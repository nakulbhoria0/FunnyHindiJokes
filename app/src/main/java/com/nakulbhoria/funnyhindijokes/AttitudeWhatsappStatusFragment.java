package com.nakulbhoria.funnyhindijokes;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.facebook.ads.AdError;
import com.facebook.ads.NativeAdsManager;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class AttitudeWhatsappStatusFragment extends Fragment implements NativeAdsManager.Listener {


    final ArrayList<Joke> jokes = new ArrayList<>();
    private NativeAdsManager mNativeAdsManager;
    private RecyclerView listView;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        String placement_id = "1869998493118528_1870003033118074";
        mNativeAdsManager = new NativeAdsManager(getActivity(), placement_id, 0);
        mNativeAdsManager.loadAds();
        mNativeAdsManager.setListener(this);

        View rootView = inflater.inflate(R.layout.joke_list,container, false );

        listView = rootView.findViewById(R.id.list);
        listView.setLayoutManager(new LinearLayoutManager(getActivity()));

        jokes.add(new Joke(getString(R.string.attitude_1)));
        jokes.add(new Joke(getString(R.string.attitude_2)));
        jokes.add(new Joke(getString(R.string.attitude_3)));
        jokes.add(new Joke(getString(R.string.attitude_4)));
        jokes.add(new Joke(getString(R.string.attitude_5)));
        jokes.add(new Joke(getString(R.string.attitude_6)));
        jokes.add(new Joke(getString(R.string.attitude_7)));
        jokes.add(new Joke(getString(R.string.attitude_8)));
        jokes.add(new Joke(getString(R.string.attitude_9)));
        jokes.add(new Joke(getString(R.string.attitude_10)));
        jokes.add(new Joke(getString(R.string.attitude_11)));
        jokes.add(new Joke(getString(R.string.attitude_12)));
        jokes.add(new Joke(getString(R.string.attitude_13)));
        jokes.add(new Joke(getString(R.string.attitude_14)));
        jokes.add(new Joke(getString(R.string.attitude_15)));
        jokes.add(new Joke(getString(R.string.attitude_16)));
        jokes.add(new Joke(getString(R.string.attitude_17)));
        jokes.add(new Joke(getString(R.string.attitude_18)));
        jokes.add(new Joke(getString(R.string.attitude_19)));
        jokes.add(new Joke(getString(R.string.attitude_20)));
        jokes.add(new Joke(getString(R.string.attitude_21)));
        jokes.add(new Joke(getString(R.string.attitude_22)));
        jokes.add(new Joke(getString(R.string.attitude_23)));
        jokes.add(new Joke(getString(R.string.attitude_24)));
        jokes.add(new Joke(getString(R.string.attitude_25)));
        jokes.add(new Joke(getString(R.string.attitude_26)));
        jokes.add(new Joke(getString(R.string.attitude_27)));
        jokes.add(new Joke(getString(R.string.attitude_28)));
        jokes.add(new Joke(getString(R.string.attitude_29)));
        jokes.add(new Joke(getString(R.string.attitude_30)));
        jokes.add(new Joke(getString(R.string.attitude_31)));
        jokes.add(new Joke(getString(R.string.attitude_32)));
        jokes.add(new Joke(getString(R.string.attitude_33)));
        jokes.add(new Joke(getString(R.string.attitude_34)));
        jokes.add(new Joke(getString(R.string.attitude_35)));
        jokes.add(new Joke(getString(R.string.attitude_36)));
        jokes.add(new Joke(getString(R.string.attitude_37)));
        jokes.add(new Joke(getString(R.string.attitude_38)));
        jokes.add(new Joke(getString(R.string.attitude_39)));
        jokes.add(new Joke(getString(R.string.attitude_40)));
        jokes.add(new Joke(getString(R.string.attitude_41)));
        jokes.add(new Joke(getString(R.string.attitude_42)));
        jokes.add(new Joke(getString(R.string.attitude_43)));
        jokes.add(new Joke(getString(R.string.attitude_44)));
        jokes.add(new Joke(getString(R.string.attitude_45)));
        jokes.add(new Joke(getString(R.string.attitude_46)));
        jokes.add(new Joke(getString(R.string.attitude_47)));
        jokes.add(new Joke(getString(R.string.attitude_48)));
        jokes.add(new Joke(getString(R.string.attitude_49)));
        jokes.add(new Joke(getString(R.string.attitude_50)));




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
