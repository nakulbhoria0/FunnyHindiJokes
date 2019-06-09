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
public class BestFunnyJokesFragment extends Fragment implements NativeAdsManager.Listener {

    final ArrayList<Joke> jokes = new ArrayList<>();
    private NativeAdsManager mNativeAdsManager;
    private RecyclerView listView;
    private int num =1;

    public BestFunnyJokesFragment() {
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
        jokes.add(new Joke("1. मेरी रूह का परिंदा फड़फड़ाये,\nलेकिन सकून का जजीरा मिल न पाए\n\nप्रश्न: इस कविता में, कवि कहाँ है और क्या कर रहा है?\n\nउत्तर: इस कविता में कवि wine shop के बाहर खड़ा है और उसका नवरात्रि का व्रत है़."));
        jokes.add(new Joke("2. सत्तर वर्ष की उम्र पूरी करने के बाद एक बुड्ढा,\nप्रत्येक एक वर्ष बीतने पर, अपनी ही पत्नी से शादी करता था…..!\n\nिना किसी रोक-टोक के सारा कार्यक्रम सम्पन्न हो जाता,\nऔर फिर अगले वर्ष सब कुछ वैसे ही दोहराया जाता…….!!\n\nपूरे गाँव में ये बात कौतुहल का विषय बन गयी……???\n\nआखिर में जब एक व्यक्ति से नहीं रहा गया तो उसने पूछ ही लिया:—\n\nबुढ़ऊ….ये क्या बात हूंई,\nकी तुम हर साल ब्याह करते हो….\nहर साल फेरे लेते हो……\n\nबुड्ढा बोला :— “बस एक ही शब्द” सुनने की खातिर…….!!!!\n\n“कौन सा शब्द..”?\n\nवहीं जब पंडित जी कहते हैं कि……..\n\nलड़के को बुलाओ\n\n.”बस……कसम से मजा आ जाता है…….!!!!"));
        jokes.add(new Joke("3. प्रिय दिसंबर,\nतुम कृपा वापिस आ जाओ, तुम तो सिर्फ नहाने नहीं देते थे। जनवरी\n\n.\n\n.\n\nतो हाथ भी धोने नहीं दे रहा।…\n\nआजकल तो धूप भी मोहल्ले की सबसे खूबसूरत लड़की जैसी हो गई है …..\n\nदिखती कम है .\nऔर जब दिखती है तो सारा मोहल्ला बाहर निकल आता है"));
        jokes.add(new Joke("4. पेन खो जाए तो नया ले सकते हैँ\n" +
                "लेकिन उसका ढक्कन खो जाए तो नया नही ले सकते है..\n" +
                "\n" +
                "इसलिए जीवन मेँ एक बात हमेशा याद रखना!\n" +
                "\n" +
                "पेन हमेशा टिचुक-टिचुक वाला ही लेना!!"));
        jokes.add(new Joke("5. मेरे एक शुभचिंतक ने मुझे यह सुझाव दिया –\n" +
                "कि wife से बहस से नहीं जीतो,\n" +
                "बल्कि अपनी मुस्कान से हराओ।\n" +
                "\n" +
                "मैंने प्रयास किया ••••••\n" +
                "\n" +
                "Wife बोली-\n" +
                "बहुत ज्यादा हंसी आ रही है तुमको आजकल??\n" +
                "लगता है तुम्हारा भूत उतारना पड़ेगा ।।"));
        jokes.add(new Joke("6. सभी लोग इंतज़ार कर रहे है कि\n" +
                "\n" +
                "सनी लिओनी KBC में आयें\n" +
                "और अमिताभ ये कहे कि…\n" +
                "\n" +
                "आइये देखते है..\n" +
                "\n" +
                "इनके जीवन से जुड़ा दिलचस्प वीडियो.. !!"));
        jokes.add(new Joke("7. पुलिस ट्रेनिंग के दौरान , अफसर ने पूछा : ‘ये हाथ में क्या है ?’\n" +
                "\n" +
                "सुरेश : “सर , बन्दूक है …!”\n" +
                "\n" +
                "अफसर : “ये बन्दूक नहीं ! तुम्हारी इज़्ज़त है , शान है , ये तुम्हारी माँ है माँ . !!”\n" +
                "\n" +
                "फिर अफसर ने दूसरे सिपाही रमेश से पूछा : “ये हाथ में क्या है ?”\n" +
                "\n" +
                "रमेश : “सर , ये सुरेश की माँ है , उसकी इज़्ज़त है , उसकी शान है और हमारी मौसी है मौसी ..!\n" +
                "\n" +
                "सर बेहोश"));
        jokes.add(new Joke("8. कुछ नियम, जो न्यूटन भी न बता पाए…!!!\n" +
                "\n" +
                "*नियम 1*\n" +
                "अगर ब्रेड आपके हाथ से छूट जाये तो जमीन पर उसी तरफ से गिरेगा जिस तरफ मक्खन लगा हो !\n" +
                "\n" +
                "*नियम 2*\n" +
                "जब आपके हाथ ग्रीस या आटे से पूरी तरह सन चुके होंगे, तभी आपकी नाक में खुजली शुरू हो जाएगी !\n" +
                "\n" +
                "*नियम 3*\n" +
                "टेलीफोन का नियम, जब भी आप कोई राँग नम्बर डायल करेंगे, वह एन्गेज कभी नहीं मिलेगा।\n" +
                "\n" +
                "*नियम 4*\n" +
                "whats app पर जब कोई मेसेज गलत ग्रुप में पोस्ट हो जाये उस वक्त नेट सबसे तेज चलता है…\n" +
                "आपकी लाख कोशिश के बावजूद वह पलक झपकते ही पहुँच जाता है… और सही पोस्ट पर पहले 2 – 3 मिनट तक डमरू घूमता रहता है… उसके बाद ही मैसेज पहुँच पाता है !\n" +
                "\n" +
                "*नियम 5*\n" +
                "यदि आप एक लाइन में भीड़ देखकर किसी दूसरी लाइन में चले जाएं, तो वह लाइन तेज़ गति से आगे बढ़ने लगेगी, जिसमें आप पहले खड़े थे !"));
        jokes.add(new Joke("9. अटल सत्य:\n" +
                "\n" +
                "पढाई और “जिम” हमेशा\n" +
                "कल से “शुरू” होते है।…????\n" +
                "और\n" +
                "सिगरेट और दारू\n" +
                "कल से “बंद”…\n" +
                "\n" +
                "( व्हाट्सअप यूनिवर्सिटी की खोज )"));
        jokes.add(new Joke("10. आँख का डॉक्टर :\n" +
                "(लेडी पेशेंट की आँखें चैक करते हुए)\n" +
                "\n" +
                "डॉक्टर :\n" +
                "मैडम….अपने हसबेंड को जैसे देखती हो वैसे देखो।\n" +
                "\n" +
                "लेडी : लेकिन क्यों ?\n" +
                "डॉक्टर : आँखों मे आई ड्राप डालना है!"));
        jokes.add(new Joke("11. पत्नी ने पति से पूछा\n" +
                "\n" +
                "पत्नी :\n" +
                "अच्छा यह बताओ\n" +
                "कि तुम मूर्ख हो या मैं ???\n" +
                "\n" +
                "पति : (शान्त मन से)\n" +
                "प्रिये यह बात तो सब लोग\n" +
                "जानते हैं कि तुम अत्यन्त तीव्र\n" +
                "बुद्धि की स्वामिनी हो\n" +
                "इसलिए यह कभी हो ही नहीं\n" +
                "सकता कि तुम किसी मूर्ख\n" +
                "व्यक्ति से शादी करो\n" +
                "\n" +
                "भाई का नाम आगे राष्ट्रपति पुरस्कार\n" +
                "के लिए भेजा गया है"));
        jokes.add(new Joke("12. एक होनहार महिला पहलीबार स्कुटी चलाकर पेट्रोल पम्प पर गई…\n" +
                "\n" +
                "भईया । पेट्रोल कितने रूपये लीटर है\n" +
                ".\n" +
                "मैडम 73.74 रूपये\n" +
                ".\n" +
                "ठीक ठाक लगा लो , बगल वाला तो 65.71 रुपये लीटर दे रहा है ?\n" +
                "\n" +
                "घोर सन्नाटा\n" +
                "(ओ मेडम, बाजू में डीजल की मशीन हे. )"));
        jokes.add(new Joke("13. शर्मा जी :\n" +
                "तेरी बीवी कल क्यु ज़ोर ज़ोर से चिल्ला रही थी ?????\n" +
                "उसकी आवाज़ मेरे घर तक आ रही थी …..\n" +
                "\n" +
                "वर्मा जी :\n" +
                "अरे, यार ऐसी कोई ख़ास बात नही थी,\n" +
                "उसकी फोटो फ़ेसबुक पे अपलोड करने की जगह …..\n" +
                "OLX पे अपलोड हो गयी।\n" +
                "\n" +
                "ओर हद तो तब हो गई\n" +
                "जब एक लड़के ने कहा: “भाई ये 1960 का कबाड किसने डाला हैं?”"));
        jokes.add(new Joke("14. पल्स पोलिओ टीम घर आयी…\n" +
                "संता (बीबी से): बंदूक और कारतुस कहाँ हैं…??\n" +
                "\n" +
                "टीम भागी,\n" +
                "पीछे से संता ने आवाज दी,\n" +
                "\n" +
                "रुको\n" +
                "ओये रुको\n" +
                "ये हमारे बच्चो के नाम हैं.!! "));
        jokes.add(new Joke("15. बेटा (पापा से): कार की चाबी दो, कॉलेज जाना हे फंक्सन हे .\n" +
                "पापा : क्यों ?\n" +
                "\n" +
                "बेटा : 10 लाख की गाड़ी में जाऊंगा तो शान रहेगी .\n" +
                "\n" +
                "पापा: ये ले 10 रूपए, 30 लाख की बस में जायेगा तो ज्यादा शान रहेगी!!"));
        jokes.add(new Joke("16. पति : मुन्ना कब से रो रहा है।\n" +
                "इसे लोरी सुनाकर सुला क्यों नहीं देती?\n" +
                "\n" +
                "पत्नी :\n" +
                "लोरी सुनाती हूं तो पड़ोसी कहते हैं कि\n" +
                "भाभी जी इससे अच्छा तो मुन्ने को ही रोने दो."));
        jokes.add(new Joke("17. कक्षा दसवीं की परीक्षा मे प्रश्न पूछा गया –\n" +
                "“माल्यार्पण करना” का अर्थ बताओ\n" +
                "\n" +
                "होनहार छात्र ने लिखा –\n" +
                "\n" +
                "सरकारी बैँकोँ द्वारा गरीब जनता की\n" +
                "गाढी कमाई माल्या को अर्पण\n" +
                "करने को ही माल्यार्पण कहते है।\n" +
                "\n" +
                "और बच्चा सीधे MBA के लिये सेलेक्ट हो गया।!!!"));
        jokes.add(new Joke("18. रामजी घर छोड़ गए तो मर्यादा पुरूषोत्तम बन गए।\n" +
                "\n" +
                "कृष्ण घर छोड़ गए तो कर्मयोगी और जगतगुरू बन गए।\n" +
                "\n" +
                "सिद्धार्थ घर छोड़ गए तो गौतम बुद्ध बन गए।\n" +
                "\n" +
                "गांधीजी घर छोड़ गए तो महात्मा और राष्ट्रपिता बन गए।\n" +
                "\n" +
                "मोदी जी घर छोड़ गए तो PM बन गए।\n" +
                "\n" +
                "योगी घर छोड़ गए तो CM बन गए।\n" +
                "\n" +
                "घर छोड़ दो रे , बहुत स्कोप है ।"));
        jokes.add(new Joke("19. मेरा नेपाली नौकर कल मेरे पास आया और बोला शाबजी-\n" +
                "“सीरीया का बाशाह मर गया .!!”\n" +
                "\n" +
                "मैं बड़ा खुश हुआ चलो ISIS ka खात्मा हुआ …..\n" +
                "\n" +
                "मैंने टीवी चैनल देखा ….\n" +
                "किसी न्यूज़ में ऐसी कोई खबर नहीं था\n" +
                "एक घंटे बाद मैं अपने बगीचे में गया\n" +
                "और …..\n" +
                "वहा मुझे पता चला कि वो कह रहा था कि ….\n" +
                "“चिडिया का बच्चा मर गया”!!!"));
        jokes.add(new Joke("20. पत्नी अंग्रेजी की किताब पढ़ रही थी.\n" +
                "\n" +
                "उसने अपने पति से पूछा:\n" +
                "अजी सुनिए, ये Complete और Finish में क्या फर्क होता है?\n" +
                "\n" +
                "पति:\n" +
                "अगर शादी सही लड़की से हो गयी तो समझो की जिंदगी Complete\n" +
                "और अगर गलत लड़की से हो गयी तो समझो की जिंदगी Finish…"));

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