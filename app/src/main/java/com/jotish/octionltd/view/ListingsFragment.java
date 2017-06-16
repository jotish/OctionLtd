package com.jotish.octionltd.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.jotish.octionltd.databinding.FragmentListingsBinding;
import com.jotish.octionltd.viewmodel.ListingFragmentViewModel;

/**
 * Created by jotishsuthar on 15/06/17.
 */

public class ListingsFragment extends Fragment{

  private FragmentListingsBinding mFragmentListingsBinding;
  private ListingFragmentViewModel mListingFragmentViewModel;
  private FragmentActivity mContext;
  private final int NUMBER_OF_TABS = 2;

  public static ListingsFragment newInstance() {
    Bundle args = new Bundle();
    ListingsFragment fragment = new ListingsFragment();
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
    mFragmentListingsBinding =  FragmentListingsBinding.inflate(inflater, container, false);
    mListingFragmentViewModel = new ListingFragmentViewModel(mContext);
    mFragmentListingsBinding.setListingFragmentViewModel(mListingFragmentViewModel);
    setupTabLayout(mFragmentListingsBinding.tabLayout, mFragmentListingsBinding.pager);
    setupViewPager(mFragmentListingsBinding.pager);
    return mFragmentListingsBinding.getRoot();
  }

  private void setupTabLayout(TabLayout tabLayout, ViewPager pager) {
    tabLayout.setupWithViewPager(pager);
    tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
    tabLayout.setTabMode(TabLayout.MODE_FIXED);
  }

  private void setupViewPager(ViewPager pager) {
    pager.setOffscreenPageLimit(NUMBER_OF_TABS);
    FragmentViewPagerAdapter adapter = new FragmentViewPagerAdapter(
        mContext.getSupportFragmentManager());
    adapter.addFragment(ItemsListFragment.newInstance(),
        mListingFragmentViewModel.getCurrentItemsLabel());
    adapter.addFragment(ItemsUpcomingListFragment.newInstance(),
        mListingFragmentViewModel.getUpcomingItemsLabel());
    pager.setAdapter(adapter);
  }
}
