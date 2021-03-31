package com.woythaltech.bandapp.nomatterwhat;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.support.v4.app.INotificationSideChannel;
import android.util.Patterns;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import org.jetbrains.annotations.NotNull;

import java.util.regex.Pattern;

public class VIPFragment extends Fragment {

    private static final String TAG = "VIPFragment";
    private View view;
    private FirebaseAuth mAuth;
    private TextView vipEmail;
    private TextView vipPassword;


    public VIPFragment() {

    }

    static VIPFragment newInstance() {
        return new VIPFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {



        view = inflater.inflate(R.layout.fragment_vip, container, false);

        mAuth = FirebaseAuth.getInstance();

        vipEmail = view.findViewById(R.id.vipEmail);
        vipPassword = view.findViewById(R.id.vipPassword);

        view.findViewById(R.id.vipLogin).setOnClickListener(v -> login());
        view.findViewById(R.id.becomeVIP).setOnClickListener(v -> becomeVIP());
        view.findViewById(R.id.forgotPW).setOnClickListener(v -> forgotPW());

        return view;
    }

    private void login() {
        userLogin();
    }

    private void becomeVIP() {
        Intent intent = new Intent(this.getActivity(), BecomeVIP.class);
        startActivity(intent);
    }

    private void forgotPW() {
        Toast.makeText(this.getActivity(), "Get new PW", Toast.LENGTH_SHORT).show();
    }

    private void userLogin() {

        String email = vipEmail.getText().toString().trim();
        String password = vipPassword.getText().toString().trim();

        if(email.isEmpty() || !Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            vipEmail.setError("Please enter a valid email");
            vipEmail.requestFocus();
            return;
        }

        if(password.isEmpty()){
            vipPassword.setError("Password is Required");
            vipPassword.requestFocus();
            return;
        }

        if(password.length() < 8){
            vipPassword.setError("Password must be at least 8 Character");
            vipPassword.requestFocus();
        }

        mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(task -> {
            if(task.isSuccessful()){
                // Go to Profile Activity
                startActivity(new Intent(getActivity(), Profile.class));
            } else {
                Toast.makeText(getActivity(), "Failed to Login. Please check your credentials", Toast.LENGTH_SHORT).show();
            }
        });
    }

}