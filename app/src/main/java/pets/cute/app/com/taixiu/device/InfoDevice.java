package pets.cute.app.com.taixiu.device;

import android.provider.Settings;

import pets.cute.app.com.taixiu.main.MainApp;

/**
 * Created by Forev on 7/2/2016.
 */
public class InfoDevice {
    String device_id;
    String device_name;

    public String getDeviceId() {
        return device_id;
    }

    public String getDeviceName() {
        return device_name;
    }

    static  InfoDevice instance;

    public static InfoDevice getInstance() {
        if (instance == null)
            instance = new InfoDevice();
        return instance;
    }

    private InfoDevice() {
        device_id = Settings.Secure.getString(MainApp.getInstance().getContentResolver(),
                Settings.Secure.ANDROID_ID);
        device_name = android.os.Build.MODEL;
    }
}
