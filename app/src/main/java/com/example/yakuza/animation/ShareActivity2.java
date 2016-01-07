package com.example.yakuza.animation;

import android.os.Bundle;
import android.app.Activity;
import android.util.Log;

public class ShareActivity2 extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Bundle args = new Bundle();
        args.putString("transitionName", getIntent().getStringExtra("transitionName"));
        ShareActivity2Fragment fragment = new ShareActivity2Fragment();
        fragment.setArguments(args);

        setContentView(R.layout.activity_share2);


        getActionBar().setDisplayHomeAsUpEnabled(true);
    }

}
