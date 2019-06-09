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
public class CoolWhatsappStatusFragment extends Fragment implements NativeAdsManager.Listener {

    final ArrayList<Joke> jokes = new ArrayList<>();
    private NativeAdsManager mNativeAdsManager;
    private RecyclerView listView;

    public CoolWhatsappStatusFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        String placement_id = "1869998493118528_1870003033118074";
        mNativeAdsManager = new NativeAdsManager(getActivity(), placement_id, 0);
        mNativeAdsManager.loadAds();
        mNativeAdsManager.setListener(this);

        View rootView = inflater.inflate(R.layout.joke_list, container, false);
        listView = rootView.findViewById(R.id.list);
        listView.setLayoutManager(new LinearLayoutManager(getActivity()));
        jokes.add(new Joke("1. Not all men are fools, some stay bachelor."));
        jokes.add(new Joke("2. I talk to myself because I like dealing with a better class of people."));
        jokes.add(new Joke("3. Save water drink beer."));
        jokes.add(new Joke("4. I’m not single, I’m just romantically challenged."));
        jokes.add(new Joke("5. Trust in God, But lock your car."));
        jokes.add(new Joke("6. AwesoME ends with ME and Ugly starts with You."));
        jokes.add(new Joke("7. Try to be a rainbow in someone’s cloud."));
        jokes.add(new Joke("8. It hurts when you have someone in your heart but not in your arms."));
        jokes.add(new Joke("9. You have to learn the rules of the game. And then you have to play better than anyone else."));
        jokes.add(new Joke("10. Life is like riding a bicycle to keep your balance, you must keep moving."));
        jokes.add(new Joke("11. You’re already a successful personal. The things we take for granted someone else is praying for."));
        jokes.add(new Joke("12. Dreams is not what you see in sleep, Is the thing which doesn’t let you sleep."));
        jokes.add(new Joke("13. I will win, not immediately but definitely."));
        jokes.add(new Joke("14. I love to walk in fog, because nobody knows I’m smoking."));
        jokes.add(new Joke("15. I’m not drunk, I’m just chemically off-balanced."));
        jokes.add(new Joke("16. Oh, so you wanna argue, bring it. I got my CAPS LOCK ON."));
        jokes.add(new Joke("17. I’m so poor that I can’t pay attention in class."));
        jokes.add(new Joke("18. Warning!!! I know KARATE and few other oriental jokes."));
        jokes.add(new Joke("19. Had a really great “Night Out” last night, according to my police report."));
        jokes.add(new Joke("20. The road to success is always under construction."));
        jokes.add(new Joke("21. Doubt kills more dreams than failure ever will."));
        jokes.add(new Joke("22. Born to express not to impress."));
        jokes.add(new Joke("23. Silent people have the loudest minds."));
        jokes.add(new Joke("24. When I was born. Devil said,”Oh Shit! Competition!!!”"));
        jokes.add(new Joke("25. I work for money, for loyalty hire a Dog."));
        jokes.add(new Joke("26. Some people are alive only, because it’s illegal to kill them."));
        jokes.add(new Joke("27. When nothing goes right… Go left!"));
        jokes.add(new Joke("28. If you can’t convince them, confuse them."));
        jokes.add(new Joke("29. Don’t compare yourself with anyone in this world… if you do so, you are insulting yourself…"));
        jokes.add(new Joke("30. Create your own visual style… let it be unique for yourself and yet identifiable for others."));
        jokes.add(new Joke("31. Motivation is what gets you started. Habit is what keeps you going."));
        jokes.add(new Joke("32. It is almost impossible to smile on the outside without feeling better on the inside."));
        jokes.add(new Joke("33. No matter how strong of a person you are, there’s always someone who can make you weak."));
        jokes.add(new Joke("34. Please don’t forget to smile."));
        jokes.add(new Joke("35. Get up every morning, imagine a future then make it happen."));
        jokes.add(new Joke("36. Everyone is beautiful in their own way because God makes no mistakes."));
        jokes.add(new Joke("37. You’re right. I’m NOT perfect. But I’m unique!"));
        jokes.add(new Joke("38. Always remember that you’re unique. Just like everyone else."));
        jokes.add(new Joke("39. My “last seen at” was just to check your “last seen at”."));
        jokes.add(new Joke("40. Not always “Available”.. try your Luck.."));
        jokes.add(new Joke("41. Hey there Whatsapp is using me."));
        jokes.add(new Joke("42. Life is Short – Chat Fast!"));
        jokes.add(new Joke("43. Time is precious, waste it wisely."));
        jokes.add(new Joke("44. Some people call me Mike, you can call me tonight."));
        jokes.add(new Joke("45. Sometimes you succeed and other times you learn."));
        jokes.add(new Joke("46. I always dream of being a millionaire like my uncle… He’s dreaming too."));
        jokes.add(new Joke("47. Scratch here ▒▒▒▒▒▒▒▒▒▒▒▒▒▒ to reveal my status."));
        jokes.add(new Joke("48. I Know What You’re Doing Right Now… You’re Reading On My Wall, Right !"));
        jokes.add(new Joke("49. I’ve gone out to find myself. If I should arrive before I get back, please ask me to wait."));
        jokes.add(new Joke("50. Roses are red, Facebook is blue, No mutual friends, Who the hell are you?"));


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