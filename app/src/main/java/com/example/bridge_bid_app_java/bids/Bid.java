package com.example.bridge_bid_app_java.bids;

import static com.example.bridge_bid_app_java.utils.BidHelperFunctions.isStopperHeldInUnbidSuits;

import com.example.bridge_bid_app_java.game.BidSelection;
import com.example.bridge_bid_app_java.game.Game;
import com.example.bridge_bid_app_java.game.Player;
import com.example.bridge_bid_app_java.playing_cards.Hand;

import java.util.List;

public class Bid {

    private BidSelection bidSelection;
    private Game game;
    private BidSelection recommendedBid;

    public Bid(BidSelection bidSelection, Game game) {
        this.bidSelection = bidSelection;
        this.game = game;
        recommendedBid = createRecommendedBid();
    }

    public Bid(Game game) {
        this.game = game;
    }

    public BidSelection createRecommendedBid() {
        if (isBidSelectionNull() && userCanOpen()) {
            return createOpenBid();
        }
        if (didPlayerOpen(Player.PARTNER)) {
            return respondToPartnerBid();
        }

        if (didOpponentsOpen()) {

        }

        return BidSelection.PASS;
    }

    public BidSelection respondToPartnerBid() {
        return switch (bidSelection) {
            case ONE_CLUB, ONE_DIAMONDS -> respondToOneClubOneDiamondBid();
            case ONE_HEARTS -> respondToOneHeartBid();
            default -> BidSelection.PASS;
        };
    }

    private BidSelection respondToOneHeartBid() {
        if (isTotalPointsGreaterOrEqualTo(10) && isSpadesEqualTo(5) &&
                isHeartsLessThan(2) && isHeartsLessThan(2)) {
            return BidSelection.TWO_SPADES;
        }
        if (isTotalPointsGreaterOrEqualTo(6) && isSpadesEqualTo(6) &&
                isHighHeartLessThan(2) && isHeartsLessThan(2)) {
            return BidSelection.TWO_SPADES;
        }
        if (isTotalPointsGreaterOrEqualTo(6) && isHeartsGreaterThan(1)
                && isHighHeartsGreaterThan(1)) {
            return BidSelection.TWO_HEARTS;
        }
        if (isTotalPointsGreaterOrEqualTo(10) && isHighHeartLessThan(2) &&
                isHeartsLessThan(2) && isDiamondAmount(List.of(5, 6))) {
            return BidSelection.TWO_DIAMOND;
        }
        if (isTotalPointsGreaterOrEqualTo(10) && isHighHeartLessThan(2) &&
                isHeartsLessThan(2) && isClubAmount(List.of(5, 6))) {
            return BidSelection.TWO_CLUBS;
        }
        if (isTotalPointsGreaterOrEqualTo(6) && is4432or4441Split() &&
                isHighHeartLessThan(2) && isHeartsLessThan(2)) {
            return BidSelection.ONE_NO_TRUMPS;
        }
        if (isTotalPointsGreaterOrEqualTo(6) && isSpadesEqualTo(5) && isHighHeartLessThan(2) && isHeartsLessThan(2)) {
            return BidSelection.ONE_SPADES;
        }


        return BidSelection.PASS;
    }

    private BidSelection respondToOneClubOneDiamondBid() {
        if (isTotalPointsGreaterOrEqualTo(10) && isSpadesEqualTo(8) && isOrdinalGreater(BidSelection.FOUR_SPADES)) {
            return BidSelection.FOUR_SPADES;
        }
        if (isTotalPointsGreaterOrEqualTo(10) && isHeartsEqualTo(8) && isOrdinalGreater(BidSelection.FOUR_HEARTS)) {
            return BidSelection.FOUR_HEARTS;
        }
        if (isTotalPointsGreaterOrEqualTo(10) && isDiamondsEqualTo(8) && isOrdinalGreater(BidSelection.FIVE_DIAMONDS)) {
            return BidSelection.FIVE_DIAMONDS;
        }
        if (isTotalPointsGreaterOrEqualTo(10) && isClubsEqualTo(8) && isOrdinalGreater(BidSelection.FIVE_CLUBS)) {
            return BidSelection.FIVE_CLUBS;
        }
        if (isTotalPointsGreaterOrEqualTo(16) && is4432or4441Split() && isOrdinalGreater(BidSelection.THREE_NO_TRUMP)) {
            return BidSelection.THREE_NO_TRUMP;
        }
        if (isTotalPointsGreaterOrEqualTo(10) && isSpadesEqualTo(7) && isOrdinalGreater(BidSelection.THREE_SPADES)) {
            return BidSelection.THREE_SPADES;
        }
        if (isTotalPointsGreaterOrEqualTo(10) && isHeartsEqualTo(7) && isOrdinalGreater(BidSelection.THREE_HEARTS)) {
            return BidSelection.THREE_HEARTS;
        }
        if (isTotalPointsEqualsTo(10) && isDiamondsEqualTo(7) && isOrdinalGreater(BidSelection.THREE_DIAMONDS)) {
            return BidSelection.THREE_DIAMONDS;
        }
        if (isTotalPointsGreaterOrEqualTo(10) && isClubsEqualTo(7) && isOrdinalGreater(BidSelection.THREE_CLUBS)) {
            return BidSelection.THREE_CLUBS;
        }
        if (isTotalPointsGreaterOrEqualTo(13) && isStopperHeldInUnbidSuits(game) && isOrdinalGreater(BidSelection.TWO_NO_TRUMP)) {
            return BidSelection.TWO_NO_TRUMP;
        }
        if (isTotalPointsGreaterOrEqualTo(10) && isSpadesEqualTo(6) && isOrdinalGreater(BidSelection.TWO_SPADES)) {
            return BidSelection.TWO_SPADES;
        }
        if (isTotalPointsGreaterOrEqualTo(10) && isHeartsEqualTo(6) && isOrdinalGreater(BidSelection.TWO_HEARTS)) {
            return BidSelection.TWO_HEARTS;
        }
        if (isTotalPointsGreaterOrEqualTo(10) && isDiamondsEqualTo(6) && isOrdinalGreater(BidSelection.TWO_DIAMOND)) {
            return BidSelection.TWO_DIAMOND;
        }
        if (isTotalPointsGreaterOrEqualTo(10) && isClubsEqualTo(5) && isOrdinalGreater(BidSelection.TWO_CLUBS)) {
            return BidSelection.TWO_CLUBS;
        }
        if (is4432or4433SplitAndAtLeast6Points() && isOrdinalGreater(BidSelection.ONE_NO_TRUMPS)) {
            return BidSelection.ONE_NO_TRUMPS;
        }
        if (isTotalPointsGreaterOrEqualTo(6) && isSpadesEqualTo(5) && isOrdinalGreater(BidSelection.ONE_SPADES)) {
            return BidSelection.ONE_SPADES;
        }
        if (isTotalPointsGreaterOrEqualTo(6) && isHeartsEqualTo(5) && isOrdinalGreater(BidSelection.ONE_HEARTS)) {
            return BidSelection.ONE_HEARTS;
        }
        if (isTotalPointsGreaterOrEqualTo(6) && isOneOfTheAmounts(List.of(4, 5)) && isOrdinalGreater(BidSelection.ONE_DIAMONDS)) {
            return BidSelection.ONE_DIAMONDS;
        }

        return BidSelection.PASS;
    }

