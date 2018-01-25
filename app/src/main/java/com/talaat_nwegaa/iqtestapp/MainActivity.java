package com.talaat_nwegaa.iqtestapp;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    double score = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void ques_1(View view) {
//for checking one radioButton

    }

    public void ques_2(View view) {
//for checking one radioButton

    }

    public void ques_3(View view) {
//for checking one radioButton
    }

    public void ques_7(View view) {

    }
    public void ques_4(View view) {
        //this method to check only 3 checkBoxes from 4

        CheckBox choose1 = (CheckBox) findViewById(R.id.Q4_ch1);
        CheckBox choose2 = (CheckBox) findViewById(R.id.Q4_ch2);
        CheckBox choose3 = (CheckBox) findViewById(R.id.Q4_ch3);
        CheckBox choose4 = (CheckBox) findViewById(R.id.Q4_ch4);
        choose4.setEnabled(true);
        choose3.setEnabled(true);
        choose2.setEnabled(true);
        choose1.setEnabled(true);

        if (choose1.isChecked() && choose2.isChecked() && choose3.isChecked())
            choose4.setEnabled(false);

        else if (choose4.isChecked() && choose2.isChecked() && choose3.isChecked())
            choose1.setEnabled(false);

        else if (choose4.isChecked() && choose2.isChecked() && choose1.isChecked())
            choose3.setEnabled(false);

        else if (choose3.isChecked() && choose4.isChecked() && choose1.isChecked())
            choose2.setEnabled(false);
    }
    private  String resultMessage(double score){
        String message="your result is "+score+"%";
        return message;
    }
    private void displayResult(String result) {
        TextView resultTextView = (TextView) findViewById(R.id.your_result);
        resultTextView.setText(result);
    }
    private void displayCorrectResult(String message){
        TextView correctAnswer=(TextView)findViewById(R.id.text_Viewing_Correct_Answer);
        correctAnswer.setText(message);
}
    String message="1-(55) , 2-(11) , 3-(D) , 4-(BCD) \n 5-(0.32) , 6-(2) ,7-(-27) ,8-(148)";

    public void correctAnswerSubmit(View view){
        displayCorrectResult(message);
    }

    public void submit(View view){
        RadioButton qus1Ch2=(RadioButton) findViewById(R.id.Q1_ch2);
        Boolean checkQus1Ch2 = qus1Ch2.isChecked();

        RadioButton qus2Ch4=(RadioButton) findViewById(R.id.Q2_ch4);
        Boolean checkQus2Ch4 = qus2Ch4.isChecked();

        RadioButton qus3Ch4=(RadioButton) findViewById(R.id.Q3_ch4);
        Boolean checkQus3Ch4 = qus3Ch4.isChecked();

        CheckBox qus4Ch2=(CheckBox) findViewById(R.id.Q4_ch2);
        Boolean checkQus4Ch2=qus4Ch2.isChecked();
        CheckBox qus4Ch3=(CheckBox) findViewById(R.id.Q4_ch3);
        Boolean checkQus4Ch3=qus4Ch3.isChecked();
        CheckBox qus4Ch4=(CheckBox) findViewById(R.id.Q4_ch4);
        Boolean checkQus4Ch4=qus4Ch4.isChecked();

        EditText number5=(EditText)findViewById(R.id.result_Q5);
        String checkQues5=number5.getText().toString();

        EditText number6=(EditText)findViewById(R.id.result_Q6);
        String checkQues6=number6.getText().toString();

        RadioButton qus7Ch2=(RadioButton) findViewById(R.id.Q7_ch2);
        Boolean checkQus7Ch2 = qus7Ch2.isChecked();

        EditText number8=(EditText)findViewById(R.id.result_Q8);
        String checkQues8=number8.getText().toString();

        int score=calculateScore(checkQus1Ch2,checkQus2Ch4,checkQus3Ch4,checkQus4Ch2,checkQus4Ch3,checkQus4Ch4,checkQues5,checkQues6,checkQus7Ch2,checkQues8);
        String result=resultMessage(score);
        displayResult(result);
        if (score>=50){
            Toast.makeText(this,"good work you pass",Toast.LENGTH_SHORT).show();
        }
        if (score<50){
            Toast.makeText(this,"bad luck you fail",Toast.LENGTH_SHORT).show();
        }
    }


    public void reset(View v){
        score=0;
        displayResult(String.valueOf((int) score));
    }
    private int calculateScore(boolean checkQus1Ch2,boolean checkQus2Ch4,boolean checkQus3Ch4,boolean checkQus4Ch2,boolean checkQus4Ch3,boolean checkQus4Ch4,String checkQues5,String checkQues6,boolean checkQus7Ch2,String checkQues8){
         score=0;
        if (checkQus1Ch2){
            score+=12.5;
        }
        if (checkQus2Ch4){
            score+=12.5;
        }
        if (checkQus3Ch4){
            score+=12.5;
        }

        if (checkQus4Ch2 && checkQus4Ch3 && checkQus4Ch4) {
            score +=12.5;
        }

        if (checkQues5.equals ("0.32")){
            score+=12.5;
        }
        if (checkQues5.equals (".32")){
            score+=12.5;
        }
        if (checkQues6.equals("2")){
            score+=12.5;
        }
        if (checkQus7Ch2){
            score+=12.5;
        }
        if (checkQues8.equals("148")){
            score+=12.5;
        }

        return (int) score;
    }

}
