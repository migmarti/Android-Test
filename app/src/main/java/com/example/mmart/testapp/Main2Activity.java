package com.example.mmart.testapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Button btn2Click = (Button) findViewById(R.id.buttonTest2);
        TextView txtView = (TextView) findViewById(R.id.textTest2);

        Intent intent = getIntent();
        String message = intent.getStringExtra("Mensaje");
        txtView.setText(message);

        btn2Click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}
