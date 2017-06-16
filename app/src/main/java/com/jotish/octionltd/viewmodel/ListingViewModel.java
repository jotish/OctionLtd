package com.jotish.octionltd.viewmodel;

import android.content.Context;
import android.support.annotation.NonNull;
import java.util.Observable;

/**
 * Created by jotishsuthar on 15/06/17.
 */

public class ListingViewModel extends Observable {
  private Context mContext;

  public ListingViewModel(@NonNull Context context) {
    mContext = context;
  }
}
