package com.example.bestproject;

import android.net.Uri;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class FragmentContainerActivity extends FragmentActivity implements Fragment1.OnFragmentInteractionListener, Fragment2.OnFragmentInteractionListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_container);
    }

    @Override
    public void onFragmentInteraction(Uri uri){
        //you can leave it empty
    }

}
