package com.example.bridge_bid_app_java.card_selection;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.bridge_bid_app_java.R;
import com.example.bridge_bid_app_java.playing_cards.Card;
import com.example.bridge_bid_app_java.playing_cards.Suit;

public class CardSelectionActivity extends AppCompatActivity implements CardSelectionInterface {

    CardSelectionPresenter presenter = new CardSelectionPresenter(this);
    private TextView cardCounterTextView;
    private TextView totalPointCounterTextView;
    private GridLayout cardGrid;
    private Suit currentSuit = Suit.CLUBS;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



        setContentView(R.layout.activity_card_selection);
        setupViews();
        updateCardGrid(currentSuit, false);
    }

    private void setupViews() {
        cardGrid = findViewById(R.id.card_selection);
        cardCounterTextView = findViewById(R.id.card_counter);
        totalPointCounterTextView = findViewById(R.id.total_point_counter);
    }

    public void updateCardGrid(Suit suit, boolean update) {
        ViewGroup.MarginLayoutParams params = new ViewGroup.MarginLayoutParams(324, 424);
        params.setMargins(10, 10, 10, 10);

        if (update) {
            cardGrid.removeAllViews();
        }

        for (Card card : Card.values()) {
            if (suit == card.getSuit()) {
                createCardGrid(cardGrid, params, card);
            }
        }
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
}
