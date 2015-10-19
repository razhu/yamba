package com.casasmap.yamba;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by ramiro on 10/19/15.
 */
public class SettingsActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(savedInstanceState == null){

            //create a fragment
            SettingsFragment fragment = new SettingsFragment();
            getFragmentManager().beginTransaction().add(android.R.id.content, fragment, fragment.getClass().getSimpleName()).commit();
        }
    }
}
