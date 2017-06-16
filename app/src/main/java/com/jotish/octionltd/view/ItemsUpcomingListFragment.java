package com.jotish.octionltd.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.jotish.octionltd.databinding.FragmentItemUpcomingListBinding;
import com.jotish.octionltd.viewmodel.ItemListUpcomingViewModel;
import java.util.Observable;
import java.util.Observer;

/**
 * Created by jotishsuthar on 16/06/17.
 */

public class ItemsUpcomingListFragment extends Fragment  implements Observer{

  private ItemListUpcomingViewModel mItemListViewModel;
  private FragmentItemUpcomingListBinding mFragmentItemListBinding;
  private FragmentActivity mContext;

  public static ItemsUpcomingListFragment newInstance() {
    Bundle args = new Bundle();
    ItemsUpcomingListFragment fragment = new ItemsUpcomingListFragment();
    fragment.setArguments(args);
    return fragment;
  }

  @Override
  public void onCreate(@Nullable final Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    mContext = getActivity();
  }

  @Nullable
  @Override
  public View onCreateView(final LayoutInflater inflater, @Nullable final ViewGroup container,
      @Nullable final Bundle savedInstanceState) {
    mFragmentItemListBinding = FragmentItemUpcomingListBinding.inflate(inflater,
        container,false);
    mItemListViewModel = new ItemListUpcomingViewModel(mContext);
    mFragmentItemListBinding.setItemListViewModel(mItemListViewModel);
    setupAuctionItemsView(mFragmentItemListBinding.itemsRecyler);
    setupObserver(mItemListViewModel);
    mItemListViewModel.init();
    return mFragmentItemListBinding.getRoot();
  }

  public void setupObserver(Observable observable) {
    observable.addObserver(this);
  }

  @Override
  public void onDestroy() {
    super.onDestroy();
    mItemListViewModel.reset();
  }
  private void setupAuctionItemsView(RecyclerView listRecyler) {
    AuctionUpcomingAdapter adapter = new AuctionUpcomingAdapter();
    LinearLayoutManager layoutManager = new LinearLayoutManager(mContext);
    listRecyler.setLayoutManager(layoutManager);
    listRecyler.setAdapter(adapter);
    DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(listRecyler.getContext(),
        layoutManager.getOrientation());
    listRecyler.addItemDecoration(dividerItemDecoration);
  }
  @Override
  public void update(Observable observable, Object data) {
    if (observable instanceof ItemListUpcomingViewModel) {
      AuctionUpcomingAdapter auctionAdapter = (AuctionUpcomingAdapter)
          mFragmentItemListBinding.itemsRecyler.getAdapter();
      ItemListUpcomingViewModel itemListViewModel = (ItemListUpcomingViewModel) observable;
      auctionAdapter.setAuctionItems(itemListViewModel.getAuctionItems());
    }
  }
}
