package com.example.bridge_bid_app_java.bids;

import static com.example.bridge_bid_app_java.utils.BidHelperFunctions.is4432or4441Split;
import static com.example.bridge_bid_app_java.utils.BidHelperFunctions.isOrdinalGreater;
import static com.example.bridge_bid_app_java.utils.BidHelperFunctions.isStopperHeldInUnbidSuits;
import static com.example.bridge_bid_app_java.utils.BidHelperFunctions.isSuitAmountGreaterThanOrEqualTo;
import static com.example.bridge_bid_app_java.utils.BidHelperFunctions.isSuitAmountLessThanOrEqualTo;
import static com.example.bridge_bid_app_java.utils.BidHelperFunctions.isTotalPointsGreaterOrEqualTo;

import com.example.bridge_bid_app_java.game.BidSelection;
import com.example.bridge_bid_app_java.playing_cards.Suit;

public class ResponseToOneSpadeBids {

    public BidSelection getRecommendedBid() {
        if (isFiveDiamondsAValidResponse()) {
            return BidSelection.FIVE_DIAMONDS;
        }
        if (isFiveClubsAValidResponse()) {
            return BidSelection.FIVE_CLUBS;
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
        if (isTwoNTAValidResponse()) {
            return BidSelection.TWO_NO_TRUMP;
        }
        if (isTwoSpadesAValidResponse()) {
            return BidSelection.TWO_SPADES;
        }
        if (isTwoHeartsAValidResponse()) {
            return BidSelection.TWO_HEARTS;
        }
        if (isTwoDiamondsAValidResponse()) {
            return BidSelection.TWO_DIAMONDS;
        }
        if (isTwoClubsAValidResponse()) {
            return BidSelection.TWO_CLUBS;
        }
        if (isOneNTAValidResponse()) {
            return BidSelection.ONE_NO_TRUMP;
        }

        return BidSelection.PASS;
    }

    private static boolean isOneNTAValidResponse() {
        return isTotalPointsGreaterOrEqualTo(6) &&
                isSuitAmountLessThanOrEqualTo(2, Suit.SPADES) &&
                is4432or4441Split() &&
                isOrdinalGreater(BidSelection.ONE_NO_TRUMP);
    }

    private static boolean isTwoClubsAValidResponse() {
        return isTotalPointsGreaterOrEqualTo(10) &&
                isSuitAmountLessThanOrEqualTo(2, Suit.SPADES) &&
                isSuitAmountGreaterThanOrEqualTo(5, Suit.CLUBS) &&
                isOrdinalGreater(BidSelection.TWO_CLUBS);
    }

    private static boolean isTwoDiamondsAValidResponse() {
        return isTotalPointsGreaterOrEqualTo(10) &
                isSuitAmountLessThanOrEqualTo(2, Suit.SPADES) &&
                isSuitAmountGreaterThanOrEqualTo(5, Suit.DIAMONDS) &&
                isOrdinalGreater(BidSelection.TWO_DIAMONDS);
    }

    private static boolean isTwoHeartsAValidResponse() {
        return isTotalPointsGreaterOrEqualTo(10) &&
                isSuitAmountLessThanOrEqualTo(2, Suit.SPADES) &&
                isSuitAmountGreaterThanOrEqualTo(5, Suit.HEARTS) &&
                isOrdinalGreater(BidSelection.TWO_HEARTS);
    }

    private static boolean isTwoSpadesAValidResponse() {
        return isTotalPointsGreaterOrEqualTo(6) &&
                isSuitAmountGreaterThanOrEqualTo(3, Suit.SPADES) &&
                isOrdinalGreater(BidSelection.TWO_SPADES);
    }

    private static boolean isTwoNTAValidResponse() {
        return isTotalPointsGreaterOrEqualTo(13) &&
                isStopperHeldInUnbidSuits() &&
                is4432or4441Split() &&
                isOrdinalGreater(BidSelection.TWO_NO_TRUMP);
    }

    private static boolean isThreeClubsAValidResponse() {
        return isTotalPointsGreaterOrEqualTo(10) &&
                isSuitAmountGreaterThanOrEqualTo(7, Suit.CLUBS) &&
                isSuitAmountLessThanOrEqualTo(2, Suit.SPADES) &&
                isOrdinalGreater(BidSelection.THREE_CLUBS);
    }

    private static boolean isThreeDiamondsAValidResponse() {
        return isTotalPointsGreaterOrEqualTo(10) &&
                isSuitAmountGreaterThanOrEqualTo(7, Suit.DIAMONDS) &&
                isSuitAmountLessThanOrEqualTo(2, Suit.SPADES) &&
                isOrdinalGreater(BidSelection.THREE_DIAMONDS);
    }

    private static boolean isThreeHeartsAValidResponse() {
        return isTotalPointsGreaterOrEqualTo(10) &&
                isSuitAmountGreaterThanOrEqualTo(7, Suit.HEARTS) &&
                isSuitAmountLessThanOrEqualTo(2, Suit.SPADES) &&
                isOrdinalGreater(BidSelection.THREE_HEARTS);
    }

    private static boolean isThreeSpadesAValidResponse() {
        return isTotalPointsGreaterOrEqualTo(13) &&
                isSuitAmountGreaterThanOrEqualTo(3, Suit.SPADES) &&
                isOrdinalGreater(BidSelection.THREE_SPADES);
    }

    private static boolean isThreeNTAValidResponse() {
        return isTotalPointsGreaterOrEqualTo(16) &&
                is4432or4441Split() &&
                isOrdinalGreater(BidSelection.THREE_NO_TRUMP);
    }

    private static boolean isFourHeartsAValidResponse() {
        return isTotalPointsGreaterOrEqualTo(10) &&
                isSuitAmountGreaterThanOrEqualTo(8, Suit.HEARTS) &&
                isOrdinalGreater(BidSelection.FOUR_HEARTS);
    }

    private static boolean isFourSpadesAValidResponse() {
        return isTotalPointsGreaterOrEqualTo(10) &&
                isSuitAmountGreaterThanOrEqualTo(5, Suit.SPADES) &&
                isOrdinalGreater(BidSelection.FOUR_SPADES);
    }

    private static boolean isFiveClubsAValidResponse() {
        return isTotalPointsGreaterOrEqualTo(13) &&
                isSuitAmountGreaterThanOrEqualTo(8, Suit.CLUBS) &&
                isOrdinalGreater(BidSelection.FIVE_CLUBS);
    }

    private static boolean isFiveDiamondsAValidResponse() {
        return isTotalPointsGreaterOrEqualTo(13) &&
                isSuitAmountGreaterThanOrEqualTo(8, Suit.DIAMONDS) &&
                isOrdinalGreater(BidSelection.FIVE_DIAMONDS);
    }
}
