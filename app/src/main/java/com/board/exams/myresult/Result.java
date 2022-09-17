package com.board.exams.myresult;

import android.app.AlertDialog;
import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.board.exams.myresult.browserr.Browser_Main;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;


public class   Result extends AppCompatActivity {


    AlertDialog.Builder alertDialog;



    String a,b;
    int i;
    String [][]url2=new String[7][];
    String [][]ur11=new String[2][];
    String [][]ur10=new String[7][];
    String [][]url8=new String[4][];
    String [][]url5=new String[2][];
    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        a= getIntent().getStringExtra("name");
        b= getIntent().getStringExtra("class");
        i= getIntent().getIntExtra("num",0);




        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setTitle(a);
        if (getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }
        alertDialog = new AlertDialog.Builder(Result.this);
         ListView listView=(ListView)findViewById(R.id.listview3);
        ArrayAdapter<String> arrayAdapter=new ArrayAdapter<String>(
                this, R.layout.samp2frag,R.id.text2,getIntent().
                getStringArrayExtra("text"));
        listView.setAdapter(arrayAdapter);




        url2[0] = new String[]{ "http://cbseresults.nic.in/cbseresults_cms/Public/Home.aspx","https://www.cisce.org/","https://results.apcfss.in/","http://apdhte.nic.in/","http://ahsec.nic.in/","http://biharboardonline.bihar.gov.in/inter-result#","http://results.cg.nic.in/","http://gbshse.gov.in/","http://www.gseb.org/", "http://haryana.indiaresults.com/hbse/default.htm","http://hpbose.org/Result.aspx","http://jkbose.jk.gov.in/jkboseresults.php","https://jac.nic.in/","http://karresults.nic.in/","http://keralaresults.nic.in/","http://mpbse.nic.in/","http://mahresult.nic.in/", "http://manresults.nic.in/","http://results.mbose.in/","http://mizoram.indiaresults.com/mbse/default.aspx","http://nbsenagaland.com/results.htm","https://www.nios.ac.in/examresult.aspx","http://orissaresults.nic.in/","http://punjab.indiaresults.com/pseb/default.aspx","http://rajresults.nic.in/","http://education.rajasthan.gov.in/content/raj/education/rajasthan-state-open-school-jaipur/en/results.html","http://sikkim.indiaresults.com/","http://dge2.tn.nic.in/",
                "http://exam.bie.telangana.gov.in/Results/Home.html","http://tripuraresults.nic.in/","http://ubse.uk.gov.in/pages/display/85-results--admit-cards","http://upresults.nic.in/","http://wbresults.nic.in/"};
        url2[1] = new String[]{ "https://www.embibe.com/exams/cbse-date-sheet/", "https://www.icsesyllabus.in/date-sheet/isc-class-12-datesheet","https://www.careerindia.com/time-table/andhra-pradesh-class-12-general-exam-time-table-t6.html","https://www.mapsofindia.com/education/exam/arunachal-pradesh-12th-class-time-table.html","https://www.mapsofindia.com/education/exam/assam-board-ahsec-date-sheet.html","https://www.careerindia.com/time-table/bihar-board-class-12-exam-time-table-t72.html","https://www.careerindia.com/time-table/chhattisgarh-board-class-12-exam-time-table-t14.html","https://www.mapsofindia.com/education/exam/goa-board-hssc-time-table.html", "https://www.mapsofindia.com/education/exam/gujarat-board-hsce-time-table.html","https://www.careerindia.com/time-table/haryana-board-class-12-exam-time-table-t98.html","https://www.careerindia.com/time-table/himachal-pradesh-class-12-exam-time-table-t18.html","https://www.careerindia.com/time-table/jksbose-jammu-province-summer-zone-class-12-regular-candidates-exam-time-table-t21.html","https://www.careerindia.com/time-table/jharkhand-intermediate-class-12-exam-time-table-t23.html","https://www.careerindia.com/time-table/karnataka-board-class-12-2nd-puc-exam-time-table-t25.html","https://www.careerindia.com/time-table/kerala-hse-class-12-exam-time-table-t27.html","https://www.mapsofindia.com/education/exam/madhya-pradesh-higher-secondary-date-sheet.html", "https://www.careerindia.com/time-table/maharashtra-hsc-vocational-class-12-exam-time-table-t83.html","https://www.careerindia.com/time-table/manipur-board-class-12-exam-time-table-t95.html","https://www.careerindia.com/time-table/meghalaya-hsslc-class-12-exam-time-table-t89.html","https://www.mapsofindia.com/education/exam/mizoram-board-hsslc-time-table.html","https://www.careerindia.com/time-table/nagaland-hsslc-class-12-exam-time-table-t46.html","https://www.careerindia.com/news/nios-date-sheet-for-2019-class-10-and-12-released-024596.html","https://www.careerindia.com/time-table/odisha-board-class-12-exam-time-table-t48.html","https://www.careerindia.com/time-table/punjab-class-12-exam-time-table-t93.html",
                "https://www.careerindia.com/time-table/rajasthan-board-class-12-exam-time-table-t64.html","https://www.clickindia.com/listing.php?id=560","https://www.embibe.com/exams/sikkim-class-12-time-table/","https://www.careerindia.com/time-table/tamil-nadu-hsc-class-12-exam-time-table-t63.html","https://www.careerindia.com/time-table/telangana-hsc-class-12-exam-time-table-t60.html","https://www.careerindia.com/time-table/tripura-board-class-12-exam-time-table-t52.html","https://www.careerindia.com/time-table/uttarakhand-board-class-12-exam-time-table-t67.html","https://www.careerindia.com/time-table/uttar-pradesh-board-class-12-exam-time-table-t54.html","https://www.careerindia.com/time-table/west-bengal-board-class-12-exam-time-table-t58.html"};
        url2[2] = new String[]{ "https://schools.aglasem.com/cbse/cbse-sample-papers-class-12/", "https://schools.aglasem.com/25078","https://schools.aglasem.com/27606","https://schools.aglasem.com/65388","https://schools.aglasem.com/9334","https://schools.aglasem.com/20932","http://www.examresults.net/goa/goa-board-hssc-class-12th-result/sample-paper/","http://www.examresults.net/gujarat/gseb-hsc-12th-result/sample-paper/","https://schools.aglasem.com/76013", "http://www.examresults.net/hp/himachal-board-hpbose-12th-result/sample-paper/","https://www.jagranjosh.com/articles-jharkhand-class-10th-exam-papers-1298980073-1","https://www.careerindia.com/tamil-nadu-board-exam-sb12.html","http://www.examresults.net/kerala/dhse-kerala-board-plus-two-12th-result/sample-paper/","https://www.jagranjosh.com/articles/mp-board-class-12-physics-previous-years-question-papers-1537440134-1","https://www.respaper.com/maharashtra_hsc_12/","http://www.examresults.net/meghalaya/mbose-hsslc-12th-result/sample-paper/","https://nios.ac.in/student-information-section/syllabus-sample-question-paper(sr-secondary).aspx", "https://boardmodelpaper.com/chse-odisha-plus-two-model-paper-odisha-12th-sample-paper-blueprint/","http://www.examresults.net/punjab/pseb-12th-result/sample-paper/","http://www.careerpoint.ac.in/free-sample-paper/rbse-class-12-sample-papers-hindi-download.aspx","https://www.jagranjosh.com/articles-tamil-nadu-board-class-12th-exam-papers-1299218406-1","https://cbseportal.com/telangana-board/papers/class-12-chemistry-paper-2","http://ubse.uk.gov.in/pages/display/99-old---model-question-paper","https://www.4ono.com/up-12th-sample-papers-pdf-20161718/"
              };
        url2[3] = new String[]{ "https://nvshq.org/result/aposs-intermediate-result/", "https://www.eduassam.com/assam-state-open-school-result/","http://www.bbose.org/ResultBBOSE.aspx","https://schools.aglasem.com/94749","http://gjrtsos.com/StudentResult.aspx?SclassXXII=12","https://www.jagranjosh.com/results/haryana-open-school-hos-12th-result-online-12th-145565","https://www.jagranjosh.com/results/hp-board-hpbose-12th-result-online-12th-145464","http://jkbose.jk.gov.in/","https://schools.aglasem.com/89539", "https://boardexam.aglasem.com/kos-sslc-result-march-april-2019/","https://www.getmyuni.com/kerala-open-school-results/b","https://schools.aglasem.com/94942","http://nsosboard.com/","https://www.nios.ac.in/examresult.aspx","http://odisha.indiaresults.com/bse-orissa/default.htm","http://education.rajasthan.gov.in/content/raj/education/en/school-sec-education/rajasthanstateopenschooljaipur/results.html","http://www.tamilnaducouncil.ac.in/", "https://schools.aglasem.com/95136","https://www.jagranjosh.com/results/up-board-12th-result-online-12th-145452","http://wbcros.in/result/"
        };
        url2[4] = new String[]{ "https://boardexam.aglasem.com/ap-open-inter-time-table-april-2019/", "https://schools.aglasem.com/98271","https://biharboard.xyz/bbose-12th-exam-date-december/","https://schools.aglasem.com/89165","http://gjrtsos.com/","https://schools.aglasem.com/109083","https://schools.aglasem.com/92639","https://www.getmyuni.com/jksos-time-table/b","https://schools.aglasem.com/89524", "https://boardexam.aglasem.com/kos-time-table-2019/","https://www.getmyuni.com/kerala-open-school-time-table/b","https://schools.aglasem.com/88483","http://nsosboard.com/","https://www.nios.ac.in/examresult.aspx","https://schools.aglasem.com/92484","https://www.getmyuni.com/rsos-12th-time-table/b","http://www.tamilnaducouncil.ac.in/", "https://schools.aglasem.com/88471","https://schools.aglasem.com/89243","https://schools.aglasem.com/91168"
        };
        url2[5] = new String[]{ "https://www.getmyuni.com/cbse-12th-board-syllabus/b", "https://www.getmyuni.com/ap-board-intermediate-bieap-syllabus/b","http://ahsec.nic.in/Syllabus.html","https://www.getmyuni.com/bihar-board-12th-intermediate-bseb-syllabus/b","http://cgbse.nic.in/academic.aspx#class12","https://www.getmyuni.com/isc-12th-cisce-syllabus/b","https://www.getmyuni.com/gujarat-board-12th-hsc-gseb/b","https://www.getmyuni.com/hbse-12th-haryana-board-syllabus/b","http://hpbose.org/Syllabus.aspx", "https://www.getmyuni.com/karnataka-puc-syllabus/b","http://mpbse.nic.in/syllabus12.htm","https://mahahsscboard.maharashtra.gov.in/#","https://www.getmyuni.com/mbose-hsslc-12th-syllabus/b","https://www.getmyuni.com/manipur-hse-12th-syllabus/b","http://www.mbse.edu.in/#","http://nbsenagaland.com/curriculum.htm","https://www.getmyuni.com/nios-board-syllabus/b", "https://www.getmyuni.com/odisha-chsc-12th-bse-syllabus/b","http://www.pseb.ac.in/syllabus","http://rajeduboard.rajasthan.gov.in/anudeshika-etc/anudeshika-syllabus.htm","https://www.getmyuni.com/tn-board-syllabus/b","http://bie.telangana.gov.in/syllabus.html","https://www.getmyuni.com/tbse-hs-12th-tripura-board-syllabus/b","https://www.getmyuni.com/cbse-12th-board-syllabus/b","https://www.getmyuni.com/up-board-12th-syllabus/b",
                "https://www.getmyuni.com/west-bengal-hs-syllabus/b"};

