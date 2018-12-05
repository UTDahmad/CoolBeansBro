package com.coolbeansbro.contactsmanager;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SearchView;
import java.util.ArrayList;


/**
 * The MainActivity class is responsible for connect the UI elements on the
 * main page of the application to their respective controls. Elements include
 * the search bar, floating action buttons, and the list view that displays all
 * of the contacts from a database.
 *
 *
 * @version 1.3
 *
 */
public class MainActivity extends AppCompatActivity {

    //initialize floating action buttons
    private FloatingActionButton addContactButton;
    private FloatingActionButton emergencyCallButton;


    //initialize the List View and associated adapter
    //for the search feature
    ListView all_contacts_search;
    ArrayAdapter<String> adapter;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //Associate the ListView object with the corresponding
        //list item in the xml
        all_contacts_search = findViewById(R.id.all_contacts_search);


        //Associate the floating action button objects with
        //the correspond buttons in the xml
        addContactButton = findViewById(R.id.floatingAddContact);
        emergencyCallButton = findViewById(R.id.floatingEmergencyCall);


        //Link the button to an activity
        addContactButton.setOnClickListener(new View.OnClickListener()
        {
            @Override

            //Call function to open a new activity
            //page when the button is pressed
            public void onClick(View v)
            {
                AddContactActivity();
            }
        });


        //Link the button to an activity
        emergencyCallButton.setOnClickListener(new View.OnClickListener()
        {
            @Override


            //Call function to open a new activity
            //page when the button is pressed
            public void onClick(View v)
            {
                EmergencyCallActivity();
            }


        });



    }

    @Override

    //Code to implement a search bar in the menu
    //by using the custom menu layout created
    public boolean onCreateOptionsMenu(Menu menu)
    {

        //Use an inflater to inflate the custom
        //search menu that was defined in an xml
        MenuInflater search = getMenuInflater();
        search.inflate(R.menu.all_contacts, menu);

        //Initializing the specific search object from within
        //the menu and displaying it
        MenuItem searchBar = menu.findItem(R.id.all_contacts_search);
        SearchView searchContacts = (SearchView)searchBar.getActionView();


        searchContacts.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String text) {


                //Filter used to constrain data based
                //on the getFilter method
                adapter.getFilter().filter(text);
                return false;
            }
        });


        //super method that executes code that is required
        //to get everything running
        return super.onCreateOptionsMenu(menu);
    }

    /**
     * This function is used to start a new activity,
     * which is the activity used to add a new contact
     *
     */
    public void AddContactActivity()
    {
        //Specify which activity needs to be called and start the activity
        Intent intent = new Intent(this, AddContactActivity.class);
        startActivity(intent);
    }

    /**
     * This function is used to start a new activity,
     * which is the activity used make an emergency call
     *
     */
    public void EmergencyCallActivity()
    {

        //Specify which activity needs to be called and start the activity
        Intent intent = new Intent(this, EmergencyCallActivity.class);
        startActivity(intent);
    }
}
