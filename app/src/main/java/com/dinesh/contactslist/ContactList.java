package com.dinesh.contactslist;

/**
 * Created by dinesh on 3/8/2017.
 */

public class ContactList {
    private String name, smallImageURL;

    private String home;




    public ContactList(String name, String smallImageURL,String home) {
        this.name = name;
        this.smallImageURL = smallImageURL;
        this.home = home;
}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSmallImageURL() {
        return smallImageURL;
    }

    public void setSmallImageURL(String smallImageURL) {
        this.smallImageURL = smallImageURL;
    }




    public void setHome(String home) {
        this.home = home;
    }

    public String getHome() {
        return home;
    }

}
