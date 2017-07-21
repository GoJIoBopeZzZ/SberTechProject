package com.innopolis.android.sbertech;

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
import com.innopolis.android.sbertech.models.CharactersLoader;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity
        implements LoaderManager.LoaderCallbacks<List<Character>> {

    private final String TAG = "MainActivity";
    private List<Character> items = new ArrayList<>();
    private RecyclerView recyclerView;
    CharacterAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        getSupportLoaderManager().initLoader(0, null, this);
    }

    @Override
    public Loader<List<Character>> onCreateLoader(int id, Bundle args) {
        return new CharactersLoader(this);
    }

    @Override
    public void onLoadFinished(Loader<List<Character>> loader, List<Character> data) {
        adapter = new CharacterAdapter(this, data);
        ((RecyclerView) findViewById(R.id.recyclerView))
                .setAdapter(adapter);
    }

    @Override
    public void onLoaderReset(Loader<List<Character>> loader) {

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

//    private class CharacterAdapter extends RecyclerView.Adapter<PhotoHolder> {
//        private List<Character> mCharacterItems;
//
//        public CharacterAdapter(List<Character> mCharacterItems) {
//            this.mCharacterItems = mCharacterItems;
//        }
//
//        @Override
//        public PhotoHolder onCreateViewHolder(ViewGroup parent, int viewType) {
//            LayoutInflater inflater = LayoutInflater.from(MainActivity.this);
//            View view = inflater.inflate(R.layout.character_item, parent, false);
//            return new PhotoHolder(view);
//        }
//
//        @Override
//        public void onBindViewHolder(PhotoHolder holder, int position) {
//            Character characterItem = mCharacterItems.get(position);
//            holder.tvName.setText(holder.tvName.getText() + characterItem.getName());
//        }
//
//        @Override
//        public int getItemCount() {
//            return mCharacterItems.size();
//        }
//    }
//
//    private class FetchItemTask extends AsyncTask<Void, Void, List<Character>> {
//        @Override
//        protected List<Character> doInBackground(Void... voids) {
//            URL url = null;
//            try {
//                url = new URL("https://anapioficeandfire.com/api/characters/583");
//            } catch (MalformedURLException e) {
//                e.printStackTrace();
//            }
//            return new CharacterFetcher().fetchItems(url);
//        }
//
//        @Override
//        protected void onPostExecute(List<Character> galeryItems) {
//            items = galeryItems;
//            setAdapter();
//        }
//
//    }
//
//    private void setAdapter() {
//        recyclerView.setAdapter(new CharacterAdapter(items));
//    }
}
