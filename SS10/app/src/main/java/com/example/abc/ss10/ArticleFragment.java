package com.example.abc.ss10;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import static com.example.abc.ss10.R.id.imageView;


/**
 * A simple {@link Fragment} subclass.
 */
public class ArticleFragment extends Fragment {

    ImageView imageView;
    public ArticleFragment() {
        // Required empty public constructor

    }

    @Override
    public void onStart() {
        super.onStart();
        ((MainActivity) getActivity()).showActionBar(false);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_article, container, false);
//        ((AppCompatActivity) getActivity()).getSupportActionBar().hide();
        imageView = (ImageView) view.findViewById(R.id.im_back);
        addListener();

        return view;
    }

    private void addListener() {
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragmentManager().popBackStack();
                ((MainActivity) getActivity()).showActionBar(true);
                ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle("HOME");

            }
        });
    }

}
