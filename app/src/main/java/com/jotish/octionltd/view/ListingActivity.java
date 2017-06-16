package com.jotish.octionltd.view;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import com.jotish.octionltd.R;
import com.jotish.octionltd.databinding.ActivityListingBinding;
import com.jotish.octionltd.viewmodel.ListingViewModel;

public class ListingActivity extends AppCompatActivity {

  private ActivityListingBinding mActivityListingBinding;
  private ListingViewModel mListingViewModel;
  private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
      = new BottomNavigationView.OnNavigationItemSelectedListener() {

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
      switch (item.getItemId()) {
        case R.id.navigation_home:
          loadListingFragment();
          return true;
        case R.id.navigation_dashboard:
          return true;
        case R.id.navigation_notifications:
          return true;
      }
      return false;
    }

  };

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    initDataBinding();
    setSupportActionBar(mActivityListingBinding.toolbar);
    getSupportActionBar().setDisplayShowTitleEnabled(false);
    BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
    navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    navigation.setSelectedItemId(R.id.navigation_home);
  }

  private void initDataBinding() {
    mActivityListingBinding = DataBindingUtil.setContentView(this, R.layout
        .activity_listing);
    mListingViewModel = new ListingViewModel(this);
    mActivityListingBinding.setListingViewModel(mListingViewModel);
  }

  private void loadListingFragment() {
    Fragment currentFragment = getSupportFragmentManager().findFragmentById(R.id.content_fragment);
    if (currentFragment == null || !(currentFragment instanceof  ListingsFragment)) {
      ListingsFragment listingsFragment = ListingsFragment.newInstance();
      FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
      transaction.replace(R.id.content_fragment, listingsFragment, listingsFragment.getTag());
      transaction.commit();
    }
  }
}
