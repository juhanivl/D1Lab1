package com.example.juhani.lab1;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.support.v7.widget.Toolbar;


/**
 * Created by Juhani on 29.8.2016.
 */
public class SecondActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_activity);


        Button firstFragmentButton = (Button)findViewById(R.id.firstFragment);
        Button secondFragmentButton = (Button)findViewById(R.id.secondFragment);

        // Create new fragment and transaction
        final Fragment firstFragment = new FirstFragment();
        final Fragment secondFragment = new SecondFragment();


        firstFragmentButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {



                FragmentManager fm = getFragmentManager();
                FragmentTransaction transaction = fm.beginTransaction();
                transaction.replace(R.id.contentFragment, firstFragment);
                transaction.commit();

            }
        });


        secondFragmentButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                FragmentManager fm = getFragmentManager();
                FragmentTransaction transaction = fm.beginTransaction();
                transaction.replace(R.id.contentFragment, secondFragment);
                transaction.commit();

            }
        });


    }
}
