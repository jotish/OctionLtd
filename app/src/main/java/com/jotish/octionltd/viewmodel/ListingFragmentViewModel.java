package com.jotish.octionltd.viewmodel;


import android.content.Context;
import android.support.annotation.NonNull;
import com.jotish.octionltd.R;
import java.util.Observable;

/**
 * Created by jotishsuthar on 15/06/17.
 */

public class ListingFragmentViewModel extends Observable {

  private Context mContext;
  public String mCurrentItemsLabel;
  public String mUpcomingItemsLabel;

  public ListingFragmentViewModel(@NonNull Context context) {
    mContext = context;
    mCurrentItemsLabel = context.getString(R.string.current);
    mUpcomingItemsLabel = context.getString(R.string.upcoming);
  }

  public String getCurrentItemsLabel() {
    return mCurrentItemsLabel;
  }

  public String getUpcomingItemsLabel() {
    return mUpcomingItemsLabel;
  }
}
