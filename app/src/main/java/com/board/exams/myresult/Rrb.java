package com.board.exams.myresult;

import android.app.AlertDialog;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;


import com.board.exams.myresult.add.Interstitial;
import com.board.exams.myresult.browserr.Browser_Main;



public class Rrb extends AppCompatActivity {
    ListView listView;
    String [][]rrb;

    String [][]inst;
    String [][]scol;
    Adapters adapter;    AlertDialog.Builder alertDialog;


    String s;
    class Adapters extends ArrayAdapter<String> {

        Context context;
        String []ti;
        String []sti;
        String []st2;

        public Adapters(Context c, String []t1,String []t2,String []t3) {
            super(c, R.layout.sam1,R.id.title,t1);
            this.context=c;
            this.ti=t1;
            this.sti=t2;
            this.st2=t3;
        }

        class Myviewholder{
            TextView textView1;
            TextView textView2;

            public Myviewholder(View v) {
                textView1 = (TextView) v.findViewById(R.id.title);
                textView2 = (TextView) v.findViewById(R.id.subtitle);
            }




        }
        @Override
        public View getView(final int position, View convertView, ViewGroup parent) {
            Myviewholder myviewholder=null;
            if(convertView==null){ LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);          //  View rowView=inflater.inflate(R.layout.samp1, null);
                convertView=inflater.inflate(R.layout.sam1, parent, false);
                myviewholder=new Myviewholder(convertView);
                convertView.setTag(myviewholder);}
            else
                myviewholder=(Myviewholder) convertView.getTag();

