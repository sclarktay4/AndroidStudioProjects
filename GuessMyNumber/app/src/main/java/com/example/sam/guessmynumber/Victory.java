package com.example.sam.guessmynumber;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.felipecsl.gifimageview.library.GifImageView;

import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Random;

/**
 * Created by Sam on 4/5/2017.
 */


public class Victory extends AppCompatActivity {


    private GifImageView gifImageView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_victory);

        gifImageView = (GifImageView)findViewById(R.id.gifImageView);

        try {
            InputStream inputstream = getAssets().open("giphytext.gif");
            byte[] bytes = IOUtils.toByteArray(inputstream);
            gifImageView.setBytes(bytes);
            gifImageView.startAnimation();
        }
        catch (IOException ex)
        {

        }

    }

}
