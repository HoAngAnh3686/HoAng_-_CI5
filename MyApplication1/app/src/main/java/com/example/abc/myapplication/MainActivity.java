package com.example.abc.myapplication;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getRefereces();
        addListener();
    }

    private void addListener() {
        imageView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                showDialog();
            }
        });

    }

    private void getRefereces() {
        imageView = (ImageView) findViewById(R.id.image);
    }

    private void showDialog() {
        FragmentManager fragmentManager = getSupportFragmentManager();
        DetailFragment detailFragment = new DetailFragment();
        detailFragment.show(fragmentManager,"a");
    }


}
