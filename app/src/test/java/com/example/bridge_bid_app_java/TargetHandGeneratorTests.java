package com.example.bridge_bid_app_java;

import static com.example.bridge_bid_app_java.utils.TargetHandGenerator.createTargetedHandWithTargetedQuickTricks;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import com.example.bridge_bid_app_java.playing_cards.Card;
import com.example.bridge_bid_app_java.playing_cards.Hand;
import com.example.bridge_bid_app_java.utils.TargetHandGenerator;

import org.junit.Test;

import java.util.List;

public class TargetHandGeneratorTests {

    @Test
    public void testCreateTargetedHandWithPreselectedCards() {
        Hand hand = TargetHandGenerator.createTargetedHandWith(11, 3, 3, 4, 3, List.of(Card.ACE_DIAMONDS, Card.ACE_HEARTS));

        assertEquals(11, hand.getTotalPointCount());
        assertEquals(3, hand.getSpades());
        assertEquals(3, hand.getHearts());
        assertEquals(4, hand.getDiamonds());
        assertEquals(3, hand.getClubs());
        assertTrue(hand.getCards().contains(Card.ACE_HEARTS));
        assertTrue(hand.getCards().contains(Card.ACE_DIAMONDS));
    }

    @Test
    public void testCreateTargetHandWithPointsAndCardCount() {
        Hand hand = TargetHandGenerator.createTargetedHand(11, 3, 3, 4, 3);

        assertEquals(11, hand.getTotalPointCount());
        assertEquals(3, hand.getSpades());
        assertEquals(3, hand.getHearts());
        assertEquals(4, hand.getDiamonds());
        assertEquals(3, hand.getClubs());
    }

    @Test
    public void testCreateTargetedHandWithAndWithout() {
        Hand hand = TargetHandGenerator.createTargetedHandWithAndWithout(11, 5, 3, 3, 2,
                List.of(Card.ACE_SPADES, Card.KING_SPADES), List.of(Card.QUEEN_SPADES, Card.JACK_SPADES, Card.TEN_SPADES));

        assertEquals(11, hand.getTotalPointCount());
        assertEquals(5, hand.getSpades());
        assertEquals(3, hand.getHearts());
        assertEquals(3, hand.getDiamonds());
        assertEquals(2, hand.getClubs());
        assertTrue(hand.getCards().contains(Card.ACE_SPADES));
        assertTrue(hand.getCards().contains(Card.KING_SPADES));
        assertFalse(hand.getCards().contains(Card.QUEEN_SPADES));
        assertFalse(hand.getCards().contains(Card.JACK_SPADES));
        assertFalse(hand.getCards().contains(Card.TEN_SPADES));
    }

    @Test
    public void testCreateTargetedHandWithTargetedQuickTricks() {
        Hand hand = createTargetedHandWithTargetedQuickTricks(5, 5, 3, 4, 1);

        assertEquals(5, hand.getQuickTricks(), 0);
        assertEquals(5, hand.getSpades());
        assertEquals(3, hand.getHearts());
        assertEquals(4, hand.getDiamonds());
        assertEquals(1, hand.getClubs());
    }
}
