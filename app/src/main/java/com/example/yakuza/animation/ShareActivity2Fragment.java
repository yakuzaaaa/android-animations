package com.example.yakuza.animation;

import android.app.Fragment;
import android.media.Image;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

/**
 * A placeholder fragment containing a simple view.
 */
public class ShareActivity2Fragment extends Fragment {

    String mTransitionName;
    public void setmTransitionName(String name)
    {
        mTransitionName = name;
    }

    public ShareActivity2Fragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root =  inflater.inflate(R.layout.fragment_share2,container,false);

        ImageView image =  (ImageView)root.findViewById(R.id.imageBig);

        Bundle arg = this.getArguments();
        if(arg == null)
        {
           mTransitionName =  getActivity().getIntent().getStringExtra("transitionName");

            image.setTransitionName(mTransitionName);
            Log.d("transition",image.getTransitionName()+" transition name in fragment");

        }
        else
        {
            image.setTransitionName(arg.getString("transitionName"));
        }
        return root;
    }
}
