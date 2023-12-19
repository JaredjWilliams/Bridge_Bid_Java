package com.example.bridge_bid_app_java;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import com.example.bridge_bid_app_java.playing_cards.Card;
import com.example.bridge_bid_app_java.playing_cards.Hand;
import com.example.bridge_bid_app_java.utils.TargetHandGenerator;

import org.junit.Test;

import java.util.List;

public class TargetHandGeneratorTests {

    @Test
    public void testCreateTargetedHandWithPreselectedCards() {
        Hand hand = TargetHandGenerator.createTargetedHand(11, 3, 3, 4, 3, List.of(Card.ACE_DIAMONDS, Card.ACE_HEARTS));

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
}
