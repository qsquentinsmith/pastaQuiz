package com.example.android.pastaquiz;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * Initialize score
     */
    int score = 0;

    /**
     * Set up Radio buttons
     */
    public void onRadioButtonClicked(View view) {
        //Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        //Question 1
        switch (view.getId()) {
            case R.id.thirteen:
                //correct answer
                if (checked)
                    break;
            case R.id.twentythree:
                if (checked)
                    //wrong answer
                    break;
            case R.id.nine:
                if (checked)
                    //wrong answer
                    break;
        }
        //Question 3
        switch (view.getId()) {
            case R.id.secondCentury:
                if (checked)
                    //wrong answer
                    break;
            case R.id.thirteenthCentury:
                if (checked)
                    //wrong answer
                    break;
            case R.id.fourthCentury:
                if (checked)
                    //correct answer
                    break;
            case R.id.seventhCentury:
                if (checked)
                    //wrong answer
                    break;
        }
        switch (view.getId()) {
            case R.id.gigli:
                if (checked)
                    //correct answer
                    break;
            case R.id.radiatori:
                if (checked)
                    //wrong answer
                    break;
            case R.id.rotelle:
                if (checked)
                    //wrong answer
                    break;
        }
    }

    /**
     * This method is called when the get score button is clicked
     *
     */
    public void displayScore(View view) {

        EditText nameField = (EditText) findViewById(R.id.name_field);
        String name = nameField.getText().toString();


        //question 1
        RadioButton thirteen = findViewById(R.id.thirteen);
        if (thirteen.isChecked()) {
            score = score + 1;
        }

        //question 2: Need to check all three boxes to get one point
        CheckBox choiceOne = (CheckBox) findViewById(R.id.italy);

        CheckBox choiceTwo = (CheckBox) findViewById(R.id.united_states);

        CheckBox choiceThree = (CheckBox) findViewById(R.id.russia);

        if (choiceThree.isChecked() && choiceOne.isChecked() && choiceTwo.isChecked()) {
            score = score + 1;
        }


        //question 3
        RadioButton fourthCentury = findViewById(R.id.fourthCentury);
        if (fourthCentury.isChecked()) {
            score = score + 1;
        }


        //question 4
        EditText macInputField = (EditText) findViewById(R.id.mac_input_field);
        String mac = macInputField.getText().toString();
        if (mac.equals("Macaroni")) {
            score = score + 1;
        }

        //question 5
        EditText fusilliInputField = (EditText) findViewById(R.id.fusilli_input_field);
        String fusilli = fusilliInputField.getText().toString();
        if (fusilli.equals("Fusilli")) {
            score = score + 1;
        }

        //question 6
        EditText farfalle_input_field = (EditText) findViewById(R.id.farfalle_input_field);
        String farfalle = farfalle_input_field.getText().toString();
        if (farfalle.equals("Farfalle")) {
            score = score + 1;
        }

        //question 7
        RadioButton gigli = findViewById(R.id.gigli);
        if (gigli.isChecked()) {
            score = score + 1;
        }


        //displays score if number of points is greater than five it will show one message. If less than five a different message
        if (score > 5) {

            Context context = getApplicationContext();
            String text = "Congratulations " + name + "! You know your pasta. Score: " + score + "/7";
            int duration = Toast.LENGTH_LONG;

            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
        } else {
            Context context = getApplicationContext();
            String text = "Good try, " + name + ". Go eat some pasta and brush up on some pasta facts. Score:" + score + "/7";
            int duration = Toast.LENGTH_LONG;

            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
        }


        //resets score after toast is displayed so it doesn't add the values
        score = 0;
    }

    /**
     * Reset button for all fields to restart
     *
     */
    public void reset (View view) {

        //clears radio buttons
        RadioGroup radioGroup1 = (RadioGroup)findViewById(R.id.question_one);
        radioGroup1.clearCheck();

        RadioGroup radioGroup2 = (RadioGroup)findViewById(R.id.question_three);
        radioGroup2.clearCheck();

        RadioGroup radioGroup3 = (RadioGroup)findViewById(R.id.question_seven);
        radioGroup3.clearCheck();


        //clears checkboxes
        CheckBox choiceOne = (CheckBox) findViewById(R.id.italy);
        CheckBox choiceTwo = (CheckBox) findViewById(R.id.united_states);
        CheckBox choiceThree = (CheckBox) findViewById(R.id.russia);
        CheckBox choiceFour = (CheckBox) findViewById(R.id.france);
        CheckBox choiceFive = (CheckBox) findViewById(R.id.china);

        if (choiceOne.isChecked() | choiceTwo.isChecked() | choiceThree.isChecked() | choiceFour.isChecked() | choiceFive.isChecked()) {
            choiceOne.setChecked(false);
            choiceTwo.setChecked(false);
            choiceThree.setChecked(false);
            choiceFour.setChecked(false);
            choiceFive.setChecked(false);
        }


        // Sets all editText boxes empty
        final EditText nameField = (EditText) findViewById(R.id.name_field);
        final EditText inputField1 = (EditText) findViewById(R.id.mac_input_field);
        final EditText inputField2 = (EditText) findViewById(R.id.fusilli_input_field);
        final EditText inputField3 = (EditText) findViewById(R.id.farfalle_input_field);

        nameField.getText().clear();
        inputField1.getText().clear();
        inputField2.getText().clear();
        inputField3.getText().clear();

    }

}