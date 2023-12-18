package com.example.bridge_bid_app_java.playing_cards;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Hand {

    private final Set<Card> cards = new HashSet<Card>() ;
    private int totalPointCount;
    private int distributionPoints;
    private int highCardPoints;
    private int clubs;
    private int diamonds;
    private int hearts;
    private int spades;
    private int aces;
    private int kings;

    private boolean canOpen;
    private boolean canBidTwoLevel;
    private boolean canBidThreeLevel;
    private boolean canRespond;

    public Hand() {

    }

    public Hand(List<Card> cards) {
        this.cards.addAll(cards);
        updatePointCounts();
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
        calculateKings();
        calculateAces();
        calculateSuits();
        updateCanOpen(totalPointCount);
        updateCanBidTwoLevel(totalPointCount);
    }

    public void calculateHCP() {
        int total = 0;

        for (Card card: cards) {
            switch (card) {
                case JACK_CLUBS, JACK_DIAMONDS, JACK_HEARTS, JACK_SPADES -> total++;
                case QUEEN_CLUBS, QUEEN_DIAMONDS, QUEEN_HEARTS, QUEEN_SPADES -> total += 2;
                case KING_CLUBS, KING_DIAMONDS, KING_HEARTS, KING_SPADES -> total += 3;
                case ACE_CLUBS, ACE_DIAMONDS, ACE_HEARTS, ACE_SPADES -> total += 4;
                default -> { }
            }
        }

        highCardPoints = total;
    }

    public void calculateSuits() {
        int clubs = 0;
        int diamonds = 0;
        int hearts = 0;
        int spades = 0;

        for (Card card: cards) {
            switch (card.getSuit()) {
                case CLUBS -> clubs++;
                case DIAMONDS -> diamonds++;
                case HEARTS -> hearts++;
                case SPADES -> spades++;
                default -> { }
            }
        }

        this.clubs = clubs;
        this.diamonds = diamonds;
        this.hearts = hearts;
        this.spades = spades;
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

    public void updateCanOpen(int totalPointCount) {
        canOpen = totalPointCount > 12;
    }

    public void updateCanBidTwoLevel(int totalPointCount) {
        canBidTwoLevel = totalPointCount > 10;
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

    public int getCardsLength() { return cards.size(); }

    public int getClubs() {
        return clubs;
    }

    public int getDiamonds() {
        return diamonds;
    }

    public int getHearts() {
        return hearts;
    }

    public int getSpades() {
        return spades;
    }

    @Override
    public String toString() {
        return "Hand{" +
                "cards=" + cards +
                ", totalPointCount=" + totalPointCount +
                ", distributionPoints=" + distributionPoints +
                ", highCardPoints=" + highCardPoints +
                ", clubs=" + clubs +
                ", diamonds=" + diamonds +
                ", hearts=" + hearts +
                ", spades=" + spades +
                ", aces=" + aces +
                ", kings=" + kings +
                '}';
    }
}
