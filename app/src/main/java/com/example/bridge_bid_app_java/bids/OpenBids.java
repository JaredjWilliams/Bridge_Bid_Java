package com.example.bridge_bid_app_java.bids;

import static com.example.bridge_bid_app_java.playing_cards.Suit.CLUBS;
import static com.example.bridge_bid_app_java.playing_cards.Suit.DIAMONDS;
import static com.example.bridge_bid_app_java.playing_cards.Suit.HEARTS;
import static com.example.bridge_bid_app_java.playing_cards.Suit.NO_TRUMP;
import static com.example.bridge_bid_app_java.playing_cards.Suit.SPADES;
import static com.example.bridge_bid_app_java.utils.BidHelperFunctions.getBidSelectionFor;
import static com.example.bridge_bid_app_java.utils.BidHelperFunctions.is4432or4441Split;
import static com.example.bridge_bid_app_java.utils.BidHelperFunctions.isHighCardPointsGreaterOrEqualTo;
import static com.example.bridge_bid_app_java.utils.BidHelperFunctions.isQuickTricksGreaterThanOrEqualTo;
import static com.example.bridge_bid_app_java.utils.BidHelperFunctions.isSuitAmountGreaterThanOrEqualTo;
import static com.example.bridge_bid_app_java.utils.BidHelperFunctions.isSuitAmountLessThanOrEqualTo;
import static com.example.bridge_bid_app_java.utils.BidHelperFunctions.isTotalPointsGreaterOrEqualTo;

import com.example.bridge_bid_app_java.game.BidSelection;
import com.example.bridge_bid_app_java.playing_cards.Suit;

import java.util.List;

public class OpenBids {

    public OpenBids() {

    }

    public BidSelection getRecommendedBid() {

        if (isAValidOpenerFor(2, SPADES)) {
            return getBidSelectionFor(2, SPADES);
        }

        if (isAValidOpenerFor(2, HEARTS)) {
            return getBidSelectionFor(2, HEARTS);
        }

        if (isAValidOpenerFor(2, DIAMONDS)) {
            return getBidSelectionFor(2, DIAMONDS);
        }

        if (isAValidOpenerFor(2, CLUBS)) {
            return getBidSelectionFor(2, CLUBS);
        }

        if (isAValidOpenerFor(1, NO_TRUMP)) {
            return getBidSelectionFor(1, NO_TRUMP);
        }

        if (isAValidOpenerFor(1, SPADES)) {
            return getBidSelectionFor(1, SPADES);
        }

        if (isAValidOpenerFor(1, HEARTS)) {
            return getBidSelectionFor(1, HEARTS);
        }

        if (isAValidOpenerFor(1, DIAMONDS)) {
            return getBidSelectionFor(1, DIAMONDS);
        }

        if (isOneClubAValidBid()) {
            return getBidSelectionFor(1, CLUBS);
        }

        return BidSelection.PASS;
    }

    private boolean isAValidOpenerFor(int number, Suit suit) {

        if (isSuitNoTrump(suit)) {
            return switch (number) {
                case 1 -> isHighCardPointsGreaterOrEqualTo(15) && is4432or4441Split();
                case 2 -> isHighCardPointsGreaterOrEqualTo(21) && is4432or4441Split();
                case 3 -> isHighCardPointsGreaterOrEqualTo(24) && is4432or4441Split();
                default -> false;
            };
        }

        if (isOneClubOrOneDiamond(number, suit)) {
            return isOneClubAValidBid() || isOneDiamondAValidBid();
        }

        boolean enoughQuickTricks = switch (number) {
            case 1 -> doesMeetPointAndLengthCriteria(suit) &&
                    (isQuickTricksGreaterThanOrEqualTo(2) || isTotalPointsGreaterOrEqualTo(14));
            case 2 -> isQuickTricksGreaterThanOrEqualTo(4);
            case 3 -> isQuickTricksGreaterThanOrEqualTo(6);
            case 4 -> true;
            default -> false;
        };

        boolean enoughPoints = switch (number) {
            case 1, 4 -> isTotalPointsGreaterOrEqualTo(13);
            case 2, 3 -> enoughQuickTricks;
            default -> false;
        };

        boolean enoughOfSuit = switch (number) {
            case 1, 2 -> isSuitAmountGreaterThanOrEqualTo(5, suit);
            case 3 -> isSuitAmountGreaterThanOrEqualTo(7, suit);
            case 4, 5 -> isSuitAmountGreaterThanOrEqualTo(8, suit);
            case 6, 7 -> true;
            default -> false;
        };

        return enoughQuickTricks && enoughPoints && enoughOfSuit;
    }

    private static boolean doesMeetQuickTrickCriteria(Suit suit) {
        return isQuickTricksGreaterThanOrEqualTo(2);
    }

    private static boolean doesMeetPointAndLengthCriteria(Suit suit) {
        return isTotalPointsGreaterOrEqualTo(13) && isSuitAmountGreaterThanOrEqualTo(5, suit);
    }

    private boolean isOneClubOrOneDiamond(int number, Suit suit) {
        return isSuitClubsOrDiamonds(suit) && number == 1;
    }

    private boolean isSuitNoTrump(Suit suit) {
        return suit == NO_TRUMP;
    }

    private boolean isSuitClubsOrDiamonds(Suit suit) {
        return List.of(DIAMONDS, CLUBS).contains(suit);
    }

    private boolean isSuitSpadesOrHearts(Suit suit) {
        return List.of(SPADES, HEARTS).contains(suit);
    }

    private boolean isOneSuitBidAValidFor(Suit suit) {

        if (isOneSuitOpenWith13Points(suit)) {
            return true;
        } else return isOneSuitOpenWith14Points(suit);
    }

    private static boolean isOneSuitOpenWith14Points(Suit suit) {
        return isTotalPointsGreaterOrEqualTo(14) &&
                isSuitAmountGreaterThanOrEqualTo(5, suit);
    }

    private boolean isOneSuitOpenWith13Points(Suit suit) {
        return isTotalPointsGreaterOrEqualTo(13) &&
                isSuitAmountGreaterThanOrEqualTo(5, suit) &&
                (isQuickTricksGreaterThanOrEqualTo(2) ||
                        isSuitAmountGreaterThanOrEqualTo(6, suit));
    }

    private boolean isOneDiamondAValidBid() {
        return isTotalPointsGreaterOrEqualTo(14) &&
                isSuitAmountLessThanOrEqualTo(4, SPADES) &&
                isSuitAmountLessThanOrEqualTo(4, HEARTS) &&
                isSuitAmountGreaterThanOrEqualTo(3, DIAMONDS) &&
                isSuitAmountLessThanOrEqualTo(2, CLUBS);

    }

    private boolean isOneClubAValidBid() {
        return isTotalPointsGreaterOrEqualTo(14) &&
                isSuitAmountLessThanOrEqualTo(4, SPADES) &&
                isSuitAmountLessThanOrEqualTo(4, HEARTS) &&
                isSuitAmountLessThanOrEqualTo(3, DIAMONDS) &&
                isSuitAmountGreaterThanOrEqualTo(3, CLUBS);
    }


}
