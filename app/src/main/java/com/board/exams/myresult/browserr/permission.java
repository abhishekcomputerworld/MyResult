package com.board.exams.myresult.browserr;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;

import androidx.appcompat.app.AlertDialog;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.board.exams.myresult.R;


public class permission {


    public static boolean m38910a(Activity activity) {
        String str = "android.permission.READ_EXTERNAL_STORAGE";
        try {
            String str2 = "android.permission.WRITE_EXTERNAL_STORAGE";
            if (ContextCompat.checkSelfPermission((Context) activity, str) == 0) {
                if (ContextCompat.checkSelfPermission((Context) activity, str2) == 0) {
                    return true;
                }
            }
            if (ActivityCompat.shouldShowRequestPermissionRationale(activity, str2)) {
                m38909a(activity);
            } else {
                ActivityCompat.requestPermissions(activity, new String[]{str, str2}, 100);
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static void m38909a(final Activity activity) {
        final AlertDialog a = new AlertDialog.Builder(activity).create();
        View inflate = LayoutInflater.from(activity).inflate(R.layout.need_permission, null);
        inflate.findViewById(R.id.iv_close).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                a.dismiss();
            }
        });
        inflate.findViewById(R.id.tv_allow).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ActivityCompat.requestPermissions(activity, new String[]{"android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE"}, 12);
                a.dismiss();
            }
        });
        a.setView(inflate);
        a.show();
    }


}