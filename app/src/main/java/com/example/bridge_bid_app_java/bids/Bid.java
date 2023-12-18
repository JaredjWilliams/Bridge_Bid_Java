package com.example.bridge_bid_app_java.bids;

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
        if (didPartnerBid(BidSelection.ONE_CLUBS)) {
            return respondToOneClubBid();
        }

        return BidSelection.PASS;
    }

    public BidSelection respondToOneClubBid() {
        if (isTotalPointsGreaterOrEqualTo(13))
        if (isTotalPointsGreaterOrEqualTo(10) && isSpadesEqualTo(6)) {
            return BidSelection.TWO_SPADES;
        }
        if (isTotalPointsGreaterOrEqualTo(10) && isHeartsEqualTo(6)) {
            return BidSelection.TWO_HEARTS;
        }
        if (isTotalPointsGreaterOrEqualTo(10) && isDiamondsEqualTo(6)) {
            return BidSelection.TWO_DIAMOND;
        }
        if (isTotalPointsGreaterOrEqualTo(10) && isClubsEqualTo(5)) {
            return BidSelection.TWO_CLUBS;
        }
        if (is4432or4433SplitAndAtLeast6Points()) {
            return BidSelection.ONE_NO_TRUMPS;
        }
        if (isTotalPointsGreaterOrEqualTo(6) && isSpadesEqualTo(5)) {
            return BidSelection.ONE_SPADES;
        }
        if (isTotalPointsGreaterOrEqualTo(6) && isHeartsEqualTo(5)) {
            return BidSelection.ONE_HEARTS;
        }
        if (isTotalPointsGreaterOrEqualTo(6) && isOneOfTheAmounts(List.of(4, 5))) {
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

        return BidSelection.ONE_CLUBS;
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

    private boolean isSpadesEqualTo(int value) {
        return game.getHand().getSpades() == value;
    }

    private boolean is4432or4433SplitAndAtLeast6Points() {
        Hand hand = game.getHand();

        boolean spades2or4or3 = List.of(2, 3, 4).contains(hand.getSpades());
        boolean hearts2or4or3 = List.of(2, 3, 4).contains(hand.getHearts());
        boolean diamonds2or3or4 = List.of(2, 3).contains(hand.getDiamonds());
        boolean clubs2or3or4 = List.of(2, 3, 4).contains(hand.getClubs());

        return spades2or4or3 && hearts2or4or3 && diamonds2or3or4 && clubs2or3or4 && hand.getTotalPointCount() > 5;
    }

    private boolean isSuitEqualToValuesAndTotalPoints(int suitNumber, List<Integer> values, int targetPoints, Hand hand) {
        return values.contains(suitNumber) && hand.getTotalPointCount() >= targetPoints;
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
