package com.jotish.octionltd.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.jotish.octionltd.databinding.FragmentItemListBinding;
import com.jotish.octionltd.viewmodel.ItemListViewModel;

/**
 * Created by jotishsuthar on 16/06/17.
 */

public class ItemsListFragment extends Fragment {

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
    return mFragmentItemListBinding.getRoot();
  }
}
