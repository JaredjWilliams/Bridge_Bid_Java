package com.example.bridge_bid_app_java.bids;

import static com.example.bridge_bid_app_java.utils.BidHelperFunctions.isOrdinalGreater;
import static com.example.bridge_bid_app_java.utils.BidHelperFunctions.isSuitAmountGreaterThanOrEqualTo;
import static com.example.bridge_bid_app_java.utils.BidHelperFunctions.isTotalPointsGreaterOrEqualTo;
import static com.example.bridge_bid_app_java.utils.BidHelperFunctions.isTotalPointsLessThanOrEqualTo;

import com.example.bridge_bid_app_java.game.BidSelection;
import com.example.bridge_bid_app_java.playing_cards.Suit;

public class ResponseToTwoSpadeBid {

    public BidSelection getRecommendedBid() {
        if (isFourHeartsAValidResponse()) {
            return BidSelection.FOUR_SPADES;
        }
        if (isThreeHeartsAValidResponse()) {
            return BidSelection.THREE_SPADES;
        }
        if (isTwoNTAValidResponse()) {
            return BidSelection.TWO_NO_TRUMP;
        }

        return BidSelection.PASS;
    }

    private boolean isThreeHeartsAValidResponse() {
        return isTotalPointsGreaterOrEqualTo(7) &&
                isSuitAmountGreaterThanOrEqualTo(3, Suit.SPADES) &&
                isOrdinalGreater(BidSelection.THREE_SPADES);
    }

    private boolean isTwoNTAValidResponse() {
        return isTotalPointsLessThanOrEqualTo(6) &&
                isOrdinalGreater(BidSelection.TWO_NO_TRUMP);
    }

    private boolean isFourHeartsAValidResponse() {
        return isTotalPointsGreaterOrEqualTo(10) &&
                isSuitAmountGreaterThanOrEqualTo(3, Suit.SPADES) &&
                isOrdinalGreater(BidSelection.FOUR_SPADES);
    }
}
