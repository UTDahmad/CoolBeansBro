package com.coolbeansbro.contactsmanager;

import org.junit.Test;

import static org.junit.Assert.*;

public class EmergencyCallActivityTest {

    @Test
    public void returnEmergencyNumber() {

        String input = "United States";
        String output;
        String expected = "911";

        EmergencyCallActivity e = new EmergencyCallActivity();

        output = e.returnEmergencyNumber(input);
        assertEquals(expected, output);



    }

    @Test
    public void returnEmergencyNumber2() {

        String input = "Australia";
        String output;
        String expected = "000";

        EmergencyCallActivity e = new EmergencyCallActivity();

        output = e.returnEmergencyNumber(input);
        assertEquals(expected, output);



    }
    @Test
    public void returnEmergencyNumber3() {

        String input = "hlsafhlksg";
        String output;
        String expected = "???";

        EmergencyCallActivity e = new EmergencyCallActivity();

        output = e.returnEmergencyNumber(input);
        assertEquals(expected, output);



    }
}