package com.nakulbhoria.funnyhindijokes;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class SettingsActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    ArrayList<ThemeImage> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.joke_list);

        recyclerView = findViewById(R.id.list);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        list = new ArrayList<>();

        list.add(new ThemeImage(R.drawable.background));
        list.add(new ThemeImage(R.drawable.background1));
        list.add(new ThemeImage(R.drawable.background2));
        list.add(new ThemeImage(R.drawable.background3));
        list.add(new ThemeImage(R.drawable.background4));
        list.add(new ThemeImage(R.drawable.background5));
        list.add(new ThemeImage(R.drawable.background6));
        list.add(new ThemeImage(R.drawable.background7));
        list.add(new ThemeImage(R.drawable.background8));
        list.add(new ThemeImage(R.drawable.background9));
        list.add(new ThemeImage(R.drawable.background10));
        list.add(new ThemeImage(R.drawable.background11));
        list.add(new ThemeImage(R.drawable.background12));
        list.add(new ThemeImage(R.drawable.background13));
        list.add(new ThemeImage(R.drawable.background14));
        list.add(new ThemeImage(R.drawable.background15));
        list.add(new ThemeImage(R.drawable.background16));
        list.add(new ThemeImage(R.drawable.background17));
        list.add(new ThemeImage(R.drawable.background18));
        list.add(new ThemeImage(R.drawable.background19));
        list.add(new ThemeImage(R.drawable.background20));

        DividerItemDecoration itemDecoration =
                new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        recyclerView.addItemDecoration(itemDecoration);

        SettingsAdapter adapter = new SettingsAdapter(this, list);

        recyclerView.setAdapter(adapter);

    }
}
