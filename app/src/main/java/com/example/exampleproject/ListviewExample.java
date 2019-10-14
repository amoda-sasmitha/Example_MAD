package com.example.exampleproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class ListviewExample extends AppCompatActivity {

    private ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listview_example);

        //Arraylist You want to add
        //should be a string type array or string type arraylist
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("Item 01");
        arrayList.add("Item 02");
        arrayList.add("Item 03");
        arrayList.add("Item 04");
        arrayList.add("Item 05");

        ListView listView = findViewById(R.id.listview);

        //create the adapter
        ArrayAdapter adapter = new ArrayAdapter( this , R.layout.support_simple_spinner_dropdown_item , arrayList);

        //set adapter to the listview
        listView.setAdapter(adapter);
    }
}
