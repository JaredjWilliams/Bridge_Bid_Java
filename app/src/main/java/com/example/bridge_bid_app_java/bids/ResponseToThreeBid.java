package com.example.bridge_bid_app_java.bids;

import static com.example.bridge_bid_app_java.utils.BidHelperFunctions.isOrdinalGreater;
import static com.example.bridge_bid_app_java.utils.BidHelperFunctions.isPartnerBidEqualTo;
import static com.example.bridge_bid_app_java.utils.BidHelperFunctions.isQuickTricksGreaterThanOrEqualTo;
import static com.example.bridge_bid_app_java.utils.BidHelperFunctions.isTotalPointsGreaterOrEqualTo;

import com.example.bridge_bid_app_java.game.BidSelection;

public class ResponseToThreeBid {

    public BidSelection getRecommendedBid() {

        if (isFourSpadesAValidBid()) {
            return BidSelection.FOUR_SPADES;
        }

        if (isFourHeartsAValidBid()) {
            return BidSelection.FOUR_HEARTS;
        }

        if (isFiveDiamondsAValidBid()) {
            return BidSelection.FIVE_DIAMONDS;
        }

        if (isFiveClubsAValidBid()) {
            return BidSelection.FIVE_CLUBS;
        }

        return BidSelection.PASS;
    }

    private static boolean isFiveClubsAValidBid() {
        return isTotalPointsGreaterOrEqualTo(15) &&
                isQuickTricksGreaterThanOrEqualTo(5) &&
                isPartnerBidEqualTo(BidSelection.THREE_CLUBS) &&
                isOrdinalGreater(BidSelection.FIVE_CLUBS);
    }

    private static boolean isFiveDiamondsAValidBid() {
        return isTotalPointsGreaterOrEqualTo(15) &&
                isQuickTricksGreaterThanOrEqualTo(5) &&
                isPartnerBidEqualTo(BidSelection.THREE_DIAMONDS) &&
                isOrdinalGreater(BidSelection.FIVE_DIAMONDS);
    }

    private static boolean isFourHeartsAValidBid() {
        return isTotalPointsGreaterOrEqualTo(13) &&
                isQuickTricksGreaterThanOrEqualTo(4) &&
                isPartnerBidEqualTo(BidSelection.THREE_HEARTS) &&
                isOrdinalGreater(BidSelection.FOUR_HEARTS);
    }

    private static boolean isFourSpadesAValidBid() {
        return isTotalPointsGreaterOrEqualTo(13) &&
                isQuickTricksGreaterThanOrEqualTo(4) &&
                isPartnerBidEqualTo(BidSelection.THREE_SPADES) &&
                isOrdinalGreater(BidSelection.FOUR_SPADES);
    }
}
