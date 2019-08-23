Quelle: [Manifest.permission](https://developer.android.com/reference/android/Manifest.permission)

### ACCEPT_HANDOVER

Added in API level 28

public static final String ACCEPT_HANDOVER

Allows a calling app to continue a call which was started in another app. An example is a video calling app that wants to continue a voice call on the user's mobile network.

When the handover of a call from one app to another takes place, there are two devices which are involved in the handover; the initiating and receiving devices. The initiating device is where the request to handover the call was started, and the receiving device is where the handover request is confirmed by the other party.

This permission protects access to the TelecomManager.acceptHandover(Uri, int, PhoneAccountHandle) which the receiving side of the handover uses to accept a handover.

Protection level: dangerous

Constant Value: "android.permission.ACCEPT_HANDOVER"

### ACCESS_BACKGROUND_LOCATION

Added in API level 29

public static final String ACCESS_BACKGROUND_LOCATION

Allows an app to access location in the background. If you're requesting this permission, you must also request either ACCESS_COARSE_LOCATION or ACCESS_FINE_LOCATION. Requesting this permission by itself doesn't give you location access.

Protection level: dangerous

This is a hard restricted permission which cannot be held by an app until the installer on record did not whitelist the permission. For more details see PackageInstaller.SessionParams.setWhitelistedRestrictedPermissions(Set).

Constant Value: "android.permission.ACCESS_BACKGROUND_LOCATION"

### ACCESS_CHECKIN_PROPERTIES

Added in API level 1

public static final String ACCESS_CHECKIN_PROPERTIES

Allows read/write access to the "properties" table in the checkin database, to change values that get uploaded.

Not for use by third-party applications.

Constant Value: "android.permission.ACCESS_CHECKIN_PROPERTIES"

### ACCESS_COARSE_LOCATION

Added in API level 1

public static final String ACCESS_COARSE_LOCATION

Allows an app to access approximate location. Alternatively, you might want ACCESS_FINE_LOCATION.

Protection level: dangerous

Constant Value: "android.permission.ACCESS_COARSE_LOCATION"

### ACCESS_FINE_LOCATION

Added in API level 1

public static final String ACCESS_FINE_LOCATION

Allows an app to access precise location. Alternatively, you might want ACCESS_COARSE_LOCATION.

Protection level: dangerous

Constant Value: "android.permission.ACCESS_FINE_LOCATION"

### ACCESS_LOCATION_EXTRA_COMMANDS

Added in API level 1

public static final String ACCESS_LOCATION_EXTRA_COMMANDS

Allows an application to access extra location provider commands.

Protection level: normal

Constant Value: "android.permission.ACCESS_LOCATION_EXTRA_COMMANDS"

### ACCESS_MEDIA_LOCATION

Added in API level 29

public static final String ACCESS_MEDIA_LOCATION

Allows an application to access any geographic locations persisted in the user's shared collection.

Constant Value: "android.permission.ACCESS_MEDIA_LOCATION"

### ACCESS_NETWORK_STATE

Added in API level 1

public static final String ACCESS_NETWORK_STATE

Allows applications to access information about networks.

Protection level: normal

Constant Value: "android.permission.ACCESS_NETWORK_STATE"

### ACCESS_NOTIFICATION_POLICY

Added in API level 23

public static final String ACCESS_NOTIFICATION_POLICY

Marker permission for applications that wish to access notification policy. This permission is not supported on managed profiles.

Protection level: normal

Constant Value: "android.permission.ACCESS_NOTIFICATION_POLICY"

### ACCESS_WIFI_STATE

Added in API level 1

public static final String ACCESS_WIFI_STATE

Allows applications to access information about Wi-Fi networks.

Protection level: normal

Constant Value: "android.permission.ACCESS_WIFI_STATE"

### ACCOUNT_MANAGER

Added in API level 5

public static final String ACCOUNT_MANAGER

Allows applications to call into AccountAuthenticators.

Not for use by third-party applications.

Constant Value: "android.permission.ACCOUNT_MANAGER"

### ACTIVITY_RECOGNITION

Added in API level 29

public static final String ACTIVITY_RECOGNITION

Allows an application to recognize physical activity.

Protection level: dangerous

Constant Value: "android.permission.ACTIVITY_RECOGNITION"

### ADD_VOICEMAIL

Added in API level 14

public static final String ADD_VOICEMAIL

Allows an application to add voicemails into the system.

Protection level: dangerous

Constant Value: "com.android.voicemail.permission.ADD_VOICEMAIL"

### ANSWER_PHONE_CALLS

Added in API level 26

public static final String ANSWER_PHONE_CALLS

Allows the app to answer an incoming phone call.

Protection level: dangerous

Constant Value: "android.permission.ANSWER_PHONE_CALLS"

### BATTERY_STATS

Added in API level 1

public static final String BATTERY_STATS

Allows an application to collect battery statistics

Constant Value: "android.permission.BATTERY_STATS"

### BIND_ACCESSIBILITY_SERVICE

Added in API level 16

public static final String BIND_ACCESSIBILITY_SERVICE

Must be required by an AccessibilityService, to ensure that only the system can bind to it.

Protection level: signature

Constant Value: "android.permission.BIND_ACCESSIBILITY_SERVICE"

### BIND_APPWIDGET

Added in API level 3

public static final String BIND_APPWIDGET

Allows an application to tell the AppWidget service which application can access AppWidget's data. The normal user flow is that a user picks an AppWidget to go into a particular host, thereby giving that host application access to the private data from the AppWidget app. An application that has this permission should honor that contract.

Not for use by third-party applications.

Constant Value: "android.permission.BIND_APPWIDGET"

### BIND_AUTOFILL_SERVICE

Added in API level 26

public static final String BIND_AUTOFILL_SERVICE

Must be required by a AutofillService, to ensure that only the system can bind to it.

Protection level: signature

Constant Value: "android.permission.BIND_AUTOFILL_SERVICE"

### BIND_CALL_REDIRECTION_SERVICE

Added in API level 29

public static final String BIND_CALL_REDIRECTION_SERVICE

Must be required by a CallRedirectionService, to ensure that only the system can bind to it.

Protection level: signature|privileged

Constant Value: "android.permission.BIND_CALL_REDIRECTION_SERVICE"

### BIND_CARRIER_MESSAGING_CLIENT_SERVICE

Added in API level 29

public static final String BIND_CARRIER_MESSAGING_CLIENT_SERVICE

A subclass of CarrierMessagingClientService must be protected with this permission.

Constant Value: "android.permission.BIND_CARRIER_MESSAGING_CLIENT_SERVICE"

### BIND_CARRIER_MESSAGING_SERVICE

Added in API level 22
Deprecated in API level 23

public static final String BIND_CARRIER_MESSAGING_SERVICE

This constant was deprecated in API level 23.
Use BIND_CARRIER_SERVICES instead

Constant Value: "android.permission.BIND_CARRIER_MESSAGING_SERVICE"

### BIND_CARRIER_SERVICES

Added in API level 23

public static final String BIND_CARRIER_SERVICES

The system process that is allowed to bind to services in carrier apps will have this permission. Carrier apps should use this permission to protect their services that only the system is allowed to bind to.

Protection level: signature|privileged

Constant Value: "android.permission.BIND_CARRIER_SERVICES"

### BIND_CHOOSER_TARGET_SERVICE

Added in API level 23

public static final String BIND_CHOOSER_TARGET_SERVICE

Must be required by a ChooserTargetService, to ensure that only the system can bind to it.

Protection level: signature

Constant Value: "android.permission.BIND_CHOOSER_TARGET_SERVICE"

### BIND_CONDITION_PROVIDER_SERVICE

Added in API level 24

public static final String BIND_CONDITION_PROVIDER_SERVICE

Must be required by a ConditionProviderService, to ensure that only the system can bind to it.

Protection level: signature

Constant Value: "android.permission.BIND_CONDITION_PROVIDER_SERVICE"

### BIND_DEVICE_ADMIN

Added in API level 8

public static final String BIND_DEVICE_ADMIN

Must be required by device administration receiver, to ensure that only the system can interact with it.

Protection level: signature

Constant Value: "android.permission.BIND_DEVICE_ADMIN"

### BIND_DREAM_SERVICE

Added in API level 21

public static final String BIND_DREAM_SERVICE

Must be required by an DreamService, to ensure that only the system can bind to it.

Protection level: signature

Constant Value: "android.permission.BIND_DREAM_SERVICE"

### BIND_INCALL_SERVICE

Added in API level 23

public static final String BIND_INCALL_SERVICE

Must be required by a InCallService, to ensure that only the system can bind to it.

Protection level: signature|privileged

Constant Value: "android.permission.BIND_INCALL_SERVICE"

### BIND_INPUT_METHOD

Added in API level 3

public static final String BIND_INPUT_METHOD

Must be required by an InputMethodService, to ensure that only the system can bind to it.

Protection level: signature

Constant Value: "android.permission.BIND_INPUT_METHOD"

### BIND_MIDI_DEVICE_SERVICE

Added in API level 23

public static final String BIND_MIDI_DEVICE_SERVICE

Must be required by an MidiDeviceService, to ensure that only the system can bind to it.

Protection level: signature

Constant Value: "android.permission.BIND_MIDI_DEVICE_SERVICE"

### BIND_NFC_SERVICE

Added in API level 19

public static final String BIND_NFC_SERVICE

Must be required by a HostApduService or OffHostApduService to ensure that only the system can bind to it.

Protection level: signature

Constant Value: "android.permission.BIND_NFC_SERVICE"

### BIND_NOTIFICATION_LISTENER_SERVICE

Added in API level 18

public static final String BIND_NOTIFICATION_LISTENER_SERVICE

Must be required by an NotificationListenerService, to ensure that only the system can bind to it.

Protection level: signature

Constant Value: "android.permission.BIND_NOTIFICATION_LISTENER_SERVICE"

### BIND_PRINT_SERVICE

Added in API level 19

public static final String BIND_PRINT_SERVICE

Must be required by a PrintService, to ensure that only the system can bind to it.

Protection level: signature

Constant Value: "android.permission.BIND_PRINT_SERVICE"

### BIND_QUICK_SETTINGS_TILE

Added in API level 24

public static final String BIND_QUICK_SETTINGS_TILE

Allows an application to bind to third party quick settings tiles.

Should only be requested by the System, should be required by TileService declarations.

Constant Value: "android.permission.BIND_QUICK_SETTINGS_TILE"

### BIND_REMOTEVIEWS

Added in API level 11

public static final String BIND_REMOTEVIEWS

Must be required by a RemoteViewsService, to ensure that only the system can bind to it.

Constant Value: "android.permission.BIND_REMOTEVIEWS"

### BIND_SCREENING_SERVICE

Added in API level 24

public static final String BIND_SCREENING_SERVICE

Must be required by a CallScreeningService, to ensure that only the system can bind to it.

Protection level: signature|privileged

Constant Value: "android.permission.BIND_SCREENING_SERVICE"

### BIND_TELECOM_CONNECTION_SERVICE

Added in API level 23

public static final String BIND_TELECOM_CONNECTION_SERVICE

Must be required by a ConnectionService, to ensure that only the system can bind to it.

Protection level: signature|privileged

Constant Value: "android.permission.BIND_TELECOM_CONNECTION_SERVICE"

### BIND_TEXT_SERVICE

Added in API level 14

public static final String BIND_TEXT_SERVICE

Must be required by a TextService (e.g. SpellCheckerService) to ensure that only the system can bind to it.

Protection level: signature

Constant Value: "android.permission.BIND_TEXT_SERVICE"

### BIND_TV_INPUT

Added in API level 21

public static final String BIND_TV_INPUT

Must be required by a TvInputService to ensure that only the system can bind to it.

Protection level: signature|privileged

Constant Value: "android.permission.BIND_TV_INPUT"

### BIND_VISUAL_VOICEMAIL_SERVICE

Added in API level 26

public static final String BIND_VISUAL_VOICEMAIL_SERVICE

Must be required by a link VisualVoicemailService to ensure that only the system can bind to it.

Protection level: signature|privileged

Constant Value: "android.permission.BIND_VISUAL_VOICEMAIL_SERVICE"

### BIND_VOICE_INTERACTION

Added in API level 21

public static final String BIND_VOICE_INTERACTION

Must be required by a VoiceInteractionService, to ensure that only the system can bind to it.

Protection level: signature

Constant Value: "android.permission.BIND_VOICE_INTERACTION"

### BIND_VPN_SERVICE

Added in API level 14

public static final String BIND_VPN_SERVICE

Must be required by a VpnService, to ensure that only the system can bind to it.

Protection level: signature

Constant Value: "android.permission.BIND_VPN_SERVICE"

### BIND_VR_LISTENER_SERVICE

Added in API level 24

public static final String BIND_VR_LISTENER_SERVICE

Must be required by an VrListenerService, to ensure that only the system can bind to it.

Protection level: signature

Constant Value: "android.permission.BIND_VR_LISTENER_SERVICE"

### BIND_WALLPAPER

Added in API level 8

public static final String BIND_WALLPAPER

Must be required by a WallpaperService, to ensure that only the system can bind to it.

Protection level: signature|privileged

Constant Value: "android.permission.BIND_WALLPAPER"

### BLUETOOTH

Added in API level 1

public static final String BLUETOOTH

Allows applications to connect to paired bluetooth devices.

Protection level: normal

Constant Value: "android.permission.BLUETOOTH"

### BLUETOOTH_ADMIN

Added in API level 1

public static final String BLUETOOTH_ADMIN

Allows applications to discover and pair bluetooth devices.

Protection level: normal

Constant Value: "android.permission.BLUETOOTH_ADMIN"

### BLUETOOTH_PRIVILEGED

Added in API level 19

public static final String BLUETOOTH_PRIVILEGED

Allows applications to pair bluetooth devices without user interaction, and to allow or disallow phonebook access or message access. This is not available to third party applications.

Constant Value: "android.permission.BLUETOOTH_PRIVILEGED"

### BODY_SENSORS

Added in API level 20

public static final String BODY_SENSORS

Allows an application to access data from sensors that the user uses to measure what is happening inside his/her body, such as heart rate.

Protection level: dangerous

Constant Value: "android.permission.BODY_SENSORS"

### BROADCAST_PACKAGE_REMOVED

Added in API level 1

public static final String BROADCAST_PACKAGE_REMOVED

Allows an application to broadcast a notification that an application package has been removed.

Not for use by third-party applications.

Constant Value: "android.permission.BROADCAST_PACKAGE_REMOVED"

### BROADCAST_SMS

Added in API level 2

public static final String BROADCAST_SMS

Allows an application to broadcast an SMS receipt notification.

Not for use by third-party applications.

Constant Value: "android.permission.BROADCAST_SMS"

### BROADCAST_STICKY

Added in API level 1

public static final String BROADCAST_STICKY

Allows an application to broadcast sticky intents. These are broadcasts whose data is held by the system after being finished, so that clients can quickly retrieve that data without having to wait for the next broadcast.

Protection level: normal

Constant Value: "android.permission.BROADCAST_STICKY"

### BROADCAST_WAP_PUSH

Added in API level 2

public static final String BROADCAST_WAP_PUSH

Allows an application to broadcast a WAP PUSH receipt notification.

Not for use by third-party applications.

Constant Value: "android.permission.BROADCAST_WAP_PUSH"

### CALL_COMPANION_APP

Added in API level 29

public static final String CALL_COMPANION_APP

Allows an app which implements the InCallService API to be eligible to be enabled as a calling companion app. This means that the Telecom framework will bind to the app's InCallService implementation when there are calls active. The app can use the InCallService API to view information about calls on the system and control these calls.

Protection level: normal

Constant Value: "android.permission.CALL_COMPANION_APP"

### CALL_PHONE

Added in API level 1

public static final String CALL_PHONE

Allows an application to initiate a phone call without going through the Dialer user interface for the user to confirm the call.

Protection level: dangerous

Constant Value: "android.permission.CALL_PHONE"

### CALL_PRIVILEGED

Added in API level 1

public static final String CALL_PRIVILEGED

Allows an application to call any phone number, including emergency numbers, without going through the Dialer user interface for the user to confirm the call being placed.

Not for use by third-party applications.

Constant Value: "android.permission.CALL_PRIVILEGED"

### CAMERA

Added in API level 1

public static final String CAMERA

Required to be able to access the camera device.

This will automatically enforce the uses-feature manifest element for all camera features. If you do not require all camera features or can properly operate if a camera is not available, then you must modify your manifest as appropriate in order to install on devices that don't support all camera features.

Protection level: dangerous

Constant Value: "android.permission.CAMERA"

### CAPTURE_AUDIO_OUTPUT

Added in API level 19

public static final String CAPTURE_AUDIO_OUTPUT

Allows an application to capture audio output. Use the CAPTURE_MEDIA_OUTPUT permission if only the USAGE_UNKNOWN), USAGE_MEDIA) or USAGE_GAME) usages are intended to be captured.

