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
    ACE_CLUBS(4, false, R.drawable.ace_clubs, Suit.CLUBS),

    TWO_DIAMONDS(0, false, R.drawable.two_diamonds, Suit.DIAMONDS),
    THREE_DIAMONDS(0, false, R.drawable.three_diamonds, Suit.DIAMONDS),
    FOUR_DIAMONDS(0, false, R.drawable.four_diamonds, Suit.DIAMONDS),
    FIVE_DIAMONDS(0, false, R.drawable.five_diamonds, Suit.DIAMONDS),
    SIX_DIAMONDS(0, false, R.drawable.six_diamonds, Suit.DIAMONDS),
    SEVEN_DIAMONDS(0, false, R.drawable.seven_diamonds, Suit.DIAMONDS),
    EIGHT_DIAMONDS(0, false, R.drawable.eight_diamonds, Suit.DIAMONDS),
    NINE_DIAMONDS(0, false, R.drawable.nine_diamonds, Suit.DIAMONDS),
    TEN_DIAMONDS(0, false, R.drawable.ten_diamonds, Suit.DIAMONDS),
    JACK_DIAMONDS(1, false, R.drawable.jack_diamonds_, Suit.DIAMONDS),
    QUEEN_DIAMONDS(2, false, R.drawable.queen_of_diamonds, Suit.DIAMONDS),
    KING_DIAMONDS(3, false, R.drawable.king_diamonds_, Suit.DIAMONDS),
    ACE_DIAMONDS(4, false, R.drawable.ace_diamonds, Suit.DIAMONDS),
    TWO_HEARTS(0, false, R.drawable.two_hearts, Suit.HEARTS),
    THREE_HEARTS(0, false, R.drawable.three_hearts, Suit.HEARTS),
    FOUR_HEARTS(0, false, R.drawable.four_hearts, Suit.HEARTS),
    FIVE_HEARTS(0, false, R.drawable.five_hearts, Suit.HEARTS),
    SIX_HEARTS(0, false, R.drawable.six_hearts, Suit.HEARTS),
    SEVEN_HEARTS(0, false, R.drawable.seven_hearts, Suit.HEARTS),
    EIGHT_HEARTS(0, false, R.drawable.eight_hearts, Suit.HEARTS),
    NINE_HEARTS(0, false, R.drawable.nine_hearts, Suit.HEARTS),
    TEN_HEARTS(0, false, R.drawable.ten_hearts, Suit.HEARTS),
    JACK_HEARTS(1, false, R.drawable.jack_hearts, Suit.HEARTS),
    QUEEN_HEARTS(2, false, R.drawable.queen_of_hearts, Suit.HEARTS),
    KING_HEARTS(3, false, R.drawable.king_hearts, Suit.HEARTS),
    ACE_HEARTS(4, false, R.drawable.ace_hearts, Suit.HEARTS),
    TWO_SPADES(0, false, R.drawable.two_spades, Suit.SPADES),
    THREE_SPADES(0, false, R.drawable.three_spades, Suit.SPADES),
    FOUR_SPADES(0, false, R.drawable.four_spades, Suit.SPADES),
    FIVE_SPADES(0, false, R.drawable.five_spades, Suit.SPADES),
    SIX_SPADES(0, false, R.drawable.six_spades, Suit.SPADES),
    SEVEN_SPADES(0, false, R.drawable.seven_spades, Suit.SPADES),
    EIGHT_SPADES(0, false, R.drawable.eight_spades, Suit.SPADES),
    NINE_SPADES(0, false, R.drawable.nine_spades, Suit.SPADES),
    TEN_SPADES(0, false, R.drawable.ten_spades, Suit.SPADES),
    JACK_SPADES(1, false, R.drawable.jack_spades_, Suit.SPADES),
    QUEEN_SPADES(2, false, R.drawable.queen_of_spades, Suit.SPADES),
    KING_SPADES(3, false, R.drawable.king_spades_, Suit.SPADES),
    ACE_SPADES(4, false, R.drawable.ace_spades, Suit.SPADES);

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
