package com.example.bridge_bid_app_java.game;

import com.example.bridge_bid_app_java.playing_cards.Hand;
import com.example.bridge_bid_app_java.playing_cards.Suit;
import com.google.gson.Gson;

import java.util.Arrays;
import java.util.List;

public class Game {

    private final List<BidSelection> bidSelectionHistory = List.of();
    private List<Suit> suitsBid = Arrays.asList();
    private Player dealer;
    private Hand hand;
    private Player opener;

    public Game() {

    }

    public void updateSuitsBid(Suit suit) {
        if (!suitsBid.contains(suit)) {
            suitsBid.add(suit);
        }
    }


    public void setDealer(Player dealer) {
        this.dealer = dealer;
    }

    public void setHand(Hand hand) {
        this.hand = hand;
    }

    public Hand getHand() { return hand; }

    public void addBid(BidSelection bidSelection) {
        bidSelectionHistory.add(bidSelection);
    }

    public Player getDealer() {
        return dealer;
    }

    public static Game fromJson(String json) {
        return new Gson().fromJson(json, Game.class);
    }

    public Player getOpener() {
        return opener;
    }

    public void setOpener(Player opener) {
        this.opener = opener;
    }
}
