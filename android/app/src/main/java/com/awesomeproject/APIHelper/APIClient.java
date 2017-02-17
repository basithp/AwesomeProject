package com.awesomeproject.APIHelper;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by mbasith on 09/02/17.
 */

public class APIClient {

    public static final String BASE_URL = "https://s3-ap-southeast-1.amazonaws.com/sun-store/";
    private static Retrofit retrofit;

    public static Retrofit getAPIClient(){

        if(retrofit==null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }

        return retrofit;
    }
}
