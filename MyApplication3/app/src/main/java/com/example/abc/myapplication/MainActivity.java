package com.example.abc.myapplication;

import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    ArrayAdapter listAdapter;
    @BindView(R.id.lv_list)
    ListView listView;
    public String[] main = new String[]{
            "07.02",
            "08.02",
            "08.05",
            "09.01",
            "09.02"
    };

    public ArrayList<String> arrayList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        setupUI();
        addListener();
    }

    private void setupUI() {
        add();
        listAdapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,arrayList);
        listView.setAdapter(listAdapter);
    }

    private void add() {
        for (String name : main) {
            arrayList.add(name);
        }
    }

    private void addListener() {
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


                FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();


                switch (position) {
                    case 0:
                        Turn1Fragment turn1Fragment = new Turn1Fragment();
                        fragmentTransaction.replace(R.id.activity_main, turn1Fragment);
                        break;
                    case 1:
                        Turn1_1Fragment turn1_1Fragment = new Turn1_1Fragment();
                        fragmentTransaction.replace(R.id.activity_main, turn1_1Fragment);
                        break;
                    case 2:
                        Turn1_2Fragment turn1_2Fragment = new Turn1_2Fragment();
                        fragmentTransaction.replace(R.id.activity_main, turn1_2Fragment);
                        break;
                    case 3:
                        Turn1_3Fragment turn1_3Fragment = new Turn1_3Fragment();
                        fragmentTransaction.replace(R.id.activity_main, turn1_3Fragment);
                        break;
                    case 4:
                        Turn1_4Fragment turn1_4Fragment = new Turn1_4Fragment();
                        fragmentTransaction.replace(R.id.activity_main, turn1_4Fragment);
                         break;

                }


                fragmentTransaction.addToBackStack(null);

                fragmentTransaction.commit();

            }
        });
    }
}
