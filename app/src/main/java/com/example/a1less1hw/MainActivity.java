package com.example.a1less1hw;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private ImageView imageView;
    private EditText etUserName;
    private EditText etPassword;
    private TextView tvAttempts;
    private Button btnLogin;
    boolean isValid = false;
    private int counter = 5;
    private TextView visibilityOfPass;

    private final String USERNAME = "Makhabat";
    private final String PASSWORD = "Admin123";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = findViewById(R.id.imageView);
        etUserName = findViewById(R.id.etUserName);
        etPassword = findViewById(R.id.etPassword);
        tvAttempts = findViewById(R.id.tvAttempts);
        btnLogin = findViewById(R.id.btnLogin);
        visibilityOfPass = findViewById(R.id.visibilityOfPass);

        visibilityOfPass.setOnClickListener(view -> {
            if (visibilityOfPass.getText().equals("SHOW")) {
                visibilityOfPass.setText("HIDE");
                etPassword.setInputType(InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
            } else {
                visibilityOfPass.setText("SHOW");
                etPassword.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
            }
            etPassword.setSelection(etPassword.length());

        });

        btnLogin.setOnClickListener(view -> {

            String inputUserName = etUserName.getText().toString();
            String inputPassword = etPassword.getText().toString();
            if (inputPassword.length() > 0) {
                visibilityOfPass.setVisibility(View.VISIBLE);
                if (inputUserName.equals(USERNAME) && inputPassword.length() < 8) {
                    Toast.makeText(MainActivity.this, "Password must have at least 8 characters", Toast.LENGTH_SHORT).show();
                } else if (inputUserName.isEmpty() || inputPassword.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Please enter all the details", Toast.LENGTH_SHORT).show();

                } else {
                    isValid = validate(inputUserName, inputPassword);
                    if (!isValid) {
                        counter--;
                        Toast.makeText(MainActivity.this, "Incorrect credentials entered", Toast.LENGTH_SHORT).show();
                        tvAttempts.setText("The remaining number of attempts: " + counter);

                        if (counter == 0) {
                            btnLogin.setEnabled(false);
                        }
                    } else {
                        Toast.makeText(MainActivity.this, "Login Successful", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(MainActivity.this, HomePageActivity.class);
                        startActivity(intent);
                    }
                }
            }
        });

    }

    private boolean validate(String name, String password) {
        return name.equals(USERNAME) && password.equals(PASSWORD);
    }
}