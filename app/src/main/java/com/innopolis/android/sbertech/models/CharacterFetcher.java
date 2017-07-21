package com.innopolis.android.sbertech.models;

import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by _red_ on 21.07.17.
 */

public class CharacterFetcher {
    private static final String TAG = "FlickrFetcher";

    public String getJSONString(String url) throws IOException {

        HttpURLConnection urlConnection = null;
        BufferedReader reader = null;
        String resultJson = "";

        URL urlRes = new URL(url);

        try {
            urlConnection = (HttpURLConnection) urlRes.openConnection();
            urlConnection.setRequestMethod("GET");
            urlConnection.connect();

            InputStream inputStream = urlConnection.getInputStream();
            StringBuffer buffer = new StringBuffer();

            reader = new BufferedReader(new InputStreamReader(inputStream));

            String line;
            while ((line = reader.readLine()) != null) {
                buffer.append(line);
            }

            resultJson = buffer.toString();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return resultJson;
    }

    public Character fetchItems(String url) {
        Character character = new Character();
        try {
            String jsonString = getJSONString(url);
            JSONObject jsonBody = new JSONObject(jsonString);
            parseItem(character, jsonBody);
        } catch (IOException ex) {
            Log.e(TAG , "Ошибка загрузки данных", ex);
        } catch (JSONException jex) {
            Log.e(TAG , "Empty JSON", jex);
        }

        return character;
    }

    private void parseItem(Character item, JSONObject object)
            throws IOException, JSONException {

        item.setTitle(object.getString("titles"));
        item.setName(object.getString("name"));
        item.setGender(object.getString("gender"));
        item.setCulture(object.getString("culture"));
        item.setBirthday(object.getString("born"));
        item.setDied(object.getString("died"));

        Log.d(TAG , "Adds object - " + object.toString());
    }
}
