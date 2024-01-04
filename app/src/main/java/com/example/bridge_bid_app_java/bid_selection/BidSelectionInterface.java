package com.example.bridge_bid_app_java.bid_selection;

public interface BidSelectionInterface {
    void updateSuggestedBidText(String bidName);

    void updateCurrentPlayerText(String name);

    void updateBidGridView(boolean update);
}
