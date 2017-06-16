package com.jotish.octionltd.data;

import java.util.ArrayList;

/**
 * Created by jotishsuthar on 15/06/17.
 */

public class AuctionItemResponse {
   private Auction auction;
   private ArrayList<Media> media;
   private boolean isUpComing;

   public Auction getAuction() {
      return auction;
   }

   public ArrayList<Media> getMedia() {
      return media;
   }

   public boolean isUpComing() {
      return isUpComing;
   }
}
