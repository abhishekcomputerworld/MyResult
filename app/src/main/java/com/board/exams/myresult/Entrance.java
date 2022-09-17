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





public class Entrance extends AppCompatActivity {
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

                            Intent intent = new Intent(Entrance.this, Browser_Main.class);
                            intent.putExtra("url", st2[a]);
                            startActivity(intent);






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
                stringBuilder.append(Entrance.this.getApplicationContext().getPackageName());
                intent.putExtra("android.intent.extra.TEXT", stringBuilder.toString());
                intent.setType("text/plain");
                Entrance.this.startActivity(Intent.createChooser
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
        setContentView(R.layout.acti_entran);
        new Interstitial().load(this);

        t= getIntent().getStringExtra("title");


        alertDialog = new AlertDialog.Builder(Entrance.this);


        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setTitle(t+" Entrannce");

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
       uni1[0] = new String[]{  "AIIMS","AIIMS", "AIIMS", "AISSEE", "ATMA", "BARC", "BARC", "CAT", "CDAC", "CEED", "CIPET",
                "CMAT", "CSIR UGC NET", "GATE", "GPAT", "ICAR", "ICAR AIEEA", "ICAR Exam Net", "ICSI", "IIFT",
                "IIMC", "JAM", "JEE Advanced", "JEE Main", "JEE Main", "KVS", "MAT", "Navodaya Vidyalaya Samiti",
                "Navodaya Vidyalaya Samiti", "NCERT", "NDA/NA", "NDA/NA", "NDA/NA",
                "NEET", "NEET", "NEET", "NEET PG", "NET", "NEST",
                "NIOS", "NIOS D.El.Ed.", "Sainik School Entrance Exam.", "SNAP", "UCEED", "UPSC"};
        uni1[1] = new String[]{"All India Institute Of Medical Sciences", "AIIMS MBBS Roll Number wise list",
                 "AIIMS MBBS Over all Rank wise list", "All India Sainik Schools Entrance Exam", "Association of Indian Management Schools", "OCES DGFS Website", "OCES DGFS Results",
         "Common Admission Test IIM", "The Centre for Development of Advanced Computing.", "Common Entrance Exam for Design (CEED).", "Central Institute of Plastics Engineering & Technology", "The Common Management Admission Test (CMAT) 2018 exam results",
       "The Council for Scientific and Industrial Research. JRF (NET)", "The Graduate Aptitude Test in Engineering", "The Graduate Pharmacy Aptitude Test (GPAT) 2018 exam results",
          " Indian Council of Agricultural Research", "ICAR All India Entrance Examinations for Admission (AIEEA)", "",
         "Institute of Company Secretaries of India (ICSI)", "Indian Institute of Foreign Trade"
         , "Indian Institute of Mass Communication Entrance Examination", "Joint Admission Test for M.Sc.",
        "Joint Entrance Examination (Advanced) Results and Answer sheet.",
                "Joint Entrance Examination (Main) Answer Key & other",
        "http://cbseresults.nic.in/", "Kendriya Vidyalaya Sangathan", "Management Aptitude Test (MAT) by All India Management association (AIMA).",
          "Website", "Results and Announcements ", "RIE CEE 2017", "National Defence Academy and Naval Academy (Written Exam)",
          "National Defence Academy and Naval Academy (Interview)", "National Defence Academy and Naval Academy (Final Exam)", "National Eligibility cum Entrance Test NEET (UG) Answer Key", "National Eligibility cum Entrance Test  Results",
          "NEETSS, NEET-PG, NEET-MDS, FET 2018, FMGE, CET, PDCET, CETSS, 6 Year P-I, DNB THEORY, DNB PRACTICAL, Fellowship Exit.",
      "NEET (PG) Result", "CBSE UGC NET", "National Entrance Screening Test by National Institute of Science Education and Research" , "National Institute of Open Schooling",
       "National Institute of Open Schooling. D.El.Ed.", "Sainik School Entrance Exam."
         , "The Symbiosis International University", "Undergraduate Common Entrance Exam for Design.",
          "Union Public Service Commission. Civil, Army and other government services exam.",
        };
        uni1[2] = new String[]{"https://www.aiimsexams.org/"
       , "https://drive.google.com/file/d/1bP-WwbSKWFhov_tb-p-SOOmiTy6pGDEA/view?usp=sharing"
      , "https://drive.google.com/file/d/1iGQnzXbAc65nQYOjlMLR5i6Fg5ImkM9-/view?usp=sharing"
       , "https://www.sainikschooltvm.nic.in/index.php?option=com_content&view=article&id=83&Itemid=90&menu=admission"
             ,   "https://www.atmaaims.com/"
             ,   "http://www.barconlineexam.in/science/index.html#"
             ,   "https://www.i-register.co.in/BARCSCI18Live/frmresultlogin.aspx"
             ,   "https://iimcat.ac.in/per/g01/pub/756/ASM/WebPortal/1/index.html?756@@1@@1"
                ,     "https://www.cdac.in/index.aspx?id=edu_acts_Login_cv11#"
               , "http://www.ceed.iitb.ac.in"
             ,   "https://www.cipet.gov.in/academics/exam-results.php"
              ,  "https://ntacmat.nic.in/ntacmatcms/public/home.aspx"
              ,  "http://csirhrdg.res.in/"
              ,  "http://gate.iitm.ac.in/"
                , "https://ntagpat.nic.in/ntagpatcms/public/home.aspx"
              ,  "http://icarexam.net/"
               ,"https://www.aieea.net/",
                "http://icarexam.net/"
             , "https://www.icsi.edu/AnnouncementsforStudents.aspx"
              , "http://tedu.iift.ac.in/iift/view-all-updated.php"
              ,  "http://iimc.nic.in/WhatsNews_Description.aspx?News_id=40455"
             ,   "http://jam.iitkgp.ac.in/"
             ,   "https://www.jeeadv.ac.in/"
            ,    "https://jeemain.nic.in/webinfo/Public/Home.aspx"
            ,    "http://cbseresults.nic.in/"
              ,  "http://kvsangathan.nic.in/announcement"
            ,    "https://mat.aima.in"
            ,    "https://navodaya.gov.in/nvs/en/Home1"
             , "https://navodaya.gov.in/nvs/en/Admission-JNVST/Admission-Notifications/"
             ,   "http://ncert-cee.kar.nic.in/CEE.aspx"
            , "http://www.upsc.gov.in/exams-related-info/written-result"
              ,  "http://www.upsc.gov.in/interview-schedule-and-esummon-letters"
                , "http://www.upsc.gov.in/exams-related-info/final-result"
                , "https://cbseneet.nic.in/cbseneet/Welcome.aspx"
                , "http://cbseresults.nic.in/"
                , "http://natboard.edu.in/"
              ,  "https://drive.google.com/file/d/107GYj47R8q1ONZIgzRC8jUZOhv1s09zl/view"
              ,  "https://cbsenet.nic.in/"
              ,  "https://nestexam.in/result17.php"
             ,   "https://nios.ac.in/examresult.aspx"
            ,    "http://dled.nios.ac.in/"
        , "http://sainikschooladmission.in/index.html"
           ,     "https://www.snaptest.org/"
               , "http://www.uceed.iitb.ac.in/"
             ,   "http://www.upsc.gov.in/"
                };
        uni2 = new String[3][];
        uni2[0] = new String[]{"AP CHE", "AP DEECET", "AP DEECET", "AP D.El.Ed.", "AP EAMCET",
                "AP ICET", "AP TET"};
        uni2[1] = new String[]{ "Andhra Pradesh State Council of Higher Education. AP PGECET - 17,  AP EAMCET - 17, AP LAWCET - 17, AP EdCET - 17, AP ECET - 17, AP ICET - 17, AP PGECET - 17, AP PECET - 17.",
        "Andhra Pradesh Diploma in Elementary Education Common Entrance Test", "Results", "D.El.Ed., 1st year May 2018 Results ",
    "Andhra Pradesh Engineering, Agriculture and Medical Common Entrance Test (AP EAMCET)", "Andhra Pradesh Integrated Common Entrance Test Result & Answer key", "Andhra Pradesh Teacher Eligibility Test"                                                                                                    };
        uni2[2] = new String[]{"http://sche.ap.gov.in/APSCHEHome.aspx", "https://apdeecet.apcfss.in/", "https://apdeecetht188723.apcfss.in/apdeecetresults52369841.htm",
         "http://portal.bseap.org/dedistjun18res", "http://sche.ap.gov.in/eamcet/Eamcet/EAMCET_HomePage.aspx", "http://sche.ap.gov.in/ICET/ICET/ICET_HomePage.aspx", "https://results.apcfss.in/resultsaptet050218150320001730.aptet"                                                                                                             };
        uni3 = new String[3][];
        uni3[0] = new String[]{ "No data at present"   };
        uni3[1] = new String[]{  " comming soon...."  };
        uni3[2] = new String[]{   ""  };
        uni4 = new String[3][];
        uni4[0] = new String[]{ "No data at present"   };
        uni4[1] = new String[]{  " comming soon...."  };
        uni4[2] = new String[]{   ""  };
        uni5 = new String[3][];
        uni5[0] = new String[]{"BCECEB Results",
                "BCECE 2018",
                "Bihar ITICAT",
                "Bihar BEd.",
                "Bihar BEd.",
                "Bihar D.El.Ed.",
                "Simultala Awasiya Vidyalaya"};
        uni5[1] = new String[]{  "Bihar Combined Entrance Competitive Examination Board. Check Result in 'Latest Updates' section",
        "Result of BCECE-2018 (Adv. No. BCECEB(BCECE)-2018/21 Dated 19.05.2018)",
         "BCECEB Industrial Training Institute Competitive Admission Test (ITICAT) ",
        "Nalanda Open University Bihar Bachelor of Education (B.Ed) Common Entrance Test (CET)",
   "2019",  "http://biharcetbed.com/Conspref/Search.html",
 "Diploma in Elementary Education (D.El.Ed.) Examination.",
        "Bihar School Examination Board (BSEB)"                             };
        uni5[2] = new String[]{  "http://bceceboard.bihar.gov.in/",
       "http://bceceboard.bihar.gov.in/pdf_Adv/ADV_BC18_21.pdf",
      "http://bceceboard.bihar.gov.in/pdf_Adv/ADV_ITIC18_06.pdf",
        "http://biharcetbed.com/home.html",
    "http://biharcetbed.com/Conspref/Search.html" ,
 "https://biharboard.online/"            ,
      "https://biharboard.online/SAVAdmin/home.html"  };
        uni6 = new String[3][];
        uni6[0] = new String[]{ "No data at present"   };
        uni6[1] = new String[]{  " comming soon...."  };
        uni6[2] = new String[]{   ""  };
        uni7 = new String[3][];
        uni7[0] = new String[]{"JNU Entrance Exam"};
        uni7[1] = new String[]{"Jawaharlal Nehru University Entrance Exam Result and Cuts-Off lists."};
        uni7[2] = new String[]{"https://admissions.jnu.ac.in/SearchResultFin.aspx"};
        uni8 = new String[3][];
        uni8[0] = new String[]{ "No data at present"   };
        uni8[1] = new String[]{  " comming soon...."  };
        uni8[2] = new String[]{   ""  };
        uni9 = new String[3][];
        uni9[0] = new String[]{ "No data at present"   };
        uni9[1] = new String[]{  " comming soon...."  };
        uni9[2] = new String[]{   ""  };
        uni10 = new String[3][];
        uni10[0] = new String[]{ "No data at present"   };
        uni10[1] = new String[]{  " comming soon...."  };
        uni10[2] = new String[]{   ""  };
        uni11 = new String[3][];
        uni11[0] = new String[]{ "No data at present"   };
        uni11[1] = new String[]{  " comming soon...."  };
        uni11[2] = new String[]{   ""  };
        uni12 = new String[3][];
        uni12[0] = new String[]{ "No data at present"   };
        uni12[1] = new String[]{  " comming soon...."  };
        uni12[2] = new String[]{   ""  };
        uni13 = new String[3][];
        uni13[0] = new String[]{ "No data at present"   };
        uni13[1] = new String[]{  " comming soon...."  };
        uni13[2] = new String[]{   ""  };
        uni14 = new String[3][];
        uni14[0] = new String[]{"Karnataka DTE", "KCET", "KCET", "SRM JEEE"};
        uni14[1] = new String[]{"Directorate of Technical Education", "Karnataka CET ", "Karnataka CET ",
                "SRM University Entrance Exam" };
        uni14[2] = new String[]{ "http://www.dte.kar.nic.in/index.shtml", "http://karresults.nic.in/",
  "http://kea.kar.nic.in/", "https://applications.srmuniv.ac.in/btech"                           };
        uni15= new String[3][];
        uni15[0] = new String[]{"KEAM exam", "Kerala KMAT",};
        uni15[1] = new String[]{ "Kerala Engineering Architecture Medical Entrance Exam ",""};
        uni15[2] = new String[]{"http://www.cee-kerala.org/index.php/keam", "https://www.kmatkerala.in/"};
        uni16 = new String[3][];
        uni16[0] = new String[]{ "No data at present"   };
        uni16[1] = new String[]{  " comming soon...."  };
        uni16[2] = new String[]{   ""  };
    uni17 = new String[3][];
        uni17[0] = new String[]{"MAH MBA CET", "MH CET"};
        uni17[1] = new String[]{ "MBA and MMS programmes ", "DTE Maharashtra"};
        uni17[2] = new String[]{ "http://cetcell.mahacet.org/", "https://www.dtemaharashtra.gov.in/approvedinstitues/"};
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
        uni22[0] = new String[]{"OUAT","SCERT Odisha"};
        uni22[1] = new String[]{ "Orissa University of Agriculture and Technology.", "SAMS"        };
        uni22[2] = new String[]{ "http://www.ouat.nic.in/exam_result", "http://samsodisha.gov.in/"};
        uni23 = new String[3][];
        uni23[0] = new String[]{ "No data at present"   };
        uni23[1] = new String[]{  " comming soon...."  };
        uni23[2] = new String[]{   ""  };
        uni24 = new String[3][];
        uni24[0] = new String[]{  "No data at present"   };
        uni24[1] = new String[]{   " comming soon...."  };
        uni24[2] = new String[]{    ""  };
        uni25 = new String[3][];
        uni25[0] = new String[]{"BSTC 2018 Rajasthan"};
        uni25[1] = new String[]{"The Basic School Teaching Certificate (BSTC) conducted by the Banswara-based Govind Guru Tribal University (GGTU)"};
        uni25[2] = new String[]{"http://bstcggtu2018.com"};

         uni26 = new String[3][];
         uni26[0] = new String[]{"VITEEE"};
         uni26[1] = new String[]{"VIT Engineering Entrance Examination (VITEEE)"};
         uni26[2] = new String[]{"https://vtop11.vit.ac.in/viteeeresults/"};


        uni27 = new String[3][];
        uni27[0] = new String[]{"TS EAMCET", "TS ICET", "TS PECET", "TS POLYCET "};
        uni27[1] = new String[]{ "Telangana State Engineering Agriculture and Management Common Entrance Test Result and Answer key",
                                    "Telangana State Integrated MBA, MCA Entrance Exam",
                      "Telangana State Physical Education Common Entrance Test. B.P.Ed/D.P.Ed.",
                                          "Telangana Polytechnic Common Entrance Test",            };
        uni27[2] = new String[]{ "http://eamcet.tsche.ac.in/TSEAMCET/EAMCET_HomePage.aspx", "http://icet.tsche.ac.in/TSICET/TSICET_HomePage.aspx#"    ,                                            "http://pecet.tsche.ac.in/Content/frmDownLoadRankCard.aspx"  , "https://polycetts.nic.in/Default.aspx"        };
        uni28 = new String[3][];
        uni28[0] = new String[]{ "No data at present"   };
        uni28[1] = new String[]{  " comming soon...."  };
        uni28[2] = new String[]{   ""  };
        uni29 = new String[3][];
        uni29[0] = new String[]{ "No data at present"   };
        uni29[1] = new String[]{  " comming soon...."  };
        uni29[2] = new String[]{   ""  };
        uni30 = new String[3][];
        uni30[0] = new String[]{   "No data at present"   };
        uni30[1] = new String[]{    " comming soon...."  };
        uni30[2] = new String[]{     ""  };
        uni31 = new String[3][];
        uni31[0] = new String[]{"Combined Pre Ayush Test (CPAT)", "UP BEd JEE", "UP D.EL.ED", "UPSEE"};
        uni31[1] = new String[]{ "Conducted by University of Lucknow", "Uttar Pradesh BEd Entrance", "Uttar Pradesh Diploma in Elementary Education", "Uttar Pradesh State Entrance Examination Results and Answer Key",  };
        uni31[2] = new String[]{  "http://cpatup2017.in/index.html", "http://www.lkouniv.ac.in/en/news?Newslistslug=en-events" , "http://updeledinfo.in./"  , "https://upsee.nic.in/publicinfo/public/home.aspx"  };
        uni32 = new String[3][];
        uni32[0] = new String[]{"WBJEE"};
        uni32[1] = new String[]{"West Bengal Joint Entrance Exam "};
        uni32[2] = new String[]{"http://www.wbjeeb.in/"};

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
                    stringBuilder.append(Entrance.this.getApplicationContext().getPackageName());
                    Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(stringBuilder.toString()));

                    try {
                        Entrance.this.startActivity(intent);
                    } catch (ActivityNotFoundException unused) {
                        Entrance mainActivity = Entrance.this;
                        StringBuilder stringBuilder2 = new StringBuilder();
                        stringBuilder2.append("http://play.google.com/store/apps/details?id=");
                        stringBuilder2.append(Entrance.this.getApplicationContext().getPackageName());
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
                    stringBuilder.append(Entrance.this.getApplicationContext().getPackageName());
                    Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(stringBuilder.toString()));

                    try {
                        Entrance.this.startActivity(intent);
                    } catch (ActivityNotFoundException unused) {
                        Entrance mainActivity = Entrance.this;
                        StringBuilder stringBuilder2 = new StringBuilder();
                        stringBuilder2.append("http://play.google.com/store/apps/details?id=");
                        stringBuilder2.append(Entrance.this.getApplicationContext().getPackageName());
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
