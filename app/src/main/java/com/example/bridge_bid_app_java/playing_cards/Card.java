package com.example.bridge_bid_app_java.playing_cards;

import com.example.bridge_bid_app_java.R;

public enum Card {


    TWO_CLUBS(0, false, R.drawable.two_clubs, Suit.CLUBS),
    THREE_CLUBS(0, false, R.drawable.three_clubs, Suit.CLUBS),
    FOUR_CLUBS(0, false, R.drawable.four_clubs, Suit.CLUBS),
    FIVE_CLUBS(0, false, R.drawable.five_clubs, Suit.CLUBS),
    SIX_CLUBS(0, false, R.drawable.six_clubs, Suit.CLUBS),
    SEVEN_CLUBS(0, false, R.drawable.seven_clubs, Suit.CLUBS),
    EIGHT_CLUBS(0, false, R.drawable.eight_clubs, Suit.CLUBS),
    NINE_CLUBS(0, false, R.drawable.nine_clubs, Suit.CLUBS),
    TEN_CLUBS(0, false, R.drawable.ten_clubs, Suit.CLUBS),
    JACK_CLUBS(1, false, R.drawable.jack_clubs_, Suit.CLUBS),
    QUEEN_CLUBS(2, false, R.drawable.queen_of_clubs, Suit.CLUBS),
    KING_CLUBS(3, false, R.drawable.king_clubs_, Suit.CLUBS),
    ACE_CLUBS(4, false, R.drawable.ace_clubs, Suit.CLUBS);

    private boolean isSelected;
    private Suit suit;
    private int image;
    private int value;

    Card(int value, boolean selected, int image, Suit suit){
        this.isSelected = selected;
        this.value = value;
        this.image = image;
        this.suit = suit;
    }

    public void isSelected(boolean selected) {
        isSelected = selected;
    }

    public boolean isSelected() {
        return isSelected;
    }

    public int getImage() {
        return image;
    }

    public Suit getSuit() {
        return suit;
    }
}
