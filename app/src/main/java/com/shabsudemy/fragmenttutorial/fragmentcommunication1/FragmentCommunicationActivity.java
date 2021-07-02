package com.shabsudemy.fragmenttutorial.fragmentcommunication1;

import com.shabsudemy.fragmenttutorial.R;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

public class FragmentCommunicationActivity extends AppCompatActivity  implements  Communicator{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_communication);
    }

    @Override
    public void respond(String data) {
        FragmentManager manager = getSupportFragmentManager();
        FragmentB f2= (FragmentB) manager.findFragmentById(R.id.fragmentb);
        f2.changeText(data);
    }
}