package com.example.sam.braingame;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    RelativeLayout gameLayout;
    RelativeLayout statsLayout;
    Button startButton;
    Button button0;
    Button button1;
    Button button2;
    Button button3;
    Button restartButton;
    TextView sumTextView;
    TextView resultTextView;
    TextView scoreTextView;
    TextView timerTextView;
    TextView statsTextView;
    ArrayList<Integer> answers = new ArrayList<Integer>();
    int locationOfCorrectAnswer;
    int score = 0;
    int numberOfQuestions = 0;
    float stat;

    public void playAgain(View view) {

        score = 0;
        numberOfQuestions = 0;
        timerTextView.setText("30s");
        scoreTextView.setText("0/0");
        resultTextView.setText("");
        restartButton.setVisibility(View.INVISIBLE);
        statsTextView.setVisibility(View.INVISIBLE);
        gameLayout.setVisibility(View.VISIBLE);

        generateQuestion();

        new CountDownTimer(30100, 1000) {


            @Override
            public void onTick(long l) {

                timerTextView.setText(String.valueOf(l/1000) + "s");

            }

            @Override
            public void onFinish() {
                stat = (((float)score/(float)numberOfQuestions) * 100);
                timerTextView.setText("0s");
                resultTextView.setText("Your score: " + Integer.toString(score) + "/" + Integer.toString(numberOfQuestions));
                gameLayout.setVisibility(View.INVISIBLE);
                statsTextView.setVisibility(View.VISIBLE);
                statsTextView.setText(String.valueOf(Math.round(stat)) + "%");

                restartButton.setVisibility(View.VISIBLE);


            }
        }.start();

    }

    public void generateQuestion() {

        Random rand = new Random();

        int a = rand.nextInt(21);
        int b = rand.nextInt(21);

        sumTextView.setText(Integer.toString(a)+ " + " + Integer.toString(b));

        locationOfCorrectAnswer = rand.nextInt(4);

        answers.clear();

        int incorrectAnswer;

        for (int i = 0; i < 4; i++) {

            if (i == locationOfCorrectAnswer) {

                answers.add(a + b);
            }
            else {

                incorrectAnswer = rand.nextInt(41);

                while (incorrectAnswer == a + b) {

                    incorrectAnswer = rand.nextInt(41);
                }

                answers.add(incorrectAnswer);
            }
        }

        button0.setText(Integer.toString(answers.get(0)));
        button1.setText(Integer.toString(answers.get(1)));
        button2.setText(Integer.toString(answers.get(2)));
        button3.setText(Integer.toString(answers.get(3)));

    }

    public void chooseAnswer(View view) {

        if (view.getTag().toString().equals(Integer.toString(locationOfCorrectAnswer))) {

            score++;
            resultTextView.setText("Correct!");

        }
        else {
            resultTextView.setText("Wrong!");
        }

        numberOfQuestions++;
        scoreTextView.setText(Integer.toString(score) + "/" + Integer.toString(numberOfQuestions));
        generateQuestion();
    }

    public void start(View view) {

        startButton.setVisibility(View.INVISIBLE);
        gameLayout.setVisibility(View.VISIBLE);

        playAgain(findViewById(R.id.restartButton));

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        startButton = (Button)findViewById(R.id.startButton);
        sumTextView = (TextView)findViewById(R.id.sumTextView);
        button0 = (Button)findViewById(R.id.button2) ;
        button1 = (Button)findViewById(R.id.button3) ;
        button2 = (Button)findViewById(R.id.button4) ;
        button3 = (Button)findViewById(R.id.button5) ;
        resultTextView = (TextView)findViewById(R.id.resultTextView) ;
        scoreTextView = (TextView)findViewById(R.id.scoreTextView) ;
        timerTextView = (TextView)findViewById(R.id.timerTextView) ;
        statsTextView = (TextView)findViewById(R.id.statsTextView) ;
        restartButton = (Button)findViewById(R.id.restartButton);
        gameLayout = (RelativeLayout)findViewById(R.id.gameLayout) ;
        statsLayout = (RelativeLayout)findViewById(R.id.statsLayout);

    }
}
