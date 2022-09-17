
package com.board.exams.myresult;


import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.MenuItem;
import android.view.Menu;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RatingBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.board.exams.myresult.add.A;
import com.board.exams.myresult.add.Interstitial;
import com.board.exams.myresult.browserr.Browser_Main;
import com.board.exams.myresult.browserr.SearchEngineModal;



import com.firebase.ui.auth.AuthMethodPickerLayout;
import com.firebase.ui.auth.AuthUI;
import com.firebase.ui.auth.ErrorCodes;
import com.firebase.ui.auth.IdpResponse;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Start extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener{
    public SharedPreferences f16265v;
    private static final int RC_SIGN_IN = 123;
    private static final String TAG ="Main";
    Boolean a;  BottomNavigationView navbView;
    TextView t1,t2;
    LinearLayout li;
    RelativeLayout re;
    String []ti=new String[]{"Board","University","Jobs","Entrance","Polytechnic","Institutes","RRB","Scholarships"};
    String []sti=new String[]{"CBSE, ICSE, Maharashtra, Bihar & more"
            ,"IGNOU, Mumbai, Delhi, Chennai & more"
            ,"UPSC, MPSC, Police, Teacher, Bank & more"
            ,"JEE, CET, GATE, B.Ed, NEET, NET, Navodaya & more",
            "DTE, ITI, POLYCET, BTE, Diploma & more",
            "AIBE, AIIMS, ICAI, BARC, Navodaya & more"
            ,"The Railway Recruitment Board",
            ""};
    FloatingActionButton fab,fabs;
    ProgressDialog progressDialog;
    AlertDialog.Builder alertDialog;
    ListView listView;
    ImageView imageView;



    @Override
    protected void onResume() {
        super.onResume();
        navbView.setSelectedItemId(R.id.homes);

    }
    class Adapters extends ArrayAdapter<String> {

        Context context;
        String []ti;
        String []sti;
        public Adapters(Context c, String []t1,String []t2) {
            super(c, R.layout.sam1,R.id.title,t1);
            this.context=c;
            this.ti=t1;
            this.sti=t2;
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
        public View getView(int position, View convertView, ViewGroup parent) {
            Myviewholder myviewholder=null;
            if(convertView==null){ LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);          //  View rowView=inflater.inflate(R.layout.samp1, null);
                convertView=inflater.inflate(R.layout.sam1, parent, false);
                myviewholder=new Myviewholder(convertView);
                convertView.setTag(myviewholder);}
            else
                myviewholder=(Myviewholder) convertView.getTag();

            myviewholder.textView1.setText(ti[position]);
            myviewholder.textView2.setText(sti[position]);

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
        setContentView(R.layout.acti_start);
new Interstitial().load(this);
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        this.f16265v = defaultSharedPreferences;
        if (!defaultSharedPreferences.getBoolean("disclaimerRead", false)) {
            mo13189p();
        }
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        alertDialog = new AlertDialog.Builder(Start.this);

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();






        listView=(ListView)findViewById(R.id.listview);


        fab = findViewById(R.id.fab);
        fabs = findViewById(R.id.fabs);


        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(fabs.getVisibility()==View.GONE){
                    Bitmap b = A.takescreenshotOfRootView(listView);
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
                            //Toast.makeText(Start.this, "Scrren shot save in"+getExternalFilesDir("My Result")+"and Library of app", Toast.LENGTH_LONG).show();

                        }
                    }, 600);
                }
            }
        });



        navigationView.setNavigationItemSelectedListener(this);
        View h=navigationView.getHeaderView(0);
        RelativeLayout headerImageView= (RelativeLayout)h.findViewById(R.id.all);

        headerImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
                if (user != null) {
                    Toast.makeText(Start.this,"You Succesfully login before no need to login again",Toast.LENGTH_SHORT).show();

                }
                else {createSignInIntent();
                }

            }
        });
        re= (RelativeLayout) h.findViewById(R.id.relative);
        li= (LinearLayout) h.findViewById(R.id.layout);

        t1= (TextView)h.findViewById(R.id.text);
        t2= (TextView)h.findViewById(R.id.user_name_v2);
        imageView= (ImageView) h.findViewById(R.id.userimg);


        navbView = findViewById(R.id.navbview);
        navbView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        navbView.setSelectedItemId(R.id.homes);


        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        if(user!= null){
            Read(); }
        Adapters adapter=new Adapters(this,ti,sti);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(position==0){
                    Intent intent= new Intent(Start.this, Board.class);
                    startActivity(intent);                    }


                else if(position==1 || position==2 || position==3 || position==4  ){
                    {

                        Intent intent= new Intent(Start.this, State.class);
                        intent.putExtra("hed", ti[position]);
                        startActivity(intent);


                    }
                }



                else if(position==5 || position==6 || position==7){
                    Intent intent= new Intent(Start.this, Rrb.class);
                    intent.putExtra("hed",  ti[position]);
                    startActivity(intent);
                }
            }
        });

    }

    public boolean isExternalStorageWritable() {
        String state = Environment.getExternalStorageState();
        if (Environment.MEDIA_MOUNTED.equals(state)) {
            return true;
        }
        return false;
    }
    public void storeScreenshot(Bitmap bitmap) {

        File file=getExternalFilesDir(Environment.DIRECTORY_PICTURES);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("screenshot_");
        stringBuilder.append(new SearchEngineModal(this).Screen_shor_no());
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
                    Toast.makeText(Start.this,"something went wrong ",Toast.LENGTH_SHORT).show();

                }
            }
        }
    }

    public void p(){
        progressDialog = new ProgressDialog(this);
        progressDialog.setProgressStyle(0);
        progressDialog.setMessage("Please wait...");
        progressDialog.setCancelable(true);
        progressDialog.setIndeterminate(false);
        progressDialog.show();
    };

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
                stringBuilder.append(Start.this.getApplicationContext().getPackageName());
                intent.putExtra("android.intent.extra.TEXT", stringBuilder.toString());
                intent.setType("text/plain");
                Start.this.startActivity(Intent.createChooser
                        (intent, "Share using....."));
                dialog.cancel();

            }
        });
        alertDialog.setNegativeButton("Later", null);
        alertDialog.show();
    }


    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {

            p();
           /* if(interstitialAd != null && interstitialAd.isAdLoaded()&&!interstitialAd.isAdInvalidated() ){
                interstitialAd.show();
                this.interstitialAd.buildLoadAdConfig().withAdListener(new C4307a());
               return;
            }
            loadAd();*/

            AlertDialog.Builder alertDialog=new AlertDialog.Builder(this);
            alertDialog.setTitle("Closing App");
            alertDialog.setMessage("Are you sure you want to Exit?");
            alertDialog.setIcon(R.drawable.ic_launcher_web);
            alertDialog.setPositiveButton("YES", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int which) {
                    Start.super.onBackPressed();
                }
            });
            alertDialog.setNegativeButton("NO", null);
            if (!isFinishing()) {
                m25845P();
                alertDialog.show();
                return;
            }
            finish();
        }
    }
    public void m25845P() {
        ProgressDialog progressDialog = this.progressDialog;
        if (progressDialog != null) {
            if (progressDialog.isShowing()) {
                this.progressDialog.dismiss();
            }
            this.progressDialog = null;
        }
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
                    stringBuilder.append(Start.this.getApplicationContext().getPackageName());
                    Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(stringBuilder.toString()));

                    try {
                        Start.this.startActivity(intent);
                    } catch (ActivityNotFoundException unused) {
                        Start mainActivity = Start.this;
                        StringBuilder stringBuilder2 = new StringBuilder();
                        stringBuilder2.append("http://play.google.com/store/apps/details?id=");
                        stringBuilder2.append(Start.this.getApplicationContext().getPackageName());
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
                    stringBuilder.append(Start.this.getApplicationContext().getPackageName());
                    Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(stringBuilder.toString()));

                    try {
                        Start.this.startActivity(intent);
                    } catch (ActivityNotFoundException unused) {
                        Start mainActivity = Start.this;
                        StringBuilder stringBuilder2 = new StringBuilder();
                        stringBuilder2.append("http://play.google.com/store/apps/details?id=");
                        stringBuilder2.append(Start.this.getApplicationContext().getPackageName());
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

        else if (id ==R.id.pri){

            Intent mIntent = new Intent(this, Browser_Main.class);
            mIntent.putExtra("url","https://sites.google.com/view/androdeveloper/privacypolicy");
            startActivity(mIntent);
            return true;
        }
        else if (id ==R.id.search){

            Intent mIntent = new Intent(this, Browser_Main.class);
            mIntent.putExtra("url","https://www.google.co.in/");
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

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.noti) {                             startActivity( new Intent(Start.this, ficationoti.class));
        }
        else if (id == R.id.login) {
            FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
            if (user != null) {
                Toast.makeText(Start.this,"You Succesfully login before no need to login again",Toast.LENGTH_SHORT).show();

            }
            else {createSignInIntent();
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
        else if (id == R.id.pri) {
            Intent mIntent = new Intent(this, Browser_Main.class);
            mIntent.putExtra("url","https://sites.google.com/view/androdeveloper/privacypolicy");
            startActivity(mIntent);
            // Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://sites.google.com/view/androdeveloper/privacypolicy"));
            // startActivity(myIntent);
        }
        else if (id == R.id.sha) { erahs(); }
        else if (id == R.id.lik) {
            alertDialog.setTitle(R.string.ratings).setMessage(R.string.ratingmsg).setIcon(R
                    .drawable.ic_launcher_web).setPositiveButton("PROCEED", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("market://details?id=");
                    stringBuilder.append(Start.this.getApplicationContext().getPackageName());
                    Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(stringBuilder.toString()));

                    try {
                        Start.this.startActivity(intent);
                    } catch (ActivityNotFoundException unused) {
                        Start mainActivity = Start.this;
                        StringBuilder stringBuilder2 = new StringBuilder();
                        stringBuilder2.append("http://play.google.com/store/apps/details?id=");
                        stringBuilder2.append(Start.this.getApplicationContext().getPackageName());
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
        }
        else if (id == R.id.out) {
            FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
            if(user!= null){
                setVisible(true);
                // [START auth_fui_signout]
                AuthUI.getInstance()
                        //  .delete(this)

                        .signOut(this)
                        .addOnCompleteListener(new OnCompleteListener<Void>() {
                            public void onComplete(@NonNull Task<Void> task) {
                                Toast.makeText(Start.this,"You Succesfully logout",Toast.LENGTH_SHORT).show();
                                li.setVisibility(View.VISIBLE);
                                re.setVisibility(View.GONE); // ...
                            }
                        });
                // [END auth_fui_signout]
            }
            else {                    Toast.makeText(Start.this,"you are not login ",Toast.LENGTH_SHORT).show();
            }

        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener = new
            BottomNavigationView.OnNavigationItemSelectedListener() {

                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    switch (item.getItemId()) {
                        case R.id.homes:

                            return true;
                        case R.id.locker:
                            Intent mIntent = new Intent(Start.this, Browser_Main.class);
                            mIntent.putExtra("url","https://digilocker.gov.in/index.php#no-back");
                            startActivity(mIntent);
                            return true;

                        case R.id.noti:
                            startActivity( new Intent(Start.this, ficationoti.class));
                            return true;

                        case R.id.library:
                            startActivity( new Intent(Start.this, Brarili.class));

                            return true;
                    }
                    return false;
                }
            };



    // nigol
    public void createSignInIntent() {
        // [START auth_fui_create_intent]
        // Choose authentication providers

        List<AuthUI.IdpConfig> providers = Arrays.asList(
                new AuthUI.IdpConfig.EmailBuilder().build(),
                new AuthUI.IdpConfig.PhoneBuilder().build(),
                new AuthUI.IdpConfig.GoogleBuilder().build(),
                new AuthUI.IdpConfig.FacebookBuilder().build()
        );


        AuthMethodPickerLayout customLayout = new AuthMethodPickerLayout
                .Builder(R.layout.login)
                .setGoogleButtonId(R.id.google)
                .setEmailButtonId(R.id.emaillogin)
                .setFacebookButtonId(R.id.facebook)
                .setPhoneButtonId(R.id.phone)
                // ...
                //  .setTosAndPrivacyPolicyId(R.id.baz)
                .build();




        // Create and launch sign-in intent
        startActivityForResult(
                AuthUI.getInstance()
                        .createSignInIntentBuilder()
                        .setAuthMethodPickerLayout(customLayout)
                        .setAvailableProviders(providers)
                        .setLogo(R.drawable.ic_launcher_web)      // Set logo drawable
                        .setTheme(R.style.AppTheme)
                        .build(),
                RC_SIGN_IN);
        // [END auth_fui_create_intent]
    }

    // [START auth_fui_result]
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == RC_SIGN_IN) {
            IdpResponse response = IdpResponse.fromResultIntent(data);

            if (resultCode == RESULT_OK) {
                // Successfully signed in
                FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
                updateUI(user);
                Toast.makeText(Start.this,"You Succesfully Login",Toast.LENGTH_SHORT).show();




                // ...
            } else {
                // Sign in failed
                if (response == null) {
                    // User pressed back button
                    //  showSnackbar(R.string.sign_in_cancelled);
                    return;
                }

                if (response.getError().getErrorCode() == ErrorCodes.NO_NETWORK) {
                    Toast.makeText(Start.this,"No Internet Connection",Toast.LENGTH_SHORT).show();

                    // showSnackbar(R.string.no_internet_connection);
                    return;
                }

                //showSnackbar(R.string.unknown_error);
                Log.e(TAG, "Sign-in error: ", response.getError());
                // Sign in failed. If response is null the user canceled the
                // sign-in flow using the back button. Otherwise check
                // response.getError().getErrorCode() and handle the error.
                // ...
            }
        }
    }
    private void updateUI(FirebaseUser user) {

        String nam = null;
        String em;
        if (user != null) {
            li.setVisibility(View.GONE);
            re.setVisibility(View.VISIBLE);
            if(user.getPhoneNumber()!=null) {
                em=user.getPhoneNumber();
                t1.setText(em);
            }
            else {
                //  String imgurl = user.getPhotoUrl().toString();
                //  imageView.setImageURI(user.getPhotoUrl());
                //  Glide.with(this).load(imgurl).into(imageView);
                em=user.getEmail();
                nam=user.getDisplayName();
                t1.setText(em);
                t2.setText(nam);
                nam=nam+" ";
            }






            FileOutputStream out = null;

            try {
                out = openFileOutput("d", Context.MODE_PRIVATE);
                out.write(nam.getBytes());
                out = openFileOutput("f", Context.MODE_PRIVATE);
                out.write(em.getBytes());

            } catch (FileNotFoundException e) {
                // manage exception ...
            } catch (IOException e) {
                // manage exception ...
            } finally {
                if (out != null) {
                    try {
                        out.close(); }
                    catch (Exception exc) {
                        Toast.makeText(Start.this,"something went wrong ",Toast.LENGTH_SHORT).show();

                    }
                }
            }



















        }
        else {

        }
    }

    public   void Read()
    {
        li.setVisibility(View.GONE);
        re.setVisibility(View.VISIBLE);
        try {
            FileInputStream out = openFileInput("d");
            int read=-1;
            StringBuffer stringBuffer=new StringBuffer();
            while ((read=out.read())!=-1){
                stringBuffer.append((char) read);
            }

            String s1=stringBuffer.substring(0);
            //String s2=stringBuffer.substring(stringBuffer.indexOf(" ")+1);
            t2.setText(s1);
            //t1.setText(s2);


            FileInputStream out2 = openFileInput("f");
            int read2=-1;
            StringBuffer stringBuffer2=new StringBuffer();
            while ((read2=out2.read())!=-1){
                stringBuffer2.append((char) read2);
            }

            String s2=stringBuffer2.substring(0);
            t1.setText(s2);




        } catch (FileNotFoundException e) {
            // manage exception ...
        } catch (IOException e) {
            // manage exception ...
        }






    }

    public void mo13189p() {
        AlertDialog.Builder aVar = new  AlertDialog.Builder(this);
        aVar.setIcon((int) R.mipmap.ic_launcher);
        aVar.setTitle("Disclaimer (" + 192 + ")");
        aVar.setCancelable(false);
        aVar.setMessage((CharSequence) getString(R.string.disclaimer));
        aVar.setPositiveButton("OK", new C3297g());
        aVar.show();
    }

    class C3297g implements DialogInterface.OnClickListener {
        C3297g() {
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            SharedPreferences.Editor edit =f16265v.edit();
            edit.putBoolean("disclaimerRead", true);
            edit.commit();
            dialogInterface.cancel();
        }
    }








}
