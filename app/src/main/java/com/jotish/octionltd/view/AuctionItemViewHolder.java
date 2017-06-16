package com.jotish.octionltd.view;

import android.support.v7.widget.RecyclerView;
import com.jotish.octionltd.data.AuctionItemResponse;
import com.jotish.octionltd.databinding.ItemCurrentBinding;
import com.jotish.octionltd.viewmodel.AuctionItemViewModel;

/**
 * Created by jotishsuthar on 16/06/17.
 */

public class AuctionItemViewHolder  extends RecyclerView.ViewHolder{
  ItemCurrentBinding mItemCurrentBinding;

  public AuctionItemViewHolder(ItemCurrentBinding itemCurrentBinding) {
    super(itemCurrentBinding.itemView);
    this.mItemCurrentBinding = itemCurrentBinding;
  }

  public void bindItem(AuctionItemResponse auctionItem) {
    if (mItemCurrentBinding.getAuctionItemViewModel() == null) {
      mItemCurrentBinding.setAuctionItemViewModel(
          new AuctionItemViewModel(itemView.getContext(),auctionItem));
    } else {
      mItemCurrentBinding.getAuctionItemViewModel().setAuctionItem(auctionItem);
    }
  }

}
