package com.woythaltech.bandapp.nomatterwhat;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class VIPFragment extends Fragment {

    public VIPFragment() {
        // Required empty public constructor
    }

    static VIPFragment newInstance() {
        return new VIPFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_vip, container, false);

        return view;
    }
}