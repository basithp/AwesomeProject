package com.awesomeproject.APIHelper;

import android.util.Log;

import com.awesomeproject.Model.FeedItem;

import java.io.Console;
import java.util.ArrayList;
import java.util.List;


import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by mbasith on 09/02/17.
 */

public class FeedProvider {

    public static void getFeedFromServer(final APIFeedFetcherCallback listener){

        APIInterface apiInterface = APIClient.getAPIClient().create(APIInterface.class);
        Call<List<FeedItem>> feedItemsCall = apiInterface.getFeeds();
        feedItemsCall.enqueue(new Callback<List<FeedItem>>() {
            @Override
            public void onResponse(Call<List<FeedItem>> call, Response<List<FeedItem>> response) {
                List<FeedItem> feedItemList = response.body();
                listener.OnFeedFetched(feedItemList);
            }

            @Override
            public void onFailure(Call<List<FeedItem>> call, Throwable t) {
                Log.e("ERROR","ERROR");
            }
        });
    }


    public interface APIFeedFetcherCallback{
        public void OnFeedFetched(List<FeedItem> feedItemList);
    }
}
