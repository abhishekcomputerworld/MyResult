package com.board.exams.myresult;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.app.AlertDialog;
import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.board.exams.myresult.browserr.Browser_Main;

public class more_app extends AppCompatActivity {

    public String f16214s;

    class C3267a implements AdapterView.OnItemClickListener {

        /* renamed from: b */
        final /* synthetic */ String[][] f16215b;

        C3267a(String[][] strArr) {
            this.f16215b = strArr;
        }

        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            String unused =more_app.this.f16214s = this.f16215b[i][2];
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("http://play.google.com/store/apps/details?id=" +more_app.this.f16214s));
            intent.addFlags(1208483840);
            try {
                more_app.this.startActivity(intent);
            } catch (ActivityNotFoundException unused2) {
                more_app apps =more_app.this;
                apps.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=" +more_app.this.f16214s)));
            }
        }
    }

    public void mo13132n() {
       /* C1038e.C1039a aVar = new C1038e.C1039a();
        aVar.mo4868b("8FF6680EC9AC296C1D05ADB940206770");
        aVar.mo4868b("091A8598D12241AFE5D4C108AF61D612");
        aVar.mo4868b("CBF0C252EB6686BD1D591661866DF74D");
        ((AdView) findViewById(R.id.main_ad_view)).mo5021a(aVar.mo4867a());*/
    }

AlertDialog.Builder alertDialog;
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_more_app);
        alertDialog = new AlertDialog.Builder(more_app.this);
        mo13132n();
        setSupportActionBar((Toolbar) findViewById(R.id.home_toolbar));
        setTitle("More Apps");
       /* ListView listView = (ListView) findViewById(R.id.listview);
        String[][] strArr = {
                new String[]{"Check PF Balance & Bank Balance", "Check your EPF (Employees' Providend Fund) Balance and Bank Balance without Login or Internet", "com.mpawer.fin.pf", "Free"},
                new String[]{"Check Bank Balance (Lite)", "This app is a lite (less storage space) version and you can Check your Bank Balance without Login or Internet.", "com.mpawer.fin.bb", "Free"}, 
                new String[]{"Check PF Balance (Lite)", "This app is a lite (less storage space) version and you can Check your EPF Balance without Login or Internet.", "com.mpawer.fin.epf", "Free"}, 
                new String[]{"Exam Result", "Get all Indian Exam Results online Instantly.", "com.mpawer.tools.examresult", "Free"}, 
                new String[]{"Unit Converter", "Converts different units like area, length, speed etc. in to other units.", "com.ampower.areaconv", "Free"}, 
                new String[]{"Vahan", "Check registration details like owner name, vehicle type, RC/FC expiry, Finance, tax validity etc. of any vehicle.", "com.mpawer.tools.rto", "Free"}};
        listView.setAdapter(new C3347b(this, strArr, new int[]{R.drawable.ic_logo2, R.drawable.collapse, R.drawable.ic_logo2, R.drawable.ic_logo2, R.drawable.ic_logo2, R.drawable.ic_logo2}));
        listView.setOnItemClickListener(new C3267a(strArr));
    */}

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.start2, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        int itemId = menuItem.getItemId();
        if (itemId == R.id.action_disclaimer) {
            Disclaimer.mo13133o(this);
        }
  

        if (itemId == R.id.lik) {
            alertDialog.setTitle(R.string.ratings).setMessage(R.string.ratingmsg).setIcon(R
                    .drawable.ic_launcher_web).setPositiveButton("Proceed", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("market://details?id=");
                    stringBuilder.append(more_app.this.getApplicationContext().getPackageName());
                    Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(stringBuilder.toString()));

                    try {
                        more_app.this.startActivity(intent);
                    } catch (ActivityNotFoundException unused) {
                        more_app mainActivity = more_app.this;
                        StringBuilder stringBuilder2 = new StringBuilder();
                        stringBuilder2.append("http://play.google.com/store/apps/details?id=");
                        stringBuilder2.append(more_app.this.getApplicationContext().getPackageName());
                        mainActivity.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(stringBuilder2.toString())));
                    }
                }
            }).setNegativeButton("Later", null).show();
        }
        else if (itemId ==R.id.search){

            Intent mIntent = new Intent(this, Browser_Main.class);
            mIntent.putExtra("url","https://www.google.co.in/");
            startActivity(mIntent);
            return true;
        }      if (itemId ==R.id.sha){
            erahs();
        }
         if (itemId ==R.id.upd){
            alertDialog.setTitle(R.string.updatle).setMessage(R.string.updatemsg).setIcon(R
                    .drawable.ic_launcher_web).setPositiveButton("PROCEED", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("market://details?id=");
                    stringBuilder.append(more_app.this.getApplicationContext().getPackageName());
                    Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(stringBuilder.toString()));

                    try {
                        more_app.this.startActivity(intent);
                    } catch (ActivityNotFoundException unused) {
                        more_app mainActivity = more_app.this;
                        StringBuilder stringBuilder2 = new StringBuilder();
                        stringBuilder2.append("http://play.google.com/store/apps/details?id=");
                        stringBuilder2.append(more_app.this.getApplicationContext().getPackageName());
                        mainActivity.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(stringBuilder2.toString())));
                    }
                }
            }).setNegativeButton("Later", null).show();
        }
        return super.onOptionsItemSelected(menuItem);
    }

    public  void erahs(){
        alertDialog.setTitle("Share app with friends");
        alertDialog.setMessage(R.string.shmsg);
        alertDialog.setIcon(R.drawable.ic_launcher_web);

        alertDialog.setPositiveButton("proceed", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {

                Intent intent = new Intent();
                intent.setAction("android.intent.action.SEND");
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("http://play.google.com/store/apps/details?id=");
                stringBuilder.append(more_app.this.getApplicationContext().getPackageName());
                intent.putExtra("android.intent.extra.TEXT", stringBuilder.toString());
                intent.setType("text/plain");
                more_app.this.startActivity(Intent.createChooser
                        (intent, "Share using....."));
                dialog.cancel();

            }
        });
        alertDialog.setNegativeButton("Later", null);
        alertDialog.show();
    }
}
