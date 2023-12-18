package com.example.bridge_bid_app_java.bid_selection;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import com.example.bridge_bid_app_java.R;
import com.example.bridge_bid_app_java.game.BidSelection;
import com.example.bridge_bid_app_java.game.Game;

public class BidSelectionActivity extends AppCompatActivity implements BidSelectionInterface {

    private GridLayout bidGrid;
    private TextView currentPlayer;
    private BidSelectionPresenter presenter;
    private TextView suggestedBid;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_bid_selection);
        presenter = new BidSelectionPresenter(this);
        retrieveGameFromGSON();

        setViews();
        initializeViews();
    }

    private void setViews() {
        bidGrid = findViewById(R.id.bid_grid_view);
        currentPlayer = findViewById(R.id.current_player);
        suggestedBid = findViewById(R.id.suggested_bid);
    }

    private void initializeViews() {
        createCurrentPlayerText(presenter.getGame().getDealer().name());
        initializeBidGridView();
    }

    private void createCurrentPlayerText(String name) {
        currentPlayer.setText(name);
    }

    private void initializeBidGridView() {
        ViewGroup.MarginLayoutParams params = new ViewGroup.MarginLayoutParams(200, 200);
        params.setMargins(10,10,10,10);

        for (BidSelection bidSelection : BidSelection.values()) {
            createBid(bidSelection, params);
        }
    }

    private void createBid(BidSelection bidSelection, ViewGroup.LayoutParams params) {
        TextView bidImage = new TextView(this);

        bidImage.setPadding(10, 10, 10, 10);
        bidImage.setBackground(ContextCompat.getDrawable(this, bidSelection.getImage()));
        bidImage.setLayoutParams(params);
        bidImage.setElevation(4.0f);
        bidImage.setText(bidSelection.getName());
        bidImage.setGravity(Gravity.CENTER);
        bidImage.setTextColor(bidSelection.getColor());

        bidImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        bidGrid.addView(bidImage);
    }

    private void retrieveGameFromGSON() {
        String gameJSON = getIntent().getStringExtra("gameObjectAsString");

        if (gameJSON != null) {
            Game game = Game.fromJson(gameJSON);
            presenter.setGame(game);
        }
    }


}
