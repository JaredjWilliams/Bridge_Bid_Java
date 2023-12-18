package com.example.bridge_bid_app_java;

import static com.example.bridge_bid_app_java.utils.TargetHandGenerator.createTargetedHand;
import static org.junit.Assert.assertEquals;

import com.example.bridge_bid_app_java.bids.Bid;
import com.example.bridge_bid_app_java.game.BidSelection;
import com.example.bridge_bid_app_java.game.Game;
import com.example.bridge_bid_app_java.game.Player;

import org.junit.Before;
import org.junit.Test;

public class ResponseBidTests {

    private Game game;
    private Bid bid;

    @Before
    public void setUp() {
        game = new Game();
        game.setOpener(Player.PARTNER);
    }

    @Test
    public void testResponseBidOfOneDiamond() {
        game.setHand(createTargetedHand(6, 3, 4, 5, 1));
        bid = new Bid(BidSelection.ONE_CLUBS, game);
        System.out.println(game.getHand());

        assertEquals(BidSelection.ONE_DIAMONDS, bid.getRecommendedBid());
    }

    @Test
    public void testResponseBidOfOneDiamondWith4Diamonds() {
        game.setHand(createTargetedHand(6, 3, 4, 4, 2));
        bid = new Bid(BidSelection.ONE_CLUBS, game);
        System.out.println(game.getHand());

        assertEquals(BidSelection.ONE_DIAMONDS, bid.getRecommendedBid());
    }

    @Test
    public void testResponseBidOfOneHeart() {
        game.setHand(createTargetedHand(11, 3, 5, 3, 2));
        bid = new Bid(BidSelection.ONE_CLUBS, game);
        System.out.println(game.getHand());

        assertEquals(BidSelection.ONE_HEARTS, bid.getRecommendedBid());
    }

    @Test
    public void testResponseBidOfOneSpade() {
        game.setHand(createTargetedHand(6, 5, 3, 3, 2));
        bid = new Bid(BidSelection.ONE_CLUBS, game);
        System.out.println(game.getHand());

        assertEquals(BidSelection.ONE_SPADES, bid.getRecommendedBid());
    }

    @Test
    public void testResponseBidOfOneNT() {
        game.setHand(createTargetedHand(6, 4, 4, 3, 2));
        bid = new Bid(BidSelection.ONE_CLUBS, game);
        System.out.println(game.getHand());

        assertEquals(BidSelection.ONE_NO_TRUMPS, bid.getRecommendedBid());
    }

    @Test
    public void testResponseBidOfTwoClub() {
        game.setHand(createTargetedHand(10, 2, 3, 3, 5));
        bid = new Bid(BidSelection.ONE_CLUBS, game);
        System.out.println(game.getHand());

        assertEquals(BidSelection.TWO_CLUBS, bid.getRecommendedBid());
    }

    @Test
    public void testResponseBidOfTwoDiamonds() {
        game.setHand(createTargetedHand(10, 2, 3, 6, 2));
        bid = new Bid(BidSelection.ONE_CLUBS, game);
        System.out.println(game.getHand());

        assertEquals(BidSelection.TWO_DIAMOND, bid.getRecommendedBid());
    }

    @Test
    public void testResponseBidOfTwoHearts() {
        game.setHand(createTargetedHand(10, 2, 6, 4, 1));
        bid = new Bid(BidSelection.ONE_CLUBS, game);
        System.out.println(game.getHand());

        assertEquals(BidSelection.TWO_HEARTS, bid.getRecommendedBid());
    }

    @Test
    public void testResponseBidOfTwoSpades() {
        game.setHand(createTargetedHand(10, 6, 4, 2, 1));
        bid = new Bid(BidSelection.ONE_CLUBS, game);
        System.out.println(game.getHand());

        assertEquals(BidSelection.TWO_SPADES, bid.getRecommendedBid());
    }

    @Test
    public void testResponseBidOfTwoNT() {
        game.setHand(createTargetedHand(13, 6, 4, 2, 1));
        bid = new Bid(BidSelection.ONE_CLUBS, game);
        System.out.println(game.getHand());

        assertEquals(BidSelection.TWO_SPADES, bid.getRecommendedBid());
    }
}
