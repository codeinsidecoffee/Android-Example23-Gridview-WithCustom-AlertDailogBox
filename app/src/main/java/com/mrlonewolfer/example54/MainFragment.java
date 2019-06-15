package com.mrlonewolfer.example54;


import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ImageView;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class MainFragment extends Fragment {


    GridView gridView;
    ArrayList<ImageBean> imgArrayList;
    Context context;

    public MainFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        context=getContext();
        View view= inflater.inflate(R.layout.fragment_main, container, false);
        gridView=view.findViewById(R.id.gridView);

        preaparedData();
        ImageAdapter imageAdapter= new ImageAdapter(context,imgArrayList);
        gridView.setAdapter(imageAdapter);

        return  view;
    }

    private void preaparedData() {
    imgArrayList= new ArrayList<>();
    imgArrayList.add(new ImageBean(R.drawable.add,"Add"));
    imgArrayList.add(new ImageBean(R.drawable.edit,"Edit"));
    imgArrayList.add(new ImageBean(R.drawable.view,"View"));
    imgArrayList.add(new ImageBean(R.drawable.report,"Report"));
    imgArrayList.add(new ImageBean(R.drawable.setting,"Setting"));
    imgArrayList.add(new ImageBean(R.drawable.search,"Search"));

    }

}
