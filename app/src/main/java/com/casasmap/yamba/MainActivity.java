package com.casasmap.yamba;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

/**
 * Created by ramiro on 10/19/15.
 */
public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.action_settings_new:
                startActivity(new Intent(this, SettingsActivity.class));
                return true;
            case R.id.action_tweet:
                startActivity(new Intent("com.casasmap.android.yamba.action.tweet"));
                return true;
            default:
                return false;
        }

    }
}
