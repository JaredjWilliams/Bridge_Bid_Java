package com.example.bridge_bid_app_java.bid_selection;

import com.example.bridge_bid_app_java.bids.BidGenerator;
import com.example.bridge_bid_app_java.game.BidSelection;
import com.example.bridge_bid_app_java.game.Game;
import com.example.bridge_bid_app_java.game.Player;

public class BidSelectionPresenter {

    private BidGenerator generator;
    private BidSelectionInterface view;
    private Game game;

    public BidSelectionPresenter(BidSelectionInterface view) {
        this.view = view;
    }

    public void getSuggestedBid() {
        generator.updateRecommendedBid(game);
        view.updateSuggestedBidText(generator.getRecommendedBid().getName());
    }

    public void createBidGenerator() {
        generator = new BidGenerator(game);
    }

    public void onBidClicked(BidSelection bidSelection) {
        updateGame(bidSelection);

        bidSelection.isEnabled(bidSelection);

        updateView();

        getSuggestedBidIfCurrentPlayerIsUser();
    }

    private void updateGame(BidSelection bidSelection) {

        if (isCurrentPlayerOpening(bidSelection)) {
            game.getCurrentPlayer().setOpened(true);
        }

        game.addBidToHistory(bidSelection);
        game.getCurrentPlayer().addToBidHistory(bidSelection);
        game.updateCurrentPlayer();
    }

    private boolean isCurrentPlayerOpening(BidSelection bidSelection) {
        return isBidHistoryLessThan(5) && bidSelection != BidSelection.PASS;
    }

    private void updateView() {
        view.updateBidGridView(true);
        view.updateCurrentPlayerText(currentPlayerName());
    }

    private void getSuggestedBidIfCurrentPlayerIsUser() {
        if (game.getCurrentPlayer() == Player.USER) {
            getSuggestedBid();
        }
    }



    public String currentPlayerName() {
        return game.getCurrentPlayer().name();
    }

    private boolean isBidHistoryLessThan(int value) {
        return game.getBidHistoryLength() < value;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }
}