    public BidSelection createOpenBid() {
        if (isTotalPointsLessThan(13)) {
            return BidSelection.PASS;
        } else if (isClubsEqualTo(7)) {
            return BidSelection.THREE_CLUBS;
        }

        return BidSelection.ONE_CLUB;
    }
    private boolean isHighHeartsGreaterThan(int value) {
        return game.getHand().getHearts() > value;
    }

    private boolean isHeartsGreaterThan(int value) {
        return game.getHand().getHighHearts() > value;
    }
    private boolean isDiamondAmount(List<Integer> values) {
        return values.contains(game.getHand().getDiamonds());
    }

    private boolean isClubAmount(List<Integer> values) {
        return values.contains(game.getHand().getClubs());
    }

    private boolean isHighHeartLessThan(int value) {
        return game.getHand().getHighHearts() < value;
    }

    public boolean isOrdinalGreater(BidSelection selection) {
        return bidSelection.ordinal() < selection.ordinal();
    }

    private boolean isTotalPointsLessThan(int value) {
        return game.getHand().getTotalPointCount() < value;
    }
    private boolean isTotalPointsEqualsTo(int value) {
        return game.getHand().getTotalPointCount() == value;
    }

    private boolean didPlayerOpen(Player player) {
        return game.getOpener() == player;
    }

    private boolean didOpponentsOpen() {
        return game.getOpener() == Player.LEFT_OPPONENT || game.getOpener() == Player.RIGHT_OPPONENT;
    }

    private boolean isBidSelectionNull() {
        return bidSelection == null;
    }

    private boolean userCanOpen() {
        return game.getHand().getTotalPointCount() > 12;
    }

    private boolean didPartnerBid(BidSelection bidSelection) {
        return this.bidSelection == bidSelection;
    }
    private boolean isHeartsEqualTo(int value) {
        return game.getHand().getHearts() == value;
    }
    private boolean isHeartsLessThan(int value) {
        return game.getHand().getHearts() < value;
    }

    private boolean isSpadesEqualTo(int value) {
        return game.getHand().getSpades() == value;
    }

    private boolean is4432or4441Split() {
        Hand hand = game.getHand();

        boolean spades = List.of(1, 2, 3, 4).contains(hand.getSpades());
        boolean hearts = List.of(1, 2, 3, 4).contains(hand.getHearts());
        boolean diamonds = List.of(1, 2, 3, 4).contains(hand.getDiamonds());
        boolean clubs = List.of(1, 2, 3, 4).contains(hand.getClubs());

        return spades && hearts && diamonds && clubs;
    }

    private boolean is4432or4433SplitAndAtLeast6Points() {
        Hand hand = game.getHand();

        boolean spades2or4or3 = List.of(2, 3, 4).contains(hand.getSpades());
        boolean hearts2or4or3 = List.of(2, 3, 4).contains(hand.getHearts());
        boolean diamonds2or3or4 = List.of(2, 3).contains(hand.getDiamonds());
        boolean clubs2or3or4 = List.of(2, 3, 4).contains(hand.getClubs());

        return spades2or4or3 && hearts2or4or3 && diamonds2or3or4 && clubs2or3or4 && hand.getTotalPointCount() > 5;
    }

    private boolean isTotalPointsGreaterOrEqualTo(int value) {
        return game.getHand().getTotalPointCount() >= value;
    }

    private boolean isClubsEqualTo(int value) {
        return game.getHand().getClubs() == value;
    }

    private boolean isDiamondsEqualTo(int value) {
        return game.getHand().getDiamonds() == value;
    }

    private boolean isOneOfTheAmounts(List<Integer> numbers) {
        return numbers.contains(game.getHand().getDiamonds());
    }

    public BidSelection getRecommendedBid() {
        return recommendedBid;
    }

    public Game getGame() {
        return game;
    }
}
