package com.example.bridge_bid_app_java.bids;

import static com.example.bridge_bid_app_java.utils.BidHelperFunctions.is4432or4433SplitAndAtLeast6Points;
import static com.example.bridge_bid_app_java.utils.BidHelperFunctions.is4432or4441Split;
import static com.example.bridge_bid_app_java.utils.BidHelperFunctions.isOrdinalGreater;
import static com.example.bridge_bid_app_java.utils.BidHelperFunctions.isStopperHeldInUnbidSuits;
import static com.example.bridge_bid_app_java.utils.BidHelperFunctions.isSuitAmountGreaterThanOrEqualTo;
import static com.example.bridge_bid_app_java.utils.BidHelperFunctions.isSuitAmountOneOfTheAmounts;
import static com.example.bridge_bid_app_java.utils.BidHelperFunctions.isTotalPointsEqualsTo;
import static com.example.bridge_bid_app_java.utils.BidHelperFunctions.isTotalPointsGreaterOrEqualTo;

import com.example.bridge_bid_app_java.game.BidSelection;
import com.example.bridge_bid_app_java.playing_cards.Suit;

import java.util.List;

public class ResponseToOneClubDiamondBids {

    public BidSelection getRecommendedBid() {
        if (isTotalPointsGreaterOrEqualTo(10) &&
                isSuitAmountGreaterThanOrEqualTo(8, Suit.SPADES) &&
                isOrdinalGreater(BidSelection.FOUR_SPADES)) {
            return BidSelection.FOUR_SPADES;
        }
        if (isTotalPointsGreaterOrEqualTo(10) &&
                isSuitAmountGreaterThanOrEqualTo(8, Suit.HEARTS) &&
                isOrdinalGreater(BidSelection.FOUR_HEARTS)) {
            return BidSelection.FOUR_HEARTS;
        }
        if (isTotalPointsGreaterOrEqualTo(10) &&
                isSuitAmountGreaterThanOrEqualTo(8, Suit.DIAMONDS) &&
                isOrdinalGreater(BidSelection.FIVE_DIAMONDS)) {
            return BidSelection.FIVE_DIAMONDS;
        }
        if (isTotalPointsGreaterOrEqualTo(10) &&
                isSuitAmountGreaterThanOrEqualTo(8, Suit.CLUBS) &&
                isOrdinalGreater(BidSelection.FIVE_CLUBS)) {
            return BidSelection.FIVE_CLUBS;
        }
        if (isTotalPointsGreaterOrEqualTo(16) &&
                is4432or4441Split() &&
                isOrdinalGreater(BidSelection.THREE_NO_TRUMP)) {
            return BidSelection.THREE_NO_TRUMP;
        }
        if (isTotalPointsGreaterOrEqualTo(10) &&
                isSuitAmountGreaterThanOrEqualTo(7, Suit.SPADES) &&
                isOrdinalGreater(BidSelection.THREE_SPADES)) {
            return BidSelection.THREE_SPADES;
        }
        if (isTotalPointsGreaterOrEqualTo(10) &&
                isSuitAmountGreaterThanOrEqualTo(7, Suit.HEARTS) &&
                isOrdinalGreater(BidSelection.THREE_HEARTS)) {
            return BidSelection.THREE_HEARTS;
        }
        if (isTotalPointsEqualsTo(10) &&
                isSuitAmountGreaterThanOrEqualTo(7, Suit.DIAMONDS) &&
                isOrdinalGreater(BidSelection.THREE_DIAMONDS)) {
            return BidSelection.THREE_DIAMONDS;
        }
        if (isTotalPointsGreaterOrEqualTo(10) &&
                isSuitAmountGreaterThanOrEqualTo(7, Suit.CLUBS) &&
                isOrdinalGreater(BidSelection.THREE_CLUBS)) {
            return BidSelection.THREE_CLUBS;
        }
        if (isTotalPointsGreaterOrEqualTo(13) &&
                isStopperHeldInUnbidSuits() &&
                isOrdinalGreater(BidSelection.TWO_NO_TRUMP)) {
            return BidSelection.TWO_NO_TRUMP;
        }
        if (isTotalPointsGreaterOrEqualTo(10) &&
                isSuitAmountGreaterThanOrEqualTo(6, Suit.SPADES) &&
                isOrdinalGreater(BidSelection.TWO_SPADES)) {
            return BidSelection.TWO_SPADES;
        }
        if (isTotalPointsGreaterOrEqualTo(10) &&
                isSuitAmountGreaterThanOrEqualTo(6, Suit.HEARTS) &&
                isOrdinalGreater(BidSelection.TWO_HEARTS)) {
            return BidSelection.TWO_HEARTS;
        }
        if (isTotalPointsGreaterOrEqualTo(10) &&
                isSuitAmountGreaterThanOrEqualTo(6, Suit.DIAMONDS) &&
                isOrdinalGreater(BidSelection.TWO_DIAMONDS)) {
            return BidSelection.TWO_DIAMONDS;
        }
        if (isTotalPointsGreaterOrEqualTo(10) &&
                isSuitAmountGreaterThanOrEqualTo(5, Suit.CLUBS) &&
                isOrdinalGreater(BidSelection.TWO_CLUBS)) {
            return BidSelection.TWO_CLUBS;
        }
        if (is4432or4433SplitAndAtLeast6Points() &&
                isOrdinalGreater(BidSelection.ONE_NO_TRUMP)) {
            return BidSelection.ONE_NO_TRUMP;
        }
        if (isTotalPointsGreaterOrEqualTo(6) &&
                isSuitAmountGreaterThanOrEqualTo(5, Suit.SPADES) &&
                isOrdinalGreater(BidSelection.ONE_SPADE)) {
            return BidSelection.ONE_SPADE;
        }
        if (isTotalPointsGreaterOrEqualTo(6) &&
                isSuitAmountGreaterThanOrEqualTo(5, Suit.HEARTS) &&
                isOrdinalGreater(BidSelection.ONE_HEART)) {
            return BidSelection.ONE_HEART;
        }
        if (isTotalPointsGreaterOrEqualTo(6) &&
                isSuitAmountOneOfTheAmounts(List.of(4, 5), Suit.DIAMONDS) &&
                isOrdinalGreater(BidSelection.ONE_DIAMOND)) {
            return BidSelection.ONE_DIAMOND;
        }

        return BidSelection.PASS;
    }
}
