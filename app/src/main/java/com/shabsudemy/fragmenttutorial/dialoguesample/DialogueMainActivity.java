package com.shabsudemy.fragmenttutorial.dialoguesample;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import com.shabsudemy.fragmenttutorial.R;

public class DialogueMainActivity extends AppCompatActivity implements MyDialog.Communicator, View.OnClickListener {

    Button onclickmeButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialogue_main);
        onclickmeButton = (Button) findViewById(R.id.clickmeDialogue);
        onclickmeButton.setOnClickListener(this);
    }

    public void showDialogue() {
        FragmentManager manager = getSupportFragmentManager();
        MyDialog myDialog = new MyDialog();
        myDialog.show(manager, "myDialogue");
    }

    @Override
    public void onDialogMessage(String message) {
        Toast.makeText(this, "Ondialoge Triggerd", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onClick(View v) {
        Intent i = null;
        switch (v.getId()) {
            case R.id.clickmeDialogue:
                showDialogue();
                break;
        }
    }
}