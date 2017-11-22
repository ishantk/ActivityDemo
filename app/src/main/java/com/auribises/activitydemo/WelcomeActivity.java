package com.auribises.activitydemo;

import android.content.SharedPreferences;
import android.graphics.drawable.AnimationDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class WelcomeActivity extends AppCompatActivity implements View.OnClickListener{

    @InjectView(R.id.editTextName)
    EditText eTxtName;

    @InjectView(R.id.buttonSubmit)
    Button btnSubmit;

    @InjectView(R.id.imageView)
    ImageView imageView;

    SharedPreferences preferences;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        ButterKnife.inject(this);

        getSupportActionBar().setTitle("Welcome");

        btnSubmit.setOnClickListener(this);

        preferences = getSharedPreferences("activityDemo",MODE_PRIVATE);
        editor = preferences.edit();

        String name = preferences.getString("keyName","NA");
        int age = preferences.getInt("keyAge",0);

        eTxtName.setText(name+" - "+age);

        Animation animation1 = AnimationUtils.loadAnimation(this,R.anim.alpha_animation);
        Animation animation2 = AnimationUtils.loadAnimation(this,R.anim.rotate_animation);
        btnSubmit.startAnimation(animation2);
        eTxtName.startAnimation(animation1);

        AnimationDrawable animationDrawable = (AnimationDrawable)imageView.getBackground();
        animationDrawable.start();

    }

    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.buttonSubmit){

            String name = eTxtName.getText().toString().trim();

            editor.putString("keyName",name);
            editor.putInt("keyAge",30);
            editor.apply(); // to save the data in XML (SP)

        }
    }
}
