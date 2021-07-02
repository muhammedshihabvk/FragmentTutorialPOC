package com.shabsudemy.fragmenttutorial;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.view.ActionMode;
import androidx.appcompat.widget.SwitchCompat;
import androidx.appcompat.widget.Toolbar;

import com.shabsudemy.fragmenttutorial.dialoguesample.DialogueMainActivity;
import com.shabsudemy.fragmenttutorial.fragmentcommunication1.FragmentCommunicationActivity;
import com.shabsudemy.fragmenttutorial.fragmentpoc.FragmentPocSample1;
import com.shabsudemy.fragmenttutorial.modularuidesign.ModularUiMainActivity;

public class MainActivity extends AppCompatActivity {

    Toolbar toolbar;
    Switch aSwitch;
    ActionMode actionMode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        aSwitch = (Switch) findViewById(R.id.switch1);

        setSupportActionBar(toolbar);
                getSupportActionBar().setTitle("shabs POC bundle");
//        toolbar.setTitle("shabs POC bundle");
        toolbar.setSubtitle("welcome");
        toolbar.setNavigationIcon(R.drawable.ic_launcher_foreground);
        System.out.println(getSupportActionBar().getSubtitle());
        System.out.println(getSupportActionBar().getTitle());

        aSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    Toast.makeText(MainActivity.this, "true", Toast.LENGTH_SHORT).show();
                    actionMode = MainActivity.this.startSupportActionMode(new ActionBarCallback());
                }else{
                    actionMode.finish();
                    Toast.makeText(MainActivity.this, "false", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    class ActionBarCallback implements ActionMode.Callback{

        @Override
        public boolean onCreateActionMode(ActionMode mode, Menu menu) {
            mode.getMenuInflater().inflate(R.menu.contextual_menu_main,menu);
            return true;
        }

        @Override
        public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
            mode.setTitle("On copy Action");
            return false;
        }

        @Override
        public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
            Toast.makeText(MainActivity.this, "clicked on copy button", Toast.LENGTH_SHORT).show();
            return false;
        }

        @Override
        public void onDestroyActionMode(ActionMode mode) {
            aSwitch.setChecked(false);
            Toast.makeText(MainActivity.this, "context menue is destroyed", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {
            case R.id.menu_search:
                Toast.makeText(this, "Search clicked", Toast.LENGTH_SHORT).show();
                break;
            case R.id.menu_settings:
                Toast.makeText(this, "settings clicked", Toast.LENGTH_SHORT).show();
                break;
            default:
                Log.d("TAG", "Default option triggerd");
                break;
        }
        return true;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    public void onButtonClick(View view) {
        Intent i = null;
        switch (view.getId()) {
            case R.id.fragmentActivityButton:
                i = new Intent(this, FragmentPocSample1.class);
                startActivity(i);
                break;

            case R.id.fragmentCommunicationActivityButton:
                i = new Intent(this, FragmentCommunicationActivity.class);
                startActivity(i);
                break;
            case R.id.modularUiFragmentActivity:
                i = new Intent(this, ModularUiMainActivity.class);
                startActivity(i);
                break;

            case R.id.dialogueFragmentActivity:
                i = new Intent(this, DialogueMainActivity.class);
                startActivity(i);
                break;
            default:
                break;
        }
    }
}