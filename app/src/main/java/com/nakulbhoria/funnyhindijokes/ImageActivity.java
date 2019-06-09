package com.nakulbhoria.funnyhindijokes;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class ImageActivity extends AppCompatActivity{
    ImageView imageView;
    Button button;
    SharedPreferences preferences;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.activity_image);
        final int i = getIntent().getExtras().getInt("i");
        imageView = findViewById(R.id.image);
        button = findViewById(R.id.button);

        imageView.setImageResource(i);

        preferences = getSharedPreferences("prefs", MODE_PRIVATE);
        final SharedPreferences.Editor editor = preferences.edit();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editor.putInt("value",i );
                editor.apply();

                Toast.makeText(ImageActivity.this, "Background Changed Successfully", Toast.LENGTH_SHORT).show();

                Intent i = new Intent(ImageActivity.this, MainActivity.class);
                startActivity(i);
                finish();

            }
        });




    }
}
