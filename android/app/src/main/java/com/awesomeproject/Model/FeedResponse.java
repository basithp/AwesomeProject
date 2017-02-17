package com.awesomeproject.Model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by mbasith on 09/02/17.
 */

public class FeedResponse {
    @SerializedName("feed")
    List<FeedItem> feedItems;
}
