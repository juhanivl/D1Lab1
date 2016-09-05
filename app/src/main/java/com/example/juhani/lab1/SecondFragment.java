package com.example.juhani.lab1;

import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Created by Juhani on 29.8.2016.
 */
public class SecondFragment extends Fragment {

    private static final String Fname = "kstest.test";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.second_fragment, container, false);

        TextView sharedText = (TextView) view.findViewById(R.id.sharedText);

        try {
            int content;
            BufferedReader br = new BufferedReader(new InputStreamReader(getActivity().openFileInput(Fname)));
            String fContent="";
            while ((content = br.read()) != -1) {
                fContent = fContent+(char)content;
            }
            sharedText.setText(fContent);
            br.close();
        }
        catch (Exception e) {
            Log.d("ERROR", e.toString());
        }

        return view;

    }

}
