package com.example.sam.connectfour;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    int activePlayer = 1;

    int[] gameState = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
                        0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};

    public int positionCheck (int tag)
    {
      while ( tag < 43)
        {

            tag = tag + 7;

        }
        return tag - 7;
    }

    public void dropIn(View view){

        ImageView counter = (ImageView) view;

        int tappedCounter = Integer.parseInt(counter.getTag().toString());

        if (gameState[tappedCounter] == 0)
        {

            //positionCheck(tappedCounter);
            tappedCounter = positionCheck(tappedCounter);
            System.out.println(tappedCounter);
                gameState[tappedCounter] = activePlayer;

                counter.setTranslationY(-1000f);

                if (activePlayer == 1) {

                    counter.setImageResource(R.drawable.yellow);

                    activePlayer = 2;
                } else {
                    counter.setImageResource(R.drawable.red);

                    activePlayer = 1;
                }


            counter.animate().translationYBy(1000f).setDuration(300);
        }


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
