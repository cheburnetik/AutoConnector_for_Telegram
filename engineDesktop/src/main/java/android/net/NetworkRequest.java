package android.net;

/** Desktop shim for {@code android.net.NetworkRequest} + its Builder. */
public final class NetworkRequest {
    public static final class Builder {
        public Builder removeCapability(int capability) { return this; }
        public Builder addCapability(int capability) { return this; }
        public NetworkRequest build() { return new NetworkRequest(); }
    }
}
