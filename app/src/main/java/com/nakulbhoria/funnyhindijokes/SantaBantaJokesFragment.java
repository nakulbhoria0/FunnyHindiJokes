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
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class SantaBantaJokesFragment extends Fragment implements NativeAdsManager.Listener {


    final ArrayList<Joke> jokes = new ArrayList<>();
    private NativeAdsManager mNativeAdsManager;
    private RecyclerView listView;
    private InterstitialAd mInterstitialAd;

    public SantaBantaJokesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        String placement_id = "1869998493118528_1870003033118074";
        mNativeAdsManager = new NativeAdsManager(getActivity(), placement_id, 0);
        mNativeAdsManager.loadAds();
        mNativeAdsManager.setListener(this);

        prepareAd();


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

        View rootView = inflater.inflate(R.layout.joke_list, container, false );

        listView = rootView.findViewById(R.id.list);
        listView.setLayoutManager(new LinearLayoutManager(getActivity()));
        jokes.add(new Joke("1. संता और बंता दोनों भाई एक ही क्लास में पढ़ते थे।\n" +
                "\n" +
                "अध्यापिका: तुम दोनों ने अपने पापा का नाम अलग-अलग क्यों लिखा?\n" +
                "\n" +
                "संता: मैडम फिर आप कहोगे नक़ल मारी है, इसीलिए।"));
        jokes.add(new Joke("2. बैंक मैनेजर:\n" +
                "कैश खत्म हो गया है कल आना\n" +
                "\n" +
                "संता:\n" +
                "लेकिन मुझे मेरे पैसे अभी चाहिये\n" +
                "\n" +
                "मैनेजर:\n" +
                "देखिये आप गुस्सा मत करिये,\n" +
                "शांति से बात कीजिये..\n" +
                "\n" +
                "संता:\n" +
                "ठीक है बुलाओ शांति को,\n" +
                "आज उसी से बात करूँगा !"));
        jokes.add(new Joke("3. पल्स पोलिओ टीम घर आयी…\n" +
                "संता (बीबी से): बंदूक और कारतुस कहाँ हैं…??\n" +
                "\n" +
                "टीम भागी,\n" +
                "पीछे से संता ने आवाज दी,\n" +
                "\n" +
                "रुको\n" +
                "ओये रुको\n" +
                "ये हमारे बच्चो के नाम हैं.!! "));
        jokes.add(new Joke("4. संता ( पेट्रॉल पंप पर ) : अरे भाई , जरा एक रुपए का पेट्रॉल डाल दो।\n" +
                "\n" +
                "सेल्समैन : भाई , इतना पेट्रॉल डलवाकर जाना कहां है ?\n" +
                "\n" +
                "संता : अरे यार, कहीं नहीं जाना हम तो ऐसे ही पैसे उड़ाते रहते हैं..!!"));
        jokes.add(new Joke("5. संता – जो मेरी इच्छा पूरी करेगा उसको 1 लाख रूपये दूंगा ।\n" +
                "\n" +
                "बंता – बोल क्या इच्छा है तेरी ?\n" +
                "\n" +
                "संता – मुझे 2 लाख रुपये चाहिए ।"));
        jokes.add(new Joke("6. संता (एयर होस्टेस से): आपकी शक्ल मेरी बीवी से मिलती है..\n" +
                "\n" +
                "एयर होस्टेस ने ज़ोरदार थप्पड़ संता के मुँह पर मारा..\n" +
                "\n" +
                "संता: कमाल है, आदत भी वही है!!"));
        jokes.add(new Joke("7. संता, डॉक्टर से:\n" +
                "जब मैं सोता हूँ तो सपने में बन्दर फुटबॉल खेलते हैं ।\n" +
                "\n" +
                "डॉक्टर:\n" +
                "कोई दिक्कत नहीं, ये गोली रात को सोने से पहले खा लेना ।\n" +
                "\n" +
                "संता:\n" +
                "कल से खाऊंगा, आज तो फाइनल हैं!!!"));
        jokes.add(new Joke("8. अध्यापक:\n" +
                "वाक्य को अंग्रेजी में ट्रांसलेट करो\n" +
                "‘वसंत ने मुझे मुक्का मारा’\n" +
                "\n" +
                "संता:\n" +
                "‘वसन्तपंचमी’..!”"));
        jokes.add(new Joke("9. संता एक माइक्रोसॉफ्ट कंपनी में interview देने गया,\n" +
                "\n" +
                "इंटरव्यूकर्ताः Java के चार version बताइये,\n" +
                "\n" +
                "संताः मर जावा, मिट जावा, लुट जावा, और सद्दके जावा ।\n" +
                "\n" +
                "इंटरव्यूकर्ताः शबाश, अब सीधा घर जावा ।"));
        jokes.add(new Joke("10. खतरनाक जोक\n" +
                "\n" +
                "पत्नी को एक थप्पड मारने की सजा १००० रुपये जज साहब ने सुनाई..\n" +
                "\n" +
                "तब संता ने जज को पुछा :-\n" +
                "“दुसरा एक थप्पड मार दु..??\n" +
                "\n" +
                "जज गुस्से से :- क्यो..??\n" +
                "\n" +
                "संता :- क्योंकि छुट्टा नहीं है मेरे पास २००० रुपये का नोट है।"));
        jokes.add(new Joke("11. यात्री ट्रेन से उतरा, उसने संता से पूछा –\n" +
                "“यह कौन-सा स्टेशन है ?”\n" +
                "\n" +
                "संता हंसा, और जोर से हंसा,\n" +
                "जोर-जोर से हंसा, हस्ते-हस्ते लोट पोट हो गया…\n" +
                "\n" +
                "और बड़ी मुश्किल से अपने आपको संभालते हुए बोला –\n" +
                "“पगले, ये रेलवे स्टेशन है…!”"));
        jokes.add(new Joke("12. दीवार पर लिखा था “यहां कुत्ते\n" +
                "सुसु करते हैं!”\n" +
                "\n" +
                "संता ने वहां सुसु किया और फिर हंस कर बोला:\n" +
                "‘इसे कहते हैं दिमाग.. सुसु मैंने किया और नाम कुत्ते का आएगा.’"));
        jokes.add(new Joke("13. संता के घर उसका विदेशी दोस्त आया\n" +
                "और\n" +
                "दरवाजे पर नीबू मिर्ची लटके देख चकराया और पूछा:\n" +
                "ये क्या है?\n" +
                "\n" +
                "संता:\n" +
                "ये एंटी वायरस है। मेड इन इंडिया !!"));
        jokes.add(new Joke("14. टीचर: अगर अपना कैरेक्टर सुधारना चाहते हो\n" +
                "तो अपनी टीचर को मां समझो….\n" +
                "\n" +
                "संता: मैडम इससे तो हमारे पापा का कैरेक्टर खराब होगा….!!"));
        jokes.add(new Joke("15. संता :-\n" +
                "आज फिर मुझे आलिया भट्ट को किस करने को दिल कर रहा है ।\n" +
                "\n" +
                "बंता:-\n" +
                "क्या ??????\n" +
                "तुम आलिया को पहले किस कर चुके हो?\n" +
                "\n" +
                "संता:- नहीं, एक बार पहले भी दिल किया था !"));
        jokes.add(new Joke("16. संता: आज इतनी ठंड क्यों है?\n" +
                "बंता: सूरज नही निकला ना\n" +
                "\n" +
                "संता: क्यों नही निकला?\n" +
                "बंता:\n" +
                "उसकी मम्मी ने नही निकलने दिया।\n" +
                "बोली कि ठंड में कहाँ जायेगा, पड़ा रह कम्बल में, फालतू की आवारागर्दी करेगा।"));
        jokes.add(new Joke("17. संता सिंह अपनी गर्भवती बीवी को हॉस्पीटल ले गया\n" +
                "और नर्स से बोला;\n" +
                "\n" +
                "अगर लडका हो तो कहना कि टमाटर हुआ है..\n" +
                "\n" +
                "और अगर लडकी हो तो कहना प्याज हुयी है..!\n" +
                "\n" +
                "इत्तेफाक से लडका लडकी दोनों जुडवा हो जाते हैं…\n" +
                "\n" +
                "और नर्स कन्फ्यूजन में बाहर आयी और बोली…..\n" +
                "सर बधाई हो..\n" +
                "“सलाद” हुआ है..!!"));
        jokes.add(new Joke("18. संता केले के छिलके से फिसल कर गिर गया।\n" +
                "आगे चला तो दूसरे छिलके से फिसल कर गिर गया।\n" +
                "थोड़ा और आगे चला तो उसे तीसरा छिलका दिख गया।\n" +
                "\n" +
                "संता बोला- धत् तेरे की, अब फिर से गिरना पड़ेगा .. !"));
        jokes.add(new Joke("19. विदेश यात्रा से लौटकर आये संता ने अपनी बीवी से पूछा- क्या मैं विदेशी जैसा दिखता हूं?\n" +
                "\n" +
                "बीवी- नहीं तो\n" +
                "\n" +
                "संता- तो फिर लन्दन में एक औरत क्यों पूछ रही थी कि मैं विदेशी हूं...."));
        jokes.add(new Joke("20. संतो (संता की बीवी) – सुनो जी, जब हमारी नयी नयी शादी हुई थी,\n" +
                "तो जब मैं खाना बना कर लाती थी तो तुम खुद कम खाते थे,\n" +
                "मुझे ज्यादा खिलाते थे।\n" +
                "संता – तो ?\n" +
                "\n" +
                "संतो – तो अब ऐसा क्यों नहीं करते ?\n" +
                "संता – क्यूंकि अब तुम अच्छा खाना बनाना सीख गयी हो…."));
        jokes.add(new Joke("21. व्हाटसआप आया तो SMS खत्म\n" +
                "\n" +
                "यू ट्यूब आये तो विडिओ खत्म\n" +
                "\n" +
                "स्काइप आया तो ISD कॉल खत्म\n" +
                "\n" +
                "अमेज़न आया तो बाजार की खरीदारी खत्म\n" +
                "\n" +
                "फेसबुक आया तो रियल लाइफ खत्म\n" +
                "\n" +
                "सबसे खास पॉइंट तो अब है………..\n" +
                "\n" +
                "राहुल गांधी और केजरीवाल आये तो सन्ता और बन्ता खत्म!!!!"));
        jokes.add(new Joke("22. यमराज (संता से): तुम्हारी कोई आखिरी ख्वाहिश है?\n" +
                "\n" +
                "संता:\n" +
                "हाँ है!\n" +
                "मैं मनमोहन सिंह को नरेंद्र मोदी की शादी में सलमान खान की पत्नी से बात करते हुए देखना चाहता हूँ!\n" +
                "\n" +
                "यमराज बेहोश !!"));
        jokes.add(new Joke("23. संता एक बार किसी कंपनी में जॉब के लिए इंटरव्यू देने गया\n" +
                "\n" +
                "बंता सिंह (मेनेजर): आपकी शादी हो गयी?\n" +
                "\n" +
                "संता: जी हाँ, एक लड़की से हुई\n" +
                "\n" +
                "मेनेजर: शादी तो लड़की से ही होती है!!\n" +
                "\n" +
                "संता: नहीं जी, मेरी बहिन की शादी तो लड़के से हुई है!"));
        jokes.add(new Joke("24. संता ने बंता को हिंदी SMS भेजा\n" +
                "भेजने वाला महान,\n" +
                "पढ़ने वाला गधा.\n" +
                "\n" +
                "बंता गुस्से में वापिस sms भेजता है:\n" +
                "भेजने वाला गधा,\n" +
                "पढ़ने वाला महान!!"));
        jokes.add(new Joke("25. बैंक मैनेजर: ये क्या अजीब सा हस्ताक्षर है?\n" +
                "\n" +
                "“@/e”\n" +
                "\n" +
                "संता: ये हस्ताक्षर मेरी दादी के हैं!\n" +
                "\n" +
                "बैंक मैनेजर: ऐसा अजीब सा हस्ताक्षर? क्या नाम है उनका?\n" +
                "\n" +
                "संता: जलेबी बाई…"));
        jokes.add(new Joke("26. जेलर: तुम्हे कल सुबह 5 बजे फांसी दी जाएगी!\n" +
                "\n" +
                "संता सरदार: हाहाहाहाहा\n" +
                "\n" +
                "जेलर: क्या हुआ, हंस क्यों रहे हो?\n" +
                "\n" +
                "संता सरदार: मैं तो उठता ही सुबह 9 बजे हूँ.."));
        jokes.add(new Joke("27. संता:\n" +
                "पंडित जी, मेरी शादी नहीं हो रही है..\n" +
                "कोई उपाय बताओ।\n" +
                "\n" +
                ".\n" +
                "\n" +
                ".\n" +
                "\n" +
                "पंडित जी:\n" +
                "सबसे पहले, बड़ो से ‘सदा सुखी रहो’ के आशीर्वाद लेना बंद करो."));
        jokes.add(new Joke("28. बंता:\n" +
                "यार ये रामदेव बाबा वाला नूडल्स खरीदा है,\n" +
                "इनको खाना कैसे है ?\n" +
                "\n" +
                "संता:\n" +
                "एक नाक बंद करके दूसरी नाक से अंदर खींचना हैं!!!!"));
        jokes.add(new Joke("29. डॉक्टर: अच्छे स्वास्थ्य के लिए रोजाना व्यायाम किया करो\n" +
                "\n" +
                "संता: जी मैं रोजाना क्रिकेट और फुटबाल खेलता हूँ!\n" +
                "\n" +
                "डॉक्टर: कितनी देर खेलते हो?\n" +
                "\n" +
                "संता: जब तक मोबाइल की बैटरी खत्म नहीं हो जाती!!"));
        jokes.add(new Joke("30. संता: यह सदाचार क्या होता है?\n" +
                "\n" +
                "बंता: जैसे आम का अचार होता है, वैसे सादा आचार होता है!\n" +
                "\n" +
                "————\n" +
                "\n" +
                "संता: यह अनुशासन क्या होता है?\n" +
                "\n" +
                "बंता: जैसे दुशासन होता है, वैसे ही अनुशासन होता है !!"));

        DividerItemDecoration itemDecoration =
                new DividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL);
        listView.addItemDecoration(itemDecoration);
        JokeAdapter adapter = new JokeAdapter(getActivity(), jokes);

        listView.setAdapter(adapter);

        return rootView;
    }

    public void prepareAd(){
        mInterstitialAd = new InterstitialAd(getActivity());
        mInterstitialAd.setAdUnitId("ca-app-pub-2178015702183927/1772107559");
        mInterstitialAd.loadAd(new AdRequest.Builder().build());
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