package com.innopolis.android.sbertech.tasks;

import android.content.Context;
import android.os.AsyncTask;
import android.support.v7.widget.RecyclerView;

import com.innopolis.android.sbertech.CharactersActivity;
import com.innopolis.android.sbertech.R;
import com.innopolis.android.sbertech.models.Character;
import com.innopolis.android.sbertech.models.CharacterFetcher;

import java.util.List;

/**
 * Created by _red_ on 22.07.17.
 */

public class CharactersFactory extends AsyncTask<Void, Void, List<Character>> {

    private String startUrl;
    private Context context;
    private List<Character> items;

    public CharactersFactory(Context context, List<Character> items, String startUrl) {
        this.context = context;
        this.items = items;
        this.startUrl = startUrl;
    }

    @Override
    protected List<Character> doInBackground(Void... voids) {
        int count = items.size();
        for (int i = 1; i < 10; i++) {
            items.add(new CharacterFetcher()
                    .fetchItems(startUrl + count + i));
        }
        return items;
    }

    @Override
    protected void onPostExecute(List<Character> data) {
        super.onPostExecute(data);
        ((RecyclerView)((CharactersActivity)context)
                .findViewById(R.id.recyclerView))
                .getAdapter()
                .notifyDataSetChanged();
    }
}
