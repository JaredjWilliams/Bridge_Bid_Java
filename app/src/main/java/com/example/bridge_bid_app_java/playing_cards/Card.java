package com.example.bridge_bid_app_java.playing_cards;

import com.example.bridge_bid_app_java.R;

public enum Card {

    TWO_CLUBS(0, false, R.drawable.two_clubs, Suit.CLUBS, Rank.TWO),
    THREE_CLUBS(0, false, R.drawable.three_clubs, Suit.CLUBS, Rank.THREE),
    FOUR_CLUBS(0, false, R.drawable.four_clubs, Suit.CLUBS, Rank.FOUR),
    FIVE_CLUBS(0, false, R.drawable.five_clubs, Suit.CLUBS, Rank.FIVE),
    SIX_CLUBS(0, false, R.drawable.six_clubs, Suit.CLUBS, Rank.SIX),
    SEVEN_CLUBS(0, false, R.drawable.seven_clubs, Suit.CLUBS, Rank.SEVEN),
    EIGHT_CLUBS(0, false, R.drawable.eight_clubs, Suit.CLUBS, Rank.EIGHT),
    NINE_CLUBS(0, false, R.drawable.nine_clubs, Suit.CLUBS, Rank.NINE),
    TEN_CLUBS(0, false, R.drawable.ten_clubs, Suit.CLUBS, Rank.TEN),
    JACK_CLUBS(1, false, R.drawable.jack_clubs_, Suit.CLUBS, Rank.JACK),
    QUEEN_CLUBS(2, false, R.drawable.queen_of_clubs, Suit.CLUBS, Rank.QUEEN),
    KING_CLUBS(3, false, R.drawable.king_clubs_, Suit.CLUBS, Rank.KING),
    ACE_CLUBS(4, false, R.drawable.ace_clubs, Suit.CLUBS, Rank.ACE),

    TWO_DIAMONDS(0, false, R.drawable.two_diamonds, Suit.DIAMONDS, Rank.TWO),
    THREE_DIAMONDS(0, false, R.drawable.three_diamonds, Suit.DIAMONDS, Rank.THREE),
    FOUR_DIAMONDS(0, false, R.drawable.four_diamonds, Suit.DIAMONDS, Rank.FOUR),
    FIVE_DIAMONDS(0, false, R.drawable.five_diamonds, Suit.DIAMONDS, Rank.FIVE),
    SIX_DIAMONDS(0, false, R.drawable.six_diamonds, Suit.DIAMONDS, Rank.SIX),
    SEVEN_DIAMONDS(0, false, R.drawable.seven_diamonds, Suit.DIAMONDS, Rank.SEVEN),
    EIGHT_DIAMONDS(0, false, R.drawable.eight_diamonds, Suit.DIAMONDS, Rank.EIGHT),
    NINE_DIAMONDS(0, false, R.drawable.nine_diamonds, Suit.DIAMONDS, Rank.NINE),
    TEN_DIAMONDS(0, false, R.drawable.ten_diamonds, Suit.DIAMONDS, Rank.TEN),
    JACK_DIAMONDS(1, false, R.drawable.jack_diamonds_, Suit.DIAMONDS, Rank.JACK),
    QUEEN_DIAMONDS(2, false, R.drawable.queen_of_diamonds, Suit.DIAMONDS, Rank.QUEEN),
    KING_DIAMONDS(3, false, R.drawable.king_diamonds_, Suit.DIAMONDS, Rank.KING),
    ACE_DIAMONDS(4, false, R.drawable.ace_diamonds, Suit.DIAMONDS, Rank.ACE),

    TWO_HEARTS(0, false, R.drawable.two_hearts, Suit.HEARTS, Rank.TWO),
    THREE_HEARTS(0, false, R.drawable.three_hearts, Suit.HEARTS, Rank.THREE),
    FOUR_HEARTS(0, false, R.drawable.four_hearts, Suit.HEARTS, Rank.FOUR),
    FIVE_HEARTS(0, false, R.drawable.five_hearts, Suit.HEARTS, Rank.FIVE),
    SIX_HEARTS(0, false, R.drawable.six_hearts, Suit.HEARTS, Rank.SIX),
    SEVEN_HEARTS(0, false, R.drawable.seven_hearts, Suit.HEARTS, Rank.SEVEN),
    EIGHT_HEARTS(0, false, R.drawable.eight_hearts, Suit.HEARTS, Rank.EIGHT),
    NINE_HEARTS(0, false, R.drawable.nine_hearts, Suit.HEARTS, Rank.NINE),
    TEN_HEARTS(0, false, R.drawable.ten_hearts, Suit.HEARTS, Rank.TEN),
    JACK_HEARTS(1, false, R.drawable.jack_hearts, Suit.HEARTS, Rank.JACK),
    QUEEN_HEARTS(2, false, R.drawable.queen_of_hearts, Suit.HEARTS, Rank.QUEEN),
    KING_HEARTS(3, false, R.drawable.king_hearts, Suit.HEARTS, Rank.KING),
    ACE_HEARTS(4, false, R.drawable.ace_hearts, Suit.HEARTS, Rank.ACE),

    TWO_SPADES(0, false, R.drawable.two_spades, Suit.SPADES, Rank.TWO),
    THREE_SPADES(0, false, R.drawable.three_spades, Suit.SPADES, Rank.THREE),
    FOUR_SPADES(0, false, R.drawable.four_spades, Suit.SPADES, Rank.FOUR),
    FIVE_SPADES(0, false, R.drawable.five_spades, Suit.SPADES, Rank.FIVE),
    SIX_SPADES(0, false, R.drawable.six_spades, Suit.SPADES, Rank.SIX),
    SEVEN_SPADES(0, false, R.drawable.seven_spades, Suit.SPADES, Rank.SEVEN),
    EIGHT_SPADES(0, false, R.drawable.eight_spades, Suit.SPADES, Rank.EIGHT),
    NINE_SPADES(0, false, R.drawable.nine_spades, Suit.SPADES, Rank.NINE),
    TEN_SPADES(0, false, R.drawable.ten_spades, Suit.SPADES, Rank.TEN),
    JACK_SPADES(1, false, R.drawable.jack_spades_, Suit.SPADES, Rank.JACK),
    QUEEN_SPADES(2, false, R.drawable.queen_of_spades, Suit.SPADES, Rank.QUEEN),
    KING_SPADES(3, false, R.drawable.king_spades_, Suit.SPADES, Rank.KING),
    ACE_SPADES(4, false, R.drawable.ace_spades, Suit.SPADES, Rank.ACE);

    private boolean isSelected;
    private Suit suit;
    private int image;
    private int value;
    private Rank rank;

    Card(int value, boolean selected, int image, Suit suit, Rank rank){
        this.isSelected = selected;
        this.value = value;
        this.image = image;
        this.suit = suit;
        this.rank = rank;
    }

    public static void resetCards() {
        for (Card card : Card.values()) {
            card.isSelected = false;
        }
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

    public Rank getRank() { return rank; }
}
