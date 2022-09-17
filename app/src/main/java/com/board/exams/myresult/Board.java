package com.board.exams.myresult;

import android.app.AlertDialog;
import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.LinearLayout;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.board.exams.myresult.add.Interstitial;
import com.board.exams.myresult.browserr.Browser_Main;
import com.board.exams.myresult.fragmclass.BFragm1;
import com.board.exams.myresult.fragmclass.Frag10;
import com.board.exams.myresult.fragmclass.Fragm2;
import com.board.exams.myresult.fragmclass.Fragm5;
import com.board.exams.myresult.fragmclass.Fragm8;
import com.board.exams.myresult.fragmclass.Resultfrag;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class Board extends AppCompatActivity {
    ViewPager viewPager;
    TabLayout tabLayout;
    TabItem tabItem;
    AlertDialog.Builder alertDialog;

    ListView listView;
    String []ti=new String[]{"Board Result","Class 12th","Class 11th","Class 10th","Class 8th","Class 5th"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.actiboard);
        new Interstitial().load(this);
        viewPager=(ViewPager)findViewById(R.id.viewpger);
         Toolbar toolbar = findViewById(R.id.toolbar);
        loadBannerAd();




        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }
        BottomNavigationView navView = findViewById(R.id.navbview);
        alertDialog = new AlertDialog.Builder(Board.this);
        navView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);


        tabLayout= (TabLayout) findViewById(R.id.tablayout);
        FragmentManager fm=getSupportFragmentManager();
        pagerada adapter = new pagerada(getSupportFragmentManager());
        adapter.addFragment(new Resultfrag(), ti[0]);

        adapter.addFragment(new Fragm2(), ti[1]);
        adapter.addFragment(new BFragm1(), ti[2]);
        adapter.addFragment(new Frag10(), ti[3]);
        adapter.addFragment(new Fragm8(), ti[4]);
        adapter.addFragment(new Fragm5(), ti[5]);

        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);




    }
    class pagerada extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();
        public pagerada(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int i) {
            return mFragmentList.get(i);
        }
        public void addFragment(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }
        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }
        @Override
        public int getCount() {
            return mFragmentList.size();
        }
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
                stringBuilder.append(Board.this.getApplicationContext().getPackageName());
                intent.putExtra("android.intent.extra.TEXT", stringBuilder.toString());
                intent.setType("text/plain");
                Board.this.startActivity(Intent.createChooser
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
                    stringBuilder.append(Board.this.getApplicationContext().getPackageName());
                    Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(stringBuilder.toString()));

                    try {
                        Board.this.startActivity(intent);
                    } catch (ActivityNotFoundException unused) {
                        Board mainActivity = Board.this;
                        StringBuilder stringBuilder2 = new StringBuilder();
                        stringBuilder2.append("http://play.google.com/store/apps/details?id=");
                        stringBuilder2.append(Board.this.getApplicationContext().getPackageName());
                        mainActivity.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(stringBuilder2.toString())));
                    }
                }
            }).setNegativeButton("Later", null).show();
        }
        else if (id ==R.id.ref){
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
                    stringBuilder.append(Board.this.getApplicationContext().getPackageName());
                    Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(stringBuilder.toString()));

                    try {
                        Board.this.startActivity(intent);
                    } catch (ActivityNotFoundException unused) {
                        Board mainActivity = Board.this;
                        StringBuilder stringBuilder2 = new StringBuilder();
                        stringBuilder2.append("http://play.google.com/store/apps/details?id=");
                        stringBuilder2.append(Board.this.getApplicationContext().getPackageName());
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
            Disclaimer.mo13133o(Board.this);
            return true;
        }
        else if (id ==R.id.search){

            Intent mIntent = new Intent(this, Browser_Main.class);
            mIntent.putExtra("url","https://www.google.co.in/");
            startActivity(mIntent);
            return true;
        }     else if (id ==R.id.action_apps){
            Intent myIntent = new Intent(Board.this,more_app.class);
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
                            onBackPressed();
                            return true;

                        case R.id.locker:
                            Intent mIntent = new Intent(Board.this, Browser_Main.class);
                            mIntent.putExtra("url","https://digilocker.gov.in/index.php#no-back");
                            startActivity(mIntent);

                            return true;
                        case R.id.noti:
                            startActivity( new Intent(Board.this, ficationoti.class));
                            return true;
                        case R.id.library:
                            startActivity( new Intent(Board.this, Brarili.class));
                            return true;
                    }
                    return false;
                }
            };

    private void loadBannerAd() {
      /*  AdView   adView = new AdView(this, "2675200819398732_2815293028722843", AdSize.BANNER_HEIGHT_50);
        LinearLayout adContainer = (LinearLayout) findViewById(R.id.main_ad_view);
        adContainer.addView(adView);
        adView.loadAd();
*/
    }


}
