package com.example.hsuihj.whackamole;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class goback extends AppCompatActivity {
    private Button exit, restart;
    private int score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_goback);

        TextView scoreLabel = (TextView) (findViewById(R.id.scoreLabel));
        int score = getIntent().getIntExtra("SCORE", 0);
        scoreLabel.setText(score + "");


        Button exit = (Button) (findViewById(R.id.button6));
        Button restart = (Button) (findViewById(R.id.button7));

        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        restart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent restart = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(restart);
            }
        });
    }
}


