package com.oyatech.jobsheduler;

import androidx.appcompat.app.AppCompatActivity;

import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import static com.oyatech.jobsheduler.TextSetterJobScheduler.NUMBER_TO_INTEGER;
import static com.oyatech.jobsheduler.TextSetterJobScheduler.numberToString;

public class MainActivity extends AppCompatActivity {
final static String TAG = MainActivity.class.getSimpleName();
    public static final int JOB_ID = 1;

    TextView mWelcome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mWelcome = findViewById(R.id.hello);

    }
    public void setWelcome() {
//Describing the job that needs the a JobScheduler
        PersistableBundle bundle = new PersistableBundle();
        bundle.putString(NUMBER_TO_INTEGER,"23");

        ComponentName componentName = new ComponentName(this,TextSetterJobScheduler.class);

        JobInfo jobInfo = new JobInfo.Builder(JOB_ID,componentName)//the jobInfo containing its Id and the component name
                .setRequiredNetworkType(JobInfo.NETWORK_TYPE_CELLULAR)//setting the criteria
                .setExtras(bundle)
                .build();

        JobScheduler scheduler = (JobScheduler) getSystemService(JOB_SCHEDULER_SERVICE);
        scheduler.schedule(jobInfo);
    }


    public void Jobber(View view) {

        setWelcome();
        Log.d("JObber Method", "Jobber() returned: Called" );
    }


}