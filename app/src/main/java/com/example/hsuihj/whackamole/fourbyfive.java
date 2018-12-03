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

public class fourbyfive extends AppCompatActivity {
    private ImageButton mol31, mol32, mol33, mol34, mol35, mol36, mol37, mol38, mol39, mol310, mol311, mol312, mol313, mol314, mol315, mol316, mol317, mol318, mol319, mol320;
    private int score, mole;
    private CountDownTimer timer;
    private ArrayList<ImageButton> buttons;
    private Random random;
    private TextView timetv, scoretv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fourbyfive);

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
                mole = random.nextInt(20);
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
        mol31 = (ImageButton) findViewById(R.id.mol31);
        mol32 = (ImageButton) findViewById(R.id.mol32);
        mol33 = (ImageButton) findViewById(R.id.mol33);
        mol34 = (ImageButton) findViewById(R.id.mol34);
        mol35 = (ImageButton) findViewById(R.id.mol35);
        mol36 = (ImageButton) findViewById(R.id.mol36);
        mol37 = (ImageButton) findViewById(R.id.mol37);
        mol38 = (ImageButton) findViewById(R.id.mol38);
        mol39 = (ImageButton) findViewById(R.id.mol39);
        mol310 = (ImageButton) findViewById(R.id.mo310);
        mol311 = (ImageButton) findViewById(R.id.mol311);
        mol312 = (ImageButton) findViewById(R.id.mol312);
        mol313 = (ImageButton) findViewById(R.id.mol313);
        mol314 = (ImageButton) findViewById(R.id.mol314);
        mol315 = (ImageButton) findViewById(R.id.mol315);
        mol316 = (ImageButton) findViewById(R.id.mol316);
        mol317 = (ImageButton) findViewById(R.id.mol317);
        mol318 = (ImageButton) findViewById(R.id.mol318);
        mol319 = (ImageButton) findViewById(R.id.mo319);
        mol320 = (ImageButton) findViewById(R.id.mol320);



        timetv = (TextView) findViewById(R.id.textView2);
        scoretv = (TextView) findViewById(R.id.textView6);

        buttons.add(mol31);
        buttons.add(mol32);
        buttons.add(mol33);
        buttons.add(mol34);
        buttons.add(mol35);
        buttons.add(mol36);
        buttons.add(mol37);
        buttons.add(mol38);
        buttons.add(mol39);
        buttons.add(mol310);
        buttons.add(mol311);
        buttons.add(mol312);
        buttons.add(mol313);
        buttons.add(mol314);
        buttons.add(mol315);
        buttons.add(mol316);
        buttons.add(mol317);
        buttons.add(mol318);
        buttons.add(mol319);
        buttons.add(mol320);

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
