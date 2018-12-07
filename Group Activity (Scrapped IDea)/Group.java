private void newGroup() {
        ArrayList<Contact> newList = new ArrayList<Contact>();

        newList.add(ContentProviderOperation
        .newInsert(Contact.grouping.NAME)
        .withValue(Contac.grouping.PREFIX, " ").create());
        try {
        newGroup().apply(Contacts.NAME, newList);

        }
        catch (Exception ex) {
        System.out.print("Error Detected", ex.toString());
        }

        }