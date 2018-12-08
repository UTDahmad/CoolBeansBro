package com.coolbeansbro.contactsmanager;

import android.support.test.rule.ActivityTestRule;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Tests loaded contacts to ensure the name, number and id are not null
 * Additionally tests to make sure the contact ids are not empty
 * @author  Yeswanth Bogireddy
 */
public class MainActivityTests {
    ArrayList<userContact> contactsList  = new ArrayList<>();
    MainActivity activity;

    @Rule
    public ActivityTestRule<MainActivity> activityRule = new ActivityTestRule(MainActivity.class);

    @Before
    public void init() throws Exception{
        activity = activityRule.getActivity();
    }

    @Test
    public void loadContactsCheckContactsName() {
        contactsList = activity.loadContacts();
        for (Contact c: contactsList){
            assertNotNull(c.getName());
        }
    }

    @Test
    public void loadContactsCheckContactsNumber() {
        contactsList = activity.loadContacts();
        for (Contact c: contactsList){
            assertNotNull(c.getNumber());
        }
    }

    @Test
    public void loadContactsCheckContactsIdNotNull() {
        contactsList = activity.loadContacts();
        for (Contact c: contactsList){
            assertNotNull(c.getID());
        }
    }

    @Test
    public void loadContactsCheckContactsIdNotEmpty() {
        contactsList = activity.loadContacts();
        for (Contact c: contactsList){
            assertNotEquals(c.getID(),"");
        }
    }


}