package com.princetronics.ekonomi.Fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.princetronics.ekonomi.R;

/**
 * Created by Prince on 11/6/2014.
 */
public class FragmentSectionInkomst extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_section_inkomst, container, false);
        return rootView;
    }
}
