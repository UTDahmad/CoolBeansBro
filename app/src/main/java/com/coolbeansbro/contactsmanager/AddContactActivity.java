package com.coolbeansbro.contactsmanager;

import android.content.Intent;
import android.provider.ContactsContract;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

/**
 * This class connects the add contact xml to the java code.
 * A contact object is saved from the data inputted by the user
 * when the add button is pressed.
 *
 * @version 1.0
 */
public class AddContactActivity extends AppCompatActivity {

    //initialize EditText objects
    EditText name;
    EditText number;
    EditText email;
    EditText alternateNumber;
    EditText group;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_contact);
        name = findViewById(R.id.name_input);
        number = findViewById(R.id.phone1_input);
        alternateNumber = findViewById(R.id.phone2_input);
        email = findViewById(R.id.email_input);
        group = findViewById(R.id.group_input);
    }

    public void addContactClick(View v){


        //Get text from user into strings
        String nameString = name.getText().toString();
        String phoneNumber = number.getText().toString();
        String emailString = email.getText().toString();
        String secondaryPhoneNumber = alternateNumber.getText().toString();
        String groupString = group.getText().toString();

        //Should do checks on phoneNumber, name etc
        if(!(nameString.equals("")&& phoneNumber.equals(""))) {


            Intent contactIntent = new Intent(ContactsContract.Intents.Insert.ACTION);
            contactIntent.setType(ContactsContract.RawContacts.CONTENT_TYPE);

            //Start contact activity to add contact data
            contactIntent
                    .putExtra(ContactsContract.Intents.Insert.NAME, nameString)
                    .putExtra(ContactsContract.Intents.Insert.PHONE, phoneNumber)
                    .putExtra(ContactsContract.Intents.Insert.EMAIL, emailString)
                    .putExtra(ContactsContract.Intents.Insert.SECONDARY_PHONE, secondaryPhoneNumber)
                    .putExtra(ContactsContract.Intents.Insert.NOTES, groupString);

            startActivityForResult(contactIntent, 1);

        }
        else
            Toast.makeText(this,"Invalid input", Toast.LENGTH_SHORT).show();
    }


}
