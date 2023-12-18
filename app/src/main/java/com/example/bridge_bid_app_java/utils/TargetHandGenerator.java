package com.example.bridge_bid_app_java.utils;

import com.example.bridge_bid_app_java.playing_cards.Card;
import com.example.bridge_bid_app_java.playing_cards.Hand;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class TargetHandGenerator {

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
}
