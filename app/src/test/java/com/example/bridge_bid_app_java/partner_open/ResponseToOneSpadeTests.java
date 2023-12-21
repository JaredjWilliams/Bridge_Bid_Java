package com.example.bridge_bid_app_java.partner_open;

import static com.example.bridge_bid_app_java.utils.TargetHandGenerator.createTargetedHand;
import static org.junit.Assert.assertEquals;

import com.example.bridge_bid_app_java.bids.Bid;
import com.example.bridge_bid_app_java.game.BidSelection;
import com.example.bridge_bid_app_java.game.Game;
import com.example.bridge_bid_app_java.game.Player;

import org.junit.Before;
import org.junit.Test;

public class ResponseToOneSpadeTests {

    private Game game;
    private Bid bid;

    @Before
    public void setUp() {
        game = new Game();
        game.setOpener(Player.PARTNER);
    }

    @Test
    public void testOneNT() {
        game.setHand(createTargetedHand(6, 2, 4, 4, 3));
        bid = new Bid(BidSelection.ONE_SPADE, game);
        System.out.println(game.getHand());

        assertEquals(BidSelection.ONE_NO_TRUMP, bid.getRecommendedBid());
    }

    @Test
    public void testTwoClubs() {
        game.setHand(createTargetedHand(10, 2, 3, 2, 6));
        bid = new Bid(BidSelection.ONE_SPADE, game);
        System.out.println(game.getHand());

        assertEquals(BidSelection.TWO_CLUBS, bid.getRecommendedBid());
    }

    @Test
    public void testTwoDiamonds() {
        game.setHand(createTargetedHand(10, 2, 3, 6, 2));
        bid = new Bid(BidSelection.ONE_SPADE, game);
        System.out.println(game.getHand());

        assertEquals(BidSelection.TWO_DIAMONDS, bid.getRecommendedBid());
    }
    // When -> 5 diamonds is held
    // And -> one_spade was bid
    // And -> less than 3 spades is held
    // Result -> two_diamonds is bid
    @Test
    public void testTwoDiamondsAlternate() {
        game.setHand(createTargetedHand(10, 2, 3, 5, 3));
        bid = new Bid(BidSelection.ONE_SPADE, game);
        System.out.println(game.getHand());

        assertEquals(BidSelection.TWO_DIAMONDS, bid.getRecommendedBid());
    }

    @Test
    public void testTwoHearts() {
        game.setHand(createTargetedHand(10, 2, 6, 2, 3));
        bid = new Bid(BidSelection.ONE_SPADE, game);
        System.out.println(game.getHand());

        assertEquals(BidSelection.TWO_HEARTS, bid.getRecommendedBid());
    }

    @Test
    public void testTwoHeartAlternate() {
        game.setHand(createTargetedHand(10, 2, 5, 3, 3));
        bid = new Bid(BidSelection.ONE_SPADE, game);
        System.out.println(game.getHand());

        assertEquals(BidSelection.TWO_HEARTS, bid.getRecommendedBid());
    }

    @Test
    public void testTwoSpades() {
        game.setHand(createTargetedHand(6, 3, 3, 4, 3));
        bid = new Bid(BidSelection.ONE_SPADE, game);
        System.out.println(game.getHand());

        assertEquals(BidSelection.TWO_SPADES, bid.getRecommendedBid());
    }

    @Test
    public void testTwoNT() {

    }
}
