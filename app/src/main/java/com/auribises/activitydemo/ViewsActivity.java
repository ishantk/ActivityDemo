package com.auribises.activitydemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

public class ViewsActivity extends AppCompatActivity implements View.OnClickListener,AdapterView.OnItemSelectedListener{

    CheckBox cbC, cbCpp, cbJava;
    RadioButton rbMale, rbFemale;

    Spinner spCity;
    ArrayAdapter<String> adapter;

    Button btnSubmit;


    void initViews(){
        cbC = (CheckBox)findViewById(R.id.checkBoxC);
        cbCpp = (CheckBox)findViewById(R.id.checkBoxCpp);
        cbJava = (CheckBox)findViewById(R.id.checkBoxJava);

        rbMale = (RadioButton)findViewById(R.id.radioButtonMale);
        rbFemale = (RadioButton)findViewById(R.id.radioButtonFemale);


        btnSubmit = (Button)findViewById(R.id.buttonSubmit);



        cbC.setOnClickListener(this);
        cbCpp.setOnClickListener(this);
        cbJava.setOnClickListener(this);

        rbMale.setOnClickListener(this);
        rbFemale.setOnClickListener(this);

        btnSubmit.setOnClickListener(this);
    }

    void initSpinner(){
        spCity = (Spinner)findViewById(R.id.spinnerCity);

        adapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item);
        adapter.add("--Select City--"); //0
        adapter.add("Ludhiana");
        adapter.add("Chandigarh");
        adapter.add("Delhi");
        adapter.add("Bengaluru");
        adapter.add("California");      //n-1

        spCity.setAdapter(adapter);
        spCity.setOnItemSelectedListener(this);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_views);
        initViews();
        initSpinner();
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();

        switch (id){
            case R.id.checkBoxC:
                if(cbC.isChecked())
                    Toast.makeText(this,"You Checked C: ",Toast.LENGTH_LONG).show();
                else
                    Toast.makeText(this,"You UnChecked C: ",Toast.LENGTH_LONG).show();

                break;

            case R.id.checkBoxCpp:

                if(cbCpp.isChecked())
                    Toast.makeText(this,"You Checked Cpp: ",Toast.LENGTH_LONG).show();
                else
                    Toast.makeText(this,"You UnChecked Cpp: ",Toast.LENGTH_LONG).show();


                break;

            case R.id.checkBoxJava:

                if(cbJava.isChecked())
                    Toast.makeText(this,"You Checked Java: ",Toast.LENGTH_LONG).show();
                else
                    Toast.makeText(this,"You UnChecked Java: ",Toast.LENGTH_LONG).show();


                break;

            case R.id.radioButtonMale:

                if(rbMale.isChecked())
                    Toast.makeText(this,"You Selected Male: ",Toast.LENGTH_LONG).show();
                else
                    Toast.makeText(this,"You UnSelected Male: ",Toast.LENGTH_LONG).show();


                break;

            case R.id.radioButtonFemale:

                if(rbFemale.isChecked())
                    Toast.makeText(this,"You Selected Female: ",Toast.LENGTH_LONG).show();
                else
                    Toast.makeText(this,"You UnSelected Female: ",Toast.LENGTH_LONG).show();



                break;

            case R.id.buttonSubmit:

                Toast.makeText(this,"You Clicked Submit: ",Toast.LENGTH_LONG).show();

                break;
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        String city = adapter.getItem(i);
        Toast.makeText(this,"You Selected: "+city,Toast.LENGTH_LONG).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
