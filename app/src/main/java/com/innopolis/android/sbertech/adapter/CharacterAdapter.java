package com.innopolis.android.sbertech.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.innopolis.android.sbertech.R;
import com.innopolis.android.sbertech.models.Character;
import com.innopolis.android.sbertech.models.CharacterFetcher;

import java.util.List;

/**
 * Created by _red_ on 20.07.17.
 */

public class CharacterAdapter extends RecyclerView.Adapter<CharacterAdapter.CharacterHolder> {
    private Context context;
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
    }

    @Override
    public int getItemCount() {
        return entries.size();
    }

    public void updateEntries(List<Character> entries) {
        this.entries = entries;
        notifyDataSetChanged();
    }

    class CharacterHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        private final String TAG = "ArticleHolder";

        private TextView tvTitle;
        private TextView tvName;
        private TextView tvGender;
        private TextView tvCulture;
        private TextView tvBorn;
        private TextView tvDied;

        CharacterHolder(View itemView) {
            super(itemView);

            tvTitle = itemView.findViewById(R.id.tvTitle);
            tvName = itemView.findViewById(R.id.tvName);
            tvGender = itemView.findViewById(R.id.tvGender);
            tvCulture = itemView.findViewById(R.id.tvCulture);
            tvBorn = itemView.findViewById(R.id.tvBorn);
            tvDied = itemView.findViewById(R.id.tvDied);
        }

        void bindData(Character entry) {
            tvTitle.setText(tvName.getText() + "entry.getTitle());
            tvName.setText(entry.getName());
            tvGender.setText(entry.getGender());
            tvCulture.setText(entry.getCulture());
            tvBorn.setText(entry.getBirthday());
            tvDied.setText(entry.getDied());

        }

        @Override
        public void onClick(View view) {
//                Intent intent = new Intent(view.getContext(), ArticleDetails.class);
//                intent.putExtra(EXTRA_ARTICLE_TITLE, tvTitle.getText().toString());
//                intent.putExtra(EXTRA_ARTICLE_DESCTIPTION, tvBody.getText().toString());
//                intent.putExtra(EXTRA_ARTICLE_IMAGE_URL, url);
//                context.startActivity(intent);
        }
    }
}
