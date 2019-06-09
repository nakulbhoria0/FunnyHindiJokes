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
public class ShortJokesFragment extends Fragment implements NativeAdsManager.Listener {


    final ArrayList<Joke> jokes = new ArrayList<Joke>();
    private NativeAdsManager mNativeAdsManager;
    private RecyclerView listView;

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
        jokes.add(new Joke("1. फ़िज़िक्स के नियम के अनुसार किसी चीज़ को उठाने से सरकाना ज़्यादा आसान होता है।\n" +
                "\n" +
                "…\n" +
                "\n" +
                "जैसे\n" +
                "\n" +
                ".\n" +
                "\n" +
                "ज़िम्मेदारी\n" +
                "\n" +
                "– न्यूटन के फ़ूफा\n" +
                "(सरकारी अधिकारी )"));
        jokes.add(new Joke("2. गर्मी आ गयी हैं अपना ख्याल रखना\n" +
                "पानी ज्यादा पीना\n" +
                "खाना कम खाना\n" +
                "और सबसे जरूरी बात-\n" +
                "सिर को धुप से बचाना⚡\n" +
                "क्योंकि भूसे मे आग जल्दी लगती हैं|"));
        jokes.add(new Joke("3. बहू अगर नींबू खा रही हो तो जरूरी नहीं कि कोई खुशखबरी हो।\n" +
                "\n" +
                "जमाना बदल गया है…\n" +
                "\n" +
                "हो सकता है वो रात की उतार रही हो।"));
        jokes.add(new Joke("4. वो तो मेडिकल स्टोर पर\n" +
                "इन लड़कियों का बस नहीं चलता..\n" +
                "\n" +
                "वर्ना ……\n" +
                "\n" +
                "सर दर्द की गोली मांगते हुये भी पूछ ले\n" +
                "भईया इसमें कोई और कलर दिखाना ।"));
        jokes.add(new Joke("5. जंगल मे सपेरा बीन लिए बैठा था.\n" +
                "\n" +
                "गौर फरमाइए..\n" +
                "\n" +
                "जंगल मे सपेरा बीन लिए बैठा था…\n" +
                "\n" +
                "साँप और भी कमीना था,\n" +
                "वो इयरफोन लगाए बैठा था..!!"));
        jokes.add(new Joke("6. मैं तो स्मार्ट फोन को उस दिन स्मार्ट मानूंगा,\n" +
                "जब मैं चिल्लाऊंगा:\n" +
                "कारे, हमाओ फोन काँ है..?\n" +
                "\n" +
                "और फोन आवाज लगायेगा:\n" +
                "जे हैं दाउ हम, पल्ली के नेचे डरे हैं।"));
        jokes.add(new Joke("7. मरीज – डॉ. साहब जोड़ों में दर्द रहता है क्या करूँ ?\n" +
                "\n" +
                "डॉ. (मरीज को गले लगते हुए) – जोड़े तो भगवान बनाता है पगले इसमें हम डॉ. क्या कर सकते हैं?"));
        jokes.add(new Joke("8. घर का T.V बिगड़ जाए\n" +
                "तो माता-पिता कहते हैं..\n" +
                "बच्चों ने बिगाड़ा है;\n" +
                "\n" +
                "और अगर बच्चे बिगड़ जाएं तो\n" +
                "कहते है..\n" +
                "T.V. ने बिगाड़ा है !!!"));
        jokes.add(new Joke("9. दामाद अपनी सास से बात करता हैं :\n" +
                "आपकी बेटी में तो हज़ारों कमियाँ हैं ।\n" +
                "\n" +
                "सास: हाँ बेटा , इसी वजह से तो उसे अच्छा लड़का नही मिला. "));
        jokes.add(new Joke("10. जब दो लडकियों आपस में मिलती हैं तो..\n" +
                "\n" +
                "एक selfie ले लेती हैं..\n" +
                "\n" +
                "जब दो लड़के आपस में मिलते हैं तो ..\n" +
                "\n" +
                "एक हाफ़ ले लेते है…"));
        jokes.add(new Joke("11. ब्रेकिंग न्यूज़..\n" +
                "\n" +
                "एडमिन को भारी नुकसान\n" +
                "\n" +
                ".\n" +
                "\n" +
                ".\n" +
                "\n" +
                ".\n" +
                "\n" +
                "चाय पिते वक़्त आधा बिस्कुट चाय में गिरा\n" +
                "एडमिन सदमे में!!"));
        jokes.add(new Joke("12. डॉक्टर: आपका वजन कितना है?\n" +
                "संता: चश्में के साथ 75 किलो।\n" +
                "\n" +
                "डॉक्टर: और चश्में के बिना?\n" +
                "संता: वो मुझे दिखता ही नहीं।"));
        jokes.add(new Joke("13. टीचर :- देश के सबसे ईमानदार पुलिसवाले कहा पर पाए जाते है…???\n" +
                "\n" +
                ".\n" +
                "\n" +
                "पप्पू :- सावधान इंडिया और क्राइम पेट्रोल !"));
        jokes.add(new Joke("14. दादा (पोते से)- तेरी टीचर आ रही है, जा छुप जा.\n" +
                "\n" +
                "पोता-\n" +
                "पहले आप छुप जाओ,\n" +
                "आपकी मौत के बहाने मैंने दो हफ्ते की छुट्टी ले रखी है."));
        jokes.add(new Joke("15. पति-पत्नी एक ही प्लेट में गोलगप्पे खा रहे थे।\n" +
                "एक दूसरे की आँख में आँख डाले पत्नी ने रोमांटिक हो कर पूछा !\n" +
                "“ऐसे क्या देख रहे हो जी?”\n" +
                "पति: थोडा आराम से खा, मेरी बारी ही नहीं आ रही।"));
        jokes.add(new Joke("16. शहर की लड़की की शादी गाँव मे हो गई।\n" +
                "\n" +
                "लड़की की सासु माँ ने उसे भैस को घास डालने को बोला।\n" +
                "\n" +
                "भैस के मुँह मे झाग देख कर लड़की वापस आ गई।\n" +
                "\n" +
                "सासु माँ बोली: क्या हुआ बहू?\n" +
                "\n" +
                "लड़की बोली:\n" +
                "भैस अभी कोलगेट कर रही है, माँ जी।।"));
        jokes.add(new Joke("17. टीचर: तुम्हें पता है हमारे पूर्वज बन्दर थे?\n" +
                "\n" +
                "पप्पू थारे होंगे, महारे तो चौधरी थे।"));
        jokes.add(new Joke("18. पप्पू …… दिल्ली चला गया\n" +
                "रेलवे स्टेशन पै अखबार वाले से बोला:-\n" +
                "एक अखबार देना…\n" +
                "\n" +
                "अखबार वाला-हिन्दी या अंग्रेजी का?\n" +
                "\n" +
                "पप्पू ….. भाई कोईसा दे दे\n" +
                "मने तो रोटी लपेटनी है|"));
        jokes.add(new Joke("19. पत्नी हरियाणा पुलिस से- जी म्हारा\n" +
                "घरवाला 5 दिन पेहला गोभी लेन\n" +
                "गया था इब तक कोणी आया\n" +
                "\n" +
                "हरियाणा पुलिस- फेर के होया,\n" +
                "कोई और सब्जी बना ले, जरुरी है गोभी बनानी?"));
        jokes.add(new Joke("20. लाजवाब हरियाणा\n" +
                "\n" +
                "हरियाणवी लड़की: पासपोर्ट साइज फोटो खींच दे, अर उसमें मेरी नई चप्पल भी आनी चाहिए\n" +
                "\n" +
                "फोटोग्राफर बी हरियाणवी था। बोल्या उकड़ू बैठ जा।"));
        jokes.add(new Joke("21. पप्पू पेंटिंग खरीदने गया…\n" +
                "सेल्समैन:\n" +
                "यह 10 हजार रुपये की है।\n" +
                "आईल पेंट से बनी हुई है।\n" +
                "पप्पू \n" +
                "पैसों की चिंता मत कर।\n" +
                "देसी घी में कुछ दिखा….!"));
        jokes.add(new Joke("22. हॉस्टल स्टूडेंट अपने दोस्त से:\n" +
                "भाई धोखा हो गया धोखा ;-(\n" +
                "\n" +
                "दोस्त:- क्या हो गया…??\n" +
                "\n" +
                "स्टूडेंट:\n" +
                "घर से बुक्स के लिए पैसे मंगवाए थे,\n" +
                "\n" +
                ".\n" +
                "\n" +
                "घर वालो ने बुक्स ही भेज दी…"));
        jokes.add(new Joke("23. प्रभु यह क्या मोह माया है?\n" +
                "\n" +
                "अपना बच्चा रोये तो दिल में दर्द होता है\n" +
                "और दूसरे का रोये तो सर में।\n" +
                "\n" +
                "अपनी बीवी रोये तो सर में दर्द होता है\n" +
                "और दूसरे की रोये तो दिल में \n" +
                "\n" +
                "सब प्रभु की माया है!!"));
        jokes.add(new Joke("24. दोस्त – तेरी बीवी ने तुझे घर से क्यों निकाला,\n" +
                "पठान – साले तेरे कहने पर उसे चैन गिफ्ट की थी, इसीलिए निकाला।\n" +
                "दोस्त – चांदी की थी क्या?\n" +
                "पठान – नहीं साइकिल की\n" +
                "\n" +
                "सोने चान्दी वाले तो हडताल पर है ।"));
        jokes.add(new Joke("25. भक्तिनि:\n" +
                "“बाबा, मेरे और मेरे पति के बीच प्रेम कम हो गया है..\n" +
                "कोई ऊपाय बताओ..!!\n" +
                "\n" +
                "बाबा:\n" +
                "बालिका… शनिवार को ‘फेसबुक’ का ऐकासना\n" +
                "और रविवार को ‘व्हाटसप्प’ का उपवास रखो पहले जैसा प्रेम आ जाएगा…….."));
        jokes.add(new Joke("26. एक निग्रो मरने के बाद स्वर्ग गया..\n" +
                "\n" +
                "परी: तुम कौन हो ?\n" +
                "\n" +
                "निग्रो (परी को इम्प्रेस करने के लिए):\n" +
                "मैं TITANIC का हीरो हूं ,\n" +
                "\n" +
                "परी : …\n" +
                "TITANIC डूबी थी\n" +
                "जली नही थी कल्ले … "));
        jokes.add(new Joke("27. Girl – “तुम क्या काम करते हो ?”\n" +
                "\n" +
                "Boy– “Hindustan Times में job करता था लेकिन अभी छोड़ दिया …”\n" +
                "\n" +
                "Girl- “छोड़ क्यूँ दिया ? कितनी अच्छी कंपनी तो है ?”\n" +
                "\n" +
                "Boy– “अब इतनी ठंड में कौन सुबह-सुबह अखबार बांटने जाए …!!!”"));
        jokes.add(new Joke("28. लेजी ब्वॉय: पापा एक ग्लास पानी देना…\n" +
                "\n" +
                "पापा: खुद उठ के पी लो…\n" +
                "\n" +
                "ब्वॉय: प्लीज, दे दो ना…\n" +
                "\n" +
                "पापा: अब अगर पानी मांगा तो थप्पड़ मारुंगा…\n" +
                "\n" +
                "ब्वॉय: थप्पड़ मारने आओ तो पानी लेते आना…!!!"));
        jokes.add(new Joke("29. जंगल मे सपेरा बीन लिए बैठा था.\n" +
                "\n" +
                "गौर फरमाइए..\n" +
                "\n" +
                "जंगल मे सपेरा बीन लिए बैठा था…\n" +
                "\n" +
                "साँप और भी कमीना था,\n" +
                "वो इयरफोन लगाए बैठा था..!!"));
        jokes.add(new Joke("30. अगर हम गौर करे तो पता चलता है की\n" +
                "इंसान जिंदगीभर सिर्फ तीन काम करता है\n" +
                "\n" +
                "1. भागादौड़ी\n" +
                "\n" +
                "2.हाथाजोडी\n" +
                "\n" +
                "और\n" +
                "\n" +
                "3. माथाफोडी!!"));


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
