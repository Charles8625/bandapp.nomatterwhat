package com.woythaltech.bandapp.nomatterwhat;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class MerchFragment extends Fragment {

    public MerchFragment() {

    }

    static MerchFragment newInstance() {
        return new MerchFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_merch, container, false);

        return view;
    }
}