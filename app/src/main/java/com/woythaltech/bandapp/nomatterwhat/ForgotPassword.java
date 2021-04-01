package com.woythaltech.bandapp.nomatterwhat;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

import org.jetbrains.annotations.NotNull;

public class ForgotPassword extends AppCompatActivity {

    private TextView forgotPWEmail;
    private Button retrievePW;
    private FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);

        auth = FirebaseAuth.getInstance();

        forgotPWEmail = findViewById(R.id.forgotPWEmail);
        retrievePW = findViewById(R.id.retrievePW);

        retrievePW.setOnClickListener(v -> {
            resetPassword();
        });

    }

    private void resetPassword() {
        String email = forgotPWEmail.getText().toString().trim();

        if (email.isEmpty()){
            forgotPWEmail.setError("Email Required");
            forgotPWEmail.requestFocus();
            return;
        }

        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            forgotPWEmail.setError("Enter Valid Email");
            forgotPWEmail.requestFocus();
            return;
        }
        auth.sendPasswordResetEmail(email).addOnCompleteListener(task -> {
            if (task.isSuccessful()) {
                Toast.makeText(this, "Check your email", Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(this, "Try again. Something went wrong", Toast.LENGTH_SHORT).show();
            }
        });
    }
}