package com.example.bridge_bid_app_java.presenter_tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import com.example.bridge_bid_app_java.bid_selection.BidSelectionInterface;
import com.example.bridge_bid_app_java.bid_selection.BidSelectionPresenter;
import com.example.bridge_bid_app_java.game.BidSelection;
import com.example.bridge_bid_app_java.game.Game;
import com.example.bridge_bid_app_java.game.Player;

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
    // AND: Opponents did not select a bid.
    // RESULT: Updates partner opened
    @Test
    public void testOnBidClickedSetPlayerOpener() {
        presenter.getGame().setCurrentPlayer(Player.PARTNER);
        presenter.onBidClicked(BidSelection.TWO_NO_TRUMP);

        assertEquals(Player.PARTNER, presenter.getGame().getOpener());
    }
}
