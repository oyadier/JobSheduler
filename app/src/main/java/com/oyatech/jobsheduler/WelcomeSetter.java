package com.oyatech.jobsheduler;

import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import android.os.PersistableBundle;

import androidx.appcompat.app.AppCompatActivity;

import static android.content.Context.JOB_SCHEDULER_SERVICE;
import static com.oyatech.jobsheduler.MainActivity.JOB_ID;
import static com.oyatech.jobsheduler.TextSetterJobScheduler.NUMBER_TO_INTEGER;

public class WelcomeSetter {
    Context mContext;
    private String finalString;

    public String getFinalString() {
        return finalString;
    }

    public WelcomeSetter(Context pContext) {
        mContext = pContext;
    }

    public String setFinalString(int number)
    {
        int numbe = 23 + number;

        return numbe + "";
    }

}
