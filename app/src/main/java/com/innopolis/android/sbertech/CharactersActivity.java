package com.innopolis.android.sbertech;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import com.innopolis.android.sbertech.adapter.CharacterAdapter;
import com.innopolis.android.sbertech.models.Character;
import com.innopolis.android.sbertech.tasks.CharactersFactory;
import java.util.ArrayList;
import java.util.List;

public class CharactersActivity extends AppCompatActivity {

    private final String TAG = "CharactersActivity";
    private final String resourceURL = "https://anapioficeandfire.com/api/characters/";
    private List<Character> items = new ArrayList<>();
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new CharacterAdapter(this, items));

        CharactersFactory charactersFactory = new CharactersFactory(this, items, resourceURL);
        charactersFactory.execute();
    }
}
