package com.example.bridge_bid_app_java.presenter_tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import com.example.bridge_bid_app_java.bid_selection.BidSelectionInterface;
import com.example.bridge_bid_app_java.bid_selection.BidSelectionPresenter;
import com.example.bridge_bid_app_java.game.BidSelection;
import com.example.bridge_bid_app_java.game.Game;
import com.example.bridge_bid_app_java.game.Player;
import com.example.bridge_bid_app_java.utils.TargetHandGenerator;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

public class BidSelectionPresenterTests {


    @Mock
    BidSelectionInterface view;

    private BidSelectionPresenter presenter;

    @Before
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        presenter = new BidSelectionPresenter(view);
        presenter.setGame(new Game());

        Player.PARTNER.setOpened(false);
        Player.USER.setOpened(false);
        Player.LEFT_OPPONENT.setOpened(false);
        Player.RIGHT_OPPONENT.setOpened(false);

        presenter.getGame().resetBidHistory();
    }

    // WHEN: A bid is clicked onBidClicked is called.
    // AND: This is the first bid for the team.
    // RESULT: Updates the current players open variable.
    @Test
    public void testOnBidClickedSetPlayerOpener() {
        presenter.getGame().setCurrentPlayer(Player.PARTNER);
        presenter.onBidClicked(BidSelection.SEVEN_NO_TRUMP);

        assertTrue(presenter.getGame().getOpeners().contains(Player.PARTNER));
    }

    // WHEN: A bid is clicked onBidClicked is called
    // RESULT: Adds the clicked bid to the games bid history
    @Test
    public void testOnBidClicked() {
        presenter.getGame().setCurrentPlayer(Player.USER);
        presenter.onBidClicked(BidSelection.ONE_CLUB);

        assertEquals(BidSelection.ONE_CLUB, presenter.getGame().getLastBid());
    }

    // WHEN: A bid is clicked onBidClicked is called
    // RESULT: disabled the current bid and all others below it.
    @Test
    public void testOnBidClickedDisableBids() {
        presenter.getGame().setCurrentPlayer(Player.USER);
        presenter.onBidClicked(BidSelection.TWO_NO_TRUMP);

        assertFalse(BidSelection.ONE_CLUB.getEnabled());
    }

    // WHEN: A bid is clicked onBidClicked is called
    // RESULT: updateBidsGrid is called on view
    @Test
    public void testOnBidClickedUpdatesBidGrid() {
        presenter.getGame().setCurrentPlayer(Player.USER);
        presenter.onBidClicked(BidSelection.TWO_NO_TRUMP);

        Mockito.verify(view).updateBidGridView(true);
    }

    // WHEN: A bid is clicked onBidClicked is called
    // RESULT: sets next player to the left most player
    @Test
    public void testOnBidClickedUpdatePlayer() {
        presenter.getGame().setCurrentPlayer(Player.USER);
        presenter.onBidClicked(BidSelection.ONE_NO_TRUMP);

        Mockito.verify(view).updateCurrentPlayerText(Player.LEFT_OPPONENT.name());
    }

    // WHEN: A bid is clicked onBidClicked is called.
    // RESULT: adds the bid to the current players bid history.
    @Test
    public void testOnBidClickedAddBidToCurrentPlayerBidHistory() {
        presenter.getGame().setCurrentPlayer(Player.USER);
        presenter.onBidClicked(BidSelection.TWO_NO_TRUMP);

        BidSelection lastUserBid = Player.USER.getLastBid();

        assertEquals(BidSelection.TWO_NO_TRUMP, lastUserBid);
    }

    // WHEN: A bid is clicked onBidClicked is called.
    // AND: This is the second bid.
    // AND: The first bid resulted in a player opening
    // AND: the selected bid is not pass.
    // RESULT: The current player is an opener.
    @Test
    public void testOnBidClickedResultsInPlayerOpenerSecondBid() {

        presenter.getGame().setCurrentPlayer(Player.USER);
        presenter.getGame().setHand(TargetHandGenerator.createAndFillAndRandomHand());
        presenter.onBidClicked(BidSelection.ONE_CLUB);
        // sets user as opened. Left opponent is not current player.

        presenter.onBidClicked(BidSelection.ONE_HEART);
        // sets left opponent to opened. Partner is now current player.

        presenter.onBidClicked(BidSelection.ONE_SPADE);
        // should not set partner to opened. Right opponent is now current player.

        presenter.onBidClicked(BidSelection.ONE_NO_TRUMP);
        // should not set right opponent opened to true. User is now current player.


        assertTrue(Player.USER.getOpened());
        assertTrue(Player.LEFT_OPPONENT.getOpened());
        assertFalse(Player.PARTNER.getOpened());
        assertFalse(Player.RIGHT_OPPONENT.getOpened());
    }
}
