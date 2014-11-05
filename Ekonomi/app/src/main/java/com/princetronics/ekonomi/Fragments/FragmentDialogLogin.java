package com.princetronics.ekonomi.Fragments;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
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


    // Layout
    private View layout;
    private LayoutInflater inflater;

    // DialogFragment Layout
    private AlertDialog.Builder builder;

    // Layout Components
    private EditText firstname, lastname, userID, password;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Layout setup
        inflater = getActivity().getLayoutInflater();
        layout = inflater.inflate(R.layout.fragment_login_dialog, null);

        // DialogFragment Layout setup
        builder = new AlertDialog.Builder(getActivity());
        builder.setTitle(R.string.logga_in);

        // Login Button
        builder.setPositiveButton(R.string.logga_in, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        builder.setView(layout);

        return builder.create();
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        getDialog().getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE);
    }
}