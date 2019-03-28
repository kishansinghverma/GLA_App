package com.example.gla_app;

import android.content.Intent;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.TextView;

import java.io.Serializable;
import java.util.ArrayList;

public class que1 extends AppCompatActivity{

    RadioButton btn[]= new RadioButton[4];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_que1);


        Intent it=getIntent();

        ArrayList<Question> questions=(ArrayList<Question>) it.getSerializableExtra("list");

        ((TextView)findViewById(R.id.textView2)).setText(questions.get(0).getQue());
        btn[0].setText(questions.get(0).getOptions()[0]);
        btn[1].setText(questions.get(0).getOptions()[1]);
        btn[2].setText(questions.get(0).getOptions()[2]);
        btn[3].setText(questions.get(0).getOptions()[3]);

    }
}
