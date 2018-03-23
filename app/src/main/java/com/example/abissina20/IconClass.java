package com.example.abissina20;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Icon;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import java.util.zip.Inflater;


public class IconClass extends AppCompatActivity implements AdapterView.OnItemClickListener{
    AlertDialog action;
    public void alerDa(){
        String[] listOpt = {getString(R.string.team)};
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setTitle("Developers");
        builder.setItems(listOpt,null);
        builder.setNegativeButton("ok",null);
        action = builder.create();
        action.show();
        action.getWindow().setLayout(400, 200);

    }

    public static final String MSG_KEy = "Welcom";
    GridView gridView;
    String[] values={
            "Home",
            "UNSECO",
            "Emperors",
            "Sites",
            "Maps",
            "Developer "


    };
    int[] images ={
            R.drawable.home,
            R.drawable.unescos,
            R.drawable.empreror,
            R.drawable.park,
            R.drawable.maps,
            R.drawable.group,


    };
    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.iconlist);

        gridView = (GridView)findViewById(R.id.gridView);

        GridAdapter gridAdapter = new GridAdapter(this,values,images);

        gridView.setAdapter(gridAdapter);
        gridView.setOnItemClickListener(this);
    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        //Intent intent = new Intent(IconClass.this,Maps.class);
        //startActivity(intent);
        //String data=(String)parent.getItemAtPosition(position);
        /*
        Intent intent = new Intent(IconClass.this,MainActivity.class);
        startActivity(intent);
        Toast.makeText(IconClass.this,"You have choosen"+ values[position],Toast.LENGTH_SHORT).show();
        */
        if(position==5){
            //Toast.makeText(IconClass.this,"You have choosen"+ position,Toast.LENGTH_SHORT).show();
            alerDa();
        }else if(position==4){
            //Toast.makeText(IconClass.this,"You have choosen Maps"+ position,Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(IconClass.this,MapsActivity.class);
            startActivity(intent);
        }else{
            Intent intent = new Intent(IconClass.this,MainActivity.class);
            String x = String.valueOf(position);
            //Toast.makeText(IconClass.this,"You have choosen"+ values[position],Toast.LENGTH_SHORT).show();
            intent.putExtra(MSG_KEy,x);
            startActivity(intent);
        }


    }

}
