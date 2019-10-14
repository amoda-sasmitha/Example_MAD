package com.example.exampleproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class SpinnerExample extends AppCompatActivity {

    Spinner normal , dynamic;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner_example);

        //initialize two spinners
        normal = findViewById(R.id.spinner);
        dynamic = findViewById(R.id.spinner2);

        //get items from sting list and fill the spinner
        ArrayAdapter NormalAdapter =
                new ArrayAdapter( this , R.layout.support_simple_spinner_dropdown_item , getResources().getStringArray(R.array.items ));
        normal.setAdapter(NormalAdapter);

        //get item from arraylist and fill the spinner
        final ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("1st item");
        arrayList.add("2nd item");
        arrayList.add("3rd item");
        arrayList.add("4th item");
        ArrayAdapter DynamicAdapter = new ArrayAdapter( this , R.layout.support_simple_spinner_dropdown_item , arrayList );
        dynamic.setAdapter(DynamicAdapter);


        normal.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText( SpinnerExample.this, normal.getSelectedItem().toString() , Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });




    }
}
