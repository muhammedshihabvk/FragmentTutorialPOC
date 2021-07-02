package com.shabsudemy.fragmenttutorial.modularuidesign;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.shabsudemy.fragmenttutorial.R;

import java.util.ArrayList;
import java.util.Random;

public class ModularFragmentA extends Fragment implements AdapterView.OnItemClickListener {

    ListView listView;
    ArrayList<String> heading = new ArrayList<String>();
    ArrayList<String> description = new ArrayList<String>();
    ArrayList<String> stringArray = new ArrayList<String>();
    Random random;

    ModularUiCommunicator modularUiCommunicator;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_modular_a, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        stringArray.add("Lorem Ipsum is simply dummy text of the printing and typesetting industry. ");
        stringArray.add("Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer");
        stringArray.add(" took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries,");
        stringArray.add(" but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the ");
        stringArray.add("1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing ");
        stringArray.add("software like Aldus PageMaker including versions of Lorem Ipsum.");

        random = new Random();
        for (int i = 0; i < 10; i++) {
            heading.add("Heading" + String.valueOf(i));
            int num = random.nextInt(5);
            description.add(stringArray.get(num));
        }

        listView = (ListView) getActivity().findViewById(R.id.modularUiListview);
        ArrayAdapter arrayAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, heading);
        listView.setAdapter(arrayAdapter);
        listView.setOnItemClickListener(this);
        modularUiCommunicator = (ModularUiCommunicator) getActivity();

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        modularUiCommunicator.respond(description.get(position));
    }
}