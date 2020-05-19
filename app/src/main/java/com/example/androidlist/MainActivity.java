package com.example.androidlist;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    ListView listview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Hooks
        listview = findViewById(R.id.listview);
        listview.setOnItemClickListener(this);

        //Name of countries to display in a list
        String[] EAC = {"Kenya", "Uganda", "Tanzania", "Somalia", "Ethiopia",
                "North Sudan", "South Sudan", "Rwanda", "Burundi", "Congo"};

        //Declaring adapter for list
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, EAC){
            @NonNull
            @Override
            public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
                View view = super.getView(position, convertView, parent);
                return view;
            }
        };
        listview.setAdapter(adapter);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        String names = parent.getItemAtPosition(position).toString();
        Toast.makeText(getApplicationContext(), "You clicked " + names, Toast.LENGTH_SHORT).show();
    }
}
