package com.coolbeansbro.contactsmanager;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationManager;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.io.IOException;

public class EmergencyCallActivity extends AppCompatActivity {

    private double latitude;
    private double longitude;
    private String countryString;
    private TextView countryOutput;
    private TextView emergencyNumber;
    private LocationManager currentLocation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_emergency_call);



        countryOutput = findViewById(R.id.country_text);
        emergencyNumber = findViewById(R.id.emergency_number_string);


        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED
                && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) == PackageManager.PERMISSION_GRANTED)
        {
            LocationManager lm = (LocationManager)getSystemService(Context.LOCATION_SERVICE);
            Location location = lm.getLastKnownLocation(lm.PASSIVE_PROVIDER);


            setCoordinates(location);
            setCountry();

            countryOutput.setText(countryString);

        }
        emergencyNumber.setText(returnEmergencyNumber(countryString));

    }

    public String returnEmergencyNumber(String country)
    {
        if (country.contains("United States"))
        {
            return "911";
        }
        else
        {
            return "000";
        }
    }

    public void setCoordinates(Location location)
    {
        latitude = location.getLatitude();
        longitude = location.getLongitude();

    }

    public void setCountry()
    {
        try {
            Geocoder g = new Geocoder(this);
            java.util.List<Address> addresses = null;
            addresses = g.getFromLocation(32.9869,-96.75,1);
            countryString = addresses.get(0).getCountryName();

        }
        catch (IOException e){
            e.printStackTrace();
        }

    }
}
