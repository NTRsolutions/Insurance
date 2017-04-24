package com.insurance.bluescheme.insure;

import com.insurance.bluescheme.insure.utils.Prefs;

/**
 * Created by tonmoybarua on 19-Mar-17.
 */

public class Application extends android.app.Application {
    private Prefs prefs;
    private static Application app;
    @Override
    public void onCreate() {
        super.onCreate();
        app = this;
        prefs = new Prefs(this);

    }
    public static Application getApp() {
        return app;
    }
    public Prefs getPrefs() {
        return prefs;
    }
    public void setPrefs(Prefs prefs) {
        this.prefs = prefs;
    }
}
