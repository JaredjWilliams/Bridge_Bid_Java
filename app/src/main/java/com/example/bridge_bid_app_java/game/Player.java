package com.example.bridge_bid_app_java.game;

import java.util.List;

public enum Player {
    USER(List.of(), false),
    LEFT_OPPONENT(List.of(), false),
    PARTNER(List.of(), false),
    RIGHT_OPPONENT(List.of(), false);

    Player(List<BidSelection> bidSelectionHistory, boolean opened) {

    }
}
