package com.example.bridge_bid_app_java.game;

import java.util.List;

public enum Player {
    USER(List.of(), false, false),
    LEFT_OPPONENT(List.of(), false, false),
    PARTNER(List.of(), false, false),
    RIGHT_OPPONENT(List.of(), false, false);

    boolean strong2Bid;

    Player(List<BidSelection> bidSelectionHistory, boolean opened, boolean strong2Bid) {

    }

    public void setPlayerStrong2Bid(boolean isStrong2) {
        strong2Bid = isStrong2;
    }

    public boolean getPlayerStrong2Bid() {
        return strong2Bid;
    }
}
