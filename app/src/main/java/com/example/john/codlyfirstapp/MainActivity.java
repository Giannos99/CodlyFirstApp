package com.example.john.codlyfirstapp;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.support.annotation.DrawableRes;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import org.json.JSONArray;

import java.io.InputStream;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;


public class MainActivity extends Activity {

    private int current=0;
    private int endOfList;
    private TextView txtView;
    //private long starttime = 0;
    //private TextView timerValue;
    private ImageView img;

    private List<PicTuple> pictureList;
    MyTimerTask myTask = new MyTimerTask();
    Timer myTimer = new Timer();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        InputStream inputStream = getResources().openRawResource(R.raw.shiftingpattern);
        CSVFile csvFile = new CSVFile(inputStream);
        pictureList = csvFile.read();

        img= (ImageView) findViewById(R.id.image);
        img.setImageResource(R.drawable.house);
        txtView = (TextView) findViewById(R.id.MarqueeText);

        //int resourceId = this.getResources().getIdentifier("@string/marquee" , "string", this.getPackageName());
        //txtView.setText(resourceId);
        txtView.setText(getString(R.string.marquee));
        txtView.setTextColor(Color.parseColor("#FFFFFF"));
        //txtView.setSelected(true);
        txtView.setEnabled(true); // Thanks to Romain Guy
        myTimer.schedule(myTask, 0, pictureList.get(current).getTime() * 1000);
        //txtView.setText("START | firstText | END");
        //txtView.startAnimation(AnimationUtils.loadAnimation(MainActivity.this, android.R.anim.slide_in_left));
        //timerValue = (TextView) findViewById(R.id.timerValue);

        //JSONArray myPics = new JSONArray("")
    }

    @Override
    protected void onPause() {
        super.onPause();
//         myTimer.cancel();
    }

    @Override
    protected void onResume() {
        super.onResume();
        //do something


        endOfList = pictureList.size();




    }
    class MyTimerTask extends TimerTask {
        public void run() {
            // ERROR
            runOnUiThread(new Runnable() {
                @Override
                public void run() {


                    String picName = pictureList.get(current).getPic();
                    int id = getResources().getIdentifier("com.example.john.codlyfirstapp:drawable/" + picName, null, null);

                    img.setImageResource(id);


                    current++;
                    if(current == endOfList) {
                        current = 0;

                    }

                }
            });

            System.out.println("");
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
