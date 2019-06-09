package com.nakulbhoria.funnyhindijokes;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.TextView;

public class ContactActivity extends AppCompatActivity{
    TextView contactUs,aboutUs, privacy;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    super.setContentView(R.layout.activity_privacy);


    aboutUs = findViewById(R.id.contact);
    privacy = findViewById(R.id.privacy);
    contactUs = findViewById(R.id.textView3);

    String contactText = contactUs.getText().toString();
    String aboutUsText2 = aboutUs.getText().toString();
    String privacyText = privacy.getText().toString();

        SpannableString ssPrivacy = new SpannableString(privacyText);
        SpannableString ssContact = new SpannableString(contactText);
        SpannableString ssAbout = new SpannableString(aboutUsText2);

        ClickableSpan clickableSpanPrivacy = new ClickableSpan() {
            @Override
            public void onClick(View widget) {

                startActivity(new Intent(Intent.ACTION_VIEW,
                        Uri.parse("https://www.funny-jokes.in.net/p/priva.html")));

            }
        };

        ClickableSpan clickableSpanContact2 = new ClickableSpan() {
            @Override
            public void onClick(View widget) {

                startActivity(new Intent(Intent.ACTION_VIEW,
                        Uri.parse("https://www.funny-jokes.in.net/p/contact.html")));

            }
        };

        ClickableSpan clickableSpanContactEmail = new ClickableSpan() {
            @Override
            public void onClick(View widget) {

                String[] recipient = {"nakulbhoria63845@gmail.com"};
                Intent emailIntent = new Intent(Intent.ACTION_SEND);
                emailIntent.setData(Uri.parse("mailto:"));
                emailIntent.setType("text/plain");
                emailIntent.putExtra(Intent.EXTRA_EMAIL, recipient);
                emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Funny Hindi Jokes App Support");

                try{
                    startActivity(Intent.createChooser(emailIntent, "Send mail..."));
                    finish();
                }catch (ActivityNotFoundException e){

                }
            }
        };
        ClickableSpan clickableSpanAbout = new ClickableSpan() {
            @Override
            public void onClick(View widget) {

                startActivity(new Intent(Intent.ACTION_VIEW,
                        Uri.parse("https://www.funny-jokes.in.net")));

            }
        };

        ClickableSpan clickableSpanAbout2 = new ClickableSpan() {
            @Override
            public void onClick(View widget) {

                startActivity(new Intent(Intent.ACTION_VIEW,
                        Uri.parse("https://www.funny-jokes.in.net")));
            }
        };

        ssAbout.setSpan(clickableSpanAbout2,8 ,30 ,Spanned.SPAN_EXCLUSIVE_EXCLUSIVE );
        ssAbout.setSpan(clickableSpanAbout,41 ,63 ,Spanned.SPAN_EXCLUSIVE_EXCLUSIVE );
        ssPrivacy.setSpan(clickableSpanPrivacy, 5, 19, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        ssContact.setSpan(clickableSpanContactEmail, 26, 52, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        ssContact.setSpan(clickableSpanContact2, 74, 78, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);


        aboutUs.setText(ssAbout);
        aboutUs.setMovementMethod(LinkMovementMethod.getInstance());
        contactUs.setText(ssContact);
        contactUs.setMovementMethod(LinkMovementMethod.getInstance());
        privacy.setText(ssPrivacy);
        privacy.setMovementMethod(LinkMovementMethod.getInstance());

    }
}
