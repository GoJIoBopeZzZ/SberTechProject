package com.innopolis.android.sbertech;

import android.os.AsyncTask;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.innopolis.android.sbertech.adapter.CharacterAdapter;
import com.innopolis.android.sbertech.models.Character;
import com.innopolis.android.sbertech.models.CharacterFetcher;
import com.innopolis.android.sbertech.models.CharactersLoader;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private final String TAG = "MainActivity";
    private List<Character> items = new ArrayList<>();
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        CharacterFactory characterFactory = new CharacterFactory();
        characterFactory.execute();
    }

    class CharacterFactory extends AsyncTask<Void, Void, List<Character>> {

        private URL url;
        private int capacity;

        public CharacterFactory() {
        }

        @Override
        protected List<Character> doInBackground(Void... voids) {
            items.add(new CharacterFetcher()
                    .fetchItems("https://anapioficeandfire.com/api/characters/583"));
            return items;
        }

        @Override
        protected void onPostExecute(List<Character> data) {
            super.onPostExecute(data);
            recyclerView.setAdapter(new CharacterAdapter(MainActivity.this, data));
        }
    }
}
