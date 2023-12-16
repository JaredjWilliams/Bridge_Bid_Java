package com.example.bridge_bid_app_java.card_selection;

import android.media.Image;
import android.view.View;
import android.widget.ImageView;

import com.example.bridge_bid_app_java.R;
import com.example.bridge_bid_app_java.playing_cards.Card;
import com.example.bridge_bid_app_java.playing_cards.Hand;

public class CardSelectionPresenter {
    private CardSelectionInterface view;
    private final Hand hand = new Hand();

    public CardSelectionPresenter(CardSelectionInterface view) {
        this.view = view;
    }

    public ImageView onCardPressed(ImageView cardImage, Card card) {

        if (card.isSelected()) {
            card.isSelected(false);
            hand.removeCardFromHand(card);
            cardImage.setBackgroundResource(0);
        } else {
            card.isSelected(true);
            hand.addCard(card);
            cardImage.setBackgroundResource(R.drawable.selected_card_background);
        }

        view.setCardCounterTextView(hand.getCards().size());
        view.setTotalPointCounter(hand.getHighCardPoints());

        return cardImage;
    }

    private void addCardToHand() {
    }

    private void removeCardFromHand() {
    }
}
