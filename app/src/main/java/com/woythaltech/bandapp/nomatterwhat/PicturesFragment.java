package com.woythaltech.bandapp.nomatterwhat;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;


public class PicturesFragment extends Fragment implements View.OnClickListener{

    public final static List<Picture> pictureList = new ArrayList<>();
    private RecyclerView recyclerView;
    private PicturesFragment.PicturesAdapter picturesAdapter;

    public PicturesFragment() {
        // Required empty public constructor
    }

    static PicturesFragment newInstance() {
        return new PicturesFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View picFragView =  inflater.inflate(R.layout.fragment_pictures, container, false);

        // For testing purposes add Pictures

        pictureList.clear();

        for (int i = 0; i < 6; i++){
            pictureList.add(new Picture("Hello", "World"));
        }


        ///////////////////////////////

        recyclerView = picFragView.findViewById(R.id.recyclerViewPictures);
        picturesAdapter = new PicturesAdapter();
        recyclerView.setAdapter(picturesAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getContext()));

        return picFragView;
    }

    @Override
    public void onClick(View v) {

    }

    // ViewHolder Class

    static class PicturesViewHolder extends RecyclerView.ViewHolder {


        TextView leftImageText;
        TextView rightImageText;


        public PicturesViewHolder(@NonNull @NotNull View itemView) {

            super(itemView);

            leftImageText = itemView.findViewById(R.id.leftImageText);
            rightImageText = itemView.findViewById(R.id.rightImageText);

        }

    }


    // PicturesAdapter Class

    class PicturesAdapter extends RecyclerView.Adapter<PicturesFragment.PicturesViewHolder>{

        @NonNull
        @Override
        public PicturesFragment.PicturesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View itemView = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.picture_row, parent, false);

            itemView.setOnClickListener(PicturesFragment.this);
            return new PicturesViewHolder(itemView);
        }

        @Override
        public void onBindViewHolder(@NonNull @NotNull PicturesFragment.PicturesViewHolder holder, int position) {
            Picture picture = pictureList.get(position);

            holder.leftImageText.setText(picture.getLeftImageText());
            holder.rightImageText.setText(picture.getRightImageText());


        }

        @Override
        public int getItemCount() {
            return pictureList.size();
        }
    }

}