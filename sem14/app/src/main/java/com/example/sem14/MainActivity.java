package com.example.sem14;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    private EditText user;
    private Button b1;
    private FirebaseDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        user = findViewById(R.id.USER);
        b1 = findViewById(R.id.B1);

        b1.setOnClickListener((view) -> {

            Intent shot = new Intent(this, LaLista.class);
            shot.putExtra("user", user.getText().toString());
            startActivity(shot);
        });
    }
}