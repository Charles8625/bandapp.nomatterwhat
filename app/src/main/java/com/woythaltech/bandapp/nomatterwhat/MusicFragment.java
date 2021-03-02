package com.woythaltech.bandapp.nomatterwhat;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.text.method.ScrollingMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;


public class MusicFragment extends Fragment implements View.OnClickListener {

    public final static List<Song> songList = new ArrayList<>();
    private RecyclerView recyclerView;
    private MusicAdapter musicAdapter;

    public MusicFragment() {
        // Required empty public constructor
    }

    static MusicFragment newInstance() {
        return new MusicFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View musicFragView =  inflater.inflate(R.layout.fragment_music, container, false);


        // For testing purposes
        Song trance = new Song("Trance", "No Matter What", "2017");
        Song locked = new Song("Locked and Loaded", "No Matter What", "2017");
        Song biPolar = new Song("Bi-Polar", "No Matter What", "2017");

        songList.add(trance);
        songList.add(locked);
        songList.add(biPolar);

        recyclerView = musicFragView.findViewById(R.id.recyclerViewMusic);
        musicAdapter = new MusicAdapter();
        recyclerView.setAdapter(musicAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getContext()));


        return musicFragView;
    }

    @Override
    public void onClick(View v) {


    }

    // ViewHolder Class

    static class MusicViewHolder extends RecyclerView.ViewHolder {

        TextView albumCover;
        TextView bandName;
        TextView songName;
        TextView releaseYear;

        public MusicViewHolder(@NonNull @NotNull View itemView) {

            super(itemView);

            bandName = itemView.findViewById(R.id.bandName);
            songName = itemView.findViewById(R.id.songName);
            releaseYear = itemView.findViewById(R.id.releaseYear);


        }
    }


    // MusicAdapter Class

    class MusicAdapter extends RecyclerView.Adapter<MusicViewHolder>{


        @NonNull
        @Override
        public MusicViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View itemView = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.music_row, parent, false);

            itemView.setOnClickListener(MusicFragment.this);
            return new MusicViewHolder(itemView);
        }

        @Override
        public void onBindViewHolder(@NonNull @NotNull MusicViewHolder holder, int position) {
            Song song = songList.get(position);
            holder.bandName.setText(song.getBandName());
            holder.songName.setText(song.getSongName());
            holder.releaseYear.setText(song.getReleaseYear());

        }

        @Override
        public int getItemCount() {
            return songList.size();
        }
    }

}



