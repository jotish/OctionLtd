package com.jotish.octionltd.data;

import io.reactivex.Observable;
import java.util.ArrayList;
import retrofit2.http.GET;
/**
 * Created by jotishsuthar on 15/06/17.
 */

public interface AuctionItemRepo {

  @GET("auctions")
  Observable<ArrayList<AuctionItemResponse>> fetchAuctionItems();
}
