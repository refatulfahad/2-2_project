package com.example.refat.alarmclock;

import android.app.AlarmManager;
import android.app.AlertDialog;
import android.app.PendingIntent;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class Main2Activity extends AppCompatActivity  {

    Button answer1,answer2,answer3,answer4;
    TextView score,question;
    private Question mQuestions=new Question();
    private String mAnswer;
    private int mscore=0;
    private int mQuestionlength=mQuestions.mQuestions.length;
    Random r;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        //Toast.makeText(Main2Activity.this, "Main2Activity", Toast.LENGTH_SHORT).show();
        r=new Random();
        answer1= (Button) findViewById(R.id.answer1);
        answer2= (Button) findViewById(R.id.answer2);
        answer3= (Button) findViewById(R.id.answer3);
        answer4= (Button) findViewById(R.id.answer4);
        score= (TextView) findViewById(R.id.score);
        question= (TextView) findViewById(R.id.question);
        score.setText("Score: "+mscore);
        updateQuestion(r.nextInt(mQuestionlength));
        answer1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(answer1.getText()==mAnswer){
                    mscore++;
                    score.setText("Score: "+mscore);
                    if(mscore==3){
                        gameOver();
                    }
                    updateQuestion(r.nextInt(mQuestionlength));
                }
                else{
                    updateQuestion(r.nextInt(mQuestionlength));
                }

            }
        });
        answer2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(answer2.getText()==mAnswer){
                    mscore++;
                    score.setText("Score: "+mscore);
                    if(mscore==3){
                        gameOver();
                    }
                    updateQuestion(r.nextInt(mQuestionlength));
                }
                else{
                    updateQuestion(r.nextInt(mQuestionlength));
                }


            }
        });
        answer3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(answer3.getText()==mAnswer){
                    mscore++;
                    score.setText("Score: "+mscore);
                    if(mscore==3){
                        gameOver();
                    }
                    updateQuestion(r.nextInt(mQuestionlength));
                }
                else{
                    updateQuestion(r.nextInt(mQuestionlength));
                }

            }
        });
        answer4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(answer4.getText()==mAnswer){
                    mscore++;
                    score.setText("Score: "+mscore);
                    if(mscore==3){
                        gameOver();
                    }
                    updateQuestion(r.nextInt(mQuestionlength));
                }
                else{
                    updateQuestion(r.nextInt(mQuestionlength));
                }

            }
        });
    }
    private void updateQuestion(int num){
        question.setText(mQuestions.getQuestion(num));
        answer1.setText(mQuestions.getChoice1(num));
        answer2.setText(mQuestions.getChoice2(num));
        answer3.setText(mQuestions.getChoice3(num));
        answer4.setText(mQuestions.getChoice4(num));
        mAnswer=mQuestions.getCorrectAnswer(num);
    }
    private void gameOver(){
        /*AlertDialog.Builder alertDialogbuilder=new AlertDialog.Builder(Main2Activity.this);
        alertDialogbuilder.
                setMessage("Game over! your Score: "+mscore+"points").
                setCancelable(false).
                setPositiveButton("New Game",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                startActivity(new Intent(getApplicationContext(),MainActivity.class));
                            }
                        }).
                setNegativeButton("Exit",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                finish();
                            }
                        });*/
        Intent quesintent=new Intent(Main2Activity.this,MainActivity.class);
           quesintent.putExtra("ID_KEY", mscore);
            startActivity(quesintent);
    }
}




