package com.example.soccerhighlights;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.soccerhighlights.model.Match;

public class DetailsActivity extends AppCompatActivity {

    private TextView matchDate, teamNames;
    private Button watchHighlightButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        matchDate = findViewById(R.id.matchDate);
        teamNames = findViewById(R.id.teamNames);
        watchHighlightButton = findViewById(R.id.watchHighlightButton);

        // Get the Match object passed from MainActivity
        Match match = (Match) getIntent().getSerializableExtra("match");

        if (match != null) {
            matchDate.setText("Match Date: " + match.getDate());
            teamNames.setText(match.getHomeTeam() + " vs " + match.getAwayTeam());

            // Handle the button click to open the video URL
            watchHighlightButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String videoUrl = match.getHighlightUrl(); // This should be the URL for the video
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(videoUrl));
                    startActivity(intent);
                }
            });
        }
    }
}
