package com.shabsudemy.fragmenttutorial.fragmentpoc;

import com.shabsudemy.fragmenttutorial.R;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class FragmentPocSample1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_poc_sample1);

        MyFragment myFragment = new MyFragment();
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.add(R.id.constrainLayout, myFragment, "key1");
        transaction.commit();

    }

}