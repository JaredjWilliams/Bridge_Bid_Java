package com.example.bridge_bid_app_java.partner_open;

import static com.example.bridge_bid_app_java.utils.TargetHandGenerator.createTargetedHandWith;
import static com.example.bridge_bid_app_java.utils.TargetHandGenerator.createTargetedHandWithTargetedQuickTricks;
import static org.junit.Assert.assertEquals;

import com.example.bridge_bid_app_java.bids.BidGenerator;
import com.example.bridge_bid_app_java.game.BidSelection;
import com.example.bridge_bid_app_java.game.Game;
import com.example.bridge_bid_app_java.game.Player;
import com.example.bridge_bid_app_java.playing_cards.Card;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class ResponseToThreeTests {

    private Game game;
    private BidGenerator bidGenerator;

    @Before
    public void setUp() {
        game = new Game();
        game.setOpener(Player.PARTNER);
        bidGenerator = new BidGenerator(BidSelection.PASS, game);
    }

    // WHEN: Quick Tricks is greater than or equal to 5
    // AND: Partner opened with 3 clubs
    // RESULT: Five Clubs is bid
    @Test
    public void testFiveClubs() {
        List<Card> included = List.of(
                Card.ACE_SPADES, Card.KING_SPADES, Card.KING_HEARTS, Card.QUEEN_HEARTS,
                Card.ACE_DIAMONDS, Card.KING_DIAMONDS
        );
        game.setHand(createTargetedHandWith(20, 5, 3, 3, 2,
                included));

        bidGenerator.updateRecommendedBid(BidSelection.THREE_CLUBS, game);
        System.out.println(game.getHand());

        assertEquals(BidSelection.FIVE_CLUBS, bidGenerator.getRecommendedBid());
    }

    // WHEN: Quick Tricks is less than 5
    // AND: Partner opened with 3 clubs
    // RESULT: Pass
    @Test
    public void testPass() {
        game.setHand(createTargetedHandWithTargetedQuickTricks(4, 4, 4, 3, 2));
        bidGenerator.updateRecommendedBid(BidSelection.THREE_CLUBS, game);
        System.out.println(game.getHand());

        assertEquals(BidSelection.PASS, bidGenerator.getRecommendedBid());
    }

    // WHEN: Quick Tricks is greater than or equal to 5
    // AND: Partner opened 3 diamonds
    // RESULT: 5 Diamonds
    @Test
    public void testThreeDiamonds() {
        game.setHand(createTargetedHandWithTargetedQuickTricks(5, 4, 4, 1, 4));

        bidGenerator.updateRecommendedBid(BidSelection.THREE_DIAMONDS, game);
        System.out.println(game.getHand());

        assertEquals(BidSelection.FIVE_DIAMONDS, bidGenerator.getRecommendedBid());
    }

    // WHEN: Quick Tricks is less than 5
    // AND: Partner opened 3 diamonds
    // RESULT: Pass
    @Test
    public void testPassForThreeDiamonds() {
        game.setHand(createTargetedHandWithTargetedQuickTricks(4, 4, 4, 1, 4));

        bidGenerator.updateRecommendedBid(BidSelection.THREE_DIAMONDS, game);
        System.out.println(game.getHand());

        assertEquals(BidSelection.PASS, bidGenerator.getRecommendedBid());
    }

    // WHEN: Quick Tricks is greater than or equal to 4
    // AND: Partner opened 3 spades
    // RESULT: 4 Spades is bid
    @Test
    public void testFourSpades() {
        game.setHand(createTargetedHandWithTargetedQuickTricks(4, 1, 4, 4, 4));

        bidGenerator.updateRecommendedBid(BidSelection.THREE_SPADES, game);
        System.out.println(game.getHand());

        assertEquals(BidSelection.FOUR_SPADES, bidGenerator.getRecommendedBid());
    }

    // WHEN: Quick Tricks is less than 4
    // AND: Partner opened 3 Spades
    // RESULT: Pass
    @Test
    public void testPassForThreeSpades() {
        game.setHand(createTargetedHandWithTargetedQuickTricks(3, 1, 4, 4, 4));

        bidGenerator.updateRecommendedBid(BidSelection.THREE_SPADES, game);
        System.out.println(game.getHand());

        assertEquals(BidSelection.PASS, bidGenerator.getRecommendedBid());
    }

    // WHEN: Quick Tricks is greater than or equal to 4
    // AND: Partner opened 3 Hearts
    // RESULT: 4 Hearts is bid
    @Test
    public void testFourHearts() {
        game.setHand(createTargetedHandWithTargetedQuickTricks(4, 4, 1, 4, 4));

        bidGenerator.updateRecommendedBid(BidSelection.THREE_HEARTS, game);
        System.out.println(game.getHand());

        assertEquals(BidSelection.FOUR_HEARTS, bidGenerator.getRecommendedBid());
    }
}
