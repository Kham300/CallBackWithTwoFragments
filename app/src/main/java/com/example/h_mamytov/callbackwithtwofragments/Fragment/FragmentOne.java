package com.example.h_mamytov.callbackwithtwofragments.Fragment;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.example.h_mamytov.callbackwithtwofragments.Adapter.AdapterOne;
import com.example.h_mamytov.callbackwithtwofragments.R;

public class FragmentOne extends Fragment implements AdapterOne.ChangeFragmentTwoBackgroundCallback {

    AskActivityToChangeFragmentTwoBackGroundCallBack callBackToActivity;

    private static final int LAYOUT = R.layout.fragment_one;

    @SuppressLint("StaticFieldLeak")
    private static ImageView imageView;

    private AdapterOne adapterOne;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(LAYOUT, container, false);
        imageView = view.findViewById(R.id.image_view_one);
        adapterOne = new AdapterOne();
        adapterOne.setCallback(this);

        Button button = view.findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeBackground();
            }
        });
        return view;
    }

    @Override
    public void onAttach(Context context){
        super.onAttach(context);
        if (context instanceof AskActivityToChangeFragmentTwoBackGroundCallBack){
            callBackToActivity = (AskActivityToChangeFragmentTwoBackGroundCallBack) context;
        } else {
            throw new RuntimeException(context.toString()+
            "must implement AskActivityToChangeFragmentTwoBackGroundCallBack");
        }
    }

    @Override
    public void onDetach(){
        super.onDetach();
        callBackToActivity = null;
    }

    public static ImageView getImageView() {
        return imageView;
    }

    public void changeBackground(){
        adapterOne.changeBackGround();
    }

    @Override
    public void changeBackGroundOfFragmentTwo() {
        callBackToActivity.changeBackGroundFromActivityToFragmentTwo();
    }

    public interface AskActivityToChangeFragmentTwoBackGroundCallBack{
        void changeBackGroundFromActivityToFragmentTwo();
    }

    public void setCallBackToActivity(AskActivityToChangeFragmentTwoBackGroundCallBack callBackToActivity) {
        this.callBackToActivity = callBackToActivity;
    }
}
