package com.example.hsuihj.whackamole;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button button1, button2, button3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button1 = (Button) findViewById(R.id.button4);
        button2 = (Button) findViewById(R.id.button5);
        button3 = (Button) findViewById(R.id.button3);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                open2x3();
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                open3x4();
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                open4x5();
            }
        });
    }

    public void open2x3() {
        Intent intent = new Intent(this, twobythree.class);
        startActivity(intent);
    }
    public void open3x4() {
        Intent intent = new Intent(this, threebyfour.class);
        startActivity(intent);
    }
    public void open4x5() {
        Intent intent = new Intent(this, fourbyfive.class);
        startActivity(intent);
    }

}
