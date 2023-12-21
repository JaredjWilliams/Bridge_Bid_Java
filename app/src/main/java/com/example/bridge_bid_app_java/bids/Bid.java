package com.example.bridge_bid_app_java.bids;

import static com.example.bridge_bid_app_java.utils.BidHelperFunctions.isStopperHeldInUnbidSuits;

import com.example.bridge_bid_app_java.game.BidSelection;
import com.example.bridge_bid_app_java.game.Game;
import com.example.bridge_bid_app_java.game.Player;
import com.example.bridge_bid_app_java.playing_cards.Hand;
import com.example.bridge_bid_app_java.playing_cards.Suit;

import java.util.List;

public class Bid {

    private BidSelection bidSelection;
    private Game game;
    private BidSelection recommendedBid;
    private ResponseToOneHeartBids oneHeartResponses;

    public Bid(BidSelection bidSelection, Game game) {
        this.bidSelection = bidSelection;
        this.game = game;

        oneHeartResponses = new ResponseToOneHeartBids(bidSelection, game);
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
            case ONE_CLUB, ONE_DIAMOND -> respondToOneClubOneDiamondBid();
            case ONE_HEART -> oneHeartResponses.getRecommendedBid();
            case ONE_SPADE -> responseToOneSpadeBid();
            default -> BidSelection.PASS;
        };
    }

    private BidSelection responseToOneSpadeBid() {
        if (isTotalPointsGreaterOrEqualTo(6) &&
                isSuitAmountGreaterThanOrEqualTo(3, Suit.SPADES) &&
                isOrdinalGreater(BidSelection.TWO_SPADES)) {
            return BidSelection.TWO_SPADES;
        }
        if (isTotalPointsGreaterOrEqualTo(10) &&
                isSuitAmountLessThanOrEqualTo(2, Suit.SPADES) &&
                isSuitAmountGreaterThanOrEqualTo(5, Suit.HEARTS) &&
                isOrdinalGreater(BidSelection.TWO_HEARTS)) {
            return BidSelection.TWO_HEARTS;
        }
        if (isTotalPointsGreaterOrEqualTo(10) &
                isSuitAmountLessThanOrEqualTo(2, Suit.SPADES) &&
                isSuitAmountGreaterThanOrEqualTo(5, Suit.DIAMONDS) &&
                isOrdinalGreater(BidSelection.TWO_DIAMONDS)) {
            return BidSelection.TWO_DIAMONDS;
        }
        if (isTotalPointsGreaterOrEqualTo(10) &&
                isSuitAmountLessThanOrEqualTo(2, Suit.SPADES) &&
                isSuitAmountGreaterThanOrEqualTo(5, Suit.CLUBS) &&
                isOrdinalGreater(BidSelection.TWO_CLUBS)) {
            return BidSelection.TWO_CLUBS;
        }
        if (isTotalPointsGreaterOrEqualTo(6) &&
                isSuitAmountLessThanOrEqualTo(2, Suit.SPADES) &&
                is4432or4441Split() &&
                isOrdinalGreater(BidSelection.ONE_NO_TRUMP)) {
            return BidSelection.ONE_NO_TRUMP;
        }

        return BidSelection.PASS;
    }


    private BidSelection respondToOneClubOneDiamondBid() {
        if (isTotalPointsGreaterOrEqualTo(10) &&
                isSuitAmountGreaterThanOrEqualTo(8, Suit.SPADES) &&
                isOrdinalGreater(BidSelection.FOUR_SPADES)) {
            return BidSelection.FOUR_SPADES;
        }
        if (isTotalPointsGreaterOrEqualTo(10) &&
                isSuitAmountGreaterThanOrEqualTo(8, Suit.HEARTS) &&
                isOrdinalGreater(BidSelection.FOUR_HEARTS)) {
            return BidSelection.FOUR_HEARTS;
        }
        if (isTotalPointsGreaterOrEqualTo(10) &&
                isSuitAmountGreaterThanOrEqualTo(8, Suit.DIAMONDS) &&
                isOrdinalGreater(BidSelection.FIVE_DIAMONDS)) {
            return BidSelection.FIVE_DIAMONDS;
        }
        if (isTotalPointsGreaterOrEqualTo(10) &&
                isSuitAmountGreaterThanOrEqualTo(8, Suit.CLUBS) &&
                isOrdinalGreater(BidSelection.FIVE_CLUBS)) {
            return BidSelection.FIVE_CLUBS;
        }
        if (isTotalPointsGreaterOrEqualTo(16) &&
                is4432or4441Split() &&
                isOrdinalGreater(BidSelection.THREE_NO_TRUMP)) {
            return BidSelection.THREE_NO_TRUMP;
        }
        if (isTotalPointsGreaterOrEqualTo(10) &&
                isSuitAmountGreaterThanOrEqualTo(7, Suit.SPADES) &&
                isOrdinalGreater(BidSelection.THREE_SPADES)) {
            return BidSelection.THREE_SPADES;
        }
        if (isTotalPointsGreaterOrEqualTo(10) &&
                isSuitAmountGreaterThanOrEqualTo(7, Suit.HEARTS) &&
                isOrdinalGreater(BidSelection.THREE_HEARTS)) {
            return BidSelection.THREE_HEARTS;
        }
        if (isTotalPointsEqualsTo(10) &&
                isSuitAmountGreaterThanOrEqualTo(7, Suit.DIAMONDS) &&
                isOrdinalGreater(BidSelection.THREE_DIAMONDS)) {
            return BidSelection.THREE_DIAMONDS;
        }
        if (isTotalPointsGreaterOrEqualTo(10) &&
                isSuitAmountGreaterThanOrEqualTo(7, Suit.CLUBS) &&
                isOrdinalGreater(BidSelection.THREE_CLUBS)) {
            return BidSelection.THREE_CLUBS;
        }
        if (isTotalPointsGreaterOrEqualTo(13) &&
                isStopperHeldInUnbidSuits(game) &&
                isOrdinalGreater(BidSelection.TWO_NO_TRUMP)) {
            return BidSelection.TWO_NO_TRUMP;
        }
        if (isTotalPointsGreaterOrEqualTo(10) &&
                isSuitAmountGreaterThanOrEqualTo(6, Suit.SPADES) &&
                isOrdinalGreater(BidSelection.TWO_SPADES)) {
            return BidSelection.TWO_SPADES;
        }
        if (isTotalPointsGreaterOrEqualTo(10) &&
                isSuitAmountGreaterThanOrEqualTo(6, Suit.HEARTS) &&
                isOrdinalGreater(BidSelection.TWO_HEARTS)) {
            return BidSelection.TWO_HEARTS;
        }
        if (isTotalPointsGreaterOrEqualTo(10) &&
                isSuitAmountGreaterThanOrEqualTo(6, Suit.DIAMONDS) &&
                isOrdinalGreater(BidSelection.TWO_DIAMONDS)) {
            return BidSelection.TWO_DIAMONDS;
        }
        if (isTotalPointsGreaterOrEqualTo(10) &&
                isSuitAmountGreaterThanOrEqualTo(5, Suit.CLUBS) &&
                isOrdinalGreater(BidSelection.TWO_CLUBS)) {
            return BidSelection.TWO_CLUBS;
        }
        if (is4432or4433SplitAndAtLeast6Points() &&
                isOrdinalGreater(BidSelection.ONE_NO_TRUMP)) {
            return BidSelection.ONE_NO_TRUMP;
        }
        if (isTotalPointsGreaterOrEqualTo(6) &&
                isSuitAmountGreaterThanOrEqualTo(5, Suit.SPADES) &&
                isOrdinalGreater(BidSelection.ONE_SPADE)) {
            return BidSelection.ONE_SPADE;
        }
        if (isTotalPointsGreaterOrEqualTo(6) &&
                isSuitAmountGreaterThanOrEqualTo(5, Suit.HEARTS) &&
                isOrdinalGreater(BidSelection.ONE_HEART)) {
            return BidSelection.ONE_HEART;
        }
        if (isTotalPointsGreaterOrEqualTo(6) &&
                isSuitAmountOneOfTheAmounts(List.of(4, 5), Suit.DIAMONDS) &&
                isOrdinalGreater(BidSelection.ONE_DIAMOND)) {
            return BidSelection.ONE_DIAMOND;
        }

        return BidSelection.PASS;
    }

    public BidSelection createOpenBid() {
        if (isTotalPointsLessThan(13)) {
            return BidSelection.PASS;
        } else if (isSuitAmountGreaterThanOrEqualTo(7, Suit.CLUBS)) {
            return BidSelection.THREE_CLUBS;
        }

        return BidSelection.ONE_CLUB;
    }

    boolean isSuitAmountGreaterThanOrEqualTo(int value, Suit suit) {
        return game.getHand().getCards().stream().filter(card -> card.getSuit() == suit).count() >= value;
    }

    boolean isSuitAmountLessThanOrEqualTo(int value, Suit suit) {
        return game.getHand().getCards().stream().filter(card -> card.getSuit() == suit).count() <= value;
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

    boolean is4432or4441Split() {
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

    boolean isTotalPointsGreaterOrEqualTo(int value) {
        return game.getHand().getTotalPointCount() >= value;
    }

    private boolean isSuitAmountOneOfTheAmounts(List<Integer> numbers, Suit suit) {
        return numbers.contains((int) game.getHand().getCards().stream().filter(card -> card.getSuit() == suit).count());
    }

    public BidSelection getRecommendedBid() {
        return recommendedBid;
    }

    public Game getGame() {
        return game;
    }
}
