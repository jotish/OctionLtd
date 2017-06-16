package com.jotish.octionltd.view;

import android.support.v7.widget.RecyclerView;
import com.jotish.octionltd.data.AuctionItemResponse;
import com.jotish.octionltd.databinding.ItemUpcomingBinding;
import com.jotish.octionltd.viewmodel.AuctionItemViewModel;

/**
 * Created by jotishsuthar on 16/06/17.
 */

public class AuctionItemUpcomingViewHolder extends RecyclerView.ViewHolder{
  ItemUpcomingBinding mItemUpcomingBinding;

  public AuctionItemUpcomingViewHolder(ItemUpcomingBinding itemUpcomingBinding) {
    super(itemUpcomingBinding.itemView);
    this.mItemUpcomingBinding = itemUpcomingBinding;
  }

  public void bindItem(AuctionItemResponse auctionItem) {
    if (mItemUpcomingBinding.getAuctionItemViewModel() == null) {
      mItemUpcomingBinding.setAuctionItemViewModel(
          new AuctionItemViewModel(itemView.getContext(),auctionItem));
    } else {
      mItemUpcomingBinding.getAuctionItemViewModel().setAuctionItem(auctionItem);
    }
  }

}
