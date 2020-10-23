package com.example.a1less1hw;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class HomePageActivity extends AppCompatActivity {

    private TextView textView;
    private ImageView imageView;
    private EditText etText;
    private Button btnChange;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
        init();
    }

    private void init() {
        textView = findViewById(R.id.textView);
        imageView = findViewById(R.id.imageView);
        etText = findViewById(R.id.etText);
        btnChange = findViewById(R.id.btnChange);

        btnChange.setOnClickListener(view -> {
            String text = etText.getText().toString();
            textView.setText(text);
            imageView.setImageResource(R.drawable.whitecam);
        });

        imageView.setOnClickListener(view -> {
            textView.setText("");
            etText.setText("");

        });


    }
}