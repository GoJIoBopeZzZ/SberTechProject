package com.innopolis.android.sbertech.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.innopolis.android.sbertech.R;
import com.innopolis.android.sbertech.models.Character;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
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

        final String TAG = "ArticleHolder";
        final String EXTRA_ARTICLE_TITLE = "TITLE";
        final String EXTRA_ARTICLE_DESCTIPTION = "DESCRIPTION";
        final String EXTRA_ARTICLE_IMAGE_URL = "URL";

        TextView tvName;
        TextView tvGender;
        TextView tvBorn;
        TextView ivDied;

        String link;
        String url;

        CharacterHolder(View itemView) {
            super(itemView);

            tvName = itemView.findViewById(R.id.tvName);
            tvGender = itemView.findViewById(R.id.body_article);
            tvBorn = itemView.findViewById(R.id.image_article);
            itemView.setOnClickListener(this);
            tvDate = itemView.findViewById(R.id.date_article);
        }

        void bindData(Character entry) {
//            DrawableLoader loader = new DrawableLoader(context, entries);
//            loader.execute();

//            tvTitle.setText(entry.getTitle());
//            tvBody.setText(entry.getBody());
//            tvDate.setText(entry.getDate());
//            ivImage.setImageDrawable(entry.getImage());
//            this.url = entry.getImageRes();
//            link = entry.getLink();

        }

        private Drawable LoadImage(String URL) {
            Drawable drawable = null;
            InputStream is = null;
            try {
                is = (InputStream) new URL(URL).getContent();
                drawable = Drawable.createFromStream(is, "src");
            } catch (IOException e) {
                e.printStackTrace();
            }
            return drawable;
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
