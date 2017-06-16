package com.jotish.octionltd.viewmodel;

import android.content.Context;
import android.databinding.BaseObservable;
import android.databinding.BindingAdapter;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.bumptech.glide.Glide;
import com.jotish.octionltd.R;
import com.jotish.octionltd.data.Auction;
import com.jotish.octionltd.data.AuctionItemFactory;
import com.jotish.octionltd.data.AuctionItemResponse;
import com.jotish.octionltd.utils.DateUtils;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

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

  public String getTimeRemaining() {
    if (timeRemaining == null) {
      int startTime = Integer.valueOf(mAuctionItem.getAuction().getStart_time_unix());
      int endTime = Integer.valueOf(mAuctionItem.getAuction().getEnd_time_unix());
      timeRemaining = endTime - startTime + "s";
    }
    return this.timeRemaining;
  }

  public String getTimeToStart() {
    if (timeRemaining == null) {
      String startTime = mAuctionItem.getAuction().getStart_time();
      String format = "yyyy-MM-dd HH:mm:ss";
      SimpleDateFormat formater = new SimpleDateFormat(format);
      try{
        Date startDate = formater.parse(startTime);
        Date currentDate = new Date();
        timeRemaining = DateUtils.getFormattedDifferenceInDates(currentDate, startDate);
      } catch(ParseException e){
        timeRemaining = null;
      }
    }
    return  mContext.getString(R.string.starts_in, timeRemaining);
  }


  public int getProgressTimeRemaining() {
    Random rand = new Random();
    return rand.nextInt(100) + 1;
  }

  public String getItemName() {
    return mAuctionItem.getAuction().getTitle();
  }

  public String getRetailPrice() {
    Auction auctionItem = mAuctionItem.getAuction();
    return mContext.getString(R.string.retail_rice,auctionItem.getCurrency(),
        auctionItem.getProductPrice());
  }

  public String getAuctionPrice() {
    Auction auctionItem = mAuctionItem.getAuction();
    return mContext.getString(R.string.currency_format, auctionItem.getCurrency(),
        auctionItem.getPrice());
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
