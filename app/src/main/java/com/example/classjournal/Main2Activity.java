package com.example.classjournal;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class Main2Activity extends AppCompatActivity {

    int requestCode = 1;

    ListView lvInfoList;
    TextView tvWeek;
    TextView tvGrade;
    CustomAdapter caInfo;
    ArrayList<Class> infoList;


    Button btnInfo;
    Button btnAdd;
    Button btnEmail;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        tvWeek = findViewById(R.id.textViewWeek);
        tvGrade = findViewById(R.id.textViewGrade);
        lvInfoList = findViewById(R.id.listView);

        btnInfo = findViewById(R.id.btnInfo);
        btnEmail = findViewById(R.id.btnEmail);
        btnAdd = findViewById(R.id.btnAdd);

        infoList = new ArrayList<Class>();

        infoList.add(new Class("Week 1", "B"));
        infoList.add(new Class("Week 2", "C"));
        infoList.add(new Class("Week 3", "A"));

        caInfo = new CustomAdapter(this, R.layout.custom_row, infoList);
        lvInfoList.setAdapter(caInfo);

        //Email Button
        btnEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                // The action you want this intent to do;
                // ACTION_SEND is used to indicate sending text
                Intent email = new Intent(Intent.ACTION_SEND);
                // Put essentials like email address, subject & body text
                email.putExtra(Intent.EXTRA_EMAIL, new String[]{"jason_lim@rp.edu.sg"});
                email.putExtra(Intent.EXTRA_SUBJECT, "");
                email.putExtra(Intent.EXTRA_TEXT, "");
                // This MIME type indicates email
                email.setType("message/rfc822");
                // createChooser shows user a list of app that can handle
                // this MIME type, which is, email
                startActivity(Intent.createChooser(email, "Choose an Email client :"));
            }
        });


        //Info Button
        btnInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                // Intent to display data
                Intent rpIntent = new Intent(Intent.ACTION_VIEW);
                // Set the URL to be used.
                rpIntent.setData(Uri.parse("http://www.rp.edu.sg"));
                startActivity(rpIntent);
            }
        });

        //Add button
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Integer num = infoList.size() + 1;
                String week = "Week: " + num.toString();

                Intent i = new Intent(Main2Activity.this, Main3Activity.class);
                i.putExtra("week", week);
                startActivityForResult(i, requestCode);
            }
        });

        }

        @Override
        protected void onActivityResult(int requestCode, int resultCode, Intent data) {
            super.onActivityResult(requestCode, resultCode, data);

            Integer num = infoList.size() + 1;

            if (requestCode == RESULT_OK) {
                if (data != null) {
                    // Get data passed back from 2nd activity
                    String grade = data.getStringExtra("grade");
                    infoList.add(new Class("week: " + num.toString(), grade));
                    caInfo.notifyDataSetChanged();
                }
            }
        }
    }