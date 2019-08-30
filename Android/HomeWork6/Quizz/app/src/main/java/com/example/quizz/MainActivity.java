package com.example.quizz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Question[] question = {
            new Question(R.string.Q1, true),
            new Question(R.string.Q2, true),
            new Question(R.string.Q3, true),
            new Question(R.string.Q4, true),
            new Question(R.string.Q5, false),
    };
    private int qindex = 0;
    private Button buttonTrue;
    private Button buttonFalse;
    private Button buttonNext;
    private Button buttonPrevious;
    private Button buttonStart;
    private Button buttonEnd;
    private TextView textViewQu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        if (savedInstanceState != null) {
            qindex = savedInstanceState.getInt("KEY_INDEX", 0);
        }

        buttonTrue = findViewById(R.id.trueBtn);
        buttonFalse = findViewById(R.id.falseBtn);
        buttonStart = findViewById(R.id.start);
        buttonEnd = findViewById(R.id.end);
        buttonNext = findViewById(R.id.next);
        buttonPrevious = findViewById(R.id.previous);
        textViewQu = findViewById(R.id.txtQuestion);
        textViewQu.setText(question[qindex].getQuestionid());
        buttonTrue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkanswer(true);
            }
        });
        buttonFalse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkanswer(false);
            }
        });
        buttonStart.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                qindex = 0;
                textViewQu.setText(question[qindex].getQuestionid());
            }
        });
        buttonEnd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                qindex = 4;
                textViewQu.setText(question[qindex].getQuestionid());
            }
        });
        buttonNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int i = (qindex + 1) % question.length;
                textViewQu.setText(question[i].getQuestionid());
                qindex++;
            }

        });

        buttonPrevious.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int i = (qindex - 1) % question.length;
                textViewQu.setText(question[i].getQuestionid());
                qindex--;

            }
        });
    }


    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("KEY_INDEX", qindex);
    }

    private void checkanswer(boolean ans) {
        if (question[qindex].isAnswer() == ans) {
            Toast.makeText(MainActivity.this, "درست جواب دادی", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(MainActivity.this, "غلط جواب دادی", Toast.LENGTH_LONG).show();

        }
    }



}