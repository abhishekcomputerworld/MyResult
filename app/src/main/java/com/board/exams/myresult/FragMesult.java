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





public class FragMesult extends AppCompatActivity {
    ListView listView;
    String[][] uni1,uni2,uni3,uni4,uni5,uni6,uni7,uni8,uni9,uni10,uni11,uni12,uni13,uni14,
            uni15,uni16,uni17,uni18,uni19,uni20,uni21,uni22,uni23,uni24,uni25,uni26,uni27,uni28,uni29,uni30,uni31,uni32,uni33;
    Adapters adapter;
    String t;
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
                        Intent intent = new Intent(FragMesult.this, Browser_Main.class);
                        intent.putExtra("url", st2[a]);
                        startActivity(intent);}

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
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frag_mesult);
        new Interstitial().load(this);

        t= getIntent().getStringExtra("title");
        alertDialog = new AlertDialog.Builder(FragMesult.this);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setTitle(t+" Board Result");






        if (getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }
        listView=(ListView)findViewById(R.id.listview3);
        String []al=new String[]{"CBSE","CISCE,ISC,ICSE","Andhra Pradesh", "Arunachal Pradesh","Assam","Bihar",
                "CGBSE / Chhattisgarh","Goa","Gujarat","HBSE,Haryana", "Himachal Pradesh",
                "Jammu and Kashmir","Jharkhand",
                "Karnataka","Kerala","Madhya Pradesh","Maharashtra","Manipur","Meghalaya",
                "Mizoram","Nagaland","NIOS","Odisha","Punjab",
                "Rajasthan","RSOS","Sikkim","Tamil Nadu",
                "Telangana","Tripura","Uttarakhand/ Uttranchal","Uttar Pradesh","West Bengal"
        };
