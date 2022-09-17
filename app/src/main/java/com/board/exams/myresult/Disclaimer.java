package com.board.exams.myresult;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;

public class Disclaimer {

    public static void mo13133o(Context context) {
        AlertDialog.Builder aVar = new  AlertDialog.Builder(context);
        aVar.setIcon((int) R.mipmap.ic_launcher);
        aVar.setTitle("Disclaimer  ");
        aVar.setCancelable(false);
        aVar.setMessage((CharSequence)context. getString(R.string.disclaimer));
        aVar.setPositiveButton("OK", (DialogInterface.OnClickListener) null);
        aVar.show();
    }
}
