package com.shabsudemy.fragmenttutorial.modularuidesign;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;

import com.shabsudemy.fragmenttutorial.R;
import com.shabsudemy.fragmenttutorial.fragmentcommunication1.FragmentB;

import java.util.ArrayList;

public class ModularUiMainActivity extends AppCompatActivity implements  ModularUiCommunicator{

    ArrayList<String> arrayList = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modular_ui_main);
    }


    @Override
    public void respond(String id) {
        FragmentManager manager = getSupportFragmentManager();
        ModularFragmentB f2= (ModularFragmentB) manager.findFragmentById(R.id.modularUiFragmentB);
        f2.changeData(id);
    }
}