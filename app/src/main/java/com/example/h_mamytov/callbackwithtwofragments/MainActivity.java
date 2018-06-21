package com.example.h_mamytov.callbackwithtwofragments;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.h_mamytov.callbackwithtwofragments.Fragment.FragmentOne;
import com.example.h_mamytov.callbackwithtwofragments.Fragment.FragmentTwo;

public class MainActivity extends AppCompatActivity implements FragmentOne.AskActivityToChangeFragmentTwoBackGroundCallBack {


    private static final String ONE_TAG = "one";
    private static final String TWO_TAG = "two";
    FragmentOne fragmentOne;
    FragmentTwo fragmentTwo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // add fragments
        FragmentManager fragmentManager = getSupportFragmentManager();

        fragmentOne = (FragmentOne) fragmentManager.findFragmentByTag(ONE_TAG);
        if (fragmentOne == null) {
            fragmentOne = new FragmentOne();
            fragmentManager.beginTransaction().add(R.id.fragment1, fragmentOne, ONE_TAG).commit();
        }

        fragmentTwo = (FragmentTwo) fragmentManager.findFragmentByTag(TWO_TAG);
        if (fragmentTwo == null) {
            fragmentTwo = new FragmentTwo();
            fragmentManager.beginTransaction().add(R.id.fragment2, fragmentTwo, TWO_TAG).commit();
        }
    }

    @Override
    public void changeBackGroundFromActivityToFragmentTwo() {
        fragmentTwo.changeBackground();
    }

}
