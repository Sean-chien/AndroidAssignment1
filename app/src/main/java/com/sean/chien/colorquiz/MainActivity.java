package com.sean.chien.colorquiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import static com.sean.chien.colorquiz.R.id.questionTV;

public class MainActivity extends AppCompatActivity {
    public static final String LOG_TAG = "MainActivity";
    private int score = 0;
    private Button leftButt;
    private Button rightButt;
    private TextView questionTV;
    private TextView scoreTV;
    private boolean isRightAnswer;

    private void generateQuestion(){
        Question question = new Question();
        leftButt.setBackgroundColor(question.getLeftColor());
        rightButt.setBackgroundColor(question.getRightColor());
        questionTV.setText(question.getQuestionLabel());
        isRightAnswer = question.isRightAnswer();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        scoreTV = findViewById(R.id.scoreTV);
        scoreTV.setText("Score: " + score);
        // initializing views from the layout
        leftButt = findViewById(R.id.leftBtn);
        rightButt = findViewById(R.id.rightBtn);
        questionTV = findViewById(R.id.questionTV);

        generateQuestion();
    }

    public void buttonTapped(View view){
        // which button is tapped left or right ?
        Button btn = (Button) view;
        // btn -> identify
        // check if it's right or wrong
        // update your socre textView

        if (btn.getId() == R.id.leftBtn){
            //left button tapped
            if (isRightAnswer){
                score--;
                toast("Wrong!");
            }else {
                score++;
                toast("Right!");
            }
        }else{
            //right button tapped
            if (isRightAnswer){
                score++;
                toast("right!");
            }else{
                score--;
                toast("wrong!");
            }
        }
        scoreTV.setText("Score" + score);
        generateQuestion();
    }

    private void toast(String message){
        Toast.makeText(this,message, Toast.LENGTH_SHORT).show();
    }
}
