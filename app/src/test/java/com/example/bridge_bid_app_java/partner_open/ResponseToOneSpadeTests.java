package com.example.bridge_bid_app_java.partner_open;

import static com.example.bridge_bid_app_java.utils.TargetHandGenerator.createTargetedHand;
import static com.example.bridge_bid_app_java.utils.TargetHandGenerator.createTargetedHandWith;
import static org.junit.Assert.assertEquals;

import com.example.bridge_bid_app_java.bids.BidGenerator;
import com.example.bridge_bid_app_java.game.BidSelection;
import com.example.bridge_bid_app_java.game.Game;
import com.example.bridge_bid_app_java.game.Player;
import com.example.bridge_bid_app_java.playing_cards.Card;
import com.example.bridge_bid_app_java.playing_cards.Hand;
import com.example.bridge_bid_app_java.playing_cards.Suit;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class ResponseToOneSpadeTests {

    private Game game;
    private BidGenerator bidGenerator;

    @Before
    public void setUp() {
        game = new Game();
        game.setOpener(Player.PARTNER);
        Player.PARTNER.addToBidHistory(BidSelection.ONE_SPADE);
        game.addBidToHistory(BidSelection.ONE_SPADE);
        bidGenerator = new BidGenerator(game);
    }

    @Test
    public void testOneNT() {
        game.setHand(createTargetedHand(6, 2, 4, 4, 3));
        bidGenerator.updateRecommendedBid(game);
        System.out.println(game.getHand());

        assertEquals(BidSelection.ONE_NO_TRUMP, bidGenerator.getRecommendedBid());
    }

    @Test
    public void testTwoClubs() {
        game.setHand(createTargetedHand(10, 2, 3, 2, 6));
        bidGenerator.updateRecommendedBid(game);
        System.out.println(game.getHand());

        assertEquals(BidSelection.TWO_CLUBS, bidGenerator.getRecommendedBid());
    }

    @Test
    public void testTwoDiamonds() {
        game.setHand(createTargetedHand(10, 2, 3, 6, 2));
        bidGenerator.updateRecommendedBid(game);
        System.out.println(game.getHand());

        assertEquals(BidSelection.TWO_DIAMONDS, bidGenerator.getRecommendedBid());
    }
    // When -> 5 diamonds is held
    // And -> one_spade was bid
    // And -> less than 3 spades is held
    // Result -> two_diamonds is bid
    @Test
    public void testTwoDiamondsAlternate() {
        game.setHand(createTargetedHand(10, 2, 3, 5, 3));
        bidGenerator.updateRecommendedBid(game);
        System.out.println(game.getHand());

        assertEquals(BidSelection.TWO_DIAMONDS, bidGenerator.getRecommendedBid());
    }

    @Test
    public void testTwoHearts() {
        game.setHand(createTargetedHand(10, 2, 6, 2, 3));
        bidGenerator.updateRecommendedBid(game);
        System.out.println(game.getHand());

        assertEquals(BidSelection.TWO_HEARTS, bidGenerator.getRecommendedBid());
    }

    @Test
    public void testTwoHeartAlternate() {
        game.setHand(createTargetedHand(10, 2, 5, 3, 3));
        bidGenerator.updateRecommendedBid(game);
        System.out.println(game.getHand());

        assertEquals(BidSelection.TWO_HEARTS, bidGenerator.getRecommendedBid());
    }

    @Test
    public void testTwoSpades() {
        game.setHand(createTargetedHand(6, 3, 3, 4, 3));
        bidGenerator.updateRecommendedBid(game);
        System.out.println(game.getHand());

        assertEquals(BidSelection.TWO_SPADES, bidGenerator.getRecommendedBid());
    }

    @Test
    public void testTwoNT() {
        List<Card> cardsIncluded = List.of(Card.ACE_SPADES, Card.ACE_DIAMONDS);
        Hand hand = createTargetedHandWith(13, 2, 4, 4, 3, cardsIncluded);

        game.setHand(hand);
        game.updateBidSuitsForAll(List.of(Suit.HEARTS, Suit.CLUBS));
        bidGenerator.updateRecommendedBid(game);

        System.out.println(game.getHand());

        assertEquals(BidSelection.TWO_NO_TRUMP, bidGenerator.getRecommendedBid());
    }

    @Test
    public void testThreeClubs() {
        Hand hand = createTargetedHand(10, 2, 2, 2, 7);

        game.setHand(hand);
        bidGenerator.updateRecommendedBid(game);
        System.out.println(game.getHand());

        assertEquals(BidSelection.THREE_CLUBS, bidGenerator.getRecommendedBid());
    }

    @Test
    public void testThreeDiamonds() {
        Hand hand = createTargetedHand(10, 2, 2, 7, 2);

        game.setHand(hand);
        bidGenerator.updateRecommendedBid(game);
        System.out.println(game.getHand());

        assertEquals(BidSelection.THREE_DIAMONDS, bidGenerator.getRecommendedBid());
    }

    @Test
    public void testThreeHearts() {
        Hand hand = createTargetedHand(10, 2, 7, 2, 2);

        game.setHand(hand);
        bidGenerator.updateRecommendedBid(game);
        System.out.println(game.getHand());

        assertEquals(BidSelection.THREE_HEARTS, bidGenerator.getRecommendedBid());
    }

    @Test
    public void testThreeSpades() {
        Hand hand = createTargetedHand(13, 3, 3, 4, 3);

        game.setHand(hand);
        bidGenerator.updateRecommendedBid(game);
        System.out.println(game.getHand());

        assertEquals(BidSelection.THREE_SPADES, bidGenerator.getRecommendedBid());
    }

    @Test
    public void testThreeNT() {
        Hand hand = createTargetedHand(16, 3, 3, 4, 3);

        game.setHand(hand);
        bidGenerator.updateRecommendedBid(game);
        System.out.println(game.getHand());

        assertEquals(BidSelection.THREE_NO_TRUMP, bidGenerator.getRecommendedBid());
    }

    @Test
    public void testFourHearts() {
        Hand hand = createTargetedHand(10, 1, 8, 2, 2);

        game.setHand(hand);
        bidGenerator.updateRecommendedBid(game);
        System.out.println(game.getHand());

        assertEquals(BidSelection.FOUR_HEARTS, bidGenerator.getRecommendedBid());
    }

    @Test
    public void testFourSpades() {
        Hand hand = createTargetedHand(10, 5, 3, 3, 2);

        game.setHand(hand);
        bidGenerator.updateRecommendedBid(game);
        System.out.println(game.getHand());

        assertEquals(BidSelection.FOUR_SPADES, bidGenerator.getRecommendedBid());
    }

    @Test
    public void testFiveClubs() {
        Hand hand = createTargetedHand(13, 2,2, 1, 8);

        game.setHand(hand);
        bidGenerator.updateRecommendedBid(game);
        System.out.println(game.getHand());

        assertEquals(BidSelection.FIVE_CLUBS, bidGenerator.getRecommendedBid());
    }

    @Test
    public void testFiveDiamonds() {
        Hand hand = createTargetedHand(13, 2,2, 8, 1);

        game.setHand(hand);
        bidGenerator.updateRecommendedBid(game);
        System.out.println(game.getHand());

        assertEquals(BidSelection.FIVE_DIAMONDS, bidGenerator.getRecommendedBid());
    }
}
