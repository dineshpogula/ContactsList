package com.dinesh.contactslist;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by dinesh on 3/9/2017.
 */

public class PersonDetails implements Parcelable {
    private String company;
    private String largeImageURL;
    private String email;
    private String name;
    private String home;
    private String street;
    private String city;
    private String state;
    private String country;
    private String zip;
    private Boolean favorite;

    public Boolean getFavorite () {
        return favorite;
    }

    public void setFavorite (Boolean favorite) {
        this.favorite = favorite;
    }

    public PersonDetails () {
        super();


    }


    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getLargeImageURL() {
        return largeImageURL;
    }

    public void setLargeImageURL(String largeImageURL) {
        this.largeImageURL = largeImageURL;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHome() {
        return home;
    }

    public void setHome(String home) {
        this.home = home;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public PersonDetails(String largeImageURL,String name, String company, String home, String street, String city, String state, String country, String zip, String email, Boolean favorite) {

        this.company = company;
        this.largeImageURL = largeImageURL;
        this.email = email;
        this.name = name;
        this.home = home;
        this.street = street;
        this.city = city;
        this.state = state;
        this.country = country;
        this.zip = zip;
        this.favorite = favorite;

    }



    public PersonDetails(Parcel parcel){
        this.company = parcel.readString();
      this.largeImageURL =parcel.readString();
       this.email = parcel.readString();
       this.name = parcel.readString();
     this.home = parcel.readString();
      this.street = parcel.readString();
       this.state = parcel.readString();
        this.city = parcel.readString();
       this.country = parcel.readString();
       this.zip = parcel.readString();
        this.favorite= parcel.readInt() ==1 ? true : false;

    }
    public static final Parcelable.Creator<PersonDetails> CREATOR = new Parcelable.Creator<PersonDetails>(){

        @Override
        public PersonDetails createFromParcel(Parcel parcel) {
            return new PersonDetails(parcel);
        }

        @Override
        public PersonDetails[] newArray(int i) {
            return new PersonDetails[i];
        }
    };


    @Override
    public int describeContents () {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(company);
        parcel.writeString(largeImageURL);
        parcel.writeString(email);
        parcel.writeString(name);
        parcel.writeString(home);
        parcel.writeString(street);
        parcel.writeString(city);
        parcel.writeString(state);
        parcel.writeString(country);
        parcel.writeString(zip);
        parcel.writeInt(favorite ? 0 : 1);




    }
}
