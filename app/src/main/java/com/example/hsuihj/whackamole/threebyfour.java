package com.example.hsuihj.whackamole;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class threebyfour extends AppCompatActivity {
    private ImageButton mol21, mol22, mol23, mol24, mol25, mol26, mol27, mol28, mol29, mol210, mol211, mol212;
    private int score, mole;
    private CountDownTimer timer;
    private ArrayList<ImageButton> buttons;
    private Random random;
    private TextView timetv, scoretv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_threebyfour);

        buttons = new ArrayList<>();
        random = new Random();
        score = 0;
        mole = 0;
        initializeGame();

        timer = new CountDownTimer(60000,1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                timetv.setText("Time: " + millisUntilFinished / 1000);
                buttons.get(mole).setVisibility(View.INVISIBLE);
                mole = random.nextInt(12);
                buttons.get(mole).setVisibility(View.VISIBLE);
            }

            @Override
            public void onFinish() {
                buttons.get(mole).setVisibility(View.INVISIBLE);
                timetv.setText("Time: 0");
                goback();
                displayScore();
            }
        }.start();
    }


    private void initializeGame(){
        mol21 = (ImageButton) findViewById(R.id.mol21);
        mol22 = (ImageButton) findViewById(R.id.mol22);
        mol23 = (ImageButton) findViewById(R.id.mol23);
        mol24 = (ImageButton) findViewById(R.id.mol24);
        mol25 = (ImageButton) findViewById(R.id.mol25);
        mol26 = (ImageButton) findViewById(R.id.mol26);
        mol27 = (ImageButton) findViewById(R.id.mol27);
        mol28 = (ImageButton) findViewById(R.id.mol28);
        mol29 = (ImageButton) findViewById(R.id.mol29);
        mol210 = (ImageButton) findViewById(R.id.mol210);
        mol211 = (ImageButton) findViewById(R.id.mol211);
        mol212 = (ImageButton) findViewById(R.id.mol212);

        timetv = (TextView) findViewById(R.id.textView2);
        scoretv = (TextView) findViewById(R.id.textView6);

        buttons.add(mol21);
        buttons.add(mol22);
        buttons.add(mol23);
        buttons.add(mol24);
        buttons.add(mol25);
        buttons.add(mol26);
        buttons.add(mol27);
        buttons.add(mol28);
        buttons.add(mol29);
        buttons.add(mol210);
        buttons.add(mol211);
        buttons.add(mol212);

        for (ImageButton imageButton : buttons){
            imageButton.setOnClickListener(buttonListener);
        }
    }

    private final View.OnClickListener buttonListener = new View.OnClickListener(){

        public void onClick(View v){
            score += 1;
            scoretv.setText(String.valueOf(score));
            buttons.get(mole).setVisibility(View.INVISIBLE);
        }
    };
    public void goback()  {
        Intent intent = new Intent(getApplicationContext(),goback.class);
        startActivity(intent);
    }
    public void displayScore() {
        Intent intent = new Intent(getApplicationContext(), goback.class);
        intent.putExtra("SCORE", score);
        startActivity(intent);
    }

}
