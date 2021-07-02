package com.shabsudemy.fragmenttutorial.dialoguesample;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.shabsudemy.fragmenttutorial.R;

public class MyDialog extends DialogFragment implements View.OnClickListener {

    Button yes, no;
    Communicator communicator;

    @Override
    public void onAttach(@NonNull  Context context) {
        super.onAttach(context);
        communicator = (Communicator) context;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.my_dialogue, container, false);
        yes = view.findViewById(R.id.buttonYes);
        no = view.findViewById(R.id.buttonNo);
        yes.setOnClickListener(this);
        no.setOnClickListener(this);
        setCancelable(false);
        return view;
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.buttonYes) {
//            Toast.makeText(getActivity(), "yes", Toast.LENGTH_SHORT).show();
            communicator.onDialogMessage("yes");
            dismiss();
        } else {
//            Toast.makeText(getActivity(), "No", Toast.LENGTH_SHORT).show();
//            getActivity().finish();
            communicator.onDialogMessage("yes");
            dismiss();
        }

    }

    interface Communicator {
        public void onDialogMessage(String message);
    }

}
