package com.example.bridge_bid_app_java.bids;

import static com.example.bridge_bid_app_java.utils.BidHelperFunctions.isTotalPointsGreaterOrEqualTo;

import com.example.bridge_bid_app_java.game.BidSelection;
import com.example.bridge_bid_app_java.game.Game;
import com.example.bridge_bid_app_java.game.Player;
import com.example.bridge_bid_app_java.utils.BidHelperFunctions;

public class BidGenerator {

    private final ResponseToOneClubDiamondBids oneClubDiamondBids = new ResponseToOneClubDiamondBids();
    private final ResponseToOneHeartBids oneHeartResponses = new ResponseToOneHeartBids();
    private final ResponseToTwoDiamondBid twoDiamondBids = new ResponseToTwoDiamondBid();
    private final ResponseToThreeBid threeBid = new ResponseToThreeBid();
    private final ResponseToOneSpadeBids oneSpadeBids = new ResponseToOneSpadeBids();
    private final ResponseToTwoHeartBid twoHeartBids = new ResponseToTwoHeartBid();
    private final ResponseToTwoSpadeBid twoSpadeBid = new ResponseToTwoSpadeBid();
    private final ResponseToTwoClubBid twoClubBids = new ResponseToTwoClubBid();
    private final ResponseToOneNTBids oneNTBids = new ResponseToOneNTBids();
    private final ResponseToTwoNTBid twoNTBids = new ResponseToTwoNTBid();
    private final OpenBids openBids = new OpenBids();

    private Game game;
    private BidSelection recommendedBid;
    private BidHelperFunctions bidHelperFunctions;

    public BidGenerator(Game game) {
        this.game = game;

        bidHelperFunctions = new BidHelperFunctions(game);
    }

    public void updateRecommendedBid(Game game) {
        this.game = game;

        BidHelperFunctions.setGame(game);

        recommendedBid = createRecommendedBid();
    }

    public BidSelection createRecommendedBid() {
        if (canUserOpen()) {
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
        return switch (Player.PARTNER.getLastBid()) {
            case ONE_CLUB, ONE_DIAMOND -> oneClubDiamondBids.getRecommendedBid();
            case ONE_HEART -> oneHeartResponses.getRecommendedBid();
            case ONE_SPADE -> oneSpadeBids.getRecommendedBid();
            case ONE_NO_TRUMP -> oneNTBids.getRecommendedBid();
            case TWO_CLUBS -> twoClubBids.getRecommendedBid();
            case TWO_DIAMONDS -> twoDiamondBids.getRecommendedBid();
            case TWO_HEARTS -> twoHeartBids.getRecommendedBid();
            case TWO_SPADES -> twoSpadeBid.getRecommendedBid();
            case TWO_NO_TRUMP -> twoNTBids.getRecommendedBid();
            case THREE_CLUBS, THREE_DIAMONDS, THREE_HEARTS, THREE_SPADES -> threeBid.getRecommendedBid();
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

    private boolean canUserOpen() {
        return !didPlayerOpen(Player.PARTNER) && isTotalPointsGreaterOrEqualTo(13) && !didPlayerOpen(Player.USER);
    }

    private boolean didPlayerOpen(Player player) {
        return game.getOpeners().contains(player);
    }

    private boolean didOpponentsOpen() {
        return didPlayerOpen(Player.LEFT_OPPONENT) || didPlayerOpen(Player.RIGHT_OPPONENT);
    }

    private boolean isBidHistoryEmpty() {
        return game.getBidHistoryLength() == 0;
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
