package com.awesomeproject.Activity;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.awesomeproject.APIHelper.FeedProvider;
import com.awesomeproject.Model.FeedItem;
import com.facebook.react.ReactActivity;
import com.facebook.react.ReactActivityDelegate;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableMapKeySetIterator;
import com.facebook.react.bridge.ReadableType;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

public class MainActivity extends ReactActivity implements FeedProvider.APIFeedFetcherCallback {

    /**
     * Returns the name of the main component registered from JavaScript.
     * This is used to schedule rendering of the component.
     */
    @Override
    protected String getMainComponentName() {
        return "AwesomeProject";
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected ReactActivityDelegate createReactActivityDelegate() {
        return new ReactActivityDelegate(this, getMainComponentName()) {
            @Nullable
            @Override
            protected Bundle getLaunchOptions() {

                //FeedProvider.getFeedFromServer(MainActivity.this);
                Bundle initialProps = new Bundle();
                JSONObject jsonObject = new JSONObject();
                try {
                    jsonObject.put("type","Hero");
                    jsonObject.put("slug", "Exclusive");
                    jsonObject.put("image","https://encrypted-tbn3.gstatic.com/images?q=tbn:ANd9GcSFdA5GAN95DJ3TlMWowdi5duQRk5pZeXvgQSGHhlS39MHIE7t6vg");
                    jsonObject.put("title","West Ham to offer Slaven Bilic a new contract");

                    JSONArray jsonArray = new JSONArray();
                    jsonArray.put(jsonObject);
                    initialProps.putString("feeds",jsonArray.toString());
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                return initialProps;
            }
        };
    }

    @Override
    public void OnFeedFetched(List<FeedItem> feedItemList) {

    }
}
