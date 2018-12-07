package com.coolbeansbro.contactsmanager;

import android.Manifest;
import android.content.ContentResolver;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Color;
import android.net.Uri;
import android.provider.ContactsContract;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
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
    ListView contactsListView;
    ContactDisplay adapter;

    ArrayList<Contact> contactsList  = new ArrayList<>();

    final int MY_PERMISSIONS_REQUEST_READ_CONTACTS = 111;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //Associate the ListView object with the corresponding
        //list item in the xml
        all_contacts_search = findViewById(R.id.all_contacts_search);

        //main listview with all contacts
        contactsListView = findViewById(R.id.contacts_lv);


        //create contacts adapter
        adapter = new ContactDisplay(this, R.layout.contact_item, contactsList);
        contactsListView.setAdapter(adapter);

        contactsListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Contact c = contactsList.get(position);
                Intent intent = new Intent(Intent.ACTION_VIEW);
                Uri uri = Uri.withAppendedPath(ContactsContract.Contacts.CONTENT_URI, String.valueOf(c.getID()));
                intent.setData(uri);
                startActivity(intent);
            }
        });



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


        if (checkPermissions()) {
            contactsList = loadContacts();
            adapter.notifyDataSetChanged();
        }

    }


    public boolean checkPermissions(){
        // Here, thisActivity is the current activity
        if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.READ_CONTACTS)
                != PackageManager.PERMISSION_GRANTED) {

            // Permission is not granted
            // Should we show an explanation?
            if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                    Manifest.permission.READ_CONTACTS)) {
                // Show an explanation to the user *asynchronously* -- don't block
                // this thread waiting for the user's response! After the user
                // sees the explanation, try again to request the permission.
                return false;
            } else {
                // No explanation needed; request the permission
                ActivityCompat.requestPermissions(this,
                        new String[]{Manifest.permission.READ_CONTACTS},
                        MY_PERMISSIONS_REQUEST_READ_CONTACTS);

                // MY_PERMISSIONS_REQUEST_READ_CONTACTS is an
                // app-defined int constant. The callback method gets the
                // result of the request.
                return false;
            }
        } else {
            // Permission has already been granted
            return true;
        }
    }


    /**
     * @return loaded contacts from android database
     */
    public ArrayList<Contact> loadContacts(){
        ArrayList<Contact> tempContacts = new ArrayList<>();
        ContentResolver contentResolver = getContentResolver();
        Cursor cursor = contentResolver.query(ContactsContract.Contacts.CONTENT_URI, null, null, null, ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME + " ASC");
        if (cursor.getCount() > 0) {
            while (cursor.moveToNext()) {

                int hasPhoneNumber = Integer.parseInt(cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts.HAS_PHONE_NUMBER)));
                if (hasPhoneNumber > 0) {
                    String id = cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts._ID));
                    String name = cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME));

                    Contact contact = new Contact();
                    contact.setName(name);
                    contact.setID(id);

                    Cursor phoneCursor = contentResolver.query(
                            ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
                            null,
                            ContactsContract.CommonDataKinds.Phone.CONTACT_ID + " = ?", new String[]{id},
                            null);
                    if (phoneCursor != null) {
                        if (phoneCursor.moveToNext()) {
                            String phoneNumber = phoneCursor.getString(phoneCursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));

                            contact.setNumber(phoneNumber);
                            //At here You can add phoneNUmber and Name to you listView ,ModelClass,Recyclerview
                            phoneCursor.close();
                        }
                    }

                    tempContacts.add(contact);
                }
            }
        }
        return tempContacts;
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


    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           String permissions[], int[] grantResults) {
        switch (requestCode) {
            case MY_PERMISSIONS_REQUEST_READ_CONTACTS: {
                // If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    // permission was granted, yay! Do the
                    // contacts-related task you need to do.
                    contactsList = loadContacts();
                    adapter.notifyDataSetChanged();
                } else {
                    // permission denied, boo! Disable the
                    // functionality that depends on this permission.
                }
                return;
            }

            // other 'case' lines to check for other
            // permissions this app might request.
        }
    }
}
