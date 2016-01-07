package com.example.yakuza.animation;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * A placeholder fragment containing a simple view.
 */
public class ShareActivity1Fragment extends Fragment {

    ImageView imageList;
    FragmentInteraction mListener;
    public ShareActivity1Fragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_share1, container, false);
        ListView list = (ListView) root.findViewById(R.id.list);
        ArrayList<RowItem> arrayList = new ArrayList<>(5);
        imageList = (ImageView) root.findViewById(R.id.list_image);

        for (int i = 0; i < 4; i++) {
            RowItem rowItem = new RowItem("s");
            arrayList.add(i, rowItem);
        }

        CustomAdapter ca = new CustomAdapter(getActivity(), arrayList);
        list.setAdapter(ca);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ImageView image = (ImageView)view.findViewById(R.id.list_image);
                //image.setTransitionName("xyz"+position);
              Log.d("transition","Selected Position "+image.getTransitionName());
                mListener.onInteraction(getActivity(), image);
            }
        });

    return root;
    }
    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            mListener = (FragmentInteraction) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }


    public interface FragmentInteraction{
        void onInteraction(Context context,View view);

    }


}
