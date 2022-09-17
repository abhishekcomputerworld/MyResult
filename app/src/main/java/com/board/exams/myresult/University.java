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
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;


import com.board.exams.myresult.add.Interstitial;
import com.board.exams.myresult.browserr.Browser_Main;



public class University extends AppCompatActivity {
    ListView listView;
    String[][] uni1,uni2,uni3,uni4,uni5,uni6,uni7,uni8,uni9,uni10,uni11,uni12,uni13,uni14,
            uni15,uni16,uni17,uni18,uni19,uni20,uni21,uni22,uni23,uni24,uni25,uni26,uni27,uni28,uni29,uni30,uni31,uni32;
    Adapters adapter;    AlertDialog.Builder alertDialog;

    String t;
String []al;


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
                       // Toast.makeText(University.this, String.valueOf(Uri.parse(st2[a])), Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(University.this, Browser_Main.class);
                            intent.putExtra("url", String.valueOf(Uri.parse(st2[a])));
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
                stringBuilder.append(University.this.getApplicationContext().getPackageName());
                intent.putExtra("android.intent.extra.TEXT", stringBuilder.toString());
                intent.setType("text/plain");
                University.this.startActivity(Intent.createChooser
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
        setContentView(R.layout.acti_university);
        new Interstitial().load(this);
        t= getIntent().getStringExtra("title");

        alertDialog = new AlertDialog.Builder(University.this);


        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setTitle(t+" University");

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
        uni1[0] = new String[]{"IGNOU"};
        uni1[1] = new String[]{"Indira Gandhi National Open University"};
        uni1[2] = new String[]{ "http://www.ignou.ac.in/ignou/studentzone/results/1"};
        uni2 = new String[3][];
        uni2[0] = new String[]{"GITAM University"};
        uni2[1] = new String[]{"Gandhi Institute of Technology and Management, Visakhapatnam, Andhra Pradesh",};
        uni2[2] = new String[]{"https://doeresults.gitam.edu/onlineresults/pages/Newgrdcrdinput1.aspx"};
        uni3 = new String[3][];
        uni3[0] = new String[]{"Arunachal University"};
        uni3[1] = new String[]{"Rajiv Gandhi University, Papum Pare, Arunachal Pradesh."};
        uni3[2] = new String[]{"http://www.rgu.ac.in/Academics/Result"};
        uni4 = new String[3][];
        uni4[0] = new String[]{"Assam University", "Dibrugarh University, Assam ", "Dibrugarh University, Assam "};
        uni4[1] = new String[]{ "Assam University, Silchar.", "Results-1", "Results-2"};
        uni4[2] = new String[]{"http://ausexamresults.in/", "https://dibru.ac.in/site/2019/" , "http://dibru.net/"};
        uni5 = new String[3][];
        uni5[0] = new String[]{"DDELNMU","LNMU", "Magadh  University", "TMBU" };
        uni5[1] = new String[]{
                "Directorate of Distance Education Lalit Narayan Mithila University Darbhanga, Bihar.", "Lalit Narayan Mithila University Darbhanga, Bihar",
                 "Magadh University Bodh Gaya, Bihar.", "Tilka Manjhi Bhagalpur University, Bhagalpur."};
        uni5[2] = new String[]{
                "http://www.ddelnmu.ac.in/home/result.php", "http://lnmu.ac.in/home/results.php", "https://www.magadhuniversity.ac.in/result.php",
"http://result.tmbuniversity.info/"};
        uni6 = new String[3][];
        uni6[0] = new String[]{"Bilaspur University"};
        uni6[1] = new String[]{"Bilaspur, Chhattisgarh"};
        uni6[2] = new String[]{"http://www.bilaspuruniversity.ac.in/results.php"};
        uni7 = new String[3][];
        uni7[0] = new String[]{"Delhi University", "DU Journalism", "GGSIP University", "JNU"};
        uni7[1] = new String[]{"Delhi University, Delhi.", "Delhi School Of Journalism exam",
                 "Guru Gobind Singh Indraprastha University Dwarka, Delhi.",
                "Jawaharlal Nehru University Admissions."};
        uni7[2] = new String[]{
                "http://www.du.ac.in/", "http://dsj.du.ac.in/index.html" , "http://sggu.ac.in/results/", "https://admissions.jnu.ac.in/"};
        uni8 = new String[3][];
        uni8[0] = new String[]{ "No data at present"   };
        uni8[1] = new String[]{  " comming soon...."  };
        uni8[2] = new String[]{   ""  };



        uni9 = new String[3][];
        uni9[0] = new String[]{"Ganpat University", "GTU", "Gujarat University", "Gujarat University", "MS University", "Saurashtra University",
                "SGGU", "VNSGU"};
        uni9[1] = new String[]{"Ganpat University Mehsana, Gujarat.", "Gujarat Technological University Ahmedabad."
                , "Home", "Result", "Maharaja Sayajirao University of Baroda.", "Saurashtra University Rajkot, Gujarat.",
        "Shri Govind Guru University Godhra, Gujarat.", "Veer Narmad South Gujarat University Surat, Gujarat."};
        uni9[2] = new String[]{"http://www.ganpatuniversity.ac.in/exam-result", "http://www.gtu.ac.in/result.aspx",
        "http://www.gujaratuniversity.ac.in/web/", "http://www.gujaratuniversity.org.in/result_e/result/result.html", "http://msub.digitaluniversity.ac/SearchDuplicateResult.aspx?ID=822",
       "http://result.saurashtrauniversity.edu/Default1.aspx", "http://sggu.ac.in/results/", "http://vnsgu.ac.in/vnsguexam/result.php"};


        uni10 = new String[3][];
        uni10[0] = new String[]{ "No data at present"   };
        uni10[1] = new String[]{  " comming soon...."  };
        uni10[2] = new String[]{   ""  };

        uni11 = new String[3][];
        uni11[0] = new String[]{"HPTU", "HPU" };
        uni11[1] = new String[]{"Himachal Pradesh Technical University.", "Himachal Pradesh University Shimla, Himachal Pradesh."};
        uni11[2] = new String[]{"http://himachal-pradesh.indiaresults.com/himtu/default.aspx", "http://himachal-pradesh.indiaresults.com/hp-university/default.aspx"};
        uni12 = new String[3][];
        uni12[0] = new String[]{"Jammu University", "Kashmir University"};
        uni12[1] = new String[]{"University of Jammu.", "University of Jammu and Kashmir, Srinagar."};
        uni12[2] = new String[]{ "http://www.coeju.com/", "https://egov.uok.edu.in/Results/"};
        uni13 = new String[3][];
        uni13[0] = new String[]{"VBU "};
        uni13[1] = new String[]{ "Vinoba Bhave University Hazaribagh, Jharkhand.",};
        uni13[2] = new String[]{"http://vbu.ac.in/2016/06/23/vbu-result-2/"};
        uni14 = new String[3][];
        uni14[0] = new String[]{"Bangalore University", "BSPUCPA", "Davangere University "
               , "Gulbarga University", "Gulbarga University", "Kuvempu University", "Mangalore University",
                "PUC", "RCUB", "Tumkur University",  };
        uni14[1] = new String[]{"Bangalore University, Bengaluru, Karnataka.", "The Bengaluru South Pre-University Colleges Principals’ Association (BSPUCPA) ",
                "Davangere University Davangere, Karnataka", "Gulbarga University, Karnataka.", "Results",
       "Kuvempu University Shimoga, Karnataka, ", "Mangalore University Mangalore, Karnataka.", "Karnataka Pre-University College",
        "Rani Channamma University Belagavi, Karnataka.", "Tumakuru, Karnataka.", "Visvesvaraya Technological University"};
        uni14[2] = new String[]{"http://52.77.88.220:7878/", "https://bspucpa.com/",
 "http://davangereuniversity.ac.in/", "http://gug.ac.in/", "http://karnataka.indiaresults.com/gulbarga-university/default.aspx", "http://www.kuvempu.ac.in/php/exam.php",
         "http://52.77.88.220:3331/", "http://result.bspucpa.com/", "http://results.logisys.net.in/rcub/", "http://164.100.133.129:81/tutresult/", "http://results.vtu.ac.in/"};
        uni15 = new String[3][];
        uni15[0] = new String[]{"Calicut University","DHIU","Kerala University", "KTU", "MGU"              };
        uni15[1] = new String[]{ "The University of Calicut, Malappuram, Kerala.","Darul Huda Islamic University, Malappuram, Kerala ","University of Kerala Thiruvananthapuram, Kerala.",
                "Kerala Technical University. APJ Abdul Kalam Technological University.", "Mahatma Gandhi (MG) University, Kerala."   };
        uni15[2] = new String[]{ "http://www.cupbresults.uoc.ac.in/CuPbhavan/index.php","http://dhiu.in/exam-result/index.php"
               , "https://exams.keralauniversity.ac.in/result.php", "https://ktu.edu.in/eu/res/viewResults.htm"         , "https://www.mgu.ac.in/index.php?option=com_content&view=article&id=529&Itemid=1601"
                                                                                       };
        uni16 = new String[3][];
        uni16[0] = new String[]{"BU Bhopal", "CCS", "DHSGSU","Jiwaji University", "MCU",
                "RGPV", "Vikram University"};
        uni16[1] = new String[]{"Barkatullah University Bhopal, Madhya Pradesh.","Chaudhary Charan Singh University  Meerut, Uttar Pradesh.","Doctor Harisingh Gour Vishwavidyalaya Sagar University",
                "Jiwaji University Gwalior,  Madhya Pradesh.",
                "Makhanlal Chaturvedi National University of Journalism and Communication,  Bhopal, Madhya Pradesh",
                "Rajiv Gandhi Proudyogiki Vishwavidyalaya, Bhopal, Madhya Pradesh.",
                "Vikram University Ujjain, Madhya Pradesh.",};
        uni16[2] = new String[]{
                "http://www.bubhopal.ac.in/1322/Result-Dashboard","http://192.163.211.186/~ccsuresu/",
                "http://dhsgsu.ac.in/Result",
        "http://jiwaji.ucanapply.com/result.php",
 "http://www.mcu.ac.in/Examination_Information.aspx",
 "http://result.rgpv.ac.in/Result/ProgramSelect.aspx",
        "http://www.vikramuniv.net/page.php?p=results.php"  };
        uni17= new String[3][];
        uni17[0] = new String[]{"Amravati University","BAMU ","Gondwana University", "Mumbai University", "RTMNU", "Shivaji University", "SRTMUN",};
        uni17[1] = new String[]{ "Sant Gadge Baba Amravati University (SGBAU)","Babasaheb Ambedkar Marathawada University  Aurangabad, Maharashtra.",
                "Gadchiroli, Maharashtra.", "Mumbai, Maharashtra.", "Nagpur University Nagpur, Maharashtra.", "Shivaji University Kolhapur, Maharashtra.",
                "Swami Ramanand Teerth Marathwada, Nanded, Maharashtra"};
        uni17[2] = new String[]{ "http://gondwanaexams.org/", "http://mu.ac.in/portal/results/",
   "https://rtmnuresults.org/", "http://suk.digitaluniversity.ac/SearchDuplicateResult.aspx?ID=28174",
           "http://www.srtmun.ac.in/en/" };
        uni18 = new String[3][];
        uni18[0] = new String[]{"manipur university"};
        uni18[1] = new String[]{""};
        uni18[2] = new String[]{"http://www.manipuruniv.ac.in/"};

        uni19= new String[3][];
        uni19[0] = new String[]{"NEHU"};
        uni19[1] = new String[]{ "North-Eastern Hill University"};
        uni19[2] = new String[]{"http://logisys.net.in/results/nehu/"};
        uni20 = new String[3][];
        uni20[0] = new String[]{"Mizoram University"};
        uni20[1] = new String[]{""};
        uni20[2] = new String[]{"https://www.mzu.edu.in/"};
        uni21 = new String[3][];
       uni21[0] = new String[]{"Nagaland University"};
       uni21[1] = new String[]{""};
        uni21[2] = new String[]{"http://nagalanduniversity.ac.in/English"};
      uni22 = new String[3][];
       uni22[0] = new String[]{"BPTU","Sambalpur University", "Utkal University"};
       uni22[1] = new String[]{ "BIJU PATNAIK UNIVERSITY OF TECHNOLOGY, ODISHA", "Sambalpur University, Odisha.","Utkal University, Odisha."};
       uni22[2] = new String[]{ "http://bputexam.in/StudentSection/ResultPublished/StudentResult.aspx",
        "http://orissaresults.nic.in/", "http://uuems.in/"                                                      };
        uni23 = new String[3][];
        uni23[0] = new String[]{"Pondicherry University"};
        uni23[1] = new String[]{""};
        uni23[2] = new String[]{ "http://result.pondiuni.edu.in/candidate.asp"};
        uni24 = new String[3][];
       uni24[0] = new String[]{"GNDU", "PTU","Punjab University", "Punjabi University"};
       uni24[1] = new String[]{ "Guru Nanak Dev University, Amritsar, Punjab.",
               "I. K. Gujral Punjab Technical University, Kapurthala, Punjab.",
               "Punjab University Chandigarh.",
               "Punjabi University Patiala, Punjab."};
       uni24[2] = new String[]{"http://web.gndu.ac.in/examination-results.aspx","http://ptuexam.com/NewLogin.aspx?ReturnUrl=%2f",
               "http://results.puchd.ac.in/","http://punjabiuniversity.ac.in/puexam/results.html" };
        uni25 = new String[3][];
       uni25[0] = new String[]{"Bhagwant University","GGTU",  "JNVU", "MDSU", "MLSU",
               "RRBMU", "RTU", "RTU", "Shekhawati University(PDSU)", "Uniraj"};
       uni25[1] = new String[]{"Bhagwant University Ajmer, Rajasthan.", "Govind Guru Tribal University",
        "Jai Narain Vyas University Jodhpur, Rajasthan.", "Maharshi Dayanand Saraswati University is a university in Ajmer, Rajasthan", "Mohanlal Sukhadia University, Udaipur.",
               "Raj Rishi Bhartrihari Matsya University Alwar, Rajasthan.", "Rajasthan Technical University (RTU), Kota",
               "Pandit Deendayal Upadhyaya Shekhawati University Katrathal, Rajasthan. (Click 'Student Panel' and then 'Result')",
         "University of Rajasthan Jaipur, Rajasthan.",

        };
       uni25[2] = new String[]{ "http://www.univindia.info/bhaGreSult/", "http://bstcggtu2018.com",
    "http://www.jnvuonline.co/", "http://www.mdsuexam.org/", "https://results.mlsuportal.in/",
        "http://www.rrbmuniv.ac.in/results.php","http://www.rtu.ac.in/RTU/", "http://www.esuvidha.info/",
        "http://univexam.com/", "https://www.uniraj.ac.in/index.php?mid=5407" };
        uni26 = new String[3][];
       uni26[0] = new String[]{"Alagappa University", "Anna University", "Anna University",
               "Anna University", "BDU", "Bharathiar University", "Madras University", "Madras University", "Madras University",
               "MS University", "Periyar University", "Periyar University", "Periyar University",
                                       "Thiruvalluvar University", "TNDALU",
                                               };
       uni26[1] = new String[]{
               "Alagappa University", "Chennai, Tamil Nadu.", "Controller Of Exams(aucoe)",
   "coe1", "Bharathidasan University Tiruchirappalli, Tamil Nadu.", "The Bharathiar University, Coimbatore, Tamil Nadu.",
           "University of Madras Chepauk, Chennai", "INSTITUTE OF DISTANCE EDUCATION", "UG / PG / Professional Degree Examination Results", "Manonmaniam Sundaranar University, Tirunelveli, Tamil Nadu.",   "Website"
           ,      "Result",      "News", "Thiruvallauvar University Vellore, Tamil Nadu", "Tamil Nadu Dr Ambedkar Law University",};
       uni26[2] = new String[]{

               "http://alagappauniversity.ac.in/page/36", "https://www.annauniv.edu/",
         "http://aucoe.annauniv.edu/", "http://coe1.annauniv.edu/home/", "http://www.bdu.ac.in/results/", "http://buc.edu.in/Home/UniNews2","http://www.unom.ac.in/"
        ,"http://www.ideunom.ac.in/", "http://www.ideunom.ac.in/Result/", "http://www.msuniv.ac.in/results.aspx",
        "https://www.periyaruniversity.ac.in/", "https://www.periyaruniversity.ac.in/Result.php", "https://www.periyaruniversity.ac.in/AllNewsEvents.php",
        "http://www.tvuni.in/results.aspx", "http://tndalu.ac.in/"
        };
        uni27 = new String[3][];
       uni27[0] = new String[]{"Hyderabad University", "JNTUH", "JNTUH", "Kakatiya University", "Osmania University",
               "PJTSAU", "Satavahana University"};
       uni27[1] = new String[]{
               "Gachibowli, Hyderabad.", "Jawaharlal Nehru Technological University Hyderabad.",
               "Results", "Warangal, Telangana.", "Hyderabad, Telangana.", "Professor Jayashankar Telangana State Agricultural University, Hyderabad, Telangana."
          ,  "Satavahana University Karimnagar, Telangana."};
       uni27[2] = new String[]{ "http://acad.uohyd.ac.in/ResPg.html","http://jntuh.ac.in/"      ,
   "http://jntuhresults.in/","http://kuexams.org/", "http://www.osmania.ac.in/examination-results.php",
          "http://www.pjtsau.ac.in/","http://www.satavahana.ac.in/"};
        uni28 = new String[3][];
       uni28[0] = new String[]{"Tripura University"};
       uni28[1] = new String[]{""};
       uni28[2] = new String[]{"http://www.tripurauniv.in/"};
        uni29 = new String[3][];
        uni29[0] = new String[]{"Uttaranchal University"};
        uni29[1] = new String[]{""};
        uni29[2] = new String[]{"http://www.uou.ac.in/"};
        uni30 = new String[3][];
       uni30[0] = new String[]{"Uttaranchal University"};
       uni30[1] = new String[]{""};
       uni30[2] = new String[]{"https://uttaranchaluniversity.ac.in/"};
       uni31 = new String[3][];
        uni31[0] = new String[]{"Aligarh Muslim University", "Allahabad University", "BHU",
                "DDUGU", "Glocal University", "Kanpur University (CSJM)", "Lucknow University", "Lucknow University",
                "MGKVP", "MJPRU", "VBSPU",                    };
        uni31[1] = new String[]{ "Aligarh, Uttar Pradesh", "Allahabad University, Allahabad", " Banaras Hindu University",
        "Deen Dayal Upadhyay Gorakhpur University", "Mirzapur Pole, Uttar Pradesh.", "Chhatrapati Shahu Ji Maharaj University Kanpur, Uttar Pradesh.",
        "News for Students", "Current Events", "Mahatma Gandhi Kashi Vidyapith Varanasi", "Mahatma Jyotiba Phule Rohilkhand University", "Veer Bahadur Singh Purvanchal University, Jaunpur, UP."
    };
        uni31[2] = new String[]{
              "http://www.amucontrollerexams.com/admissions_ga.html", "http://allduniv.ac.in/home/pages/187", "http://bhuonline.in/",
         "http://ddugorakhpuruniversity.in/", "http://www.glocaluniversity.edu.in/resultmay2017/", "http://www.kanpuruniversity.org/imp_dates_results.htm", "http://www.lkouniv.ac.in/en/news?Newslistslug=en-events",
                 "http://www.lkouniv.ac.in/en/news?Newslistslug=en-student-news", "http://mgkvp.ac.in/results.aspx", "http://www.mjpru.ac.in/results.html", "http://vbspuonline.in/index.html"};
        uni32 = new String[3][];
       uni32[0] = new String[]{"Aliah University", "Burdwan University", "Calcutta University","UGB","WBSU",};
       uni32[1] = new String[]{"Kolkata, West Bengal", "The University of Burdwan, Purba Bardhaman, West Bengal, India.",
               "University of Calcutta, West Bengal.", "The University of Gour Banga, Malda, West Bengal.","West Bengal State University Kolkata, West Bengal."};
       uni32[2] = new String[]{"https://aliah.ac.in/results-and-annoucements","http://www.buruniv.ac.in/bunew/Template.php?page=NOT_CATEGORY&subpage=EXRS_UG",
               "http://wbresults.nic.in/", "http://www.ugb.ac.in/","http://www.wbsubregistration.org/notice-exam.php"};

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
                    stringBuilder.append(University.this.getApplicationContext().getPackageName());
                    Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(stringBuilder.toString()));

                    try {
                        University.this.startActivity(intent);
                    } catch (ActivityNotFoundException unused) {
                        University mainActivity = University.this;
                        StringBuilder stringBuilder2 = new StringBuilder();
                        stringBuilder2.append("http://play.google.com/store/apps/details?id=");
                        stringBuilder2.append(University.this.getApplicationContext().getPackageName());
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
                    stringBuilder.append(University.this.getApplicationContext().getPackageName());
                    Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(stringBuilder.toString()));

                    try {
                        University.this.startActivity(intent);
                    } catch (ActivityNotFoundException unused) {
                        University mainActivity = University.this;
                        StringBuilder stringBuilder2 = new StringBuilder();
                        stringBuilder2.append("http://play.google.com/store/apps/details?id=");
                        stringBuilder2.append(University.this.getApplicationContext().getPackageName());
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
