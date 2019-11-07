package com.example.internalstoragetest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class DetailsActivity extends AppCompatActivity {

    private TextView txtUserName;
    private TextView txtPassword;
    private Intent loginIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
    }

    public void goBackToLoginScreen(View view){
        loginIntent = new Intent(DetailsActivity.this,MainActivity.class);
        startActivity(loginIntent);
    }
}
