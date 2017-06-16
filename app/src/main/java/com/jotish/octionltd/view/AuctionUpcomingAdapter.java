package com.jotish.octionltd.view;


import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.jotish.octionltd.R;
import com.jotish.octionltd.data.AuctionItemResponse;
import com.jotish.octionltd.databinding.ItemUpcomingBinding;
import java.util.Collections;
import java.util.List;

/**
 * Created by jotishsuthar on 16/06/17.
 */

public class AuctionUpcomingAdapter extends RecyclerView.Adapter<AuctionItemUpcomingViewHolder> {

  private List<AuctionItemResponse> mAuctionItems;

  public AuctionUpcomingAdapter() {
    this.mAuctionItems = Collections.emptyList();
  }

  @Override public AuctionItemUpcomingViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    ItemUpcomingBinding itemUpcomingBinding =
        DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.item_upcoming,
            parent, false);
    return new AuctionItemUpcomingViewHolder(itemUpcomingBinding);
  }

  @Override public void onBindViewHolder(AuctionItemUpcomingViewHolder holder, int position) {
    holder.bindItem(mAuctionItems.get(position));
  }

  @Override public int getItemCount() {
    return mAuctionItems.size();
  }

  public void setAuctionItems(List<AuctionItemResponse> auctionItems) {
    this.mAuctionItems = auctionItems;
    notifyDataSetChanged();
  }
}

