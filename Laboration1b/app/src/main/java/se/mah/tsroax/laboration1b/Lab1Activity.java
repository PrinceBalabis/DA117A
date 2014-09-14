package se.mah.tsroax.laboration1b;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.*;

public class Lab1Activity extends Activity {
    private EditText etName;
    private EditText etPhone;
    private EditText etEmail;
    private TextView tvSummary;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab1);
        etName = (EditText) findViewById(R.id.etName);
        etPhone = (EditText) findViewById(R.id.etPhone);
        etEmail = (EditText) findViewById(R.id.etEmail);
        tvSummary = (TextView) findViewById(R.id.tvSummary);
        Button bnSummary = (Button) findViewById(R.id.bnSummary);
        bnSummary.setOnClickListener(new buttonListener());
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

    private class buttonListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            String str = summary();
            tvSummary.setText(str);
            //tvSummary.setText("test");

        }

        private String summary() {
            String res;
            res = "Name=" + etName.getText().toString() +
                    ", phone=" + etPhone.getText().toString() +
                    ", email=" + etEmail.getText().toString();
            return res;
        }
    }
}
