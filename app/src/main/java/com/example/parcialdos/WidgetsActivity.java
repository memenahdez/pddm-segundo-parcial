package com.example.parcialdos;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

public class WidgetsActivity extends AppCompatActivity {

    Button button;
    SeekBar seekBar;
    TextView textView;
    EditText editText;
    CheckBox checkBox;
    Switch aSwitch;
    RadioGroup radioGroup;
    RatingBar ratingBar;
    ToggleButton toggleButton;
    ProgressBar progressBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_widgets);

        seekBar = findViewById(R.id.seek_bar);
        textView = findViewById(R.id.text_view);
        checkBox = findViewById(R.id.check_box);
        radioGroup = findViewById(R.id.radio_button);
        ratingBar = findViewById(R.id.Rating_bar);
        toggleButton = findViewById(R.id.Toggle_button);

        listenerTextView();
        listenerEditText();
        listenerCheckbox();
        listenerSwitch();
        listenerRadioGroup();
        listenerRatingBar();
        listenerToggleButton();


        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                textView.setText("El valor es: " + i);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }


    private void listenerTextView(){
        textView.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                message("beforeTextView" + charSequence);
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                message("changedTextView" + charSequence);
                /*
                String mayusculas = charSequence.toString().toUpperCase();
                String currentValue = textView.getText().toString().toUpperCase();
                if
                */

            }

            @Override
            public void afterTextChanged(Editable editable) {
                message("afterTextChanged");
            }
        });
    }

    private void listenerEditText(){
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                message("beforeTextChanged" + charSequence + " " + i + " " + i1 + " " + i2);
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                message("onTextChanged" + charSequence + " " + i + " " + i1 + " " + i2);

            }

            @Override
            public void afterTextChanged(Editable editable) {
                message("afterTextChanged");

            }
        });
    }

    private void listenerCheckbox(){
        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                message("onCheckedChanged" + b);
            }
        });
    }

    private void listenerSwitch(){
        aSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                message("onCheckedChange" + b);
            }
        });
    }

    private void listenerRadioGroup(){
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i){
                    case R.id.opt_1:
                        message("opción uno");
                        break;
                    case R.id.opt_2:
                        message("opción dos");
                        break;
                }
                message("onCheckedChange" + i);
            }
        });
    }

    private void listenerRatingBar(){
        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float v, boolean b) {
                message("onRatingChanger" + v + " " + b);
            }
        });
    }

    private void listenerToggleButton(){
        toggleButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                message("onCheckChanged" + b);
            }
        });
    }

    private void message(String msg){
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
    }

}