Not for use by third-party applications.

Constant Value: "android.permission.CAPTURE_AUDIO_OUTPUT"

### CHANGE_COMPONENT_ENABLED_STATE

Added in API level 1

public static final String CHANGE_COMPONENT_ENABLED_STATE

Allows an application to change whether an application component (other than its own) is enabled or not.

Not for use by third-party applications.

Constant Value: "android.permission.CHANGE_COMPONENT_ENABLED_STATE"

### CHANGE_CONFIGURATION

Added in API level 1

public static final String CHANGE_CONFIGURATION

Allows an application to modify the current configuration, such as locale.

Constant Value: "android.permission.CHANGE_CONFIGURATION"

### CHANGE_NETWORK_STATE

Added in API level 1

public static final String CHANGE_NETWORK_STATE

Allows applications to change network connectivity state.

Protection level: normal

Constant Value: "android.permission.CHANGE_NETWORK_STATE"

### CHANGE_WIFI_MULTICAST_STATE

Added in API level 4

public static final String CHANGE_WIFI_MULTICAST_STATE

Allows applications to enter Wi-Fi Multicast mode.

Protection level: normal

Constant Value: "android.permission.CHANGE_WIFI_MULTICAST_STATE"

### CHANGE_WIFI_STATE

Added in API level 1

