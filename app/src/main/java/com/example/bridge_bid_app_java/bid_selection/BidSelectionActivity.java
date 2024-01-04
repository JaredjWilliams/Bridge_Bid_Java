package com.example.bridge_bid_app_java.bid_selection;

import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

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
        updateCurrentPlayerText(presenter.getGame().getDealer().name());
        updateSuggestedBidText(null);
        updateBidGridView(false);
    }

    @Override
    public void updateSuggestedBidText(String bidName) {
        if (bidName != null) {
            suggestedBid.setText("Suggested Bid: " + bidName);
        }
    }

    @Override
    public void updateCurrentPlayerText(String name) {
        currentPlayer.setText(name);
    }

    @Override
    public void updateBidGridView(boolean update) {
        ViewGroup.MarginLayoutParams params = new ViewGroup.MarginLayoutParams(200, 200);
        params.setMargins(10,10,10,10);

        if (update) {
            removeBidsForGrid();
        }

        for (BidSelection bidSelection : BidSelection.values()) {
            createBid(bidSelection, params);
        }
    }

    private void removeBidsForGrid() {
        bidGrid.removeAllViews();
    }

    private void createBid(BidSelection bidSelection, ViewGroup.LayoutParams params) {
        TextView bidImage = new TextView(this);

        bidImage.setPadding(10, 10, 10, 10);
        bidImage.setBackgroundResource(bidSelection.getImage());
        bidImage.setLayoutParams(params);
        bidImage.setElevation(4.0f);
        bidImage.setText(bidSelection.getName());
        bidImage.setGravity(Gravity.CENTER);
        bidImage.setTextColor(bidSelection.getColor());

        Drawable backgroundDrawable = getResources().getDrawable(bidSelection.getImage()).mutate();
        bidImage.setBackground(backgroundDrawable);

        if (!bidSelection.getEnabled()) {
            System.out.println(bidSelection);
            bidImage.getBackground().setColorFilter(Color.GRAY, PorterDuff.Mode.SRC_ATOP);
        }


        bidImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.onBidClicked(bidSelection);
            }
        });

        bidGrid.addView(bidImage);
    }

    private void retrieveGameFromGSON() {
        String gameJSON = getIntent().getStringExtra("gameObjectAsString");

        if (gameJSON != null) {
            Game game = Game.fromJson(gameJSON);
            presenter.setGame(game);
            presenter.createBidGenerator();
        }
    }


}
