package com.coolbeansbro.contactsmanager;

import org.junit.Before;
import org.junit.Test;
//import java.util.regex.*;



/**
 * Checks to see if contact has valid inputted data
 * return valid if true or invalid if false
 *
 * @author Raj Tailor
 * @version 1.1
 */
public class AddContactActivityTest {

    userContact raj;
    Contact tail;
    String output;

    @Before
    public void initialize()
    {
        raj = new userContact();
    }

    /*
    Tests to make sure that the email is a valid email
    */
    @Test
    public void returnEmailError() {

        output = raj.getEmail();
        String x = output.trim();

        if(x.matches("[a-zA-Z0-9\\.]+@[a-zA-Z0-9\\-\\_\\.]+\\.[a-zA-Z0-9]{3}"))
            System.out.println("Valid");
        )
        else{
            System.out.println("Invalid")
        }

    }

/*
Checks to see i the alternate number isn;t the same as the original
*/

    @Test
    public void returnBirthdayError() {

        output = raj.getAlternateNumber();
        String x = output.trim();
        String tot = tail.getNumber();
        String dec = tot.trim();
        if(x == dec){
            System.out.println("Valid");
        }
        else{
            System.out.println("Invalid");
        }



    }

}