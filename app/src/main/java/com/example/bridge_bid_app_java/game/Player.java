package com.example.bridge_bid_app_java.game;

import java.util.ArrayList;
import java.util.List;

public enum Player {
    USER(new ArrayList<>(), false, false),
    LEFT_OPPONENT(new ArrayList<>(), false, false),
    PARTNER(new ArrayList<>(), false, false),
    RIGHT_OPPONENT(new ArrayList<>(), false, false);

    boolean strong2Bid;
    List<BidSelection> bidHistory;
    boolean opened;

    Player(List<BidSelection> bidHistory, boolean opened, boolean strong2Bid) {
        this.bidHistory = bidHistory;
        this.opened = opened;
    }

    public void addToBidHistory(BidSelection bidSelection) {
        bidHistory.add(bidSelection);
    }

    public void setPlayerStrong2Bid(boolean isStrong2) {
        strong2Bid = isStrong2;
    }

    public boolean getPlayerStrong2Bid() {
        return strong2Bid;
    }

    public List<BidSelection> getBidHistory() { return bidHistory; }

    public BidSelection getLastBid() { return bidHistory.get(bidHistory.size() - 1); }

    public void setOpened(boolean opened) {
        this.opened = opened;
    }
}
