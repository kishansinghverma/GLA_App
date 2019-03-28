package com.example.gla_app;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Button btn;
    SharedPreferences sp;
    ArrayList<Question> questions;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        questions=new ArrayList<>();
        Question q1 = new Question();
        q1.setQue("UI Means?");
        q1.setOptions(new String[]{"User Interface","User Interaction", "Useful Interaction", "User Identification"});
        q1.setMarks(5);
        q1.setCorrect(1);

        Question q2 = new Question();
        q2.setQue("Business Logic Is Stored in which file?");
        q2.setOptions(new String[]{".xml file",".java file", ".html file", "None of these"});
        q2.setMarks(5);
        q2.setCorrect(2);

        Question q3 = new Question();
        q3.setQue("Which of following is not a programming language?");
        q3.setOptions(new String[]{"Python","Ruby", "HTML", "PHP"});
        q3.setMarks(5);
        q3.setCorrect(3);

        Question q4 = new Question();
        q4.setQue("AI Stands for?");
        q4.setOptions(new String[]{"Auto Input","Auto Intelligence", "Artificial Input", "Artificial Intelligence"});
        q4.setMarks(5);
        q4.setCorrect(4);

        Question q5 = new Question();
        q5.setQue("Which language other than java is used for android developement?");
        q5.setOptions(new String[]{"Kotlin","Perl", "Ruby", ".Net"});
        q5.setMarks(5);
        q5.setCorrect(1);

        questions.add(q1);
        questions.add(q2);
        questions.add(q3);
        questions.add(q4);
        questions.add(q5);

        sp=getSharedPreferences("com.example.gla_app", MODE_PRIVATE);
        SharedPreferences.Editor edt=sp.edit();

        edt.putString("user","188429023");
        edt.putString("pass", "145789632");
        edt.apply();

        btn=findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sp=getSharedPreferences("com.example.gla_app", MODE_PRIVATE);
                String s_user=sp.getString("user", null);
                String s_pass=sp.getString("pass", null);

                if (((EditText)findViewById(R.id.editText)).getText().toString().equals(s_user) && ((EditText)findViewById(R.id.editText2)).getText().toString().equals(s_pass))
                {
                    Intent it=new Intent(MainActivity.this, Disp_Que.class);

                    it.putExtra("list", questions);

                    startActivity(it);

                }
                else
                    Toast.makeText(MainActivity.this, "Login failed", Toast.LENGTH_SHORT).show();

            }
        });

    }


}
