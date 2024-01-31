package ru.startandroid.develop.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.*;

public class MainActivity extends AppCompatActivity {
    TextView tvInfo;
    EditText etInput;
    Button bControl;

    int guess = (int) (Math.random() * 100);
    boolean gameFinished = false;

/*
    private TextView myText;
    private CheckBox myCheckBox;

    private Button myButton;*/

    //@SuppressLint("WrongViewCast")
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        tvInfo = (TextView)findViewById(R.id.textView1);
        etInput = (EditText)findViewById(R.id.editText1);
        bControl = (Button)findViewById(R.id.button1);
        /*myText = findViewById(R.id.tvMyText);
        myCheckBox = findViewById(R.id.chbMyCheckBox);
        myButton = findViewById(R.id.btnMyButton);

        myText.setText("New text in TextView");
        myCheckBox.setChecked(true);
        myButton.setEnabled(false);*/


    }

    public void OnClick(View v){
        Integer.parseInt(etInput.getText().toString());
        tvInfo.setText(getResources().getString(R.string.ahead));
        if (!gameFinished) {
            int inp=Integer.parseInt(etInput.getText().toString());
            if (inp > guess)
                tvInfo.setText("Перелет!");
            if (inp < guess)
                tvInfo.setText("Недолет!");
            if (inp > guess){
                tvInfo.setText("В точку!");
                bControl.setText("Сыграть еще");
                gameFinished = true;
            }
        }
        else {
            guess = (int)(Math.random()*100);
            bControl.setText("Ввести значение: ");
            etInput.setText(" ");
            tvInfo.setText("Попробуйте угадать число (1 - 100)");
            gameFinished = false;
        }
    }
}