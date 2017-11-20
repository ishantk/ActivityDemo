package com.auribises.activitydemo;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.AsyncTask;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class MyLocationActivity extends AppCompatActivity implements LocationListener, View.OnClickListener {

    LocationManager locationManager;

    TextView txtLoc;
    Button btnFetch;

    double latitude,longitude;
    StringBuffer adrsBuffer;


    void initViews() {
        txtLoc = (TextView) findViewById(R.id.textViewLocation);
        btnFetch = (Button) findViewById(R.id.buttonFetch);
        btnFetch.setOnClickListener(this);

        locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);

        /*btnFetch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });*/
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_location);

        initViews();

    }

    @Override
    public void onLocationChanged(Location location) {

        latitude = location.getLatitude();
        longitude = location.getLongitude();

        float speed = location.getSpeed(); // mtrs / secs

        txtLoc.setText(latitude+" - "+longitude);


        locationManager.removeUpdates(this);

        new MyTask().execute();
    }


    class MyTask extends AsyncTask{

        // UI THREAD
        @Override
        protected void onPreExecute() {
            // show progress bar
        }

        // NON UI THREAD - NO UI ELEMENT CAN BE ACCESSED HERE | No UI of Activity should be accessed in here
        @Override
        protected Object doInBackground(Object[] objects) {
            // code which runs in background parallely rto the Activity Thread
            // Reverse Geocoding

            try {
                Geocoder geocoder = new Geocoder(MyLocationActivity.this);
                List<Address> adrsList = geocoder.getFromLocation(latitude, longitude, 5);

                if(adrsList!=null && adrsList.size()>0){

                    adrsBuffer = new StringBuffer();

                    Address address = adrsList.get(0);
                    for(int i=0;i<address.getMaxAddressLineIndex();i++){
                        adrsBuffer.append(address.getAddressLine(i)+"\n");
                    }

                }

            }catch (Exception e){
                e.printStackTrace();
            }

            return null;
        }

        // UI THREAD
        @Override
        protected void onPostExecute(Object o) {
            // hide progress bar

            txtLoc.setText("Latitude: "+latitude+" | Longitude: "+longitude+"\nAddress: "+adrsBuffer.toString());
        }
    }

    @Override
    public void onStatusChanged(String s, int i, Bundle bundle) {

    }

    @Override
    public void onProviderEnabled(String s) {

    }

    @Override
    public void onProviderDisabled(String s) {

    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.buttonFetch) {

            if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                Toast.makeText(this,"Please grant permissions in settings to access Location",Toast.LENGTH_LONG).show();
            }else {
                locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 10, 5, this);
            }

        }
    }
}
