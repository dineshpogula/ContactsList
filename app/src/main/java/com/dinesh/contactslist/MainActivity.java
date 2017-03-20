package com.dinesh.contactslist;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonArrayRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

class MainActivity extends Activity {
    // Log tag
    private static final String TAG = MainActivity.class.getSimpleName();

    // Movies json url
    private static final String url = "https://s3.amazonaws.com/technical-challenge/Contacts.json";
    private ProgressDialog pDialog;
    static ArrayList<ContactList> con = new ArrayList<ContactList>();

    static ListView listView;
    private ContactListAdapter adapter;
     static ArrayList<PersonDetails> PD = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView) findViewById(R.id.list);
        adapter = new ContactListAdapter(this, con);
        listView.setAdapter(adapter);

        pDialog = new ProgressDialog(this);
        // Showing progress dialog before making http request
        pDialog.setMessage("Loading...");
        pDialog.show();
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,final int position, long id) {

                Intent intent = new Intent(MainActivity.this, PersonDetails_Activity.class);
                     PersonDetails jsonData = PD.get(position);
                intent.putExtra("PersonDetails", jsonData);
                startActivity(intent);
            }

        });

        // changing action bar color


        // Creating volley request obj
        JsonArrayRequest movieReq = new JsonArrayRequest(url,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        Log.d(TAG, response.toString());
                        hidePDialog();

                        // Parsing json
                        for (int i = 0; i < response.length(); i++) {
                            try {

                                JSONObject obj = response.getJSONObject(i);
           // adding movie to movies array
                                ContactList contact = new ContactList(obj.getString("name"),obj.getString("smallImageURL"),obj.getJSONObject("phone").getString("home"));
                                con.add(contact);
                                PersonDetails details = new PersonDetails(obj.getString("largeImageURL"),obj.getString("name"),obj.getString("company"),obj.getJSONObject("phone").getString("home"),obj.getJSONObject("address").getString("street"),obj.getJSONObject("address").getString("city"),obj.getJSONObject("address").getString("state"),obj.getJSONObject("address").getString("country"),obj.getJSONObject("address").getString("zip"),obj.getString("email"),obj.getBoolean("favorite"));
                                PD.add(details);

                            } catch (JSONException e) {
                                e.printStackTrace();
                            }

                        }

                        // notifying list adapter about data changes
                        // so that it renders the list view with updated data
                        adapter.notifyDataSetChanged();
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                VolleyLog.d(TAG, "Error: " + error.getMessage());
                hidePDialog();

            }
        });

        // Adding request to request queue
        AppController.getInstance().addToRequestQueue(movieReq);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        hidePDialog();
    }

    private void hidePDialog() {
        if (pDialog != null) {
            pDialog.dismiss();
            pDialog = null;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

}
