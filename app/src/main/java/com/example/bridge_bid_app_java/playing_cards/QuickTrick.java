package com.example.bridge_bid_app_java.playing_cards;

public enum QuickTrick {

    ACE_KING(2.0),
    ACE_QUEEN(1.5),
    ACE(1),
    KING_QUEEN(1),
    KING(.5);

    private double value;

    QuickTrick(double value) {
        this.value = value;
    }

    public double getValue() {
        return value;
    }
}
