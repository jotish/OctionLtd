package com.jotish.octionltd.data;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by jotishsuthar on 15/06/17.
 */

public class AuctionItemFactory {

  private final static String BASE_API_URL = "https://dev-us-02.oction.co/api/v1/";
  private final static String BASE_URL = "https://dev-us-02.oction.co";

  public static AuctionItemRepo create() {
    Retrofit retrofit = new Retrofit.Builder().baseUrl(BASE_API_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .build();
    return retrofit.create(AuctionItemRepo.class);
  }

  public static String getBaseUrl() {
    return BASE_URL;
  }

}
