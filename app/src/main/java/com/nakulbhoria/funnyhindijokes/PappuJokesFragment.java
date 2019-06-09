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
public class PappuJokesFragment extends Fragment implements NativeAdsManager.Listener {


    final ArrayList<Joke> jokes = new ArrayList<>();
    private NativeAdsManager mNativeAdsManager;
    private RecyclerView listView;

    public PappuJokesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        String placement_id = "1869998493118528_1870003033118074";
        mNativeAdsManager = new NativeAdsManager(getActivity(), placement_id, 0);
        mNativeAdsManager.loadAds();
        mNativeAdsManager.setListener(this);

        View rootView = inflater.inflate(R.layout.joke_list,container, false);

        listView = rootView.findViewById(R.id.list);
        listView.setLayoutManager(new LinearLayoutManager(getActivity()));
        jokes.add(new Joke("1. पप्पू कॉलेज की लड़की से बोला:\n" +
                "“आई लव यू, अब तुम मुझे बोलो..”\n" +
                "\n" +
                "लड़की :\n" +
                "“मैं अभी जा कर सर को बोलती हूँ”\n" +
                "\n" +
                "पप्पू :\n" +
                "“पगली सर को मत बोल,\n" +
                "उनकी तो शादी हो गयी है”"));
        jokes.add(new Joke("2. मास्टर – एक ऐसी औरत जो आज तक\n" +
                "\n" +
                "कभी ना हँसी हो\n" +
                "\n" +
                "उसे क्या कहेंगे ??\n" +
                "\n" +
                "पप्पू -“हसीना”"));
        jokes.add(new Joke("3. पप्पू बिजली तार डाल के चोरी कर रहा था\n" +
                "\n" +
                "पप्पू – ले बापू कर दिया सैट\n" +
                "\n" +
                "बापू – सुसरे बिजली तो अभी आयी ही नही\n" +
                "\n" +
                "पप्पू – क्यूँ अब क्या आग लग गयी\n" +
                "\n" +
                "बापू – तार सही से फंसाया है ना ?\n" +
                "\n" +
                "पप्पू –\n" +
                ".\n" +
                ".\n" +
                ".\n" +
                ".\n" +
                "लो अब तुम हमें सिखाओगे कैसे फंसाते हैं \n" +
                "फिर दे लात दे घूंसे!!!!!"));
        jokes.add(new Joke("4. पप्पू डॉक्टर के पास गया –\n" +
                "\n" +
                "पप्पू – डॉक्टर साहब, जब मैं खड़े होकर फिर थोड़ा झुककर\n" +
                "अपनी दायीं टाँग मोड़ता हूँ तो दर्द होता है,\n" +
                "\n" +
                "डॉक्टर – मतलब ?\n" +
                "\n" +
                "पप्पू – फिर अपनी बायीं टाँग मोड़कर कमर सीधी करता हूँ,\n" +
                "तो भी दर्द होता है,\n" +
                "\n" +
                "डॉक्टर – अबे तो ऐसा ड्रामा करते ही क्यों हो?\n" +
                "\n" +
                "पप्पू – तो क्या अब मैं अपना “कच्छा” भी ना पहनूं \n" +
                "डॉक्टर बेहोश ...."));
        jokes.add(new Joke("5. पप्पू : ख़ुदकुशी पर भाषण दे रहा था .\n" +
                "\n" +
                "जज़्बाती हो कर कहने लगा\n" +
                "\n" +
                "ख़ुदकुशी हराम है , ज़ुल्म है , गुनाह है ,\n" +
                "\n" +
                "इस से बेहतर है के इंसान अपने आप को गोली मार दे ……"));
        jokes.add(new Joke("6. पप्पू के पास मोबाइल है + बैलेंस है\n" +
                "\n" +
                "पप्पू अपने दोस्त से : यार अपना मोबाइल तो देना\n" +
                "\n" +
                "तेरी भाभी को “I LOVE U” का SMS भेजना है....."));
        jokes.add(new Joke("7. पप्पू ट्रैन में सुसु कर के आया\n" +
                "\n" +
                "बीवी : आप का पायजामा गीला क्यों है ?\n" +
                "\n" +
                "पप्पू : टॉयलेट में लिखा है\n" +
                "\n" +
                "जिस्म का कोई भी हिस्सा बहार न निकले...."));
        jokes.add(new Joke("8. पप्पू को उसका सुसर जूते मार रहा था\n" +
                "\n" +
                "आदमी : क्यों मार रहे हो इसे\n" +
                "\n" +
                "सुसर : इसकी बीवी ने हॉस्पिटल से इसे SMS किया की तुम बाप बन गए हो .\n" +
                "\n" +
                "और इस नामुराद ने वो SMS अपने दोस्तों को फॉरवर्ड कर दिया....."));
        jokes.add(new Joke("9. भिखारी पप्पू से  :  मुझे खाने को कुछ मिल सकता है \n" +
                "पप्पू  :  कल की रोटी खा लोगे \n" +
                "भिखारी  :  जी हाँ .\n" +
                "पप्पू  :  अच्छा तो फिर कल टाइम से आ जाना....."));
        jokes.add(new Joke("10. पप्पू  :  स्टेशन जाने के कितने पैसे लोगे\n" +
                "\n" +
                "रिक्शा वाला  :  50\n" +
                "\n" +
                "पप्पू  :  20 ले लो\n" +
                "\n" +
                "रिक्शा वाला  :  20 में साहिब कौन ले कर जायेगा .\n" +
                "\n" +
                "पप्पू  :  तुम पीछे बेठो हम ले कर जायेगा....."));
        jokes.add(new Joke("11. एक बार पप्पू स्कीम वाली बोतल का ढक्कन बार बार खोल कर देख रहा था .\n" +
                "\n" +
                "किसी ने पूछा  :  क्या हुआ ?\n" +
                "\n" +
                "पप्पू  :  बोला ! ढक्कन मैं लिखा है  “Try Again“"));
        jokes.add(new Joke("12. पप्पू रो रहा था…!!!!\n" +
                "\n" +
                "दोस्त  :  क्यों रो रहे हो ?\n" +
                "पप्पू  :  मेरी मुर्गी मर गई .\n" +
                "\n" +
                "दोस्त  :  मेरा बाप मर गया मगर मैं तो नहीं रोया .\n" +
                "पप्पू  :  अरे , तेरा बाप क्या अंडे देता था....."));
        jokes.add(new Joke("13. टीचर: बस के ड्राइवर और कंडक्टर के बीच क्या फर्क है? \n" +
                "पप्पू: कंडक्टर सोया तो किसी का टिकट नहीं कटेगा और ड्राइवर सोया तो सबका टिकट कट जायेगा।"));
        jokes.add(new Joke("14. मास्टर जी- 1 अप्रैल को मुर्ख दिवस क्यों कहते है? \n" +
                "पप्पू- हिंदुस्तान की सबसे समझदार जनता, पूरे साल गधो की तरह कमा कर 31st मार्च को अपना सारा पैसा टैक्स मे सरकार को दे देती है।\n" +
                "और 1st अप्रैल से फिर से गधो की तरह सरकार के लिए पैसा कमाना शुरू कर देती है।\n" +
                "इस लिए 1st अप्रैल को मुर्ख दिवस कहते है।"));
        jokes.add(new Joke("15. पापाः बेटा तुम्हारे रिजल्ट का क्या हुआ? \n" +
                "पप्पुः पापा 80% आये है । \n" +
                "पापाः पर मार्कशीट पर 40% लिखा है? पप्पूः बाकी के 40% आधारकार्ड लिंक होनेपर सीधे अकाऊंट में आएंगे। \n" +
                "पापा बेहोश.."));
        jokes.add(new Joke("16. पप्पू कॉलेज की लड़की से बोला: “आई लव यू, अब तुम मुझे बोलो..” \n" +
                "\n" +
                "लड़की : “मैं अभी जा कर सर को बोलती हूँ” \n" +
                "\n" +
                "पप्पू : “पगली सर को मत बोल, उनकी तो शादी हो गयी है”"));
        jokes.add(new Joke("17. पप्पू की नौकरी चली गई… \n" +
                "\n" +
                "पप्पू रोज बॉस के घर के बाहर potti कर आता… \n" +
                "\n" +
                "बॉस:- ये क्या हरकत है..?? \n" +
                "\n" +
                "पप्पू:- ये बताना चाहता हूं कि.. भूखा नहीं मर रहा हूं…!!"));
        jokes.add(new Joke("18. पप्पू की हुई मास्टर से लड़ाई\n" +
                "मास्टर ने की पप्पू की पिटाई\n" +
                "\n" +
                "पप्पू का गरम हुआ खून..\n" +
                "\n" +
                "गया कब्रिस्तान और मास्टर की,\n" +
                "फोटो टांग के लिख दिया.... Coming Soon"));
        jokes.add(new Joke("19. पप्पू: सर जी लोग हिंदी या इंग्लिश में ही बात करते है। मैथ्स में क्यों नही..?\n" +
                "\n" +
                "टीचर:\n" +
                "ज्यादा 3-5 न कर, 9-2-11 हो जा, वरना 5-7 खीच के दूंगा,\n" +
                "6 के 36 नज़र आयेंगे और 32 के 32 बहार आ जायेंगे।\n" +
                "\n" +
                "पप्पू: बस सर….. हिंदी और इंग्लिश ही ठीक है। मैथ्स वाकई खोफनाक सब्जेक्ट है।।"));
        jokes.add(new Joke("20. पप्पू एक बार किसी कंपनी में जॉब के लिए इंटरव्यू देने गया\n" +
                "\n" +
                "मेनेजर: आपकी शादी हो गयी?\n" +
                "\n" +
                "पप्पू: जी हाँ, एक लड़की से हुई\n" +
                "\n" +
                "मेनेजर: शादी तो लड़की से ही होती है!!\n" +
                "\n" +
                "पप्पू: नहीं जी, मेरी बहिन की शादी तो लड़के से हुई है!"));

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