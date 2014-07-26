package com.dingpw.android.setting.update;


import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.AsyncTask;
import android.widget.Button;

import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by dingpw on 7/26/14.
 */
public class UpdateView extends Button {
//    private static final long PERIOD_DAY = 24 * 60 * 60 * 1000;
    private static final long PERIOD_DAY = 100;


    public UpdateView(Context context) {
        super(context);
        this.setViewLength();
        this.showCurrentVersionView();

        this.scheduleTask();
    }

    private void setViewLength(){
        this.setWidth(330);
        this.setEnabled(false);
    }

    private void showCurrentVersionView(){
        try {
            PackageManager packageManager = this.getContext().getPackageManager();
            PackageInfo packInfo = packageManager.getPackageInfo(this.getContext().getPackageName(),0);
            String version = packInfo.versionName;
            this.setText(this.getContext().getString(R.string.string_com_dingpw_android_setting_update_version) + version);
        }catch (Exception e){
            this.setText(R.string.string_com_dingpw_android_setting_update_unknown);
        }
    }


    private void scheduleTask (){
        Calendar calendar = Calendar.getInstance();
//        calendar.set(Calendar.HOUR_OF_DAY, 2);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        Date date=calendar.getTime();
//        if (date.before(new Date())) {
//            Calendar startDT = Calendar.getInstance();
//            startDT.setTime(date);
//            startDT.add(Calendar.DAY_OF_MONTH, 1);
//            date = startDT.getTime();
//        }
        Timer timer = new Timer();
        UpdateTask task = new UpdateTask();
        timer.schedule(task,date,PERIOD_DAY);
    }

    private class UpdateTask extends TimerTask {
        @Override
        public void run() {
            try {
                Thread.sleep(100000000);
            }catch (Exception e){

            }
        }
    }



    class UpdateProgressTask extends AsyncTask<Void,Integer,Integer> {

        public UpdateProgressTask() {
            super();
        }

        @Override
        protected Integer doInBackground(Void... voids) {
            return null;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected void onPostExecute(Integer integer) {
            super.onPostExecute(integer);
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
        }

        @Override
        protected void onCancelled(Integer integer) {
            super.onCancelled(integer);
        }

        @Override
        protected void onCancelled() {
            super.onCancelled();
        }
    }




    }
