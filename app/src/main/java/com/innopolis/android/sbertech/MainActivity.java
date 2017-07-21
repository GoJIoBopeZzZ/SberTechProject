package com.innopolis.android.sbertech;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.innopolis.android.sbertech.models.Character;
import com.innopolis.android.sbertech.models.FlickrFetcher;

import java.net.MalformedURLException;
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

        new FetchItemTask().execute();

        setAdapter();
    }

    private class PhotoHolder extends RecyclerView.ViewHolder {
        private ImageView itemImageView;
        private TextView tvName;
        private TextView tvBorn;
        private TextView tvMother;
        private TextView tvFather;

        public PhotoHolder(View itemView) {
            super(itemView);
            tvName = (TextView) itemView.findViewById(R.id.tvName);
            tvBorn = (TextView) itemView.findViewById(R.id.tvBorn);
        }
    }

    private class CharacterAdapter extends RecyclerView.Adapter<PhotoHolder> {
        private List<Character> mCharacterItems;

        public CharacterAdapter(List<Character> mCharacterItems) {
            this.mCharacterItems = mCharacterItems;
        }

        @Override
        public PhotoHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater inflater = LayoutInflater.from(MainActivity.this);
            View view = inflater.inflate(R.layout.character_item, parent, false);
            return new PhotoHolder(view);
        }

        @Override
        public void onBindViewHolder(PhotoHolder holder, int position) {
            Character characterItem = mCharacterItems.get(position);
            holder.tvName.setText(holder.tvName.getText() + characterItem.getName());
        }

        @Override
        public int getItemCount() {
            return mCharacterItems.size();
        }
    }

    private class FetchItemTask extends AsyncTask<Void, Void, List<Character>> {
        @Override
        protected List<Character> doInBackground(Void... voids) {
            URL url = null;
            try {
                url = new URL("https://anapioficeandfire.com/api/characters/1");
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
            return new FlickrFetcher().fetchItems(url);
        }

        @Override
        protected void onPostExecute(List<Character> galeryItems) {
            items = galeryItems;
            setAdapter();
        }

    }

    private void setAdapter() {
        recyclerView.setAdapter(new CharacterAdapter(items));
    }
}
