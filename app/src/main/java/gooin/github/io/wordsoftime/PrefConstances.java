package gooin.github.io.wordsoftime;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build;
import android.preference.PreferenceManager;

/**
 * Created by gooin on 2016/6/23.
 */
public class PrefConstances {
    public static int getAppPrefInt(Context context, String prefName) {
        int result = -1;
        if (context != null) {
            SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
            if (sharedPreferences != null) {
                result = sharedPreferences.getInt(prefName, -1);
            }

        }
        return result;
    }


    public static void putAppPrefInt(Context context, String prefName, int value) {

        if (context != null) {
            SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
            Editor edit = sharedPreferences.edit();
            edit.putInt(prefName, value);
            if (Build.VERSION.SDK_INT >= 9) {
                edit.apply();
            } else {
                edit.commit();
            }
        }
    }
}