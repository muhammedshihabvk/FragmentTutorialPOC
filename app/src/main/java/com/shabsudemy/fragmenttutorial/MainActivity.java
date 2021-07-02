package com.shabsudemy.fragmenttutorial;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.shabsudemy.fragmenttutorial.dialoguesample.DialogueMainActivity;
import com.shabsudemy.fragmenttutorial.fragmentcommunication1.FragmentCommunicationActivity;
import com.shabsudemy.fragmenttutorial.fragmentpoc.FragmentPocSample1;
import com.shabsudemy.fragmenttutorial.modularuidesign.ModularUiMainActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onButtonClick(View view) {
        Intent i = null;
        switch (view.getId()) {
            case R.id.fragmentActivityButton:
                i = new Intent(this, FragmentPocSample1.class);
                startActivity(i);
                break;

            case R.id.fragmentCommunicationActivityButton:
                i=new Intent(this, FragmentCommunicationActivity.class);
                startActivity(i);
                break;
            case R.id.modularUiFragmentActivity:
                i=new Intent(this, ModularUiMainActivity.class);
                startActivity(i);
                break;

            case R.id.dialogueFragmentActivity:
                i=new Intent(this, DialogueMainActivity.class);
                startActivity(i);
                break;
            default:
                break;
        }
    }
}