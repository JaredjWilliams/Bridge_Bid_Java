package com.example.bridge_bid_app_java.partner_open;

import static com.example.bridge_bid_app_java.utils.TargetHandGenerator.createTargetedHand;
import static org.junit.Assert.assertEquals;

import com.example.bridge_bid_app_java.bids.BidGenerator;
import com.example.bridge_bid_app_java.game.BidSelection;
import com.example.bridge_bid_app_java.game.Game;
import com.example.bridge_bid_app_java.game.Player;
import com.example.bridge_bid_app_java.playing_cards.Hand;

import org.junit.Before;
import org.junit.Test;

public class ResponseToOneNTBidsTests {

    private Game game;
    private BidGenerator bidGenerator;

    @Before
    public void setUp() {
        game = new Game();
        game.setOpener(Player.PARTNER);
        bidGenerator = new BidGenerator(BidSelection.PASS, game);
    }

    @Test
    public void testTwoClubs() {
        game.setHand(createTargetedHand(8, 4, 4, 2, 3));
        bidGenerator.updateRecommendedBid(BidSelection.ONE_NO_TRUMP, game);
        System.out.println(game.getHand());

        assertEquals(BidSelection.TWO_CLUBS, bidGenerator.getRecommendedBid());
    }

    @Test
    public void testTwoClubsAlternate() {
        game.setHand(createTargetedHand(7, 2, 3, 2, 6));
        bidGenerator.updateRecommendedBid(BidSelection.ONE_NO_TRUMP, game);
        System.out.println(game.getHand());

        assertEquals(BidSelection.TWO_CLUBS, bidGenerator.getRecommendedBid());
    }

    @Test
    public void testTwoDiamonds() {
        game.setHand(createTargetedHand(7, 3, 3, 5, 2));
        bidGenerator.updateRecommendedBid(BidSelection.ONE_NO_TRUMP, game);
        System.out.println(game.getHand());

        assertEquals(BidSelection.TWO_DIAMONDS, bidGenerator.getRecommendedBid());
    }

    @Test
    public void testTwoHearts() {
        game.setHand(createTargetedHand(7, 2, 5, 3, 3));
        bidGenerator.updateRecommendedBid(BidSelection.ONE_NO_TRUMP, game);
        System.out.println(game.getHand());

        assertEquals(BidSelection.TWO_HEARTS, bidGenerator.getRecommendedBid());
    }

    @Test
    public void testTwoSpades() {
        game.setHand(createTargetedHand(7, 5, 4, 2, 2));
        bidGenerator.updateRecommendedBid(BidSelection.ONE_NO_TRUMP, game);
        System.out.println(game.getHand());

        assertEquals(BidSelection.TWO_SPADES, bidGenerator.getRecommendedBid());
    }

    @Test
    public void testTwoNT() {
        game.setHand(createTargetedHand(8, 3, 3, 4, 3));
        bidGenerator.updateRecommendedBid(BidSelection.ONE_NO_TRUMP, game);
        System.out.println(game.getHand());

        assertEquals(BidSelection.TWO_NO_TRUMP, bidGenerator.getRecommendedBid());
    }

    @Test
    public void testThreeClubs() {
        game.setHand(createTargetedHand(10, 2, 2, 2, 7));
        bidGenerator.updateRecommendedBid(BidSelection.ONE_NO_TRUMP, game);
        System.out.println(game.getHand());

        assertEquals(BidSelection.THREE_CLUBS, bidGenerator.getRecommendedBid());
    }

    @Test
    public void testThreeDiamonds() {
        Hand hand = createTargetedHand(10, 2, 2, 7, 2);
        game.setHand(hand);
        bidGenerator.updateRecommendedBid(BidSelection.ONE_NO_TRUMP, game);
        System.out.println(game.getHand());

        assertEquals(BidSelection.THREE_DIAMONDS, bidGenerator.getRecommendedBid());
    }

    @Test
    public void testThreeHearts() {
        Hand hand = createTargetedHand(10, 2, 5, 4, 2);

        game.setHand(hand);
        bidGenerator.updateRecommendedBid(BidSelection.ONE_NO_TRUMP, game);
        System.out.println(game.getHand());

        assertEquals(BidSelection.THREE_HEARTS, bidGenerator.getRecommendedBid());
    }

    @Test
    public void testThreeSpades() {
        Hand hand = createTargetedHand(10, 5, 2, 3, 3);

        game.setHand(hand);
        bidGenerator.updateRecommendedBid(BidSelection.ONE_NO_TRUMP, game);
        System.out.println(game.getHand());

        assertEquals(BidSelection.THREE_SPADES, bidGenerator.getRecommendedBid());
    }

    @Test
    public void testThreeNT() {
        Hand hand = createTargetedHand(10, 3, 3, 4, 3);

        game.setHand(hand);
        bidGenerator.updateRecommendedBid(BidSelection.ONE_NO_TRUMP, game);
        System.out.println(game.getHand());

        assertEquals(BidSelection.THREE_NO_TRUMP, bidGenerator.getRecommendedBid());
    }

    @Test
    public void testFourHearts() {
        Hand hand = createTargetedHand(7, 3, 6, 2, 2);

        game.setHand(hand);
        bidGenerator.updateRecommendedBid(BidSelection.ONE_NO_TRUMP, game);
        System.out.println(game.getHand());

        assertEquals(BidSelection.FOUR_HEARTS, bidGenerator.getRecommendedBid());
    }

    @Test
    public void testFourSpades() {
        Hand hand = createTargetedHand(7, 6, 2, 3, 2);

        game.setHand(hand);
        bidGenerator.updateRecommendedBid(BidSelection.ONE_NO_TRUMP, game);
        System.out.println(game.getHand());

        assertEquals(BidSelection.FOUR_SPADES, bidGenerator.getRecommendedBid());
    }

    @Test
    public void testFiveClubs() {
        Hand hand = createTargetedHand(13, 2,2, 1, 8);

        game.setHand(hand);
        bidGenerator.updateRecommendedBid(BidSelection.ONE_NO_TRUMP, game);
        System.out.println(game.getHand());

        assertEquals(BidSelection.FIVE_CLUBS, bidGenerator.getRecommendedBid());
    }

    @Test
    public void testFiveDiamonds() {
        Hand hand = createTargetedHand(13, 2,2, 8, 1);

        game.setHand(hand);
        bidGenerator = new BidGenerator(BidSelection.ONE_NO_TRUMP, game);
        System.out.println(game.getHand());

        assertEquals(BidSelection.FIVE_DIAMONDS, bidGenerator.getRecommendedBid());
    }

}