public static final String CHANGE_WIFI_STATE

Allows applications to change Wi-Fi connectivity state.

Protection level: normal

Constant Value: "android.permission.CHANGE_WIFI_STATE"

### CLEAR_APP_CACHE

Added in API level 1

public static final String CLEAR_APP_CACHE

Allows an application to clear the caches of all installed applications on the device.

Protection level: signature|privileged

Constant Value: "android.permission.CLEAR_APP_CACHE"

### CONTROL_LOCATION_UPDATES

Added in API level 1

public static final String CONTROL_LOCATION_UPDATES

Allows enabling/disabling location update notifications from the radio.

Not for use by third-party applications.

Constant Value: "android.permission.CONTROL_LOCATION_UPDATES"

### DELETE_CACHE_FILES

Added in API level 1

public static final String DELETE_CACHE_FILES

Old permission for deleting an app's cache files, no longer used, but signals for us to quietly ignore calls instead of throwing an exception.

Constant Value: "android.permission.DELETE_CACHE_FILES"

### DELETE_PACKAGES

Added in API level 1

public static final String DELETE_PACKAGES

Allows an application to delete packages.

Not for use by third-party applications.

Starting in Build.VERSION_CODES.N, user confirmation is requested when the application deleting the package is not the same application that installed the package.

Constant Value: "android.permission.DELETE_PACKAGES"

