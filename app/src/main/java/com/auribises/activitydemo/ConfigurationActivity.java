package com.auribises.activitydemo;

import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class ConfigurationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_configuration);
        Toast.makeText(this,"ConfigurationActivity - onCreate",Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(this,"ConfigurationActivity - onDestroy",Toast.LENGTH_LONG).show();
    }

    /*@Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);

        if(newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            Toast.makeText(this, "ConfigurationActivity - onConfigurationChanged - LANDSCAPE", Toast.LENGTH_LONG).show();
        }

        if(newConfig.orientation == Configuration.ORIENTATION_PORTRAIT) {
            Toast.makeText(this, "ConfigurationActivity - onConfigurationChanged - POTRAIT", Toast.LENGTH_LONG).show();
        }
    }*/
}
