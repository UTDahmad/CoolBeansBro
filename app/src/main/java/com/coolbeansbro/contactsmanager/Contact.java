package com.coolbeansbro.contactsmanager;

public class Contact {

    private String name;
    private String number;
    private String email;
    private String alternateNumber;
    private String birthday;
    private String group;
    // private String photo;
    //private String notes;


    public Contact() {

    }

    public Contact(String name, String number, String alternateNumber, String email, String birthday, String group) {
        this.name = name;
        this.number = number;
        this.email = email;
        this.alternateNumber = alternateNumber;
        this.birthday = birthday;
        this.group = group;
        // this.notes = notes;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
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

    public String toString() {

        return "Contact{" +

                "name='" + name + '\'' +

                ", number='" + number + '\'' +

                ", alternativeNumber='" + alternateNumber + '\'' +

                ", email='" + email + '\'' +
                ", birthday='" + birthday + '\'' +
                ", group='" + group + '\'' +
                '}';
    }
}