package com.dingpw.android.setting.about;

import android.content.Context;
import android.text.util.Linkify;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.dingpw.android.setting.update.UpdateView;

/**
 * Created by dingpw on 7/26/14.
 */
public class AboutView extends RelativeLayout {

    public AboutView(Context context) {
        super(context);
        this.addLogo();
        this.addHomepage();
        this.addEmail();
        this.addUpdate();
    }


    private void addLogo(){
        ImageView logo = new ImageView(this.getContext());
        logo.setId(R.id.com_dingpw_android_setting_about_logo_id);
        logo.setTag(R.drawable.icon);
        logo.setImageResource(R.drawable.icon);
        LayoutParams logoLayoutParams = new LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT);
        logoLayoutParams.addRule(RelativeLayout.CENTER_HORIZONTAL);
        logo.setLayoutParams(logoLayoutParams);
        logo.setOnClickListener(new OnLogoClickListener());
        this.addView(logo);
    }


    private void addHomepage(){
        TextView homepage = new TextView(this.getContext());
        homepage.setAutoLinkMask(Linkify.WEB_URLS);
        homepage.setTextSize(20);
        homepage.setId(R.id.com_dingpw_android_setting_about_homepage_id);
        homepage.setText(R.string.string_com_dingpw_android_setting_about_homepage);
        LayoutParams homepageLayoutParams = new LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT);
        homepageLayoutParams.setMargins(0,10,0,0);
        homepageLayoutParams.addRule(RelativeLayout.CENTER_HORIZONTAL);
        homepageLayoutParams.addRule(RelativeLayout.BELOW,R.id.com_dingpw_android_setting_about_logo_id);
        homepage.setLayoutParams(homepageLayoutParams);
        this.addView(homepage);
    }

    private void addEmail(){
        TextView email = new TextView(this.getContext());
        email.setAutoLinkMask(Linkify.EMAIL_ADDRESSES);
        email.setTextSize(20);
        email.setId(R.id.com_dingpw_android_setting_about_email_id);
        email.setText(R.string.string_com_dingpw_android_setting_about_email);
        LayoutParams emailLayoutParams = new LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT);
        emailLayoutParams.setMargins(0,10,0,0);
        emailLayoutParams.addRule(RelativeLayout.CENTER_HORIZONTAL);
        emailLayoutParams.addRule(RelativeLayout.BELOW,R.id.com_dingpw_android_setting_about_homepage_id);
        email.setLayoutParams(emailLayoutParams);
        this.addView(email);
    }


    private void addUpdate(){
        UpdateView update = new UpdateView(this.getContext());
        update.setId(R.id.com_dingpw_android_setting_about_update_id);
        LayoutParams updateLayoutParams = new LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT);
        updateLayoutParams.setMargins(0,10,0,0);
        updateLayoutParams.addRule(RelativeLayout.CENTER_HORIZONTAL);
        updateLayoutParams.addRule(RelativeLayout.BELOW,R.id.com_dingpw_android_setting_about_email_id);
        update.setLayoutParams(updateLayoutParams);
        this.addView(update);
    }



    private class OnLogoClickListener implements OnClickListener{
        @Override
        public void onClick(View view) {
            if(R.drawable.icon== Integer.parseInt(view.getTag().toString())){
                ((ImageView)view).setImageResource(R.drawable.qrcode);
                view.setTag(R.drawable.qrcode);
            }else{
                ((ImageView)view).setImageResource(R.drawable.icon);
                view.setTag(R.drawable.icon);
            }
        }
    }





}
