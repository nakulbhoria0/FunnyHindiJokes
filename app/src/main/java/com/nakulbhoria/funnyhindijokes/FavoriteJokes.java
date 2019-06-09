package com.nakulbhoria.funnyhindijokes;


import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.facebook.ads.AdError;
import com.facebook.ads.NativeAdsManager;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class FavoriteJokes extends Fragment implements NativeAdsManager.Listener {


    final ArrayList<Joke> jokes = new ArrayList<>();
    private NativeAdsManager mNativeAdsManager;
    private RecyclerView listView;
    private TextView emptyView;
    DatabaseHelper myDB;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        myDB = new DatabaseHelper(getActivity());

        String placement_id = "1869998493118528_1870003033118074";
        mNativeAdsManager = new NativeAdsManager(getActivity(), placement_id, 0);
        mNativeAdsManager.loadAds();
        mNativeAdsManager.setListener(this);

        View rootView = inflater.inflate(R.layout.joke_list,container, false );

        listView = rootView.findViewById(R.id.list);
        emptyView = rootView.findViewById(R.id.empty_view);
        listView.setLayoutManager(new LinearLayoutManager(getActivity()));


        Cursor data = myDB.getAllJokes();
        int i = 1;
        if (data.getCount() == 0){
            listView.setVisibility(View.GONE);
            emptyView.setVisibility(View.VISIBLE);
        }else{
            while (data.moveToNext()){
                jokes.add(new Joke(  i + ". " + data.getString(01)));
                i++;
            }
            listView.setVisibility(View.VISIBLE);
            emptyView.setVisibility(View.GONE);
        }

        DividerItemDecoration itemDecoration =
                new DividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL);
        listView.addItemDecoration(itemDecoration);
        JokeAdapter adapter = new JokeAdapter(getActivity(), jokes);

        listView.setAdapter(adapter);

        return rootView;
    }
    @Override
    public void onAdsLoaded() {
        if (getActivity() == null) {
            return;
        }

        listView.setLayoutManager(new LinearLayoutManager(getActivity()));
        DividerItemDecoration itemDecoration =
                new DividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL);
        listView.addItemDecoration(itemDecoration);
        NativeAdRecyclerAdapter adapter =
                new NativeAdRecyclerAdapter(getActivity(), jokes, mNativeAdsManager);
        listView.setAdapter(adapter);
    }

    @Override
    public void onAdError(AdError error) {}


}