package com.example.viewtest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        countClickTimes();
        inputNumber();
        showImage();
        TestSeekBar();
    }

    private int clickTimes = 0;
    protected void countClickTimes(){
        Button btn1 = findViewById(R.id.button1);
        final TextView textView1 = findViewById(R.id.text1);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickTimes++;
                String str = "You Clicked "+clickTimes+" times";
                textView1.setText(str);
                Log.d("countClickTimes",str);
            }
        });
    }

    protected void inputNumber(){
        Button btn2 = findViewById(R.id.button2);
        final EditText editText1 = findViewById(R.id.editText1);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str = editText1.getText().toString();
                Log.d("inputNumber",str);
            }
        });
    }
    private int showTimes=0;
    protected void showImage(){
        Button btn3 = findViewById(R.id.button3);
        final ImageView imageView1 = findViewById(R.id.imageView1);
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("showImage","show");
                showTimes++;
                if (showTimes%2==1)
                    imageView1.setImageResource(R.color.colorPrimary);
                else
                    imageView1.setImageResource(R.color.colorAccent);
            }
        });
    }

    protected void TestSeekBar(){
        SeekBar seekBar = findViewById(R.id.seekBar1);
        final TextView view = findViewById(R.id.text2);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                view.setText(Integer.toString(progress));
                Log.d("TestSeekBar", "当前值:"+progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                Log.d("TestSeekBar", "拖动开始");
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                Log.d("TestSeekBar", "拖动停止");
            }
        });
    }
}
