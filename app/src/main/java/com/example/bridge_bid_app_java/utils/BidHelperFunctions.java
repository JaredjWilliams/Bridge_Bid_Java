package com.example.bridge_bid_app_java.utils;

import com.example.bridge_bid_app_java.game.Game;
import com.example.bridge_bid_app_java.playing_cards.Suit;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class BidHelperFunctions {

    public static boolean isStopperHeldInUnbidSuits(Game game) {
        List<HashMap<Suit, Integer>> stoppers = Arrays.asList(
                game.getHand().getClubStoppers(),
                game.getHand().getDiamondStoppers(),
                game.getHand().getHeartStoppers(),
                game.getHand().getSpadeStoppers());

        for (Suit unbidSuit : game.getUnbidSuits()) {
            boolean isHeld = false;
            for (HashMap<Suit, Integer> map : stoppers) {
                if (map.containsKey(unbidSuit) && map.get(unbidSuit) > 0) {
                    isHeld = true;
                    break;
                }
            }
            if (!isHeld) {
                return false;
            }
        }

        return true;
    }
}
