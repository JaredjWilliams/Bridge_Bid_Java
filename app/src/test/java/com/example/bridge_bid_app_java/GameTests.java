package com.example.bridge_bid_app_java;

import static org.junit.Assert.assertEquals;

import com.example.bridge_bid_app_java.game.Game;
import com.example.bridge_bid_app_java.game.Player;

import org.junit.Before;
import org.junit.Test;

public class GameTests {

    Game game;

    @Before
    public void setUp() {
        game = new Game();
    }

    @Test
    public void testNextPlayer() {
        game.setCurrentPlayer(Player.USER);
        game.updateCurrentPlayer();

        assertEquals(Player.LEFT_OPPONENT, game.getCurrentPlayer());
    }
}
