package net.healthtechhub.rugbyquiz;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText editText1;
    private RadioButton rb2_1, rb2_2, rb2_3, rb2_4, rb4_1, rb4_2, rb4_3, rb4_4, rb5_1, rb5_2, rb5_3, rb5_4;
    private RadioGroup rg2, rg4, rg5;
    private CheckBox cb3_1, cb3_2, cb3_3, cb3_4;
    private int correctAnswers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Question 1 definition
        editText1 = findViewById(R.id.answer1);

        // Question 2 definitions
        rb2_1 = findViewById(R.id.radioBtnEng);
        rb2_2 = findViewById(R.id.radioBtnIre);
        rb2_3 = findViewById(R.id.radioBtnNZ);
        rb2_4 = findViewById(R.id.radioBtnSA);
        rg2 = findViewById(R.id.radioGroupQ2);

        // Question 3 definitions
        cb3_1 = findViewById(R.id.checkBoxEng);
        cb3_2 = findViewById(R.id.checkBoxIre);
        cb3_3 = findViewById(R.id.checkBoxNZ);
        cb3_4 = findViewById(R.id.checkBoxSA);

        // Question 4 definitions
        rb4_1 = findViewById(R.id.radioBtnJean);
        rb4_2 = findViewById(R.id.radioBtnJohn);
        rb4_3 = findViewById(R.id.radioBtnRichie);
        rb4_4 = findViewById(R.id.radioBtnSiya);
        rg4 = findViewById(R.id.radioGroupQ4);

        // Question 2 definitions
        rb5_1 = findViewById(R.id.radioBtnConv);
        rb5_2 = findViewById(R.id.radioBtnDrop);
        rb5_3 = findViewById(R.id.radioBtnPen);
        rb5_4 = findViewById(R.id.radioBtnTry);
        rg5 = findViewById(R.id.RadioGroupQ5);

        // Variable definitions
        correctAnswers = 0;
    }

    private boolean checkQuestion1() {
        boolean isCorrect = false;
        String givenAnswer = editText1.getText().toString();
        String correctAnswer = "Azzurri";

        if (givenAnswer.toLowerCase().equals(correctAnswer.toLowerCase()))
            isCorrect = true;

        return isCorrect;
    }

    private boolean checkQuestion2() {
        boolean isCorrect = false;

        if (rb2_3.isChecked()) {
            isCorrect = true;
        }

        return isCorrect;
    }

    private boolean checkQuestion3() {
        boolean isCorrect = false;

        if (cb3_1.isChecked() && cb3_2.isChecked() && !cb3_3.isChecked() && !cb3_4.isChecked()) {
            isCorrect = true;
        }

        return isCorrect;
    }

    private boolean checkQuestion4() {
        boolean isCorrect = false;

        if (rb4_2.isChecked()) {
            isCorrect = true;
        }

        return isCorrect;
    }

    private boolean checkQuestion5() {
        boolean isCorrect = false;

        if (rb5_4.isChecked()) {
            isCorrect = true;
        }

        return isCorrect;
    }

    public void submitAnswers(View view) {
        if (checkQuestion1())
            correctAnswers++;
        if (checkQuestion2())
            correctAnswers++;
        if (checkQuestion3())
            correctAnswers++;
        if (checkQuestion4())
            correctAnswers++;
        if (checkQuestion5())
            correctAnswers++;

        String results = "you got " + correctAnswers + " / 5 answers correct";

        Toast.makeText(getApplicationContext(), results, Toast.LENGTH_LONG).show();

        // Reset in case Submit is re-clicked
        correctAnswers = 0;
    }

    public void resetQuiz(View view) {
        editText1.setText("");

        rg2.clearCheck();
        rg4.clearCheck();
        rg5.clearCheck();

        cb3_1.setChecked(false);
        cb3_2.setChecked(false);
        cb3_3.setChecked(false);
        cb3_4.setChecked(false);

        correctAnswers = 0;
    }

}
