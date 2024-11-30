package com.example.soccerhighlights;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.soccerhighlights.adapter.MatchAdapter;
import com.example.soccerhighlights.model.Match;
import com.example.soccerhighlights.network.ApiClient;
import com.example.soccerhighlights.network.ApiService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private MatchAdapter matchAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        fetchMatchData();
    }

    private void fetchMatchData() {
        ApiService apiService = ApiClient.getClient().create(ApiService.class);
        Call<List<Match>> call = apiService.getRecentMatches();

        call.enqueue(new Callback<List<Match>>() {
            @Override
            public void onResponse(Call<List<Match>> call, Response<List<Match>> response) {
                if (response.isSuccessful()) {
                    List<Match> matchList = response.body();
                    matchAdapter = new MatchAdapter(matchList, new MatchAdapter.OnMatchClickListener() {
                        @Override
                        public void onMatchClick(Match match) {
                            Intent intent = new Intent(MainActivity.this, DetailsActivity.class);
                            intent.putExtra("match", match);
                            startActivity(intent);
                        }
                    });
                    recyclerView.setAdapter(matchAdapter);
                } else {
                    Toast.makeText(MainActivity.this, "Failed to load matches", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<Match>> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Error: " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
