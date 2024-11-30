package com.example.soccerhighlights.network;

import com.example.soccerhighlights.model.Match;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {
    @GET("matches")
    Call<List<Match>> getRecentMatches();
}
