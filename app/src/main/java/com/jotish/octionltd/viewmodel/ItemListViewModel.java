package com.jotish.octionltd.viewmodel;


import android.content.Context;
import android.databinding.ObservableInt;
import android.support.annotation.NonNull;
import android.view.View;
import com.jotish.octionltd.OctionApplication;
import com.jotish.octionltd.data.AuctionItemRepo;
import com.jotish.octionltd.data.AuctionItemResponse;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

/**
 * Created by jotishsuthar on 15/06/17.
 */

public class ItemListViewModel extends Observable {

  private Context mContext;
  public ObservableInt listProgress;
  public ObservableInt itemRecycler;
  private CompositeDisposable compositeDisposable = new CompositeDisposable();
  private List<AuctionItemResponse> mAuctionItems;

  public ItemListViewModel(@NonNull Context context) {
    mContext = context;
    mAuctionItems = new ArrayList<>();
    listProgress = new ObservableInt(View.GONE);
    itemRecycler = new ObservableInt(View.GONE);
    compositeDisposable = new CompositeDisposable();
  }

  public void init() {
    initializeViews();
    getItemList();
  }

  public void initializeViews() {
    itemRecycler.set(View.GONE);
    listProgress.set(View.VISIBLE);
  }

  public void showList() {
    listProgress.set(View.GONE);
    itemRecycler.set(View.VISIBLE);
  }

  public void showFailureState() {
    listProgress.set(View.GONE);
    itemRecycler.set(View.GONE);
  }

  private void getItemList() {

    OctionApplication octionApplication = OctionApplication.create(mContext);
    AuctionItemRepo itemService = octionApplication.getAuctionItemRepo();

    Disposable disposable = itemService.fetchAuctionItems()
        .subscribeOn(octionApplication.subscribeScheduler())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(new Consumer<ArrayList<AuctionItemResponse>>() {
          @Override public void accept(ArrayList<AuctionItemResponse> itemResponse) throws Exception {
            changeItemListSet(itemResponse);
            showList();
          }
        }, new Consumer<Throwable>() {
          @Override public void accept(Throwable throwable) throws Exception {
            showFailureState();
          }
        });
    compositeDisposable.add(disposable);
  }

  private void changeItemListSet(ArrayList<AuctionItemResponse> items) {
    mAuctionItems.addAll(items);
    setChanged();
    notifyObservers();
  }
  public void reset() {
    unSubscribeFromObservable();
    compositeDisposable = null;
    mContext = null;
  }
  private void unSubscribeFromObservable() {
    if (compositeDisposable != null && !compositeDisposable.isDisposed()) {
      compositeDisposable.dispose();
    }
  }

  public List<AuctionItemResponse> getAuctionItems() {
    return mAuctionItems;
  }
}
