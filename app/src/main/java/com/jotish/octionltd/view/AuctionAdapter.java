package com.jotish.octionltd.view;


import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.jotish.octionltd.R;
import com.jotish.octionltd.data.AuctionItemResponse;
import com.jotish.octionltd.databinding.ItemCurrentBinding;
import java.util.Collections;
import java.util.List;

/**
 * Created by jotishsuthar on 16/06/17.
 */

public class AuctionAdapter extends RecyclerView.Adapter<AuctionItemViewHolder> {

  private List<AuctionItemResponse> mAuctionItems;

  public AuctionAdapter() {
    this.mAuctionItems = Collections.emptyList();
  }

  @Override public AuctionItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    ItemCurrentBinding itemCurrentBinding =
        DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.item_current,
            parent, false);
    return new AuctionItemViewHolder(itemCurrentBinding);
  }

  @Override public void onBindViewHolder(AuctionItemViewHolder holder, int position) {
    holder.bindItem(mAuctionItems.get(position));
    holder.mItemCurrentBinding.executePendingBindings();
  }

  @Override public int getItemCount() {
    return mAuctionItems.size();
  }

  public void setAuctionItems(List<AuctionItemResponse> auctionItems) {
    this.mAuctionItems = auctionItems;
    notifyDataSetChanged();
  }
}

