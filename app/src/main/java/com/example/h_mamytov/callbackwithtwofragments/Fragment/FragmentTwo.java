package com.example.h_mamytov.callbackwithtwofragments.Fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.example.h_mamytov.callbackwithtwofragments.R;

public class FragmentTwo extends Fragment{

    private static final int LAYOUT = R.layout.fragment_two;

    private ImageView imageView;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(LAYOUT, container, false);
        imageView = view.findViewById(R.id.image_view_one);
        return view;
    }

    public ImageView getImageView() {
        return imageView;
    }

    public void changeBackground(){
        int color = 65280;
        getImageView().setBackgroundColor(color);
    }

}
