package com.example.bridge_bid_app_java.bids;

import static com.example.bridge_bid_app_java.utils.BidHelperFunctions.isOrdinalGreater;
import static com.example.bridge_bid_app_java.utils.BidHelperFunctions.isSuitAmountGreaterThanOrEqualTo;
import static com.example.bridge_bid_app_java.utils.BidHelperFunctions.isSuitAmountLessThanOrEqualTo;
import static com.example.bridge_bid_app_java.utils.BidHelperFunctions.isTotalPointsGreaterOrEqualTo;
import static com.example.bridge_bid_app_java.utils.BidHelperFunctions.isTotalPointsLessThanOrEqualTo;

import com.example.bridge_bid_app_java.game.BidSelection;
import com.example.bridge_bid_app_java.playing_cards.Suit;

public class ResponseToTwoClubBid {

    public BidSelection getRecommendedBid() {
        if (isFiveClubsAValidResponse()) {
            return BidSelection.FIVE_CLUBS;
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

        return BidSelection.PASS;
    }

    private boolean isThreeClubsAValidResponse() {
        return isTotalPointsGreaterOrEqualTo(7) &&
                isSuitAmountGreaterThanOrEqualTo(3, Suit.CLUBS) &&
                isOrdinalGreater(BidSelection.THREE_CLUBS);
    }

    private boolean isTwoNTAValidResponse() {
        return isTotalPointsLessThanOrEqualTo(6) &&
                isOrdinalGreater(BidSelection.TWO_NO_TRUMP);
    }

    private boolean isTwoSpadesAValidResponse() {
        return isTotalPointsGreaterOrEqualTo(10) &&
                isSuitAmountGreaterThanOrEqualTo(5, Suit.SPADES) &&
                isSuitAmountLessThanOrEqualTo(1, Suit.CLUBS) &&
                isOrdinalGreater(BidSelection.TWO_SPADES);
    }

    private boolean isTwoHeartsAValidResponse() {
        return isTotalPointsGreaterOrEqualTo(10) &&
                isSuitAmountGreaterThanOrEqualTo(5, Suit.HEARTS) &&
                isSuitAmountLessThanOrEqualTo(1, Suit.CLUBS) &&
                isOrdinalGreater(BidSelection.TWO_HEARTS);
    }

    private boolean isTwoDiamondsAValidResponse() {
        return isTotalPointsGreaterOrEqualTo(10) &&
                isSuitAmountGreaterThanOrEqualTo(5, Suit.DIAMONDS) &&
                isSuitAmountLessThanOrEqualTo(1, Suit.CLUBS) &&
                isOrdinalGreater(BidSelection.TWO_DIAMONDS);
    }

    private boolean isFiveClubsAValidResponse() {
        return isTotalPointsGreaterOrEqualTo(10) &&
                isSuitAmountGreaterThanOrEqualTo(3, Suit.CLUBS) &&
                isOrdinalGreater(BidSelection.FIVE_CLUBS);
    }
}
