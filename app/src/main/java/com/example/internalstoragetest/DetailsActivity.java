package com.example.internalstoragetest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class DetailsActivity extends AppCompatActivity {

    private TextView txtUserName;
    private TextView txtPassword;
    private Intent loginIntent;
    FileInputStream finStream;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        txtUserName = (TextView) findViewById(R.id.txtUserName);
        txtPassword = (TextView) findViewById(R.id.txtUserPassword);

        try{
            finStream = openFileInput("user_details");
            StringBuffer sbuffer = new StringBuffer();
            int i;
            while ((i = finStream.read())!= -1){
                sbuffer.append((char)i);
            }
            finStream.close();
            String details[] = sbuffer.toString().split("\n");
            txtUserName.setText(details[0]);
            txtPassword.setText(details[1]);
            //result.setText("Name: "+ details[0]+"\nPassword: "+details[1]);
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    private void setDetailsInfo(){}
    public void goBackToLoginScreen(View view){
        loginIntent = new Intent(DetailsActivity.this,MainActivity.class);
        startActivity(loginIntent);
    }
}
