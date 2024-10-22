/*
 * Copyright 2008 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package android.bluetooth;

import android.bluetooth.BluetoothCodecConfig;
import android.bluetooth.BluetoothCodecStatus;
import android.bluetooth.BluetoothDevice;

/**
 * APIs for Bluetooth A2DP service
 *
 * @hide
 */
interface IBluetoothA2dp {
    // Public API
    @UnsupportedAppUsage
    boolean connect(in BluetoothDevice device);
    @UnsupportedAppUsage
    boolean disconnect(in BluetoothDevice device);
    @UnsupportedAppUsage
    List<BluetoothDevice> getConnectedDevices();
    @UnsupportedAppUsage
    List<BluetoothDevice> getDevicesMatchingConnectionStates(in int[] states);
    @UnsupportedAppUsage
    int getConnectionState(in BluetoothDevice device);
    boolean setActiveDevice(in BluetoothDevice device);
    BluetoothDevice getActiveDevice();
    boolean setPriority(in BluetoothDevice device, int priority);
    @UnsupportedAppUsage
    int getPriority(in BluetoothDevice device);
    boolean isAvrcpAbsoluteVolumeSupported();
    oneway void setAvrcpAbsoluteVolume(int volume);
    boolean isA2dpPlaying(in BluetoothDevice device);
    BluetoothCodecStatus getCodecStatus(in BluetoothDevice device);
    oneway void setCodecConfigPreference(in BluetoothDevice device,
                in BluetoothCodecConfig codecConfig);
    oneway void enableOptionalCodecs(in BluetoothDevice device);
    oneway void disableOptionalCodecs(in BluetoothDevice device);
    int supportsOptionalCodecs(in BluetoothDevice device);
    int getOptionalCodecsEnabled(in BluetoothDevice device);
    oneway void setOptionalCodecsEnabled(in BluetoothDevice device, int value);
}
