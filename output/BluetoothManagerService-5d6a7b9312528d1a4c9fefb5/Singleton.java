package android.util;

/**
 * Singleton helper class for lazily initialization.
 *
 * Modeled after frameworks/base/include/utils/Singleton.h
 *
 * @hide
 */
public abstract class Singleton<T> {
    @UnsupportedAppUsage
    public final T get() {
        synchronized (this) {
            return mInstance;
        }
    }
}
