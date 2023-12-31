package com.example.bridge_bid_app_java.game;

import com.example.bridge_bid_app_java.playing_cards.Hand;
import com.example.bridge_bid_app_java.playing_cards.Suit;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Game {

    private final List<BidSelection> bidSelectionHistory = new ArrayList<>();
    private final List<Suit> unbidSuits = new ArrayList<>(Arrays.asList(Suit.CLUBS, Suit.DIAMONDS, Suit.HEARTS, Suit.SPADES));
    private Player dealer;
    private Hand hand;
    private List<Player> openers = new ArrayList<>();
    private Player currentPlayer;

    public Game() {

    }

    public void addBidToHistory(BidSelection bidSelection) {
        bidSelectionHistory.add(bidSelection);
    }

    public void addAllToBidHistory(List<BidSelection> bidSelections) {
        bidSelectionHistory.addAll(bidSelections);
    }

    public void updateCurrentPlayer() {
        switch (currentPlayer) {
            case USER -> { this.currentPlayer = Player.LEFT_OPPONENT; }
            case LEFT_OPPONENT -> { this.currentPlayer = Player.PARTNER; }
            case PARTNER -> { this.currentPlayer = Player.RIGHT_OPPONENT; }
            case RIGHT_OPPONENT -> {this.currentPlayer = Player.USER; }
        }
    }

    public void updateUnbidSuitsBid(Suit suit) {
        unbidSuits.remove(suit);
    }

    public void updateBidSuitsForAll(List<Suit> suits) {
        unbidSuits.removeAll(suits);
    }

    public BidSelection getLastBid() {
        if (bidSelectionHistory.size() < 1) {
            return null;
        }
        return bidSelectionHistory.get(bidSelectionHistory.size() - 1);
    }

    public int getBidHistoryLength() {
        return bidSelectionHistory.size();
    }

    public void setDealer(Player dealer) {
        this.dealer = dealer;
        setCurrentPlayer(dealer);
    }

    public void setHand(Hand hand) {
        this.hand = hand;
    }

    public Hand getHand() { return hand; }

    public Player getDealer() {
        return dealer;
    }

    public List<Suit> getUnbidSuits() {
        return unbidSuits;
    }

    public List<Player> getOpeners() {
        return openers;
    }

    public void addOpener(Player player) {
        openers.add(player);
    }
    public void setOpeners(List<Player> openers) {
        this.openers = openers;
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public void setCurrentPlayer(Player currentPlayer) {
        this.currentPlayer = currentPlayer;
    }
    public void resetBidHistory() {
        bidSelectionHistory.clear();
    }

    public static Game fromJson(String json) {
        return new Gson().fromJson(json, Game.class);
    }

    @Override
    public String toString() {
        return "Game{" +
                "bidSelectionHistory=" + bidSelectionHistory +
                ", unbidSuits=" + unbidSuits +
                ", dealer=" + dealer +
                ", hand=" + hand +
                ", openers=" + openers +
                ", currentPlayer=" + currentPlayer +
                '}';
    }
}
