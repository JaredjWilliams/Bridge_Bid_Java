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

    public int getBidHistoryLength() {
        return bidHistory.size();
    }

    public void setPlayerStrong2Bid(boolean isStrong2) {
        strong2Bid = isStrong2;
    }

    public boolean getPlayerStrong2Bid() {
        return strong2Bid;
    }

    public List<BidSelection> getBidHistory() { return bidHistory; }

    public BidSelection getLastBid() { return bidHistory.get(bidHistory.size() - 1); }

    public boolean getOpened() {
        return opened;
    }

    public void setOpened(Game game) {

        if (isGameBidHistoryGreaterThan(4, game)) {
            System.out.println("Game bid history is greater than 4");
            return;
        }
        if (hasTeammateOfCurrentPlayerOpened(game)) {
            return;
        }
        if (isCurrentPlayerBidPass(game)) {
            return;
        }

        this.opened = true;

        addToOpenersOf(game);
    }

    public void setOpened(boolean opened) {
        this.opened = opened;
    }

    private Player getTeammateOfCurrentPlayer(Game game) {
        return switch (game.getCurrentPlayer()) {
            case USER -> PARTNER;
            case PARTNER -> USER;
            case RIGHT_OPPONENT -> LEFT_OPPONENT;
            case LEFT_OPPONENT -> RIGHT_OPPONENT;
        };
    }

    private boolean isGameBidHistoryGreaterThan(int value, Game game) {
        return game.getBidHistoryLength() > value;
    }

    private boolean hasTeammateOfCurrentPlayerOpened(Game game) {
        return getTeammateOfCurrentPlayer(game).getOpened();
    }

    private boolean isCurrentPlayerBidPass(Game game) {
        return game.getCurrentPlayer().getLastBid() == BidSelection.PASS;
    }

    private void addToOpenersOf(Game game) {
        game.addOpener(game.getCurrentPlayer());
    }
}
