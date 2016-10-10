package com.example.abc.ss10;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;


/**
 * A simple {@link Fragment} subclass.
 */
public class PayEndFragment extends Fragment {

    ImageView imageView;

    public PayEndFragment() {
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
        View view = inflater.inflate(R.layout.fragment_pay_end, container, false);
        imageView = (ImageView) view.findViewById(R.id.im_check);
        addListener();

        return view;
    }

    private void addListener() {
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragmentManager().popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
                ((MainActivity) getActivity()).showActionBar(true);
                ((MainActivity) getActivity()).setMenuBar(true);
                ((MainActivity) getActivity()).showSendMenu(false);

            }
        });
    }

}
