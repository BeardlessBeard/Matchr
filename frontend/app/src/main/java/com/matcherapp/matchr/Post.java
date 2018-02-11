package com.matcherapp.matchr;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


public class Post {

    String shirtURL;
    int postID;
    String user;
    Pants[] pants;


    public Post(JSONObject obj)
    {
        try {
            shirtURL = obj.getString("shirtURL");
            postID = obj.getInt("postID");
            user = obj.getString("user");
            pants = getPants(obj);
        } catch(JSONException e) {}

    }

    private Pants[] getPants(JSONObject obj) throws JSONException {
        JSONArray pants = obj.getJSONArray("pants");
        Pants[] rtn = new Pants[pants.length()];
        for(int i = 0 ; i < pants.length(); i++)
        {
            rtn[i] = new Pants(pants.getJSONObject(i));
        }
        return rtn;
    }
}
