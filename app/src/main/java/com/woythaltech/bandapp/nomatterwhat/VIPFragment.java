package com.woythaltech.bandapp.nomatterwhat;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.Objects;

public class VIPFragment extends Fragment{

    private static final String TAG = "VIPFragment";
    private View view;


    public VIPFragment() {

    }

    static VIPFragment newInstance() {
        return new VIPFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        view = inflater.inflate(R.layout.fragment_vip, container, false);

        view.findViewById(R.id.vipLogin).setOnClickListener(v -> login());
        view.findViewById(R.id.becomeVIP).setOnClickListener(v -> becomeVIP());
        view.findViewById(R.id.forgotPW).setOnClickListener(v -> forgotPW());

        return view;
    }

    private void login() {
        Toast.makeText(this.getActivity(), "Logging In", Toast.LENGTH_SHORT).show();
    }

    private void becomeVIP() {
        Intent intent = new Intent(this.getActivity(), BecomeVIP.class);
        startActivity(intent);
    }

    private void forgotPW() {
        Toast.makeText(this.getActivity(), "Get new PW", Toast.LENGTH_SHORT).show();
    }

}