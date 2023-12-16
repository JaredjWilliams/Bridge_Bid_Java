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
        calculateDistributionPoints();
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

    public void calculateDistributionPoints() {
        int total = 0;

        List<Long> distributions = List.of(
                cards.stream().filter(card -> card.getSuit() == Suit.CLUBS).count(),
                cards.stream().filter(card -> card.getSuit() == Suit.DIAMONDS).count(),
                cards.stream().filter(card -> card.getSuit() == Suit.HEARTS).count(),
                cards.stream().filter(card -> card.getSuit() == Suit.SPADES).count()
        );

        for (Long distribution : distributions) {
            switch (distribution.intValue()) {
                case 0 -> total += 3;
                case 1 -> total += 2;
                case 2 -> total += 1;
            }
        }

        distributionPoints = total;
    }

    public void calculateKings() {
        long total = cards.stream().filter(card ->
                card == Card.KING_DIAMONDS ||
                card == Card.KING_CLUBS ||
                card == Card.KING_HEARTS ||
                card == Card.KING_SPADES).count();

        kings = (int) total;
    }

    public void calculateAces() {
        long total = cards.stream().filter(card ->
                card == Card.ACE_DIAMONDS ||
                        card == Card.ACE_CLUBS ||
                        card == Card.ACE_HEARTS ||
                        card == Card.ACE_SPADES).count();

        aces = (int) total;
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
