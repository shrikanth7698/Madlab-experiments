package me.shrikanthravi.madlab.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import me.shrikanthravi.madlab.R;

public class ExperimentActivity3 extends AppCompatActivity {
    private String currentString = "0";
    private String previousString = null;
    private boolean isTempStringShown;
    private TextView textView;
    private int currentOpperand = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_experiment3);

        //Hiding action bar that displays app name
        if(getSupportActionBar()!=null) {
            getSupportActionBar().hide();
        }

        // Enable javascript for the view
        textView = (TextView) findViewById(R.id.textView);

        // Set the listener for all the buttons
        int numberButtons[] = { R.id.button0, R.id.button1, R.id.button2,
                R.id.button3, R.id.button4, R.id.button5, R.id.button6,
                R.id.button7, R.id.button8, R.id.button9
        };
        int opperandButtons[] = {
                R.id.buttonPlus, R.id.buttonMinus, R.id.buttonDivide, R.id.buttonTimes,
                R.id.buttonDecimal, R.id.buttonClear, R.id.buttonEquals
        };

        NumberButtonClickListener numberClickListener = new NumberButtonClickListener();
        for(int id : numberButtons) {
            View v = findViewById(id);
            v.setOnClickListener(numberClickListener);
        }

        OpperandButtonClickListener oppClickListener = new OpperandButtonClickListener();
        for(int id : opperandButtons) {
            View v = findViewById(id);
            v.setOnClickListener(oppClickListener);
        }

        setCurrentString("0");
    }

    public void setCurrentString(String s) {
        currentString = s;
        textView.setText(s);
    }
    public String getCurrentString() {
        return currentString;
    }

    public void clear() {
        isTempStringShown = false;
        setCurrentString("0");
        previousString = null;
    }
    public void calculate(int id) {
        double curr = Double.parseDouble(getCurrentString());
        double result = curr;
        if (previousString != null) {
            double prev = Double.parseDouble(previousString);
            switch(currentOpperand) {
                case R.id.buttonPlus: result = prev + curr; break;
                case R.id.buttonMinus: result = prev - curr; break;
                case R.id.buttonTimes: result = prev * curr; break;
                case R.id.buttonDivide: result = prev / curr; break;
                default: break;
            }
        }
        currentOpperand = id;
        previousString = ""+result;
        setCurrentString(previousString);
        isTempStringShown = true;
    }

    private class NumberButtonClickListener implements View.OnClickListener {
        @Override
        public void onClick(View v)  {
            String text = (String) ((Button)v).getText();
            if (currentString.equals("0") || isTempStringShown) {
                isTempStringShown = false;
                setCurrentString(text);
            }else {
                setCurrentString(getCurrentString()+text);
            }
        }
    }

    private class OpperandButtonClickListener implements View.OnClickListener {
        @Override
        public void onClick(View v)  {
            int id = v.getId();
            if (id == R.id.buttonClear) {
                clear();
            }else if (id == R.id.buttonEquals) {
                calculate(currentOpperand);
            }else if (id == R.id.buttonDecimal) {
                if (!getCurrentString().contains(".")) {
                    if (isTempStringShown) {
                        isTempStringShown = false;
                        setCurrentString("0");
                    }
                    setCurrentString(getCurrentString()+".");
                }
            }else {
                calculate(id);
            }

        }
    }

}