        ur11[0] = new String[]{"http://andhra-pradesh.indiaresults.com/", "http://kseeb.kar.nic.in/","http://results.mbose.in/","http://nbsenagaland.com/index.htm","http://dge2.tn.nic.in/","http://hpbose.org/Result.aspx","http://telangana.indiaresults.com/"};
        ur11[1] = new String[]{"https://www.careerindia.com/time-table/andhra-pradesh-class-11-exam-time-table-t68.html","https://www.embibe.com/exams/karnataka-puc-time-table/","https://www.careerindia.com/time-table/meghalaya-sslc-class-11-exam-time-table-t82.html","https://www.careerindia.com/time-table/nagaland-hsslc-class-11-exam-time-table-t87.html","https://www.embibe.com/exams/tamil-nadu-11-public-exam-time-table/","https://www.careerindia.com/time-table/himachal-pradesh-class-11-exam-time-table-t103.html","https://www.careerindia.com/time-table/himachal-pradesh-class-11-exam-time-table-t103.html","https://www.careerindia.com/time-table/telangana-hsc-class-11-exam-time-table-t81.html"};


        ur10[0] = new String[]{ "http://cbseresults.nic.in/cbseresults_cms/Public/Home.aspx", "https://www.cisce.org/","http://main.bseap.org/Index.aspx","http://apdhte.nic.in/","http://ahsec.nic.in/","http://bihar.indiaresults.com/default.htmhttp://biharboardonline.bihar.gov.in/inter-result#","http://results.cg.nic.in/","http://gbshse.gov.in/","http://www.gseb.org/", "http://haryana.indiaresults.com/hbse/default.htm","http://hpbose.org/Result.aspx","http://jkbose.jk.gov.in/jkboseresults.php","https://jac.nic.in/","http://karresults.nic.in/","http://keralaresults.nic.in/","http://mpbse.nic.in/","http://mahresult.nic.in/", "http://manresults.nic.in/","http://results.mbose.in/","http://mizoram.indiaresults.com/mbse/default.aspx","http://nbsenagaland.com/results.htm","https://www.nios.ac.in/examresult.aspx","http://orissaresults.nic.in/","http://punjab.indiaresults.com/pseb/default.aspx","http://rajresults.nic.in/","http://education.rajasthan.gov.in/content/raj/education/rajasthan-state-open-school-jaipur/en/results.html","http://sikkim.indiaresults.com/","http://tnresults.nic.in/",
                "http://results.cgg.gov.in/", "http://ubse.uk.gov.in/pages/display/85-results--admit-cards","http://upresults.nic.in/","http://wbresults.nic.in/",};
        ur10[1] = new String[]{ "https://www.embibe.com/exams/cbse-class-10-date-sheet/", "https://www.mapsofindia.com/education/exam/icse-board-time-table.html","https://www.careerindia.com/time-table/andhra-pradesh-ssc-class-10-exam-time-table-t7.html","https://www.mapsofindia.com/education/exam/arunachal-pradesh-10th-class-time-table.html","https://www.careerindia.com/time-table/assam-board-class-10-exam-time-table-t97.html","https://www.mapsofindia.com/education/exam/bihar-board-matric-time-table.html","https://www.embibe.com/exams/cbse-class-10-date-sheet/","https://www.careerindia.com/time-table/goa-board-ssc-class-10-exam-time-table-t16.html","https://www.careerindia.com/time-table/gujarat-board-class-10-exam-time-table-t90.html", "https://www.embibe.com/exams/hbse-class-10-date-sheet/","https://www.mapsofindia.com/education/exam/hpbse-10-class-date-sheet.html","https://www.careerindia.com/time-table/jksbose-jammu-province-summer-zone-class-10-regular-candidates-exam-time-table-t61.html","https://www.careerindia.com/time-table/jharkhand-board-class-10-exam-time-table-t22.html","https://www.careerindia.com/time-table/karnataka-sslc-class-10-exam-time-table-t24.html","https://www.careerindia.com/time-table/kerala-sslc-class-10-exam-time-table-t26.html","https://www.mapsofindia.com/education/exam/madhya-pradesh-high-school-date-sheet.html","https://www.careerindia.com/time-table/maharashtra-board-ssc-class-10-revised-course-exam-time-table-t28.html", "https://www.mapsofindia.com/education/exam/manipur-board-hslc-time-table.html","https://www.careerindia.com/time-table/meghalaya-sslc-class-10-exam-time-table-t30.html","https://www.careerindia.com/time-table/mizoram-hslc-class-10-exam-time-table-t77.html","https://www.careerindia.com/time-table/nagaland-sslc-class-10-exam-time-table-t47.html","https://www.careerindia.com/news/nios-date-sheet-for-2019-class-10-and-12-released-024596.html","https://www.mapsofindia.com/education/exam/odisha-class10th-date-sheet.html","https://www.mapsofindia.com/education/exam/punjab-board-10th-time-table.html","https://www.mapsofindia.com/education/exam/rajasthan-board-class-10-time-table.html",
                "https://www.getmyuni.com/rsos-12th-time-table/b","https://www.embibe.com/exams/sikkim-class-10-time-table/","https://www.careerindia.com/time-table/tamil-nadu-sslc-class-10-exam-time-table-t50.html","https://www.careerindia.com/time-table/telangana-ssc-class-10-exam-time-table-t59.html","https://www.careerindia.com/time-table/tripura-board-class-10-exam-time-table-t51.html","https://www.careerindia.com/time-table/uttarakhand-board-class-10-exam-time-table-t55.html","https://www.mapsofindia.com/education/exam/up-board-high-school-schedule.html","https://www.careerindia.com/time-table/west-bengal-board-class-10-exam-time-table-t65.html"};
        ur10[2] = new String[]{ "http://www.cbseguess.com/papers/sample_papers/x/", "https://www.cisce.org/icse_X_Specimen_Question_Papers.aspx","http://boards.edurite.com/andhra+pradesh+board-sample-question-paper~bzV.html","https://www.questionpaper2019.in/2017/12/assam-board-10th-model-papers-2019.html","https://schools.aglasem.com/71473","https://schools.aglasem.com/20931","http://www.examresults.net/goa/goa-board-ssc-class-10th-result/sample-paper/","http://www.examresults.net/gujarat/gseb-ssc-10th-result/sample-paper/","https://schools.aglasem.com/105422","https://www.jagranjosh.com/articles-himachal-pradesh-board-class-10th-exam-papers-1298982359-1", "http://www.examresults.net/jharkhand/jac-board-10th-matric-result/sample-paper/","https://www.careerindia.com/karnataka-board-exam-sb10.html","http://www.examresults.net/kerala/kerala-board-hse-sslc-class-10-result/sample-paper/","https://www.jagranjosh.com/articles-mp-board-class-10th-exam-papers-1298983150-1","http://www.examresults.net/maharashtra/MSBSHSE-maharashtra-board-ssc-result-10th/sample-paper/","http://www.examresults.net/meghalaya/mbose-sslc-10th-result/sample-paper/","https://nios.ac.in/student-information-section/syllabus-sample-question-paper(sr-secondary).aspx","http://www.examresults.net/orissa/orissa-board-bse-matric-result-10th/sample-paper/", "https://schools.aglasem.com/64863","https://electroexpart.in/rbse-model-paper-2019-class-10th/","http://www.examresults.net/tamilnadu/tn-board-sslc-10th-result/sample-paper/","https://testchampion.jagranjosh.com/free-pdf-page?file=cbse-class-10th-sample-paper-2019-telangana-telugu.pdf","http://ubse.uk.gov.in/pages/display/99-old---model-question-paper","http://www.4eno.in/sample-papers/up-board-class-10th-model-paper/"};
        ur10[3] = new String[]{ "https://boardexam.aglasem.com/aposs-ssc-results-april-2019/", "https://resultfor.in/assam-open-school-10th-12th-result/","https://schools.aglasem.com/94957","https://schools.aglasem.com/94738","http://gjrtsos.com/StudentResult.aspx?SclassXXII=10","https://www.jagranjosh.com/results/haryana-open-school-hos-10th-result-online-10th-145564","https://www.jagranjosh.com/results/hp-board-hpbose-10th-result-online-10th-145463","http://jkbose.jk.gov.in/","https://schools.aglasem.com/89539", "https://boardexam.aglasem.com/kos-sslc-result-march-april-2019/","https://www.getmyuni.com/kerala-open-school-results/b","https://schools.aglasem.com/94942","http://nsosboard.com/","https://www.nios.ac.in/examresult.aspx","http://odisha.indiaresults.com/bse-orissa/default.htm","http://education.rajasthan.gov.in/content/raj/education/en/school-sec-education/rajasthanstateopenschooljaipur/results.html","http://www.tamilnaducouncil.ac.in/", "https://schools.aglasem.com/95140","https://www.jagranjosh.com/results/up-board-10th-result-online-10th-145451","http://wbcros.in/result/"
        };
        ur10[4] = new String[]{ "https://www.mapsofindia.com/education/exam/andhra-pradesh-board-date-sheet.html", "https://www.mapsofindia.com/education/exam/assam-board-hslc-date-sheet.html","https://schools.aglasem.com/88784","https://schools.aglasem.com/94685","http://gjrtsos.com/","https://schools.aglasem.com/109082","https://schools.aglasem.com/92657","https://www.getmyuni.com/jksos-time-table/b","https://schools.aglasem.com/89529", "https://boardexam.aglasem.com/kos-time-table-2019/","https://www.getmyuni.com/kerala-open-school-time-table/b","https://schools.aglasem.com/88481","http://nsosboard.com/","https://www.nios.ac.in/examresult.aspx","https://schools.aglasem.com/92500","https://www.getmyuni.com/rsos-12th-time-table/b","http://www.tamilnaducouncil.ac.in/", "https://schools.aglasem.com/88469","https://schools.aglasem.com/89244","https://schools.aglasem.com/91168"
        };
        ur10[5] = new String[]{ "https://www.cbsesyllabus.in/class-10", "https://www.getmyuni.com/ap-board-10th-ssc-bseap-syllabus/b","https://www.getmyuni.com/assam-hslc-seba-syllabus/b","https://www.getmyuni.com/bihar-board-10th-matric-bseb-syllabus/b","http://cgbse.nic.in/academic.aspx#class10","https://www.getmyuni.com/icse-10th-board-cisce-syllabus/b","https://www.getmyuni.com/gujarat-board-10th-ssc-gseb-syllabus/b","https://www.getmyuni.com/hbse-10th-haryana-board-syllabus/b","http://hpbose.org/Syllabus.aspx", "https://www.getmyuni.com/karnataka-sslc-syllabus/b","http://mpbse.nic.in/syllabus10.htm","https://mahahsscboard.maharashtra.gov.in/sscsub.htm","https://www.getmyuni.com/mbose-sslc-10th-syllabus/b","https://www.getmyuni.com/manipur-hslc-10th/b","http://www.mbse.edu.in/#","http://nbsenagaland.com/curriculum.htm","https://www.getmyuni.com/nios-board-syllabus/b", "https://www.getmyuni.com/odisha-10th-hsc-bse-syllabus/b","http://www.pseb.ac.in/syllabus","http://rajeduboard.rajasthan.gov.in/anudeshika-etc/anudeshika-syllabus.htm","https://www.getmyuni.com/tn-board-syllabus/b","http://bie.telangana.gov.in/syllabus.html","https://www.getmyuni.com/tbse-madhyamik-syllabus/b","https://www.getmyuni.com/uttarakhand-board-10th-syllabus/b","https://www.getmyuni.com/up-board-10th-syllabus/b",
                "https://www.getmyuni.com/west-bengal-madhyamik-syllabus/b"};


