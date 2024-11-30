package com.example.soccerhighlights;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.soccerhighlights.R;
import com.example.soccerhighlights.model.Match;

import java.util.List;

public class MatchAdapter extends RecyclerView.Adapter<MatchAdapter.MatchViewHolder> {

    private List<Match> matchList;
    private OnMatchClickListener listener;

    public interface OnMatchClickListener {
        void onMatchClick(Match match);
    }

    public MatchAdapter(List<Match> matchList, OnMatchClickListener listener) {
        this.matchList = matchList;
        this.listener = listener;
    }

    @Override
    public MatchViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_match, parent, false);
        return new MatchViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MatchViewHolder holder, int position) {
        Match match = matchList.get(position);
        holder.homeTeam.setText(match.getHomeTeam());
        holder.awayTeam.setText(match.getAwayTeam());
        holder.itemView.setOnClickListener(v -> listener.onMatchClick(match));
    }

    @Override
    public int getItemCount() {
        return matchList.size();
    }

    public static class MatchViewHolder extends RecyclerView.ViewHolder {
        TextView homeTeam, awayTeam;

        public MatchViewHolder(View itemView) {
            super(itemView);
            homeTeam = itemView.findViewById(R.id.homeTeam);
            awayTeam = itemView.findViewById(R.id.awayTeam);
        }
    }
}
