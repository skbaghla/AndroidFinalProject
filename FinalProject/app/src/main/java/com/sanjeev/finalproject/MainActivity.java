package com.sanjeev.finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    TextView totalQuestionsTextView;
    TextView questionTextView;
    Button ansA, ansB, ansC, ansD;
    Button submitBtn;

    int score=0;
    int totalQuestion = 5;
    int currentQuestionIndex = 0;
    int currentPos = 0;
    String selectedAnswer = "";

    ArrayList<Integer> number = new ArrayList<Integer>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //using Collection.shuffle to shuffle numbers in arraylist then getting those random numbders index from Questions.
        shuffleQuestionIndex();
        totalQuestionsTextView = findViewById(R.id.total_question);
        questionTextView = findViewById(R.id.question);
        ansA = findViewById(R.id.ans_A);
        ansB = findViewById(R.id.ans_B);
        ansC = findViewById(R.id.ans_C);
        ansD = findViewById(R.id.ans_D);
        submitBtn = findViewById(R.id.submit_btn);

        ansA.setOnClickListener(this);
        ansB.setOnClickListener(this);
        ansC.setOnClickListener(this);
        ansD.setOnClickListener(this);
        submitBtn.setOnClickListener(this);

        totalQuestionsTextView.setText("Total questions : "+totalQuestion);

        loadNewQuestion();

    }

    private void shuffleQuestionIndex() {
        /*shuffling the list numbers */
        number.clear();
        for (int i = 0; i <= 9; ++i)
            number.add(i);
        Collections.shuffle(number);
        currentQuestionIndex = number.get(currentPos);
    }

    @Override
    public void onClick(View view) {

        //Initial colors
        ansA.setBackgroundColor(Color.WHITE);
        ansB.setBackgroundColor(Color.WHITE);
        ansC.setBackgroundColor(Color.WHITE);
        ansD.setBackgroundColor(Color.WHITE);

        Button clickedButton = (Button) view;
        if(clickedButton.getId()==R.id.submit_btn){
            if (selectedAnswer.isEmpty())
            {
                Toast.makeText(this, "Please select an answer", Toast.LENGTH_SHORT).show();
            }
            else {
                if (selectedAnswer.equals(QuestionAnswer.correctAnswers[currentQuestionIndex])) {
                    score++;
                }
                currentQuestionIndex = number.get(currentPos + 1);
                currentPos = currentPos + 1;
                loadNewQuestion();
                selectedAnswer = "";
            }
        }else{
            //choices button clicked color changing
            selectedAnswer  = clickedButton.getText().toString();
            clickedButton.setBackgroundColor(Color.GREEN);

        }

    }

    void loadNewQuestion(){

        //checking if currentPosition is equals to 5 to finish quiz and show result
        if(currentPos == totalQuestion ){
            finishQuiz();
            return;
        }

        questionTextView.setText(QuestionAnswer.question[currentQuestionIndex]);
        ansA.setText(QuestionAnswer.choices[currentQuestionIndex][0]);
        ansB.setText(QuestionAnswer.choices[currentQuestionIndex][1]);
        ansC.setText(QuestionAnswer.choices[currentQuestionIndex][2]);
        ansD.setText(QuestionAnswer.choices[currentQuestionIndex][3]);

    }

    void finishQuiz(){
        String passStatus = "";
        if(score > 4){
            passStatus = "You are a genius!";
        }else if (score > 3){
            passStatus = "Excellent work!";
        }else if (score > 2){
            passStatus = "Good job!";
        }else {
            passStatus = "Please try again!";
        }

        if (score > 2)
        {
            new AlertDialog.Builder(this)
                    .setTitle(passStatus)
                    .setMessage("Score is "+ score+" out of "+totalQuestion)
                    .setPositiveButton("Restart",(dialogInterface, i) -> restartQuiz() )
                    .setNegativeButton(android.R.string.no, null)
                    .setCancelable(false)
                    .show();
        }
        else{
            new AlertDialog.Builder(this)
                    .setTitle(passStatus)
                    .setMessage("Score is "+ score+" out of "+totalQuestion)
                    .setPositiveButton("Restart",(dialogInterface, i) -> restartQuiz() )
                    .setNegativeButton(android.R.string.no, null)
                    .setCancelable(false)
                    .show();
        }


    }

    void restartQuiz(){
        score = 0;
        currentQuestionIndex =0;
        currentPos = 0;
        shuffleQuestionIndex();
        loadNewQuestion();
    }

}