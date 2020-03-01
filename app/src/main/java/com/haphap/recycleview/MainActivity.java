package com.haphap.recycleview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;

import com.haphap.recycleview.Fragment.HomeFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Fragment fragment = new HomeFragment();
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, fragment, fragment.getClass().getSimpleName())
                .commit();

    }
}
