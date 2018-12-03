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

public class twobythree extends AppCompatActivity {
    private ImageButton mol11, mol12, mol13, mol14, mol15, mol16;
    /*private Button exit;*/
    private int score, mole;
    private CountDownTimer timer;
    private ArrayList<ImageButton> buttons;
    private Random random;
    private TextView timetv, scoretv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_twobythree);

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
                mole = random.nextInt(6);
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
        mol11 = (ImageButton) findViewById(R.id.mol11);
        mol12 = (ImageButton) findViewById(R.id.mol12);
        mol13 = (ImageButton) findViewById(R.id.mol13);
        mol14 = (ImageButton) findViewById(R.id.mol14);
        mol15 = (ImageButton) findViewById(R.id.mol15);
        mol16 = (ImageButton) findViewById(R.id.mol16);
        timetv = (TextView) findViewById(R.id.textView2);
        scoretv = (TextView) findViewById(R.id.textView6);

        buttons.add(mol11);
        buttons.add(mol12);
        buttons.add(mol13);
        buttons.add(mol14);
        buttons.add(mol15);
        buttons.add(mol16);

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
