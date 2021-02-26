package com.oyatech.jobsheduler;


import android.annotation.SuppressLint;
import android.app.job.JobParameters;
import android.app.job.JobService;

import android.os.AsyncTask;
import android.util.Log;


public class TextSetterJobScheduler extends JobService {
 static public  String NUMBER_TO_INTEGER = "Number_to_Integer";
   public static String numberToString ;
    private WelcomeSetter mWelcomeSetter;
final static String TAG     = TextSetterJobScheduler.class.getSimpleName();

    @Override
    public boolean onStartJob(JobParameters pJobParameters) {
        Log.d(TAG, "onStartJob: called");

        mWelcomeSetter = new WelcomeSetter(this);
 AsyncTask<JobParameters,Void,Integer> asyncTask = new AsyncTask<JobParameters, Void, Integer>() {
            @Override
            protected Integer doInBackground(JobParameters... setTextParams) {
                JobParameters parameters = setTextParams[0];
                String string = parameters.getExtras().getString(NUMBER_TO_INTEGER);

                int number = Integer.parseInt(string);
             String finalResult = mWelcomeSetter.setFinalString(number);
                 //   welcomeText.setWelcome();
                Log.d(TAG, "doInBackground: "+ finalResult);
               return null;
            }

     @Override
     protected void onPostExecute(Integer integer) {
         super.onPostExecute(integer);
     }
 };
   asyncTask.execute(pJobParameters);
        return true;
    }

    @Override
    public boolean onStopJob(JobParameters pJobParameters) {
        return false;
    }


}
