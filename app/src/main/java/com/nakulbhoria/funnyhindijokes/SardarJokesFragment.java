package com.nakulbhoria.funnyhindijokes;


import android.support.v4.app.Fragment;
import android.os.Bundle;
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
public class SardarJokesFragment extends Fragment implements NativeAdsManager.Listener {


    final ArrayList<Joke> jokes = new ArrayList<>();
    private NativeAdsManager mNativeAdsManager;
    private RecyclerView listView;

    public SardarJokesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        String placement_id = "1869998493118528_1870003033118074";
        mNativeAdsManager = new NativeAdsManager(getActivity(), placement_id, 0);
        mNativeAdsManager.loadAds();
        mNativeAdsManager.setListener(this);

        View rootView = inflater.inflate(R.layout.joke_list,container,false );

        listView = rootView.findViewById(R.id.list);
        listView.setLayoutManager(new LinearLayoutManager(getActivity()));
        jokes.add(new Joke("1. सरदार- स्टेशन जाने का कितना लोगे??\n" +
                "\n" +
                "रिक्शावाला- 50\n" +
                "\n" +
                "सरदार- 20 ले लो..\n" +
                "\n" +
                "रिक्शावाला- 20 में कौन ले के जाएगा??\n" +
                "\n" +
                ".\n" +
                "\n" +
                "सरदार- तुम पीछे बैठो हम लेके जाएगा!!!"));
        jokes.add(new Joke("2. पिंड दी सरदारनी अपने सरदार नू :\n" +
                "सरदार जी आज मकडोनाल्ड चलिए.?\n" +
                "\n" +
                "सरदार –\n" +
                "स्पेलिंग दस दे.. फेर चलेंगे..\n" +
                "\n" +
                "सरदारनी: फेर KFC चलदे हाँ…\n" +
                "सरदार- KFC दी फुल फॉर्म बोल फेर चलदे हां.\n" +
                "\n" +
                "सरदारनी – रहन दे कुत्तेया\n" +
                "कुलचे छोले ही खवा दे.. !"));
        jokes.add(new Joke("3. सरदार टी टी से :\n" +
                "मुझे सुबह 4 बजे लुधियाना में उठा देना । अगर में ना जागू तो ज़बरदस्ती उतार देना..\n" +
                "\n" +
                "सुबह 8 बजे सरदार जागा तो\n" +
                "लुधियाना निकल चूका था\n" +
                "और ट्रेन अमृतसर पहुँच रही थी ..\n" +
                "\n" +
                "सरदार टी टी को खूब गालियाँ देने लगा ..\n" +
                "टी टी चुप चाप था ।\n" +
                "\n" +
                "लोगों ने टी टी से कहा:\n" +
                "वो इतनी गालियाँ दे रहा है और चुप चाप सुन रहे हो ?\n" +
                "\n" +
                "टी टी: में ये सोच रहा हूँ की सुबह 4 बजे जिस सरदार को ज़बरदस्ती उतार दिया था,\n" +
                "वो कितनी गालियाँ दे रहा होगा …"));
        jokes.add(new Joke("4. सरदार का सर फट गया।\n" +
                "\n" +
                "डॉक्टर:- ये कैसे हुआ?\n" +
                "\n" +
                "सरदार:-\n" +
                "मैं ईंट से पत्थर तोड़ रहा था।\n" +
                "एक आदमी ने मुझसे कहा, “कभी खोपड़ी का इस्तेमाल भी कर लिया कर।”"));
        jokes.add(new Joke("5. सरदार (पुलिस स्टेशन जा कर बोला):-\n" +
                "मुझे फोन पर जान से मारने की धमकी मिल रही है।\n" +
                "\n" +
                "इंस्पेक्टर:\n" +
                "कौन दे रहा है?\n" +
                "\n" +
                "सरदार:-\n" +
                "BSNL वाले। कहते हैं… बिल नहीं भरा तो काट देंगे।"));
        jokes.add(new Joke("6. सरदार ने मेडिकल स्टोर से दवा ली,\n" +
                "और स्टोर वाले से कहा\n" +
                "“चीनी भी दो”\n" +
                "\n" +
                "स्टोरकीपर- चीनी यहाँ नहीं मिलती ?\n" +
                "\n" +
                "सरदार- हम पागल नहीं हैं,\n" +
                "पढ़ें लिखे हैं,दवा पर लिखा है\n" +
                "Sugar Free\n" +
                "चीनी तो तुम्हारा बाप भी देगा हाँ!!!"));
        jokes.add(new Joke("7. एक ट्रेन के नीचे 100 सरदार आ गये !!\n" +
                "99 मर गए……. एक सरदार बच गया..\n" +
                "रिपोर्टर ने उससे पूछा : “ये सब कैसे हुआ.?”\n" +
                "सरदार बोला – “गलत अनाऊँसमेंट की वजह से,\n" +
                "अनाऊँसमेंट हुआ था कि शताब्दी एक्सप्रेस प्लेटफार्म पर आ रही है!”\n" +
                "तो सब घबराकर प्लेटफार्म से उतारकर पटरी पर आ गये! पर ट्रेन प्लेटफार्म पर नहीं, पटरी पर आई…..\n" +
                "रिपोर्टर: और आप समझदार निकले जो पटरी पर नहीं उतरे!!\n" +
                "\n" +
                "सरदार: जी नहीं, मै तो सुसाइड करने आया था, अनाऊँसमेंट सुनकर मैं पटरी से हट कर प्लेटफारम पर लेट गया था”!!……"));
        jokes.add(new Joke("8. सरदार सरदारनी रेलवे स्टेशन पर खड़े ट्रेन का इंतजार कर रहे थे…\n" +
                "\n" +
                "तभी एक गाड़ी आई जिस पर लिखा था\n" +
                "“बॉम्बे मेल”\n" +
                "\n" +
                "सरदार भाग कर गाड़ी में चढ़ गया…\n" +
                "\n" +
                "बीवी से बोला –\n" +
                "जब “बॉम्बे फीमेल” आये तो तू भी चढ़ जाना !!"));
        jokes.add(new Joke("9. सरदार जी पूरी ज़िन्दगी सोचते रहे..\n" +
                "\n" +
                "सोचते रहे..\n" +
                "\n" +
                "सोचते रहे..\n" +
                "\n" +
                "और\n" +
                "\n" +
                "सोचते सोचते मर गए,\n" +
                "\n" +
                "कि अगर मेरी बहिन के 3 भाई हैं,\n" +
                "तो मेरे 2 ही क्यों है? !!"));
        jokes.add(new Joke("10. मास्टर:\n" +
                "दो में से दो गए कितने बचे ?\n" +
                "\n" +
                "सरदार:\n" +
                "समझ में नहीं आया\n" +
                "मास्टर जी\n" +
                "\n" +
                "मास्टर:\n" +
                "बेटा समझो तुम्हारे पास\n" +
                "दो रोटी हे,\n" +
                "तुमने वो दो रोटी खा ली बताओ तुम्हारे पास क्या बचा\n" +
                "\n" +
                "सरदार: सब्जी !!"));
        jokes.add(new Joke("11. ईक सरदार तलाब में गिर गया।\n" +
                "\n" +
                "डूबते-डूबते उसके हाथ में एक मछली आ गई।\n" +
                "\n" +
                "सरदार ने उसे पकड़ कर बाहर फेंका और\n" +
                "\n" +
                "बोला : तू तो कम से कम अपनी जान बचा ले।"));
        jokes.add(new Joke("12. ट्रेन में वार्निंग लिखी थी…\n" +
                "\n" +
                "बिना टिकिट सफर करने वाले यात्री होशियार!\n" +
                "\n" +
                "सरदारजी इतनी लाइन पढ़ कर बिफर गये:\n" +
                "वाहजी ये कोई बात हुई बिना टिकिट सफर करने वाला होशियार,\n" +
                "हमने टिकिट लिया तो हम बेवकूफ़ !!"));
        jokes.add(new Joke("13. बॉस – आपकी शादी हो गयी?\n" +
                "सरदार – हाँ जी, १ लड़की से हुई है,\n" +
                "\n" +
                "बॉस – शादी तो लड़की से ही होती है,\n" +
                "\n" +
                "सरदार – ना जी मेरी बहन कि तो लड़के से हुई थी !!!"));
        jokes.add(new Joke("14. सरदार जी एक नंबर पर कॉल लगाया..\n" +
                "\n" +
                "एक लड़की ने फ़ोन उठाया….\n" +
                "\n" +
                "सरदार: हेलो… कौन?\n" +
                "\n" +
                "लड़की बोली: मैं सीता…\n" +
                "\n" +
                "सरदार: ओ तेरी!, यह तो अयोध्या लग गया… सॉरी माते… !!!"));
        jokes.add(new Joke("15. शादी की पार्टी में सरदार जी ने\n" +
                "खाने की प्लेट में टीशु पेपर देख सोचा\n" +
                "कि ये खाने की चीज है….\n" +
                "\n" +
                "जैसे ही वह खाने लगा….\n" +
                "तो सारे सरदार भाई एक साथ चिल्लाये …\n" +
                "\n" +
                ".\n" +
                "\n" +
                "ओये मत खा, फीका है!!"));
        jokes.add(new Joke("16. Sardar को एक पार्टी का invitation मिला,\n" +
                "\n" +
                "जिसमें लिखा था\n" +
                "\n" +
                "‘Only Pink Tie’..\n" +
                "\n" +
                "Sardar पार्टी में गया तो उसने देखा के लोगों ने पेंट-शर्ट भी पहनी थी। "));
        jokes.add(new Joke("17. सरदार अपने बीबी के साथ coffee house में ..\n" +
                "\n" +
                "सरदार: जल्दी पी.. coffee ठंडी हो जायेगी …\n" +
                "बीबी: फीर की होगा ??\n" +
                "\n" +
                "सरदार:\n" +
                "बेवकुफ, “मेनू कार्ड” देख,\n" +
                "Hot coffee — Rs 15\n" +
                "Cold coffee — Rs 45"));
        jokes.add(new Joke("18. डॉक्टर:\n" +
                "तुम रोज सुबह क्लिनिक के बहार खड़े होकर औरतो को क्यों घूरते हो?\n" +
                "\n" +
                "सरदार: जी आप ने ही लिखा है,\n" +
                "“औरतो को देखने का समय सुबह 9 बजे से 11 बजे तक!”"));
        jokes.add(new Joke("19. 4 सरदार ट्रैन के पीछे भाग रहे थे..\n" +
                "2 चढ़ गए,\n" +
                "तो ट्रैन में लोगो ने कहा\n" +
                "“WELL DONE”\n" +
                "\n" +
                "सरदार:\n" +
                "ख़ाक well done\n" +
                "जाना तो उन्हें था, हम तो छोड़ने आये थे."));
        jokes.add(new Joke("20. सरदारनी: लो, लाइट चली गयी\n" +
                "\n" +
                "सरदार: लाइट चली गयी तोह क्या, पंखा तो चालू कर\n" +
                "\n" +
                "सरदारनी:\n" +
                "लो, की न वही सरदारों वाली बात,\n" +
                "अगर पंखा चालू किया तो मोमबत्ती बुझ नहीं जाएगी….??"));


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