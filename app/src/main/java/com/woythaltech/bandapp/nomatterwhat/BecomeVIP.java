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
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

import org.jetbrains.annotations.NotNull;

public class BecomeVIP extends AppCompatActivity implements View.OnClickListener {

    private Button register;
    private FirebaseAuth mAuth;
    private TextView name;
    private TextView email;
    private TextView password;
    private TextView confirmPW;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_become_vip);

        register = findViewById(R.id.register);
        register.setOnClickListener(this);

        name = findViewById(R.id.nameRegister);
        email = findViewById(R.id.emailRegister);
        password = findViewById(R.id.pwRegister);
        confirmPW = findViewById(R.id.pwRegister2);

        mAuth = FirebaseAuth.getInstance();

    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.register){
            registerUser();
        }

    }

    private void registerUser() {
        String email = this.email.getText().toString().trim();
        String name = this.name.getText().toString().trim();
        String password = this.password.getText().toString().trim();
        String confirmPW = this.confirmPW.getText().toString().trim();

        if (name.isEmpty()){
            this.name.setError("You must enter a name");
            this.name.requestFocus();
            return;
        }

        if (email.isEmpty()){
            this.email.setError("You must enter an email");
            this.email.requestFocus();
            return;
        }

        if (password.isEmpty()){
            this.password.setError("You must enter a password");
            this.password.requestFocus();
            return;
        }

        if (confirmPW.isEmpty()){
            this.confirmPW.setError("You must confirm your password");
            this.confirmPW.requestFocus();
            return;
        }

        if (password.length() < 8){
            this.password.setError("Minimum password length is 8 characters");
            this.password.requestFocus();
            return;
        }

        if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            this.email.setError("Please provide a valid email");
            this.email.requestFocus();
        }

        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(task -> {
                    if(task.isSuccessful()){
                        User user = new User(name, email, password);
                        FirebaseDatabase.getInstance().getReference("Users")
                                .child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                                .setValue(user).addOnCompleteListener(task1 -> {
                                    if(task1.isSuccessful()){
                                        Toast.makeText(BecomeVIP.this,
                                                "User has been registered successfully",
                                                Toast.LENGTH_LONG).show();
                                    } else {
                                        Toast.makeText(BecomeVIP.this,
                                                "Failed to Register", Toast.LENGTH_SHORT).show();
                                    }
                                });
                    } else {
                        Toast.makeText(BecomeVIP.this, "Failed to Register the User",
                                Toast.LENGTH_SHORT).show();
                    }
                });

    }
}