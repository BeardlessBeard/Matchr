package com.matcherapp.matchr;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.android.volley.*;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class feed extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        RequestQueue queue = Volley.newRequestQueue(this);
        String url = "http://matchrapp.herokuapp.com/feed/";

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feed);

        final TextView mTextView = findViewById(R.id.textView);

        if(mTextView == null)
        {
            Log.v("NULL value mTextView", "mTextView is NULL");
        }
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONArray parsedResponse = new JSONArray(response);
                            for(int i = 0; i < parsedResponse.length(); i++) {
                                Post1 p = new Post1(parsedResponse.getJSONObject(i));
                                addElementToPage(p);
                            }

                        } catch (JSONException e) {
                            return;
                        }

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                mTextView.setText("That didn't work!");
                Log.v("Should be error", error.toString());
            }
        });
        queue.add(stringRequest);
    }

    void addElementToPage(Post1 p)
    {

    }
}