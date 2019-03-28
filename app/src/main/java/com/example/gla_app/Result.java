package com.example.gla_app;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;

public class Result extends AppCompatActivity {

    TextView qv[] = new TextView[5];
    TextView rv[] = new TextView[5];
    TextView sv[] = new TextView[5];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        Intent intent=getIntent();
        ArrayList<Question> questions= (ArrayList<Question>) intent.getSerializableExtra("list");
        int marks=0;

        int qid[]={R.id.q1, R.id.q2, R.id.q3, R.id.q4, R.id.q5};
        int rid[]={R.id.r1, R.id.r2, R.id.r3, R.id.r4, R.id.r5};
        int sid[]={R.id.s1, R.id.s2, R.id.s3, R.id.s4, R.id.s5};

        for(int i=0; i<qv.length; i++) {

            qv[i]=findViewById(qid[i]);
            qv[i].setText("Q"+String.valueOf(i+1)+": "+questions.get(i).getQue());
            rv[i]=findViewById(rid[i]);
            rv[i].setText("Right Option: "+questions.get(i).getCorrect());
            sv[i]=findViewById(sid[i]);

            if(questions.get(i).getSelected()==-1){
                sv[i].setText("Selected Option: None");
                sv[i].setTextColor(getResources().getColor(android.R.color.holo_orange_light));
            }
            else {
                if (questions.get(i).getSelected() == questions.get(i).getCorrect()) {
                    marks++;
                    sv[i].setText("Selected Option: " + questions.get(i).getSelected());
                    sv[i].setTextColor(getResources().getColor(android.R.color.holo_green_dark));
                } else {
                    sv[i].setText("Selected Option: " + questions.get(i).getSelected());
                    sv[i].setTextColor(getResources().getColor(android.R.color.holo_orange_dark));
                }
            }

            ((TextView)findViewById(R.id.textView12)).setText("Your Result: "+String.valueOf(marks)+" / 5");
        }




    }
}
