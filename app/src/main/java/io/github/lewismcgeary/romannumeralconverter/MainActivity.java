package io.github.lewismcgeary.romannumeralconverter;

import android.content.Context;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText inputEditText;
    TextView outputTextView;
    Button convertButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inputEditText = (EditText) findViewById(R.id.input_edit_text);
        outputTextView = (TextView) findViewById(R.id.output_text_view);
        convertButton = (Button) findViewById(R.id.convert_button);

        convertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    convertAndDisplayNumber();
            }
        });

        inputEditText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_GO) {
                    convertAndDisplayNumber();
                    hideSoftKeyboard(v);
                    return true;
                }
                return false;
            }
        });
    }

    private void convertAndDisplayNumber() {
        try {
            String inputString = inputEditText.getText().toString();
            if (inputString.matches("[0-9]+")) {
                int inputInt = Integer.valueOf(inputString);
                outputTextView.setText(RomanNumeralConverter.convertIntToRoman(inputInt));
            } else {
                outputTextView.setText(String.valueOf(RomanNumeralConverter.convertRomanToInt(inputString)));
            }
        } catch (IllegalArgumentException exception) {
            outputTextView.setText(R.string.conversion_error);
            Log.d("Conversion Failed", exception.getMessage());
        }
    }


    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        //produce better behaviour for any EditText views
        //touching the screen outside the EditText will hide keyboard.
        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            View v = getCurrentFocus();
            if (v instanceof EditText) {
                Rect outRect = new Rect();
                v.getGlobalVisibleRect(outRect);
                if (!outRect.contains((int) event.getRawX(), (int) event.getRawY())) {
                    v.clearFocus();
                    hideSoftKeyboard(v);
                }
            }
        }
        return super.dispatchTouchEvent(event);
    }

    private void hideSoftKeyboard(View v) {
        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
    }
}
