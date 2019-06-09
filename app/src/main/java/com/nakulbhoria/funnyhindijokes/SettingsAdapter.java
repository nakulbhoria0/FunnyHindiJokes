package com.nakulbhoria.funnyhindijokes;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.ArrayList;

public class SettingsAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

    private Context mContext;
    private ArrayList<ThemeImage> imgList;

    public SettingsAdapter(Context context, ArrayList<ThemeImage> list){
        mContext = context;
        imgList = list;
    }


    @NonNull
    @Override
    public PostHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(mContext).inflate(R.layout.activity_settings, viewGroup, false);
        return new PostHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {

        final ThemeImage currentImage = imgList.get(i);
        final PostHolder holder = (PostHolder) viewHolder;
        holder.img.setImageDrawable(mContext.getResources().getDrawable(currentImage.getImage()));

        holder.img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int i = currentImage.getImage();
                Intent intent = new Intent(mContext, ImageActivity.class);
                intent.putExtra("i",i );
                mContext.startActivity(intent);
                ((Activity)mContext).finish();

            }
        });

    }

    @Override
    public int getItemCount() {
        return imgList.size();
    }

    private static class PostHolder extends RecyclerView.ViewHolder {
        ImageView img;

        PostHolder(View view) {
            super(view);
            img = itemView.findViewById(R.id.cardImage);
        }
    }
}
