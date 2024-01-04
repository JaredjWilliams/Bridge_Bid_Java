package com.example.bridge_bid_app_java.partner_open;

import static com.example.bridge_bid_app_java.utils.TargetHandGenerator.createTargetedHand;
import static org.junit.Assert.assertEquals;

import com.example.bridge_bid_app_java.bids.BidGenerator;
import com.example.bridge_bid_app_java.game.BidSelection;
import com.example.bridge_bid_app_java.game.Game;
import com.example.bridge_bid_app_java.game.Player;

import org.junit.Before;
import org.junit.Test;

public class ResponseToTwoNTTests {

    private Game game;
    private BidGenerator bidGenerator;

    @Before
    public void setUp() {
        game = new Game();
        game.setOpener(Player.PARTNER);
        Player.PARTNER.addToBidHistory(BidSelection.TWO_NO_TRUMP);
        game.addBidToHistory(BidSelection.TWO_NO_TRUMP);
        bidGenerator = new BidGenerator(game);
    }

    @Test
    public void testThreeClubs() {
        game.setHand(createTargetedHand(4, 4, 4, 3, 2));
        bidGenerator.updateRecommendedBid(game);
        System.out.println(game.getHand());

        assertEquals(BidSelection.THREE_CLUBS, bidGenerator.getRecommendedBid());
    }

    @Test
    public void testThreeDiamonds() {
        game.setHand(createTargetedHand(4, 3, 2, 5, 3));
        bidGenerator.updateRecommendedBid(game);
        System.out.println(game.getHand());

        assertEquals(BidSelection.THREE_DIAMONDS, bidGenerator.getRecommendedBid());
    }

    @Test
    public void testThreeHearts() {
        game.setHand(createTargetedHand(4, 2, 5, 4, 2));
        bidGenerator.updateRecommendedBid(game);
        System.out.println(game.getHand());

        assertEquals(BidSelection.THREE_HEARTS, bidGenerator.getRecommendedBid());
    }

    @Test
    public void testThreeSpades() {
        game.setHand(createTargetedHand(4, 5, 2, 4, 2));
        bidGenerator.updateRecommendedBid(game);
        System.out.println(game.getHand());

        assertEquals(BidSelection.THREE_SPADES, bidGenerator.getRecommendedBid());
    }

    @Test
    public void testThreeNT() {
        game.setHand(createTargetedHand(5, 4, 4, 3, 2));
        bidGenerator.updateRecommendedBid(game);
        System.out.println(game.getHand());

        assertEquals(BidSelection.THREE_NO_TRUMP, bidGenerator.getRecommendedBid());
    }

    @Test
    public void testFourHearts() {
        game.setHand(createTargetedHand(4, 1, 6, 4, 2));
        bidGenerator.updateRecommendedBid(game);
        System.out.println(game.getHand());

        assertEquals(BidSelection.FOUR_HEARTS, bidGenerator.getRecommendedBid());
    }

    @Test
    public void testFourSpades() {
        game.setHand(createTargetedHand(4, 6, 1, 4, 2));
        bidGenerator.updateRecommendedBid(game);
        System.out.println(game.getHand());

        assertEquals(BidSelection.FOUR_SPADES, bidGenerator.getRecommendedBid());
    }

    @Test
    public void testFourNT() {
        game.setHand(createTargetedHand(9, 3, 3, 4, 3));
        bidGenerator.updateRecommendedBid(game);
        System.out.println(game.getHand());

        assertEquals(BidSelection.FOUR_NO_TRUMP, bidGenerator.getRecommendedBid());
    }

    @Test
    public void testSixNT() {
        game.setHand(createTargetedHand(11, 3, 3, 4, 3));
        bidGenerator.updateRecommendedBid(game);
        System.out.println(game.getHand());

        assertEquals(BidSelection.SIX_NO_TRUMP, bidGenerator.getRecommendedBid());
    }

    @Test
    public void testSevenNT() {
        game.setHand(createTargetedHand(15, 3, 3, 4, 3));
        bidGenerator.updateRecommendedBid(game);
        System.out.println(game.getHand());

        assertEquals(BidSelection.SEVEN_NO_TRUMP, bidGenerator.getRecommendedBid());
    }
}
