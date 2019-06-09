package com.nakulbhoria.funnyhindijokes;

import android.app.Activity;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.os.Build;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.facebook.ads.AdChoicesView;
import com.facebook.ads.AdIconView;
import com.facebook.ads.MediaView;
import com.facebook.ads.NativeAd;
import com.facebook.ads.NativeAdsManager;

import java.util.ArrayList;
import java.util.List;

public class NativeAdRecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static final int AD_DISPLAY_FREQUENCY = 5;
    private static final int POST_TYPE = 0;
    private static final int AD_TYPE = 1;
    private DatabaseHelper myDB;
    private List<Joke> mPostItems;
    private List<NativeAd> mAdItems;
    private NativeAdsManager mNativeAdsManager;
    private Activity mActivity;
    SharedPreferences preferences;

    public NativeAdRecyclerAdapter(Activity activity,
                                   List<Joke> postItems, NativeAdsManager
                                           nativeAdsManager) {
        mNativeAdsManager = nativeAdsManager;
        mPostItems = postItems;
        mAdItems = new ArrayList<>();
        mActivity = activity;
        myDB = new DatabaseHelper(activity);
        preferences = activity.getSharedPreferences("prefs",Context.MODE_PRIVATE );
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == AD_TYPE) {
            View inflatedView = LayoutInflater.from(parent.getContext()).inflate(R.layout
                    .native_ad_unit, parent, false);
            return new AdHolder(inflatedView);
        } else {
            View inflatedView = LayoutInflater.from(parent.getContext()).inflate(R.layout
                    .list_item, parent, false);
            return new PostHolder(inflatedView);
        }
    }

    @Override
    public int getItemViewType(int position) {
        return position % AD_DISPLAY_FREQUENCY == 0 ? AD_TYPE : POST_TYPE;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder.getItemViewType() == AD_TYPE) {
            NativeAd ad;

            if (mAdItems.size() > position / AD_DISPLAY_FREQUENCY) {
                ad = mAdItems.get(position / AD_DISPLAY_FREQUENCY);
            } else {
                ad = mNativeAdsManager.nextNativeAd();
                mAdItems.add(ad);
            }

            AdHolder adHolder = (AdHolder) holder;
            adHolder.adChoicesContainer.removeAllViews();

            if (ad != null) {

                adHolder.tvAdTitle.setText(ad.getAdvertiserName());
                adHolder.tvAdBody.setText(ad.getAdBodyText());
                adHolder.tvAdSocialContext.setText(ad.getAdSocialContext());
                adHolder.tvAdSponsoredLabel.setText(ad.getSponsoredTranslation());
                adHolder.btnAdCallToAction.setText(ad.getAdCallToAction());
                adHolder.btnAdCallToAction.setVisibility(
                        ad.hasCallToAction() ? View.VISIBLE : View.INVISIBLE);
                AdChoicesView adChoicesView = new AdChoicesView(mActivity,
                        ad, true);
                adHolder.adChoicesContainer.addView(adChoicesView, 0);

                List<View> clickableViews = new ArrayList<>();
                clickableViews.add(adHolder.ivAdIcon);
                clickableViews.add(adHolder.mvAdMedia);
                clickableViews.add(adHolder.btnAdCallToAction);
                ad.registerViewForInteraction(
                        adHolder.itemView,
                        adHolder.mvAdMedia,
                        adHolder.ivAdIcon,
                        clickableViews);
            }
        } else {
            final PostHolder postHolder = (PostHolder) holder;

            //Calculate where the next postItem index is by subtracting ads we've shown.
            int index = position - (position / AD_DISPLAY_FREQUENCY) - 1;

            final Joke postItem = mPostItems.get(index);
            int background = preferences.getInt("value",  R.drawable.background);

            final  int sdk = Build.VERSION.SDK_INT;
            if(sdk < Build.VERSION_CODES.JELLY_BEAN){
                postHolder.layout.setBackgroundDrawable(ContextCompat.getDrawable(mActivity, background ));
            }else{
                postHolder.layout.setBackground(ContextCompat.getDrawable(mActivity, background));
            }

            postHolder.defaultTextView.setText(postItem.getDefaultJoke());
            postHolder.imgShare.setImageResource(R.drawable.ic_share_black_24dp);
            postHolder.imgLike.setImageResource(R.drawable.favorite);
            postHolder.imgCopy.setImageResource(R.drawable.ic_content_copy_black_24dp);


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


                    Cursor data = myDB.getAllJokes();
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
                    String shareBody = "https://play.google.com/store/apps/details?id=com.nakulbhoria.funnyhindijokes\n" + postItem.getDefaultJoke().substring(3);

                    //Pass your sharing content
                    sharingIntent.putExtra(Intent.EXTRA_SUBJECT, "Share with Friends");
                    sharingIntent.putExtra(Intent.EXTRA_TEXT, shareBody);

                    // Create a chooser
                    context.startActivity(Intent.createChooser(sharingIntent, "Share via"));
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return mPostItems.size() + mAdItems.size();
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

    private static class AdHolder extends RecyclerView.ViewHolder {
        MediaView mvAdMedia;
        AdIconView ivAdIcon;
        TextView tvAdTitle;
        TextView tvAdBody;
        TextView tvAdSocialContext;
        TextView tvAdSponsoredLabel;
        Button btnAdCallToAction;
        LinearLayout adChoicesContainer;

        AdHolder(View view) {
            super(view);

            mvAdMedia = (MediaView) view.findViewById(R.id.native_ad_media);
            tvAdTitle = (TextView) view.findViewById(R.id.native_ad_title);
            tvAdBody = (TextView) view.findViewById(R.id.native_ad_body);
            tvAdSocialContext = (TextView) view.findViewById(R.id.native_ad_social_context);
            tvAdSponsoredLabel = (TextView) view.findViewById(R.id.native_ad_sponsored_label);
            btnAdCallToAction = (Button) view.findViewById(R.id.native_ad_call_to_action);
            ivAdIcon = (AdIconView) view.findViewById(R.id.native_ad_icon);
            adChoicesContainer = (LinearLayout) view.findViewById(R.id.ad_choices_container);

        }
    }
}
