package com.example.bridge_bid_app_java;

import static com.example.bridge_bid_app_java.utils.TargetHandGenerator.createTargetedHandWith;
import static com.example.bridge_bid_app_java.utils.TargetHandGenerator.createTargetedHandWithAndWithout;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import com.example.bridge_bid_app_java.playing_cards.Card;
import com.example.bridge_bid_app_java.playing_cards.Hand;
import com.example.bridge_bid_app_java.playing_cards.Suit;

import org.junit.Test;

import java.util.List;
import java.util.stream.Stream;

public class HandTests {

    List<Card> cards = List.of(Card.TWO_CLUBS, Card.THREE_CLUBS, Card.FOUR_CLUBS, Card.FIVE_CLUBS);
    List<Card> mockHighCardPoints = List.of(Card.ACE_CLUBS, Card.JACK_CLUBS, Card.QUEEN_CLUBS);
    List<Card> mockFullHand = List.of(Card.FOUR_DIAMONDS, Card.TWO_HEARTS, Card.SIX_HEARTS, Card.ACE_DIAMONDS,
            Card.KING_HEARTS, Card.TEN_HEARTS, Card.THREE_SPADES, Card.NINE_DIAMONDS, Card.THREE_CLUBS,
            Card.JACK_SPADES, Card.QUEEN_DIAMONDS, Card.SIX_DIAMONDS, Card.FIVE_CLUBS);


    // The card passed as the parameter is added to the hand.
    @Test
    public void testAddCard() {
        Hand hand = new Hand(cards);
        hand.addCard(Card.SEVEN_CLUBS);

        assertTrue(hand.getCards().contains(Card.SEVEN_CLUBS));
    }

    // The card passed as the parameter is removed from the hand.
    @Test
    public void testRemoveCard() {
        Hand hand = new Hand(cards);
        hand.removeCardFromHand(Card.FIVE_CLUBS);

        assertFalse(hand.getCards().contains(Card.FIVE_CLUBS));
    }

    // When calculateHighCardPoints is called
    // It sets the highCardPoint value on the hand.
    @Test
    public void testCalculateHighCardPoints() {
        Hand hand = new Hand(mockHighCardPoints);
        hand.calculateHCP();

        assertEquals(7, hand.getHighCardPoints());
    }

    // When calculateDistributionPoints() is called
    // increments the distribution points to the amount found.

    @Test
    public void testCalculateDistributionPoints() {
        Hand hand = new Hand(mockFullHand);
        hand.calculateDistributionPoints();

        assertEquals(2, hand.getDistributionPoints());
    }

    // When calculateKings() is called
    // sets kings to the number calculated

    @Test
    public void testCalculateKings() {
        Hand hand = new Hand(mockFullHand);
        hand.calculateKings();

        assertEquals(1, hand.getKings());
    }

    // When calculateAces() is called
    // sets aces to the number calculated

    @Test
    public void testCalculateAces() {
        Hand hand = new Hand(mockFullHand);
        hand.calculateAces();

        assertEquals(1, hand.getAces());
    }


    // WHEN: A suit contains an Ace and a King
    // RESULT: The quick tricks will be incremented by 2
    @Test
    public void testCalculateQuickTricksForSuitAceAndKing() {
         Hand hand = createTargetedHandWithAndWithout(11, 5, 3, 3,
                2, List.of(Card.ACE_SPADES, Card.KING_SPADES), List.of(Card.QUEEN_SPADES, Card.JACK_SPADES, Card.TEN_SPADES));

        assertEquals(2, hand.calculateQuickTrickFor(Suit.SPADES), 0);
    }

    // WHEN: A suit contains an Ace and a Queen
    // RESULT: The quick tricks will be incremented by 1.5
    @Test
    public void testCalculateQuickTricksForSuitAceAndQueen() {
        Hand hand = createTargetedHandWithAndWithout(11, 5, 3, 3, 2,
                List.of(Card.ACE_SPADES, Card.QUEEN_SPADES), List.of(Card.KING_SPADES, Card.JACK_SPADES, Card.TEN_SPADES));

        assertEquals(1.5, hand.calculateQuickTrickFor(Suit.SPADES), 0);
    }

    // WHEN: A hand contains a stopper in a suit.
    // RESULT: The stopper amount for the suit increases.
    @Test
    public void calculateStoppers() {
        Hand hand = createTargetedHandWithAndWithout(20, 3, 3, 3, 4,
                List.of(Card.ACE_SPADES, Card.ACE_HEARTS, Card.ACE_CLUBS, Card.ACE_DIAMONDS),
                List.of(Card.KING_SPADES, Card.KING_HEARTS, Card.KING_CLUBS, Card.KING_DIAMONDS));

        int spadeCount = hand.getSpadeStoppers().get(Suit.SPADES);
        int heartCount = hand.getHeartStoppers().get(Suit.HEARTS);
        int diamondCount = hand.getDiamondStoppers().get(Suit.DIAMONDS);
        int clubCount = hand.getClubStoppers().get(Suit.CLUBS);


        assertEquals(1, spadeCount);
        assertEquals(1, heartCount);
        assertEquals(1, diamondCount);
        assertEquals(1, clubCount);
    }

    // WHEN: A hand contains a suit that is longer than 4.
    // RESULT: Adds an excess to long suit points.
    @Test
    public void testCalculateLongSuitPoints() {
        List<Card> included = List.of(Card.ACE_SPADES, Card.QUEEN_SPADES, Card.TEN_SPADES, Card.SEVEN_SPADES);
        Hand hand = createTargetedHandWith(15, 7, 5, 1, 0, included);

        int longSuitPoints = hand.getLongSuitPoints();

        assertEquals(4, longSuitPoints);
    }

    // WHEN: A hand contains the ace, king, queen, jack, ten of a suit
    // RESULT: calculates the playing tricks for that suit.
    @Test
    public void testCalculatePlayingTricks() {

        List<Double> inputList = Stream.of(7/12 ).map(this::learnByDoing).toList();



        assertEquals(5, findVertex(2, -8, 20), 0);

    }

    public double learnByDoing(int x) {
        return (Math.pow(x, 2) * -6) + (7 * x) - 1;
    }

    public double findAxisOfSymmetry(double a, double b) {
        return -b/(2 * a);
    }

    public double findVertex(double a, double b, double c) {
        return (a * Math.pow(findAxisOfSymmetry(a, b), 2) + (b * findAxisOfSymmetry(a, b)) + c);
    }



}
