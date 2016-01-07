package com.example.yakuza.animation;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

public class ShareActivity1 extends Activity implements ShareActivity1Fragment.FragmentInteraction {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_share1);
        getActionBar().setDisplayHomeAsUpEnabled(true);
    }

//
//    public void doTransitionsOnNextActivityWithFragment(View view)
//    {
//        View image = (ImageView)(findViewById(R.id.imageSmall));
//        ActivityOptionsCompat optionsCompat = ActivityOptionsCompat.makeSceneTransitionAnimation(this,image,image.getTransitionName());
//        Intent activityNext = new Intent(this,ShareActivity2.class);
//        ActivityCompat.startActivity(this, activityNext, optionsCompat.toBundle());
//    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        } else if (id == android.R.id.home) {
            onBackPressed();
        }



        return super.onOptionsItemSelected(item);


    }

    @Override
    public void onInteraction(Context context,View view) {


        ActivityOptionsCompat optionsCompat = ActivityOptionsCompat.makeSceneTransitionAnimation(this, view, view.getTransitionName());
        Intent activityNext = new Intent(this,ShareActivity2.class);
        activityNext.putExtra("transitionName",view.getTransitionName());
        Log.d("transition", view.getTransitionName() + " is the transition name in list");

        ActivityCompat.startActivity(this, activityNext, optionsCompat.toBundle());



    }
}
