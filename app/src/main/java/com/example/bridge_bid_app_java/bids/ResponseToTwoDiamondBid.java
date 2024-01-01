package com.example.bridge_bid_app_java.bids;

import static com.example.bridge_bid_app_java.utils.BidHelperFunctions.isOrdinalGreater;
import static com.example.bridge_bid_app_java.utils.BidHelperFunctions.isSuitAmountGreaterThanOrEqualTo;
import static com.example.bridge_bid_app_java.utils.BidHelperFunctions.isSuitAmountLessThanOrEqualTo;
import static com.example.bridge_bid_app_java.utils.BidHelperFunctions.isTotalPointsGreaterOrEqualTo;
import static com.example.bridge_bid_app_java.utils.BidHelperFunctions.isTotalPointsLessThanOrEqualTo;

import com.example.bridge_bid_app_java.game.BidSelection;
import com.example.bridge_bid_app_java.playing_cards.Suit;

public class ResponseToTwoDiamondBid {

    public BidSelection getRecommendedBid() {

        if (isFiveDiamondsAValidResponse()) {
            return BidSelection.FIVE_DIAMONDS;
        }
        if (isThreeDiamondsAValidResponse()) {
            return BidSelection.THREE_DIAMONDS;
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

        return BidSelection.PASS;
    }

    private boolean isTwoHeartsAValidResponse() {
        return isTotalPointsGreaterOrEqualTo(10) &&
                isSuitAmountGreaterThanOrEqualTo(5, Suit.HEARTS) &&
                isSuitAmountLessThanOrEqualTo(1, Suit.DIAMONDS) &&
                isOrdinalGreater(BidSelection.TWO_HEARTS);
    }

    private boolean isTwoSpadesAValidResponse() {
        return isTotalPointsGreaterOrEqualTo(10) &&
                isSuitAmountGreaterThanOrEqualTo(5, Suit.SPADES) &&
                isSuitAmountLessThanOrEqualTo(1, Suit.DIAMONDS) &&
                isOrdinalGreater(BidSelection.TWO_SPADES);
    }

    private boolean isTwoNTAValidResponse() {
        return isTotalPointsLessThanOrEqualTo(6) &&
                isOrdinalGreater(BidSelection.TWO_NO_TRUMP);
    }

    private boolean isThreeDiamondsAValidResponse() {
        return isTotalPointsGreaterOrEqualTo(7) &&
                isSuitAmountGreaterThanOrEqualTo(3, Suit.DIAMONDS) &&
                isOrdinalGreater(BidSelection.THREE_DIAMONDS);
    }

    private boolean isFiveDiamondsAValidResponse() {
        return isTotalPointsGreaterOrEqualTo(10) &&
                isSuitAmountGreaterThanOrEqualTo(3, Suit.DIAMONDS) &&
                isOrdinalGreater(BidSelection.FIVE_DIAMONDS);
    }
}
