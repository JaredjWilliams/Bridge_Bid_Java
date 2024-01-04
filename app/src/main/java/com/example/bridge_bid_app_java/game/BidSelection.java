package com.example.bridge_bid_app_java.game;

import android.graphics.Color;

import com.example.bridge_bid_app_java.R;
import com.example.bridge_bid_app_java.playing_cards.Suit;

public enum BidSelection {
    ONE_CLUB(Suit.CLUBS, R.drawable.card_suit_clubs, "1", Color.WHITE, true),
    ONE_DIAMOND(Suit.DIAMONDS, R.drawable.card_suit_diamonds, "1", Color.BLACK, true),
    ONE_HEART(Suit.HEARTS, R.drawable.card_suit_heats, "1", Color.BLACK, true),
    ONE_SPADE(Suit.SPADES, R.drawable.card_suit_spades, "1", Color.WHITE, true),
    ONE_NO_TRUMP(Suit.NO_TRUMP, R.drawable.no_trump_background, "1 NT", Color.WHITE, true),
    TWO_CLUBS(Suit.CLUBS, R.drawable.card_suit_clubs, "2", Color.WHITE, true),
    TWO_DIAMONDS(Suit.DIAMONDS, R.drawable.card_suit_diamonds, "2", Color.BLACK, true),
    TWO_HEARTS(Suit.HEARTS, R.drawable.card_suit_heats, "2", Color.BLACK, true),
    TWO_SPADES(Suit.SPADES, R.drawable.card_suit_spades, "2", Color.WHITE, true),
    TWO_NO_TRUMP(Suit.NO_TRUMP, R.drawable.no_trump_background, "2 NT", Color.WHITE, true),
    THREE_CLUBS(Suit.CLUBS, R.drawable.card_suit_clubs, "3", Color.WHITE, true),
    THREE_DIAMONDS(Suit.DIAMONDS, R.drawable.card_suit_diamonds, "3", Color.BLACK, true),
    THREE_HEARTS(Suit.HEARTS, R.drawable.card_suit_heats, "3", Color.BLACK, true),
    THREE_SPADES(Suit.SPADES, R.drawable.card_suit_spades,"3", Color.WHITE, true),
    THREE_NO_TRUMP(Suit.NO_TRUMP, R.drawable.no_trump_background, "3 NT", Color.WHITE, true),
    FOUR_CLUBS(Suit.CLUBS, R.drawable.card_suit_clubs, "4", Color.WHITE, true),
    FOUR_DIAMONDS(Suit.DIAMONDS, R.drawable.card_suit_diamonds, "4", Color.BLACK, true),
    FOUR_HEARTS(Suit.HEARTS, R.drawable.card_suit_heats, "4", Color.BLACK, true),
    FOUR_SPADES(Suit.SPADES, R.drawable.card_suit_spades,"4", Color.WHITE, true),
    FOUR_NO_TRUMP(Suit.NO_TRUMP, R.drawable.no_trump_background, "4 NT", Color.WHITE, true),
    FIVE_CLUBS(Suit.CLUBS, R.drawable.card_suit_clubs, "5", Color.WHITE, true),
    FIVE_DIAMONDS(Suit.DIAMONDS, R.drawable.card_suit_diamonds, "5", Color.BLACK, true),
    FIVE_HEARTS(Suit.HEARTS, R.drawable.card_suit_heats, "5", Color.BLACK, true),
    FIVE_SPADES(Suit.SPADES, R.drawable.card_suit_spades,"5", Color.WHITE, true),
    FIVE_NO_TRUMP(Suit.NO_TRUMP, R.drawable.no_trump_background, "5 NT", Color.WHITE, true),
    SIX_CLUBS(Suit.CLUBS, R.drawable.card_suit_clubs, "6", Color.WHITE, true),
    SIX_DIAMONDS(Suit.DIAMONDS, R.drawable.card_suit_diamonds, "6", Color.BLACK, true),
    SIX_HEARTS(Suit.HEARTS, R.drawable.card_suit_heats, "6", Color.BLACK, true),
    SIX_SPADES(Suit.SPADES, R.drawable.card_suit_spades,"6", Color.WHITE, true),
    SIX_NO_TRUMP(Suit.NO_TRUMP, R.drawable.no_trump_background, "6 NT", Color.WHITE, true),
    SEVEN_CLUBS(Suit.CLUBS, R.drawable.card_suit_clubs, "7", Color.WHITE, true),
    SEVEN_DIAMONDS(Suit.DIAMONDS, R.drawable.card_suit_diamonds, "7", Color.BLACK, true),
    SEVEN_HEARTS(Suit.HEARTS, R.drawable.card_suit_heats, "7", Color.BLACK, true),
    SEVEN_SPADES(Suit.SPADES, R.drawable.card_suit_spades,"7", Color.WHITE, true),
    SEVEN_NO_TRUMP(Suit.NO_TRUMP, R.drawable.no_trump_background, "7 NT", Color.WHITE, true),

    PASS(Suit.NO_TRUMP, R.drawable.no_trump_background, "Pass", Color.WHITE, true),
    DOUBLE(Suit.NO_TRUMP, R.drawable.no_trump_background, "X", Color.WHITE, true),
    REDOUBLE(Suit.NO_TRUMP, R.drawable.no_trump_background, "XX", Color.WHITE, true);

    private int image;
    private Suit suit;
    private String name;
    private int color;
    private boolean enabled;

    BidSelection(Suit suit, int image, String name, int color, boolean enabled) {
        this.suit = suit;
        this.image = image;
        this.name = name;
        this.color = color;
        this.enabled = enabled;
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

    public void isEnabled(BidSelection currentBid) {

        if (currentBid == PASS || currentBid == DOUBLE || currentBid == REDOUBLE) {
            return;
        }

        for (BidSelection bid : BidSelection.values()) {
            bid.enabled = bid.ordinal() > currentBid.ordinal();
        }
    }

    public boolean getEnabled() {
        return enabled;
    }
}
