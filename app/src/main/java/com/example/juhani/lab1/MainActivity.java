package com.example.juhani.lab1;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.support.v7.widget.Toolbar;

public class MainActivity extends AppCompatActivity {

    private Boolean textState = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button nextActivityButton = (Button) findViewById(R.id.nextActivityButton);
        Button btn = (Button) findViewById(R.id.changeTextButton);
        final TextView firstTextView = (TextView) findViewById(R.id.firstTextView);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!textState){
                    firstTextView.setText(R.string.alternateFirstString);
                    textState= true;
                }else {
                    firstTextView.setText(R.string.firstString);
                    textState = false;
                }
            }
        });

        nextActivityButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(MainActivity.this,SecondActivity.class);
                startActivity(intent);
            }
        });


        //1: create reference for sharedPreferences and get default preferences
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);

        //2: create instance of OnSharedPreferenceChangeListener and reference it as listener
        SharedPreferences.OnSharedPreferenceChangeListener listener;

        //4. Use instance field for listener
        // It will not be gc'd as long as this instance is kept referenced
        listener = new SharedPreferences.OnSharedPreferenceChangeListener() {
            public void onSharedPreferenceChanged(SharedPreferences prefs, String key) {

                System.out.println("what has changed: " + prefs + key);

                //5. make variable based on the preference that is changed
                String changedPreference = (prefs.getString(key, ""));

                System.out.println("changedPreference: "+ changedPreference);

                //change text view color (and value)
                firstTextView.setText(changedPreference);
                firstTextView.setTextColor(Color.parseColor(changedPreference));

            }
        };

        //3. register to prefs a listener created
        prefs.registerOnSharedPreferenceChangeListener(listener);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if(id==R.id.action_settings){
            Intent i = new Intent(this, MyPreferencesActivity.class);
            startActivity(i);

        }
        return super.onOptionsItemSelected(item);
    }
}
