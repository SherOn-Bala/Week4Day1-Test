package ca.judacribz.week4day1_test;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import static ca.judacribz.week4day1_test.Algorithms.checkBrackets;
import static ca.judacribz.week4day1_test.Algorithms.strCopies;

public class MainActivity extends AppCompatActivity {

    TextView tvBrackets,tvSubstringCheck;
    EditText etBrackets, etString, etSubstring, etCount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvBrackets = findViewById(R.id.tvBrackets);
        tvSubstringCheck = findViewById(R.id.tvSubstringCheck);
        etBrackets = findViewById(R.id.etBrackets);
        etString = findViewById(R.id.etString);
        etSubstring = findViewById(R.id.etSubstring);
        etCount = findViewById(R.id.etCount);
    }

    public void checkOrder(View view) {
        tvBrackets.setText(String.valueOf(checkBrackets(
                etBrackets.getText().toString().trim().replaceAll(" ", "")
        )));
    }

    public void checkCount(View view) {
        tvSubstringCheck.setText(String.valueOf(strCopies(
                etString.getText().toString().trim(),
                etSubstring.getText().toString().trim(),
                Integer.valueOf(etCount.getText().toString().trim())
        )));
    }
}
