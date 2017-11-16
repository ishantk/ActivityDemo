package com.auribises.activitydemo;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class UpperFragment extends Fragment implements View.OnClickListener{


    EditText eTxtName;
    Button btnSubmit;

    public UpperFragment() {
        // Required empty public constructor
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        eTxtName = view.findViewById(R.id.editText3);
        btnSubmit = view.findViewById(R.id.button12);
        btnSubmit.setOnClickListener(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_upper, container, false);
        return view;

    }

    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.button12){
            Toast.makeText(getActivity(),"You Clicked Button",Toast.LENGTH_LONG).show();
        }
    }
}
