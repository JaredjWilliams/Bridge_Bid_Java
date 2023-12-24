package com.example.bridge_bid_app_java.bids;

import static com.example.bridge_bid_app_java.utils.BidHelperFunctions.is4432or4441Split;
import static com.example.bridge_bid_app_java.utils.BidHelperFunctions.isOrdinalGreater;
import static com.example.bridge_bid_app_java.utils.BidHelperFunctions.isStopperHeldInUnbidSuits;
import static com.example.bridge_bid_app_java.utils.BidHelperFunctions.isSuitAmountGreaterThanOrEqualTo;
import static com.example.bridge_bid_app_java.utils.BidHelperFunctions.isSuitAmountLessThanOrEqualTo;
import static com.example.bridge_bid_app_java.utils.BidHelperFunctions.isTotalPointsGreaterOrEqualTo;

import com.example.bridge_bid_app_java.game.BidSelection;
import com.example.bridge_bid_app_java.playing_cards.Suit;

public class ResponseToOneHeartBids {

    public BidSelection getRecommendedBid() {
        if (isTotalPointsGreaterOrEqualTo(13) &&
                isSuitAmountGreaterThanOrEqualTo(8, Suit.DIAMONDS) &&
                isOrdinalGreater(BidSelection.FIVE_DIAMONDS)) {
            return BidSelection.FIVE_DIAMONDS;
        }
        if (isTotalPointsGreaterOrEqualTo(13) &&
                isSuitAmountGreaterThanOrEqualTo(8, Suit.CLUBS) &&
                isOrdinalGreater(BidSelection.FIVE_CLUBS)) {
            return BidSelection.FIVE_CLUBS;
        }
        if (isTotalPointsGreaterOrEqualTo(10) &&
                isSuitAmountGreaterThanOrEqualTo(8, Suit.SPADES) &&
                isOrdinalGreater(BidSelection.FOUR_SPADES)) {
            return BidSelection.FOUR_SPADES;
        }
        if (isTotalPointsGreaterOrEqualTo(10) &&
                isSuitAmountGreaterThanOrEqualTo(5, Suit.HEARTS) &&
                isOrdinalGreater(BidSelection.FOUR_HEARTS)) {
            return BidSelection.FOUR_HEARTS;
        }
        if (isTotalPointsGreaterOrEqualTo(16) &&
                is4432or4441Split() &&
                isSuitAmountLessThanOrEqualTo(2, Suit.HEARTS) &&
                isOrdinalGreater(BidSelection.THREE_NO_TRUMP)) {
            return BidSelection.THREE_NO_TRUMP;
        }
        if (isTotalPointsGreaterOrEqualTo(10) &&
                isSuitAmountGreaterThanOrEqualTo(7, Suit.SPADES) &&
                isOrdinalGreater(BidSelection.THREE_SPADES)) {
            return BidSelection.THREE_SPADES;
        }
        if (isTotalPointsGreaterOrEqualTo(13) &&
                isSuitAmountGreaterThanOrEqualTo(3, Suit.HEARTS) &&
                isOrdinalGreater(BidSelection.THREE_HEARTS)) {
            return BidSelection.THREE_HEARTS;
        }
        if (isTotalPointsGreaterOrEqualTo(10) &&
                isSuitAmountGreaterThanOrEqualTo(7, Suit.DIAMONDS) &&
                isSuitAmountLessThanOrEqualTo(2, Suit.HEARTS) &&
                isOrdinalGreater(BidSelection.THREE_DIAMONDS)) {
            return BidSelection.THREE_DIAMONDS;
        }
        if (isTotalPointsGreaterOrEqualTo(10) &&
                isSuitAmountGreaterThanOrEqualTo(7, Suit.CLUBS) &&
                isSuitAmountLessThanOrEqualTo(2, Suit.HEARTS) &&
                isOrdinalGreater(BidSelection.THREE_CLUBS)) {
            return BidSelection.THREE_CLUBS;
        }
        if (isTotalPointsGreaterOrEqualTo(13) &&
                isStopperHeldInUnbidSuits() &&
                isSuitAmountLessThanOrEqualTo(2, Suit.HEARTS) &&
                isOrdinalGreater(BidSelection.TWO_NO_TRUMP)) {
            return BidSelection.TWO_NO_TRUMP;
        }
        if (isTotalPointsGreaterOrEqualTo(10) &&
                isSuitAmountGreaterThanOrEqualTo(5, Suit.SPADES) &&
                isSuitAmountLessThanOrEqualTo(2, Suit.HEARTS) &&
                isOrdinalGreater(BidSelection.TWO_SPADES)) {
            return BidSelection.TWO_SPADES;
        }
        if (isTotalPointsGreaterOrEqualTo(6) &&
                isSuitAmountGreaterThanOrEqualTo(6, Suit.SPADES) &&
                isSuitAmountLessThanOrEqualTo(2, Suit.HEARTS) &&
                isOrdinalGreater(BidSelection.TWO_SPADES)) {
            return BidSelection.TWO_SPADES;
        }
        if (isTotalPointsGreaterOrEqualTo(6) &&
                isSuitAmountGreaterThanOrEqualTo(3, Suit.HEARTS) &&
                isOrdinalGreater(BidSelection.TWO_HEARTS)) {
            return BidSelection.TWO_HEARTS;
        }
        if (isTotalPointsGreaterOrEqualTo(10) &&
                isSuitAmountGreaterThanOrEqualTo(5, Suit.DIAMONDS) &&
                isSuitAmountLessThanOrEqualTo(2, Suit.HEARTS) &&
                isOrdinalGreater(BidSelection.TWO_DIAMONDS)) {
            return BidSelection.TWO_DIAMONDS;
        }
        if (isTotalPointsGreaterOrEqualTo(10) &&
                isSuitAmountLessThanOrEqualTo(2, Suit.HEARTS) &&
                isSuitAmountGreaterThanOrEqualTo(5, Suit.CLUBS) &&
                isOrdinalGreater(BidSelection.TWO_CLUBS)) {
            return BidSelection.TWO_CLUBS;
        }
        if (isTotalPointsGreaterOrEqualTo(6) &&
                is4432or4441Split() &&
                isSuitAmountLessThanOrEqualTo(2, Suit.HEARTS) &&
                isOrdinalGreater(BidSelection.ONE_NO_TRUMP)) {
            return BidSelection.ONE_NO_TRUMP;
        }
        if (isTotalPointsGreaterOrEqualTo(6) &&
                isSuitAmountGreaterThanOrEqualTo(5, Suit.SPADES) &&
                isSuitAmountLessThanOrEqualTo(2, Suit.HEARTS) &&
                isOrdinalGreater(BidSelection.ONE_SPADE)) {
            return BidSelection.ONE_SPADE;
        }


        return BidSelection.PASS;
    }

//    private boolean isSuitAmountGreaterThanOrEqualTo(int value, Suit suit) {
//        return game.getHand().getCards().stream().filter(card -> card.getSuit() == suit).count() >= value;
//    }
//
//    private boolean isSuitAmountLessThanOrEqualTo(int value, Suit suit) {
//        return game.getHand().getCards().stream().filter(card -> card.getSuit() == suit).count() <= value;
//    }
//
//    public boolean isOrdinalGreater(BidSelection selection) {
//        return bidSelection.ordinal() < selection.ordinal();
//    }
//
//    private boolean isTotalPointsGreaterOrEqualTo(int value) {
//        return game.getHand().getTotalPointCount() >= value;
//    }
//
//    private boolean is4432or4441Split() {
//        Hand hand = game.getHand();
//
//        boolean spades = List.of(1, 2, 3, 4).contains(hand.getSpades());
//        boolean hearts = List.of(1, 2, 3, 4).contains(hand.getHearts());
//        boolean diamonds = List.of(1, 2, 3, 4).contains(hand.getDiamonds());
//        boolean clubs = List.of(1, 2, 3, 4).contains(hand.getClubs());
//
//        return spades && hearts && diamonds && clubs;
//    }
}
