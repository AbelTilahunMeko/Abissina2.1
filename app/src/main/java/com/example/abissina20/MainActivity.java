package com.example.abissina20;


import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.content.Intent;
import android.content.res.TypedArray;
import android.inputmethodservice.Keyboard;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabItem;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TabHost;
import android.widget.Toast;

import com.google.android.gms.maps.MapFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    TabLayout tb;
    ViewPager viewPager;
    viewPagerAdapter viewPagerAdapter;
    RecyclerView recyclerView;
    ListView myListView;

    String[] leaders_name;
    TypedArray profilePic;
    List<RowItem> rowItems;

    public void listViewCreater() {

        rowItems = new ArrayList<RowItem>();
        leaders_name = getResources().getStringArray(R.array.Leaders_name);
        profilePic = getResources().obtainTypedArray(R.array.profilePic);

        for (int i = 0; i < leaders_name.length; i++) {
            RowItem item = new RowItem(leaders_name[i], profilePic.getResourceId(i, -1));
            rowItems.add(item);

            //myListView = (ListView) myListView.findViewById(R.id.listItems);

            CustomAdapter adapter = new CustomAdapter(MainActivity.this, rowItems);
            myListView.setAdapter(adapter);

        }
    }

    /*
    public void reciclerView(){
        recyclerView= (RecyclerView)findViewById(R.id.recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new Adapter(this,itmes));

    }*/
    private void addMapFragment() {
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        Maps fragment = new Maps();
        transaction.add(R.id.mapView, fragment);
        transaction.commit();
    }
    public void viewCreater(final int postion){

        viewPager = (ViewPager)findViewById(R.id.viewPager);
        tb =(TabLayout)findViewById(R.id.tabs);
        viewPagerAdapter = new viewPagerAdapter(getSupportFragmentManager());
        viewPagerAdapter.addFramgents(new HomeAbissinia(),"Home");
        viewPagerAdapter.addFramgents(new UNSECO(),"UNESCO");
        viewPagerAdapter.addFramgents(new Emperors(),"Emporers");
        viewPagerAdapter.addFramgents(new Sites(),"Sites");
        //viewPagerAdapter.addFramgents(new Maps(),"Maps");



        viewPager.postDelayed(new Runnable()
        {
            @Override
            public void run()
            {
                viewPager.setCurrentItem(postion, true);
            }
        }, 0);

     /*
        switch (postion){
            case 0:
                viewPager.setCurrentItem(0,true);
                //Toast.makeText(this, "The Page "+ postion, Toast.LENGTH_SHORT).show();
                break;
            case 1:
                viewPager.setCurrentItem(1, true);
                 break;
            case 2:
                viewPager.setCurrentItem(2, true);
                break;
            case 3:
                viewPager.setCurrentItem(3, true);
        }
        //viewPagerAdapter.addFramgents(new Musiums(),"Museums");


        ViewGroup.LayoutParams params = viewPager.getLayoutParams();
        params.height = 1000;
        viewPager.setLayoutParams(params);*/
        viewPager.setAdapter(viewPagerAdapter);
        tb.setupWithViewPager(viewPager);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent = getIntent();
        String x =intent.getStringExtra(IconClass.MSG_KEy);
        int position = Integer.valueOf(x);
        //Toast.makeText(this, "The Page "+ x, Toast.LENGTH_SHORT).show();
        viewCreater(position);
        //addMapFragment();
        //listViewCreater();
        //reciclerView();

        //Using this method we will Create the fragments and tabhost.

        /*
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}

