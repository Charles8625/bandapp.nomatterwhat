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

public class VideosFragment extends Fragment implements View.OnClickListener{

    public final static List<Video> videoList = new ArrayList<>();
    private RecyclerView recyclerView;
    private VideosFragment.VideosAdapter videosAdapter;

    public VideosFragment() {

    }

    static VideosFragment newInstance() {
        return new VideosFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View videoFragView =  inflater.inflate(R.layout.fragment_videos, container, false);

        videoList.clear();

        for (int i = 0; i < 6; i++){
            videoList.add(new Video("April 20th 202" + i + " The House of Blues"));
        }

        recyclerView = videoFragView.findViewById(R.id.recyclerViewVideos);
        videosAdapter = new VideosAdapter();
        recyclerView.setAdapter(videosAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getContext()));

        return videoFragView;
    }

    @Override
    public void onClick(View v) {

    }


    // ViewHolder Class

    static class VideosViewHolder extends RecyclerView.ViewHolder {

        TextView videoDescription;


        public VideosViewHolder(@NonNull @NotNull View itemView) {

            super(itemView);

            videoDescription = itemView.findViewById(R.id.videoDescription);


        }

    }


    // Adapter Class

    class VideosAdapter extends RecyclerView.Adapter<VideosFragment.VideosViewHolder>{

        @NonNull
        @Override
        public VideosFragment.VideosViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View itemView = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.video_row, parent, false);

            itemView.setOnClickListener(VideosFragment.this);
            return new VideosViewHolder(itemView);
        }

        @Override
        public void onBindViewHolder(@NonNull @NotNull VideosFragment.VideosViewHolder holder, int position) {

            Video video = videoList.get(position);
            holder.videoDescription.setText(video.getVideoDescription());

        }

        @Override
        public int getItemCount() {
            return videoList.size();
        }
    }
}