package com.example.bridge_bid_app_java.bids;

import static com.example.bridge_bid_app_java.utils.BidHelperFunctions.is4432or4441Split;
import static com.example.bridge_bid_app_java.utils.BidHelperFunctions.is4CardMajorHeld;
import static com.example.bridge_bid_app_java.utils.BidHelperFunctions.isOrdinalGreater;
import static com.example.bridge_bid_app_java.utils.BidHelperFunctions.isSuitAmountGreaterThanOrEqualTo;
import static com.example.bridge_bid_app_java.utils.BidHelperFunctions.isSuitAmountLessThanOrEqualTo;
import static com.example.bridge_bid_app_java.utils.BidHelperFunctions.isTotalPointsGreaterOrEqualTo;

import com.example.bridge_bid_app_java.game.BidSelection;
import com.example.bridge_bid_app_java.playing_cards.Suit;

public class ResponseToOneNTBids {

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
        if (isTotalPointsGreaterOrEqualTo(7) &&
                isSuitAmountGreaterThanOrEqualTo(6, Suit.SPADES) &&
                isOrdinalGreater(BidSelection.FOUR_SPADES)) {
            return BidSelection.FOUR_SPADES;
        }
        if (isTotalPointsGreaterOrEqualTo(7) &&
                isSuitAmountGreaterThanOrEqualTo(6, Suit.HEARTS) &&
                isOrdinalGreater(BidSelection.FOUR_HEARTS)) {
            return BidSelection.FOUR_HEARTS;
        }
        if (isTotalPointsGreaterOrEqualTo(10) &&
                is4432or4441Split() &&
                !is4CardMajorHeld() &&
                isOrdinalGreater(BidSelection.THREE_NO_TRUMP)) {
            return BidSelection.THREE_NO_TRUMP;
        }
        if (isTotalPointsGreaterOrEqualTo(10) &&
                isSuitAmountGreaterThanOrEqualTo(5, Suit.SPADES) &&
                isOrdinalGreater(BidSelection.THREE_SPADES)) {
            return BidSelection.THREE_SPADES;
        }
        if (isTotalPointsGreaterOrEqualTo(10) &&
                isSuitAmountGreaterThanOrEqualTo(5, Suit.HEARTS) &&
                isOrdinalGreater(BidSelection.THREE_HEARTS)) {
            return BidSelection.THREE_HEARTS;
        }
        if (isTotalPointsGreaterOrEqualTo(10) &&
                isSuitAmountGreaterThanOrEqualTo(7, Suit.DIAMONDS) &&
                isOrdinalGreater(BidSelection.THREE_DIAMONDS)) {
            return BidSelection.THREE_DIAMONDS;
        }
        if (isTotalPointsGreaterOrEqualTo(10) &&
                isSuitAmountGreaterThanOrEqualTo(7, Suit.CLUBS) &&
                isOrdinalGreater(BidSelection.THREE_CLUBS)) {
            return BidSelection.THREE_CLUBS;
        }
        if (isTotalPointsGreaterOrEqualTo(8) &&
                !is4CardMajorHeld() &&
                isSuitAmountLessThanOrEqualTo(4, Suit.DIAMONDS)) {
            return BidSelection.TWO_NO_TRUMP;
        }
        if (isTotalPointsGreaterOrEqualTo(7) &&
                isSuitAmountGreaterThanOrEqualTo(5, Suit.SPADES) &&
                isOrdinalGreater(BidSelection.TWO_SPADES)) {
            return BidSelection.TWO_SPADES;
        }
        if (isTotalPointsGreaterOrEqualTo(7) &&
                isSuitAmountGreaterThanOrEqualTo(5, Suit.HEARTS) &&
                isOrdinalGreater(BidSelection.TWO_HEARTS)) {
            return BidSelection.TWO_HEARTS;
        }
        if (isTotalPointsGreaterOrEqualTo(7) &
                isSuitAmountGreaterThanOrEqualTo(5, Suit.DIAMONDS) &&
                isOrdinalGreater(BidSelection.TWO_DIAMONDS)) {
            return BidSelection.TWO_DIAMONDS;
        }
        if (isTotalPointsGreaterOrEqualTo(8) &&
                is4CardMajorHeld() &&
                isOrdinalGreater(BidSelection.TWO_CLUBS)) {
            return BidSelection.TWO_CLUBS;
        }
        if (isTotalPointsGreaterOrEqualTo(7) &&
                isSuitAmountGreaterThanOrEqualTo(6, Suit.CLUBS) &&
                isOrdinalGreater(BidSelection.TWO_CLUBS)) {
            return BidSelection.TWO_CLUBS;
        }

        return BidSelection.PASS;
    }
}
