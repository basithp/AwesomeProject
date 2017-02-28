package com.awesomeproject.Activity;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.awesomeproject.APIHelper.FeedProvider;
import com.awesomeproject.BuildConfig;
import com.awesomeproject.Model.FeedItem;
import com.awesomeproject.R;
import com.awesomeproject.ReactModule.MyReactPackage;
import com.facebook.react.ReactInstanceManager;
import com.facebook.react.ReactRootView;
import com.facebook.react.common.LifecycleState;
import com.facebook.react.shell.MainReactPackage;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.annotations.SerializedName;
import com.microsoft.codepush.react.CodePush;

import java.util.List;

public class HomeActivity extends AppCompatActivity implements FeedProvider.APIFeedFetcherCallback, SwipeRefreshLayout.OnRefreshListener{

    private ReactRootView mReactRootView;
    private ReactInstanceManager mReactInstanceManager;
    private LinearLayout placeHolder;
    SwipeRefreshLayout swipeRefreshLayout;
    int cnt=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        placeHolder = (LinearLayout) findViewById(R.id.react_placeholder);
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
        placeHolder.removeAllViews();
        mReactRootView = new ReactRootView(this);
        mReactInstanceManager = ReactInstanceManager.builder()
                //.addPackage(new CodePush("GMtpZquafkm0_x0Ro3YRDrNg5UQrEJ8QkBAdG", HomeActivity.this, BuildConfig.DEBUG))
                .addPackage(new CodePush("nkwSKFNlShRO54HGd4hGGd2zESoCEJ8QkBAdG", HomeActivity.this, BuildConfig.DEBUG))
                .setApplication(getApplication())
                .setBundleAssetName("index.android.bundle")
                .setJSMainModuleName("index.android")
                .addPackage(new MainReactPackage())
                .addPackage(new MyReactPackage(HomeActivity.this))
                .setUseDeveloperSupport(BuildConfig.DEBUG)
                .setInitialLifecycleState(LifecycleState.RESUMED)
                .build();

        initialProps.putString("feeds",myCustomArray.toString());
        mReactRootView.unmountReactApplication();
        mReactRootView.startReactApplication(mReactInstanceManager, "AwesomeProject", initialProps);
        placeHolder.addView(mReactRootView);

    }

    @Override
    public void onRefresh() {
        FeedProvider.getFeedFromServer(HomeActivity.this);
        //swipeRefreshLayout.setRefreshing(false);

    }

    public void showToast(String title)
    {
        Toast.makeText(this,title,Toast.LENGTH_SHORT).show();
    }
}
