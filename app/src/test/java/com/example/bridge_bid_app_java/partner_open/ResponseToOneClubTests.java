package com.example.bridge_bid_app_java.partner_open;

import static com.example.bridge_bid_app_java.utils.TargetHandGenerator.createTargetedHand;
import static com.example.bridge_bid_app_java.utils.TargetHandGenerator.createTargetedHandWith;
import static org.junit.Assert.assertEquals;

import com.example.bridge_bid_app_java.bids.BidGenerator;
import com.example.bridge_bid_app_java.game.BidSelection;
import com.example.bridge_bid_app_java.game.Game;
import com.example.bridge_bid_app_java.game.Player;
import com.example.bridge_bid_app_java.playing_cards.Card;
import com.example.bridge_bid_app_java.playing_cards.Suit;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class ResponseToOneClubTests {

    private Game game;
    private BidGenerator bidGenerator;

    @Before
    public void setUp() {
        game = new Game();
        game.addOpener(Player.PARTNER);
        Player.PARTNER.addToBidHistory(BidSelection.ONE_CLUB);
        game.addBidToHistory(BidSelection.ONE_CLUB);
        bidGenerator = new BidGenerator(game);
    }

    @Test
    public void testResponseBidOfOneDiamond() {
        game.setHand(createTargetedHand(6, 3, 4, 5, 1));
        bidGenerator.updateRecommendedBid(game);
        System.out.println(game.getHand());

        assertEquals(BidSelection.ONE_DIAMOND, bidGenerator.getRecommendedBid());
    }

    @Test
    public void testResponseBidOfOneDiamondWith4Diamonds() {
        game.setHand(createTargetedHand(6, 3, 4, 4, 2));
        bidGenerator.updateRecommendedBid(game);
        System.out.println(game.getHand());

        assertEquals(BidSelection.ONE_DIAMOND, bidGenerator.getRecommendedBid());
    }

    @Test
    public void testResponseBidOfOneHeart() {
        game.setHand(createTargetedHand(11, 3, 5, 3, 2));
        bidGenerator.updateRecommendedBid(game);
        System.out.println(game.getHand());

        assertEquals(BidSelection.ONE_HEART, bidGenerator.getRecommendedBid());
    }

    @Test
    public void testResponseBidOfOneSpade() {
        game.setHand(createTargetedHand(6, 5, 3, 3, 2));
        bidGenerator.updateRecommendedBid(game);
        System.out.println(game.getHand());

        assertEquals(BidSelection.ONE_SPADE, bidGenerator.getRecommendedBid());
    }

    @Test
    public void testResponseBidOfOneNT() {
        game.setHand(createTargetedHand(6, 4, 4, 3, 2));
        bidGenerator.updateRecommendedBid(game);
        System.out.println(game.getHand());

        assertEquals(BidSelection.ONE_NO_TRUMP, bidGenerator.getRecommendedBid());
    }

    @Test
    public void testResponseBidOfTwoClub() {
        game.setHand(createTargetedHand(10, 2, 3, 3, 5));
        bidGenerator.updateRecommendedBid(game);
        System.out.println(game.getHand());

        assertEquals(BidSelection.TWO_CLUBS, bidGenerator.getRecommendedBid());
    }

    @Test
    public void testResponseBidOfTwoDiamonds() {
        game.setHand(createTargetedHand(10, 2, 3, 6, 2));
        bidGenerator.updateRecommendedBid(game);
        System.out.println(game.getHand());

        assertEquals(BidSelection.TWO_DIAMONDS, bidGenerator.getRecommendedBid());
    }

    @Test
    public void testResponseBidOfTwoHearts() {
        game.setHand(createTargetedHand(10, 2, 6, 4, 1));
        bidGenerator.updateRecommendedBid(game);
        System.out.println(game.getHand());

        assertEquals(BidSelection.TWO_HEARTS, bidGenerator.getRecommendedBid());
    }

    @Test
    public void testResponseBidOfTwoSpades() {
        game.setHand(createTargetedHand(10, 6, 4, 2, 1));
        bidGenerator.updateRecommendedBid(game);
        System.out.println(game.getHand());

        assertEquals(BidSelection.TWO_SPADES, bidGenerator.getRecommendedBid());
    }

    @Test
    public void testResponseBidOfTwoNT() {
        game.setHand(createTargetedHandWith(13, 6, 4, 2, 1, List.of(Card.ACE_CLUBS, Card.KING_DIAMONDS)));
        game.updateBidSuitsForAll(List.of(Suit.HEARTS, Suit.SPADES));
        bidGenerator.updateRecommendedBid(game);
        System.out.println(game.getHand());

        assertEquals(BidSelection.TWO_NO_TRUMP, bidGenerator.getRecommendedBid());
    }

    @Test
    public void testOneClubBidOfThreeClubs() {
        game.setHand(createTargetedHand(10, 2, 2, 2, 7));
        bidGenerator.updateRecommendedBid(game);
        System.out.println(game.getHand());

        assertEquals(BidSelection.THREE_CLUBS, bidGenerator.getRecommendedBid());
    }

    @Test
    public void testOneClubBidOfThreeDiamonds() {
        game.setHand(createTargetedHand(10, 2, 2, 7, 2));
        bidGenerator.updateRecommendedBid(game);
        System.out.println(game.getHand());

        assertEquals(BidSelection.THREE_DIAMONDS, bidGenerator.getRecommendedBid());
    }

    @Test
    public void testOneClubBidOfThreeHearts() {
        game.setHand(createTargetedHand(10, 2, 7, 2, 2));
        bidGenerator.updateRecommendedBid(game);
        System.out.println(game.getHand());

        assertEquals(BidSelection.THREE_HEARTS, bidGenerator.getRecommendedBid());
    }

    @Test
    public void testOneClubBidOfThreeSpades() {
        game.setHand(createTargetedHand(10, 7, 2, 2, 2));
        bidGenerator.updateRecommendedBid(game);
        System.out.println(game.getHand());

        assertEquals(BidSelection.THREE_SPADES, bidGenerator.getRecommendedBid());
    }

    @Test
    public void testOneClubBidOfThreeNT() {
        game.setHand(createTargetedHand(16, 3, 4, 3, 3));
        bidGenerator.updateRecommendedBid(game);
        System.out.println(game.getHand());

        assertEquals(BidSelection.THREE_NO_TRUMP, bidGenerator.getRecommendedBid());
    }

    @Test
    public void testOneClubBidOfFiveClubs() {
        game.setHand(createTargetedHand(10, 2, 1, 2, 8));
        bidGenerator.updateRecommendedBid(game);
        System.out.println(game.getHand());

        assertEquals(BidSelection.FIVE_CLUBS , bidGenerator.getRecommendedBid());
    }

    @Test
    public void testOneClubBidOfFiveDiamonds() {
        game.setHand(createTargetedHand(10, 2, 1, 8, 2));
        bidGenerator.updateRecommendedBid(game);
        System.out.println(game.getHand());

        assertEquals(BidSelection.FIVE_DIAMONDS, bidGenerator.getRecommendedBid());
    }

    @Test
    public void testOneClubBidOfFourHearts() {
        game.setHand(createTargetedHand(10, 2, 8, 1, 2));
        bidGenerator.updateRecommendedBid(game);
        System.out.println(game.getHand());

        assertEquals(BidSelection.FOUR_HEARTS, bidGenerator.getRecommendedBid());
    }

    @Test
    public void testOneClubBidOfFourSpades() {
        game.setHand(createTargetedHand(16, 8, 2, 1, 2));
        bidGenerator.updateRecommendedBid(game);
        System.out.println(game.getHand());

        assertEquals(BidSelection.FOUR_SPADES, bidGenerator.getRecommendedBid());
    }
}
