package com.matcherapp.matchr;

import android.content.Intent;
import android.graphics.Bitmap;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

public class post extends AppCompatActivity {

    static final int REQUEST_IMAGE_CAPTURE = 1;
    ImageView uploadImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        uploadImageView = findViewById(R.id.uploadImageView);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post);

        final Button submit;

        submit = (Button)findViewById(R.id.submitButton);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent submitIntent;

                submitIntent = new Intent(getApplicationContext(), Navigation.class);

                startActivity(submitIntent);
            }
        });

        ImageButton add = (ImageButton)findViewById(R.id.addImageButton);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                if(takePictureIntent.resolveActivity(getPackageManager()) != null) {
                    startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
                    onActivityResult(REQUEST_IMAGE_CAPTURE, RESULT_OK, takePictureIntent);
                }
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        if(requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK){
            Bundle extras = data.getExtras();
            Bitmap imageBitmap = (Bitmap) extras.get("data");
            uploadImageView.setImageBitmap(imageBitmap);
        }
    }
}