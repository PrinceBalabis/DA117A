package com.princetronics.ekonomi;

import java.util.Locale;

import android.app.ActionBar;
import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.support.v4.app.FragmentActivity;
import com.princetronics.ekonomi.Database.DatabaseController;
import com.princetronics.ekonomi.Fragments.FragmentDialogLogin;
import com.princetronics.ekonomi.Fragments.ListInkomst;
import com.princetronics.ekonomi.Fragments.FragmentSectionOversikt;
import com.princetronics.ekonomi.Fragments.FragmentSectionUtkomst;


public class MainActivity extends FragmentActivity implements Callback, ActionBar.TabListener  {

    // TAG1
    private static final String TAG = "MainActivity";

    // Fragment section adapter
    SectionsPagerAdapter mSectionsPagerAdapter;
    ViewPager mViewPager;

    // Database
    private static SharedPreferences preferences;
    private SharedPreferences.Editor editor;
    private DatabaseController databaseController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loginDialogInit();
    }

private void SectionAdapterInit(){
    // Set up the action bar.
    final ActionBar actionBar = getActionBar();
    actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

    // Create the adapter that will return a fragment for each of the three
    // primary sections of the activity.
    mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

    // Set up the ViewPager with the sections adapter.
    mViewPager = (ViewPager) findViewById(R.id.pager);
    mViewPager.setAdapter(mSectionsPagerAdapter);

    // When swiping between different sections, select the corresponding
    // tab. We can also use ActionBar.Tab#select() to do this if we have
    // a reference to the Tab.
    mViewPager.setOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() {
        @Override
        public void onPageSelected(int position) {
            actionBar.setSelectedNavigationItem(position);
        }
    });

    // For each of the sections in the app, add a tab to the action bar.
    for (int i = 0; i < mSectionsPagerAdapter.getCount(); i++) {
        // Create a tab with text corresponding to the page title defined by
        // the adapter. Also specify this Activity object, which implements
        // the TabListener interface, as the callback (listener) for when
        // this tab is selected.
        actionBar.addTab(
                actionBar.newTab()
                        .setText(mSectionsPagerAdapter.getPageTitle(i))
                        .setTabListener(this));
    }

}

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void updateGUI() {
        Log.i(TAG, "Update GUI method callback");

        DatabaseInit();
        SectionAdapterInit();
    }

    @Override
    public void onTabSelected(ActionBar.Tab tab, android.app.FragmentTransaction ft) {
        mViewPager.setCurrentItem(tab.getPosition());

    }

    @Override
    public void onTabUnselected(ActionBar.Tab tab, android.app.FragmentTransaction ft) {

    }

    @Override
    public void onTabReselected(ActionBar.Tab tab, android.app.FragmentTransaction ft) {

    }

    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            // getItem is called to instantiate the fragment for the given page.
            // Return a PlaceholderFragment (defined as a static inner class below).

            switch (position) {
                case 0:
                    return new FragmentSectionOversikt();
                case 1:
                    Fragment fragmentSectionInkomst = new ListInkomst();
                    return fragmentSectionInkomst;
                case 2:
//                    Fragment fragmentSectionUtkomst = new FragmentSectionUtkomst();
//                    return fragmentSectionUtkomst;
                return new FragmentSectionOversikt();
            }
            return null;

        }

        @Override
        public int getCount() {
            // Show 3 total pages.
            return 3;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            Locale l = Locale.getDefault();
            switch (position) {
                case 0:
                    return getString(R.string.section_oversikt).toUpperCase(l);
                case 1:
                    return getString(R.string.section_inkomst).toUpperCase(l);
                case 2:
                    return getString(R.string.section_utkomst).toUpperCase(l);
            }
            return null;
        }
    }

    private void loginDialogInit(){
        new FragmentDialogLogin().show(getFragmentManager(), TAG);
    }

    private void DatabaseInit(){
        preferences = getSharedPreferences("anvandare", 0);
        String anvandare = preferences.getString("etFornamn", "null") + " " +
                preferences.getString("etEfternamn", "null");
        databaseController = new DatabaseController(this, anvandare);

        // Debug
        Log.i(TAG, "Förnamn: " + preferences.getString("etFornamn", "null"));
        Log.i(TAG, "Efternamn: " + preferences.getString("etEfternamn", "null"));
    }
}
