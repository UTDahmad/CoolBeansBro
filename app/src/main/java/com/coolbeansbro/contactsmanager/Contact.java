package com.coolbeansbro.contactsmanager;


/**
 * This class is for contacts objects that have a phone number associated
 *
 * @author Ahmed Khan
 * @version 2.0
 */
public class Contact {
    private String number;

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}



/**
 * This class is for emergencyContacts objects that have an emergency
 * number and a country name. This class extends the contact class
 *
 * @author Ahmed Khan
 * @version 1.0
 */
class emergencyContact extends Contact {

    private String countryName;

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }
}

/**
 * This class is for userContacts objects that have multiple string
 * data values associated with them. For use alongside database and
 * lisviews. This class extends the contact class
 *
 * @author Ahmed Khan
 * @version 1.0
 */

class userContact extends Contact {


    //initialize strings
    private String name;
    private String email;
    private String alternateNumber;
    private String birthday;
    private String group;
    // private String photo;
    //private String notes;

    public userContact() {

    }

    //Constructor that stores all contact information
    public userContact(String name, String number, String alternateNumber, String email, String birthday, String group) {
        this.name = name;
        this.setNumber(number);
        this.email = email;
        this.alternateNumber = alternateNumber;
        this.birthday = birthday;
        this.group = group;

    }


    //get and set methods
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAlternateNumber() {
        return alternateNumber;
    }

    public void setAlternateNumber(String alternateNumber) {
        this.alternateNumber = alternateNumber;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    // public String getPhoto() {
    //     return photo;
    //}

    // public void setPhoto(String photo) {
    //     this.photo = photo;
    // }

    // public String getNotes(String notes){ return notes; }


    @Override

    /**
     * Returns a string that will be used later with the search function
     */
    public String toString() {

        return  name + ' ' +
                this.getNumber() + ' ' +
                alternateNumber + ' ' +
                email + ' ' +
                birthday + ' ' +
                group;
    }
}