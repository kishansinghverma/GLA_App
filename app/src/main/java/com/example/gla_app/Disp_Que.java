package com.example.gla_app;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.TextView;

import java.util.ArrayList;

public class Disp_Que extends AppCompatActivity{

    RadioButton btn[]= new RadioButton[4];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.disp_que);


        Intent it=getIntent();

        ArrayList<Question> questions=(ArrayList<Question>) it.getSerializableExtra("list");

        ((TextView)findViewById(R.id.textView0)).setText(questions.get(0).getQue());
        ((TextView)findViewById(R.id.textView1)).setText(questions.get(0).getOptions()[0]);
        ((TextView)findViewById(R.id.textView2)).setText(questions.get(0).getOptions()[1]);
        ((TextView)findViewById(R.id.textView3)).setText(questions.get(0).getOptions()[2]);
        ((TextView)findViewById(R.id.textView4)).setText(questions.get(0).getOptions()[3]);


    }
}
