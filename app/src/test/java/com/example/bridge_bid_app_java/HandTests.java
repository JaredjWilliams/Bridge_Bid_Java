package com.example.bridge_bid_app_java;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import com.example.bridge_bid_app_java.playing_cards.Card;
import com.example.bridge_bid_app_java.playing_cards.Hand;

import org.junit.Test;

import java.util.HashSet;
import java.util.List;

public class HandTests {

    List<Card> cards = List.of(Card.TWO_CLUBS, Card.THREE_CLUBS, Card.FOUR_CLUBS, Card.FIVE_CLUBS);
    List<Card> mockHighCardPoints = List.of(Card.ACE_CLUBS, Card.JACK_CLUBS, Card.QUEEN_CLUBS);
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
}
