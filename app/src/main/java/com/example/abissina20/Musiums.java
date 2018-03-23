package com.example.abissina20;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by BelA on 6/24/2017.
 */

public class Musiums extends Fragment {

    //so let me exaplain what is,
    //Denotes that a parameter, field or method return value can be null.
    //In method call the value that is marked as @Nullable mean that argument of the method can be null
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState){
        return inflater.inflate(R.layout.musiums,container,false);
    }
}
