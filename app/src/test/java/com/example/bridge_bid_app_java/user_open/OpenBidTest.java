package com.example.bridge_bid_app_java.user_open;

import static com.example.bridge_bid_app_java.utils.TargetHandGenerator.createTargetedHand;
import static com.example.bridge_bid_app_java.utils.TargetHandGenerator.createTargetedHandWithTargetedQuickTricks;

import static org.junit.Assert.assertEquals;

import com.example.bridge_bid_app_java.bids.BidGenerator;
import com.example.bridge_bid_app_java.game.BidSelection;
import com.example.bridge_bid_app_java.game.Game;

import org.junit.Before;
import org.junit.Test;

public class OpenBidTest {

    private Game game;
    private BidGenerator generator;

    @Before
    public void setUp() {
        game = new Game();
        generator = new BidGenerator(game);
    }

    @Test
    public void testOpenOneClub() {
        game.setHand(createTargetedHandWithTargetedQuickTricks(1, 14,  4, 4, 2, 3));
        generator.updateRecommendedBid(game);

        System.out.println(game.getHand());

        assertEquals(BidSelection.ONE_CLUB, generator.getRecommendedBid());
    }

    @Test
    public void testOpenOneDiamond() {
        game.setHand(createTargetedHandWithTargetedQuickTricks(1,14, 4, 4, 3, 2));
        generator.updateRecommendedBid(game);

        System.out.println(game.getHand());

        assertEquals(BidSelection.ONE_DIAMOND, generator.getRecommendedBid());
    }

    // WHEN: THe user has at least 5 spades.
    // AND: at least 14 points.
    // RESULT: One spade is bid.
    @Test
    public void testOpenOneSpade() {
        game.setHand(createTargetedHand(14, 5, 4, 2, 2));
        generator.updateRecommendedBid(game);

        System.out.println(game.getHand());

        assertEquals(BidSelection.ONE_SPADE, generator.getRecommendedBid());
    }

    // WHEN: The user has 2 quick tricks.
    // AND: At least 6 spades
    // AND: At least 13 points.
    // RESULT: One spade is bid.
    @Test
    public void testOpenOneSpadeQuickTricks() {
        game.setHand(createTargetedHandWithTargetedQuickTricks(2, 13, 6, 3, 2, 2));
        generator.updateRecommendedBid(game);

        System.out.println(game.getHand());

        assertEquals(BidSelection.ONE_SPADE, generator.getRecommendedBid());
    }

    // WHEN: The user has at least 5 hearts.
    // AND: At least 14 points.
    // RESULT: One heart is bid.
    @Test
    public void testOpenOneHeart() {
        game.setHand(createTargetedHand(14, 4, 5, 2, 2));
        generator.updateRecommendedBid(game);

        System.out.println(game.getHand());

        assertEquals(BidSelection.ONE_HEART, generator.getRecommendedBid());
    }

    // WHEN: The user has at least 6 hearts.
    // AND: 2 Quick Tricks.
    // AND: At least 13 points.
    // RESULT: One heart is bid.
    @Test
    public void testOpenOneHeartAlt() {
        game.setHand(createTargetedHandWithTargetedQuickTricks(2, 13, 3, 6, 2, 2));
        generator.updateRecommendedBid(game);

        System.out.println(game.getHand());

        assertEquals(BidSelection.ONE_HEART, generator.getRecommendedBid());
    }

    // WHEN: The user has a 4432 or 4441 split
    // AND: High card points is greater than or equal to 15
    // RESULT: One NT is bid.
    @Test
    public void testOneOneNT() {
        game.setHand(createTargetedHand(17, 15, 4, 4, 4, 1));
        generator.updateRecommendedBid(game);

        System.out.println(game.getHand());

        assertEquals(BidSelection.ONE_NO_TRUMP, generator.getRecommendedBid());
    }

    // WHEN: The user has 4 quick tricks
    // AND: At least 5 clubs
    // RESULT: Open with 2 clubs
    @Test
    public void testTwoClubs() {
        game.setHand(createTargetedHandWithTargetedQuickTricks(4, 16, 3, 4, 1, 5));
        generator.updateRecommendedBid(game);

        System.out.println(game.getHand());

        assertEquals(BidSelection.TWO_CLUBS, generator.getRecommendedBid());
    }

    // WHEN: The user has 4 quick tricks
    // AND: At least 5 diamonds
    // RESULT: Open with 2 diamonds
    @Test
    public void testTwoDiamonds() {
        game.setHand(createTargetedHandWithTargetedQuickTricks(4, 16, 3, 4, 5, 1));
        generator.updateRecommendedBid(game);

        System.out.println(game.getHand());

        assertEquals(BidSelection.TWO_DIAMONDS, generator.getRecommendedBid());
    }

    // WHEN: The user has 4 quick tricks
    // AND: At least 5 hearts
    // RESULT: Open with 2 hearts
    @Test
    public void testTwoHearts() {
        game.setHand(createTargetedHandWithTargetedQuickTricks(4, 16, 3, 5, 4, 1));
        generator.updateRecommendedBid(game);

        System.out.println(game.getHand());

        assertEquals(BidSelection.TWO_HEARTS, generator.getRecommendedBid());
    }

    // WHEN: The user has 4 quick tricks
    // AND: At least 5 spades
    // RESULT: Open with 2 spades
    @Test
    public void testTwoSpades() {
        game.setHand(createTargetedHandWithTargetedQuickTricks(4, 16, 5, 3, 4, 1));
        generator.updateRecommendedBid(game);

        System.out.println(game.getHand());

        assertEquals(BidSelection.TWO_SPADES, generator.getRecommendedBid());
    }
}
