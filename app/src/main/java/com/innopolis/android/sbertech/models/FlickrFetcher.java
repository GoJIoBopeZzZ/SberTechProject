package com.innopolis.android.sbertech.models;

import android.net.Uri;
import android.util.Log;

import org.json.JSONArray;
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

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

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
//            URL url = new URL("https://anapioficeandfire.com/api/characters/");

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

    public List<Character> fetchItems() {
        List<Character> characters = new ArrayList<>();
        try {
            URL url = new URL("https://anapioficeandfire.com/api/characters");

            String jsonString = getJSONString(url);
            Log.e(TAG , jsonString);
            JSONArray jsonArray = new JSONArray(jsonString);
//            JSONObject jsonBody = new JSONObject(jsonString);
            parseItems(characters, jsonArray);
        } catch (IOException ex) {
            Log.e(TAG , "Ошибка загрузки данных", ex);
        } catch (JSONException jex) {
            Log.e(TAG , "Ошибка парсинга JSON", jex);
        }

        return characters;
    }

    private void parseItems(List<Character> items, JSONArray jsonArray)
            throws IOException, JSONException {
//        JSONObject photosJsonObject = jsonBody.getJSONObject("photos");
        JSONArray photosJsonArray = jsonArray;

        for (int i = 0; i < photosJsonArray.length(); i++) {
            JSONObject jsonObject = photosJsonArray.getJSONObject(i);
            Character item = new Character();
            item.setName(jsonObject.getString("name"));
            item.setBirthday(jsonObject.getString("born"));

            if (!jsonObject.has("url_s")) continue;

//            item.setUrl(jsonObject.getString("url_s"));
            items.add(item);
        }
    }
}
