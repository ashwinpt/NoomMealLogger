package com.ashwin.framework.noommeallogger;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.ashwin.framework.noommeallogger.view.FoodSearchFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.app_container_view);

        if (savedInstanceState == null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .setReorderingAllowed(true)
                    .add(R.id.app_container, FoodSearchFragment.class, null)
                    .commit();
        }
    }
}