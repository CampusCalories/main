package com.example.austin.campuscalories;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import com.example.austin.campuscalories.LocationClass;
import android.content.Intent;
import android.widget.TextView;

public class DisplayInfoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_display_info);
        Intent i = getIntent();
        LocationClass newLocation = (LocationClass)i.getSerializableExtra("Object");
        TextView text = new TextView(this);
        text.setTextSize(20);
        String additionalInfoString =
                newLocation.getName() +
                "\n\nHours of Operation:" +
                "\nSun CLOSED" +
                "\nMon 7am-6pm" +
                "\nTue 7am-6pm" +
                "\nWed 7am-6pm" +
                "\nThu 7am-6pm" +
                "\nFri 7am-6pm" +
                "\nSat CLOSED" +
                "\n\nMenu:";

        text.setText(additionalInfoString);
        setContentView(text);
    }


}
