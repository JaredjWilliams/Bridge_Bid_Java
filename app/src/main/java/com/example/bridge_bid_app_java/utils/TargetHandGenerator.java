package com.example.bridge_bid_app_java.utils;

import com.example.bridge_bid_app_java.playing_cards.Card;
import com.example.bridge_bid_app_java.playing_cards.Hand;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class TargetHandGenerator {

    public static Hand createAndFillAndRandomHand() {
        return new Hand(createRandomHand());
    }

    private static List<Card> createRandomHand() {
        List<Card> hand = new ArrayList<>();
        List<Card> cards = new ArrayList<>(Arrays.asList(Card.values()));
        Random random = new Random();
        int bound = 52;

        for (int i = 0; i < 13; i++) {

            int n = random.nextInt(bound);
            Card card = cards.get(n);
            cards.remove(card);
            card.isSelected(true);
            hand.add(card);
            bound--;
        }

        return hand;
    }

    private static List<Card> fillRandomHand(List<Card> preselectedCards) {
        List<Card> hand = new ArrayList<>(preselectedCards);
        List<Card> cards = new ArrayList<>(Arrays.asList(Card.values()));
        cards.removeAll(preselectedCards);
        Random random = new Random();
        int bound = cards.size();

        while (hand.size() != 13) {
            int n = random.nextInt(bound);
            Card card = cards.get(n);
            cards.remove(card);
            card.isSelected(true);
            hand.add(card);
            bound--;
        }

        return hand;
    }

    private static List<Card> fillRandomHand(List<Card> preselectedCards, List<Card> leftOut) {
        List<Card> hand = new ArrayList<>(preselectedCards);
        List<Card> cards = new ArrayList<>(Arrays.asList(Card.values()));
        cards.removeAll(preselectedCards);
        cards.removeAll(leftOut);
        Random random = new Random();
        int bound = cards.size();

        while (hand.size() != 13) {
            int n = random.nextInt(bound);
            Card card = cards.get(n);
            cards.remove(card);
            card.isSelected(true);
            hand.add(card);
            bound--;
        }

        return hand;
    }

    private static List<Card> fillRandomHandWithout(List<Card> preselectedCards) {
        List<Card> hand = new ArrayList<>();
        List<Card> cards = new ArrayList<>(Arrays.asList(Card.values()));
        cards.removeAll(preselectedCards);
        Random random = new Random();
        int bound = cards.size();

        while (hand.size() != 13) {
            int n = random.nextInt(bound);
            Card card = cards.get(n);
            cards.remove(card);
            card.isSelected(true);
            hand.add(card);
            bound--;
        }

        return hand;
    }

    public static Hand createTargetedHandWithout(int totalPoints, int spades, int hearts, int diamonds, int clubs, List<Card> cards) {
        Hand hand;

        do {
            hand = new Hand(fillRandomHandWithout(cards));
        } while (hand.getTotalPointCount() != totalPoints ||
                hand.getSpades() != spades ||
                hand.getHearts() != hearts ||
                hand.getDiamonds() != diamonds ||
                hand.getClubs() != clubs);

        return hand;
    }

    public static Hand createTargetedHand(int totalPoints, int hcp, int spades, int hearts, int diamonds, int clubs) {
        Hand hand;

        do {
            hand = new Hand(createRandomHand());
        } while (hand.getTotalPointCount() != totalPoints ||
                hand.getSpades() != spades ||
                hand.getHearts() != hearts ||
                hand.getDiamonds() != diamonds ||
                hand.getClubs() != clubs ||
                hand.getHighCardPoints() != hcp);

        return hand;
    }

    public static Hand createTargetedHand(int totalPoints, int spades, int hearts, int diamonds, int clubs) {
        Hand hand;

        do {
            hand = new Hand(createRandomHand());
        } while (hand.getTotalPointCount() != totalPoints ||
                hand.getSpades() != spades ||
                hand.getHearts() != hearts ||
                hand.getDiamonds() != diamonds ||
                hand.getClubs() != clubs);

        return hand;
    }

    public static Hand createTargetedHandWith(int totalPoints, int spades, int hearts, int diamonds, int clubs, List<Card> cards) {
        Hand hand;

        do {
            hand = new Hand(fillRandomHand(cards));
        } while (hand.getTotalPointCount() != totalPoints ||
                hand.getSpades() != spades ||
                hand.getHearts() != hearts ||
                hand.getDiamonds() != diamonds ||
                hand.getClubs() != clubs);

        return hand;
    }

    public static Hand createTargetedHandWithTargetedQuickTricks(double quickTricks, int spades, int hearts, int diamonds, int clubs) {
        Hand hand;

        do {
            hand = new Hand(createRandomHand());
        } while (
                hand.getQuickTricks() != quickTricks ||
                hand.getSpades() != spades ||
                hand.getHearts() != hearts ||
                hand.getDiamonds() != diamonds ||
                hand.getClubs() != clubs
        );

        return hand;
    }

    public static Hand createTargetedHandWithAndWithout(int totalPoints, int spades, int hearts, int diamonds, int clubs, List<Card> cards, List<Card> notHeld) {
        Hand hand;

        do {
            hand = new Hand(fillRandomHand(cards, notHeld));
        } while (hand.getTotalPointCount() != totalPoints ||
                hand.getSpades() != spades ||
                hand.getHearts() != hearts ||
                hand.getDiamonds() != diamonds ||
                hand.getClubs() != clubs);

        return hand;
    }
}