//33

        uni1 = new String[3][];
        uni1[0] = new String[]{"CBSE"};
        uni1[1] = new String[]{" Central Board Of Secondary Education Results"};
        uni1[2] = new String[]{"http://cbseresults.nic.in/"};
        uni2 = new String[3][];
        uni2[0] = new String[]{"ICSE", "ISC"};
        uni2[1] = new String[]{"Indian Certificate of Secondary Education", "Indian School Certificate (ISC)"               };
        uni2[2] = new String[]{    "http://www.cisce.org/"    , "http://www.cisce.org/"                                                                                                };
        uni3 = new String[3][];
        uni3[0] = new String[]{  "SSC Exam", "Intermediate Exam", "BSEAP", "BIEAP", "APOSS"};
        uni3[1] = new String[]{   "SSC Exam Result",
                "Inter 1st & 2nd year exam Result",
                "Board of Secondary Education",
                "Board of Intermediate Education Andhra Pradesh",
                "Andhra Pradesh Open School Society." };
        uni3[2] = new String[]{   "http://push147.sps.ap.gov.in/apresultboard/interresults.aspx",
                "https://results.apcfss.in/", "http://bseap.org/" , "http://bieap.gov.in/" , "http://www.apopenschool.org/"                                };
        uni4 = new String[3][];
        uni4[0] = new String[]{ "Arunachal Pradesh", "Arunachal Pradesh"   };
        uni4[1] = new String[]{ "Directorate Of Higher and Technical Education.", "Directorate Of Higher and Technical Education Results."  };
        uni4[2] = new String[]{    "http://apdhte.nic.in/" ,"http://apdhte.nic.in/Result_details.htm"  };
        uni5 = new String[3][];
        uni5[0] = new String[]{"Assam", "Assam", "Assam", "Assam(SEBA)", "Assam(SEBA)"};
        uni5[1] = new String[]{   "Assam Higher Secondary Education Council (AHSEC)", "AHSEC Results",
                "Assam Results", "Board of Secondary Education, Assam", "Results"                                                             };
        uni5[2] = new String[]{"http://ahsec.nic.in/", "http://ahsec.nic.in/Results/index.aspx" , "http://resultsassam.nic.in/"  , "http://sebaonline.org/?link=aG9tZQ%3D%3D", "http://sebaonline.org/?link=bm90aWZpY2F0aW9uc19wdWJsaWM%3D"  };
        uni6 = new String[3][];
        uni6[0] = new String[]{ "Matric Exam", "Intermediate Exam",
                "BSEB", "Bihar", "Matric Exam", "Intermediate Exam", "BSEB",
                "BSEB", "BSEB", "BBOSE", "BBOSE", "BBOSE"           };
        uni6[1] = new String[]{  "Class 10th Matric result", "Inter Class 12th Exam Result",
                "BSEB Bihar Board Results", "Bihar All Results",
                "Matric Examination", "Intermediate Examination", "BSEB Bihar", "Bihar Board Online",
                "Bihar Board Online (main)", "The Bihar Board of Open Schooling and Examination.", "BBOSE Result", "BBOSE Results (Alt)"  };
        uni6[2] = new String[]{    "http://bihar-10th-result.indiaresults.com/br/bseb/class-10-exam-result-2019/query.htm",
        "https://bsebinteredu.in/",
 "http://bihar.indiaresults.com/bseb/default.htm",
    "http://bihar.indiaresults.com/default.htm",
            "http://biharboardonline.bihar.gov.in/matric-exam-2019",
            "http://biharboardonline.bihar.gov.in/InterExam2019",
            "http://www.bsebbihar.com/",
            "http://www.biharboardonline.in/",
            "http://biharboardonline.bihar.gov.in/",
            "http://www.bbose.org/",
            "http://www.bbose.org/ResDec2018.aspx",
            "http://www.bbose.org/ResultBBOSE.aspx"
            };
        uni7 = new String[3][];
        uni7[0] = new String[]{"Chhattisgarh", "Chhattisgarh (CGBSE)"};
        uni7[1] = new String[]{"results.cg.nic.in", "Chhattisgarh Board Of Secondary Education."};
        uni7[2] = new String[]{"http://results.cg.nic.in/", "http://cgbse.nic.in/"};
        uni8 = new String[3][];
        uni8[0] = new String[]{ "Goa (GBSHSE)"   };
        uni8[1] = new String[]{  "Goa Board of Secondary and Higher Secondary Education" };
        uni8[2] = new String[]{   "http://gbshse.gov.in/"  };
        uni9 = new String[3][];
        uni9[0] = new String[]{"Gujarat (GSEB)", "Gujarat"   };
        uni9[1] = new String[]{  "Gujarat Secondary and Higher Secondary Education Board", "Results"  };
        uni9[2] = new String[]{   "http://www.gseb.org/", "http://gujarat.indiaresults.com/"  };
        uni10 = new String[3][];
        uni10[0] = new String[]{ "Haryana (BSEH)", "Haryana (BSEH)"   };
        uni10[1] = new String[]{"Results","The Board of Secondary Education, Haryana" };
        uni10[2] = new String[]{ "http://haryana.indiaresults.com/hbse/default.aspx",  "http://www.bseh.org.in/home/"  };
        uni11 = new String[3][];
        uni11[0] = new String[]{ "Himachal Pradesh (HPBOSE)",
                "Himachal Pradesh (HPBOSE)"  };
        uni11[1] = new String[]{ "Himachal Pradesh Board Of School Education", "Himachal Pradesh Board Of School Education" };
        uni11[2] = new String[]{ "http://hpbose.org/Result.aspx",
        "http://himachal-pradesh.indiaresults.com/" };
        uni12 = new String[3][];
        uni12[0] = new String[]{  "Jammu and Kashmir (JKBOSE)",
                "Jammu and Kashmir (JKBOSE)", "Jammu and Kashmir (JKBOSE)"  };
        uni12[1] = new String[]{   "New Website", "Jammu and Kashmir State Board of School Education",  "Archived Results" };
        uni12[2] = new String[]{  "http://www.jkbose.ac.in", "http://jkbose.jk.gov.in/", "http://jkbose.jk.gov.in/jkboseresults.php"  };
        uni13 = new String[3][];
        uni13[0] = new String[]{ "Class 8th", "Class 9th",  "Class 10th","Class 12th",
                "JAC", "JAC", "Jharkhand Results" };
        uni13[1] = new String[]{ "Class 8th result",
                "Class 9th result","Class 10 result", "Class 12 result",
                "Jharkhand Academic Council-1",
                "Jharkhand Academic Council-2",
                "Jharkhand Results"};
        uni13[2] = new String[]{ "https://jacresultonline.com/jac8/",
        "http://182.18.138.199/jacresults/", "http://182.18.138.199/jacresults/", "http://182.18.138.199/jacresults/",
        "https://jac.nic.in"  ,
 "https://jac.jharkhand.gov.in/jac/",
  "http://jharresults.nic.in/"        };
        uni14 = new String[3][];
        uni14[0] = new String[]{"SSLC Exam",
                "PUC Exam","KSSEB", "PUE Board"};
        uni14[1] = new String[]{ "SSLC Calss 10th Results",
                "PUC I & II, Class 12th, CET results",
                "Karnataka Secondary Education Examination Board","re-valuation, re-counting and Supplementary circular. Model Questions and Question Bank."};
        uni14[2] = new String[]{ "http://karresults.nic.in/",
        "http://karresults.nic.in/","http://kseeb.kar.nic.in/", "http://pue.kar.nic.in/" };
        uni15= new String[3][];
        uni15[0] = new String[]{"Kerala",
                "Kerala Pareeksha Bhavan", "Kerala SSLC","Kerala SSLC", "Kerala DHSE"};
        uni15[1] = new String[]{"Kerala Results","SSLC Examination Government of Kerala",
                "Secondary School Leaving Certificate (SSLC) Examination","SSLC SAY Exam Result",
                "Department of Higher Secondary Education "  };
        uni15[2] = new String[]{  "http://keralaresults.nic.in/",
        "http://keralapareekshabhavan.in/","http://sslcexamkerala.gov.in/"    ,  "http://sslcexamkerala.gov.in/say_results.php",
        "http://dhsekerala.gov.in/"                                                      };
        uni16 = new String[3][];
        uni16[0] = new String[]{ "HSC Exam",
                "HSSC Exam", "MPBSE","MPBSE", "MPPEB", "MPPEB"  };
        uni16[1] = new String[]{ "Class 10 Results",
                "Class 12 Results","Madhya Pradesh Board of Secondary Education", "MPBSE Results",
                "MPPEB Online", "Professional Examination Board"  };
        uni16[2] = new String[]{  "http://mpresults.nic.in/",
                "http://mpresults.nic.in/" ,"http://mpbse.nic.in/" , "http://mpbse.nic.in/results.htm",
        "https://mpbse.mponline.gov.in/MPBSE/MPBSE"
,"http://peb.mp.gov.in/e_default.html"};
        uni17 = new String[3][];
        uni17[0] = new String[]{"Maharashtra",
                "Maharashtra","Maharashtra",
                "Maharashtra","Maharashtra Board"};
        uni17[1] = new String[]{"Results-1",
                "Results-2", "Results-3", "Maharashtra Results","Maharashtra State Board of Secondary and Higher Secondary Education"};
        uni17[2] = new String[]{ "http://mahresult.nic.in/",
        "http://sscresult.mkcl.org/","http://results.maharashtraeducation.com/", "http://results.gov.in/",
        "http://www.mahahsscboard.in/"};
        uni18 = new String[3][];
        uni18[0] = new String[]{"Manipur", "Manipur Board"};
        uni18[1] = new String[]{  "Manipur Results", "Board of Secondary Education, Manipur"   };
        uni18[2] = new String[]{  "http://manresults.nic.in/",
        "http://bsem.nic.in/" };
        uni19= new String[3][];
        uni19[0] = new String[]{ "Meghalaya (MBOSE)",
                "Meghalaya (MBOSE)"   };
        uni19[1] = new String[]{"Meghalaya Board of School Education", "Results"                       };
        uni19[2] = new String[]{    "http://mbose.in/",
        "http://results.mbose.in/"  };
        uni20 = new String[3][];
        uni20[0] = new String[]{"Mizoram Board(MBSE)", "Mizoram Board(MBSE)" };
        uni20[1] = new String[]{   "Mizoram Board of School Education", "Results"};
        uni20[2] = new String[]{  "http://www.mbse.edu.in/",
        "http://mizoram.indiaresults.com/mbse/default.aspx"  };
        uni21 = new String[3][];
        uni21[0] = new String[]{ "Nagaland (NBSE)",
                "Nagaland (NBSE)"  };
        uni21[1] = new String[]{  "Nagaland Board of School Education", "Results"  };
        uni21[2] = new String[]{  "http://nbsenagaland.com/index.htm" ,"http://nbsenagaland.com/results.htm" };
        uni22= new String[3][];
        uni22[0] = new String[]{ "Nios"   };
        uni22[1] = new String[]{  " The National Institute of Open Schooling"  };
        uni22[2] = new String[]{   "https://www.nios.ac.in/"  };
        uni23 = new String[3][];
        uni23[0] = new String[]{"Orissa Board",
                "Orissa Board","Orissa Board","Orissa Board"};
        uni23[1] = new String[]{"The Board of Secondary Education, Odisha","BSE Latest Updates", "BSE Results", "CHSE Results"  };
        uni23[2] = new String[]{ "http://www.bseodisha.ac.in/",
        "http://www.bseodisha.ac.in/latest-updates/",  "http://odisha.indiaresults.com/bse-orissa/default.aspx" ,"http://orissaresults.nic.in/" };

        uni24 = new String[3][];
        uni24[0] = new String[]{  "Punjab Board(PSEB)",
                "Punjab Board(PSEB)"   };
        uni24[1] = new String[]{   "Punjab School Education Board",
                "Results"};
        uni24[2] = new String[]{     "http://www.pseb.ac.in/",
        "http://punjab.indiaresults.com/pseb/default.aspx"};
    uni25 = new String[3][];
        uni25[0] = new String[]{"Rajasthan",
                "Rajasthan Board","Rajasthan Board","Rajasthan (RSOS)",
                "Rajasthan (RSOS)"};
        uni25[1] = new String[]{ "Rajasthan Results","http://rajeduboard.rajasthan.gov.in/","Rajasthan Education Board","Rajasthan State Open School", "Results"};
        uni25[2] = new String[]{"http://rajresults.nic.in/","http://rajeduboard.rajasthan.gov.in/", "http://rajasthan.indiaresults.com/","http://rsosapp.rajasthan.gov.in/",
        "http://education.rajasthan.gov.in/content/raj/education/rajasthan-state-open-school-jaipur/en/results.html"};

    uni26 = new String[3][];
        uni26[0] = new String[]{"RSOS"};
        uni26[1] = new String[]{"Rajasthan State Open School"};
        uni26[2] = new String[]{"http://education.rajasthan.gov.in/content/raj/education/rajasthan-state-open-school-jaipur/en/home.html"};

        uni27 = new String[3][];
        uni27[0] = new String[]{ "Sikkim"   };
        uni27[1] = new String[]{  ""  };
        uni27[2] = new String[]{   "http://sikkim.indiaresults.com/"  };

        uni28 = new String[3][];
        uni28[0] = new String[]{ "HSC Exam",
                "HSC Exam",  "SSLC Exam","DGE","DGE"};
        uni28[1] = new String[]{  "Class 12th HSE(+2) Results","Class 12th HSE(+2), HSE(+1) Arrears Results",  "Class 10th Results", "DGE Result","Directorate of Government Examinations"};
        uni28[2] = new String[]{ "http://tnresults.nic.in/",  "http://dge2.tn.nic.in/", "http://tnresults.nic.in/", "http://www.dge.tn.gov.in/result.html","http://www.dge.tn.gov.in/index.html" };
        uni29 = new String[3][];
        uni29[0] = new String[]{ "Intermediate Exam",
                "Intermediate Exam","Intermediate Exam","Intermediate Exam","Intermediate Exam", "TBIE",
                "TBIE", "TBIE", "TBIE","SSC Exam","TBSE",  "TSWREIS"};
        uni29[1] = new String[]{   "Inter 1st & 2nd year exam Result-1",
                "Inter 1st & 2nd year exam Result-2", "Inter 1st & 2nd year exam Result-3", "Inter 1st & 2nd year exam Result-4",
                "Inter 1st & 2nd year exam Result-5", "TBIE Exam", "Telangana State Board of Intermediate Education-1",
                "Telangana State Board of Intermediate Education-2",
                "Telangana State Board of Intermediate Education-3", "SSC Class 10th Result","Telangana Board of Secondary Education","Telangana Social Welfare Residential Educational Institutions Society, Hyderabad, Telangana."   };
        uni29[2] = new String[]{
                "http://results.cgg.gov.in/",
        "http://220.225.44.35/Results/Home.html" , "http://220.225.44.36/Results/Home.html", "http://exam.bie.telangana.gov.in/Results/Home.html",
                "http://examresults.ts.nic.in/", "http://exam.bie.telangana.gov.in","http://bie.tg.nic.in/",
        "http://bie.telangana.gov.in/",
"https://tsbie.cgg.gov.in/home.do",  "http://results.cgg.gov.in/",
        "https://www.bsetelangana.org/"            ,
 "http://cet.cgg.gov.in/coe/?login-theme-1"};
        uni30 = new String[3][];
        uni30[0] = new String[]{"Tripura" ,"Tripura Board"};
        uni30[1] = new String[]{ "Tripura Results",   "Tripura Board of Secondary Education"};
        uni30[2] = new String[]{  "http://tripuraresults.nic.in/","http://upresults.nic.in/"  };
        uni31 = new String[3][];
        uni31[0] = new String[]{ "Uttaranchal",};
        uni31[1] = new String[]{  "Uttaranchal Results"};
        uni31[2] = new String[]{"http://uaresults.nic.in/"};
        uni32 = new String[3][];
        uni32[0] = new String[]{"UP Results","UPMSP Result","UPMSP"};
        uni32[1] = new String[]{ "Uttar Pradesh Results","Board of High School and Intermediate Education Result", "Uttar Pradesh Madhyamik Shiksha Parishad"};
        uni32[2] = new String[]{ "http://upresults.nic.in/", "http://upmspresults.up.nic.in/","https://upmsp.edu.in/"};
        uni33 = new String[3][];
        uni33[0] = new String[]{"West Bengal",
                "West Bengal (WBBSE)",
                "West Bengal (WBBSE)"};
        uni33[1] = new String[]{"West Bengal Results",
                "West Bengal Board of Secondary Education",
                "Result"};
        uni33[2] = new String[]{      "http://wbresults.nic.in/",
        "http://www.wbbse.org/",
 "http://www.wbbse.org/"};

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
        if(t.equals(al[32])){
            adapter=new Adapters(this,uni33[0],uni33[1],uni33[2]);}









        listView.setAdapter(adapter);
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
                stringBuilder.append(FragMesult.this.getApplicationContext().getPackageName());
                intent.putExtra("android.intent.extra.TEXT", stringBuilder.toString());
                intent.setType("text/plain");
                FragMesult.this.startActivity(Intent.createChooser
                        (intent, "Share using....."));
                dialog.cancel();

            }
        });
        alertDialog.setNegativeButton("Later", null);
        alertDialog.show();
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
                    stringBuilder.append(FragMesult.this.getApplicationContext().getPackageName());
                    Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(stringBuilder.toString()));

                    try {
                        FragMesult.this.startActivity(intent);
                    } catch (ActivityNotFoundException unused) {
                        FragMesult mainActivity = FragMesult.this;
                        StringBuilder stringBuilder2 = new StringBuilder();
                        stringBuilder2.append("http://play.google.com/store/apps/details?id=");
                        stringBuilder2.append(FragMesult.this.getApplicationContext().getPackageName());
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
                    stringBuilder.append(FragMesult.this.getApplicationContext().getPackageName());
                    Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(stringBuilder.toString()));

                    try {
                        FragMesult.this.startActivity(intent);
                    } catch (ActivityNotFoundException unused) {
                        FragMesult mainActivity = FragMesult.this;
                        StringBuilder stringBuilder2 = new StringBuilder();
                        stringBuilder2.append("http://play.google.com/store/apps/details?id=");
                        stringBuilder2.append(FragMesult.this.getApplicationContext().getPackageName());
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
