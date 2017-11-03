package com.innopolis.android.sbertech.models;

import android.util.Log;
import android.widget.Toast;

import com.innopolis.android.sbertech.CharactersActivity;
import com.innopolis.android.sbertech.models.impl.StringBuilderFromList;

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

public class CharacterFetcher {
    private static final String TAG = "CharacterFetcher";

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

        item.setUrl(object.getString("url"));
        item.setSpouse(object.getString("spouse"));
        item.setName(object.getString("name"));
        item.setGender(object.getString("gender"));
        item.setMother(object.getString("mother"));
        item.setFather(object.getString("father"));
        item.setCulture(object.getString("culture"));
        item.setBirthday(object.getString("born"));
        item.setDied(object.getString("died"));
        item.setAliases(parseArrayItems(object, "aliases"));
        item.setTitles(parseArrayItems(object, "titles"));
        item.setAllegiances(parseArrayItems(object, "allegiances"));
        item.setBooks(parseArrayItems(object, "books"));
        item.setPlayedBy(parseArrayItems(object, "playedBy"));
        item.setPovBooks(parseArrayItems(object, "povBooks"));
        item.setTvSeries(parseArrayItems(object, "tvSeries"));
        Log.d(TAG , "Adds object - " + object.getString("url"));
    }

    private List<String> parseArrayItems(JSONObject object, String str)
            throws IOException, JSONException {
        List<String> list = new ArrayList<>();
        JSONArray titlesJsonArray = object.getJSONArray(str);
        for (int i = 0; i < titlesJsonArray.length(); i++) {
            list.add(titlesJsonArray.getString(i));
        }
        return list;
    }
}
