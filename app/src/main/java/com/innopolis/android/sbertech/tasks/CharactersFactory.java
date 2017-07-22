package com.innopolis.android.sbertech.tasks;

import android.content.Context;
import android.os.AsyncTask;
import android.support.v7.widget.RecyclerView;

import com.innopolis.android.sbertech.CharactersActivity;
import com.innopolis.android.sbertech.R;
import com.innopolis.android.sbertech.adapter.CharacterAdapter;
import com.innopolis.android.sbertech.models.Character;
import com.innopolis.android.sbertech.models.CharacterFetcher;

import java.util.List;

/**
 * Created by _red_ on 22.07.17.
 */

public class CharactersFactory extends AsyncTask<Void, Void, List<Character>> {

    private String startUrl;
    private int capacity;
    private Context context;
    private List<Character> items;

    public CharactersFactory(Context context, List<Character> items, String startUrl, int capacity) {
        this.context = context;
        this.items = items;
        this.startUrl = startUrl;
        this.capacity = capacity;
    }

    @Override
    protected List<Character> doInBackground(Void... voids) {
        for (int i = 1; i < capacity; i++) {
            items.add(new CharacterFetcher()
                    .fetchItems(startUrl + items.size() + i));
        }
        return items;
    }

    @Override
    protected void onPostExecute(List<Character> data) {
        super.onPostExecute(data);
        ((RecyclerView)((CharactersActivity)context).findViewById(R.id.recyclerView))
                .setAdapter(new CharacterAdapter(context, data));
    }
}
