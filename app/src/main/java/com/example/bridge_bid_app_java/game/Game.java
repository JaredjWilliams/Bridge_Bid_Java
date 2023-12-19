package com.example.bridge_bid_app_java.game;

import com.example.bridge_bid_app_java.playing_cards.Hand;
import com.example.bridge_bid_app_java.playing_cards.Suit;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Game {

    private final List<BidSelection> bidSelectionHistory = List.of();
    private final List<Suit> unbidSuits = new ArrayList<>(Arrays.asList(Suit.CLUBS, Suit.DIAMONDS, Suit.HEARTS, Suit.SPADES));
    private Player dealer;
    private Hand hand;
    private Player opener;

    public Game() {

    }

    public void updateUnbidSuitsBid(Suit suit) {
        unbidSuits.remove(suit);
    }

    public void updateUnbidSuitsBidsForAll(List<Suit> suits) {
        unbidSuits.removeAll(suits);
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

    public List<Suit> getUnbidSuits() {
        return unbidSuits;
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
