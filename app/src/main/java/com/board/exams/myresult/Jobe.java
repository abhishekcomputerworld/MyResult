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

public class Jobe extends AppCompatActivity {
    ListView listView;
    String[][] uni1,uni2,uni3,uni4,uni5,uni6,uni7,uni8,uni9,uni10,uni11,uni12,uni13,uni14,
            uni15,uni16,uni17,uni18,uni19,uni20,uni21,uni22,uni23,uni24,uni25,uni26,uni27,uni28,uni29,uni30,uni31,uni32;
    Adapters adapter;
    String t;
    String []al;    AlertDialog.Builder alertDialog;

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
                            Intent intent = new Intent(Jobe.this, Browser_Main.class);
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
                stringBuilder.append(Jobe.this.getApplicationContext().getPackageName());
                intent.putExtra("android.intent.extra.TEXT", stringBuilder.toString());
                intent.setType("text/plain");
                Jobe.this.startActivity(Intent.createChooser
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
        setContentView(R.layout.activity_jobe);
        new Interstitial().load(this);

        t= getIntent().getStringExtra("title");





        alertDialog = new AlertDialog.Builder(Jobe.this);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setTitle(t+" Jobs");
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
        uni1[0] = new String[]{   "AIBE", "BARC", "BARC", "BSNL Internal Exam", "BSNL External Exam", "CIL MT 2017",
                "CSIR", "CTET", "ESIC", "IBPS", "KVS", "Navodaya Vidyalaya Samiti", "Navodaya Vidyalaya Samiti", "NIACL",
                "RBI", "RPF", "RPF", "SBI (State Bank of India)", "SSC", "SSC", "SSC", "SSC", "SSC", "UGC NEET",
                "UIIC", "UPSC", "UPSC", "UPSC", "UPSC", "UPSC",
                "UPSC"};
        uni1[1] = new String[]{  "All India Bar Exam", "OCES DGFS Website", "OCES DGFS Results", "Bharat Sanchar Nigam Limited",
         "Bharat Sanchar Nigam Limited", "Coal India management trainees exam", "Council of Scientific & Industrial Research (CSIR), India.", "Central Teacher Eligibility Test (CTET) by CBSE",
         "Employees’ State Insurance Corporation of India", "The Institute of Banking Personnel Selection", "Kendriya Vidyalaya Sangathan (KVS) PGT, TGT & PRT.",
         "Website", "Results and Announcements ", "The New India Assurance Company LTD", "The Reserve Bank of India.", "Railway Police Force Constable.", "Railway Police Force",
         "The State Bank of India exams.", "Staff Selection Commission",
         "JUNIOR ENGINEERS (CIVIL, MECHANICAL, ELECTRICAL, QUANTITY SURVEYING AND CONTRACT) EXAMINATION, 2017 - LIST OF CANDIDATES (CIVIL) QUALIFIED FOR DOCUMENT VERIFICATION",
         "JUNIOR ENGINEERS (CIVIL, MECHANICAL, ELECTRICAL, QUANTITY SURVEYING AND CONTRACT) EXAMINATION, 2017 - LIST OF CANDIDATES (MECHANICAL, ELECTRICAL) QUALIFIED FOR DOCUMENT VERIFICATION",
         "CHSL Tier-1", "COMBINED RECRUITMENT OF JUNIOR HINDI TRANSLATOR, JUNIOR TRANSLATOR, SENIOR HINDI TRANSLATOR AND HINDI PRADHYAPAK EXAMINATION, 2017 - DECLARATION OF FINAL RESULT",
         "Examination by NTA", "United India Insurance Company Ltd.", "Union Public Service Commission. Civil, Army and other government services exam.",
         "What’s New", "Admit Cards", "Written Exam Results",
         "Interviews", "Final Results"
         };
        uni1[2] = new String[]{
                "http://allindiabarexamination.com/",
        "http://www.barconlineexam.in/science/index.html#" ,
  "https://www.i-register.co.in/BARCSCI18Live/frmresultlogin.aspx"  ,
   "http://www.internalexam.bsnl.co.in/",
           "http://www.externalexam.bsnl.co.in/",
           "https://www.coalindia.in/career/en-us/mt2017exam.aspx",
           "http://csirhrdg.res.in/results.htm",
           "http://cbseresults.nic.in",
           "https://www.esic.nic.in/recruitments",
           "http://www.ibps.in/",
           "https://kvsangathan.nic.in/announcement",
           "http://www.nvshq.org/",
           "http://www.nvshq.org/archive.php",
           "https://www.newindia.co.in/portal/viewAll",
           "https://opportunities.rbi.org.in/Scripts/resultsnew.aspx",
           "https://constable.rpfonlinereg.org/home.html",
           "https://si1.rpfonlinereg.org/home.html",
           "https://www.sbi.co.in/careers/ongoing-recruitment.html",
           "http://ssc.nic.in/",
           "http://ssc.nic.in/SSC_WEBSITE_LATEST/results/results_pdf/je17_result_civil_22062018.pdf",
        "http://ssc.nic.in/SSC_WEBSITE_LATEST/results/results_pdf/je17_result_em_22062018.pdf",
           "http://ssc.nic.in/SSC_WEBSITE_LATEST/results/results_pdf/result_chsl17_t1_15062018.pdf",
          "http://ssc.nic.in/SSC_WEBSITE_LATEST/results/results_pdf/JHT17SL_result_14062018.pdf" ,
           "https://www.nta.ac.in/",
    "https://uiic.co.in/careers/recruitment"    ,
   "http://www.upsc.gov.in/",
           "http://www.upsc.gov.in/whats-new",
           "http://www.upsc.gov.in/e-admit-cards",
 "http://www.upsc.gov.in/exams-related-info/written-result" ,
           "http://www.upsc.gov.in/interview-schedule-and-esummon-letters",
            "http://www.upsc.gov.in/exams-related-info/final-result"                   };
        uni2 = new String[3][];
        uni2[0] = new String[]{"APPRB", "APPSC", "APSLPRB", "APSLPRB", "APTET", "APTET"};
        uni2[1] = new String[]{"The Andhra Pradesh police recruitment board",
                "Andhra Pradesh Public Service Commission",
                "The Andhra Pradesh State Level Police Recruitment Board(APSLPRB) Website.",
                "Result",
        "Andhra Pradesh Teacher Eligibility Test",
        "The Commissioner of School Education, Government of Andhra Pradesh (CSE AP) "};
        uni2[2] = new String[]{ "http://recruitment.appolice.gov.in/",
        "https://www.psc.ap.gov.in/Default.aspx", "http://slprb.ap.gov.in/"      , "http://result.apprb.in:8082/",
         "https://aptet182389results.apcfss.in/resultsaptet187485963256.aptet", "https://aptet.apcfss.in/"                                                                };
        uni3 = new String[3][];
        uni3[0] = new String[]{ "No data at present"   };
        uni3[1] = new String[]{  " comming soon...."  };
        uni3[2] = new String[]{   ""  };
        uni4 = new String[3][];
        uni4[0] = new String[]{"Assam Police"};
        uni4[1] = new String[]{"Assam Police"};
        uni4[2] = new String[]{"http://assampolice.gov.in/contact.php"};
        uni5 = new String[3][];
        uni5[0] = new String[]{"BPSC", "BPSSC", "Bihar CSBC", "BTET"     };
        uni5[1] = new String[]{ "Bihar Public Service Commission", "The Bihar Police Sub-ordinate Services Commission",
                "Central Selection Board Of Constable", "The Bihar Teacher Eligibility Test"};
        uni5[2] = new String[]{  "http://bpsc.bih.nic.in/", "http://bpssc.bih.nic.in/" , "http://csbc.bih.nic.in/" , "https://www.bsebonline.net/"    };
        uni6 = new String[3][];
        uni6[0] = new String[]{"AIIMS"};
        uni6[1] = new String[]{"All India Institute of Medical Sciences, Raipur, Chhattisgarh."};
        uni6[2] = new String[]{"http://www.aiimsraipur.edu.in/user/vacancies-result.php"};
        uni7 = new String[3][];
        uni7[0] = new String[]{"Delhi HC", "Delhi Police", "Delhi Police"};
        uni7[1] = new String[]{  "Delhi Judicial Services, Delhi High Court.", "Staff Selection Commission(SSC) Delhi Police Exams.", "Direct Recruitment"};
        uni7[2] = new String[]{ "http://delhihighcourt.nic.in/generalnotices.asp", "https://ssc.nic.in/Portal/Results", "http://delhipolice.nic.in/recruitment.html"};
        uni8 = new String[3][];
        uni8[0] = new String[]{ "No data at present"   };
        uni8[1] = new String[]{  " comming soon...."  };
        uni8[2] = new String[]{   ""  };
        uni9 = new String[3][];
        uni9[0] = new String[]{"GPSC"};
        uni9[1] = new String[]{"The Gujarat Public Service Commission"};
        uni9[2] = new String[]{"https://gpsc.gujarat.gov.in/dashboard?stage=Result"};
        uni10 = new String[3][];
        uni10[0] = new String[]{"HSSC", "HTET"};
        uni10[1] = new String[]{"The Haryana Staff Selection Commission.", "Haryana Teacher Eligibility Test  Result"};
        uni10[2] = new String[]{ "http://www.hssc.gov.in/result.htm" ,"http://results.indiaresults.com/hr/hbse/htet-exam-result-2018/query.htm"};
        uni11 = new String[3][];
        uni11[0] = new String[]{"HPSSB", "HPSSB"};
        uni11[1] = new String[]{ "Himachal Pradesh Staff Selection Commission", "Notifications"};
        uni11[2] = new String[]{ "https://hpsssb.hp.gov.in/", "https://hpsssb.hp.gov.in/AllNotifications.aspx?id=8"};
        uni12 = new String[3][];
        uni12[0] = new String[]{"JKPSC"};
        uni12[1] = new String[]{"Jammu and Kashmir Public Service Commission."};
        uni12[2] = new String[]{"http://jkpsc.nic.in/"};
        uni13 = new String[3][];
        uni13[0] = new String[]{ "No data at present"   };
        uni13[1] = new String[]{  " comming soon...."  };
        uni13[2] = new String[]{   ""  };
        uni14 = new String[3][];
        uni14[0] = new String[]{ "No data at present"   };
        uni14[1] = new String[]{  " comming soon...."  };
        uni14[2] = new String[]{   ""  };
        uni15= new String[3][];
        uni15[0] = new String[]{"KPSC", "KTET"};
        uni15[1] = new String[]{"Kerala Public Service Commission", "Kerala Teachers Eligibility Test "};
        uni15[2] = new String[]{ "https://www.keralapsc.gov.in/index.php?option=com_docman&Itemid=92", "https://ktet.kerala.gov.in/"                                     };
        uni16 = new String[3][];
        uni16[0] = new String[]{"MPPSC","MP Patwari Exam"};
        uni16[1] = new String[]{"Madhya Pradesh Public Service Commission ","Madhya Pradesh Professional Examination Board Patwari Exam Result."};
        uni16[2] = new String[]{"http://www.mppsc.nic.in/newresults.html","http://peb.mp.gov.in/results/RESULT_17/PATWARI_RES17/default_results.htm"};
        uni17 = new String[3][];
        uni17[0] = new String[]{"MAHATET", "MPSC"};
        uni17[1] = new String[]{ "Maharashtra Teacher Eligibility Test", "Maharashtra Public Service Commission"};
        uni17[2] = new String[]{ "https://mahatet.in//", "https://www.mpsc.gov.in/Site/Home/Index.aspx"             };
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
        uni22[0] = new String[]{"OPSC"};
        uni22[1] = new String[]{"Odisha Public Service Commission"};
        uni22[2] = new String[]{"http://www.opsc.gov.in/result.php"};
        uni23 = new String[3][];
        uni23[0] = new String[]{ "No data at present"   };
        uni23[1] = new String[]{  " comming soon...."  };
        uni23[2] = new String[]{   ""  };
        uni24 = new String[3][];
        uni24[0] = new String[]{ "No data at present"   };
        uni24[1] = new String[]{  " comming soon...."  };
        uni24[2] = new String[]{   ""  };
        uni25 = new String[3][];
        uni25[0] = new String[]{"Rajasthan REET", "RPSC", "RPSC", "RSMSSB", "RSMSSB"};
        uni25[1] = new String[]{"Rajasthan Eligibility Examination for Teachers", "Rajasthan Public Service Commission.", "Results",
                "The Rajasthan Subordinate and Ministerial Services Selection Board", "Results & News"};
        uni25[2] = new String[]{"http://rajeduboard.rajasthan.gov.in/", "https://rpsc.rajasthan.gov.in"           , "https://rpsc.rajasthan.gov.in/results"                    , "http://rsmssb.rajasthan.gov.in/page?menuName=Home", "http://rsmssb.rajasthan.gov.in/page?menuName=vjb1SGmySPW2SnQ8Ife8KA=="                   };
        uni26 = new String[3][];
        uni26[0] = new String[]{"TNPSC", "TNPSC", "TN TRB TET", "TN TRB", "TNUSRB Results" };
        uni26[1] = new String[]{  "Tamil Nadu Public Service Commission", "Results", "Tamil Nadu Teachers Recruitment Board",
 "Direct Recruitment of Special Teachers 2012-2016", "Tamil Nadu Uniformed Services Recruitment Board Police Constables, Jail Warders, Firemen Exam " };
        uni26[2] = new String[]{"http://www.tnpsc.gov.in/", "http://www.tnpsc.gov.in/results.html", "http://trb.tn.nic.in/", "http://trb.tn.nic.in/srt2018/Msg3.htm", "http://tnusrbonline.org/" };
        uni27 = new String[3][];
        uni27[0] = new String[]{"TSLPRB", "TSPSC", "TSPSC", "TSTET"};
        uni27[1] = new String[]{"Telangana State Level Police Recruitment Board Results and Answer key.", "Telangana State Public Service Commission.",
                "FOREST BEAT OFFICER (48/2017) RESULTS", "Telangana State Teacher Eligibility Test 2017"};
        uni27[2] = new String[]{"https://www.tslprb.in/",
        "https://tspsc.gov.in/TSPSCWEB0508/index.jsp" ,
 "http://fboresults.tspsc.gov.in/FBO-VERIFI-RESULT.pdf" ,
"http://tstet.cgg.gov.in/",                                 };
        uni28 = new String[3][];
        uni28[0] = new String[]{ "No data at present"   };
        uni28[1] = new String[]{  " comming soon...."  };
        uni28[2] = new String[]{   ""  };
        uni29 = new String[3][];
        uni29[0] = new String[]{"UKPSC"};
        uni29[1] = new String[]{"Uttarakhand Public Service Commission."};
        uni29[2] = new String[]{"http://ukpsc.gov.in/"};
        uni30 = new String[3][];
        uni30[0] = new String[]{ "No data at present"   };
        uni30[1] = new String[]{  " comming soon...."  };
        uni30[2] = new String[]{   ""  };
        uni31 = new String[3][];
        uni31[0] = new String[]{"UPTET", "UPPSC", "UPPSC", "UPSSSC", "UPPBPB", "UP"};
        uni31[1] = new String[]{"Uttar Pradesh Teacher Eligibility Test.", "Uttar Pradesh Public Service Commission", "Info",
        "Uttar Pradesh Subordinate Services Selection Commission", "Uttar Pradesh Police Recruitment and Promotion Board", "Assistant Teachers Recruitment Examination"};
        uni31[2] = new String[]{"http://upbasiceduboard.gov.in/",
        "http://uppsc.up.nic.in/CandidateHomePage.html"      ,
 "http://uppsc.up.nic.in/News.aspx?id=more"   ,
"http://upsssc.gov.in/News.aspx?id=2",
        "http://uppbpb.gov.in/",
        "https://upbasiceduboard.gov.in/att2018/tet_regno.aspx" };
        uni32 = new String[3][];
        uni32[0] = new String[]{"West Bengal Police", "WBPRB"};
        uni32[1] = new String[]{ "", "WEST BENGAL POLICE RECRUITMENT BOARD"};
        uni32[2] = new String[]{ "http://policewb.gov.in/wbp/index.php", "https://wbprb.applythrunet.co.in/"     };

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
                    stringBuilder.append(Jobe.this.getApplicationContext().getPackageName());
                    Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(stringBuilder.toString()));

                    try {
                        Jobe.this.startActivity(intent);
                    } catch (ActivityNotFoundException unused) {
                        Jobe mainActivity = Jobe.this;
                        StringBuilder stringBuilder2 = new StringBuilder();
                        stringBuilder2.append("http://play.google.com/store/apps/details?id=");
                        stringBuilder2.append(Jobe.this.getApplicationContext().getPackageName());
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
                    stringBuilder.append(Jobe.this.getApplicationContext().getPackageName());
                    Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(stringBuilder.toString()));

                    try {
                        Jobe.this.startActivity(intent);
                    } catch (ActivityNotFoundException unused) {
                        Jobe mainActivity = Jobe.this;
                        StringBuilder stringBuilder2 = new StringBuilder();
                        stringBuilder2.append("http://play.google.com/store/apps/details?id=");
                        stringBuilder2.append(Jobe.this.getApplicationContext().getPackageName());
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
