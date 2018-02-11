package com.matcherapp.matchr;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class voting extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_voting);

        final Button submit = (Button) findViewById(R.id.buttonv);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent submitIntent;
                submitIntent = new Intent(getApplicationContext(), Navigation.class);
                startActivity(submitIntent);
            }
        });
    }
}