### DIAGNOSTIC

Added in API level 1

public static final String DIAGNOSTIC

Allows applications to RW to diagnostic resources.

Not for use by third-party applications.

Constant Value: "android.permission.DIAGNOSTIC"

### DISABLE_KEYGUARD

Added in API level 1

public static final String DISABLE_KEYGUARD

Allows applications to disable the keyguard if it is not secure.

Protection level: normal

Constant Value: "android.permission.DISABLE_KEYGUARD"

### DUMP

Added in API level 1

public static final String DUMP

Allows an application to retrieve state dump information from system services.

Not for use by third-party applications.

Constant Value: "android.permission.DUMP"

### EXPAND_STATUS_BAR

Added in API level 1

public static final String EXPAND_STATUS_BAR

Allows an application to expand or collapse the status bar.

Protection level: normal

Constant Value: "android.permission.EXPAND_STATUS_BAR"

### FACTORY_TEST

Added in API level 1

public static final String FACTORY_TEST

Run as a manufacturer test application, running as the root user. Only available when the device is running in manufacturer test mode.

Not for use by third-party applications.

Constant Value: "android.permission.FACTORY_TEST"

### FOREGROUND_SERVICE

Added in API level 28

public static final String FOREGROUND_SERVICE

Allows a regular application to use Service.startForeground.

Protection level: normal

Constant Value: "android.permission.FOREGROUND_SERVICE"

### GET_ACCOUNTS

Added in API level 1

public static final String GET_ACCOUNTS

Allows access to the list of accounts in the Accounts Service.

Note: Beginning with Android 6.0 (API level 23), if an app shares the signature of the authenticator that manages an account, it does not need "GET_ACCOUNTS" permission to read information about that account. On Android 5.1 and lower, all apps need "GET_ACCOUNTS" permission to read information about any account.

Protection level: dangerous

Constant Value: "android.permission.GET_ACCOUNTS"

### GET_ACCOUNTS_PRIVILEGED

Added in API level 23

public static final String GET_ACCOUNTS_PRIVILEGED

Allows access to the list of accounts in the Accounts Service.

Constant Value: "android.permission.GET_ACCOUNTS_PRIVILEGED"

### GET_PACKAGE_SIZE

Added in API level 1

public static final String GET_PACKAGE_SIZE

Allows an application to find out the space used by any package.

Protection level: normal

Constant Value: "android.permission.GET_PACKAGE_SIZE"

### GET_TASKS

Added in API level 1
Deprecated in API level 21

public static final String GET_TASKS

This constant was deprecated in API level 21.
No longer enforced.

Constant Value: "android.permission.GET_TASKS"

### GLOBAL_SEARCH

Added in API level 4

public static final String GLOBAL_SEARCH

This permission can be used on content providers to allow the global search system to access their data. Typically it used when the provider has some permissions protecting it (which global search would not be expected to hold), and added as a read-only permission to the path in the provider where global search queries are performed. This permission can not be held by regular applications; it is used by applications to protect themselves from everyone else besides global search.

Constant Value: "android.permission.GLOBAL_SEARCH"

### INSTALL_LOCATION_PROVIDER

Added in API level 4

public static final String INSTALL_LOCATION_PROVIDER

Allows an application to install a location provider into the Location Manager.

Not for use by third-party applications.

Constant Value: "android.permission.INSTALL_LOCATION_PROVIDER"

### INSTALL_PACKAGES

Added in API level 1

public static final String INSTALL_PACKAGES

Allows an application to install packages.

Not for use by third-party applications.

Constant Value: "android.permission.INSTALL_PACKAGES"

### INSTALL_SHORTCUT

Added in API level 19

public static final String INSTALL_SHORTCUT

Allows an application to install a shortcut in Launcher.

In Android O (API level 26) and higher, the INSTALL_SHORTCUT broadcast no longer has any effect on your app because it's a private, implicit broadcast. Instead, you should create an app shortcut by using the requestPinShortcut() method from the ShortcutManager class.

Protection level: normal

Constant Value: "com.android.launcher.permission.INSTALL_SHORTCUT"

### INSTANT_APP_FOREGROUND_SERVICE

Added in API level 26

public static final String INSTANT_APP_FOREGROUND_SERVICE

Allows an instant app to create foreground services.

Constant Value: "android.permission.INSTANT_APP_FOREGROUND_SERVICE"

### INTERNET

Added in API level 1

public static final String INTERNET

Allows applications to open network sockets.

Protection level: normal

Constant Value: "android.permission.INTERNET"

### KILL_BACKGROUND_PROCESSES

Added in API level 8

public static final String KILL_BACKGROUND_PROCESSES

Allows an application to call ActivityManager.killBackgroundProcesses(String).

Protection level: normal

Constant Value: "android.permission.KILL_BACKGROUND_PROCESSES"

### LOCATION_HARDWARE

Added in API level 18

public static final String LOCATION_HARDWARE

Allows an application to use location features in hardware, such as the geofencing api.

Not for use by third-party applications.

