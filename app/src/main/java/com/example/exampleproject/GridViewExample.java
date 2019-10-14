package com.example.exampleproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Adapter;
import android.widget.GridView;
import android.widget.Toast;

public class GridViewExample extends AppCompatActivity {

    GridView gridView;
    DBHelper db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_view_example);

        db = new DBHelper(this);

        gridView = findViewById(R.id.gridView);
        ExampleAdapter adapter = new ExampleAdapter( GridViewExample.this ,  db.getAllImages() );
        Toast.makeText( GridViewExample.this , "Count "+adapter.getCount()  , Toast.LENGTH_LONG).show();
        gridView.setAdapter(adapter);

    }
}
