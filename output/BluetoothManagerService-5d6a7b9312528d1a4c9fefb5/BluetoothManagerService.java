package com.android.server;

class BluetoothManagerService extends IBluetoothManager.Stub {
    public void unregisterAdapter(IBluetoothManagerCallback callback) {
        if (callback == null) {
            return;
        }

        mContext.enforceCallingOrSelfPermission(BLUETOOTH_PERM, "Need BLUETOOTH permission");
    }

    public void registerStateChangeCallback(IBluetoothStateChangeCallback callback) {
        mContext.enforceCallingOrSelfPermission(BLUETOOTH_PERM, "Need BLUETOOTH permission");
    }

    public void unregisterStateChangeCallback(IBluetoothStateChangeCallback callback) {
        mContext.enforceCallingOrSelfPermission(BLUETOOTH_PERM, "Need BLUETOOTH permission");
    }

    public boolean isEnabled() {
        if ((Binder.getCallingUid() != Process.SYSTEM_UID) && (!checkIfCallerIsForegroundUser())) {
            return false;
        }

        try {
            if (mBluetooth != null) {
                return mBluetooth.isEnabled();
            }

        }

        return false;
    }

    public boolean enableNoAutoConnect(String packageName) {
        if (isBluetoothDisallowed()) {
            return false;
        }

        mContext.enforceCallingOrSelfPermission(BLUETOOTH_ADMIN_PERM,
                "Need BLUETOOTH ADMIN permission");
        if (callingAppId != Process.NFC_UID) {
            throw new SecurityException("no permission to enable Bluetooth quietly");
        }

    }

    public boolean enable(String packageName) throws RemoteException {
        final int callingUid = Binder.getCallingUid();
        final boolean callerSystem = UserHandle.getAppId(callingUid) == Process.SYSTEM_UID;
        if (isBluetoothDisallowed()) {
            return false;
        }

        if (!callerSystem) {
            if (!checkIfCallerIsForegroundUser()) {
                return false;
            }

            mContext.enforceCallingOrSelfPermission(BLUETOOTH_ADMIN_PERM,
                    "Need BLUETOOTH ADMIN permission");
            if (!isEnabled() && mPermissionReviewRequired && startConsentUiIfNeeded(packageName,
                    callingUid, BluetoothAdapter.ACTION_REQUEST_ENABLE)) {
                return false;
            }
        }

    }

    public boolean disable(String packageName, boolean persist) throws RemoteException {
        final int callingUid = Binder.getCallingUid();
        final boolean callerSystem = UserHandle.getAppId(callingUid) == Process.SYSTEM_UID;
        if (!callerSystem) {
            if (!checkIfCallerIsForegroundUser()) {
                return false;
            }

            mContext.enforceCallingOrSelfPermission(BLUETOOTH_ADMIN_PERM,
                    "Need BLUETOOTH ADMIN permission");
            if (isEnabled() && mPermissionReviewRequired && startConsentUiIfNeeded(packageName,
                    callingUid, BluetoothAdapter.ACTION_REQUEST_DISABLE)) {
                return false;
            }
        }

    }

    private boolean startConsentUiIfNeeded(String packageName,
            int callingUid, String intentAction) throws RemoteException {
        if (checkBluetoothPermissionWhenPermissionReviewRequired()) {
            return false;
        }

        try {
            if (applicationInfo.uid != callingUid) {
                throw new SecurityException("Package " + packageName
                        + " not in uid " + callingUid);
            }

            return true;
        }
    }

    /**
     * Check if the caller must still pass permission check or if the caller is exempted
     * from the consent UI via the MANAGE_BLUETOOTH_WHEN_PERMISSION_REVIEW_REQUIRED check.
     *
     * Commands from some callers may be exempted from triggering the consent UI when
     * enabling bluetooth. This exemption is checked via the
     * MANAGE_BLUETOOTH_WHEN_PERMISSION_REVIEW_REQUIRED and allows calls to skip
     * the consent UI where it may otherwise be required.
     *
     * @hide
     */
    private boolean checkBluetoothPermissionWhenPermissionReviewRequired() {
        if (!mPermissionReviewRequired) {
            return false;
        }

        int result = mContext.checkCallingPermission(
                android.Manifest.permission.MANAGE_BLUETOOTH_WHEN_PERMISSION_REVIEW_REQUIRED);
    }

    public String getAddress() {
        mContext.enforceCallingOrSelfPermission(BLUETOOTH_PERM, "Need BLUETOOTH permission");
        if ((Binder.getCallingUid() != Process.SYSTEM_UID) && (!checkIfCallerIsForegroundUser())) {
            return null;
        }

        if (mContext.checkCallingOrSelfPermission(Manifest.permission.LOCAL_MAC_ADDRESS)
                != PackageManager.PERMISSION_GRANTED) {
            return BluetoothAdapter.DEFAULT_MAC_ADDRESS;
        }

    }

    public String getName() {
        mContext.enforceCallingOrSelfPermission(BLUETOOTH_PERM, "Need BLUETOOTH permission");
    }

    private boolean checkIfCallerIsForegroundUser() {
        int callingUser = UserHandle.getCallingUserId();
        int callingUid = Binder.getCallingUid();
        UserInfo ui = um.getProfileParent(callingUser);
        int parentUser = (ui != null) ? ui.id : UserHandle.USER_NULL;
        int callingAppId = UserHandle.getAppId(callingUid);
        try {
            foregroundUser = ActivityManager.getCurrentUser();
            valid = (callingUser == foregroundUser) || parentUser == foregroundUser
                    || callingAppId == Process.NFC_UID || callingAppId == mSystemUiUid;
        }

        return valid;
    }

    private boolean isBluetoothDisallowed() {
        try {
            return mContext.getSystemService(UserManager.class)
                    .hasUserRestriction(UserManager.DISALLOW_BLUETOOTH, UserHandle.SYSTEM);
        }
    }

}
