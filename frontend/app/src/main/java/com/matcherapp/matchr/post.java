package com.matcherapp.matchr;

import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class post extends AppCompatActivity {

        @Override
        protected void onCreate(final Bundle savedInstanceState){
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_post);

            final Button submit = (Button) findViewById(R.id.submitBtn);
            submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    Intent submitIntent;
                    submitIntent = new Intent(getApplicationContext(), Navigation.class);
                    startActivity(submitIntent);
                }
            });

        ImageButton add = (ImageButton) findViewById(R.id.addImageButton);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
                    startActivityForResult(takePictureIntent, 1);
                }
            }
        });
    }

    }