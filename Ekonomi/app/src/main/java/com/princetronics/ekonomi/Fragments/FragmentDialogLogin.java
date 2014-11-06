package com.princetronics.ekonomi.Fragments;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;

import com.princetronics.ekonomi.Callback;
import com.princetronics.ekonomi.R;

/**
 * Created by Prince on 11/5/2014.
 */
public class FragmentDialogLogin extends DialogFragment {

    // TAG
    private static final String TAG = "FragmentDialogLogin";

    // Callback
    private Callback caller;

    // SharedPreferences
    private static SharedPreferences preferences;
    private SharedPreferences.Editor editor;

    // Layout
    private View layout;
    private LayoutInflater inflater;

    // DialogFragment Layout
    private AlertDialog.Builder builder;

    // Layout Components
    private EditText etFornamn, etEfternamn;

    @Override
    public void onAttach(Activity activity) {
        caller = (Callback) activity;
        super.onAttach(activity);
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // SharedPreferences setup
        preferences = getActivity().getSharedPreferences("anvandare", 0);
        editor = preferences.edit();


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
                preferences = getActivity().getSharedPreferences("anvandare", 0);
                Log.i(TAG, "Förnamn: " + preferences.getString("etFornamn", "null"));
                Log.i(TAG, "Efternamn: " + preferences.getString("etEfternamn", "null"));

                // Update Fragments with user data
                caller.updateGUI();
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