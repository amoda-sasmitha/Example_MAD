package com.example.exampleproject;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.util.ArrayList;


public class DBHelper extends SQLiteOpenHelper {
    public DBHelper( Context context) {
        super(context, "test.db" , null  , 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
            String SQL = "CREATE TABLE images ( ImageName TEXT , Image BLOB  );";
            sqLiteDatabase.execSQL(SQL);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public boolean addEntry( String name, byte[] image) throws SQLiteException {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues cv = new  ContentValues();
        cv.put( "ImageName" ,name);
        cv.put("Image",image);
        long result = db.insert( "images", null, cv );
        if( result > 0 ){
            return true;
        }else{
            return  false;
        }

    }

    public ArrayList<Bitmap> getAllImages(){
        SQLiteDatabase db = getWritableDatabase();
        String Projection[] = { "Image"   };

        Cursor cursor = db.query( "images" , Projection , null , null ,null , null , null );
        ArrayList<Bitmap> imagesX = new ArrayList<>();
        while(cursor.moveToNext() ){

            byte[] array = cursor.getBlob(0);
            Bitmap current = BitmapFactory.decodeByteArray( array , 0 , array.length);
            imagesX.add(current);

        }
        return  imagesX;
    }
}
