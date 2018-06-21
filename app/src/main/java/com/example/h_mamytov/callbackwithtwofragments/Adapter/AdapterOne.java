package com.example.h_mamytov.callbackwithtwofragments.Adapter;


import com.example.h_mamytov.callbackwithtwofragments.Fragment.FragmentOne;

public class AdapterOne {

    ChangeFragmentTwoBackgroundCallback callback;

    private final int color = 16711680;


    public void changeBackGround(){
      FragmentOne.getImageView().setBackgroundColor(color);
      callback.changeBackGroundOfFragmentTwo();
    }

    public interface ChangeFragmentTwoBackgroundCallback{
        void changeBackGroundOfFragmentTwo();
    }

    public void setCallback(ChangeFragmentTwoBackgroundCallback callback) {
        this.callback = callback;
    }
}
