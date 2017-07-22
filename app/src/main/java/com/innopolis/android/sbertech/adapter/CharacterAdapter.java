package com.innopolis.android.sbertech.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.innopolis.android.sbertech.R;
import com.innopolis.android.sbertech.models.Character;
import com.innopolis.android.sbertech.tasks.CharactersFactory;

import java.util.List;

/**
 * Created by _red_ on 20.07.17.
 */

public class CharacterAdapter extends RecyclerView.Adapter<CharacterAdapter.CharacterHolder> {
    private Context context;
    private final String TAG = "CharacterAdapter";
    private final String resource = "https://anapioficeandfire.com/api/characters/";
    private List<Character> entries;

    public CharacterAdapter(Context context, List<Character> entries) {
        this.context = context;
        this.entries = entries;
    }

    @Override
    public CharacterHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.character_item, parent, false);
        return new CharacterHolder(view);
    }

    @Override
    public void onBindViewHolder(CharacterHolder holder, int position) {
        holder.bindData(entries.get(position));
        if (position > entries.size() - 10) {
            CharactersFactory charactersFactory =
                    new CharactersFactory(this.context, entries, resource);
            charactersFactory.execute();
        }
    }

    @Override
    public int getItemCount() {
        return entries.size();
    }

    class CharacterHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        private final String TAG = "ArticleHolder";

        private TextView tvName;
        private TextView tvGender;
        private TextView tvCulture;
        private TextView tvBorn;
        private TextView tvDied;

        CharacterHolder(View itemView) {
            super(itemView);

            tvName = itemView.findViewById(R.id.tvName);
            tvGender = itemView.findViewById(R.id.tvGender);
            tvCulture = itemView.findViewById(R.id.tvCulture);
            tvBorn = itemView.findViewById(R.id.tvBorn);
            tvDied = itemView.findViewById(R.id.tvDied);
            Log.d(TAG, "Create new CharacterHolder");
        }

        void bindData(Character entry) {
            tvName.setText(entry.getName());
            tvGender.setText(entry.getGender());
            tvCulture.setText(entry.getCulture());
            tvBorn.setText(entry.getBirthday());
            tvDied.setText(entry.getDied());
            Log.d(TAG, "Entry added!");
        }

        @Override
        public void onClick(View view) {
//                Intent intent = new Intent(view.getContext(), ArticleDetails.class);
//                intent.putExtra(EXTRA_TITLE, tvTitle.getText().toString());
//                intent.putExtra(EXTRA_DESCTIPTION, tvBody.getText().toString());
//                intent.putExtra(EXTRA_IMAGE_URL, url);
//                context.startActivity(intent);
        }
    }
}
