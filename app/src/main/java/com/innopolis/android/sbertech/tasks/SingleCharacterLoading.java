package com.innopolis.android.sbertech.tasks;

import android.content.Context;
import android.os.AsyncTask;

import com.innopolis.android.sbertech.models.Character;
import com.innopolis.android.sbertech.models.CharacterFetcher;

/**
 * Created by _red_ on 24.07.17.
 */

public class SingleCharacterLoading extends AsyncTask<Void, Void, Void> {
    private String url;
    private Context context;
    private Character character;

    public SingleCharacterLoading(Context context, Character character, String url) {
        this.context = context;
        this.character = character;
        this.url = url;
    }

    @Override
    protected Void doInBackground(Void... voids) {
        character = new CharacterFetcher().fetchItems(url);
        return null;
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);

    }
}
