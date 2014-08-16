package com.dingpw.android.setting.sample;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.Window;
import com.dingpw.android.setting.about.AboutView;

/**
 * Created by dingpw on 7/26/14.
 */
public class MainActivity extends Activity {

    private AlertDialog alertDialog = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.activity_main);
        this.alertDialog = new AlertDialog.Builder(this).create();
    }


    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(this.alertDialog.isShowing()){
            this.alertDialog.dismiss();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    @Override
    public boolean onKeyUp(int keyCode, KeyEvent event) {
        if(keyCode == KeyEvent.KEYCODE_MENU){
            this.alertDialog.show();
            Window window = this.alertDialog.getWindow();
            window.setContentView(new AboutView(this));
        }
        return super.onKeyUp(keyCode, event);
    }
}
