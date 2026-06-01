package android.os;

/**
 * Desktop shim for {@code android.os.Build}. The engine only reads
 * {@code VERSION.SDK_INT} to branch between the modern and legacy network APIs;
 * we report a current API level so it always takes the modern path.
 */
public final class Build {
    private Build() {}

    public static final class VERSION {
        private VERSION() {}
        /** Pretend to be a current Android so the engine takes the modern paths. */
        public static final int SDK_INT = 34;
    }

    public static final class VERSION_CODES {
        private VERSION_CODES() {}
        public static final int M = 23;
        public static final int N = 24;
        public static final int O = 26;
    }
}
