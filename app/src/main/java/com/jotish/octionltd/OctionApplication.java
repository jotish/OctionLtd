package com.jotish.octionltd;

import android.app.Application;
import android.content.Context;
import com.jotish.octionltd.data.AuctionItemFactory;
import com.jotish.octionltd.data.AuctionItemRepo;
import io.reactivex.Scheduler;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by jotishsuthar on 16/06/17.
 */

public class OctionApplication  extends Application{

  private AuctionItemRepo mAuctionItemRepo;
  private Scheduler mScheduler;

  private static OctionApplication get(Context context) {
    return (OctionApplication) context.getApplicationContext();
  }

  public static OctionApplication create(Context context) {
    return OctionApplication.get(context);
  }

  public AuctionItemRepo getAuctionItemRepo() {
    if (mAuctionItemRepo == null) {
      mAuctionItemRepo = AuctionItemFactory.create();
    }
    return mAuctionItemRepo;
  }

  public Scheduler subscribeScheduler() {
    if (mScheduler == null) {
      mScheduler = Schedulers.io();
    }

    return mScheduler;
  }
}
