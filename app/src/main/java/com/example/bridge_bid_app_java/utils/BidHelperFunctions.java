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

    public static boolean isHighCardPointsGreaterOrEqualTo(int value) {
        return game.getHand().getHighCardPoints() >= value;
    }

    public static BidSelection getBidSelectionFor(int number, Suit suit) {
        return switch (suit) {
            case CLUBS -> switch (number) {
                case 1 -> BidSelection.ONE_CLUB;
                case 2 -> BidSelection.TWO_CLUBS;
                case 3 -> BidSelection.THREE_CLUBS;
                case 4 -> BidSelection.FOUR_CLUBS;
                case 5 -> BidSelection.FIVE_CLUBS;
                case 6 -> BidSelection.SIX_CLUBS;
                case 7 -> BidSelection.SEVEN_CLUBS;
                default -> throw new IllegalStateException("Unexpected value: " + number);
            };
            case DIAMONDS -> switch (number) {
                case 1 -> BidSelection.ONE_DIAMOND;
                case 2 -> BidSelection.TWO_DIAMONDS;
                case 3 -> BidSelection.THREE_DIAMONDS;
                case 4 -> BidSelection.FOUR_DIAMONDS;
                case 5 -> BidSelection.FIVE_DIAMONDS;
                case 6 -> BidSelection.SIX_DIAMONDS;
                case 7 -> BidSelection.SEVEN_DIAMONDS;
                default -> throw new IllegalStateException("Unexpected value: " + number);
            };
            case HEARTS -> switch (number) {
                case 1 -> BidSelection.ONE_HEART;
                case 2 -> BidSelection.TWO_HEARTS;
                case 3 -> BidSelection.THREE_HEARTS;
                case 4 -> BidSelection.FOUR_HEARTS;
                case 5 -> BidSelection.FIVE_HEARTS;
                case 6 -> BidSelection.SIX_HEARTS;
                case 7 -> BidSelection.SEVEN_HEARTS;
                default -> throw new IllegalStateException("Unexpected value: " + number);
            };
            case SPADES -> switch (number) {
                case 1 -> BidSelection.ONE_SPADE;
                case 2 -> BidSelection.TWO_SPADES;
                case 3 -> BidSelection.THREE_SPADES;
                case 4 -> BidSelection.FOUR_SPADES;
                case 5 -> BidSelection.FIVE_SPADES;
                case 6 -> BidSelection.SIX_SPADES;
                case 7 -> BidSelection.SEVEN_SPADES;
                default -> throw new IllegalStateException("Unexpected value: " + number);
            };
            case NO_TRUMP -> switch (number) {
                case 1 -> BidSelection.ONE_NO_TRUMP;
                case 2 -> BidSelection.TWO_NO_TRUMP;
                case 3 -> BidSelection.THREE_NO_TRUMP;
                case 4 -> BidSelection.FOUR_NO_TRUMP;
                case 5 -> BidSelection.FIVE_NO_TRUMP;
                case 6 -> BidSelection.SIX_NO_TRUMP;
                case 7 -> BidSelection.SEVEN_NO_TRUMP;
                default -> throw new IllegalStateException("Unexpected value: " + number);
            };
        };
    }
}