Constant Value: "android.permission.LOCATION_HARDWARE"

### MANAGE_DOCUMENTS

Added in API level 19

public static final String MANAGE_DOCUMENTS

Allows an application to manage access to documents, usually as part of a document picker.

This permission should only be requested by the platform document management app. This permission cannot be granted to third-party apps.

Constant Value: "android.permission.MANAGE_DOCUMENTS"

### MANAGE_OWN_CALLS

Added in API level 26

public static final String MANAGE_OWN_CALLS

Allows a calling application which manages it own calls through the self-managed ConnectionService APIs. See PhoneAccount.CAPABILITY_SELF_MANAGED for more information on the self-managed ConnectionService APIs.

Protection level: normal

Constant Value: "android.permission.MANAGE_OWN_CALLS"

### MASTER_CLEAR

Added in API level 1

public static final String MASTER_CLEAR

Not for use by third-party applications.

Constant Value: "android.permission.MASTER_CLEAR"

### MEDIA_CONTENT_CONTROL

Added in API level 19

public static final String MEDIA_CONTENT_CONTROL

Allows an application to know what content is playing and control its playback.

Not for use by third-party applications due to privacy of media consumption

Constant Value: "android.permission.MEDIA_CONTENT_CONTROL"

### MODIFY_AUDIO_SETTINGS

Added in API level 1

public static final String MODIFY_AUDIO_SETTINGS

Allows an application to modify global audio settings.

Protection level: normal

Constant Value: "android.permission.MODIFY_AUDIO_SETTINGS"

### MODIFY_PHONE_STATE

Added in API level 1

public static final String MODIFY_PHONE_STATE

Allows modification of the telephony state - power on, mmi, etc. Does not include placing calls.

Not for use by third-party applications.

Constant Value: "android.permission.MODIFY_PHONE_STATE"

### MOUNT_FORMAT_FILESYSTEMS

Added in API level 3

public static final String MOUNT_FORMAT_FILESYSTEMS

Allows formatting file systems for removable storage.

Not for use by third-party applications.

Constant Value: "android.permission.MOUNT_FORMAT_FILESYSTEMS"

### MOUNT_UNMOUNT_FILESYSTEMS

Added in API level 1

public static final String MOUNT_UNMOUNT_FILESYSTEMS

Allows mounting and unmounting file systems for removable storage.

Not for use by third-party applications.

Constant Value: "android.permission.MOUNT_UNMOUNT_FILESYSTEMS"

### NFC

Added in API level 9

public static final String NFC

Allows applications to perform I/O operations over NFC.

Protection level: normal

Constant Value: "android.permission.NFC"

### NFC_TRANSACTION_EVENT

Added in API level 28

public static final String NFC_TRANSACTION_EVENT

Allows applications to receive NFC transaction events.

Protection level: normal

Constant Value: "android.permission.NFC_TRANSACTION_EVENT"

### PACKAGE_USAGE_STATS

Added in API level 23

public static final String PACKAGE_USAGE_STATS

Allows an application to collect component usage statistics

Declaring the permission implies intention to use the API and the user of the device can grant permission through the Settings application.

Constant Value: "android.permission.PACKAGE_USAGE_STATS"

### PERSISTENT_ACTIVITY

Added in API level 1
Deprecated in API level 15

public static final String PERSISTENT_ACTIVITY

This constant was deprecated in API level 15.
This functionality will be removed in the future; please do not use. Allow an application to make its activities persistent.

Constant Value: "android.permission.PERSISTENT_ACTIVITY"

### PROCESS_OUTGOING_CALLS

Added in API level 1
Deprecated in API level 29

public static final String PROCESS_OUTGOING_CALLS

This constant was deprecated in API level 29.
Applications should use CallRedirectionService instead of the Intent.ACTION_NEW_OUTGOING_CALL broadcast.

Allows an application to see the number being dialed during an outgoing call with the option to redirect the call to a different number or abort the call altogether.

Protection level: dangerous

This is a hard restricted permission which cannot be held by an app until the installer on record did not whitelist the permission. For more details see PackageInstaller.SessionParams.setWhitelistedRestrictedPermissions(Set).

Constant Value: "android.permission.PROCESS_OUTGOING_CALLS"

### READ_CALENDAR

Added in API level 1

public static final String READ_CALENDAR

Allows an application to read the user's calendar data.

Protection level: dangerous

Constant Value: "android.permission.READ_CALENDAR"

### READ_CALL_LOG

Added in API level 16

public static final String READ_CALL_LOG

Allows an application to read the user's call log.

Note: If your app uses the READ_CONTACTS permission and both your minSdkVersion and targetSdkVersion values are set to 15 or lower, the system implicitly grants your app this permission. If you don't need this permission, be sure your targetSdkVersion is 16 or higher.

Protection level: dangerous

This is a hard restricted permission which cannot be held by an app until the installer on record did not whitelist the permission. For more details see PackageInstaller.SessionParams.setWhitelistedRestrictedPermissions(Set).

Constant Value: "android.permission.READ_CALL_LOG"

### READ_CONTACTS

Added in API level 1

public static final String READ_CONTACTS

Allows an application to read the user's contacts data.

Protection level: dangerous

Constant Value: "android.permission.READ_CONTACTS"

### READ_EXTERNAL_STORAGE

Added in API level 16

public static final String READ_EXTERNAL_STORAGE

Allows an application to read from external storage.

Any app that declares the WRITE_EXTERNAL_STORAGE permission is implicitly granted this permission.

This permission is enforced starting in API level 19. Before API level 19, this permission is not enforced and all apps still have access to read from external storage. You can test your app with the permission enforced by enabling Protect USB storage under Developer options in the Settings app on a device running Android 4.1 or higher.

Also starting in API level 19, this permission is not required to read/write files in your application-specific directories returned by Context.getExternalFilesDir(String) and Context.getExternalCacheDir().

Note: If both your minSdkVersion and targetSdkVersion values are set to 3 or lower, the system implicitly grants your app this permission. If you don't need this permission, be sure your targetSdkVersion is 4 or higher.

