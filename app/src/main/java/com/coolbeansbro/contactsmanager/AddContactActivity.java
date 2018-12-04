package com.coolbeansbro.contactsmanager;

import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

public class AddContactActivity extends AppCompatActivity {

    EditText name;
    EditText number;
    EditText email;
    EditText alternateNumber;
    EditText birthday;
    EditText group;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_contact);
        name = findViewById(R.id.name_input);
        number = findViewById(R.id.phone1_input);
        alternateNumber = findViewById(R.id.phone2_input);
        email = findViewById(R.id.name_input);
        birthday = findViewById(R.id.birthday_input);
        group = findViewById(R.id.group_input);


    }
}
