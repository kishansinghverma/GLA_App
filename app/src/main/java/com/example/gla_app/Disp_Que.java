package com.example.gla_app;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Disp_Que extends AppCompatActivity{

    RadioButton rb[]= new RadioButton[4];
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
        int id[]={R.id.radioButton1, R.id.radioButton2, R.id.radioButton3, R.id.radioButton4,};

        for(int i=0; i<rb.length; i++)
            rb[i]=findViewById(id[i]);

        next=findViewById(R.id.button2);
        qv=findViewById(R.id.textView0);

        //////////////////////////////////////////////////////////////////////////////////////////

        qv.setText("Q"+String.valueOf(counter+1)+": "+questions.get(counter).getQue());

        for(int i=0; i<rb.length; i++)
            rb[i].setText(questions.get(counter).getOptions()[i]);

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(counter<questions.size()-1) {
                    counter++;
                    qv.setText("Q" + String.valueOf(counter + 1) + ": " + questions.get(counter).getQue());
                    for (int i = 0; i < rb.length; i++)
                        rb[i].setText(questions.get(counter).getOptions()[i]);

                    if(counter==questions.size()-1)
                        next.setText("Submit");
                }
                else
                    startActivity(new Intent(Disp_Que.this, Result.class));
            }
        });

    }
}
