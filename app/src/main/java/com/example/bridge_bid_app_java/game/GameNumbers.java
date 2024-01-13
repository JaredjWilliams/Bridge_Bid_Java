package com.example.bridge_bid_app_java.game;

public enum GameNumbers {

    GAME_IN_NO_TRUMP(26),
    GAME_IN_A_MAJOR(26),
    GAME_IN_A_MINOR(29),
    GAME_FOR_SMALL_SLAM(33),
    GAME_FOR_GRAND_SLAM(37);

    private int value;

    GameNumbers(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
