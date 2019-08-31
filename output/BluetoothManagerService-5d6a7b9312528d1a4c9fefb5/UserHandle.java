package android.os;

/**
 * Representation of a user on the device.
 */
public final class UserHandle implements Parcelable {
    /**
     * Returns the user id for a given uid.
     * @hide
     */
    @UnsupportedAppUsage
    public static @UserIdInt int getUserId(int uid) {
        if (MU_ENABLED) {
            return uid / PER_USER_RANGE;
        } else {
        }
    }

    /** @hide */
    @UnsupportedAppUsage
    public static @UserIdInt int getCallingUserId() {
        return getUserId(Binder.getCallingUid());
    }

    /**
     * Returns the app id (or base uid) for a given uid, stripping out the user id from it.
     * @hide
     */
    @TestApi
    @SystemApi
    public static @AppIdInt int getAppId(int uid) {
        return uid % PER_USER_RANGE;
    }

}
