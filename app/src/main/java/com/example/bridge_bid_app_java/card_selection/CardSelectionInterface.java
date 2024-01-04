package com.example.bridge_bid_app_java.card_selection;

import com.example.bridge_bid_app_java.playing_cards.Suit;

public interface CardSelectionInterface {

    void updateCardGrid(Suit suit, boolean update);

    void removeCardFromCardGrid();

    void setCardCounterTextView(int count);

    void setTotalPointCounter(int count);

    void enabledNextButton(boolean isEnabled);

    void setCardCounterColor(String color);
}