        url8[0] = new String[]{"http://hpbose.org/Result.aspx", "http://rajeduboard.rajasthan.gov.in/"};
        url8[1] = new String[]{"https://schools.aglasem.com/61482", "https://www.jntufastupdates.com/rbse-8th-time-table-2019/"};
        url8[2] = new String[]{ "http://tamil-nadu.indiaresults.com/"};
        url8[3] = new String[]{ "https://drive.google.com/file/d/1nf5c6CzF_Gkpf65IZNE5GDNMaeFSQ8tE/view?usp=sharing"};

        url5[0] = new String[]{"http://hpbose.org/Result.aspx","http://rajrmsa.nic.in/Class5thBoard/ResultPrint_ByRollNoDOB.aspx"};
        url5[1] = new String[]{"http://hpbose.org/", "http://rajeduboard.rajasthan.gov.in/http://rajeduboard.rajasthan.gov.in/http://rajeduboard.rajasthan.gov.in/"};




        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                final int c=position;
                {
                    if(b.equals("12r")) {
                        Log.e("abhishek_12r","__"+String.valueOf(String.valueOf(url2[i][c])));
                        Intent intent = new Intent(Result.this, Browser_Main.class);
                        intent.putExtra("url",String.valueOf(url2[i][c]));
                        startActivity(intent);
                    }
                    else if(b.equals("10r")) {
                        Log.e("abhishek_10r","__"+String.valueOf(String.valueOf(url2[i][c])));
                        Intent intent = new Intent(Result.this, Browser_Main.class);
                        intent.putExtra("url", String.valueOf(ur10[i][c]));
                        startActivity(intent);

                    }

                    else if(b.equals("11r")) {
                        Log.e("abhishek_11r","__"+String.valueOf(String.valueOf(url2[i][c])));
                        Intent intent = new Intent(Result.this, Browser_Main.class);
                        intent.putExtra("url", String.valueOf(ur11[i][c]));
                        startActivity(intent);
                    }
                    else if(b.equals("8r")) {
                        Intent intent = new Intent(Result.this, Browser_Main.class);
                        intent.putExtra("url", String.valueOf(url8[i][position]));
                        startActivity(intent);
                    }
                    else if(b.equals("5r")) {
                        Intent intent = new Intent(Result.this, Browser_Main.class);
                        intent.putExtra("url", String.valueOf(url5[i][position]));
                        startActivity(intent);
                    }
                }















            }
        });

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
                stringBuilder.append(Result.this.getApplicationContext().getPackageName());
                intent.putExtra("android.intent.extra.TEXT", stringBuilder.toString());
                intent.setType("text/plain");
                Result.this.startActivity(Intent.createChooser
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
                    stringBuilder.append(Result.this.getApplicationContext().getPackageName());
                    Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(stringBuilder.toString()));

                    try {
                        Result.this.startActivity(intent);
                    } catch (ActivityNotFoundException unused) {
                        Result mainActivity = Result.this;
                        StringBuilder stringBuilder2 = new StringBuilder();
                        stringBuilder2.append("http://play.google.com/store/apps/details?id=");
                        stringBuilder2.append(Result.this.getApplicationContext().getPackageName());
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
            startActivity(intent);  return true;
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
                    stringBuilder.append(Result.this.getApplicationContext().getPackageName());
                    Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(stringBuilder.toString()));

                    try {
                        Result.this.startActivity(intent);
                    } catch (ActivityNotFoundException unused) {
                        Result mainActivity = Result.this;
                        StringBuilder stringBuilder2 = new StringBuilder();
                        stringBuilder2.append("http://play.google.com/store/apps/details?id=");
                        stringBuilder2.append(Result.this.getApplicationContext().getPackageName());
                        mainActivity.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(stringBuilder2.toString())));
                    }
                }
            }).setNegativeButton("Later", null).show();
        }

        else if (id ==R.id.prof){
            FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
            if (user != null) {
                DrawerLayout drawer = findViewById(R.id.drawer_layout);
                drawer.openDrawer(GravityCompat.START);

            }
            else {
                Toast.makeText(Result.this,"You are not  login Please login",Toast.LENGTH_SHORT).show();
            }
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
        else if (id ==R.id.pri){
            Intent mIntent = new Intent(this, Browser_Main.class);
            mIntent.putExtra("url","https://sites.google.com/view/androdeveloper/privacypolicy");
            startActivity(mIntent); return true;
        }


        return super.onOptionsItemSelected(item);
    }


}
