package com.example.travelbookjava.view;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.example.travelbookjava.R;

public class MainActivity2 extends AppCompatActivity {
    public SQLiteDatabase database;
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater=getMenuInflater();
        menuInflater.inflate(R.menu.add_placepicnot,menu);
        return super.onCreateOptionsMenu(menu);
    }/*
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == R.id.add_picture) {
            Intent intent=new Intent(this, MainsAddPicture.class);
            intent.putExtra("info","pic");
            startActivity(intent);

        }
        if(item.getItemId() == R.id.add_note) {
            Intent intent=new Intent(this, MainActivity4.class);
            intent.putExtra("info","not");
            startActivity(intent);

        }

        return super.onOptionsItemSelected(item);
    }*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        try {
            database.execSQL("CREATE TABLE IF NOT EXISTS placepicnot(id INTEGER PRIMARY KEY,tarih VARCHAR)");
            database.execSQL("INSERT INTO placepicnot (tarih) VALUES ('11-22-2021')");

            Cursor cursor=database.rawQuery("SELECT * FROM placepicnote",null);

            int tarihIx=cursor.getColumnIndex("tarih");
            while(cursor.moveToNext()){
                System.out.println("Tarih:"+cursor.getString(tarihIx));
            }
            cursor.close();

        }catch (Exception e){

        }
    }
}