package com.example.bridge_bid_app_java.utils;

import com.example.bridge_bid_app_java.game.BidSelection;
import com.example.bridge_bid_app_java.game.Game;
import com.example.bridge_bid_app_java.game.Player;
import com.example.bridge_bid_app_java.playing_cards.Hand;
import com.example.bridge_bid_app_java.playing_cards.Suit;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class BidHelperFunctions {

    public static Game game;

    public BidHelperFunctions(Game game) {
        this.game = game;
    }

    public static boolean isSuitAmountGreaterThanOrEqualTo(int value, Suit suit) {
        return game.getHand().getCards().stream().filter(card -> card.getSuit() == suit).count() >= value;
    }

    public static boolean isSuitAmountLessThanOrEqualTo(int value, Suit suit) {
        return game.getHand().getCards().stream().filter(card -> card.getSuit() == suit).count() <= value;
    }

    public static boolean isOrdinalGreater(BidSelection selection) {
        if (game.getLastBid() == null || game.getLastBid() == BidSelection.PASS) {
            return true;
        }
        System.out.println("compare last bid: " + game.getLastBid().ordinal() + " with current bid: " + selection.ordinal());
        return game.getLastBid().ordinal() < selection.ordinal();
    }

    public static boolean isTotalPointsGreaterOrEqualTo(int value) {
        System.out.println("Helper functions: " + game.getHand());
        return game.getHand().getTotalPointCount() >= value;
    }

    public static boolean isTotalPointsLessThanOrEqualTo(int value) {
        return game.getHand().getTotalPointCount() <= value;
    }

    public static boolean isQuickTricksGreaterThanOrEqualTo(double value) {
        return game.getHand().getQuickTricks() >= value;
    }

    public static boolean isPartnerBidEqualTo(BidSelection selection) {
        return Player.PARTNER.getLastBid() == selection;
    }

    public static boolean is4432or4441Split() {
        Hand hand = game.getHand();

        boolean spades = List.of(1, 2, 3, 4).contains(hand.getSpades());
        boolean hearts = List.of(1, 2, 3, 4).contains(hand.getHearts());
        boolean diamonds = List.of(1, 2, 3, 4).contains(hand.getDiamonds());
        boolean clubs = List.of(1, 2, 3, 4).contains(hand.getClubs());

        return spades && hearts && diamonds && clubs;
    }

    public static boolean isSuitAmountOneOfTheAmounts(List<Integer> numbers, Suit suit) {
        return numbers.contains((int) game.getHand().getCards().stream().filter(card -> card.getSuit() == suit).count());
    }

    public static boolean is4432or4433SplitAndAtLeast6Points() {
        Hand hand = game.getHand();

        boolean spades2or4or3 = List.of(2, 3, 4).contains(hand.getSpades());
        boolean hearts2or4or3 = List.of(2, 3, 4).contains(hand.getHearts());
        boolean diamonds2or3or4 = List.of(2, 3).contains(hand.getDiamonds());
        boolean clubs2or3or4 = List.of(2, 3, 4).contains(hand.getClubs());

        return spades2or4or3 && hearts2or4or3 && diamonds2or3or4 && clubs2or3or4 && hand.getTotalPointCount() > 5;
    }

    public static boolean isTotalPointsEqualsTo(int value) {
        return game.getHand().getTotalPointCount() == value;
    }
    public static boolean isStopperHeldInUnbidSuits() {
        List<HashMap<Suit, Integer>> stoppers = Arrays.asList(
                game.getHand().getClubStoppers(),
                game.getHand().getDiamondStoppers(),
                game.getHand().getHeartStoppers(),
                game.getHand().getSpadeStoppers());

        for (Suit unbidSuit : game.getUnbidSuits()) {
            boolean isHeld = false;
            for (HashMap<Suit, Integer> map : stoppers) {
                if (map.containsKey(unbidSuit) && map.get(unbidSuit) > 0) {
                    isHeld = true;
                    break;
                }
            }
            if (!isHeld) {
                return false;
            }
        }

        return true;
    }

    public static boolean is4CardMajorHeld() {
        boolean are4SpadesHeld = game.getHand().getSpades() == 4;
        boolean are4HeartsHeld = game.getHand().getHearts() == 4;
        return are4HeartsHeld || are4SpadesHeld;
    }

    public static void setGame(Game game) {
        BidHelperFunctions.game = game;
    }
}
