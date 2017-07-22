package com.innopolis.android.sbertech.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.innopolis.android.sbertech.CharacterDetails;
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
            new CharactersFactory(context, entries, resource).execute();
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
        private ImageView ivPhoto;

        CharacterHolder(View itemView) {
            super(itemView);

            tvName = itemView.findViewById(R.id.tvName);
            tvGender = itemView.findViewById(R.id.tvGender);
            tvCulture = itemView.findViewById(R.id.tvCulture);
            tvBorn = itemView.findViewById(R.id.tvBorn);
            tvDied = itemView.findViewById(R.id.tvDied);
            ivPhoto = itemView.findViewById(R.id.ivPhoto);
            ivPhoto.setOnClickListener(this);
            Log.d(TAG, "Created new CharacterHolder");
        }

        void bindData(Character entry) {
            tvName.setText(entry.getName());
            tvGender.setText(entry.getGender());
            tvCulture.setText(entry.getCulture());
            tvBorn.setText(entry.getBirthday());
            tvDied.setText(entry.getDied());
            Log.d(TAG, "Entry added!" + entry.getUrl());
        }

        @Override
        public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), CharacterDetails.class);
//                intent.putExtra(EXTRA_TITLE, tvTitle.getText().toString());
//                intent.putExtra(EXTRA_DESCTIPTION, tvBody.getText().toString());
//                intent.putExtra(EXTRA_IMAGE_URL, url);
                context.startActivity(intent);
        }
    }
}
