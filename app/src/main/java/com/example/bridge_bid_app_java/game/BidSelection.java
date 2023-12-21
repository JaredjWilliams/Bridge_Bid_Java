package com.example.bridge_bid_app_java.game;

import android.graphics.Color;

import com.example.bridge_bid_app_java.R;
import com.example.bridge_bid_app_java.playing_cards.Suit;

public enum BidSelection {
    ONE_CLUB(Suit.CLUBS, R.drawable.card_suit_clubs, "1", Color.WHITE),
    ONE_DIAMOND(Suit.DIAMONDS, R.drawable.card_suit_diamonds, "1", Color.BLACK),
    ONE_HEART(Suit.HEARTS, R.drawable.card_suit_heats, "1", Color.BLACK),
    ONE_SPADE(Suit.SPADES, R.drawable.card_suit_spades, "1", Color.WHITE),
    ONE_NO_TRUMP(Suit.NO_TRUMP, R.drawable.no_trump_background, "1 NT", Color.WHITE),
    TWO_CLUBS(Suit.CLUBS, R.drawable.card_suit_clubs, "2", Color.WHITE),
    TWO_DIAMONDS(Suit.DIAMONDS, R.drawable.card_suit_diamonds, "2", Color.BLACK),
    TWO_HEARTS(Suit.HEARTS, R.drawable.card_suit_heats, "2", Color.BLACK),
    TWO_SPADES(Suit.SPADES, R.drawable.card_suit_spades, "2", Color.WHITE),
    TWO_NO_TRUMP(Suit.NO_TRUMP, R.drawable.no_trump_background, "2 NT", Color.WHITE),
    THREE_CLUBS(Suit.CLUBS, R.drawable.card_suit_clubs, "3", Color.WHITE),
    THREE_DIAMONDS(Suit.DIAMONDS, R.drawable.card_suit_diamonds, "3", Color.BLACK),
    THREE_HEARTS(Suit.HEARTS, R.drawable.card_suit_heats, "3", Color.BLACK),
    THREE_SPADES(Suit.SPADES, R.drawable.card_suit_spades,"3", Color.WHITE),
    THREE_NO_TRUMP(Suit.NO_TRUMP, R.drawable.no_trump_background, "3 NT", Color.WHITE),
    FOUR_CLUBS(Suit.CLUBS, R.drawable.card_suit_clubs, "4", Color.WHITE),
    FOUR_DIAMONDS(Suit.DIAMONDS, R.drawable.card_suit_diamonds, "4", Color.BLACK),
    FOUR_HEARTS(Suit.HEARTS, R.drawable.card_suit_heats, "4", Color.BLACK),
    FOUR_SPADES(Suit.SPADES, R.drawable.card_suit_spades,"4", Color.WHITE),
    FOUR_NO_TRUMP(Suit.NO_TRUMP, R.drawable.no_trump_background, "4 NT", Color.WHITE),
    FIVE_CLUBS(Suit.CLUBS, R.drawable.card_suit_clubs, "5", Color.WHITE),
    FIVE_DIAMONDS(Suit.DIAMONDS, R.drawable.card_suit_diamonds, "5", Color.BLACK),
    FIVE_HEARTS(Suit.HEARTS, R.drawable.card_suit_heats, "5", Color.BLACK),
    FIVE_SPADES(Suit.SPADES, R.drawable.card_suit_spades,"5", Color.WHITE),
    FIVE_NO_TRUMP(Suit.NO_TRUMP, R.drawable.no_trump_background, "5 NT", Color.WHITE),
    SIX_CLUBS(Suit.CLUBS, R.drawable.card_suit_clubs, "6", Color.WHITE),
    SIX_DIAMONDS(Suit.DIAMONDS, R.drawable.card_suit_diamonds, "6", Color.BLACK),
    SIX_HEARTS(Suit.HEARTS, R.drawable.card_suit_heats, "6", Color.BLACK),
    SIX_SPADES(Suit.SPADES, R.drawable.card_suit_spades,"6", Color.WHITE),
    SIX_NO_TRUMP(Suit.NO_TRUMP, R.drawable.no_trump_background, "6 NT", Color.WHITE),
    SEVEN_CLUBS(Suit.CLUBS, R.drawable.card_suit_clubs, "7", Color.WHITE),
    SEVEN_DIAMONDS(Suit.DIAMONDS, R.drawable.card_suit_diamonds, "7", Color.BLACK),
    SEVEN_HEARTS(Suit.HEARTS, R.drawable.card_suit_heats, "7", Color.BLACK),
    SEVEN_SPADES(Suit.SPADES, R.drawable.card_suit_spades,"7", Color.WHITE),
    SEVEN_NO_TRUMP(Suit.NO_TRUMP, R.drawable.no_trump_background, "7 NT", Color.WHITE),

    PASS(Suit.NO_TRUMP, R.drawable.no_trump_background, "Pass", Color.WHITE);

    private int image;
    private Suit suit;
    private String name;
    private int color;

    BidSelection(Suit suit, int image, String name, int color) {
        this.suit = suit;
        this.image = image;
        this.name = name;
        this.color = color;
    }

    public int getImage() {
        return image;
    }

    public Suit getSuit() {
        return suit;
    }

    public String getName() {
        return name;
    }

    public int getColor() {
        return color;
    }
}
