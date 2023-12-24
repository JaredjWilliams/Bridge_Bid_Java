package com.example.bridge_bid_app_java.bids;

import com.example.bridge_bid_app_java.game.BidSelection;
import com.example.bridge_bid_app_java.game.Game;
import com.example.bridge_bid_app_java.game.Player;
import com.example.bridge_bid_app_java.utils.BidHelperFunctions;

public class BidGenerator {

    private final ResponseToOneClubDiamondBids oneClubDiamondBids = new ResponseToOneClubDiamondBids();
    private final ResponseToOneHeartBids oneHeartResponses = new ResponseToOneHeartBids();
    private final ResponseToOneSpadeBids oneSpadeBids = new ResponseToOneSpadeBids();
    private final ResponseToOneNTBids oneNTBids = new ResponseToOneNTBids();
    private final OpenBids openBids = new OpenBids();

    private BidSelection bidSelection;
    private Game game;
    private BidSelection recommendedBid;
    private BidHelperFunctions bidHelperFunctions;

    public BidGenerator(BidSelection bidSelection, Game game) {
        this.bidSelection = bidSelection;
        this.game = game;

        bidHelperFunctions = new BidHelperFunctions(bidSelection, game);

        recommendedBid = createRecommendedBid();
    }

    public void updateRecommendedBid(BidSelection bidSelection, Game game) {
        this.bidSelection = bidSelection;
        this.game = game;

        BidHelperFunctions.setGame(game);
        BidHelperFunctions.setBidSelection(bidSelection);

        recommendedBid = createRecommendedBid();
    }

    public void updateRecommendedBid(Game game) {
        this.game = game;

        BidHelperFunctions.setGame(game);

        recommendedBid = createRecommendedBid();
    }

    public BidSelection createRecommendedBid() {
        if (isBidSelectionNull() && userCanOpen()) {
            return openBids.getRecommendedBid();
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
            case ONE_CLUB, ONE_DIAMOND -> oneClubDiamondBids.getRecommendedBid();
            case ONE_HEART -> oneHeartResponses.getRecommendedBid();
            case ONE_SPADE -> oneSpadeBids.getRecommendedBid();
            case ONE_NO_TRUMP -> oneNTBids.getRecommendedBid();
            case TWO_CLUBS -> BidSelection.PASS;
            case TWO_DIAMONDS -> BidSelection.PASS;
            case TWO_HEARTS -> BidSelection.PASS;
            case TWO_SPADES -> BidSelection.PASS;
            case TWO_NO_TRUMP -> BidSelection.PASS;
            case THREE_CLUBS -> BidSelection.PASS;
            case THREE_DIAMONDS -> BidSelection.PASS;
            case THREE_HEARTS -> BidSelection.PASS;
            case THREE_SPADES -> BidSelection.PASS;
            case THREE_NO_TRUMP -> BidSelection.PASS;
            case FOUR_CLUBS -> BidSelection.PASS;
            case FOUR_DIAMONDS -> BidSelection.PASS;
            case FOUR_HEARTS -> BidSelection.PASS;
            case FIVE_SPADES -> BidSelection.PASS;
            case FIVE_NO_TRUMP -> BidSelection.PASS;
            case SIX_CLUBS -> BidSelection.PASS;
            case SIX_DIAMONDS -> BidSelection.PASS;
            case SIX_HEARTS -> BidSelection.PASS;
            case SIX_SPADES -> BidSelection.PASS;
            case SIX_NO_TRUMP -> BidSelection.PASS;
            case SEVEN_CLUBS -> BidSelection.PASS;
            case SEVEN_DIAMONDS -> BidSelection.PASS;
            case SEVEN_HEARTS -> BidSelection.PASS;
            case SEVEN_SPADES -> BidSelection.PASS;
            case SEVEN_NO_TRUMP -> BidSelection.PASS;
            default -> BidSelection.PASS;
        };
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

    public BidSelection getRecommendedBid() {
        return recommendedBid;
    }

    public Game getGame() {
        return game;
    }
}
