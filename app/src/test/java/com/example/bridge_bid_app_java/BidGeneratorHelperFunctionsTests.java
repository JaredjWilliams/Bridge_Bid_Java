package com.example.bridge_bid_app_java;

import static org.junit.Assert.assertTrue;

import com.example.bridge_bid_app_java.game.Game;
import com.example.bridge_bid_app_java.playing_cards.Card;
import com.example.bridge_bid_app_java.playing_cards.Suit;
import com.example.bridge_bid_app_java.utils.BidHelperFunctions;
import com.example.bridge_bid_app_java.utils.TargetHandGenerator;

import org.junit.Test;

import java.util.List;

public class BidGeneratorHelperFunctionsTests {

    @Test
    public void testisStopperHeldInUnbidSuits() {
        Game game = new Game();
        game.updateUnbidSuitsBid(Suit.CLUBS);
        game.updateUnbidSuitsBid(Suit.SPADES);
        game.setHand(TargetHandGenerator.createTargetedHand(11, 3, 3, 4, 3, List.of(Card.ACE_DIAMONDS, Card.ACE_HEARTS)));
        BidHelperFunctions.setGame(game);
        assertTrue(BidHelperFunctions.isStopperHeldInUnbidSuits());
    }

}
