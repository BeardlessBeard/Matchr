package com.matcherapp.matchr;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by chris on 2/10/18.
 */

public class Pants {
    String URL;
    int score;

    public Pants(JSONObject obj) {
        try
        {
            URL = obj.getString("url");
            score = obj.getInt("score");
        }
        catch(JSONException e){}
    }
}
