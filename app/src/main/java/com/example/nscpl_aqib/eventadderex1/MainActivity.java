package com.example.nscpl_aqib.eventadderex1;

import android.content.Intent;
import android.provider.CalendarContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void onAddEventClicked(View view){
        Intent intent=new Intent(Intent.ACTION_INSERT);
        intent.setType("vnd.android.cursor.item/event");
        Calendar calendar=Calendar.getInstance();
        long startTime = calendar.getTimeInMillis();
        long endTime = calendar.getTimeInMillis() + 60 * 60 * 1000;
        intent.putExtra(CalendarContract.EXTRA_EVENT_BEGIN_TIME,startTime);
        intent.putExtra(CalendarContract.EXTRA_EVENT_END_TIME,endTime);
        intent.putExtra(CalendarContract.EXTRA_EVENT_ALL_DAY,true);

        //below code for events

        intent.putExtra(CalendarContract.Events.TITLE,"Happy Birthday");
        intent.putExtra(CalendarContract.Events.DESCRIPTION, "This is the sample description");
        intent.putExtra(CalendarContract.Events.EVENT_LOCATION,"My Home");
        intent.putExtra(CalendarContract.Events.RRULE,"FREQ=YEARLY");
        startActivity(intent);

    }
}
