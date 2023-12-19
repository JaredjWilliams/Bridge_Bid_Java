package com.example.bridge_bid_app_java.partner_open;

import static com.example.bridge_bid_app_java.utils.TargetHandGenerator.createTargetedHand;
import static com.example.bridge_bid_app_java.utils.TargetHandGenerator.createTargetedHandWithout;
import static org.junit.Assert.assertEquals;

import com.example.bridge_bid_app_java.bids.Bid;
import com.example.bridge_bid_app_java.game.BidSelection;
import com.example.bridge_bid_app_java.game.Game;
import com.example.bridge_bid_app_java.game.Player;
import com.example.bridge_bid_app_java.playing_cards.Card;

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
        game.setHand(createTargetedHandWithout(6, 5, 1, 3, 4, cardsLeftOut));
        bid = new Bid(BidSelection.ONE_HEARTS, game);
        System.out.println(game.getHand());

        assertEquals(BidSelection.ONE_SPADES , bid.getRecommendedBid());
    }

    @Test
    public void testOneNT() {
        List<Card> cardsLeftOut = List.of(Card.ACE_HEARTS, Card.KING_HEARTS, Card.QUEEN_HEARTS, Card.JACK_HEARTS);
        game.setHand(createTargetedHandWithout(6, 4, 1, 4, 4, cardsLeftOut));
        bid = new Bid(BidSelection.ONE_HEARTS, game);
        System.out.println(game.getHand());

        assertEquals(BidSelection.ONE_NO_TRUMPS, bid.getRecommendedBid());
    }

    @Test
    public void testTwoClubs() {
        List<Card> cardsLeftOut = List.of(Card.ACE_HEARTS, Card.KING_HEARTS, Card.QUEEN_HEARTS, Card.JACK_HEARTS);
        game.setHand(createTargetedHandWithout(10, 3, 1, 3, 6, cardsLeftOut));
        bid = new Bid(BidSelection.ONE_HEARTS, game);
        System.out.println(game.getHand());

        assertEquals(BidSelection.TWO_CLUBS, bid.getRecommendedBid());
    }

    @Test
    public void testTwoDiamonds() {
        List<Card> cardsLeftOut = List.of(Card.ACE_HEARTS, Card.KING_HEARTS, Card.QUEEN_HEARTS, Card.JACK_HEARTS);
        game.setHand(createTargetedHandWithout(10, 3, 1, 6, 3, cardsLeftOut));
        bid = new Bid(BidSelection.ONE_HEARTS, game);
        System.out.println(game.getHand());

        assertEquals(BidSelection.TWO_DIAMOND, bid.getRecommendedBid());
    }

    @Test
    public void testTwoHearts() {
        List<Card> preselected = List.of(Card.JACK_HEARTS, Card.QUEEN_HEARTS);
        game.setHand(createTargetedHand(6, 3, 2, 4, 4, preselected));
        bid = new Bid(BidSelection.ONE_HEARTS, game);
        System.out.println(game.getHand());

        assertEquals(BidSelection.TWO_HEARTS, bid.getRecommendedBid());
    }

    @Test
    public void testTwoSpades() {
        List<Card> cardsLeftOut = List.of(Card.ACE_HEARTS, Card.KING_HEARTS, Card.QUEEN_HEARTS, Card.JACK_HEARTS);
        game.setHand(createTargetedHandWithout(6, 6, 1, 3, 3, cardsLeftOut));
        bid = new Bid(BidSelection.ONE_HEARTS, game);
        System.out.println(game.getHand());

        assertEquals(BidSelection.TWO_SPADES, bid.getRecommendedBid());
    }

    @Test
    public void testTwoSpadesAlternate() {
        List<Card> cardsLeftOut = List.of(Card.ACE_HEARTS, Card.KING_HEARTS, Card.QUEEN_HEARTS, Card.JACK_HEARTS);
        game.setHand(createTargetedHandWithout(10, 5, 1, 4, 3, cardsLeftOut));
        bid = new Bid(BidSelection.ONE_HEARTS, game);
        System.out.println(game.getHand());

        assertEquals(BidSelection.TWO_SPADES, bid.getRecommendedBid());
    }

}
