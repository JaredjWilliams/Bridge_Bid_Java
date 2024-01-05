package com.example.bridge_bid_app_java;

import static org.junit.Assert.assertFalse;

import com.example.bridge_bid_app_java.game.BidSelection;
import com.example.bridge_bid_app_java.game.Game;
import com.example.bridge_bid_app_java.game.Player;

import org.junit.Test;

import java.util.List;

public class PlayerTests {


    // WHEN: A bid is selected in response to partner bid.
    // AND: The partner of the current player has opened
    // RESULT: Player open variable remains false.
    @Test
    public void testPlayerResponseToOpenDoesNotOpen() {
        Game game = new Game();

        Player.USER.setOpened(true);

        game.addBidToHistory(BidSelection.ONE_CLUB);

        game.addAllToBidHistory(
                List.of(BidSelection.PASS,
                        BidSelection.ONE_HEART)
        );
        game.setCurrentPlayer(Player.PARTNER);
        Player.PARTNER.setOpened(game);

        assertFalse(Player.PARTNER.getOpened());
    }

    // WHEN: A bid is selected.
    // AND: The bid history length is greater than 5.
    // RESULT: Bid selection does not result in Player opening.
    @Test
    public void testPlayerOpenFalseWhenBidHxGreaterThan4() {
        Game game = new Game();
        game.addAllToBidHistory(
                List.of(
                        BidSelection.ONE_CLUB,
                        BidSelection.PASS,
                        BidSelection.PASS,
                        BidSelection.PASS,
                        BidSelection.PASS
                )
        );

        Player.PARTNER.setOpened(game);

        assertFalse(Player.PARTNER.getOpened());
    }

    // WHEN: A Pass is selected.
    // AND: Game bid history is less than 5.
    // RESULT: Bid selection does not result in current player opening.
    @Test
    public void testPlayerDoesNotOpenWhenPassIsSelected() {
        Game game = new Game();
        game.addAllToBidHistory(
                List.of(BidSelection.PASS)
        );

        game.setCurrentPlayer(Player.PARTNER);
        Player.PARTNER.addToBidHistory(BidSelection.PASS);

        Player.PARTNER.setOpened(game);

        assertFalse(Player.PARTNER.getOpened());
    }
}
