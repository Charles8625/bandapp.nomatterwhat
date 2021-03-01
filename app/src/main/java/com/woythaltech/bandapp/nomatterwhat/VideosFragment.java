package com.woythaltech.bandapp.nomatterwhat;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class VideosFragment extends Fragment {

    public VideosFragment() {
        // Required empty public constructor
    }

    static VideosFragment newInstance() {
        return new VideosFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_videos, container, false);

        return view;
    }
}