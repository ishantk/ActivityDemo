package com.auribises.activitydemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class ShowUserActivity extends AppCompatActivity {

    User user;

    @InjectView(R.id.textViewUser)
    TextView txtUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_user);

        ButterKnife.inject(this);

        Intent rcv = getIntent();

        user = (User)rcv.getSerializableExtra("keyUser");

        txtUser.setText("Name: "+user.name+"\n\nPhone: "+user.phone+"\n\nPassword: "+user.password);

    }
}
