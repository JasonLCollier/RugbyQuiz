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

    private EditText Qtn1EditText;
    private RadioButton Qtn2RadioBtnNZ;
    private RadioButton Qtn4RadioBtnJohn;
    private RadioButton Qtn5RadioBtnTry;
    private RadioGroup Qtn2RadioGroup;
    private RadioGroup Qtn4RadioGroup;
    private RadioGroup Qtn5RadioGroup;
    private CheckBox Qtn3CheckBoxEng;
    private CheckBox Qtn3CheckBoxIre;
    private CheckBox Qtn3CheckBoxNZ;
    private CheckBox Qtn3RadioGroup;
    private int correctAnswers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Question 1 definition
        Qtn1EditText = findViewById(R.id.answer1);

        // Question 2 definitions
        Qtn2RadioBtnNZ = findViewById(R.id.radioBtnNZ);
        Qtn2RadioGroup = findViewById(R.id.radioGroupQ2);

        // Question 3 definitions
        Qtn3CheckBoxEng = findViewById(R.id.checkBoxEng);
        Qtn3CheckBoxIre = findViewById(R.id.checkBoxIre);
        Qtn3CheckBoxNZ = findViewById(R.id.checkBoxNZ);
        Qtn3RadioGroup = findViewById(R.id.checkBoxSA);

        // Question 4 definitions
        Qtn4RadioBtnJohn = findViewById(R.id.radioBtnJohn);
        Qtn4RadioGroup = findViewById(R.id.radioGroupQ4);

        // Question 2 definitions
        Qtn5RadioBtnTry = findViewById(R.id.radioBtnTry);
        Qtn5RadioGroup = findViewById(R.id.RadioGroupQ5);

        // Variable definitions
        correctAnswers = 0;
    }

    private boolean checkQuestion1() {
        boolean isCorrect = false;
        String givenAnswer = Qtn1EditText.getText().toString();
        String correctAnswer = "Azzurri";

        if (givenAnswer.equalsIgnoreCase(correctAnswer))
            isCorrect = true;

        return isCorrect;
    }

    private boolean checkQuestion2() {
        boolean isCorrect = false;

        if (Qtn2RadioBtnNZ.isChecked()) {
            isCorrect = true;
        }

        return isCorrect;
    }

    private boolean checkQuestion3() {
        boolean isCorrect = false;

        if (Qtn3CheckBoxEng.isChecked() && Qtn3CheckBoxIre.isChecked() && !Qtn3CheckBoxNZ.isChecked() && !Qtn3RadioGroup.isChecked()) {
            isCorrect = true;
        }

        return isCorrect;
    }

    private boolean checkQuestion4() {
        boolean isCorrect = false;

        if (Qtn4RadioBtnJohn.isChecked()) {
            isCorrect = true;
        }

        return isCorrect;
    }

    private boolean checkQuestion5() {
        boolean isCorrect = false;

        if (Qtn5RadioBtnTry.isChecked()) {
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
        Qtn1EditText.setText("");

        Qtn2RadioGroup.clearCheck();
        Qtn4RadioGroup.clearCheck();
        Qtn5RadioGroup.clearCheck();

        Qtn3CheckBoxEng.setChecked(false);
        Qtn3CheckBoxIre.setChecked(false);
        Qtn3CheckBoxNZ.setChecked(false);
        Qtn3RadioGroup.setChecked(false);

        correctAnswers = 0;
    }

}
