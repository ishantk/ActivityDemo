package com.auribises.activitydemo;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MySensorActivity extends AppCompatActivity implements View.OnClickListener,SensorEventListener{

    Button btnActivate;
    TextView txtSensor;

    SensorManager sensorManager;
    Sensor sensor;

    void initViews() {
        txtSensor = (TextView) findViewById(R.id.textViewSensor);
        btnActivate = (Button) findViewById(R.id.buttonActivate);
        btnActivate.setOnClickListener(this);


        sensorManager = (SensorManager)getSystemService(SENSOR_SERVICE);
        sensor = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);


    }

        @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_sensor);

        initViews();
    }

    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.buttonActivate){

            sensorManager.registerListener(this,sensor,SensorManager.SENSOR_DELAY_NORMAL);

        }
    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {

        float[] values = sensorEvent.values;

        float x = values[0];
        float y = values[1];
        float z = values[2];

        txtSensor.setText("X: "+x+" Y: "+y+" Z: "+z);


        float cal = (x*x)+(y*y)+(z*z) / (SensorManager.GRAVITY_EARTH*SensorManager.GRAVITY_EARTH);

        if(cal>2){
            txtSensor.setText("Shake Detected...");

            sensorManager.unregisterListener(this);
        }

    }

    void sendMessage(){
        SmsManager smsManager = SmsManager.getDefault();
        String phone = "9915571177";
        String message = "Need Help!! My Location is: ";

        smsManager.sendTextMessage(phone,null ,message,null,null);
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }
}
