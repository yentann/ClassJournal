package com.example.classjournal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import org.w3c.dom.Text;

public class Main3Activity extends AppCompatActivity {

    TextView DG;
    RadioGroup pass;
    Button Submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        DG = findViewById(R.id.textViewDG);
        pass = findViewById(R.id.RadioGroup);
        Submit = findViewById(R.id.buttonSubmit);

        Intent i = getIntent();

        String week = i.getStringExtra("week");
        DG.setText(week);


        //Submit Button
        Submit.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                int id = pass.getCheckedRadioButtonId();
                RadioButton rb = findViewById(id);
                final String grade = rb.getText().toString();

                //Create intent & pass in String data
                Intent i = new Intent();
                i.putExtra("grade", grade);

                // Set result to RESULT_OK to indicate normal response and pass in the intent containing the
                setResult(RESULT_OK, i);
                finish();
            }
        });
    }


}

