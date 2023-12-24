package com.example.bridge_bid_app_java.bids;

import static com.example.bridge_bid_app_java.utils.BidHelperFunctions.isSuitAmountGreaterThanOrEqualTo;
import static com.example.bridge_bid_app_java.utils.BidHelperFunctions.isTotalPointsGreaterOrEqualTo;

import com.example.bridge_bid_app_java.game.BidSelection;
import com.example.bridge_bid_app_java.playing_cards.Suit;

public class OpenBids {

    public OpenBids() {

    }

    public BidSelection getRecommendedBid() {
        if (isTotalPointsGreaterOrEqualTo(13)) {
            return BidSelection.PASS;
        } else if (isSuitAmountGreaterThanOrEqualTo(7, Suit.CLUBS)) {
            return BidSelection.THREE_CLUBS;
        }

        return BidSelection.ONE_CLUB;
    }


}
