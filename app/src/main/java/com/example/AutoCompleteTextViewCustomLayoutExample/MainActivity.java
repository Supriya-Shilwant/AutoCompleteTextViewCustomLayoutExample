package com.example.AutoCompleteTextViewCustomLayoutExample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AutoCompleteTextView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<CountryItem> countryList;
    private TextView tvDisplay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fillCountryList();

        tvDisplay = (TextView) findViewById(R.id.tvDisplay);
        AutoCompleteTextView editText = findViewById(R.id.actv);
        AutoCompleteCountryAdapter adapter = new AutoCompleteCountryAdapter(this, countryList);
        editText.setAdapter(adapter);

        editText.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // fetch the user selected value
                CountryItem item = (CountryItem) parent.getItemAtPosition(position);

                // set user selected value to the TextView
                if (item != null)
                    tvDisplay.setText(item.getCountryName());
            }
        });
    }

    private void fillCountryList() {
        countryList = new ArrayList<>();
        countryList.add(new CountryItem("India", R.drawable.flag_india));
        countryList.add(new CountryItem("Indonesia", R.drawable.flag_indonesia));
        countryList.add(new CountryItem("Australia", R.drawable.flag_australia));
        countryList.add(new CountryItem("Bangladesh", R.drawable.flag_angladesh));
        countryList.add(new CountryItem("Philippines", R.drawable.flag_philippines));
        countryList.add(new CountryItem("USA", R.drawable.flag_usa));
        countryList.add(new CountryItem("Pakistan", R.drawable.flag_pakistan));
        countryList.add(new CountryItem("Vietnam", R.drawable.flag_vietnam));
        countryList.add(new CountryItem("Japan", R.drawable.flag_japan));
    }
}