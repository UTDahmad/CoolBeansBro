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


/**
 * The EmergencyCallActivity class is used to provide
 * the user with an emergency contact number that is
 * specific to the user's country. This class requires
 * that location services be enabled to work properly.
 *
 *
 * @version 1.1
 */
public class EmergencyCallActivity extends AppCompatActivity {

    //private data
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


        //Initialize the two output objects that will be provided
        //with string that provide the user's current country
        //and the corresponding emergency number
        countryOutput = findViewById(R.id.country_text);
        emergencyNumber = findViewById(R.id.emergency_number_string);


        //If the device has allowed this app to use location
        //services data in the android settings app, the emergency
        //contact number will be calculated
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED
                && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) == PackageManager.PERMISSION_GRANTED)
        {

            //Save the current location in the location manager
            currentLocation = (LocationManager)getSystemService(Context.LOCATION_SERVICE);
            Location location = currentLocation.getLastKnownLocation(currentLocation.PASSIVE_PROVIDER);


            //Call function to save coordinate data from the location
            //into the variables initialized earlier
            setCoordinates(location);

            //Call function to set the country name
            //from the provided location data
            setCountry();

            //Call function to place the correct emergency phone number string
            //in the countryString variable
            countryOutput.setText(countryString);

        }

        //Pass on the string information to the object that will display the correct text
        //on the user's display
        emergencyNumber.setText(returnEmergencyNumber(countryString));

    }


    /**
     * This function accepts a country name as a string and calculates
     * the correct emergency phone number for that country. As of version
     * 1.2, only 11 countries are supported.
     *
     * @version 1.2
     * @param country the String name of the country the user is located in
     * @return String value that contains an emergency phone number
     */
    public String returnEmergencyNumber(String country)
    {
        if (country.contains("United States"))
        {
            return "911";
        }
        else if (country.contains("Algeria"))
        {
            return "14";
        }
        else if (country.contains("Egypt"))
        {
            return "123";
        }
        else if (country.contains("China"))
        {
            return "120";
        }
        else if (country.contains("India"))
        {
            return "102";
        }
        else if (country.contains("Indonesia"))
        {
            return "119";
        }
        else if (country.contains("United Arab Emirates"))
        {
            return "112";
        }
        else if (country.contains("Mexico"))
        {
            return "066";
        }
        else if (country.contains("Canada"))
        {
            return "911";
        }
        else if (country.contains("Australia"))
        {
            return "000";
        }
        else if (country.contains("United Kingdom"))
        {
            return "999";
        }
        else return "???";
    }

    /**
     * The setCoordinates function xtracts longitude and
     * latitude from a location object
     *
     * @param location Object that contains the user's current location data
     */
    public void setCoordinates(Location location)
    {
        latitude = location.getLatitude();
        longitude = location.getLongitude();

    }

    /**
     * This function uses android.location.Geocoder in order to
     * set an address from the given coordinates. Then, the country
     * name is extracted from the address and returned
     *
     */
    public void setCountry()
    {
        try {


            Geocoder g = new Geocoder(this);
            java.util.List<Address> addresses;


            //Convert latitude and longitude to a single address
            addresses = g.getFromLocation(latitude,longitude,1);


            //Extract the country name from the current address
            countryString = addresses.get(0).getCountryName();

        }
        catch (IOException e){
            e.printStackTrace();
        }

    }
}
