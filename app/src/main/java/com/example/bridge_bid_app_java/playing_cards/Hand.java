package com.example.bridge_bid_app_java.playing_cards;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class Hand {

    private final Set<Card> cards = new HashSet<Card>() ;
    private int totalPointCount;
    private int distributionPoints;
    private int highCardPoints;
    private int aces;
    private int kings;

    public Hand() {

    }

    public Hand(List<Card> cards) {
        this.cards.addAll(cards);
    }

    public void addCard(Card card) {
        cards.add(card);
        updatePointCounts();
    }

    public void removeCardFromHand(Card card) {
        cards.remove(card);
        updatePointCounts();
    }

    private void updatePointCounts() {
        calculateHCP();
        calculateTotalPoints();
    }

    public void calculateHCP() {
        int total = 0;

        for (Card card: cards) {
            switch (card) {
                case JACK_CLUBS -> total++;
                case QUEEN_CLUBS -> total += 2;
                case KING_CLUBS -> total += 3;
                case ACE_CLUBS -> total += 4;
                default -> { }
            }
        }

        highCardPoints = total;
    }

    private void calculateTotalPoints() {
        totalPointCount = highCardPoints + distributionPoints;
    }


    public int getTotalPointCount() {
        return totalPointCount;
    }

    public int getDistributionPoints() {
        return distributionPoints;
    }

    public int getHighCardPoints() {
        return highCardPoints;
    }

    public int getAces() {
        return aces;
    }

    public int getKings() {
        return kings;
    }

    public Collection<Card> getCards() {
        return cards;
    }

}
