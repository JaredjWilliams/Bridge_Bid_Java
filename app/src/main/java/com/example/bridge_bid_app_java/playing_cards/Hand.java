package com.example.bridge_bid_app_java.playing_cards;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Hand {

    private final Set<Card> cards = new HashSet<Card>() ;
    private int totalPointCount;
    private int distributionPoints;
    private int highCardPoints;
    private HashMap<Suit, Integer> heartStoppers = new HashMap<>();
    private HashMap<Suit, Integer> spadeStoppers = new HashMap<>();
    private HashMap<Suit, Integer> diamondStoppers = new HashMap<>();
    private HashMap<Suit, Integer> clubStoppers = new HashMap<>();
    private int highSpades;
    private int highHearts;
    private int highDiamonds;
    private int highClubs;
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
        calculateHighSpades();
        calculateHighHearts();
        calculateHighDiamonds();
        calculateHighClubs();
        calculateStoppers();
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

    public void calculateStoppers() {
        spadeStoppers.put(Suit.SPADES, (int) cards.stream().filter(card -> card == Card.ACE_SPADES || card == Card.KING_SPADES).count());
        heartStoppers.put(Suit.HEARTS, (int) cards.stream().filter(card -> card == Card.ACE_HEARTS || card == Card.KING_HEARTS).count());
        diamondStoppers.put(Suit.DIAMONDS, (int) cards.stream().filter(card -> card == Card.ACE_DIAMONDS || card == Card.KING_DIAMONDS).count());
        clubStoppers.put(Suit.CLUBS, (int) cards.stream().filter(card -> card == Card.ACE_CLUBS || card == Card.KING_CLUBS).count());
    }

    public void calculateSuits() {
        clubs = (int) cards.stream().filter(card -> card.getSuit() == Suit.CLUBS).count();
        diamonds = (int) cards.stream().filter(card -> card.getSuit() == Suit.DIAMONDS).count();
        hearts = (int) cards.stream().filter(card -> card.getSuit() == Suit.HEARTS).count();
        spades = (int) cards.stream().filter(card -> card.getSuit() == Suit.SPADES).count();
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

    public void calculateHighSpades() {
        highSpades = (int) cards.stream().filter(card ->
                card == Card.ACE_SPADES ||
                card == Card.KING_SPADES ||
                card == Card.QUEEN_SPADES ||
                card == Card.JACK_SPADES ||
                card == Card.TEN_SPADES).count();
    }

    public void calculateHighHearts() {
        highHearts = (int) cards.stream().filter(card ->
                card == Card.ACE_HEARTS ||
                        card == Card.KING_HEARTS ||
                        card == Card.QUEEN_HEARTS ||
                        card == Card.JACK_HEARTS ||
                        card == Card.TEN_HEARTS).count();
    }

    public void calculateHighDiamonds() {
        highDiamonds = (int) cards.stream().filter(card ->
                card == Card.ACE_DIAMONDS ||
                        card == Card.KING_DIAMONDS ||
                        card == Card.QUEEN_DIAMONDS ||
                        card == Card.JACK_DIAMONDS ||
                        card == Card.TEN_DIAMONDS).count();
    }

    public void calculateHighClubs() {
        highClubs = (int) cards.stream().filter(card ->
                card == Card.ACE_CLUBS ||
                        card == Card.KING_CLUBS ||
                        card == Card.QUEEN_CLUBS ||
                        card == Card.JACK_CLUBS ||
                        card == Card.TEN_CLUBS).count();
    }


    public void calculateKings() {
        kings = (int) cards.stream().filter(card ->
                card == Card.KING_DIAMONDS ||
                card == Card.KING_CLUBS ||
                card == Card.KING_HEARTS ||
                card == Card.KING_SPADES).count();
    }

    public void calculateAces() {
        aces = (int) cards.stream().filter(card ->
                card == Card.ACE_DIAMONDS ||
                        card == Card.ACE_CLUBS ||
                        card == Card.ACE_HEARTS ||
                        card == Card.ACE_SPADES).count();
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

    public HashMap<Suit, Integer> getHeartStoppers() {
        return heartStoppers;
    }

    public HashMap<Suit, Integer> getSpadeStoppers() {
        return spadeStoppers;
    }

    public HashMap<Suit, Integer> getDiamondStoppers() {
        return diamondStoppers;
    }

    public HashMap<Suit, Integer> getClubStoppers() {
        return clubStoppers;
    }

    public int getHighSpades() {
        return highSpades;
    }

    public int getHighHearts() {
        return highHearts;
    }

    public int getHighDiamonds() {
        return highDiamonds;
    }

    public int getHighClubs() {
        return highClubs;
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