This is a soft restricted permission which cannot be held by an app it its full form until the installer on record did not whitelist the permission. Specifically, if the permission is whitelisted the holder app can access external storage and the visual and aural media collections while if the permission is not whitelisted the holder app can only access to the visual and aural medial collections. Also the permission is immutably restricted meaning that the whitelist state can be specified only at install time and cannot change until the app is installed. For more details see PackageInstaller.SessionParams.setWhitelistedRestrictedPermissions(Set).

Constant Value: "android.permission.READ_EXTERNAL_STORAGE"

### READ_INPUT_STATE

Added in API level 1
Deprecated in API level 16

public static final String READ_INPUT_STATE

This constant was deprecated in API level 16.
The API that used this permission has been removed.

Allows an application to retrieve the current state of keys and switches.

Not for use by third-party applications.

Constant Value: "android.permission.READ_INPUT_STATE"

### READ_LOGS

Added in API level 1

public static final String READ_LOGS

Allows an application to read the low-level system log files.

Not for use by third-party applications, because Log entries can contain the user's private information.

Constant Value: "android.permission.READ_LOGS"

### READ_PHONE_NUMBERS

Added in API level 26

public static final String READ_PHONE_NUMBERS

Allows read access to the device's phone number(s). This is a subset of the capabilities granted by READ_PHONE_STATE but is exposed to instant applications.

Protection level: dangerous

Constant Value: "android.permission.READ_PHONE_NUMBERS"

### READ_PHONE_STATE

Added in API level 1

public static final String READ_PHONE_STATE

Allows read only access to phone state, including the phone number of the device, current cellular network information, the status of any ongoing calls, and a list of any PhoneAccounts registered on the device.

Note: If both your minSdkVersion and targetSdkVersion values are set to 3 or lower, the system implicitly grants your app this permission. If you don't need this permission, be sure your targetSdkVersion is 4 or higher.

Protection level: dangerous

Constant Value: "android.permission.READ_PHONE_STATE"

### READ_SMS

Added in API level 1

public static final String READ_SMS

Allows an application to read SMS messages.

Protection level: dangerous

This is a hard restricted permission which cannot be held by an app until the installer on record did not whitelist the permission. For more details see PackageInstaller.SessionParams.setWhitelistedRestrictedPermissions(Set).

Constant Value: "android.permission.READ_SMS"

### READ_SYNC_SETTINGS

Added in API level 1

public static final String READ_SYNC_SETTINGS

Allows applications to read the sync settings.

Protection level: normal

Constant Value: "android.permission.READ_SYNC_SETTINGS"

### READ_SYNC_STATS

Added in API level 1

public static final String READ_SYNC_STATS

Allows applications to read the sync stats.

Protection level: normal

Constant Value: "android.permission.READ_SYNC_STATS"

### READ_VOICEMAIL

Added in API level 21

public static final String READ_VOICEMAIL

Allows an application to read voicemails in the system.

Protection level: signature|privileged

Constant Value: "com.android.voicemail.permission.READ_VOICEMAIL"

### REBOOT

Added in API level 1

public static final String REBOOT

Required to be able to reboot the device.

Not for use by third-party applications.

Constant Value: "android.permission.REBOOT"

### RECEIVE_BOOT_COMPLETED

Added in API level 1

public static final String RECEIVE_BOOT_COMPLETED

Allows an application to receive the Intent.ACTION_BOOT_COMPLETED that is broadcast after the system finishes booting. If you don't request this permission, you will not receive the broadcast at that time. Though holding this permission does not have any security implications, it can have a negative impact on the user experience by increasing the amount of time it takes the system to start and allowing applications to have themselves running without the user being aware of them. As such, you must explicitly declare your use of this facility to make that visible to the user.

Protection level: normal

Constant Value: "android.permission.RECEIVE_BOOT_COMPLETED"

### RECEIVE_MMS

Added in API level 1

public static final String RECEIVE_MMS

Allows an application to monitor incoming MMS messages.

Protection level: dangerous

This is a hard restricted permission which cannot be held by an app until the installer on record did not whitelist the permission. For more details see PackageInstaller.SessionParams.setWhitelistedRestrictedPermissions(Set).

Constant Value: "android.permission.RECEIVE_MMS"

### RECEIVE_SMS

Added in API level 1

public static final String RECEIVE_SMS

Allows an application to receive SMS messages.

Protection level: dangerous

This is a hard restricted permission which cannot be held by an app until the installer on record did not whitelist the permission. For more details see PackageInstaller.SessionParams.setWhitelistedRestrictedPermissions(Set).

Constant Value: "android.permission.RECEIVE_SMS"

### RECEIVE_WAP_PUSH

Added in API level 1

public static final String RECEIVE_WAP_PUSH

Allows an application to receive WAP push messages.

Protection level: dangerous

This is a hard restricted permission which cannot be held by an app until the installer on record did not whitelist the permission. For more details see PackageInstaller.SessionParams.setWhitelistedRestrictedPermissions(Set).

Constant Value: "android.permission.RECEIVE_WAP_PUSH"

### RECORD_AUDIO

Added in API level 1

public static final String RECORD_AUDIO

Allows an application to record audio.

Protection level: dangerous

Constant Value: "android.permission.RECORD_AUDIO"

### REORDER_TASKS

Added in API level 1

public static final String REORDER_TASKS

Allows an application to change the Z-order of tasks.

Protection level: normal

Constant Value: "android.permission.REORDER_TASKS"

### REQUEST_COMPANION_RUN_IN_BACKGROUND

Added in API level 26

public static final String REQUEST_COMPANION_RUN_IN_BACKGROUND

Allows a companion app to run in the background.

Protection level: normal

Constant Value: "android.permission.REQUEST_COMPANION_RUN_IN_BACKGROUND"

### REQUEST_COMPANION_USE_DATA_IN_BACKGROUND

Added in API level 26

public static final String REQUEST_COMPANION_USE_DATA_IN_BACKGROUND

Allows a companion app to use data in the background.

Protection level: normal

Constant Value: "android.permission.REQUEST_COMPANION_USE_DATA_IN_BACKGROUND"

### REQUEST_DELETE_PACKAGES

Added in API level 26

public static final String REQUEST_DELETE_PACKAGES

Allows an application to request deleting packages. Apps targeting APIs Build.VERSION_CODES.P or greater must hold this permission in order to use Intent.ACTION_UNINSTALL_PACKAGE or PackageInstaller.uninstall(VersionedPackage, IntentSender).

