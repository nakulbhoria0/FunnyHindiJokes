package com.nakulbhoria.funnyhindijokes;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.LinearLayout;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;


public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {


    DatabaseHelper myDB;
    MyPagerAdapter myPagerAdapter;
    Toolbar toolbar;
    private DrawerLayout drawer;
    ViewPager viewPager;
    private InterstitialAd mInterstitialAd;
    SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        prepareAd();
        preferences = getSharedPreferences("prefs", MODE_PRIVATE);
        int background = preferences.getInt("value", R.drawable.background);


        mInterstitialAd.setAdListener(new AdListener() {
            @Override
            public void onAdLoaded() {
                mInterstitialAd.show();
                super.onAdLoaded();

            }

            @Override
            public void onAdFailedToLoad(int i) {
                mInterstitialAd.loadAd(new AdRequest.Builder().build());

            }
        });
        LinearLayout layout = findViewById(R.id.layout);
        final  int sdk = Build.VERSION.SDK_INT;
        if(sdk < Build.VERSION_CODES.JELLY_BEAN){
            layout.setBackgroundDrawable(ContextCompat.getDrawable(this,background));
        }else{
            layout.setBackground(ContextCompat.getDrawable(this,background));
        }


        myDB = new DatabaseHelper(this);

        toolbar = findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);

        drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();



        viewPager = findViewById(R.id.pager);
        myPagerAdapter = new MyPagerAdapter(this, getSupportFragmentManager());
        myPagerAdapter.notifyDataSetChanged();
        viewPager.setAdapter(myPagerAdapter);


        TabLayout tabLayout = findViewById(R.id.tab_layout);
        tabLayout.setupWithViewPager(viewPager);


    }

    public void prepareAd(){
        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId("ca-app-pub-2178015702183927/1772107559");
        mInterstitialAd.loadAd(new AdRequest.Builder().build());
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()){
            case R.id.best_funny:
                viewPager.setCurrentItem(0);
                break;
            case R.id.attitude:
                viewPager.setCurrentItem(1);
                break;
            case R.id.cool_status:
                viewPager.setCurrentItem(2);
                break;
            case R.id.father_son:
                viewPager.setCurrentItem(3);
                break;
            case R.id.funny_shayari:
                viewPager.setCurrentItem(4);
                break;
            case R.id.husband_wife:
                viewPager.setCurrentItem(5);
                break;
            case R.id.kanpuriya_jokes:
                viewPager.setCurrentItem(6);
                break;
            case R.id.latest_funny:
                viewPager.setCurrentItem(7);
                break;
            case R.id.pappu_jokes:
                viewPager.setCurrentItem(8);
                break;
            case R.id.positive:
                viewPager.setCurrentItem(9);
                break;
            case R.id.santa_banta:
                viewPager.setCurrentItem(10);
                break;
            case R.id.sardar_jokes:
                viewPager.setCurrentItem(11);
                break;
            case R.id.short_jokes:
                viewPager.setCurrentItem(12);
                break;
            case R.id.teacher:
                viewPager.setCurrentItem(13);
                break;
            case R.id.favorite:
                viewPager.setCurrentItem(14);
        }

        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_main, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()){
            case R.id.action_background:
                Intent backgroundIntent = new Intent(MainActivity.this, SettingsActivity.class);
                startActivity(backgroundIntent);
                break;
            case R.id.privacy:
                Intent privacyIntent = new Intent(MainActivity.this, ContactActivity.class);
                startActivity(privacyIntent);
                break;
            case R.id.contact_us:
                Intent contactIntent = new Intent(MainActivity.this, ContactActivity.class);
                startActivity(contactIntent);
                break;
            case R.id.rateApp:
                try{startActivity(new Intent(Intent.ACTION_VIEW,
                        Uri.parse("market://details?id=" + getPackageName() )));

                }catch (ActivityNotFoundException e){
                    startActivity(new Intent(Intent.ACTION_VIEW,
                            Uri.parse("https://play.google.com/store/apps/details?id=" + getPackageName())));
                }
                break;
            case R.id.shareApp:

                Intent shareIntent = new Intent(Intent.ACTION_SEND);
                String appLink;
                try{
                    appLink = "https://play.google.com/store/apps/details?id=" + getPackageName();

                }catch (ActivityNotFoundException e){
                    appLink = "https://play.google.com/store/apps/details?id=" + getPackageName();
                }
                shareIntent.setType("text/link");
                String shareBody = "Hey! i found this Amazing Jokes App on Play Store Download it now and Enjoy. \n" + appLink;
                String shareSubject = "@string/app_name";
                shareIntent.putExtra(Intent.EXTRA_SUBJECT, shareSubject);
                shareIntent.putExtra(Intent.EXTRA_TEXT, shareBody);
                startActivity(Intent.createChooser(shareIntent, "Share Using"));
                break;

            case R.id.exit:
                finishAffinity();
                break;

            case R.id.about_us:
                Intent aboutIntent = new Intent(MainActivity.this, ContactActivity.class);
                startActivity(aboutIntent);
                break;

        }


        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            finishAffinity();
        }
    }
}

