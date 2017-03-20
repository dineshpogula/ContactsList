package com.dinesh.contactslist;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;

public class PersonDetails_Activity extends AppCompatActivity {
    private TextView textone,texttwo, textthree, textfour, textfive, textsix,textseven,texteight,txt1;
    ImageLoader imageLoader = AppController.getInstance().getImageLoader();
    private NetworkImageView networkImageView;
    private RatingBar fav;

    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

       ImageView backimage = (ImageView) findViewById(R.id.backimage);
        backimage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View v) {
                Intent in = new Intent(PersonDetails_Activity.this, MainActivity.class);
                startActivity(in);
                finish();

            }
        });



        PersonDetails det = (PersonDetails) getIntent().getParcelableExtra("PersonDetails");

        if (imageLoader == null)
            imageLoader = AppController.getInstance().getImageLoader();
        networkImageView = (NetworkImageView) findViewById(R.id.ImageOne);
        texttwo = (TextView)findViewById(R.id.companyname);
        textthree =(TextView) findViewById(R.id.number);
        textfour = (TextView) findViewById(R.id.streetddress);
        textfive = (TextView) findViewById(R.id.cityaddress);
        textsix = (TextView)findViewById(R.id.stateaddress);
        textseven = (TextView) findViewById(R.id.countryaddress);
        texteight = (TextView)findViewById(R.id.Zipaddress);
        txt1 = (TextView) findViewById(R.id.personemail);
        textone =(TextView)findViewById(R.id.nameofcontact);
        fav = (RatingBar) findViewById(R.id.ratingBar);



        String largeImageURL = det.getLargeImageURL();
        String name =  det.getName();
        String company = det.getCompany();
        String home = det.getHome();
        String street = det.getStreet();
        String city = det.getCity();
        String state = det.getState();
        String country = det.getCountry();
        String zip = det.getZip();
        String email = det.getEmail();
        final Boolean favorite = det.getFavorite();

        networkImageView.setImageUrl(largeImageURL, imageLoader);


        textone.setText(name);
        texttwo.setText(company);
        textthree.setText(home);
        textfour.setText(street);
        textfive.setText(city);
        textsix.setText(state);
        textseven.setText(country);
        texteight.setText(zip);
        txt1.setText(email);
        fav.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged (RatingBar ratingBar, float rating, boolean fromUser) {
                favorite.parseBoolean(String.valueOf(favorite));

            }
        });




    }



}
