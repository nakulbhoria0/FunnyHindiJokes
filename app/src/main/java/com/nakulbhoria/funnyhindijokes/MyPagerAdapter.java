package com.nakulbhoria.funnyhindijokes;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

class MyPagerAdapter extends FragmentStatePagerAdapter {
    private Context mContext;

    public MyPagerAdapter(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
    }

    @Override
    public Fragment getItem(int position) {

        switch (position){
            case 0:
                return new BestFunnyJokesFragment();
            case 1:
                return new AttitudeWhatsappStatusFragment();
            case 2:
                return new CoolWhatsappStatusFragment();
            case 3:
                return new FatherSonJokesFragment();
            case 4:
                return new FunnyShayariFragment();
            case 5:
                return new HusbandWifeJokesFragment();
            case 6:
                return new KanpuriyaJokesFragment();
            case 7:
                return new LatestFunnyJokesFragment();
            case 8:
                return new PappuJokesFragment();
            case 9:
                return new PositiveQuotesFragment();
            case 10:
                return new SantaBantaJokesFragment();
            case 11:
                return new SardarJokesFragment();
            case 12:
                return new ShortJokesFragment();
            case 13:
                return new TeacherStudentJokesFragment();
            case 14:
                return new FavoriteJokes();
        }
        return null;
    }

    @Override
    public int getCount() {
        return 15;
    }

    @Override
    public CharSequence getPageTitle(int position) {

        switch (position){
            case 0:
                return mContext.getString(R.string.best_funny);
            case 1:
                return mContext.getString(R.string.attitude_status);
            case 2:
                return mContext.getString(R.string.cool_status);
            case 3:
                return mContext.getString(R.string.father_son);
            case 4:
                return mContext.getString(R.string.funny_shayari);
            case 5:
                return mContext.getString(R.string.husband_wife);
            case 6:
                return mContext.getString(R.string.kanpuriya);
            case 7:
                return mContext.getString(R.string.latest_funny);
            case 8:
                return mContext.getString(R.string.pappu);
            case 9:
                return mContext.getString(R.string.positive_quotes);
            case 10:
                return mContext.getString(R.string.santa_banta);
            case 11:
                return mContext.getString(R.string.sardar);
            case 12:
                return mContext.getString(R.string.short_jokes);
            case 13:
                return mContext.getString(R.string.teacher_student);
            case 14:
                return mContext.getString(R.string.favorite_jokes);
        }

        return null;
    }

    @Override
    public int getItemPosition(@NonNull Object object) {
        return POSITION_NONE;
    }
}
