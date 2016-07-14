package pets.cute.app.com.taixiu.main;

import android.app.Application;

/**
 * Created by Forev on 7/2/2016.
 */
public class MainApp extends Application {
    private static MainApp instance;

    public static MainApp getInstance() {
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
    }
}
