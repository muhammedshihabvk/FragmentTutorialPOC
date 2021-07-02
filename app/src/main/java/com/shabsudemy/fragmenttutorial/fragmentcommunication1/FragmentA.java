package com.shabsudemy.fragmenttutorial.fragmentcommunication1;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.shabsudemy.fragmenttutorial.R;

public class FragmentA extends Fragment implements View.OnClickListener {

    Button clickMeButton;
    int count=0;
    Communicator communicator;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_a,container,false);

    }

    @Override
    public void onCreate(@Nullable  Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(savedInstanceState!=null){
            count=savedInstanceState.getInt("counter");
        }else{
            count=0;
        }
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        communicator =(Communicator) getActivity();
        clickMeButton = (Button) getActivity().findViewById(R.id.clickMeButton);
        clickMeButton.setOnClickListener(this);
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        outState.putInt("counter",count);
        super.onSaveInstanceState(outState);
    }


    @Override
    public void onClick(View v) {
        count++;
        communicator.respond("Current value is" +String.valueOf(count));

    }
}
