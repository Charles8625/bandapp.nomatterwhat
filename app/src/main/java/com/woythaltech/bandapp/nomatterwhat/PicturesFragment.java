package com.woythaltech.bandapp.nomatterwhat;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link PicturesFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PicturesFragment extends Fragment {

    public PicturesFragment() {
        // Required empty public constructor
    }

    static PicturesFragment newInstance() {
        return new PicturesFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_pictures, container, false);

        return view;
    }
}