package com.example.refat.alarmclock;

/**
 * Created by REFAT on 1/8/2019.
 */

public class Question {
    public String mQuestions[]={
            "The average of first 50 natural numbers is …",
            " If ‘+’ means ‘×’, ‘-‘ means ‘+’, ‘×’ means ‘÷’ and ‘÷’ means ‘-‘ then find the value of;\n" +
                    "6 – 9 + 8 × 3 ÷ 20 = ……. .",
            "The number of 3-digit numbers divisible by 6, is ………….. .",
            " What is 1004 divided by 2?",
            "What is 121 times 11??",
            "10001 – 101 = ?",
            "106 × 106 – 94 × 94 = ?",
            " Which of the following numbers gives 240 when added to its own square?",
            " Evaluation of 8^3 × 8^2 × 8^-5 is …………. .",
            "The simplest form of 1.5 : 2.5 is …………… ."
    };
    private String mChoices[][]={
            {"25.30","25.5","25.00","12.25"},/**
     **/
            {"6","10","-2","12"},
            {"149","166","150","151"},
            {"52","502","520","5002"},
            {"1331","1313","1133","3131"},
            {"1001","990","9990","9900"},
            {"2004","2400","1904","1906"},
            {"15","16","18","20"},
            {"1","0","8","None of these"},
            {"6:10","15:25","0.75:1.25","3:5"}
    };
    private String mCorrectAnswer[]={
            "25.5","10","150","502","1331","9900","2400","15","1","3:5"
    };
    public String getQuestion(int a){
        String  question=mQuestions[a];
        return question;
    }
    public String getChoice1(int a){
        String choice=mChoices[a][0];
        return  choice;
    }
    public String getChoice2(int a){
        String choice=mChoices[a][1];
        return  choice;
    }
    public String getChoice3(int a){
        String choice=mChoices[a][2];
        return  choice;
    }
    public String getChoice4(int a){
        String choice=mChoices[a][3];
        return  choice;
    }
    public String getCorrectAnswer(int a){
        String answer=mCorrectAnswer[a];
        return  answer;
    }
}