            myviewholder.textView1.setText(ti[position]);
            myviewholder.textView2.setText(sti[position]);
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int a, long id) {
                    final int b=a;
                    {
                        Intent intent = new Intent(Rrb.this, Browser_Main.class);
                        intent.putExtra("url", st2[a]);
                        startActivity(intent);

                    }
                }
            });
            return convertView;
        }
    }
    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
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
                stringBuilder.append(Rrb.this.getApplicationContext().getPackageName());
                intent.putExtra("android.intent.extra.TEXT", stringBuilder.toString());
                intent.setType("text/plain");
                Rrb.this.startActivity(Intent.createChooser
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
        setContentView(R.layout.activity_rrb);
        new Interstitial().load(this);
        s=getIntent().getStringExtra("hed");



        alertDialog = new AlertDialog.Builder(Rrb.this);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
         setTitle(s);
        if (getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }
        listView=(ListView)findViewById(R.id.listview3);
        rrb = new String[3][];inst = new String[3][];scol = new String[3][];

        rrb[0]= new String[]{ "Ahmedabad",   "Ajmer", "Allahabad", "Bangalore", "Bhopal", "Bhubaneswar", "Bilaspur", "Chandigarh", "Chennai",
                "Gorakhpur", "Guwahati", "Jammu & Srinagar", "Kolkata", "Malda", "Mumbai", "Muzaffarpur", "Patna", "Ranchi", "Secunderabad", "Siliguri",
                "Thiruvananthapuram",  };
        rrb[1]= new String[]{"Railway Recruitment Board (RRB)", "Railway Recruitment Board (RRB)", "Railway Recruitment Board (RRB)",
                "Railway Recruitment Board (RRB)", "Railway Recruitment Board (RRB)", "Railway Recruitment Board (RRB)",
                "Railway Recruitment Board (RRB)", "Railway Recruitment Board (RRB)", "Railway Recruitment Board (RRB)", "Railway Recruitment Board (RRB)",
                "Railway Recruitment Board (RRB)", "Railway Recruitment Board (RRB)" , "Railway Recruitment Board (RRB)", "Railway Recruitment Board (RRB)",
                "Railway Recruitment Board (RRB)", "Railway Recruitment Board (RRB)", "Railway Recruitment Board (RRB)",
                "Railway Recruitment Board (RRB)", "Railway Recruitment Board (RRB)", "Railway Recruitment Board (RRB)", "Railway Recruitment Board (RRB)",
        };
        rrb[2]= new String[]{"http://www.rrbahmedabad.gov.in", "http://Www.Rrbajmer.Gov.In", "http://Www.Rrbald.Gov.In", "http://Www.Rrbbnc.Gov.In" ,
                "http://Www.Rrbbpl.Nic.In" , "http://Www.Rrbbbs.Gov.In", "http://Www.Rrbbilaspur.Gov.In", "http://Www.Rrbcdg.Gov.In",
                "http://Www.Rrbchennai.Gov.In" , "http://Www.Rrbgkp.Gov.In", "http://Www.Rrbguwahati.Gov.In" , "http://Www.Rrbjammu.Nic.In",
                "http://Www.Rrbkolkata.Gov.In"  , "http://Www.Rrbmalda.Gov.In", "http://Www.Rrbmumbai.Gov.In" , "http://Www.Rrbmuzaffarpur.Gov.In" ,
                "http://Www.Rrbpatna.Gov.In" , "http://Www.Rrbranchi.Gov.In", "http://Www.Rrbsecunderabad.Nic.In/", "http://Www.Rrbsiliguri.Org" ,
                "http://Www.Rrbthiruvananthapuram.Gov.In"  };

        inst[0]= new String[]{"AIBE","AIIMS", "BARC","BARC", "ICAI", "ICAI", "ICSI", "ICWAI", "IIFT", "Navodaya Vidyalaya Samiti",
                              "Navodaya Vidyalaya Samiti", "NIELIT", "NIFT", "NIOS", "NIOS D.El.Ed." };
        inst[1]= new String[]{"All India Bar Exam", "All India Institute of Medical Sciences, Raipur, Chhattisgarh.", "OCES DGFS Website",
                "OCES DGFS Results", "The Institute of Chartered Accountants of India Results", "Results NIC",
                "Institute of Company Secretaries of India (ICSI)", "The Institute of Cost Accountants of India", "Indian Institute of Foreign Trade",
                "Website", "Results and Announcements ", "The National Institute of Electronics and Information Technology", "National Institute of Fashion Technology (NIFT) ", "National Institute of Open Schooling",
                "National Institute of Open Schooling. D.El.Ed."        };
        inst[2]= new String[]{"http://allindiabarexamination.com/","http://www.aiimsraipur.edu.in/user/student-results.php", "http://www.barconlineexam.in/science/index.html#",
                              "https://www.i-register.co.in/BARCSCI18Live/frmresultlogin.aspx", "http://caresults.icai.org/icai_results/index.php", "https://icai.nic.in/caresult/",
                "http://www.icsi.edu/", "http://examicmai.in/Result-IF02011980/", "http://tedu.iift.ac.in/iift/view-all-updated.php", "https://navodaya.gov.in/nvs/en/Home1",
                "https://navodaya.gov.in/nvs/en/Admission-JNVST/Admission-Notifications/", "https://student.nielit.gov.in/", "https://nift.ac.in/",
                "https://nios.ac.in/examresult.aspx", "http://dled.nios.ac.in/"};

        scol[0]= new String[]{"Maharashtra Scholarship Exam"};
        scol[1]= new String[]{"Maharashtra 5th & 8th Class Scholarship Exam Result MSCE."};
        scol[2]= new String[]{"http://www.mscepune.in/"};

        if(s.equals("Institutes")){
         adapter=new Adapters(this,inst[0],inst[1],inst[2]);}
        if(s.equals("RRB")){
             adapter=new Adapters(this,rrb[0],rrb[1],rrb[2]);}
         if(s.equals("Scholarships")){
             adapter=new Adapters(this,scol[0],scol[1],scol[2]);}
        listView.setAdapter(adapter);

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
                    stringBuilder.append(Rrb.this.getApplicationContext().getPackageName());
                    Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(stringBuilder.toString()));

                    try {
                        Rrb.this.startActivity(intent);
                    } catch (ActivityNotFoundException unused) {
                        Rrb mainActivity = Rrb.this;
                        StringBuilder stringBuilder2 = new StringBuilder();
                        stringBuilder2.append("http://play.google.com/store/apps/details?id=");
                        stringBuilder2.append(Rrb.this.getApplicationContext().getPackageName());
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
        } else if (id ==R.id.ref){
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
                    stringBuilder.append(Rrb.this.getApplicationContext().getPackageName());
                    Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(stringBuilder.toString()));

                    try {
                        Rrb.this.startActivity(intent);
                    } catch (ActivityNotFoundException unused) {
                        Rrb mainActivity = Rrb.this;
                        StringBuilder stringBuilder2 = new StringBuilder();
                        stringBuilder2.append("http://play.google.com/store/apps/details?id=");
                        stringBuilder2.append(Rrb.this.getApplicationContext().getPackageName());
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



}
