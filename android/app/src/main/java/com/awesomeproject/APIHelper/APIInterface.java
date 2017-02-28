package com.awesomeproject.APIHelper;

import java.util.List;

import com.awesomeproject.Model.FeedItem;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by mbasith on 09/02/17.
 */

public interface APIInterface {

    @GET("feeds-android.json")
    Call<List<FeedItem>>  getFeeds();
}
