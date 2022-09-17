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
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.board.exams.myresult.add.Interstitial;
import com.board.exams.myresult.browserr.Browser_Main;





public class Polytectic extends AppCompatActivity {
    ListView listView;
    String[][] uni1,uni2,uni3,uni4,uni5,uni6,uni7,uni8,uni9,uni10,uni11,uni12,uni13,uni14,
            uni15,uni16,uni17,uni18,uni19,uni20,uni21,uni22,uni23,uni24,uni25,uni26,uni27,uni28,uni29,uni30,uni31,uni32;
    Adapters adapter;
    String t;
    String []al;
    AlertDialog.Builder alertDialog;

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


                            Intent intent = new Intent(Polytectic.this, Browser_Main.class);
                            intent.putExtra("url", Uri.parse(st2[a]));
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
    }    public  void erahs(){
        alertDialog.setTitle("Share app with friends");
        alertDialog.setMessage(R.string.shmsg);
        alertDialog.setIcon(R.drawable.ic_launcher_web);

        alertDialog.setPositiveButton("proceed", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {

                Intent intent = new Intent();
                intent.setAction("android.intent.action.SEND");
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("http://play.google.com/store/apps/details?id=");
                stringBuilder.append(Polytectic.this.getApplicationContext().getPackageName());
                intent.putExtra("android.intent.extra.TEXT", stringBuilder.toString());
                intent.setType("text/plain");
                Polytectic.this.startActivity(Intent.createChooser
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
        setContentView(R.layout.acti_polytec);
        t= getIntent().getStringExtra("title");

        new Interstitial().load(this);

        alertDialog = new AlertDialog.Builder(Polytectic.this);


        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setTitle(t+" Polytechnic");

        if (getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }
        listView=(ListView)findViewById(R.id.listview3);
        al=new String[]{"All India","Andhra Pradesh", "Arunachal Pradesh", "Assam", "Bihar", "Chhattisgarh", "Delhi", "Goa",
                "Gujarat", "Haryana", "Himachal Pradesh", "Jammu & Kashmir", "Jharkhand", "Karnataka", "Kerala", "Madhya Pradesh", "Maharashtra", "Manipur",
                "Meghalaya", "Mizoram", "Nagaland", "Odisha", "Pondicherry", "Punjab", "Rajasthan", "Tamil Nadu", "Telangana", "Tripura", "Uttarakhand", "Uttaranchal",
                "Uttar Pradesh", "West Bengal" };
        uni1 = new String[3][];
        uni1[0] = new String[]{ "No data at present"   };
        uni1[1] = new String[]{  " comming soon...."  };
        uni1[2] = new String[]{   ""  };
        uni2 = new String[3][];
        uni2[0] = new String[]{"AP POLYCET", "AP Diploma"};
        uni2[1] = new String[]{"Polytechnic Common Entrance Test","STATE BOARD OF TECHNICAL EDUCATION AND TRAINING, Andhra Pradesh."};
        uni2[2] = new String[]{"https://polycetap.nic.in/Default.aspx","http://ousbtet.net/dipresults/"};
        uni3 = new String[3][];
        uni3[0] = new String[]{ "No data at present"   };
        uni3[1] = new String[]{  " comming soon...."  };
        uni3[2] = new String[]{   ""  };
        uni4 = new String[3][];
        uni4[0] = new String[]{ "No data at present"   };
        uni4[1] = new String[]{  " comming soon...."  };
        uni4[2] = new String[]{   ""  };
        uni5 = new String[3][];
        uni5[0] = new String[]{"Bihar ITICAT"};
        uni5[1] = new String[]{ "BCECEB Industrial Training Institute Competitive Admission Test (ITICAT) "};
        uni5[2] = new String[]{"http://bceceboard.bihar.gov.in/pdf_Adv/ADV_ITIC18_06.pdf"};
        uni6 = new String[3][];
        uni6[0] = new String[]{ "No data at present"   };
        uni6[1] = new String[]{  " comming soon...."  };
        uni6[2] = new String[]{   ""  };
        uni7 = new String[3][];
        uni7[0] = new String[]{"Delhi DTTE"};
        uni7[1] = new String[]{"CET 2017 entrance exam"};
        uni7[2] = new String[]{"https://cetdelhi.nic.in/Candidate/ResultCET.aspx"};
        uni8 = new String[3][];
        uni8[0] = new String[]{ "No data at present"   };
        uni8[1] = new String[]{  " comming soon...."  };
        uni8[2] = new String[]{   ""  };
        uni9 = new String[3][];
        uni9[0] = new String[]{"GTU"};
        uni9[1] = new String[]{"Gujarat Technological University Ahmedabad."};
        uni9[2] = new String[]{ "http://www.gtu.ac.in/result.aspx"};
        uni10 = new String[3][];
        uni10[0] = new String[]{"HSBTE","HSBTE"};
        uni10[1] = new String[]{"Haryana State Board of Technical Education. All Results.", "Haryana State Board of Technical Education. Dec 2017 Exams."};
        uni10[2] = new String[]{"http://hsbte.org.in/students-results","http://result.hsbte.com/"          };
        uni11 = new String[3][];
        uni11[0] = new String[]{"MPPEB"};
        uni11[1] = new String[]{"Madhya Pradesh Professional Examination Board, Chinar Park (East), Bhopal."};
        uni11[2] = new String[]{"http://vyapam.nic.in/e_default.html"};
        uni12 = new String[3][];
        uni12[0] = new String[]{"DTE Maharashtra", "MSBTE"};
        uni12[1] = new String[]{ "Directorate of Technical Education, Maharashtra State.", "Maharashtra State Board of Technical Education"};
        uni12[2] = new String[]{"http://www.dtemaharashtra.gov.in/","http://msbte.org.in/"                };
        uni13 = new String[3][];
        uni13[0] = new String[]{ "No data at present"   };
        uni13[1] = new String[]{  " comming soon...."  };
        uni13[2] = new String[]{   ""  };
        uni14 = new String[3][];
        uni14[0] = new String[]{"DTE Karnataka","BTE Karnataka", "BTE Karnataka"};
        uni14[1] = new String[]{ "Directorate of Technical Education", "Board of Technical Examinations ",
                "Results"};
        uni14[2] = new String[]{"http://www.dte.kar.nic.in/index.shtml","http://www.btenet.in/","http://www.bteresults.net/Home.aspx"};
        uni15= new String[3][];
        uni15[0] = new String[]{"DTE Kerala"};
        uni15[1] = new String[]{"Directorate of Technical Education"};
        uni15[2] = new String[]{"http://polyadmission.org/index.php?r=site%2Fhome"};
        uni16 = new String[3][];
        uni16[0] = new String[]{ "No data at present"   };
        uni16[1] = new String[]{  " comming soon...."  };
        uni16[2] = new String[]{   ""  };
        uni17 = new String[3][];
        uni17[0] = new String[]{ "No data at present"   };
        uni17[1] = new String[]{  " comming soon...."  };
        uni17[2] = new String[]{   ""  };
        uni18 = new String[3][];
        uni18[0] = new String[]{ "No data at present"   };
        uni18[1] = new String[]{  " comming soon...."  };
        uni18[2] = new String[]{   ""  };
        uni19= new String[3][];
        uni19[0] = new String[]{ "No data at present"   };
        uni19[1] = new String[]{  " comming soon...."  };
        uni19[2] = new String[]{   ""  };
        uni20 = new String[3][];
        uni20[0] = new String[]{ "No data at present"   };
        uni20[1] = new String[]{  " comming soon...."  };
        uni20[2] = new String[]{   ""  };
        uni21 = new String[3][];
        uni21[0] = new String[]{ "No data at present"   };
        uni21[1] = new String[]{  " comming soon...."  };
        uni21[2] = new String[]{   ""  };
        uni22 = new String[3][];
        uni22[0] = new String[]{"SCTEVT Odisha"};
        uni22[1] = new String[]{ "State Council for Technical Education & Vocational Training Bhubaneswar, Orissa."};
        uni22[2] = new String[]{"http://sctevtodisha.nic.in/website/DioplomaResultsStudent.aspx"};
        uni23 = new String[3][];
        uni23[0] = new String[]{ "No data at present"   };
        uni23[1] = new String[]{  " comming soon...."  };
        uni23[2] = new String[]{   ""  };
        uni24 = new String[3][];
        uni24[0] = new String[]{"Punjab"};
        uni24[1] = new String[]{"The Punjab State Board of Technical Education and Industrial Training (punjabteched)"};
        uni24[2] = new String[]{"http://www.punjabteched.com/"};
        uni25 = new String[3][];
        uni25[0] = new String[]{"DTE Rajasthan"};
        uni25[1] = new String[]{"Directorate of Technical Education"};
        uni25[2] = new String[]{"http://www.dte.rajasthan.gov.in/Polytechnics/Admissions/Admissions.html"};
        uni26 = new String[3][];
        uni26[0] = new String[]{"TNDTE"};
        uni26[1] = new String[]{"Tamil Nadu Directorate of Technical Education"};
        uni26[2] = new String[]{"http://intradote.tn.nic.in/"};
        uni27 = new String[3][];
        uni27[0] = new String[]{"TSDEECET", "TS POLYCET"};
        uni27[1] = new String[]{ "Telangana State Diploma in Elementary Education Common entrance Test 2017","Telangana Polytechnic Common Entrance Test"};
        uni27[2] = new String[]{"http://tsdeecet.cgg.gov.in/", "https://polycetts.nic.in/Default.aspx"     };
        uni28 = new String[3][];
        uni28[0] = new String[]{ "No data at present"   };
        uni28[1] = new String[]{  " comming soon...."  };
        uni28[2] = new String[]{   ""  };
        uni29 = new String[3][];
        uni29[0] = new String[]{"UBTER"};
        uni29[1] = new String[]{"Uttarakhand Board of Technical Education"};
        uni29[2] = new String[]{"http://www.ubter.in/"};
        uni30 = new String[3][];
        uni30[0] = new String[]{ "No data at present"   };
        uni30[1] = new String[]{  " comming soon...."  };
        uni30[2] = new String[]{   ""  };
        uni31 = new String[3][];
        uni31[0] = new String[]{"UP BTE Polytecnic","UP BTE Polytecnic","UP JEE Polytechnic"};
        uni31[1] = new String[]{"Board of Technical Education, Uttar Pradesh.", "Results",
                                  "JEE Polytechnic, Uttar Pradesh.", };
        uni31[2] = new String[]{ "http://bteup.ac.in/webapp/default.aspx", "http://result.bteupexam.in/year/rollno.aspx#", "http://www.jeecup.org/"              };
        uni32 = new String[3][];
        uni32[0] = new String[]{"WBSCTE"};
        uni32[1] = new String[]{"West Bengal State Council of Technical Education"};
        uni32[2] = new String[]{"https://webscte.co.in/"};

        if(t.equals(al[0])){
            adapter=new Adapters(this,uni1[0],uni1[1],uni1[2]);}
        if(t.equals(al[1])){
            adapter=new Adapters(this,uni2[0],uni2[1],uni2[2]);}
        if(t.equals(al[2])){
            adapter=new Adapters(this,uni3[0],uni3[1],uni3[2]);}
        if(t.equals(al[3])){
            adapter=new Adapters(this,uni4[0],uni4[1],uni4[2]);}
        if(t.equals(al[4])){
            adapter=new Adapters(this,uni5[0],uni5[1],uni5[2]);}
        if(t.equals(al[5])){
            adapter=new Adapters(this,uni6[0],uni6[1],uni6[2]);}
        if(t.equals(al[6])){
            adapter=new Adapters(this,uni7[0],uni7[1],uni7[2]);}
        if(t.equals(al[7])){
            adapter=new Adapters(this,uni8[0],uni8[1],uni8[2]);}
        if(t.equals(al[8])){
            adapter=new Adapters(this,uni9[0],uni9[1],uni9[2]);}
        if(t.equals(al[9])){
            adapter=new Adapters(this,uni10[0],uni10[1],uni10[2]);}
        if(t.equals(al[10])){
            adapter=new Adapters(this,uni11[0],uni11[1],uni11[2]);}
        if(t.equals(al[11])){
            adapter=new Adapters(this,uni12[0],uni12[1],uni12[2]);}
        if(t.equals(al[12])){
            adapter=new Adapters(this,uni13[0],uni13[1],uni13[2]);}
        if(t.equals(al[13])){
            adapter=new Adapters(this,uni14[0],uni14[1],uni14[2]);}
        if(t.equals(al[14])){
            adapter=new Adapters(this,uni15[0],uni15[1],uni15[2]);}
        if(t.equals(al[15])){
            adapter=new Adapters(this,uni16[0],uni16[1],uni16[2]);}
        if(t.equals(al[16])){
            adapter=new Adapters(this,uni17[0],uni17[1],uni17[2]);}
        if(t.equals(al[17])){
            adapter=new Adapters(this,uni18[0],uni18[1],uni18[2]);}
        if(t.equals(al[18])){
            adapter=new Adapters(this,uni19[0],uni19[1],uni19[2]);}
        if(t.equals(al[19])){
            adapter=new Adapters(this,uni20[0],uni20[1],uni20[2]);}
        if(t.equals(al[20])){
            adapter=new Adapters(this,uni21[0],uni21[1],uni21[2]);}
        if(t.equals(al[21])){
            adapter=new Adapters(this,uni22[0],uni22[1],uni22[2]);}
        if(t.equals(al[22])){
            adapter=new Adapters(this,uni23[0],uni23[1],uni23[2]);}
        if(t.equals(al[23])){
            adapter=new Adapters(this,uni24[0],uni24[1],uni24[2]);}
        if(t.equals(al[24])){
            adapter=new Adapters(this,uni25[0],uni25[1],uni25[2]);}
        if(t.equals(al[25])){
            adapter=new Adapters(this,uni26[0],uni26[1],uni26[2]);}
        if(t.equals(al[26])){
            adapter=new Adapters(this,uni27[0],uni27[1],uni27[2]);}
        if(t.equals(al[27])){
            adapter=new Adapters(this,uni28[0],uni28[1],uni28[2]);}
        if(t.equals(al[28])){
            adapter=new Adapters(this,uni29[0],uni29[1],uni29[2]);}
        if(t.equals(al[29])){
            adapter=new Adapters(this,uni30[0],uni30[1],uni30[2]);}
        if(t.equals(al[30])){
            adapter=new Adapters(this,uni31[0],uni31[1],uni31[2]);}
        if(t.equals(al[31])){
            adapter=new Adapters(this,uni32[0],uni32[1],uni32[2]);}







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
                    stringBuilder.append(Polytectic.this.getApplicationContext().getPackageName());
                    Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(stringBuilder.toString()));

                    try {
                        Polytectic.this.startActivity(intent);
                    } catch (ActivityNotFoundException unused) {
                        Polytectic mainActivity = Polytectic.this;
                        StringBuilder stringBuilder2 = new StringBuilder();
                        stringBuilder2.append("http://play.google.com/store/apps/details?id=");
                        stringBuilder2.append(Polytectic.this.getApplicationContext().getPackageName());
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
        }  else if (id ==R.id.ref){
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
                    stringBuilder.append(Polytectic.this.getApplicationContext().getPackageName());
                    Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(stringBuilder.toString()));

                    try {
                        Polytectic.this.startActivity(intent);
                    } catch (ActivityNotFoundException unused) {
                        Polytectic mainActivity = Polytectic.this;
                        StringBuilder stringBuilder2 = new StringBuilder();
                        stringBuilder2.append("http://play.google.com/store/apps/details?id=");
                        stringBuilder2.append(Polytectic.this.getApplicationContext().getPackageName());
                        mainActivity.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(stringBuilder2.toString())));
                    }
                }
            }).setNegativeButton("Later", null).show();
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
            startActivity(mIntent);
            return true;
        }


        return super.onOptionsItemSelected(item);
    }



}
