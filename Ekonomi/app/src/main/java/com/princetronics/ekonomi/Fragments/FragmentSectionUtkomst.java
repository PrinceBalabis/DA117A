package com.princetronics.ekonomi.Fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.princetronics.ekonomi.R;

/**
 * Created by Prince on 11/5/2014.
 */
public class FragmentSectionUtkomst extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_section_utkomst, container, false);
        return rootView;
    }
}
