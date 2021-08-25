package com.example.fabmenu;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.OvershootInterpolator;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private static final String TAG = "MainActivity";

    FloatingActionButton fabMain, fabOne, fabTwo, fabThree, fabFour, fabFive, fabSix;

    Float translationX = 50f;

    Float transX = -50f;

    Boolean isOpen = false;

    OvershootInterpolator interpolator = new OvershootInterpolator();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fabMain = findViewById(R.id.fabMain);
        fabOne = findViewById(R.id.fabOne);
        fabTwo = findViewById(R.id.fabTwo);
        fabThree = findViewById(R.id.fabThree);
        fabFour = findViewById(R.id.fabFour);
        fabFive = findViewById(R.id.fabFive);
        fabSix = findViewById(R.id.fabSix);

        fabOne.setTranslationX(translationX);
        fabTwo.setTranslationX(translationX);
        fabFive.setTranslationX(translationX);
        fabThree.setTranslationX(transX);
        fabFour.setTranslationX(transX);
        fabSix.setTranslationX(transX);


        fabOne.setAlpha(0f);
        fabTwo.setAlpha(0f);
        fabThree.setAlpha(0f);
        fabFour.setAlpha(0f);
        fabFive.setAlpha(0f);
        fabSix.setAlpha(0f);

        fabMain.setOnClickListener(this);
        fabOne.setOnClickListener(this);
        fabTwo.setOnClickListener(this);
        fabThree.setOnClickListener(this);
        fabFour.setOnClickListener(this);
        fabFive.setOnClickListener(this);
        fabSix.setOnClickListener(this);
    }

    private void handleOpen(){

        isOpen = !isOpen;

        fabMain.animate().rotation(45f).setInterpolator(interpolator).setDuration(300).start();

        fabOne.animate().translationX(0f).alpha(1f).setInterpolator(interpolator).setDuration(300).start();
        fabTwo.animate().translationX(0f).alpha(1f).setInterpolator(interpolator).setDuration(300).start();
        fabFive.animate().translationX(0f).alpha(1f).setInterpolator(interpolator).setDuration(300).start();
        fabThree.animate().translationX(0f).alpha(1f).setInterpolator(interpolator).setDuration(300).start();
        fabFour.animate().translationX(0f).alpha(1f).setInterpolator(interpolator).setDuration(300).start();
        fabSix.animate().translationX(0f).alpha(1f).setInterpolator(interpolator).setDuration(300).start();
    }

    private void handleClose(){

        isOpen = !isOpen;

        fabMain.animate().rotation(0f).setInterpolator(interpolator).setDuration(300).start();

        fabOne.animate().translationX(translationX).alpha(0f).setInterpolator(interpolator).setDuration(300).start();
        fabTwo.animate().translationX(translationX).alpha(0f).setInterpolator(interpolator).setDuration(300).start();
        fabFive.animate().translationX(translationX).alpha(0f).setInterpolator(interpolator).setDuration(300).start();
        fabThree.animate().translationX(transX).alpha(0f).setInterpolator(interpolator).setDuration(300).start();
        fabFour.animate().translationX(transX).alpha(0f).setInterpolator(interpolator).setDuration(300).start();
        fabSix.animate().translationX(transX).alpha(0f).setInterpolator(interpolator).setDuration(300).start();

    }

    @Override
    public void onClick(View view) {

        switch (view.getId()){

            case R.id.fabMain:

                Log.i(TAG, "onClick: fab main");

                if(isOpen) {
                    handleClose();
                } else {
                    handleOpen();
                }

                break;

            case R.id.fabOne:

                Log.i(TAG, "onClick: fab one");
                break;
                
        }
    }
}