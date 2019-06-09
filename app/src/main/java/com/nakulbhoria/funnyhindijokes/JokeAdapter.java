package com.nakulbhoria.funnyhindijokes;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class JokeAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    SharedPreferences preferences;
    ArrayList<Joke> list;
    private Context context;
    DatabaseHelper myDB;

    public JokeAdapter(Context context, ArrayList<Joke> list) {
        this.list = list;
        this.context = context;
        myDB = new DatabaseHelper(context);
        preferences = context.getSharedPreferences("prefs", Context.MODE_PRIVATE);

    }


    @Override
    public void onViewDetachedFromWindow(@NonNull RecyclerView.ViewHolder holder) {
        super.onViewDetachedFromWindow(holder);
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View inflatedView = LayoutInflater.from(parent.getContext()).inflate(R.layout
                .list_item, parent, false);
        return new PostHolder(inflatedView);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        final PostHolder postHolder = (PostHolder) holder;

        final Joke postItem = list.get(position);

        int background = preferences.getInt("value",R.drawable.background );


        final  int sdk = Build.VERSION.SDK_INT;
        if(sdk < Build.VERSION_CODES.JELLY_BEAN){
            postHolder.layout.setBackgroundDrawable(ContextCompat.getDrawable(context,background));
        }else{
            postHolder.layout.setBackground(ContextCompat.getDrawable(context, background));
        }
        postHolder.imgShare.setImageResource(R.drawable.ic_share_black_24dp);
        postHolder.imgLike.setImageResource(R.drawable.favorite);
        postHolder.imgCopy.setImageResource(R.drawable.ic_content_copy_black_24dp);
        postHolder.defaultTextView.setText(postItem.getDefaultJoke());

        postHolder.imgLike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context context = v.getContext();
                String likeJoke = postItem.getDefaultJoke().substring(3);


                Cursor crsr = null;
                try{
                    crsr = myDB.getJoke(likeJoke);
                }catch (Exception e){
                    crsr = null;
                }
                if (crsr.getCount() < 1 || crsr ==null) {
                    myDB.add(likeJoke);
                    Toast.makeText(context, "Like", Toast.LENGTH_SHORT).show();
                } else {

                    myDB.delete(likeJoke);
                    Toast.makeText(context, "Unlike", Toast.LENGTH_SHORT).show();
                }

            }
        });

        postHolder.imgCopy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Gets a handle to the clipboard service.

                Context context = v.getContext();

                final ClipboardManager clipboardManager = (ClipboardManager) context
                        .getSystemService(Context.CLIPBOARD_SERVICE);
                final ClipData clipData = ClipData
                        .newPlainText("Copy", postItem.getDefaultJoke().substring(3));
                clipboardManager.setPrimaryClip(clipData);
                Toast.makeText(context, "Copied to clipboard", Toast.LENGTH_SHORT).show();
            }
        });

        postHolder.imgShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context context = v.getContext();

                //Implement a Sharing Intent
                Intent sharingIntent = new Intent(Intent.ACTION_SEND);

                //set the sharing type
                sharingIntent.setType("text/plain");

                //set the Share Body
                String shareBody = postItem.getDefaultJoke().substring(3);

                //Pass your sharing content
                sharingIntent.putExtra(Intent.EXTRA_SUBJECT, "Share with Friends");
                sharingIntent.putExtra(Intent.EXTRA_TEXT, shareBody);

                // Create a chooser
                context.startActivity(Intent.createChooser(sharingIntent, "Share via"));
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    private static class PostHolder extends RecyclerView.ViewHolder {
        LinearLayout layout;
        ImageView imgShare;
        ImageView imgCopy;
        ImageView imgLike;
        TextView defaultTextView;

        PostHolder(View view) {
            super(view);

            layout = itemView.findViewById(R.id.list_Layout);
            imgLike = itemView.findViewById(R.id.image_like);
            imgShare = itemView.findViewById(R.id.image_share);
            imgCopy = itemView.findViewById(R.id.image_copy);
            defaultTextView = itemView.findViewById(R.id.default_text_view);
            defaultTextView.setSelected(true);
        }
    }
}