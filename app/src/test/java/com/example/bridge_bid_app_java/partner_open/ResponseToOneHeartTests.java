package com.example.bridge_bid_app_java.partner_open;

import static com.example.bridge_bid_app_java.utils.TargetHandGenerator.createTargetedHand;
import static com.example.bridge_bid_app_java.utils.TargetHandGenerator.createTargetedHandWithout;
import static org.junit.Assert.assertEquals;

import com.example.bridge_bid_app_java.bids.Bid;
import com.example.bridge_bid_app_java.game.BidSelection;
import com.example.bridge_bid_app_java.game.Game;
import com.example.bridge_bid_app_java.game.Player;
import com.example.bridge_bid_app_java.playing_cards.Card;
import com.example.bridge_bid_app_java.playing_cards.Hand;
import com.example.bridge_bid_app_java.playing_cards.Suit;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class ResponseToOneHeartTests {

    private Game game;
    private Bid bid;

    @Before
    public void setUp() {
        game = new Game();
        game.setOpener(Player.PARTNER);
    }

    @Test
    public void testOneSpade() {
        List<Card> cardsLeftOut = List.of(Card.ACE_HEARTS, Card.KING_HEARTS, Card.QUEEN_HEARTS, Card.JACK_HEARTS);
        game.setHand(createTargetedHandWithout(6, 5, 2, 3, 3, cardsLeftOut));
        bid = new Bid(BidSelection.ONE_HEARTS, game);
        System.out.println(game.getHand());

        assertEquals(BidSelection.ONE_SPADES , bid.getRecommendedBid());
    }

    @Test
    public void testOneNT() {
        List<Card> cardsLeftOut = List.of(Card.ACE_HEARTS, Card.KING_HEARTS, Card.QUEEN_HEARTS, Card.JACK_HEARTS);
        game.setHand(createTargetedHandWithout(6, 4, 2, 4, 3, cardsLeftOut));
        bid = new Bid(BidSelection.ONE_HEARTS, game);
        System.out.println(game.getHand());

        assertEquals(BidSelection.ONE_NO_TRUMPS, bid.getRecommendedBid());
    }

    @Test
    public void testTwoClubs() {
        List<Card> cardsLeftOut = List.of(Card.ACE_HEARTS, Card.KING_HEARTS, Card.QUEEN_HEARTS, Card.JACK_HEARTS);
        game.setHand(createTargetedHandWithout(10, 3, 2, 2, 6, cardsLeftOut));
        bid = new Bid(BidSelection.ONE_HEARTS, game);
        System.out.println(game.getHand());

        assertEquals(BidSelection.TWO_CLUBS, bid.getRecommendedBid());
    }

    @Test
    public void testTwoDiamonds() {
        List<Card> cardsLeftOut = List.of(Card.ACE_HEARTS, Card.KING_HEARTS, Card.QUEEN_HEARTS, Card.JACK_HEARTS);
        game.setHand(createTargetedHandWithout(10, 3, 2, 6, 2, cardsLeftOut));
        bid = new Bid(BidSelection.ONE_HEARTS, game);
        System.out.println(game.getHand());

        assertEquals(BidSelection.TWO_DIAMOND, bid.getRecommendedBid());
    }

    @Test
    public void testTwoHearts() {
        game.setHand(createTargetedHand(6, 3, 3, 4, 3));
        bid = new Bid(BidSelection.ONE_HEARTS, game);
        System.out.println(game.getHand());

        assertEquals(BidSelection.TWO_HEARTS, bid.getRecommendedBid());
    }

    @Test
    public void testTwoSpades() {
        List<Card> cardsLeftOut = List.of(Card.ACE_HEARTS, Card.KING_HEARTS, Card.QUEEN_HEARTS, Card.JACK_HEARTS);
        game.setHand(createTargetedHandWithout(6, 6, 2, 2, 3, cardsLeftOut));
        bid = new Bid(BidSelection.ONE_HEARTS, game);
        System.out.println(game.getHand());

        assertEquals(BidSelection.TWO_SPADES, bid.getRecommendedBid());
    }

    @Test
    public void testTwoSpadesAlternate() {
        List<Card> cardsLeftOut = List.of(Card.ACE_HEARTS, Card.KING_HEARTS, Card.QUEEN_HEARTS, Card.JACK_HEARTS);
        game.setHand(createTargetedHandWithout(10, 5, 2, 3, 3, cardsLeftOut));
        bid = new Bid(BidSelection.ONE_HEARTS, game);
        System.out.println(game.getHand());

        assertEquals(BidSelection.TWO_SPADES, bid.getRecommendedBid());
    }

    @Test
    public void testResponseBidOfTwoNT() {
        List<Card> cardsLeftOut = List.of(Card.ACE_HEARTS, Card.KING_HEARTS, Card.QUEEN_HEARTS, Card.JACK_HEARTS);
        List<Card> cardsIncluded = List.of(Card.ACE_CLUBS, Card.KING_DIAMONDS);

        Hand hand = createTargetedHand(13, 4, 2, 3, 4, cardsIncluded, cardsLeftOut);

        game.setHand(hand);
        game.updateUnbidSuitsBidsForAll(List.of(Suit.HEARTS, Suit.SPADES));
        bid = new Bid(BidSelection.ONE_HEARTS, game);

        System.out.println(game.getHand());

        assertEquals(BidSelection.TWO_NO_TRUMP, bid.getRecommendedBid());
    }

    @Test
    public void testResponseBidThreeClubs() {
        List<Card> cardsLeftOut = List.of(Card.ACE_HEARTS, Card.KING_HEARTS, Card.QUEEN_HEARTS, Card.JACK_HEARTS);

        game.setHand(createTargetedHandWithout(10, 2, 2, 2, 7, cardsLeftOut));

        bid = new Bid(BidSelection.ONE_HEARTS, game);
        System.out.println(game.getHand());

        assertEquals(BidSelection.THREE_CLUBS, bid.getRecommendedBid());
    }

    @Test
    public void testResponseBidThreeDiamonds() {
        List<Card> cardsLeftOut = List.of(Card.ACE_HEARTS, Card.KING_HEARTS, Card.QUEEN_HEARTS, Card.JACK_HEARTS);

        game.setHand(createTargetedHandWithout(10, 2, 2, 7, 2, cardsLeftOut));
        bid = new Bid(BidSelection.ONE_HEARTS, game);
        System.out.println(game.getHand());

        assertEquals(BidSelection.THREE_DIAMONDS, bid.getRecommendedBid());
    }

    @Test
    public void testResponseBidThreeHearts() {

        game.setHand(createTargetedHand(13, 4, 3, 3, 3));
        bid = new Bid(BidSelection.ONE_HEARTS, game);
        System.out.println(game.getHand());

        assertEquals(BidSelection.THREE_HEARTS, bid.getRecommendedBid());
    }

    @Test
    public void testResponseBidThreeSpades() {
        game.setHand(createTargetedHand(10, 7, 2, 3, 1));
        bid = new Bid(BidSelection.ONE_HEARTS, game);
        System.out.println(game.getHand());

        assertEquals(BidSelection.THREE_SPADES, bid.getRecommendedBid());
    }

    @Test
    public void testResponseBidThreeNT() {
        game.setHand(createTargetedHand(16, 3, 2, 4, 4));
        bid = new Bid(BidSelection.ONE_HEARTS, game);
        System.out.println(game.getHand());

        assertEquals(BidSelection.THREE_NO_TRUMP, bid.getRecommendedBid());
    }

    @Test
    public void testResponseBidFourHearts() {
        game.setHand(createTargetedHand(10, 3, 5, 3, 2));
        bid = new Bid(BidSelection.ONE_HEARTS, game);
        System.out.println(game.getHand());

        assertEquals(BidSelection.FOUR_HEARTS, bid.getRecommendedBid());
    }

    @Test
    public void testResponseBidFourSpades() {
        game.setHand(createTargetedHand(10, 8, 2, 2, 1));
        bid = new Bid(BidSelection.ONE_HEARTS, game);
        System.out.println(game.getHand());

        assertEquals(BidSelection.FOUR_SPADES, bid.getRecommendedBid());
    }

    @Test
    public void testResponseBidFiveClubs() {
        game.setHand(createTargetedHand(13, 2, 2, 1, 8));
        bid = new Bid(BidSelection.ONE_HEARTS, game);
        System.out.println(game.getHand());

        assertEquals(BidSelection.FIVE_CLUBS, bid.getRecommendedBid());
    }

    @Test
    public void testResponseBidFiveDiamonds() {
        game.setHand(createTargetedHand(13, 2, 2, 8, 1));
        bid = new Bid(BidSelection.ONE_HEARTS, game);
        System.out.println(game.getHand());

        assertEquals(BidSelection.FIVE_DIAMONDS, bid.getRecommendedBid());
    }
}
