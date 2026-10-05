package me.souravbadami.mycleanindiaapp;
import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

public class PrefManager {

    private static final String TAG = "PrefManager";

    SharedPreferences pref;
    SharedPreferences.Editor editor;
    Context _context;

    // shared pref mode
    int PRIVATE_MODE = 0;

    // Shared preferences file name
    private static final String PREF_NAME = "mycleanindia-welcome";

    private static final String IS_FIRST_TIME_LAUNCH = "IsFirstTimeLaunch";

    public PrefManager(Context context) {
        this._context = context;
        pref = _context.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
        editor = pref.edit();
        Log.d(TAG, "PrefManager initialized with preferences file: " + PREF_NAME);
    }

    public void setFirstTimeLaunch(boolean isFirstTime) {
        Log.d(TAG, "setFirstTimeLaunch: setting " + IS_FIRST_TIME_LAUNCH + " to " + isFirstTime);
        editor.putBoolean(IS_FIRST_TIME_LAUNCH, isFirstTime);
        boolean success = editor.commit();
        if (success) {
            Log.d(TAG, "setFirstTimeLaunch: value committed successfully");
        } else {
            Log.w(TAG, "setFirstTimeLaunch: failed to commit value");
        }
    }

    public boolean isFirstTimeLaunch() {
        boolean isFirstTime = pref.getBoolean(IS_FIRST_TIME_LAUNCH, true);
        Log.d(TAG, "isFirstTimeLaunch: " + isFirstTime);
        return isFirstTime;
    }

}