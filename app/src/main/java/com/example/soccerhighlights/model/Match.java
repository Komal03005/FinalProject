package com.example.soccerhighlights.model;

import java.io.Serializable;

public class Match implements Serializable {

    private String date;
    private String homeTeam;
    private String awayTeam;
    private String highlightUrl;

    // Getters and setters
    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getHomeTeam() {
        return homeTeam;
    }

    public void setHomeTeam(String homeTeam) {
        this.homeTeam = homeTeam;
    }

    public String getAwayTeam() {
        return awayTeam;
    }

    public void setAwayTeam(String awayTeam) {
        this.awayTeam = awayTeam;
    }

    public String getHighlightUrl() {
        return highlightUrl;
    }

    public void setHighlightUrl(String highlightUrl) {
        this.highlightUrl = highlightUrl;
    }
}
