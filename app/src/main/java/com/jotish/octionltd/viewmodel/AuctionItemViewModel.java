package com.jotish.octionltd.viewmodel;

import android.content.Context;
import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.databinding.BindingAdapter;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.CountDownTimer;
import android.support.v4.content.ContextCompat;
import android.widget.ImageView;
import com.bumptech.glide.Glide;
import com.jotish.octionltd.BR;
import com.jotish.octionltd.data.AuctionItemFactory;
import com.jotish.octionltd.data.AuctionItemResponse;

/**
 * Created by jotishsuthar on 16/06/17.
 */

public class AuctionItemViewModel extends BaseObservable{

  private Context mContext;
  private AuctionItemResponse mAuctionItem;
  private String timeRemaining;

  public AuctionItemViewModel(Context context, AuctionItemResponse auctionItem) {
    mContext = context;
    mAuctionItem = auctionItem;
  }

  public String getMediaImageUrl() {
    if (mAuctionItem.getMedia() != null && mAuctionItem.getMedia().size() > 0) {
      return AuctionItemFactory.getBaseUrl() + mAuctionItem.getMedia().get(0).getMedia();
    }
    return null;
  }
  @Bindable
  public String getTimeRemaining() {
    if (timeRemaining == null) {
      int startTime = Integer.valueOf(mAuctionItem.getAuction().getStart_time_unix());
      int endTime = Integer.valueOf(mAuctionItem.getAuction().getEnd_time_unix());
      timeRemaining = endTime - startTime + "s";
    }
    return this.timeRemaining;
  }

  public String getItemName() {
    return mAuctionItem.getAuction().getTitle();
  }

  public String getRetailPrice() {
    return mAuctionItem.getAuction().getProductPrice();
  }

  public String getAuctionPrice() {
    return mAuctionItem.getAuction().getStartingPrice();
  }

  @BindingAdapter({"bind:imageUrl","bind:placeHolderDrawable", "bind:errorDrawable" })
  public static void setImageUrl(ImageView imageView, String url, Drawable placeHolder, Drawable
      errorDrawable) {
    Glide.with(imageView.getContext())
        .load(url)
        .placeholder(placeHolder)
        .fitCenter()
        .fallback(placeHolder)
        .error(errorDrawable)
        .into(imageView);
  }

  public void setAuctionItem(AuctionItemResponse auctionItem) {
    this.mAuctionItem = auctionItem;
    notifyChange();
  }
}
