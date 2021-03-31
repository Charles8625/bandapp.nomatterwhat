package com.woythaltech.bandapp.nomatterwhat;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class ShowsFragment extends Fragment implements View.OnClickListener{

    public final static List<Show> showList = new ArrayList<>();
    private RecyclerView recyclerView;
    private ShowAdapter showAdapter;

    public ShowsFragment() {

    }

    static ShowsFragment newInstance() {
        return new ShowsFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View showFragView =  inflater.inflate(R.layout.fragment_shows, container, false);


        // Testing purposes
        showList.clear();

        for (int i = 0; i < 11; i++){
            showList.add(new Show("Irish Mill", "123 Route 83, " +
                    "Mundelein IL 60060", "3/7/21", "7:00pm"));
        }

        //////////////////////////////

        recyclerView = showFragView.findViewById(R.id.recyclerViewShows);
        showAdapter = new ShowsFragment.ShowAdapter();
        recyclerView.setAdapter(showAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getContext()));

        return showFragView;
    }

    @Override
    public void onClick(View v) {

    }

    // ViewHolder Class

    static class ShowViewHolder extends RecyclerView.ViewHolder {

        TextView showVenue;
        TextView showAddress;
        TextView showTime;
        TextView showDate;

        public ShowViewHolder(@NonNull @NotNull View itemView) {

            super(itemView);

            showVenue = itemView.findViewById(R.id.showVenue);
            showAddress = itemView.findViewById(R.id.showAddress);
            showTime= itemView.findViewById(R.id.showTime);
            showDate = itemView.findViewById(R.id.showDate);

        }
    }


    // ShowAdapter Class

    class ShowAdapter extends RecyclerView.Adapter<ShowsFragment.ShowViewHolder>{


        @NonNull
        @Override
        public ShowsFragment.ShowViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View itemView = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.show_row, parent, false);

            itemView.setOnClickListener(ShowsFragment.this);
            return new ShowsFragment.ShowViewHolder(itemView);
        }

        @Override
        public void onBindViewHolder(@NonNull @NotNull ShowsFragment.ShowViewHolder holder, int position) {

            Show show = showList.get(position);

            holder.showVenue.setText(show.getShowVenue());
            holder.showDate.setText(show.getShowDate());
            holder.showTime.setText(show.getShowTime());
            holder.showAddress.setText(show.getShowAddress());

        }

        @Override
        public int getItemCount() {
            return showList.size();
        }
    }
}