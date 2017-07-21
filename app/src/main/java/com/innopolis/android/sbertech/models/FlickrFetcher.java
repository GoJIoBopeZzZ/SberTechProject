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

public class FlickrFetcher {

    /**
     * Created by _red_ on 06.07.17.
     */

    private static final String TAG = "FlickrFetcher";

    public String getJSONString(URL url) throws IOException {

        HttpURLConnection urlConnection = null;
        BufferedReader reader = null;
        String resultJson = "";

        try {
            urlConnection = (HttpURLConnection) url.openConnection();
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

    public List<Character> fetchItems(URL url) {
        List<Character> characters = new ArrayList<>();
        try {
            String jsonString = getJSONString(url);
            JSONObject jsonBody = new JSONObject(jsonString);
            Log.d(TAG , jsonBody.toString());
        } catch (IOException ex) {
            Log.e(TAG , "Ошибка загрузки данных", ex);
            return characters;
        } catch (JSONException jex) {
            Log.e(TAG , "Empty JSON", jex);
            return characters;
        }

        return characters;
    }

    private void parseItem(List<Character> items, JSONObject object)
            throws IOException, JSONException {

        Character item = new Character();
        item.setName(object.getString("name"));
        Log.e(TAG , item.getName());
        item.setBirthday(object.getString("born"));
        Log.e(TAG , item.getBirthday());
        items.add(item);
    }
}
