package com.example.bridge_bid_app_java.partner_open;

import static com.example.bridge_bid_app_java.utils.TargetHandGenerator.createTargetedHand;
import static org.junit.Assert.assertEquals;

import com.example.bridge_bid_app_java.bids.BidGenerator;
import com.example.bridge_bid_app_java.game.BidSelection;
import com.example.bridge_bid_app_java.game.Game;
import com.example.bridge_bid_app_java.game.Player;

import org.junit.Before;
import org.junit.Test;

public class ResponseToTwoClubsTests {

    private Game game;
    private BidGenerator bidGenerator;

    @Before
    public void setUp() {
        game = new Game();
        game.addOpener(Player.PARTNER);
        Player.PARTNER.addToBidHistory(BidSelection.TWO_CLUBS);
        game.addBidToHistory(BidSelection.TWO_CLUBS);
        bidGenerator = new BidGenerator(game);
    }

    @Test
    public void testTwoDiamonds() {
        game.setHand(createTargetedHand(10, 3, 4, 5, 1));
        bidGenerator.updateRecommendedBid(game);
        System.out.println(game.getHand());

        assertEquals(BidSelection.TWO_DIAMONDS, bidGenerator.getRecommendedBid());
    }

    @Test
    public void testTwoHearts() {
        game.setHand(createTargetedHand(10, 3, 5, 4, 1));
        bidGenerator.updateRecommendedBid(game);
        System.out.println(game.getHand());

        assertEquals(BidSelection.TWO_HEARTS, bidGenerator.getRecommendedBid());
    }

    @Test
    public void testTwoSpades() {
        game.setHand(createTargetedHand(10, 5, 3, 4, 1));
        bidGenerator.updateRecommendedBid(game);
        System.out.println(game.getHand());

        assertEquals(BidSelection.TWO_SPADES, bidGenerator.getRecommendedBid());
    }

    @Test
    public void testTwoNT() {
        game.setHand(createTargetedHand(6, 5, 3, 4, 1));
        bidGenerator.updateRecommendedBid(game);
        System.out.println(game.getHand());

        assertEquals(BidSelection.TWO_NO_TRUMP, bidGenerator.getRecommendedBid());
    }

    @Test
    public void testThreeClubs() {
        game.setHand(createTargetedHand(7, 7, 3, 3, 4, 3));
        bidGenerator.updateRecommendedBid(game);
        System.out.println(game.getHand());

        assertEquals(BidSelection.THREE_CLUBS, bidGenerator.getRecommendedBid());
    }

    @Test
    public void testFiveClubs() {
        game.setHand(createTargetedHand(10, 3, 3, 4, 3));
        bidGenerator.updateRecommendedBid(game);
        System.out.println(game.getHand());

        assertEquals(BidSelection.FIVE_CLUBS, bidGenerator.getRecommendedBid());
    }
}
