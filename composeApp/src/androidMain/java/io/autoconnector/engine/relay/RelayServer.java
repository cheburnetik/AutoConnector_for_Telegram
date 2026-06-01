package io.autoconnector.engine.relay;

import io.autoconnector.engine.core.AppExecutors;
import io.autoconnector.engine.db.ProxyStore;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.RejectedExecutionException;

/**
 * One loopback SOCKS5 listener. Telegram connects here (configured as a SOCKS5
 * proxy on {@code 127.0.0.1}); each accepted connection is handed to a
 * {@link RelayConnection} that bridges it to a rated upstream proxy.
 */
public final class RelayServer {

    /** Receives short status lines for the foreground notification / UI. */
    public interface Listener {
        void event(String line);
    }

    private final int port;
    private final ProxyStore store;
    private final RelayManager manager;
    private final Listener listener;

    private ServerSocket serverSocket;
    private Thread acceptThread;
    private volatile boolean running;

    public RelayServer(int port, ProxyStore store, RelayManager manager, Listener listener) {
        this.port = port;
        this.store = store;
        this.manager = manager;
        this.listener = listener;
    }

    /** Binds {@code 127.0.0.1:port} and starts accepting Telegram connections. */
    public void start() throws IOException {
        serverSocket = new ServerSocket();
        serverSocket.setReuseAddress(true);
        serverSocket.bind(new InetSocketAddress("127.0.0.1", port));
        running = true;

        acceptThread = new Thread(() -> {
            while (running) {
                try {
                    Socket client = serverSocket.accept();
                    try {
                        AppExecutors.RELAY.submit(
                                new RelayConnection(client, port, store, manager, listener));
                    } catch (RejectedExecutionException rex) {
                        // Pool saturated — drop this connection rather than
                        // grow threads unbounded; Telegram will retry on its
                        // own port-failover and we surface the load to the UI.
                        try { client.close(); } catch (IOException ignored) {}
                        listener.event("relay pool overloaded — dropped accept on " + port);
                    }
                } catch (IOException e) {
                    if (running) listener.event("accept[" + port + "]: " + e.getMessage());
                }
            }
        }, "relay-accept-" + port);
        acceptThread.start();
    }

    public void stop() {
        running = false;
        try {
            if (serverSocket != null) serverSocket.close();
        } catch (IOException ignored) {
        }
        // Don't shut down AppExecutors.RELAY — it's shared across the
        // process lifetime; in-flight pipes will close themselves when
        // RelayManager.stop() yanks the upstream sockets.
    }
}
