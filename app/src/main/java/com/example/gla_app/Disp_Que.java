package com.example.gla_app;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;

import java.util.ArrayList;

public class Disp_Que extends AppCompatActivity{

    TextView tv[]= new TextView[4];
    Button next;
    TextView qv;
    ArrayList<Question> questions;
    int counter=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.disp_que);

        Intent it=getIntent();
        questions=(ArrayList<Question>) it.getSerializableExtra("list");
        int id[]={R.id.textView1, R.id.textView2, R.id.textView3, R.id.textView4,};

        for(int i=0; i<tv.length; i++)
            tv[i]=findViewById(id[i]);

        next=findViewById(R.id.button2);
        qv=findViewById(R.id.textView0);

        //////////////////////////////////////////////////////////////////////////////////////////

        qv.setText("Q"+String.valueOf(counter+1)+": "+questions.get(counter).getQue());

        for(int i=0; i<tv.length; i++)
            tv[i].setText(questions.get(counter).getOptions()[i]);

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                
                counter++;
                qv.setText("Q"+String.valueOf(counter+1)+": "+questions.get(counter).getQue());
                for(int i=0; i<tv.length; i++)
                    tv[i].setText(questions.get(counter).getOptions()[i]);
            }
        });

    }
}