Protection level: normal

Constant Value: "android.permission.REQUEST_DELETE_PACKAGES"

### REQUEST_IGNORE_BATTERY_OPTIMIZATIONS

Added in API level 23

public static final String REQUEST_IGNORE_BATTERY_OPTIMIZATIONS

Permission an application must hold in order to use Settings.ACTION_REQUEST_IGNORE_BATTERY_OPTIMIZATIONS. This is a normal permission: an app requesting it will always be granted the permission, without the user needing to approve or see it.

Constant Value: "android.permission.REQUEST_IGNORE_BATTERY_OPTIMIZATIONS"

### REQUEST_INSTALL_PACKAGES

Added in API level 23

public static final String REQUEST_INSTALL_PACKAGES

Allows an application to request installing packages. Apps targeting APIs greater than 25 must hold this permission in order to use Intent.ACTION_INSTALL_PACKAGE.

Protection level: signature

Constant Value: "android.permission.REQUEST_INSTALL_PACKAGES"

### REQUEST_PASSWORD_COMPLEXITY

Added in API level 29

public static final String REQUEST_PASSWORD_COMPLEXITY

Allows an application to request the screen lock complexity and prompt users to update the screen lock to a certain complexity level.

Protection level: normal

Constant Value: "android.permission.REQUEST_PASSWORD_COMPLEXITY"

### RESTART_PACKAGES

Added in API level 1
Deprecated in API level 15

public static final String RESTART_PACKAGES

This constant was deprecated in API level 15.
The ActivityManager.restartPackage(String) API is no longer supported.

Constant Value: "android.permission.RESTART_PACKAGES"

### SEND_RESPOND_VIA_MESSAGE

Added in API level 18

public static final String SEND_RESPOND_VIA_MESSAGE

Allows an application (Phone) to send a request to other applications to handle the respond-via-message action during incoming calls.

Not for use by third-party applications.

Constant Value: "android.permission.SEND_RESPOND_VIA_MESSAGE"

### SEND_SMS

Added in API level 1

public static final String SEND_SMS

Allows an application to send SMS messages.

Protection level: dangerous

This is a hard restricted permission which cannot be held by an app until the installer on record did not whitelist the permission. For more details see PackageInstaller.SessionParams.setWhitelistedRestrictedPermissions(Set).

Constant Value: "android.permission.SEND_SMS"

### SET_ALARM

Added in API level 9

public static final String SET_ALARM

Allows an application to broadcast an Intent to set an alarm for the user.

Protection level: normal

Constant Value: "com.android.alarm.permission.SET_ALARM"

### SET_ALWAYS_FINISH

Added in API level 1

public static final String SET_ALWAYS_FINISH

Allows an application to control whether activities are immediately finished when put in the background.

Not for use by third-party applications.

Constant Value: "android.permission.SET_ALWAYS_FINISH"

### SET_ANIMATION_SCALE

Added in API level 1

public static final String SET_ANIMATION_SCALE

Modify the global animation scaling factor.

Not for use by third-party applications.

Constant Value: "android.permission.SET_ANIMATION_SCALE"

### SET_DEBUG_APP

Added in API level 1

public static final String SET_DEBUG_APP

Configure an application for debugging.

Not for use by third-party applications.

Constant Value: "android.permission.SET_DEBUG_APP"

### SET_PREFERRED_APPLICATIONS

Added in API level 1
Deprecated in API level 15

public static final String SET_PREFERRED_APPLICATIONS

This constant was deprecated in API level 15.
No longer useful, see PackageManager.addPackageToPreferred(String) for details.

Constant Value: "android.permission.SET_PREFERRED_APPLICATIONS"

### SET_PROCESS_LIMIT

Added in API level 1

public static final String SET_PROCESS_LIMIT

Allows an application to set the maximum number of (not needed) application processes that can be running.

Not for use by third-party applications.

Constant Value: "android.permission.SET_PROCESS_LIMIT"

### SET_TIME

Added in API level 8

public static final String SET_TIME

Allows applications to set the system time.

Not for use by third-party applications.

Constant Value: "android.permission.SET_TIME"

### SET_TIME_ZONE

Added in API level 1

public static final String SET_TIME_ZONE

Allows applications to set the system time zone.

Not for use by third-party applications.

Constant Value: "android.permission.SET_TIME_ZONE"

### SET_WALLPAPER

Added in API level 1

public static final String SET_WALLPAPER

Allows applications to set the wallpaper.

Protection level: normal

Constant Value: "android.permission.SET_WALLPAPER"

### SET_WALLPAPER_HINTS

Added in API level 1

public static final String SET_WALLPAPER_HINTS

Allows applications to set the wallpaper hints.

Protection level: normal

Constant Value: "android.permission.SET_WALLPAPER_HINTS"

### SIGNAL_PERSISTENT_PROCESSES

Added in API level 1

public static final String SIGNAL_PERSISTENT_PROCESSES

Allow an application to request that a signal be sent to all persistent processes.

Not for use by third-party applications.

Constant Value: "android.permission.SIGNAL_PERSISTENT_PROCESSES"

### SMS_FINANCIAL_TRANSACTIONS

Added in API level 29

public static final String SMS_FINANCIAL_TRANSACTIONS

Allows financial apps to read filtered sms messages.

Constant Value: "android.permission.SMS_FINANCIAL_TRANSACTIONS"

### START_VIEW_PERMISSION_USAGE

Added in API level 29

public static final String START_VIEW_PERMISSION_USAGE

Allows the holder to start the permission usage screen for an app.

Protection level: signature|installer

Constant Value: "android.permission.START_VIEW_PERMISSION_USAGE"

### STATUS_BAR

Added in API level 1

public static final String STATUS_BAR

Allows an application to open, close, or disable the status bar and its icons.

Not for use by third-party applications.

Constant Value: "android.permission.STATUS_BAR"

### SYSTEM_ALERT_WINDOW

Added in API level 1

public static final String SYSTEM_ALERT_WINDOW

Allows an app to create windows using the type WindowManager.LayoutParams.TYPE_APPLICATION_OVERLAY, shown on top of all other apps. Very few apps should use this permission; these windows are intended for system-level interaction with the user.

