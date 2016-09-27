package com.taewonkim.android.fourthousandsung;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    GridLayout gameBoard;
    Button btnStart;
    ArrayList<Button> check = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gameBoard = (GridLayout) findViewById(R.id.gameBoard);
        btnStart = (Button) findViewById(R.id.btnStart);

        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int num = new Random().nextInt(9);
                Button target = new Button(MainActivity.this);
                target.setText(num + "");
                gameBoard.addView(target);

                target.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        check.add((Button) v);

                        if (check.size() == 2) {
                            check.get(0).getText();
                            if (check.get(0).getText().equals(check.get(1).getText())) {
                                check.get(0).setVisibility(View.INVISIBLE);
                                check.get(1).setVisibility(View.INVISIBLE);
                            }

                        } else if (check.size() > 2) {
                            check.clear();
                            check.add((Button) v);
                        }

                    }
                });
            }
        });
    }
}
