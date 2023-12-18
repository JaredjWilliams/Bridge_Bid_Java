package com.example.bridge_bid_app_java;

import static com.example.bridge_bid_app_java.utils.TargetHandGenerator.createTargetedHand;
import static org.junit.Assert.assertEquals;

import com.example.bridge_bid_app_java.bids.Bid;
import com.example.bridge_bid_app_java.game.BidSelection;
import com.example.bridge_bid_app_java.game.Game;
import com.example.bridge_bid_app_java.playing_cards.Card;
import com.example.bridge_bid_app_java.playing_cards.Hand;

import org.junit.Test;

import java.util.List;

public class BidTests {

    List<Card> mockFullHand = List.of(Card.FOUR_DIAMONDS, Card.TWO_HEARTS, Card.SIX_HEARTS, Card.ACE_DIAMONDS,
            Card.KING_HEARTS, Card.TEN_HEARTS, Card.THREE_SPADES, Card.NINE_DIAMONDS, Card.THREE_CLUBS,
            Card.JACK_SPADES, Card.QUEEN_DIAMONDS, Card.SIX_DIAMONDS, Card.FIVE_CLUBS);
    List<Card> mockThreeClubs = List.of(Card.ACE_CLUBS, Card.KING_CLUBS, Card.QUEEN_CLUBS, Card.NINE_CLUBS,
            Card.EIGHT_CLUBS, Card.SIX_CLUBS, Card.THREE_CLUBS, Card.KING_DIAMONDS, Card.NINE_DIAMONDS,
            Card.SIX_SPADES, Card.FOUR_SPADES, Card.KING_HEARTS, Card.TEN_HEARTS);
    List<Card> mockOneDiamond = List.of(Card.ACE_DIAMONDS, Card.KING_DIAMONDS, Card.QUEEN_DIAMONDS, Card.JACK_DIAMONDS,
            Card.ACE_CLUBS);



    @Test
    public void testBidOpenerPass() {
        Game game = new Game();
        Hand hand = new Hand(mockFullHand);
        game.setHand(hand);
        Bid bid = new Bid(game);

        System.out.println(createTargetedHand(13, 2, 2, 2, 7));

        assertEquals(BidSelection.PASS, bid.getRecommendedBid());
    }

    @Test
    public void testBidOpenerThreeClub() {
        Game game = new Game();
        game.setHand(createTargetedHand(13, 2, 2, 2, 7));
        Bid bid = new Bid(game);

        assertEquals(BidSelection.THREE_CLUBS, bid.getRecommendedBid());
    }


}
