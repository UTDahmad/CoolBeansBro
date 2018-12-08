package com.coolbeansbro.contactsmanager;

public class GroupHelper {

    Contacts grouping;
    create grouping() {
        Contact C = this.Contact();
        grouping = new Contacts();
        grouping.put(Contacts.grouping.NAME, "Group Name");
        C.insert(Contacts.grouping.NAME, grouping);
    }

}
