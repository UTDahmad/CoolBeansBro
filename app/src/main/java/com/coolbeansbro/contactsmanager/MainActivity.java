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

public class MainActivity extends AppCompatActivity {

    private FloatingActionButton addContactButton;
    private FloatingActionButton emergencyCallButton;


    ListView all_contacts_search;

    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        all_contacts_search = (ListView) findViewById(R.id.all_contacts_search);

        addContactButton = findViewById(R.id.floatingAddContact);
        addContactButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                AddContactActivity();
            }
        });

        emergencyCallButton = findViewById(R.id.floatingEmergencyCall);
        emergencyCallButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                EmergencyCallActivity();
            }
        });





    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater search = getMenuInflater();
        search.inflate(R.menu.all_contacts, menu);
        MenuItem searchBar = menu.findItem(R.id.all_contacts_search);
        SearchView searchContacts = (SearchView)searchBar.getActionView();

        searchContacts.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String text) {
                adapter.getFilter().filter(text);
                return false;
            }
        });

        return super.onCreateOptionsMenu(menu);
    }

    public void AddContactActivity()
    {
        Intent intent = new Intent(this, AddContactActivity.class);
        startActivity(intent);
    }

    public void EmergencyCallActivity()
    {
        Intent intent = new Intent(this, EmergencyCallActivity.class);
        startActivity(intent);
    }
}
