package com.example.classjournal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView lv;
    ArrayList<String> al;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lv = this.findViewById(R.id.listViewCode);
        al = new ArrayList<String>();
        al.add("C347");

        ArrayAdapter<String> aaModule;
        aaModule = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,al);
        lv.setAdapter(aaModule);



        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String module = al.get(position);

                Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                intent.putExtra("module", module);
                startActivity(intent);

            }
        });

    }
}

