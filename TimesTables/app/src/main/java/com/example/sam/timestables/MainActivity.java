package com.example.sam.timestables;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView timesTableListView;

    public void generateTimesTable(int timesTable){


        final ArrayList<String> timesTableContent = new ArrayList<String>();
        ArrayList<String> timesTableShow = new ArrayList<String>();

        for (int i = 1; i <= 12; i++) {

            timesTableContent.add(Integer.toString(timesTable * i));
            timesTableShow.add(Integer.toString(timesTable)  + " * " + Integer.toString(i) + " =  ?");
        }

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_activated_1, timesTableShow);
       // ArrayAdapter<String> arrayAdapter1 = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_activated_1, timesTableContent);

        timesTableListView.setAdapter(arrayAdapter);

        timesTableListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Toast.makeText(getApplicationContext(), "The answer is " + timesTableContent.get(i),Toast.LENGTH_SHORT).show();
            }
        });



    }

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final SeekBar timesTableSeekBar = (SeekBar) findViewById(R.id.timesTableSeekBar);
        timesTableListView = (ListView) findViewById(R.id.timesTableListView);

        timesTableSeekBar.setMax(20);
        timesTableSeekBar.setProgress(10);

        timesTableSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener()
        {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b)
            {

                int min = 1;
                int timesTable;

                if (i < min )
                {

                    timesTable = min;
                    timesTableSeekBar.setProgress(min);

                }else
                {

                    timesTable = i;
                }

                generateTimesTable(timesTable);

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar)
            {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar)
            {

            }
        });

        generateTimesTable(10);
    }
}
