package com.example.bridge_bid_app_java;

import com.example.bridge_bid_app_java.card_selection.CardSelectionInterface;
import com.example.bridge_bid_app_java.card_selection.CardSelectionPresenter;
import com.example.bridge_bid_app_java.game.Player;
import com.example.bridge_bid_app_java.playing_cards.Card;
import com.example.bridge_bid_app_java.playing_cards.Hand;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.List;

public class CardSelectionPresenterTests {
    List<Card> mockFullHand = List.of(Card.FOUR_DIAMONDS, Card.TWO_HEARTS, Card.SIX_HEARTS, Card.ACE_DIAMONDS,
            Card.KING_HEARTS, Card.TEN_HEARTS, Card.THREE_SPADES, Card.NINE_DIAMONDS, Card.THREE_CLUBS,
            Card.JACK_SPADES, Card.QUEEN_DIAMONDS, Card.SIX_DIAMONDS, Card.FIVE_CLUBS);
    List<Card> mockFullHandMinusOne = List.of(Card.TWO_HEARTS, Card.SIX_HEARTS, Card.ACE_DIAMONDS,
            Card.KING_HEARTS, Card.TEN_HEARTS, Card.THREE_SPADES, Card.NINE_DIAMONDS, Card.THREE_CLUBS,
            Card.JACK_SPADES, Card.QUEEN_DIAMONDS, Card.SIX_DIAMONDS, Card.FIVE_CLUBS);

    @Mock
    CardSelectionInterface view;

    private CardSelectionPresenter presenter;

    @Before
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        presenter = new CardSelectionPresenter(view);
    }

    // When -> updateNextButton is called
    // And -> hand size is 13
    // And -> dealer is not null
    // Result -> the next button is enabled
    @Test
    public void testUpdateNextButton() {
        Hand hand = new Hand(mockFullHand);
        Player player = Player.USER;

        presenter.updateNextButton(hand, player);

        Mockito.verify(view).enabledNextButton(true);
    }

    // When -> updateNextButton is called
    // And -> hand size is 13
    // And -> dealer is null
    // Result -> the next button is disabled
    @Test
    public void testUpdateNextButtonReturnsFalse() {
        Hand hand = new Hand(mockFullHand);

        presenter.updateNextButton(hand, null);

        Mockito.verify(view).enabledNextButton(false);
    }

    // When -> updateNextButton is called
    // And -> hand size is less than 13
    // And -> dealer is not null
    // Result -> the next button will be disabled
    @Test
    public void testUpdateNextButtonReturnsFalseWhen() {
        Hand hand = new Hand(mockFullHandMinusOne);

        presenter.updateNextButton(hand, Player.USER);

        Mockito.verify(view).enabledNextButton(false);
    }
}
