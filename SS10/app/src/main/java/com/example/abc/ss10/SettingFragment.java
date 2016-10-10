package com.example.abc.ss10;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class SettingFragment extends Fragment {


    public SettingFragment() {
        // Required empty public constructor
    }

    @Override
    public void onStart() {
        super.onStart();
        ((MainActivity) getActivity()).showActionBar(true);
        ((MainActivity) getActivity()).showSendMenu(false);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
//        ((AppCompatActivity) getActivity()).getSupportActionBar().show();
        ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle("Setting");
        return inflater.inflate(R.layout.fragment_setting, container, false);
    }

}
