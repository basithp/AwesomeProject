package com.awesomeproject.ReactModule;

import android.app.Activity;
import android.widget.Toast;

import com.awesomeproject.Activity.HomeActivity;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by mbasith on 15/02/17.
 */

public class ToastAndroid extends ReactContextBaseJavaModule {

    private static final String DURATION_SHORT_KEY = "SHORT";
    private static final String DURATION_LONG_KEY = "LONG";
    Activity activity;
    public ToastAndroid(ReactApplicationContext reactContext) {
        super(reactContext);
    }

    public ToastAndroid(ReactApplicationContext reactContext, Activity activity) {
        super(reactContext);
        this.activity = activity;
    }

    @Override
    public String getName() {
        return "ToastAndroid";
    }

    @Override
    public Map<String, Object> getConstants() {
        final Map<String, Object> constants = new HashMap<>();
        constants.put(DURATION_SHORT_KEY, Toast.LENGTH_SHORT);
        constants.put(DURATION_LONG_KEY, Toast.LENGTH_LONG);
        return constants;
    }

    @ReactMethod
    public void show(String message, int duration) {
        Toast.makeText(getReactApplicationContext(), message, duration).show();
    }

    @ReactMethod
    public void showInParent(String message, int duration){
        HomeActivity homeActivity = (HomeActivity) activity;
        if (homeActivity!=null){
            homeActivity.showToast(message);
        }

    }

    @Override
    public boolean canOverrideExistingModule() {
        return true;
    }
}
