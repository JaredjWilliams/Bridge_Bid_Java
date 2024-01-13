package com.example.bridge_bid_app_java.bid_selection;

import com.example.bridge_bid_app_java.bids.BidGenerator;
import com.example.bridge_bid_app_java.game.BidSelection;
import com.example.bridge_bid_app_java.game.Game;
import com.example.bridge_bid_app_java.game.Player;

public class BidSelectionPresenter {

    private final BidSelectionInterface view;
    private Game game;
    private BidGenerator generator;

    public BidSelectionPresenter(BidSelectionInterface view) {
        this.view = view;
        generator = new BidGenerator(game);
    }

    public void getSuggestedBid() {
        generator.updateRecommendedBid(game);
        view.updateSuggestedBidText(generator.getRecommendedBid().getNameOfBid());
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
        addBidSelectionToGameBidHistory(bidSelection);
        addBidSelectionToCurrentPlayerBidHistory(bidSelection);
        setCurrentPlayerOpenBasedOn(game);
        updateCurrentPlayerOf(game);
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

    private void updateCurrentPlayerOf(Game game) {
        game.updateCurrentPlayer();
    }

    private void setCurrentPlayerOpenBasedOn(Game game) {
        game.getCurrentPlayer().setOpened(game);
    }

    private void addBidSelectionToGameBidHistory(BidSelection bidSelection) {
        game.addBidToHistory(bidSelection);
    }

    private void addBidSelectionToCurrentPlayerBidHistory(BidSelection bidSelection) {
        game.getCurrentPlayer().addToBidHistory(bidSelection);
    }

    public String currentPlayerName() {
        return game.getCurrentPlayer().name();
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }
}
