package com.innopolis.android.sbertech.models;

import android.content.Context;
import android.support.v4.content.AsyncTaskLoader;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

/**
 * Created by _red_ on 21.07.17.
 */

public class CharactersLoader extends AsyncTaskLoader<List<Character>> {

    private static URL lentaRssUrl;
    private final String TAG = "RssService";
    private List<Character> characters;
    private Context context;

    static {
        try {
            lentaRssUrl = new URL("https://lenta.ru/rss/news/russia ");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    public CharactersLoader(Context context) {
        super(context);
        this.context = context;
    }

    @Override
    public List<Character> loadInBackground() {

        return characters;
    }

    @Override
    public void deliverResult(List<Character> data) {
        super.deliverResult(data);
    }

    @Override
    protected void onStartLoading() {
        super.onStartLoading();
        if (characters == null)
            forceLoad();
        else deliverResult(characters);
    }

    @Override
    protected void onStopLoading() {
        super.onStopLoading();
    }

    @Override
    protected void onReset() {
        characters.clear();
        super.onReset();
    }

    private InputStream getInputStream(URL url) throws IOException {
        return url.openConnection().getInputStream();
    }
}
