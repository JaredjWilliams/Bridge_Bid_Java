package com.example.bridge_bid_app_java.card_selection;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.bridge_bid_app_java.R;
import com.example.bridge_bid_app_java.bid_selection.BidSelectionActivity;
import com.example.bridge_bid_app_java.game.Player;
import com.example.bridge_bid_app_java.playing_cards.Card;
import com.example.bridge_bid_app_java.playing_cards.Suit;

public class CardSelectionActivity extends AppCompatActivity implements CardSelectionInterface {

    CardSelectionPresenter presenter = new CardSelectionPresenter(this);
    private final Suit currentSuit = Suit.CLUBS;

    private Button createRandomHandButton;
    private TextView totalPointCounterTextView;
    private RadioButton rightOpponentButton;
    private RadioButton leftOpponentButton;
    private TextView cardCounterTextView;
    private RadioButton partnerButton;
    private RadioButton userButton;
    private GridLayout cardGrid;

    private Button nextButton;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_card_selection);
        setupViews();

        updateCardGrid(currentSuit, false);
        createStrongOrWeak2CheckMark();
        createSuitSelectionImages();
        createRadioButtons();
        createNextButton();
        createRandomHandButton();
        setCardCounterTextView(0);
        setTotalPointCounter(0);
    }

    private void setupViews() {
        totalPointCounterTextView = findViewById(R.id.total_point_counter);
        rightOpponentButton = findViewById(R.id.right_opp_radio_button);
        leftOpponentButton = findViewById(R.id.left_opp_radio_button);
        partnerButton = findViewById(R.id.partner_radio_button);
        cardCounterTextView = findViewById(R.id.card_counter);
        userButton = findViewById(R.id.user_radio_button);
        cardGrid = findViewById(R.id.card_selection);
        nextButton = findViewById(R.id.next_button);

        createRandomHandButton = findViewById(R.id.random_hand_button);
    }

    private void createSuitSelectionImages() {
        suitSelectionImage(R.id.diamond_suit, R.drawable.card_suit_diamonds, Suit.DIAMONDS);
        suitSelectionImage(R.id.spade_suit, R.drawable.card_suit_spades, Suit.SPADES);
        suitSelectionImage(R.id.heart_suit, R.drawable.card_suit_heats, Suit.HEARTS);
        suitSelectionImage(R.id.club_suit, R.drawable.card_suit_clubs, Suit.CLUBS);
    }

    private void createRadioButtons() {
        createRadioButton(rightOpponentButton, Player.RIGHT_OPPONENT);
        createRadioButton(leftOpponentButton, Player.LEFT_OPPONENT);
        createRadioButton(partnerButton, Player.PARTNER);
        createRadioButton(userButton, Player.USER);
    }

    private void createRandomHandButton() {
        createRandomHandButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.createRandomHand();
                updateCardGrid(Suit.CLUBS, true);
            }
        });
    }

    private void createNextButton() {
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.updateHand();
                startBidActivity();
            }
        });
    }

    private void createStrongOrWeak2CheckMark() {
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean isStrong2 = Player.PARTNER.getPlayerStrong2Bid();
                presenter.updatePartnerStrong2Bid(!isStrong2);
            }
        });
    }

    private void startBidActivity() {
        Intent bidSelectionActivity = new Intent(this, BidSelectionActivity.class);
        bidSelectionActivity.putExtra("gameObjectAsString", presenter.gameToGSON(presenter.getGame()));
        startActivity(bidSelectionActivity);
    }

    private void createRadioButton(RadioButton button, Player player) {
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.updateDealer(player);
                presenter.updateNextButton(presenter.getHand(), presenter.getGame().getDealer());
            }
        });
    }


    private void suitSelectionImage(int id, int image, Suit suit) {
        ImageView suitImage = findViewById(id);

        suitImage.setImageResource(image);
        suitImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateCardGrid(suit, true);
            }
        });
    }

    @Override
    public void updateCardGrid(Suit suit, boolean update) {
        ViewGroup.MarginLayoutParams params = new ViewGroup.MarginLayoutParams(324, 424);
        params.setMargins(10, 10, 10, 10);

        if (update) {
            removeCardFromCardGrid();
        }

        for (Card card : Card.values()) {
            if (suit == card.getSuit()) {
                createCardGrid(cardGrid, params, card);
            }
        }
    }

    @Override
    public void removeCardFromCardGrid() {
        cardGrid.removeAllViews();
    }

    private void createCardGrid(GridLayout cardGrid, ViewGroup.LayoutParams params, Card card) {
        final ImageView[] cardImage = {new ImageView(this)};

        cardImage[0].setBackgroundResource(card.isSelected() ? R.drawable.selected_card_background : 0);
        cardImage[0].setPadding(10,10,10,10);
        cardImage[0].setImageResource(card.getImage());
        cardImage[0].setLayoutParams(params);
        cardImage[0].setElevation(4.0f);

        cardImage[0].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cardImage[0] = presenter.onCardPressed(cardImage[0], card);
            }
        });

        cardGrid.addView(cardImage[0]);
    }

    @Override
    public void setCardCounterTextView(int count) {
        cardCounterTextView.setText("Cards Selected: " + count);
    }
    @Override
    public void setTotalPointCounter(int count) {
        totalPointCounterTextView.setText("Current Points: " + count);
    }
    @Override
    public void enabledNextButton(boolean isEnabled) {
        nextButton.setEnabled(isEnabled);
    }
    @Override
    public void setCardCounterColor(String color) {
        cardCounterTextView.setTextColor(Color.parseColor(color));
    }
}
