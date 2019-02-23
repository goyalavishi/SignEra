package com.linguistics.helpy;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.Slide;
import android.transition.TransitionInflater;
import android.view.Window;
import android.view.WindowManager;

public class SplashScreen extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE); //will hide the title
       // getSupportActionBar().hide(); // hide the title bar
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash_screen);

        Thread timer=new Thread(){
            public void run(){
                try{
                    sleep(2500);
                }
                catch(InterruptedException e){
                    e.printStackTrace();
                }
                finally {
                    Intent intent=new Intent(getApplicationContext(),HomeActivity.class);
                    startActivity(intent);



                }
            }
        };
        timer.start();
    }



    @Override
    protected void onPause(){
        super.onPause();
        finish();
        overridePendingTransition(R.anim.hold, R.anim.fadeout);


    }

}
