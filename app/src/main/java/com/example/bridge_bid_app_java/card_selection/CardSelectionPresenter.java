package com.example.bridge_bid_app_java.card_selection;

import android.widget.ImageView;

import com.example.bridge_bid_app_java.R;
import com.example.bridge_bid_app_java.game.Game;
import com.example.bridge_bid_app_java.game.Player;
import com.example.bridge_bid_app_java.playing_cards.Card;
import com.example.bridge_bid_app_java.playing_cards.Hand;
import com.google.gson.Gson;

public class CardSelectionPresenter {
    private final CardSelectionInterface view;
    private final Hand hand = new Hand();
    private final Game game = new Game();

    public CardSelectionPresenter(CardSelectionInterface view) {
        this.view = view;
    }

    public ImageView onCardPressed(ImageView cardImage, Card card) {

        if (card.isSelected()) {
            card.isSelected(false);
            hand.removeCardFromHand(card);
            cardImage.setBackgroundResource(0);
        } else {
            card.isSelected(true);
            hand.addCard(card);
            cardImage.setBackgroundResource(R.drawable.selected_card_background);
        }

        view.setCardCounterTextView(hand.getCards().size());
        view.setTotalPointCounter(hand.getTotalPointCount());
        updateNextButton(hand, game.getDealer());
        updateCardCounterColor();

        return cardImage;
    }

    public void updateDealer(Player player) {
        game.setDealer(player);
    }

    public void updateHand() {
        game.setHand(hand);
    }

    public void updateNextButton(Hand hand, Player player) {
        view.enabledNextButton(isHandSize13(hand) && isDealerNotNull(player));
    }

    private boolean isHandSize13(Hand hand) {
        return hand.getCardsLength() == 13;
    }

    private boolean isDealerNotNull(Player player) {
        return player != null;
    }

    public void updateCardCounterColor() {
        if (hand.getCardsLength() > 13) {
            view.setCardCounterColor("#FF0000");
        } else if (hand.getCardsLength() == 13) {
            view.setCardCounterColor("#008000");
        } else {
            view.setCardCounterColor("#000000");
        }
    }

    public String gameToGSON(Game game) {
        Gson gson = new Gson();
        return gson.toJson(game);
    }

    public void updatePartnerStrong2Bid(boolean isStrong2) {
        Player.PARTNER.setPlayerStrong2Bid(isStrong2);
    }

    public Hand getHand() {
        return hand;
    }
    public Game getGame() {
        return game;
    }
}
