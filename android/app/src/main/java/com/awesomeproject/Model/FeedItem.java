package com.awesomeproject.Model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by mbasith on 09/02/17.
 */

public class FeedItem {

    @SerializedName("type")
    String type;

    @SerializedName("slug")
    String slug;

    @SerializedName("image")
    String imageURL;

    @SerializedName("title")
    String title;

    @SerializedName("summary")
    String summary;

    @Override
    public String toString() {
        return String.format("{\n" +
                "type : %s\n" +
                "slug : %s\n" +
                "image : %s\n" +
                "title : %s\n" +
                "summary : %s\n" +
                "},\n",this.type,this.slug,this.imageURL,this.title,this.summary);
    }
}
