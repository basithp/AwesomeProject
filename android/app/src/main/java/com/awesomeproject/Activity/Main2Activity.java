package com.awesomeproject.Activity;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.LinearLayout;

import com.awesomeproject.APIHelper.FeedProvider;
import com.awesomeproject.BuildConfig;
import com.awesomeproject.Model.FeedItem;
import com.awesomeproject.R;
import com.awesomeproject.ReactModule.MyReactPackage;
import com.facebook.react.ReactInstanceManager;
import com.facebook.react.ReactRootView;
import com.facebook.react.common.LifecycleState;
import com.facebook.react.cxxbridge.CatalystInstanceImpl;
import com.facebook.react.cxxbridge.JSBundleLoader;
import com.facebook.react.shell.MainReactPackage;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;


public class Main2Activity extends AppCompatActivity implements FeedProvider.APIFeedFetcherCallback, SwipeRefreshLayout.OnRefreshListener {

    private ReactRootView mReactRootView;
    private ReactInstanceManager mReactInstanceManager;
    private LinearLayout placeHolder;
    SwipeRefreshLayout swipeRefreshLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        placeHolder = (LinearLayout) findViewById(R.id.reacr_placeholder);
        //swipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.swipeRefresh);
        //swipeRefreshLayout.setOnRefreshListener(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        FeedProvider.getFeedFromServer(this);
    }

    @Override
    public void OnFeedFetched(List<FeedItem> feedItemList) {

        Gson gson = new GsonBuilder().create();
        JsonArray myCustomArray = gson.toJsonTree(feedItemList).getAsJsonArray();
        Bundle initialProps = new Bundle();

        mReactRootView = new ReactRootView(this);
        mReactInstanceManager = ReactInstanceManager.builder()
                .setApplication(getApplication())
                .setBundleAssetName("index.android.bundle")
                .setJSMainModuleName("index.android")
                .addPackage(new MainReactPackage())
                .setUseDeveloperSupport(BuildConfig.DEBUG)
                .setInitialLifecycleState(LifecycleState.RESUMED)
                .build();

        initialProps.putString("feeds",myCustomArray.toString());

        placeHolder.removeView(mReactRootView);
        mReactRootView.startReactApplication(mReactInstanceManager, "AwesomeProject", initialProps);
        placeHolder.addView(mReactRootView);

    }

    @Override
    public void onRefresh() {
        FeedProvider.getFeedFromServer(this);
        //swipeRefreshLayout.setRefreshing(false);

    }
}
