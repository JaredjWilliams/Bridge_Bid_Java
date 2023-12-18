package com.example.bridge_bid_app_java.game;

import android.graphics.Color;

import com.example.bridge_bid_app_java.R;
import com.example.bridge_bid_app_java.playing_cards.Suit;

public enum BidSelection {
    ONE_CLUBS(Suit.CLUBS, R.drawable.card_suit_clubs, "1", Color.WHITE),
    ONE_DIAMONDS(Suit.DIAMONDS, R.drawable.card_suit_diamonds, "1", Color.BLACK),
    ONE_HEARTS(Suit.HEARTS, R.drawable.card_suit_heats, "1", Color.BLACK),
    ONE_SPADES(Suit.SPADES, R.drawable.card_suit_spades, "1", Color.WHITE),
    ONE_NO_TRUMPS(Suit.NO_TRUMP, R.drawable.no_trump_background, "1 NT", Color.WHITE),
    TWO_CLUBS(Suit.CLUBS, R.drawable.card_suit_clubs, "2", Color.WHITE),
    TWO_DIAMOND(Suit.DIAMONDS, R.drawable.card_suit_diamonds, "2", Color.BLACK),
    TWO_HEARTS(Suit.HEARTS, R.drawable.card_suit_heats, "2", Color.BLACK),
    TWO_SPADES(Suit.SPADES, R.drawable.card_suit_spades, "2", Color.WHITE),
    TWO_NO_TRUMP(Suit.NO_TRUMP, R.drawable.no_trump_background, "2 NT", Color.WHITE),
    THREE_CLUBS(Suit.CLUBS, R.drawable.card_suit_clubs, "3", Color.WHITE),
    THREE_DIAMONDS(Suit.DIAMONDS, R.drawable.card_suit_diamonds, "3", Color.BLACK),
    THREE_HEARTS(Suit.HEARTS, R.drawable.card_suit_heats, "3", Color.BLACK),
    THREE_SPADES(Suit.SPADES, R.drawable.card_suit_spades,"3", Color.WHITE),
    THREE_NO_TRUMP(Suit.NO_TRUMP, R.drawable.no_trump_background, "3 NT", Color.WHITE),
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
