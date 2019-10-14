package com.example.exampleproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button spinner , dialogbox , listview , gridview , toast , image;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinner = findViewById(R.id.normalSpinner);
        listview = findViewById(R.id.listView);
        gridview = findViewById(R.id.gridView);
        toast = findViewById(R.id.toast);
        image = findViewById(R.id.imageUpload);
        dialogbox = findViewById(R.id.dialogBox);

        spinner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this , SpinnerExample.class );
                startActivity(intent);
            }
        });


        listview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this , ListviewExample.class );
                startActivity(intent);
            }
        });

        image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this , ImageExample.class );
                startActivity(intent);
            }
        });

        gridview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this , GridViewExample.class );
                startActivity(intent);
            }
        });
    }
}
