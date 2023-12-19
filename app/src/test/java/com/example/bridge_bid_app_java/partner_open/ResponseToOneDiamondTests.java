package com.example.bridge_bid_app_java.partner_open;

import static com.example.bridge_bid_app_java.utils.TargetHandGenerator.createTargetedHand;
import static org.junit.Assert.assertEquals;

import com.example.bridge_bid_app_java.bids.Bid;
import com.example.bridge_bid_app_java.game.BidSelection;
import com.example.bridge_bid_app_java.game.Game;
import com.example.bridge_bid_app_java.game.Player;
import com.example.bridge_bid_app_java.playing_cards.Card;
import com.example.bridge_bid_app_java.playing_cards.Suit;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class ResponseToOneDiamondTests {

    private Game game;
    private Bid bid;

    @Before
    public void setUp() {
        game = new Game();
        game.setOpener(Player.PARTNER);
    }

    @Test
    public void testResponseBidOfOneHeart() {
        game.setHand(createTargetedHand(11, 3, 5, 3, 2));
        bid = new Bid(BidSelection.ONE_DIAMONDS, game);
        System.out.println(game.getHand());

        assertEquals(BidSelection.ONE_HEARTS, bid.getRecommendedBid());
    }

    @Test
    public void testResponseBidOfOneSpade() {
        game.setHand(createTargetedHand(6, 5, 3, 3, 2));
        bid = new Bid(BidSelection.ONE_DIAMONDS, game);
        System.out.println(game.getHand());

        assertEquals(BidSelection.ONE_SPADES, bid.getRecommendedBid());
    }

    @Test
    public void testResponseBidOfOneNT() {
        game.setHand(createTargetedHand(6, 4, 4, 3, 2));
        bid = new Bid(BidSelection.ONE_DIAMONDS, game);
        System.out.println(game.getHand());

        assertEquals(BidSelection.ONE_NO_TRUMPS, bid.getRecommendedBid());
    }

    @Test
    public void testResponseBidOfTwoClub() {
        game.setHand(createTargetedHand(10, 2, 3, 3, 5));
        bid = new Bid(BidSelection.ONE_DIAMONDS, game);
        System.out.println(game.getHand());

        assertEquals(BidSelection.TWO_CLUBS, bid.getRecommendedBid());
    }

    @Test
    public void testResponseBidOfTwoDiamonds() {
        game.setHand(createTargetedHand(10, 2, 3, 6, 2));
        bid = new Bid(BidSelection.ONE_DIAMONDS, game);
        System.out.println(game.getHand());

        assertEquals(BidSelection.TWO_DIAMOND, bid.getRecommendedBid());
    }

    @Test
    public void testResponseBidOfTwoHearts() {
        game.setHand(createTargetedHand(10, 2, 6, 4, 1));
        bid = new Bid(BidSelection.ONE_DIAMONDS, game);
        System.out.println(game.getHand());

        assertEquals(BidSelection.TWO_HEARTS, bid.getRecommendedBid());
    }

    @Test
    public void testResponseBidOfTwoSpades() {
        game.setHand(createTargetedHand(10, 6, 4, 2, 1));
        bid = new Bid(BidSelection.ONE_DIAMONDS, game);
        System.out.println(game.getHand());

        assertEquals(BidSelection.TWO_SPADES, bid.getRecommendedBid());
    }

    @Test
    public void testResponseBidOfTwoNT() {
        game.setHand(createTargetedHand(13, 6, 4, 2, 1, List.of(Card.ACE_CLUBS, Card.KING_DIAMONDS)));
        game.updateUnbidSuitsBidsForAll(List.of(Suit.HEARTS, Suit.SPADES));
        bid = new Bid(BidSelection.ONE_DIAMONDS, game);
        System.out.println(game.getHand());

        assertEquals(BidSelection.TWO_NO_TRUMP, bid.getRecommendedBid());
    }

    @Test
    public void testOneClubBidOfThreeClubs() {
        game.setHand(createTargetedHand(10, 2, 2, 2, 7));
        bid = new Bid(BidSelection.ONE_DIAMONDS, game);
        System.out.println(game.getHand());

        assertEquals(BidSelection.THREE_CLUBS, bid.getRecommendedBid());
    }

    @Test
    public void testOneClubBidOfThreeDiamonds() {
        game.setHand(createTargetedHand(10, 2, 2, 7, 2));
        bid = new Bid(BidSelection.ONE_DIAMONDS, game);
        System.out.println(game.getHand());

        assertEquals(BidSelection.THREE_DIAMONDS, bid.getRecommendedBid());
    }

    @Test
    public void testOneClubBidOfThreeHearts() {
        game.setHand(createTargetedHand(10, 2, 7, 2, 2));
        bid = new Bid(BidSelection.ONE_DIAMONDS, game);
        System.out.println(game.getHand());

        assertEquals(BidSelection.THREE_HEARTS, bid.getRecommendedBid());
    }

    @Test
    public void testOneClubBidOfThreeSpades() {
        game.setHand(createTargetedHand(10, 7, 2, 2, 2));
        bid = new Bid(BidSelection.ONE_DIAMONDS, game);
        System.out.println(game.getHand());

        assertEquals(BidSelection.THREE_SPADES, bid.getRecommendedBid());
    }

    @Test
    public void testOneClubBidOfThreeNT() {
        game.setHand(createTargetedHand(16, 3, 4, 3, 3));
        bid = new Bid(BidSelection.ONE_DIAMONDS, game);
        System.out.println(game.getHand());

        assertEquals(BidSelection.THREE_NO_TRUMP, bid.getRecommendedBid());
    }

    @Test
    public void testOneClubBidOfFiveClubs() {
        game.setHand(createTargetedHand(10, 2, 1, 2, 8));
        bid = new Bid(BidSelection.ONE_DIAMONDS, game);
        System.out.println(game.getHand());

        assertEquals(BidSelection.FIVE_CLUBS , bid.getRecommendedBid());
    }

    @Test
    public void testOneClubBidOfFiveDiamonds() {
        game.setHand(createTargetedHand(10, 2, 1, 8, 2));
        bid = new Bid(BidSelection.ONE_DIAMONDS, game);
        System.out.println(game.getHand());

        assertEquals(BidSelection.FIVE_DIAMONDS, bid.getRecommendedBid());
    }

    @Test
    public void testOneClubBidOfFourHearts() {
        game.setHand(createTargetedHand(10, 2, 8, 1, 2));
        bid = new Bid(BidSelection.ONE_DIAMONDS, game);
        System.out.println(game.getHand());

        assertEquals(BidSelection.FOUR_HEARTS, bid.getRecommendedBid());
    }

    @Test
    public void testOneClubBidOfFourSpades() {
        game.setHand(createTargetedHand(16, 8, 2, 1, 2));
        bid = new Bid(BidSelection.ONE_DIAMONDS, game);
        System.out.println(game.getHand());

        assertEquals(BidSelection.FOUR_SPADES, bid.getRecommendedBid());
    }
}
