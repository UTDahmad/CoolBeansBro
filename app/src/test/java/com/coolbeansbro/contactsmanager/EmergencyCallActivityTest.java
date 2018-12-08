package com.coolbeansbro.contactsmanager;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;


/**
 * Checks to see if inputting a country into the returnEmergencyCallFunction will
 * return the correct emergency number
 *
 * @author Ahmed Khan
 * @version 1.1
 */
public class EmergencyCallActivityTest {


    EmergencyCallActivity e;
    String output;

    @Before
    public void initialize()
    {
        e = new EmergencyCallActivity();
    }


    /*
    Test Case with a country that has a corresponding
    emergency call number
    */
    @Test
    public void returnEmergencyNumber() {

        String input = "United States";
        String expected = "911";


        output = e.returnEmergencyNumber(input);
        assertEquals(expected, output);



    }

    /*
    Test Case with a country that has a corresponding
    emergency call number
    */
    @Test
    public void returnEmergencyNumber2() {

        String input = "Australia";
        String expected = "000";


        output = e.returnEmergencyNumber(input);
        assertEquals(expected, output);



    }
    /*
    Test Case with gibberish that has no corresponding
    emergency call number
    */
    @Test
    public void returnEmergencyNumber3() {

        String input = "hlsafhlksg";
        String expected = "???";


        output = e.returnEmergencyNumber(input);
        assertEquals(expected, output);



    }

    /*
    Test Case with an empty string that has no corresponding
    emergency call number
    */
    @Test
    public void returnEmergencyNumber4() {

        String input = "";
        String expected = "???";


        output = e.returnEmergencyNumber(input);
        assertEquals(expected, output);



    }
}