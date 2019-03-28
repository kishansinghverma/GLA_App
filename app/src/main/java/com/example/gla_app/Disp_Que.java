package com.example.gla_app;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class Disp_Que extends AppCompatActivity{

    RadioButton rb[]= new RadioButton[4];
    RadioGroup rg;
    Button next;
    TextView qv;
    ArrayList<Question> questions;
    int counter=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_disp_que);

        Intent intent=getIntent();
        questions=(ArrayList<Question>) intent.getSerializableExtra("list");
        int id[]={R.id.radioButton1, R.id.radioButton2, R.id.radioButton3, R.id.radioButton4,};

        for(int i=0; i<rb.length; i++) {
            rb[i] = findViewById(id[i]);
            rb[i].setId(i+1);
        }


        next=findViewById(R.id.button2);
        qv=findViewById(R.id.textView0);
        rg=findViewById(R.id.radiogroup);


        //////////////////////////////////////////////////////////////////////////////////////////

        qv.setText("Q"+String.valueOf(counter+1)+": "+questions.get(counter).getQue());

        for(int i=0; i<rb.length; i++)
            rb[i].setText(questions.get(counter).getOptions()[i]);

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                questions.get(counter).setSelected(rg.getCheckedRadioButtonId());
                if(counter<questions.size()-1) {
                    counter++;
                    rg.clearCheck();
                    qv.setText("Q" + String.valueOf(counter + 1) + ": " + questions.get(counter).getQue());

                    for (int i = 0; i < rb.length; i++)
                        rb[i].setText(questions.get(counter).getOptions()[i]);

                    if(counter==questions.size()-1)
                        next.setText("Submit");

                }
                else
                    startActivity(new Intent(Disp_Que.this, Result.class).putExtra("list", questions));
            }
        });

    }
}
