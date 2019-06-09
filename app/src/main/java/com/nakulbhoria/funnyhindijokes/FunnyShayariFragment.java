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
public class FunnyShayariFragment extends Fragment implements NativeAdsManager.Listener {

    final ArrayList<Joke> jokes = new ArrayList<>();
    private NativeAdsManager mNativeAdsManager;
    private RecyclerView listView;
    private InterstitialAd mInterstitialAd;

    public FunnyShayariFragment() {
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
        jokes.add(new Joke("1. ना तलवार की धार से ना गोलियों की बौछार से, \n" +
                "बंदा डरता है तो सिर्फ अपने बाप की मार से।"));
        jokes.add(new Joke("2. आँखो से आँखे मिलाकर तो देखो, \n" +
                "एक बार हमारे पास आकर तो देखो, \n" +
                "मिलना चाहेंगे सब लोग तुमसे, \n" +
                "एक बार मेरे दोस्त साबुन से नहाकर तो देखो।"));
        jokes.add(new Joke("3. ऐसी अपनी वाईफ हो, \n" +
                "जींस जिसकी टाईट हो, \n" +
                "चेहरा जिसका व्हाईट हो, \n" +
                "बालों में स्टाईल हो, \n" +
                "होंठों पर स्माइल हो, \n" +
                "इंडिया कि पैदाईश हो, \n" +
                "सास की सेवा जिसकी ख्वाहिश हो, \n" +
                "ऐसी अपनी वाईफ हो, \n" +
                "तो क्या हसीन लाईफ हो।"));
        jokes.add(new Joke("4. हम तुम्हारी याद में रो-रो के टब भर दिए, \n" +
                "तुम इतने बेवफा निकले कि नहाकर चल दिए।"));
        jokes.add(new Joke("5. मोहब्बत के खर्चों की बड़ी लंबी कहानी है, \n" +
                "कभी फिल्म दिखानी है तो कभी शॉपिंग करानी है, \n" +
                "मास्टर रोज कहता है कहाँ हैं फीस के पैसे? \n" +
                "उसे कैसे समझाऊँ कि मुझे छोरी पटानी है!"));
        jokes.add(new Joke("6. हसीना से मिलें नजरें अट्रैक्शन हो भी सकता है, \n" +
                "चढ़े फीवर मोहब्बत का तो एक्शन हो भी सकता है, \n" +
                "हसीनों को मुसीबत तुम समझ कर दूर ही रहना, \n" +
                "ये अंग्रेजी दवाएं हैं रिएक्शन हो भी सकता है।"));
        jokes.add(new Joke("7. चिरागों में इतना नूर ना होता, \n" +
                "तो तनहा दिल मजबूर ना होता, \n" +
                "हम आपसे मिलने जरूर आते, \n" +
                "अगर आपका घर इतना दूर ना होता।"));
        jokes.add(new Joke("8. ये बारिश का मौसम बहुत तड़पाता है, \n" +
                "वो बस मुझे ही दिल से चाहता है, \n" +
                "लेकिन वो मिलने आए भी तो कैसे...? \n" +
                "उसके पास न रेनकोट है और ना छाता है।"));
        jokes.add(new Joke("9. ताज महल क्या चीज है... \n" +
                "हम इससे भी अच्छी इमारत बनवा देंगे, \n" +
                "शाहजहां ने मुमताज़ को मुर्दा दफनाया था, \n" +
                "हम तुझे ज़िंदा ही दफना देंगे।"));
        jokes.add(new Joke("10. कहते हैं कि प्यार की राहों पे चलना आसान नहीं, \n" +
                "मैंने भी कल चल के देखा मुझे ताे रास्ता ठीक ही लगा।"));
        jokes.add(new Joke("11. ऐ दोस्त व्हिस्की को कफ़न में बांध ला, \n" +
                "कब्र में बैठ कर पिया करेंगे, \n" +
                "इन लड़कियो से मिला है धोखा \n" +
                "चुड़ैलों से सेटिंग किया करेंगे।"));
        jokes.add(new Joke("12. मुस्कुराना तो हर लड़की की अदा है \n" +
                "जो इसे प्यार समझे वो सबसे बड़ा गधा है।"));
        jokes.add(new Joke("13. अंधकार के घोर तिमिर में हॅसने के बाद रुलाती है, \n" +
                "तन्हाई और गम है साथ ये जिंदगी भी तड़पाती है, \n" +
                "मेरी हालत भी मुझसे जलती और रूठ जाती है, \n" +
                "जब आइंस्टीन और न्यूटन संग याद तुम्हारी आती है।"));
        jokes.add(new Joke("14. एक बेवफा की याद में हम कुछ ख़ास हो गए, \n" +
                "पहले हम लोटा थे पर अब गिलास हो गए।"));
        jokes.add(new Joke("15. नखरे आपके तौबा-तौबा \n" +
                "गजब आपका स्टाईल है, \n" +
                "मैसेज तो आप कभी करते नहीं, \n" +
                "बस हल्ला मचा रखा है कि \n" +
                "हमारे पास भी मोबाईल है।"));
        jokes.add(new Joke("16. इस क़दर था खटमलों का चारपाई में हुजूम, \n" +
                "वस्ल का दिल से मेरे अरमान रुख़्सत हो गया।"));
        jokes.add(new Joke("17. ये मोहब्बत नहीं, उसूल-ए-वफ़ा है ऐ दोस्त, \n" +
                "हम जान तो दे देंगे जान का नंबर नहीं देंगे।"));
        jokes.add(new Joke("18. इश्क का जिसको ख्वाब आ जाता है, \n" +
                "समझो उसका वक़्त खराब आ जाता है, \n" +
                "महबूब आये या न आये, \n" +
                "पर तारे गिनने का हिसाब आ जाता है।"));
        jokes.add(new Joke("19. कितना शरीफ शख्श है वीवी पे फ़िदा है, \n" +
                "उस पे ये कमाल है कि अपनी पे फ़िदा है।"));
        jokes.add(new Joke("20. दिल दो किसी एक को और वो भी किसी नेक को, \n" +
                "मंदिर का प्रसाद नहीं... जो बांट दो हर एक को।"));
        jokes.add(new Joke("21. अर्ज़ किया है... \n" +
                "\n" +
                "वो कहती अपने भाइयों से, मेरे आशिक़ को यूँ ना पीटो, \n" +
                "ज़रा गौर फरमाइये... \n" +
                "वो कहती अपने भाइयों से, मेरे आशिक़ को यूँ ना पीटो, \n" +
                "बड़ा ज़िद्दी है ये कमीना, पहले कुत्ते की तरह घसीटो।"));
        jokes.add(new Joke("22. लड़कियों से प्यार न करना क्योंकि, \n" +
                "दिखती हैं हीर की तरह, \n" +
                "लगती हैं खीर की तरह, \n" +
                "दिल में चुभती हैं तीर की तरह, \n" +
                "और छोड़ जाती हैं फकीर की तरह ।"));
        jokes.add(new Joke("23. मोहब्बत न सही मुक़दमा ही कर दे... \n" +
                "तारीख दर तारीख मुलाकात तो होगी ।"));
        jokes.add(new Joke("24. तेरा प्यार भी हजार की नोट जैसा है, \n" +
                "डर लगता है कहीं नकली तो नहीं ।"));
        jokes.add(new Joke("25. रोया है फ़ुर्सत से कोई मेरी तरह सारी रात यकीनन, \n" +
                "वर्ना रुख़सत-ए- मार्च में यहाँ बरसात नहीं होती...।"));
        jokes.add(new Joke("26. न वफा का जिकर होगा, \n" +
                "न वफा कि बात होगी, \n" +
                "अब मोहब्बत जिससे भी होगी, \n" +
                "\n" +
                "गेहूँ काटने के बाद होगी..।।"));
        jokes.add(new Joke("27. जेलर- सुना है की तुम शायर हो कुछ सुनाओ यार... \n" +
                "\n" +
                "कैदी- \n" +
                "गम ए उल्फत मे जो जिन्दगी कटी हमारी, \n" +
                "जिस दिन जमानत हुई जिन्दगी खतम तुम्हारी ।"));
        jokes.add(new Joke("28. तुझे पाने के लिये कुछ भी कर सकता हूँ, \n" +
                "तेरे प्यार मे जी तो क्या मर भी सकता हूँ, \n" +
                "फिर भी तू नही मिली तो मुझे कोई गम नही, \n" +
                "ये तरीका किसी दूसरी पर भी सेट कर सकता हूँ।"));
        jokes.add(new Joke("29. इतने पड़े हैं डंडे तेरी गली में, \n" +
                "अरमान हो गए ठन्डे तेरी गली में, \n" +
                "एक हाथ में है कंघी जुल्फे संवारते हैं, \n" +
                "गाड़ेंगे आशिकी के झंडे तेरी गली में। \n" +
                "\n" +
                "अब क्या बताएं ज़ालिम कैसे गुजारते हैं, \n" +
                "संडे तेरी गली में मंडे तेरी गली में, \n" +
                "सीने पे हाथ रख कर तुझको पुकारते हैं, \n" +
                "जब मारते हैं पत्थर मुंडे तेरी गली में। \n" +
                "\n" +
                "तडपते हैं कितना ज़ालिम तुझको तरस न आया, \n" +
                "कर लेंगे ख़ुदकुशी हम वन डे तेरी गली में, \n" +
                "हम ढूढ़ लेंगे कोई दीदार का बहाना, \n" +
                "बेचा करेंगे अंडे तेरी गली में...।"));
        jokes.add(new Joke("30. आपकी सूरत मेरे दिल में ऐसे बस गयी है, \n" +
                "जैसे छोटे से दरवाजे में भैंस फंस गयी है..।"));
        jokes.add(new Joke("31. आँखों से आसुओं की विदाई कर दो, \n" +
                "दिल से ग़मों की जुदाई कर दो, \n" +
                "गर फिर भी दिल न लगे कही, \n" +
                "तो मेरे घर की पुताई कर दो...।"));
        jokes.add(new Joke("32. है हसरत कि हो ऐलान एक दिन, \n" +
                "कि हजरात-ए-इश्क इन्तेकाल कर गए ।"));
        jokes.add(new Joke("33. मोहब्बत हमने उसी दिन छोड़ दी थी ग़ालिब... \n" +
                "जब उसने कहा था कि \n" +
                "पप्पियों के पैसे अलग \n" +
                "और झप्पियों के अलग..।"));
        jokes.add(new Joke("34. मेरी सांसो में जो समाया बहुत लगता है, \n" +
                "वही शख्स मुझे पराया भी बहुत लगता है, \n" +
                "उनसे मिलने की तमन्ना तो बहुत है मगर, \n" +
                "आने-जाने में किराया ही बहुत लगता है।"));
        jokes.add(new Joke("35. निगाहें आज भी उस शख्स को शिद्दत से तलाश करती हैं, \n" +
                "जिसने कहा था... \n" +
                "\"बस दसवी कर लो, आगे पढ़ाई आसान है ।\""));
        jokes.add(new Joke("36. जुल्फों में फूलों को सजा के आयी, \n" +
                "चेहरे से दुपट्टा उठा के आयी, \n" +
                "किसी ने पूछा आज बड़ी खुबसूरत लग रही है, \n" +
                "हमने कहा शायद आज नहा के आयी।"));
        jokes.add(new Joke("37. हम भी जान-ए-मन तेरे लिए ताजमहल बनायेंगे, \n" +
                "अर्ज़ किया है, \n" +
                "हम भी जान-ए-मन तेरे लिए ताजमहल बनायेंगे, \n" +
                "एक कप सुबह पिलायेंगे और एक कप शाम को पिलायेंगे।"));
        jokes.add(new Joke("38. उस की गली से गुजरे तो उसकी रँगोली भी देख आए, \n" +
                "गजब की बनाती है... \n" +
                "हमें तो लगा था बस मुँह बनाना आता होगा।"));
        jokes.add(new Joke("39. आशिक पागल हो जाते हैं प्यार में, \n" +
                "बाकी कसर पूरी हो जाती है इंतज़ार में, \n" +
                "मगर ये दिलरुबा नहीं समझती, \n" +
                "वो तो गोल गप्पे और पपड़ी \n" +
                "खाती फिरती है बाज़ार में ।"));
        jokes.add(new Joke("40. हमसे मोहब्बत का दिखावा न किया कर, \n" +
                "हमे मालुम है तेरे वफा की डिगरी फर्जी है ।"));
        jokes.add(new Joke("41. तुम्हारा साया बन कर ताउम्र तुम्हारा साथ निभायेंगे, \n" +
                "हर एक कदम तुम्हारी राहों को फूलों से सजायेंगे, \n" +
                "अगर मौत ने जुदा कर भी दिया हमें तुमसे, \n" +
                "तो तुम्हारी खिड़की के सामने वाले पेड़ पर, \n" +
                "प्रेत बन कर उलटे लटक जायेंगे। "));
        jokes.add(new Joke("42. इससे ज्यादा दुश्मनी की \n" +
                "इन्तहा क्या होगी ग़ालिब \n" +
                "टोयलेट की टंकी में कोई \n" +
                "बर्फ डाल गया।"));
        jokes.add(new Joke("43. उम्र की राह में जज्बात बदल जाते है, \n" +
                "वक़्त की आंधी में हालात बदल जाते है, \n" +
                "सोचता हूं काम कर-कर के रिकॉर्ड तोड़ दूं, \n" +
                "कमबख्त सैलेरी देख के ख्यालात बदल जाते हैं।"));
        jokes.add(new Joke("44. ऐ खुदा... हिचकियों में कुछ तो फर्क डाला होता... \n" +
                "अब कैसे पता करूँ कि कौनसी वाली याद कर रही है."));
        jokes.add(new Joke("45. आसमान जितना नीला है, \n" +
                "सूरजमुखी जितना पिला है, \n" +
                "पानी जितना गीला है, \n" +
                "आपका स्क्रू उतना ही ढीला है।"));
        jokes.add(new Joke("46. इश्क़ में ये अंजाम पाया है,\n" +
                "हाथ पैर टूटे, मुँह से खून आया है,\n" +
                "हॉस्पिटल पहुंचे तो नर्स ने फ़रमाया..\n" +
                "बहारों फूल बरसाओ, किसी का आशिक़ आया है!"));
        jokes.add(new Joke("47. ये जो लड़कियों के बाल होते हैं,\n" +
                "लड़कों को फ़साने के जाल होते हैं,\n" +
                "खून चूस लेती हैं लड़कों का सारा,\n" +
                "तभी तो इनके होंठ लाल होते हैं।"));
        jokes.add(new Joke("48. हम दिलफेक आशिक़ हर काम में कमाल कर दे,\n" +
                "जो वादा करे वो पूरा हर हाल में कर दे,\n" +
                "क्या जरुरत है लड़कियों को लिपस्टिक लगाने की,\n" +
                "हम चूम-चूम के ही होंठ लाल कर दें।"));
        jokes.add(new Joke("49. न चांद होगा ना तारे होंगे,\n" +
                "क्या हम इस साल भी कुंवारे होंगे ,\n" +
                "इस दुनिया में कितनों के निकाह हो गए ,\n" +
                "क्या हमारे नसीब में सिर्फ निकाह के छुहारे होंगे।"));
        jokes.add(new Joke("50. जुल्फों में फूलों को सजा के आयी,\n" +
                "चेहरे से दुपट्टा उठा के आयी,\n" +
                "किसी ने पूछा आज बड़ी खुबसूरत लग रही है,\n" +
                "हमने कहा शायद आज नहा के आयी!"));


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