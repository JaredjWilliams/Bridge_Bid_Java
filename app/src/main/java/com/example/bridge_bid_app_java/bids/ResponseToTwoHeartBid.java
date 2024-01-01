package com.example.bridge_bid_app_java.bids;

import static com.example.bridge_bid_app_java.utils.BidHelperFunctions.isOrdinalGreater;
import static com.example.bridge_bid_app_java.utils.BidHelperFunctions.isSuitAmountGreaterThanOrEqualTo;
import static com.example.bridge_bid_app_java.utils.BidHelperFunctions.isSuitAmountLessThanOrEqualTo;
import static com.example.bridge_bid_app_java.utils.BidHelperFunctions.isTotalPointsGreaterOrEqualTo;
import static com.example.bridge_bid_app_java.utils.BidHelperFunctions.isTotalPointsLessThanOrEqualTo;

import com.example.bridge_bid_app_java.game.BidSelection;
import com.example.bridge_bid_app_java.playing_cards.Suit;

public class ResponseToTwoHeartBid {

    public BidSelection getRecommendedBid() {
        if (isFourHeartsAValidResponse()) {
            return BidSelection.FOUR_HEARTS;
        }
        if (isThreeHeartsAValidResponse()) {
            return BidSelection.THREE_HEARTS;
        }
        if (isTwoNTAValidResponse()) {
            return BidSelection.TWO_NO_TRUMP;
        }
        if (isTwoSpadesAValidResponse()) {
            return BidSelection.TWO_SPADES;
        }

        return BidSelection.PASS;
    }

    private boolean isThreeHeartsAValidResponse() {
        return isTotalPointsGreaterOrEqualTo(7) &&
                isSuitAmountGreaterThanOrEqualTo(3, Suit.HEARTS) &&
                isOrdinalGreater(BidSelection.THREE_HEARTS);
    }

    private boolean isTwoNTAValidResponse() {
        return isTotalPointsLessThanOrEqualTo(6) &&
                isOrdinalGreater(BidSelection.TWO_NO_TRUMP);
    }

    private boolean isTwoSpadesAValidResponse() {
        return isTotalPointsGreaterOrEqualTo(10) &&
                isSuitAmountGreaterThanOrEqualTo(5, Suit.SPADES) &&
                isSuitAmountLessThanOrEqualTo(1, Suit.HEARTS) &&
                isOrdinalGreater(BidSelection.TWO_SPADES);
    }

    private boolean isFourHeartsAValidResponse() {
        return isTotalPointsGreaterOrEqualTo(10) &&
                isSuitAmountGreaterThanOrEqualTo(3, Suit.HEARTS) &&
                isOrdinalGreater(BidSelection.FOUR_HEARTS);
    }
}