Note: If the app targets API level 23 or higher, the app user must explicitly grant this permission to the app through a permission management screen. The app requests the user's approval by sending an intent with action Settings.ACTION_MANAGE_OVERLAY_PERMISSION. The app can check whether it has this authorization by calling Settings.canDrawOverlays().

Protection level: signature|preinstalled|appop|pre23|development

Constant Value: "android.permission.SYSTEM_ALERT_WINDOW"

### TRANSMIT_IR

Added in API level 19

public static final String TRANSMIT_IR

Allows using the device's IR transmitter, if available.

Protection level: normal

Constant Value: "android.permission.TRANSMIT_IR"

### UNINSTALL_SHORTCUT

Added in API level 19

public static final String UNINSTALL_SHORTCUT

Don't use this permission in your app.
This permission is no longer supported.

Constant Value: "com.android.launcher.permission.UNINSTALL_SHORTCUT"

### UPDATE_DEVICE_STATS

Added in API level 3

public static final String UPDATE_DEVICE_STATS

Allows an application to update device statistics.

Not for use by third-party applications.

Constant Value: "android.permission.UPDATE_DEVICE_STATS"

### USE_BIOMETRIC

Added in API level 28

public static final String USE_BIOMETRIC

Allows an app to use device supported biometric modalities.

Protection level: normal

Constant Value: "android.permission.USE_BIOMETRIC"

### USE_FINGERPRINT

Added in API level 23
Deprecated in API level 28

public static final String USE_FINGERPRINT

This constant was deprecated in API level 28.
Applications should request USE_BIOMETRIC instead

Allows an app to use fingerprint hardware.

Protection level: normal

Constant Value: "android.permission.USE_FINGERPRINT"

### USE_FULL_SCREEN_INTENT

Added in API level 29

public static final String USE_FULL_SCREEN_INTENT

Required for apps targeting Build.VERSION_CODES.Q that want to use notification full screen intents.

Constant Value: "android.permission.USE_FULL_SCREEN_INTENT"

### USE_SIP

Added in API level 9

public static final String USE_SIP

Allows an application to use SIP service.

Protection level: dangerous

Constant Value: "android.permission.USE_SIP"

### VIBRATE

Added in API level 1

public static final String VIBRATE

Allows access to the vibrator.

Protection level: normal

Constant Value: "android.permission.VIBRATE"

### WAKE_LOCK

Added in API level 1

public static final String WAKE_LOCK

Allows using PowerManager WakeLocks to keep processor from sleeping or screen from dimming.

Protection level: normal

Constant Value: "android.permission.WAKE_LOCK"

### WRITE_APN_SETTINGS

Added in API level 1

public static final String WRITE_APN_SETTINGS

Allows applications to write the apn settings and read sensitive fields of an existing apn settings like user and password.

Not for use by third-party applications.

Constant Value: "android.permission.WRITE_APN_SETTINGS"

### WRITE_CALENDAR

Added in API level 1

public static final String WRITE_CALENDAR

Allows an application to write the user's calendar data.

Protection level: dangerous

Constant Value: "android.permission.WRITE_CALENDAR"

### WRITE_CALL_LOG

Added in API level 16

public static final String WRITE_CALL_LOG

Allows an application to write (but not read) the user's call log data.

Note: If your app uses the WRITE_CONTACTS permission and both your minSdkVersion and targetSdkVersion values are set to 15 or lower, the system implicitly grants your app this permission. If you don't need this permission, be sure your targetSdkVersion is 16 or higher.

Protection level: dangerous

This is a hard restricted permission which cannot be held by an app until the installer on record did not whitelist the permission. For more details see PackageInstaller.SessionParams.setWhitelistedRestrictedPermissions(Set).

Constant Value: "android.permission.WRITE_CALL_LOG"

### WRITE_CONTACTS

Added in API level 1

public static final String WRITE_CONTACTS

Allows an application to write the user's contacts data.

Protection level: dangerous

Constant Value: "android.permission.WRITE_CONTACTS"

### WRITE_EXTERNAL_STORAGE

Added in API level 4

public static final String WRITE_EXTERNAL_STORAGE

Allows an application to write to external storage.

Note: If both your minSdkVersion and targetSdkVersion values are set to 3 or lower, the system implicitly grants your app this permission. If you don't need this permission, be sure your targetSdkVersion is 4 or higher.

Starting in API level 19, this permission is not required to read/write files in your application-specific directories returned by Context.getExternalFilesDir(String) and Context.getExternalCacheDir().

Is this permission is not whitelisted for an app that targets an API level before Build.VERSION_CODES.Q this permission cannot be granted to apps.

Constant Value: "android.permission.WRITE_EXTERNAL_STORAGE"

### WRITE_GSERVICES

Added in API level 1

public static final String WRITE_GSERVICES

Allows an application to modify the Google service map.

Not for use by third-party applications.

Constant Value: "android.permission.WRITE_GSERVICES"

### WRITE_SECURE_SETTINGS

Added in API level 3

public static final String WRITE_SECURE_SETTINGS

Allows an application to read or write the secure system settings.

Not for use by third-party applications.

Constant Value: "android.permission.WRITE_SECURE_SETTINGS"

### WRITE_SETTINGS

Added in API level 1

public static final String WRITE_SETTINGS

Allows an application to read or write the system settings.

Note: If the app targets API level 23 or higher, the app user must explicitly grant this permission to the app through a permission management screen. The app requests the user's approval by sending an intent with action Settings.ACTION_MANAGE_WRITE_SETTINGS. The app can check whether it has this authorization by calling Settings.System.canWrite().

Protection level: signature|preinstalled|appop|pre23

Constant Value: "android.permission.WRITE_SETTINGS"

### WRITE_SYNC_SETTINGS

Added in API level 1

public static final String WRITE_SYNC_SETTINGS

Allows applications to write the sync settings.

Protection level: normal

Constant Value: "android.permission.WRITE_SYNC_SETTINGS"

### WRITE_VOICEMAIL

Added in API level 21

public static final String WRITE_VOICEMAIL

Allows an application to modify and remove existing voicemails in the system.

Protection level: signature|privileged

Constant Value: "com.android.voicemail.permission.WRITE_VOICEMAIL" 