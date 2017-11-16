package com.auribises.activitydemo;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MyFragmentsActivity extends AppCompatActivity {

    FragmentManager fragmentManager;

    UpperFragment upperFragment;
    LowerFragment lowerFragment;

    void initViews(){
        upperFragment = new UpperFragment();
        lowerFragment = new LowerFragment();

        fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().add(R.id.upperFrame,upperFragment).commit();
        fragmentManager.beginTransaction().add(R.id.lowerFrame,lowerFragment).commit();

        //fragmentManager.beginTransaction().remove(upperFragment);
        //fragmentManager.beginTransaction().replace(R.id.upperFrame,newUpperFragment);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_fragments);
        initViews();
    }
}
