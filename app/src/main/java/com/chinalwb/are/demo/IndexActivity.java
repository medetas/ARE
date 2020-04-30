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
import android.widget.Toast;

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
//        openPage(defaultToolbarButton, ARE_DefaultToolbarActivity.class);
        defaultToolbarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(IndexActivity.this, ARE_DefaultToolbarActivity.class);
                startActivity(intent);
            }
        });



        LinearLayout openButton = this.findViewById(R.id.open);
//        openPage2(openButton, ARE_DefaultToolbarActivity.class);
        openButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(IndexActivity.this, TestRead.class);
//                intent.putExtra("fname", "Open");
                startActivityForResult(intent, 1);
            }
        });


        LinearLayout cameraButton = this.findViewById(R.id.camerabutton);
        cameraButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(IndexActivity.this, Camera.class);
                startActivity(intent);
            }
        });
    }

//    private void openPage(LinearLayout button, final Class activity) {
//        button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(IndexActivity.this, activity);
//                startActivity(intent);
//
//            }
//        });
//    }
////    private void openPage2(LinearLayout button, final Class activity) {
////        button.setOnClickListener(new View.OnClickListener() {
////            @Override
////            public void onClick(View v) {
////                Intent intent = new Intent(IndexActivity.this, activity);
////                intent.putExtra("fname", "Open");
////                startActivityForResult(intent, 1);
////
////            }
////        });
////    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1) {
            if (resultCode == RESULT_OK) {
                String result = data.getStringExtra("fname");
                //mEditText.fromHtml(mEditText.getHtml() + result);
                Intent intent = new Intent(IndexActivity.this, ARE_DefaultToolbarActivity.class);
                intent.putExtra("fname", result);
                startActivity(intent);
            }
            if (resultCode == RESULT_CANCELED) {
                Toast.makeText(this, "No file chosen", Toast.LENGTH_LONG).show();

            }
        }

    }

}
