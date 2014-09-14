package se.mah.tsroax.laboration1b;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Lab1Activity extends Activity {
    private EditText etName;
    private EditText etPhone;
    private EditText etEmail;
    private TextView tvSummary;
    private TextView tvName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab1);
        initializeComponents();
        registerListeners();
    }

    private void registerListeners() {
        Button bnSummary = (Button) findViewById(R.id.bnSummary);
        bnSummary.setOnClickListener(new ButtonListener());
        Button bnColor = (Button) findViewById(R.id.bnColor);
        bnColor.setOnClickListener(new ChangeColor());
    }

    private void initializeComponents() {
        etName = (EditText) findViewById(R.id.etName);
        etPhone = (EditText) findViewById(R.id.etPhone);
        etEmail = (EditText) findViewById(R.id.etEmail);
        tvSummary = (TextView) findViewById(R.id.tvSummary);
        tvName = (TextView) findViewById(R.id.tvName);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.lab1, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private class ButtonListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            String str = summary();
            tvSummary.setText(str);
        }

        private String summary() {
            String res;
            res = "Name=" + etName.getText().toString() +
                    ", phone=" + etPhone.getText().toString() +
                    ", email=" + etEmail.getText().toString();
            return res;
        }
    }

    private class ChangeColor implements View.OnClickListener {
        private boolean redColor = true;

        @Override
        public void onClick(View v) {
            if (redColor) {
                tvName.setTextColor(0xFFFF6600);
            } else {
                tvName.setTextColor(Color.RED);
            }
            redColor = !redColor;
        }
    }
}
