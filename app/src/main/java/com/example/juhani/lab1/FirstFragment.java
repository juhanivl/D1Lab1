package com.example.juhani.lab1;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;

/**
 * Created by Juhani on 29.8.2016.
 */
public class FirstFragment extends Fragment {

    private static final String Fname = "kstest.test";


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.first_fragment, container, false);


        final EditText et = (EditText) view.findViewById(R.id.editableText);
        Button saveButton = (Button) view.findViewById(R.id.saveText);

        saveButton.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                try {
                    FileOutputStream fOs =  getActivity().openFileOutput(Fname, Context.MODE_APPEND);
                    OutputStreamWriter oSw = new OutputStreamWriter(fOs);
                    BufferedWriter bw = new BufferedWriter(oSw);
                    bw.write(et.getText().toString());
                    bw.flush();
                    bw.close();
                    oSw.close();
                    fOs.close();
                }
                catch (Exception e) {
                    Log.d("onClick", e.toString());
                }
            }
        });



        return view;
    }

}
