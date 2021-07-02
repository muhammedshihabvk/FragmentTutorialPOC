package com.shabsudemy.fragmenttutorial.fragmentpoc;

import com.shabsudemy.fragmenttutorial.R;

import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class MyFragment  extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.my_fragment_layout,container,false);
    }
}
