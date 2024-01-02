package com.example.bridge_bid_app_java.bids;

import static com.example.bridge_bid_app_java.utils.BidHelperFunctions.is4432or4441Split;
import static com.example.bridge_bid_app_java.utils.BidHelperFunctions.isOrdinalGreater;
import static com.example.bridge_bid_app_java.utils.BidHelperFunctions.isSuitAmountGreaterThanOrEqualTo;
import static com.example.bridge_bid_app_java.utils.BidHelperFunctions.isTotalPointsGreaterOrEqualTo;

import com.example.bridge_bid_app_java.game.BidSelection;
import com.example.bridge_bid_app_java.playing_cards.Suit;

public class ResponseToTwoNTBid {

    public BidSelection getRecommendedBid() {

        if (isSevenNTAValidResponse()) {
            return BidSelection.SEVEN_NO_TRUMP;
        }

        if (isSixNTAValidResponse()) {
            return BidSelection.SIX_NO_TRUMP;
        }

        if (isFourNTAValidResponse()) {
            return BidSelection.FOUR_NO_TRUMP;
        }

        if (isFourSpadesAValidResponse()) {
            return BidSelection.FOUR_SPADES;
        }

        if (isFourHeartsAValidResponse()) {
            return BidSelection.FOUR_HEARTS;
        }

        if (isThreeNTAValidResponse()) {
            return BidSelection.THREE_NO_TRUMP;
        }

        if (isThreeSpadesAValidResponse()) {
            return BidSelection.THREE_SPADES;
        }

        if (isThreeHeartsAValidResponse()) {
            return BidSelection.THREE_HEARTS;
        }

        if (isThreeDiamondsAValidResponse()) {
            return BidSelection.THREE_DIAMONDS;
        }

        if (isThreeClubsAValidResponse()) {
            return BidSelection.THREE_CLUBS;
        }

        return BidSelection.PASS;
    }

    private static boolean isSevenNTAValidResponse() {
        return isTotalPointsGreaterOrEqualTo(15) &&
                isOrdinalGreater(BidSelection.SEVEN_NO_TRUMP);
    }

    private static boolean isSixNTAValidResponse() {
        return isTotalPointsGreaterOrEqualTo(11) &&
                isOrdinalGreater(BidSelection.SIX_NO_TRUMP);
    }

    private static boolean isFourNTAValidResponse() {
        return isTotalPointsGreaterOrEqualTo(9) &&
                isOrdinalGreater(BidSelection.FOUR_NO_TRUMP);
    }

    private static boolean isFourSpadesAValidResponse() {
        return isSuitAmountGreaterThanOrEqualTo(6, Suit.SPADES) &&
                isTotalPointsGreaterOrEqualTo(4) &&
                isOrdinalGreater(BidSelection.FOUR_SPADES);
    }

    private static boolean isFourHeartsAValidResponse() {
        return isSuitAmountGreaterThanOrEqualTo(6, Suit.HEARTS) &&
                isTotalPointsGreaterOrEqualTo(4) &&
                isOrdinalGreater(BidSelection.FOUR_HEARTS);
    }

    private static boolean isThreeNTAValidResponse() {
        return is4432or4441Split() &&
                isTotalPointsGreaterOrEqualTo(5) &&
                isOrdinalGreater(BidSelection.THREE_NO_TRUMP);
    }

    private static boolean isThreeSpadesAValidResponse() {
        return isSuitAmountGreaterThanOrEqualTo(5, Suit.SPADES) &&
                isTotalPointsGreaterOrEqualTo(4) &&
                isOrdinalGreater(BidSelection.THREE_SPADES);
    }

    private static boolean isThreeHeartsAValidResponse() {
        return isSuitAmountGreaterThanOrEqualTo(5, Suit.HEARTS) &&
                isTotalPointsGreaterOrEqualTo(4) &&
                isOrdinalGreater(BidSelection.THREE_HEARTS);
    }

    private static boolean isThreeDiamondsAValidResponse() {
        return isSuitAmountGreaterThanOrEqualTo(5, Suit.DIAMONDS) &&
                isTotalPointsGreaterOrEqualTo(4) &&
                isOrdinalGreater(BidSelection.THREE_DIAMONDS);
    }

    private static boolean isThreeClubsAValidResponse() {
        return is4432or4441Split() &&
                isTotalPointsGreaterOrEqualTo(4) &&
                isOrdinalGreater(BidSelection.THREE_CLUBS);
    }
}
