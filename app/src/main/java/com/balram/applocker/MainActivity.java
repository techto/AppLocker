package com.balram.applocker;

import android.os.Bundle;

import com.balram.library.LockActivity;


/**
 * Created by Balram Pandey 12/11/16.
 */

public class MainActivity extends LockActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
