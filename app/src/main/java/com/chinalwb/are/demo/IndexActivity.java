package com.chinalwb.are.demo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.chinalwb.are.glidesupport.GlideApp;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class IndexActivity extends AppCompatActivity {
    Button openButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_index);


        initViews();

       }

    private void initViews() {
        LinearLayout defaultToolbarButton = this.findViewById(R.id.defaultToolbar);
        openPage(defaultToolbarButton, ARE_DefaultToolbarActivity.class);



        LinearLayout openButton = this.findViewById(R.id.open);
        openPage2(openButton, ARE_DefaultToolbarActivity.class);

        LinearLayout cameraButton = this.findViewById(R.id.camerabutton);
        cameraButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(IndexActivity.this, Camera.class);
                startActivity(intent);
            }
        });
    }

    private void openPage(LinearLayout button, final Class activity) {
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(IndexActivity.this, activity);
                intent.putExtra("fname", "New");
                startActivity(intent);

            }
        });
    }
    private void openPage2(LinearLayout button, final Class activity) {
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(IndexActivity.this, activity);
                intent.putExtra("fname", "Open");
                startActivity(intent);

            }
        });
    }

}
