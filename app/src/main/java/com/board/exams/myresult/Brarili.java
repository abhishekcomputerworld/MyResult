
package com.board.exams.myresult;

import android.app.AlertDialog;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.FileProvider;

import com.board.exams.myresult.add.Interstitial;
import com.board.exams.myresult.browserr.Browser_Main;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Brarili extends AppCompatActivity {
    ImageView imageView;
    GridView gridView;
    String []t;


    AlertDialog.Builder alertDialog;
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
                stringBuilder.append(Brarili.this.getApplicationContext().getPackageName());
                intent.putExtra("android.intent.extra.TEXT", stringBuilder.toString());
                intent.setType("text/plain");
                Brarili.this.startActivity(Intent.createChooser
                        (intent, "Share using....."));
                dialog.cancel();

            }
        });
        alertDialog.setNegativeButton("Later", null);
        alertDialog.show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_brarili);
        new Interstitial().load(this);
        alertDialog = new AlertDialog.Builder(Brarili.this);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setTitle("Library");

        if (getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }
        BottomNavigationView navbView = findViewById(R.id.navbview);
        navbView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        navbView.setSelectedItemId(R.id.library);
        gridView=(GridView)findViewById(R.id.grid);
       // Toast.makeText(Brarili.this,String.valueOf("bitmaps.size()")+"abhi22",Toast.LENGTH_SHORT).show();
        Adapters adapter=new Adapters(this);
        gridView.setAdapter(adapter);
        //     Toast.makeText(Brarili.this,String.valueOf("bitmaps.size()")+"abhi2",Toast.LENGTH_SHORT).show();
        // File file=getExternalFilesDir("My Result");
        // File directory = new File(String.valueOf(file)); //path is the string specifying your directory path.
        // File[] files = directory.listFiles();
        //opnscreeingallr(files[5].getName());
    }

    class Adapters extends BaseAdapter {
        ArrayList<Bitmap> bitmaps;
        Context context;
        File[] files;

        Adapters(Context c){
            this.context=c;

            bitmaps = new ArrayList<Bitmap>();
            File file= Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);

          //  File file=getExternalFilesDir("My Result");
            File directory = new File(String.valueOf(file));
            files = directory.listFiles();
           // Toast.makeText(Brarili.this,String.valueOf(files.length),Toast.LENGTH_SHORT).show();
            for (int i = 0; i < files.length; i++)
            {

                File imageFile = new File(file,files[i].getName());
                FileInputStream streamIn = null;
                try {
                    streamIn = new FileInputStream(imageFile);
                    Bitmap bitmap = BitmapFactory.decodeStream(streamIn); //This gets the image
                    bitmaps.add(bitmap)        ;
                } catch (FileNotFoundException e) {
                    Toast.makeText(Brarili.this,"take screen shot ",Toast.LENGTH_SHORT).show();

                    e.printStackTrace();

                }
                finally {
                    if (streamIn != null) {
                        try {
                            streamIn.close(); }
                        catch (Exception exc) {
                            Toast.makeText(Brarili.this,"something went wrong ",Toast.LENGTH_SHORT).show();

                        }
                    }
                }
            }
        }


        class Myviewholder{
            ImageView imageView;
            TextView textView2;

            public Myviewholder(View v) {
                imageView = (ImageView) v.findViewById(R.id.gimage);
                textView2 = (TextView) v.findViewById(R.id.gtext);
            }




        }

        @Override
        public int getCount() {
            return bitmaps.size();
        }

        @Override
        public Object getItem(int position) {
            return bitmaps.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            Myviewholder myviewholder=null;
         //   Toast.makeText(Brarili.this,String.valueOf(bitmaps.size())+"abhi",Toast.LENGTH_SHORT).show();
            //    Singalarry temp=list.get(position);
            if(convertView==null){ LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);          //  View rowView=inflater.inflate(R.layout.samp1, null);
                convertView=inflater.inflate(R.layout.grid, parent, false);
                myviewholder=new Myviewholder(convertView);
                convertView.setTag(myviewholder);}
            else
                myviewholder=(Myviewholder) convertView.getTag();

            myviewholder.imageView.setImageBitmap(bitmaps.get(position));
            myviewholder.textView2.setText(files[position].getName());
            gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int a, long id) {
                    opnscreeingall(files[a].getName());
                }
            });
            return convertView;
        }
    }
    public void opnscreeingall( String a){
       // File file=getExternalFilesDir("My Result");
        File file= Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);
        File imageFile = new File(file, a);




        Intent install = new Intent(Intent.ACTION_VIEW);
        install.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
        Uri apkURI = FileProvider.getUriForFile(this, this.getApplicationContext().getPackageName() + ".provider", imageFile);
        install.setDataAndType(apkURI, "image/*");
        install.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
        startActivity(install);

        //Toast.makeText(Brarili.this," again"+a,Toast.LENGTH_LONG).show();

    }
    public void storeScreenshot() {
        File file=getExternalFilesDir("My Result");
        File imageFile = new File(file, "aaa");
        FileInputStream streamIn = null;
        try {
            streamIn = new FileInputStream(imageFile);
            Bitmap bitmap = BitmapFactory.decodeStream(streamIn); //This gets the image
            imageView.setImageBitmap(bitmap );
        } catch (FileNotFoundException e) {
            Toast.makeText(Brarili.this,"take screen shot ",Toast.LENGTH_SHORT).show();

            e.printStackTrace();

        }
        finally {
            if (streamIn != null) {
                try {
                    streamIn.close(); }
                catch (Exception exc) {
                    Toast.makeText(Brarili.this,"something went wrong ",Toast.LENGTH_SHORT).show();

                }
            }
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.start2, menu);
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
                    stringBuilder.append(Brarili.this.getApplicationContext().getPackageName());
                    Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(stringBuilder.toString()));

                    try {
                        Brarili.this.startActivity(intent);
                    } catch (ActivityNotFoundException unused) {
                        Brarili mainActivity = Brarili.this;
                        StringBuilder stringBuilder2 = new StringBuilder();
                        stringBuilder2.append("http://play.google.com/store/apps/details?id=");
                        stringBuilder2.append(Brarili.this.getApplicationContext().getPackageName());
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
        }    else if (id ==R.id.ref){
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
                    stringBuilder.append(Brarili.this.getApplicationContext().getPackageName());
                    Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(stringBuilder.toString()));

                    try {
                        Brarili.this.startActivity(intent);
                    } catch (ActivityNotFoundException unused) {
                        Brarili mainActivity = Brarili.this;
                        StringBuilder stringBuilder2 = new StringBuilder();
                        stringBuilder2.append("http://play.google.com/store/apps/details?id=");
                        stringBuilder2.append(Brarili.this.getApplicationContext().getPackageName());
                        mainActivity.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(stringBuilder2.toString())));
                    }
                }
            }).setNegativeButton("Later", null).show();
        }

        else if (id ==R.id.pri){
            Intent mIntent = new Intent(this, Browser_Main.class);
            mIntent.putExtra("url","https://sites.google.com/view/androdeveloper/privacypolicy");
            startActivity(mIntent);
            return true;
        }

        else if (id ==R.id.action_disclaimer){
            Disclaimer.mo13133o(this);
            return true;
        }
        else if (id ==R.id.action_apps){
            Intent myIntent = new Intent(this,more_app.class);
            startActivity(myIntent);  return true;
        }
        return super.onOptionsItemSelected(item);
    }


    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener = new
            BottomNavigationView.OnNavigationItemSelectedListener() {

                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    switch (item.getItemId()) {
                        case R.id.homes:
                            startActivity( new Intent(Brarili.this, Start.class));

                            return true;
                        case R.id.locker:
                            Intent mIntent = new Intent(Brarili.this, Browser_Main.class);
                            mIntent.putExtra("url","https://digilocker.gov.in/index.php#no-back");
                            startActivity(mIntent);
                            return true;

                        case R.id.noti:
                            startActivity( new Intent(Brarili.this, ficationoti.class));
                            return true;

                        case R.id.library:

                            return true;
                    }
                    return false;
                }
            };

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
