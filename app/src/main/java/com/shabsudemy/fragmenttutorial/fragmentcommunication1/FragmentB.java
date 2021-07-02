package com.shabsudemy.fragmenttutorial.fragmentcommunication1;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.shabsudemy.fragmenttutorial.R;

public class FragmentB extends Fragment {

    TextView textView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_b, container, false);
    }


    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("text", String.valueOf(textView.getText()));
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        textView = getActivity().findViewById(R.id.textViewFragb);
        if (savedInstanceState != null) {
            textView.setText(savedInstanceState.getString("text"));
        }
    }

    public void changeText(String data) {
        textView.setText(data);
    }
}
