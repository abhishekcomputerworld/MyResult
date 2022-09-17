package com.board.exams.myresult;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.board.exams.myresult.add.A;
import com.board.exams.myresult.browserr.Browser_Main;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Vieweb extends AppCompatActivity {
    AlertDialog.Builder alertDialog;
    FloatingActionButton fab,fabs;
    Toolbar toolbar;
    WebView webView;



    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activityviewweb);
         toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        alertDialog = new AlertDialog.Builder(Vieweb.this);
        fab = findViewById(R.id.fab);
        fabs = findViewById(R.id.fabs);
        webView =(WebView) findViewById(R.id.webview);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(fabs.getVisibility()==View.GONE){
                    Bitmap b = A.takescreenshotOfRootView(webView);
                    fabs.setImageBitmap(b);
                    fabs.show();
                    //  Toast.makeText(Start.this,"Scrren shot taken",Toast.LENGTH_SHORT).show();

                    if (isExternalStorageWritable()) {
                        storeScreenshot(b);
                    }
                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        public void run() {
                            fabs.hide();
                           // Toast.makeText(Vieweb.this, "Scrren shot save in"+getExternalFilesDir("My Result")+"and Library of app", Toast.LENGTH_LONG).show();

                        }
                    }, 600);
                }
            }
        });

       // webView.loadUrl("https://www.google.com/");
        progressDialog = new ProgressDialog(this);
        progressDialog.setProgressStyle(0);
        progressDialog.setMessage("Please wait...");
        progressDialog.setCancelable(false);
        progressDialog.setIndeterminate(false);
        progressDialog.show();
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            public void run() {
                onBackPressed();
                Toast.makeText(Vieweb.this,"Data will be Avilable Soon",Toast.LENGTH_SHORT).show();
                progressDialog.dismiss();


            }
        }, 4000);

    }
    public void storeScreenshot(Bitmap bitmap) {

        File file=getExternalFilesDir("My Result");
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("screenshot_");
        stringBuilder.append(System.currentTimeMillis());
        stringBuilder.append(".jpeg");
        File imageFile = new File(file, String.valueOf(stringBuilder));
        FileOutputStream out = null;

        try {
            out = new FileOutputStream(imageFile);
            // choose JPEG format
            bitmap.compress(Bitmap.CompressFormat.JPEG, 90, out);
            out.flush();

        } catch (FileNotFoundException e) {
            // manage exception ...
        } catch (IOException e) {
            // manage exception ...
        } finally {
            if (out != null) {
                try {
                    out.close(); }
                catch (Exception exc) {
                    Toast.makeText(Vieweb.this,"something went wrong ",Toast.LENGTH_SHORT).show();

                }
            }
        }
    }

    public boolean isExternalStorageWritable() {
        String state = Environment.getExternalStorageState();
        if (Environment.MEDIA_MOUNTED.equals(state)) {
            return true;
        }
        return false;
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
                stringBuilder.append(Vieweb.this.getApplicationContext().getPackageName());
                intent.putExtra("android.intent.extra.TEXT", stringBuilder.toString());
                intent.setType("text/plain");
                Vieweb.this.startActivity(Intent.createChooser
                        (intent, "Share using....."));
                dialog.cancel();

            }
        });
        alertDialog.setNegativeButton("Later", null);
        alertDialog.show();
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.start, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.lik) {
            alertDialog.setTitle(R.string.ratings).setMessage(R.string.ratingmsg).setIcon(R
                    .drawable.ic_launcher_web).setPositiveButton("Proceed", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("market://details?id=");
                    stringBuilder.append(Vieweb.this.getApplicationContext().getPackageName());
                    Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(stringBuilder.toString()));

                    try {
                        Vieweb.this.startActivity(intent);
                    } catch (ActivityNotFoundException unused) {
                        Vieweb mainActivity = Vieweb.this;
                        StringBuilder stringBuilder2 = new StringBuilder();
                        stringBuilder2.append("http://play.google.com/store/apps/details?id=");
                        stringBuilder2.append(Vieweb.this.getApplicationContext().getPackageName());
                        mainActivity.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(stringBuilder2.toString())));
                    }
                }
            }).setNegativeButton("Later", null).show();
        }
        else if (id ==R.id.search){

            Intent mIntent = new Intent(this, Browser_Main.class);
            mIntent.putExtra("url","https://www.google.co.in/");
            startActivity(mIntent);
            return true;
        }     else if (id ==R.id.ref){
            Intent intent = getIntent();
            finish();
            startActivity(intent);
            return true;
        }
        else if (id ==R.id.sha){
            erahs();
        }
        else if (id ==R.id.upd){
            alertDialog.setTitle(R.string.updatle).setMessage(R.string.updatemsg).setIcon(R
                    .drawable.ic_launcher_web).setPositiveButton("PROCEED", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("market://details?id=");
                    stringBuilder.append(Vieweb.this.getApplicationContext().getPackageName());
                    Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(stringBuilder.toString()));

                    try {
                        Vieweb.this.startActivity(intent);
                    } catch (ActivityNotFoundException unused) {
                        Vieweb mainActivity = Vieweb.this;
                        StringBuilder stringBuilder2 = new StringBuilder();
                        stringBuilder2.append("http://play.google.com/store/apps/details?id=");
                        stringBuilder2.append(Vieweb.this.getApplicationContext().getPackageName());
                        mainActivity.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(stringBuilder2.toString())));
                    }
                }
            }).setNegativeButton("Later", null).show();
        }
        else if (id ==R.id.scr){
            if(!item.isChecked()){
                item.setChecked(true);
                fab.show();
            }
            else {
                item.setChecked(false);
                fab.hide();
            }

        }
        else if (id ==R.id.action_disclaimer){
            Disclaimer.mo13133o(this);
            return true;
        }
        else if (id ==R.id.action_apps){
            Intent myIntent = new Intent(this,more_app.class);
            startActivity(myIntent);  return true;
        }
        else if (id ==R.id.pri){
            Intent mIntent = new Intent(this, Browser_Main.class);
            mIntent.putExtra("url","https://sites.google.com/view/androdeveloper/privacypolicy");
            startActivity(mIntent);   return true;
        }


        return super.onOptionsItemSelected(item);
    }
}
