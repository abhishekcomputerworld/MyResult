package com.board.exams.myresult.browserr;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.ListPopupWindow;
import androidx.core.app.ActivityCompat;

import android.app.Activity;
import android.app.DownloadManager;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.util.Log;
import android.view.Display;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.webkit.CookieManager;
import android.webkit.DownloadListener;
import android.webkit.URLUtil;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.board.exams.myresult.Brarili;
import com.board.exams.myresult.R;
import com.board.exams.myresult.Start;
import com.board.exams.myresult.add.A;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import static com.board.exams.myresult.browserr.permission.m38910a;

public class Browser_Main extends AppCompatActivity implements Webview_Interface, View.OnClickListener,enable_sc_shot {
WebView webView;
    ListPopupWindow listPopupWindow;
    Webview_Interface webview_interface;
    private static final int sdk_version = Build.VERSION.SDK_INT;
    boolean ingonite_value= false;
    ImageView backword,forward,download,home,browserimage,refresh2,popup,cut,refresh;
    ProgressBar progressBar;
    TextView urlset;
    FloatingActionButton fab_download_buton,fabs;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_browser);
        this.webview_interface= (Webview_Interface)this;
        urlset=(TextView)findViewById(R.id.urlset);
        progressBar=(ProgressBar) findViewById(R.id.browserprogressbar);
        backword=(ImageView) findViewById(R.id.backword);
        home=(ImageView) findViewById(R.id.home);
        forward=(ImageView) findViewById(R.id.forword);
        cut=(ImageView) findViewById(R.id.cut);
        refresh=(ImageView) findViewById(R.id.refresh_);
        refresh2=(ImageView) findViewById(R.id.refresh);
        popup=(ImageView) findViewById(R.id.popup);
        browserimage=(ImageView) findViewById(R.id.browserimage);
        download=(ImageView) findViewById(R.id.download);
        fab_download_buton=(FloatingActionButton) findViewById(R.id.fab_download_buton);

        backword.setOnClickListener(this);
        forward.setOnClickListener(this);
        home.setOnClickListener(this);
        cut.setOnClickListener(this);
        urlset.setOnClickListener(this);
        browserimage.setOnClickListener(this);
        popup.setOnClickListener(this);
        refresh.setOnClickListener(this);
        refresh2.setOnClickListener(this);
        download.setOnClickListener(this);
        fab_download_buton.setOnClickListener(this);
        fabs = findViewById(R.id.fabs);
        fabs.setOnClickListener(this);
        enable_shot();

        this.webView = (WebView) findViewById(R.id.webview);
        if (Build.VERSION.SDK_INT > 16) {
            webView.setId(View.generateViewId());
        }
        this.webView.setDrawingCacheBackgroundColor(-1);
        this.webView.setFocusableInTouchMode(true);
        this.webView.setFocusable(true);
        this.webView.setDrawingCacheEnabled(false);
        this.webView.setWillNotCacheDrawing(true);
        if (Build.VERSION.SDK_INT <= 22) {
            this.webView.setAnimationCacheEnabled(false);
            this.webView.setAlwaysDrawnWithCacheEnabled(false);
        }
        this.webView.setBackgroundColor(-1);
        this.webView.setScrollbarFadingEnabled(true);
        this.webView.setSaveEnabled(true);
        this.webView.setNetworkAvailable(true);
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webView.setWebChromeClient(new MyWebChromeClient(this,webview_interface));
        webView.setWebViewClient(new MyWebViewClient(this,webview_interface));
        webView.setDownloadListener(new DownloadListener() {
            @Override
            public void onDownloadStart(String url, String userAgent, String contentDisposition, String mimetype, long contentLength) {
                if(m38910a(Browser_Main.this)) {
                     downloadDialog( url,  userAgent,  contentDisposition,  mimetype);
                 //   start_Download(url);

                }
                else{

                }
            }
        });
        setting();
        Log.e("abhishek_mainr","__1"+String.valueOf(getIntent().getStringExtra("url")!=null));
        if(getIntent().getStringExtra("url")!=null){
            Log.e("abhishek_mainr","__1"+String.valueOf(getIntent().getStringExtra("url")));
          //  Toast.makeText(this, getIntent().getStringExtra("url")+"fvdzc", Toast.LENGTH_SHORT).show();
            urlset.setText(getIntent().getStringExtra("url"));
        webView.loadUrl(getIntent().getStringExtra("url"));}
        else{
          //  Toast.makeText(this, "error", Toast.LENGTH_SHORT).show();
            webView.loadUrl("https://www.google.co.in/");}

    }



    public void downloadDialog(final String url, final String userAgent, String contentDisposition, String mimetype)
    {
        final PopupWindow mPopupWindow;

        LayoutInflater inflater = (LayoutInflater) this.getSystemService(LAYOUT_INFLATER_SERVICE);
        View customView = inflater.inflate(R.layout.during_download,null);
        mPopupWindow = new PopupWindow(customView, ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        mPopupWindow.setOutsideTouchable(false);
        mPopupWindow.showAtLocation(view(), Gravity.CENTER,0,0);
        mPopupWindow.setFocusable(true);
        View container= (View) mPopupWindow.getContentView().getParent();

        WindowManager wm = (WindowManager) this.getSystemService(this.WINDOW_SERVICE);
        WindowManager.LayoutParams p = (WindowManager.LayoutParams) container.getLayoutParams();
        p.flags = WindowManager.LayoutParams.FLAG_DIM_BEHIND;
        p.dimAmount = 0.3f;
        wm.updateViewLayout(container, p);

 //       final ImageView file_img= customView.findViewById(R.id.file_img);
        final EditText file_name= customView.findViewById(R.id.file_name);
        final TextView location= customView.findViewById(R.id.location);
        TextView cancel= customView.findViewById(R.id.cancel);
        TextView download= customView.findViewById(R.id.download);
        LinearLayout locaton_click= customView.findViewById(R.id.locaton_click);

        final String filename = URLUtil.guessFileName(url,contentDisposition,mimetype);
      //  file_img.setVisibility(View.GONE);
        file_name.setText(filename);
        File state = Environment.getExternalStoragePublicDirectory("My Result");

       // location.setText(state+filename);
        location.setText("Internal Storage/"+"My Result");
        locaton_click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ///   FragmentManager abc=this.getSupportFragmentManager();
                // Browser_Tab fragment = new Browser_Tab();
                //getSupportFragmentManager().beginTransaction().replace(R.id.framehole,fragment,"location").addToBackStack(null).commit();

            }
        });
        download.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                DownloadManager.Request request = new DownloadManager.Request(Uri.parse(url));
                //cookie
                String cookie= CookieManager.getInstance().getCookie(url);
                //Add cookie and User-Agent to request
                request.addRequestHeader("Cookie",cookie);
                request.addRequestHeader("User-Agent",userAgent);
                //file scanned by MediaScannar
                request.allowScanningByMediaScanner();
                //Download is visible and its progress, after completion too.
                request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
                //DownloadManager created
                DownloadManager downloadManager=(DownloadManager)getSystemService(DOWNLOAD_SERVICE);
                //Saving files in Download folder
                //request.setDestinationInExternalFilesDir(context,"abababab",filename);
                request.setDestinationInExternalPublicDir("My Result", String.valueOf(file_name.getText()));
                //download enqued
                downloadManager.enqueue(request);
                mPopupWindow.dismiss();
            }
        });
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPopupWindow.dismiss();

            }
        });
        //getting filename from url.
        //alertdialog
        /**   AlertDialog.Builder builder=new AlertDialog.Builder(context);
         //title of alertdialog
         builder.setTitle("Download");
         //message of alertdialog
         builder.setMessage("Do you want to save " +filename);
         //if Yes button clicks.
         builder.setPositiveButton("Yes", new DialogInterface.OnClickListener()
         {
         @Override
         public void onClick(DialogInterface dialog, int which)
         {
         //DownloadManager.Request created with url.

         }
         });
         builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialog, int which)
        {
        //cancel the dialog if Cancel clicks
        dialog.cancel();
        mPopupWindow.dismiss();
        }

        });
         //alertdialog shows.
         builder.create().show();

         }**/
    }
    public WebView view() {
        return this.webView;
    }
    private void setting() {
        if (this.webView != null) {
            WebSettings settings = this.webView.getSettings();
            if (sdk_version < 18) {
                settings.setAppCacheMaxSize(Long.MAX_VALUE);
            }
            if (sdk_version < 17) {
                settings.setEnableSmoothTransition(true);
            }
            if (sdk_version > 16) {
                settings.setMediaPlaybackRequiresUserGesture(true);
            }
            if (sdk_version >= 21&&  !this.ingonite_value) {
                settings.setMixedContentMode(2);
            } else if (sdk_version >= 21) {
                settings.setMixedContentMode(1);
            }
            if (this.ingonite_value) {
                settings.setDomStorageEnabled(false);
                settings.setAppCacheEnabled(false);
                settings.setDatabaseEnabled(false);
                settings.setCacheMode(WebSettings.LOAD_NO_CACHE);
            } else {
                settings.setDomStorageEnabled(true);
                settings.setAppCacheEnabled(true);
                settings.setCacheMode(WebSettings.LOAD_DEFAULT);
                settings.setDatabaseEnabled(true);
                settings.setPluginState(WebSettings.PluginState.ON);
            }
            settings.setSupportZoom(true);
            settings.setBuiltInZoomControls(true);
            settings.setDisplayZoomControls(false);
            settings.setAllowContentAccess(true);
            settings.setAllowFileAccess(true);
            if (sdk_version >= 16) {
                settings.setAllowFileAccessFromFileURLs(false);
                settings.setAllowUniversalAccessFromFileURLs(false);
            }
            settings.setJavaScriptEnabled(true);
            settings.setJavaScriptCanOpenWindowsAutomatically(true);
            if (sdk_version >= 21 && !this.ingonite_value) {
                CookieManager.getInstance().setAcceptThirdPartyCookies(this.webView, true);
                settings.setMixedContentMode(2);
            } else if (sdk_version >= 21) {
                settings.setMixedContentMode(1);
            }
        }
    }
    @Override
    public void progress(int progress) {
        boolean isLoading;
        if (progress < 100) {
            isLoading = true;
            progressBar.setProgress(progress);
            cut.setVisibility(View.VISIBLE);
            refresh.setVisibility(View.GONE);
        } else {
            cut.setVisibility(View.GONE);
            refresh.setVisibility(View.VISIBLE);
            isLoading = false;
        }
        if (isLoading) {
            progressBar.setProgress(progress);
            a(true);
        } else {
            a(false);

        }
    }

    public void a(boolean visible) {
        int i = View.INVISIBLE;
        if (!visible || this.progressBar.getVisibility() !=  View.VISIBLE) {
            if (visible || this.progressBar.getVisibility() != View.INVISIBLE) {
                ProgressBar progressBar = this.progressBar;
                if (visible) {
                    i =  View.VISIBLE;
                }
                progressBar.setVisibility(i);
            }
        }
    }
    public void forward(boolean enabled) {
        if (view()!= null) {
            if (enabled) {
                forward.setAlpha(1.0f);
            } else {
                forward.setAlpha(0.3f);
            }
            forward.setEnabled(enabled);
        }
    }

    public void backword(boolean enabled) {
        if (view()!= null) {
            if (enabled) {
                backword.setAlpha(1.0f);
            } else {
                backword.setAlpha(0.3f);
            }
            backword.setEnabled(enabled);
        }
    }

    @Override
    public void url(String url) {
        if( url == null || url.isEmpty()) {
            urlset.setText("Untitled");
        }
        else{
            urlset.setText(url);
        }

    }

    @Override
    public void url_img(Bitmap a) {
        browserimage.setImageBitmap(a);
    }
    public void forward(){
        if (webView.canGoForward()) {
            webView.goForward();        }

    }
    public void backword(){
        if (webView.canGoBack()) {
            webView.goBack();
        } else {
        //    brow.setVisibility(View.VISIBLE);

            super.onBackPressed();
        }
    }
    public void home(){
        Intent intent=new Intent(this, Start.class);
        startActivity(intent);
    }
    public void cut(){
        webView.stopLoading();
        super.onBackPressed();
    }
    private void popup(View view) {

        listPopupWindow = new ListPopupWindow(this);
        ArrayList<String> options = new ArrayList();

        if (view()!=null) {
            options.add("Share");
        }
        options.add("Take Snap_Shot");
        options.add("Block Ads on Web");
        Display display = ((WindowManager) getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay();

        listPopupWindow.setAdapter(new PopupAdapter(this,options,this));
        listPopupWindow.setHeight(-2);
        listPopupWindow.setWidth((int) (display.getWidth()/(1.5)));

        listPopupWindow.setModal(true);

        listPopupWindow.setAnchorView(view);

        listPopupWindow.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                  String selectedItem = (String) parent.getItemAtPosition(position);
                    if(selectedItem.equals("Share")){
                   share(Browser_Main.this,webView.getUrl());
                }
                if(selectedItem.equals("Block Ads on Web")){
                    //Toast.makeText(Browser_Main.this, "hello", Toast.LENGTH_SHORT).show();
                }

            }

        });
        listPopupWindow.show();

    }
    public static  void share(Context a, String str) {
        Intent intent = new Intent();
        intent.setAction("android.intent.action.SEND");
        intent.putExtra("android.intent.extra.TEXT", str);
        intent.setType("text/plain");
        try {
            a.startActivity(Intent.createChooser(intent, a.getString(R.string.ot)));
        } catch (ActivityNotFoundException e) {
            e.printStackTrace();
            Toast.makeText(a, R.string.bi, Toast.LENGTH_SHORT).show();
        }
    }
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.forword:
                forward();
                break;
            case R.id.backword:
                backword();
                break;
            case R.id.home:
                home();
                break;

            case R.id.cut:
                cut();
                break;
            case R.id.popup:
                popup(view);
                break;
            case R.id.refresh:
                webView.reload();
                break;
            case R.id.download:
                download();
                break;
            case R.id.fab_download_buton:
               if( permission.m38910a(this)){
                take_snapshot();}
                break;
            case R.id.fabs:
                show_screenshot();
                break;

        }


    }
    private void show_screenshot() {
        download();
    }
    private void take_snapshot() {
        if(fabs.getVisibility()==View.GONE){
            Bitmap b = A.takescreenshotOfRootView(webView);
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
                    Toast.makeText(Browser_Main.this, "Scrren shot save in"+Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES)+"and Library of app", Toast.LENGTH_LONG).show();

                }
            }, 600);
        }
    }
    public void storeScreenshot(Bitmap bitmap) {

       // File file=getExternalFilesDir(Environment.DIRECTORY_PICTURES);
        File file=Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);
     //   File file=Environment.getExternalStorageDirectory();
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
            new SearchEngineModal(this).save_shot_no(new SearchEngineModal(this).Screen_shor_no()+1);
        } catch (FileNotFoundException e) {
            // manage exception ...
        } catch (IOException e) {
            // manage exception ...
        } finally {
            if (out != null) {
                try {
                    out.close(); }
                catch (Exception exc) {
                    Toast.makeText(Browser_Main.this,"something went wrong ",Toast.LENGTH_SHORT).show();

                }
            }
        }
    }

    public boolean isExternalStorageWritable() {
        String state = Environment.getExternalStorageState();
        if (Environment.MEDIA_MOUNTED.equals(state)) {
            return true;
        }
        return false;
    }
    private void download() {
        Intent intent=new Intent(this, Brarili.class);
        startActivity(intent);
       /* framehole.setVisibility(View.VISIBLE);
        Webview_Download fragment = new Webview_Download();
        getSupportFragmentManager().beginTransaction().replace(R.id.framehole,fragment,"down").addToBackStack(null).commit();
        brow.setVisibility(View.GONE);

*/

    }

    private void open_permission_setting() {
        final AlertDialog a = new AlertDialog.Builder(this).create();
        View inflate = LayoutInflater.from(this).inflate(R.layout.open_permission_setting, null);
        inflate.findViewById(R.id.iv_close).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                a.dismiss();
            }
        });
        inflate.findViewById(R.id.tv_update_settings).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                a.dismiss();
                try {
                    StringBuilder sb = new StringBuilder();
                    sb.append("package:");
                    sb.append(getPackageName());
                    startActivity(new Intent("android.settings.APPLICATION_DETAILS_SETTINGS", Uri.parse(sb.toString())));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        a.setView(inflate);
        a.show();
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {

        if (requestCode != 100) {
            super.onRequestPermissionsResult(requestCode, permissions, grantResults);
            return;
        }
        if (grantResults.length <= 0 || grantResults[0] != 0) {
            if (! ActivityCompat.shouldShowRequestPermissionRationale((Activity) this, "android.permission.WRITE_EXTERNAL_STORAGE")) {
                open_permission_setting();
            } else {
                permission.m38909a(this);
            }
        }
        }

    @Override
    public void enable_shot() {
        if( new SearchEngineModal(this).enable_Snap_Shot()){
            fab_download_buton.setVisibility(View.VISIBLE);
        }
        else{
            fab_download_buton.setVisibility(View.GONE);

        }
    }
}