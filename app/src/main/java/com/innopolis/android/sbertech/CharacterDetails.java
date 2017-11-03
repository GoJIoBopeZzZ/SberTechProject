package com.innopolis.android.sbertech;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.innopolis.android.sbertech.models.Character;
import com.innopolis.android.sbertech.models.CharacterFetcher;

import java.util.List;

public class CharacterDetails extends AppCompatActivity {
    private final String TAG = "CharacterDetails";
    private  Character person;
    CharacterFetcher fetcher;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_character_details);
    }

    private String getUrl() throws InvalidUrlException{
        return getIntent().getStringExtra("URL");
    }

    private void loadPerson() {
        fetcher = new CharacterFetcher();
        try {
            person = fetcher.fetchItems(getUrl());
        } catch (InvalidUrlException e) {
            Log.e(TAG, "Loading the character failed! ");
        }
    }

    private void activityDataFilling() {
        loadPerson();

        ((TextView)findViewById(R.id.tvName)).setText(person.getName());
        ((TextView)findViewById(R.id.tvGender)).setText(person.getGender());
        ((TextView)findViewById(R.id.tvCulture)).setText(person.getCulture());
        ((TextView)findViewById(R.id.tvUrl)).setText(person.getUrl());
        ((TextView)findViewById(R.id.tvMother)).setText(person.getMother());
        ((TextView)findViewById(R.id.tvFather)).setText(person.getFather());
        ((TextView)findViewById(R.id.tvSpouse)).setText(person.getSpouse());
        ((TextView)findViewById(R.id.tvBorn)).setText(person.getBirthday());
        ((TextView)findViewById(R.id.tvDied)).setText(person.getDied());
        ((TextView)findViewById(R.id.tvTitles))
                .setText(fetcher.formatedString(person.getTitles()));
        ((TextView)findViewById(R.id.tvAliases))
                .setText(fetcher.formatedString(person.getAliases()));
        ((TextView)findViewById(R.id.tvAllegiances))
                .setText(fetcher.formatedString(person.getAllegiances()));
        ((TextView)findViewById(R.id.tvBooks))
                .setText(fetcher.formatedString(person.getBooks()));
        ((TextView)findViewById(R.id.tvSeries))
                .setText(fetcher.formatedString(person.getTvSeries()));
        ((TextView)findViewById(R.id.tvPlayedBy))
                .setText(fetcher.formatedString(person.getPlayedBy()));
        ((TextView)findViewById(R.id.tvPovBooks))
                .setText(fetcher.formatedString(person.getPovBooks()));
    }

    private class InvalidUrlException extends Exception {
        public InvalidUrlException(String message) {
            super(message);
        }
    }
}