package com.coolbeansbro.contactsmanager;

import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class AddContactActivity extends AppCompatActivity {

    TextInputEditText name;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_contact);
     //   name = findViewById(R.id.contactName);


    }
}
