package com.example.internalstoragetest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    private TextView txtUsername;
    private TextView txtPassword;
    private Button btnSave;
    private Intent detailsIntent;
    private FileOutputStream foutStream;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtUsername = (TextView) findViewById(R.id.txtUsername);
        txtPassword = (TextView) findViewById(R.id.txtPassword);
    }

    public void saveUserInfoAndGoToDetailsScreen(View view){
        String username = txtUsername.getText().toString() + "\n";
        String password = txtPassword.getText().toString();

        try{
            foutStream = openFileOutput("user_details", Context.MODE_PRIVATE);
            foutStream.write(username.getBytes());
            foutStream.write(password.getBytes());
            Toast.makeText(this,"Details info saved successfully",Toast.LENGTH_LONG).show();
            detailsIntent = new Intent(MainActivity.this,DetailsActivity.class);
            startActivity(detailsIntent);
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }


    }
}
