package com.example.internalstoragetest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView txtUsername;
    private TextView txtPassword;
    private Button btnSave;
    private Intent detailsIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void saveUserInfoAndGoToDetailsScreen(View view){
        detailsIntent = new Intent(MainActivity.this,DetailsActivity.class);
        startActivity(detailsIntent);
    }
}
