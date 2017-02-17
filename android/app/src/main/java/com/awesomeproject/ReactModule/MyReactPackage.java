package com.awesomeproject.ReactModule;

import android.app.Activity;
import android.content.Context;

import com.awesomeproject.ReactModule.ToastAndroid;
import com.facebook.react.ReactPackage;
import com.facebook.react.bridge.JavaScriptModule;
import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.uimanager.ViewManager;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by mbasith on 15/02/17.
 */

public class MyReactPackage implements ReactPackage {

    Activity activity;
    public MyReactPackage(Activity activity) {
        this.activity = activity;
    }

    @Override
    public List<Class<? extends JavaScriptModule>> createJSModules() {
        return Collections.emptyList();
    }

    @Override
    public List<ViewManager> createViewManagers(ReactApplicationContext reactContext) {
        return Collections.emptyList();
    }

    @Override
    public List<NativeModule> createNativeModules(
            ReactApplicationContext reactContext) {
        List<NativeModule> modules = new ArrayList<>();
        modules.add(new ToastAndroid(reactContext,activity));

        return modules;
    }
}
