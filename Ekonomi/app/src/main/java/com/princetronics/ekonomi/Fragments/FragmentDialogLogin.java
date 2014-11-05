package com.princetronics.ekonomi.Fragments;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import com.princetronics.ekonomi.R;

/**
 * Created by Prince on 11/5/2014.
 */
public class FragmentDialogLogin extends DialogFragment {

    // TAG
    private static final String TAG = "FragmentDialogLogin";

    // SharedPreferences
    private static SharedPreferences settings;
    private SharedPreferences.Editor editor;

    // Layout
    private View layout;
    private LayoutInflater inflater;

    // DialogFragment Layout
    private AlertDialog.Builder builder;

    // Layout Components
    private EditText etFornamn, etEfternamn;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // SharedPreferences setup
        settings = getActivity().getSharedPreferences("anvandare", 0);
        editor = settings.edit();


        // Layout setup
        inflater = getActivity().getLayoutInflater();
        layout = inflater.inflate(R.layout.fragment_login_dialog, null);

        // Component setup
        etFornamn = (EditText) layout.findViewById(R.id.etFornamn);
        etEfternamn = (EditText) layout.findViewById(R.id.etEfternamn);

        // DialogFragment Layout setup
        builder = new AlertDialog.Builder(getActivity());
        builder.setTitle(R.string.logga_in);

        // Login button setup
        builder.setPositiveButton(R.string.logga_in, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                editor.putString("etFornamn", etFornamn.getText().toString());
                editor.putString("etEfternamn", etEfternamn.getText().toString());
                editor.commit();

                // Debug
                settings = getActivity().getSharedPreferences("anvandare", 0);
                Log.i(TAG, "Förnamn: " + settings.getString("etFornamn", "null"));
                Log.i(TAG, "Efternamn: " + settings.getString("etEfternamn", "null"));
            }
        });
        builder.setView(layout);

        return builder.create();
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        // Show keyboard after created
        getDialog().getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE);
    }
}