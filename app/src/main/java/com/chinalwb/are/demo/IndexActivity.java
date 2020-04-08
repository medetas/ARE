package com.chinalwb.are.demo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
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
        Button defaultToolbarButton = this.findViewById(R.id.defaultToolbar);
        openPage(defaultToolbarButton, ARE_DefaultToolbarActivity.class);

        Button fullBottomButton = this.findViewById(R.id.fullBottomButton);
        openPage(fullBottomButton, ARE_FullBottomActivity.class);

        Button fullTopButton = this.findViewById(R.id.fullTopButton);
        openPage(fullTopButton, ARE_FullTopActivity.class);

        Button minBottomButton = this.findViewById(R.id.minBottomButton);
        openPage(minBottomButton, ARE_MinBottomActivity.class);

        Button minTopButton = this.findViewById(R.id.minTopButton);
        openPage(minTopButton, ARE_MinTopActivity.class);

        Button minHideButton = this.findViewById(R.id.minHideButton);
        openPage(minHideButton, ARE_MinHideActivity.class);

        Button multipleInstanceButton = this.findViewById(R.id.multiInstanceButton);
        openPage(multipleInstanceButton, ARE_MultiInstanceActivity.class);

        Button openButton = this.findViewById(R.id.openButton);
       // openPage(openButton, ARE_DefaultToolbarActivity.class);
        openButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listFiles();
            }
        });

    }

    private void openPage(Button button, final Class activity) {
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(IndexActivity.this, activity);
                startActivity(intent);
            }
        });
    }

    private String readText(String input){
        File file = new File(input);
        StringBuilder text = new StringBuilder();
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line;
            while ((line = br.readLine()) != null) {
                text.append(line);
                text.append("\n");
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return text.toString();
    }

    private void listFiles(){
        Intent intent = new Intent(Intent.ACTION_OPEN_DOCUMENT);
        intent.addCategory(Intent.CATEGORY_OPENABLE);
        intent.setType("text/+");
    }
}
