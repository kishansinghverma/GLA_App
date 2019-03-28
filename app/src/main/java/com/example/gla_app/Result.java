package com.example.gla_app;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;

public class Result extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        Intent intent=getIntent();

        ArrayList<Question> questions= (ArrayList<Question>) intent.getSerializableExtra("list");

        StringBuffer str=new StringBuffer();

        for(Question x:questions)
            str.append(String.valueOf(x.getSelected())+" ");

        ((TextView)findViewById(R.id.textView2)).setText(str);

    }
}
