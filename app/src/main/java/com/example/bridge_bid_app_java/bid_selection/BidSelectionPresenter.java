package com.example.bridge_bid_app_java.bid_selection;

import com.example.bridge_bid_app_java.game.Game;

public class BidSelectionPresenter {

    private BidSelectionInterface view;
    private Game game;

    public BidSelectionPresenter(BidSelectionInterface view) {
        this.view = view;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }
}
