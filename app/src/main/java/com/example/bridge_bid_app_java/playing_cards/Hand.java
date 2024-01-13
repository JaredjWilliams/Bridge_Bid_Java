package com.example.bridge_bid_app_java.playing_cards;

import static com.example.bridge_bid_app_java.playing_cards.Suit.CLUBS;
import static com.example.bridge_bid_app_java.playing_cards.Suit.DIAMONDS;
import static com.example.bridge_bid_app_java.playing_cards.Suit.HEARTS;
import static com.example.bridge_bid_app_java.playing_cards.Suit.SPADES;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

public class Hand {

    private final Set<Card> cards = new HashSet<Card>() ;
    private int totalPointCount;
    private int distributionPoints;
    private int highCardPoints;
    private double quickTricks;
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
    private int longSuitPoints;

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
        //Only count SSPs if you have established that you and your partner have an 8 card fit or better.
        //If you have 4 card or better support then count SSPs as follows:
        //5 points for a void (no cards in a suit), 3 points for a singleton and 1 point for a doubleton.
        //If you have just 3 card support, count SSPs as follows:
        //3 points for a void, 2 points for a singleton and 1 point for a doubleton
        calculateTotalPoints();
        calculateKings();
        calculateAces();
        calculateSuits();
        updateCanOpen(totalPointCount);
        updateCanBidTwoLevel(totalPointCount);
        calculateStoppers();
        calculateAllQuickTricks();
        calculateHighCards();
        calculateLongSuitPoints();
        // You DO count LSPs if you are opening the bidding or if you are making a responding bid that involves a change of suit.
        // You DON’T count LSPs if you are opening the bidding or responding with a balanced hand and making a NT bid.
    }

    private void calculateLongSuitPoints() {
        longSuitPoints = Stream.of(SPADES, HEARTS, CLUBS, DIAMONDS)
                .mapToInt(suit -> (int) cards.stream()
                    .filter(card -> card.getSuit() == suit)
                        .count() - 4)
                .filter(excess -> excess > 0)
                .sum();
    }

    private void calculateAllQuickTricks() {
        double total = 0;

        total += calculateQuickTrickFor(Suit.CLUBS);
        total += calculateQuickTrickFor(Suit.DIAMONDS);
        total += calculateQuickTrickFor(Suit.HEARTS);
        total += calculateQuickTrickFor(SPADES);

        quickTricks = total;
    }

    public double calculateQuickTrickFor(Suit suit) {
        List<Rank> suitOfCards = cards.stream()
                .filter(card -> card.getSuit() == suit)
                .map(Card::getRank)
                .toList();

        if (isQuickTrickFor(suitOfCards, Rank.ACE, Rank.KING)) {
            return QuickTrick.ACE_KING.getValue();
        }
        if (isQuickTrickFor(suitOfCards, Rank.ACE, Rank.QUEEN)) {
            return QuickTrick.ACE_QUEEN.getValue();
        }
        if (isQuickTrickFor(suitOfCards, Rank.KING, Rank.QUEEN)) {
            return QuickTrick.KING_QUEEN.getValue();
        }
        if (isQuickTrickFor(suitOfCards, Rank.ACE, null)) {
            return QuickTrick.ACE.getValue();
        }
        if (isQuickTrickFor(suitOfCards, Rank.KING, null)) {
            return QuickTrick.KING.getValue();
        }

        return 0;
    }

    private boolean isQuickTrickFor(List<Rank> suitOfCards, Rank rankOne, Rank rankTwo) {
        if (rankTwo == null) {
            return suitOfCards.contains(rankOne);
        }
        return suitOfCards.contains(rankOne) && suitOfCards.contains(rankTwo);
    }

    public void calculateHCP() {
        int total = 0;

        for (Card card: cards) {
            switch (card.getRank()) {
                case JACK -> total++;
                case QUEEN -> total += 2;
                case KING -> total += 3;
                case ACE -> total += 4;
                default -> { }
            }
        }

        highCardPoints = total;
    }

    public void calculateStoppers() {
        spadeStoppers.put(SPADES, (int) cards.stream().filter(card -> card == Card.ACE_SPADES || card == Card.KING_SPADES).count());
        heartStoppers.put(Suit.HEARTS, (int) cards.stream().filter(card -> card == Card.ACE_HEARTS || card == Card.KING_HEARTS).count());
        diamondStoppers.put(Suit.DIAMONDS, (int) cards.stream().filter(card -> card == Card.ACE_DIAMONDS || card == Card.KING_DIAMONDS).count());
        clubStoppers.put(Suit.CLUBS, (int) cards.stream().filter(card -> card == Card.ACE_CLUBS || card == Card.KING_CLUBS).count());
    }

    public void calculateSuits() {
        clubs = (int) cards.stream().filter(card -> card.getSuit() == Suit.CLUBS).count();
        diamonds = (int) cards.stream().filter(card -> card.getSuit() == Suit.DIAMONDS).count();
        hearts = (int) cards.stream().filter(card -> card.getSuit() == Suit.HEARTS).count();
        spades = (int) cards.stream().filter(card -> card.getSuit() == SPADES).count();
    }

    public void calculateDistributionPoints() {
        int total = 0;

        List<Long> distributions = List.of(
                cards.stream().filter(card -> card.getSuit() == Suit.CLUBS).count(),
                cards.stream().filter(card -> card.getSuit() == Suit.DIAMONDS).count(),
                cards.stream().filter(card -> card.getSuit() == Suit.HEARTS).count(),
                cards.stream().filter(card -> card.getSuit() == SPADES).count()
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

    public int calculateHighCardsFor(Suit suit) {
        List<Rank> ranks = List.of(Rank.ACE, Rank.KING, Rank.QUEEN, Rank.JACK, Rank.TEN);
        long count = cards.stream().filter(card -> card.getSuit() == suit)
                .map(Card::getRank)
                .filter(ranks::contains)
                .count();

        return (int) count;
    }

    private void calculateHighCards() {
        highSpades = calculateHighCardsFor(SPADES);
        highHearts = calculateHighCardsFor(Suit.HEARTS);
        highDiamonds = calculateHighCardsFor(Suit.DIAMONDS);
        highClubs = calculateHighCardsFor(Suit.CLUBS);
    }


    public void calculateKings() {
        kings = (int) cards.stream().filter(card -> card.getRank() == Rank.KING).count();
    }

    public void calculateAces() {
        aces = (int) cards.stream().filter(card -> card.getRank() == Rank.ACE).count();
    }

    public void updateCanOpen(int totalPointCount) {
        canOpen = totalPointCount > 12;
    }

    public void updateCanBidTwoLevel(int totalPointCount) {
        canBidTwoLevel = totalPointCount > 10;
    }

    private void calculateTotalPoints() {

        totalPointCount = highCardPoints
                + distributionPoints;
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

    public double getQuickTricks() {
        return quickTricks;
    }

    public int getLongSuitPoints() { return longSuitPoints; }

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
                ", quickTricks=" + quickTricks +
                '}';
    }
}
