package com.example.bridge_bid_app_java.bids;

import static com.example.bridge_bid_app_java.utils.BidHelperFunctions.game;
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
        if (isFourSpadesAValidResponse()) {
            return BidSelection.FOUR_SPADES;
        }
        if (isFourHeartsAValidResponse()) {
            return BidSelection.FOUR_HEARTS;
        }
        if (isFiveDiamondsAValidResponse()) {
            return BidSelection.FIVE_DIAMONDS;
        }
        if (isFiveClubsAValidResponse()) {
            return BidSelection.FIVE_CLUBS;
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
        if (isThreeClubsAValidReponse()) {
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
        if (isOneSpadeAValidResponse()) {
            return BidSelection.ONE_SPADE;
        }
        if (isOneHeartAValidResponse()) {
            return BidSelection.ONE_HEART;
        }
        System.out.println("is one heart valid: " + isOneHeartAValidResponse());
        System.out.println("is hearts greater than or equal to: " + isSuitAmountGreaterThanOrEqualTo(5, Suit.HEARTS));
        System.out.println("is ordinal greater than: " + isOrdinalGreater(BidSelection.ONE_HEART));
        if (isOneDiamondAValidResponse()) {
            return BidSelection.ONE_DIAMOND;
        }

        return BidSelection.PASS;
    }

    private static boolean isOneDiamondAValidResponse() {
        return isTotalPointsGreaterOrEqualTo(6) &&
                isSuitAmountOneOfTheAmounts(List.of(4, 5), Suit.DIAMONDS) &&
                isOrdinalGreater(BidSelection.ONE_DIAMOND);
    }

    private static boolean isOneHeartAValidResponse() {
        System.out.println(game.getHand());
        return isTotalPointsGreaterOrEqualTo(6) &&
                isSuitAmountGreaterThanOrEqualTo(5, Suit.HEARTS) &&
                isOrdinalGreater(BidSelection.ONE_HEART);
    }

    private static boolean isOneSpadeAValidResponse() {
        return isTotalPointsGreaterOrEqualTo(6) &&
                isSuitAmountGreaterThanOrEqualTo(5, Suit.SPADES) &&
                isOrdinalGreater(BidSelection.ONE_SPADE);
    }

    private static boolean isOneNTAValidResponse() {
        return is4432or4433SplitAndAtLeast6Points() &&
                isOrdinalGreater(BidSelection.ONE_NO_TRUMP);
    }

    private static boolean isTwoClubsAValidResponse() {
        return isTotalPointsGreaterOrEqualTo(10) &&
                isSuitAmountGreaterThanOrEqualTo(5, Suit.CLUBS) &&
                isOrdinalGreater(BidSelection.TWO_CLUBS);
    }

    private static boolean isTwoDiamondsAValidResponse() {
        return isTotalPointsGreaterOrEqualTo(10) &&
                isSuitAmountGreaterThanOrEqualTo(6, Suit.DIAMONDS) &&
                isOrdinalGreater(BidSelection.TWO_DIAMONDS);
    }

    private static boolean isTwoHeartsAValidResponse() {
        return isTotalPointsGreaterOrEqualTo(10) &&
                isSuitAmountGreaterThanOrEqualTo(6, Suit.HEARTS) &&
                isOrdinalGreater(BidSelection.TWO_HEARTS);
    }

    private static boolean isTwoSpadesAValidResponse() {
        return isTotalPointsGreaterOrEqualTo(10) &&
                isSuitAmountGreaterThanOrEqualTo(6, Suit.SPADES) &&
                isOrdinalGreater(BidSelection.TWO_SPADES);
    }

    private static boolean isTwoNTAValidResponse() {
        return isTotalPointsGreaterOrEqualTo(13) &&
                isStopperHeldInUnbidSuits() &&
                isOrdinalGreater(BidSelection.TWO_NO_TRUMP);
    }

    private static boolean isThreeClubsAValidReponse() {
        return isTotalPointsGreaterOrEqualTo(10) &&
                isSuitAmountGreaterThanOrEqualTo(7, Suit.CLUBS) &&
                isOrdinalGreater(BidSelection.THREE_CLUBS);
    }

    private static boolean isThreeDiamondsAValidResponse() {
        return isTotalPointsEqualsTo(10) &&
                isSuitAmountGreaterThanOrEqualTo(7, Suit.DIAMONDS) &&
                isOrdinalGreater(BidSelection.THREE_DIAMONDS);
    }

    private static boolean isThreeHeartsAValidResponse() {
        return isTotalPointsGreaterOrEqualTo(10) &&
                isSuitAmountGreaterThanOrEqualTo(7, Suit.HEARTS) &&
                isOrdinalGreater(BidSelection.THREE_HEARTS);
    }

    private static boolean isThreeSpadesAValidResponse() {
        return isTotalPointsGreaterOrEqualTo(10) &&
                isSuitAmountGreaterThanOrEqualTo(7, Suit.SPADES) &&
                isOrdinalGreater(BidSelection.THREE_SPADES);
    }

    private static boolean isThreeNTAValidResponse() {
        return isTotalPointsGreaterOrEqualTo(16) &&
                is4432or4441Split() &&
                isOrdinalGreater(BidSelection.THREE_NO_TRUMP);
    }

    private static boolean isFiveClubsAValidResponse() {
        return isTotalPointsGreaterOrEqualTo(10) &&
                isSuitAmountGreaterThanOrEqualTo(8, Suit.CLUBS) &&
                isOrdinalGreater(BidSelection.FIVE_CLUBS);
    }

    private boolean isFourSpadesAValidResponse() {
        return isTotalPointsGreaterOrEqualTo(10) &&
                isSuitAmountGreaterThanOrEqualTo(8, Suit.SPADES) &&
                isOrdinalGreater(BidSelection.FOUR_SPADES);
    }

    private boolean isFourHeartsAValidResponse() {
        return isTotalPointsGreaterOrEqualTo(10) &&
                isSuitAmountGreaterThanOrEqualTo(8, Suit.HEARTS) &&
                isOrdinalGreater(BidSelection.FOUR_HEARTS);
    }

    private boolean isFiveDiamondsAValidResponse() {
        return isTotalPointsGreaterOrEqualTo(10) &&
                isSuitAmountGreaterThanOrEqualTo(8, Suit.DIAMONDS) &&
                isOrdinalGreater(BidSelection.FIVE_DIAMONDS);
    }
}
