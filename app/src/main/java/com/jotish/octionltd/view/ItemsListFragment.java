package com.jotish.octionltd.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.jotish.octionltd.databinding.FragmentItemListBinding;
import com.jotish.octionltd.viewmodel.AuctionItemViewModel;
import com.jotish.octionltd.viewmodel.ItemListViewModel;
import java.util.Observable;
import java.util.Observer;

/**
 * Created by jotishsuthar on 16/06/17.
 */

public class ItemsListFragment extends Fragment  implements Observer{

  private ItemListViewModel mItemListViewModel;
  private FragmentItemListBinding mFragmentItemListBinding;
  private FragmentActivity mContext;

  public static ItemsListFragment newInstance() {
    Bundle args = new Bundle();
    ItemsListFragment fragment = new ItemsListFragment();
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
    mFragmentItemListBinding = FragmentItemListBinding.inflate(inflater,
        container,false);
    mItemListViewModel = new ItemListViewModel(mContext);
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
    AuctionAdapter adapter = new AuctionAdapter();
    listRecyler.setLayoutManager(new LinearLayoutManager(mContext));
    listRecyler.setAdapter(adapter);
  }
  @Override
  public void update(Observable observable, Object data) {
    if (observable instanceof ItemListViewModel) {
      AuctionAdapter auctionAdapter = (AuctionAdapter)
          mFragmentItemListBinding.itemsRecyler.getAdapter();
      ItemListViewModel itemListViewModel = (ItemListViewModel) observable;
      auctionAdapter.setAuctionItems(itemListViewModel.getAuctionItems());
    }
  }
}
