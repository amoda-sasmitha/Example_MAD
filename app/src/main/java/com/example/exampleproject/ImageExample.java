package com.example.exampleproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class ImageExample extends AppCompatActivity {

    private ImageView image;
    DBHelper db;
    private Button fromCamera , fromStorage;
    static final int REQUEST_IMAGE_CAPTURE = 1888;
    static final int REQUEST_IMAGE = 188;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_example);

        image = findViewById(R.id.image);
        fromCamera = findViewById(R.id.fromcamera);
        fromStorage = findViewById(R.id.fromstorage );
        db = new DBHelper(this);

        fromCamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
                    startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
                }
            }
        });

        fromStorage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent( Intent.ACTION_PICK , MediaStore.Images.Media.INTERNAL_CONTENT_URI );
                startActivityForResult(intent, REQUEST_IMAGE );
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {


        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            Bitmap imageBitmap = (Bitmap) extras.get("data");
            image.setImageBitmap(imageBitmap);

            ByteArrayOutputStream stream = new ByteArrayOutputStream();
            imageBitmap.compress( Bitmap.CompressFormat.PNG , 0 ,stream );
            boolean r = db.addEntry("Image" , stream.toByteArray() );

            if( r ){
                Toast.makeText( ImageExample.this , "Success" , Toast.LENGTH_LONG).show();
            }else{
                Toast.makeText( ImageExample.this , "unsuccess" , Toast.LENGTH_LONG).show();

            }

        }

        if (requestCode == REQUEST_IMAGE && resultCode == RESULT_OK) {
            Uri uri = data.getData();
            Bitmap bitmap = null;

            try {
                 bitmap = MediaStore.Images.Media.getBitmap( this.getContentResolver() , uri );
            } catch (IOException e) {
                e.printStackTrace();
            }
            image.setImageBitmap(bitmap);

            ByteArrayOutputStream stream = new ByteArrayOutputStream();
            bitmap.compress( Bitmap.CompressFormat.PNG , 0 ,stream );
            boolean r = db.addEntry("Image" , stream.toByteArray() );

            if( r ){
                Toast.makeText( ImageExample.this , "Success" , Toast.LENGTH_LONG).show();
            }else{
                Toast.makeText( ImageExample.this , "unsuccess" , Toast.LENGTH_LONG).show();

            }

        }
    }
}
