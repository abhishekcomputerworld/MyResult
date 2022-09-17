package com.board.exams.myresult.browserr;

import android.content.Context;
import android.content.SharedPreferences;


import com.board.exams.myresult.R;

import okhttp3.HttpUrl;

public class SearchEngineModal {
    Context context;
    SharedPreferences pref,pref2 ;
    public SearchEngineModal(Context context) {
        this.context = context;
        get_Browser_type();
      //  block_add();
    }
  public   boolean block_add(){
        pref2 = context.getSharedPreferences("blok_add", 0); // 0 - for private mode
        return    pref2.getBoolean("ads", true); // getting Integer
    }
    public   int Screen_shor_no(){
        pref2 = context.getSharedPreferences("shot_no", 0); // 0 - for private mode
        return    pref2.getInt("no", 1); // getting Integer
    }
    public   boolean enable_Snap_Shot(){
        SharedPreferences pref = context.getSharedPreferences("Snap_Shot", 0); // 0 - for private mode
        return    pref.getBoolean("snap_sho", true); // getting Integer
    }
    public void start_block_add(boolean b){
        SharedPreferences pref = context.getSharedPreferences("blok_add", 0); // 0 - for private mode
        SharedPreferences.Editor editor = pref.edit();
        editor.putBoolean("ads", b); // Storing boolean - true/false
        editor.commit();
    }
    public void save_shot_no(int b){
        SharedPreferences pref = context.getSharedPreferences("shot_no", 0); // 0 - for private mode
        SharedPreferences.Editor editor = pref.edit();
        editor.putInt("no", b); // Storing boolean - true/false
        editor.commit();
    }
    public void start_Take_Snap_Shot(boolean b){
        SharedPreferences pref = context.getSharedPreferences("Snap_Shot", 0); // 0 - for private mode
        SharedPreferences.Editor editor = pref.edit();
        editor.putBoolean("snap_sho", b); // Storing boolean - true/false
        editor.commit();
    }
    public  int get_Browser_type(){
        SharedPreferences pref = context.getSharedPreferences("MyPref", 0); // 0 - for private mode
        return    pref.getInt("key_name", 0); // getting Integer
    }

    public  void set_Browser_type(int i){
        SharedPreferences pref = context.getSharedPreferences("MyPref", 0); // 0 - for private mode

        SharedPreferences.Editor editor = pref.edit();
        editor.putInt("key_name", i); // Storing integer
        editor.commit();
    }
    public int  SearchEngine() {
        //pref = context.getSharedPreferences("MyPref", 0); // 0 - for private mode
        //  this.searchEngineType= pref.getInt("key_name", 0); // getting Integer
        switch (get_Browser_type()) {
            case 0:
                return R.mipmap.google;

            case 1:
                return R.mipmap.google;

            case 2:
                return R.mipmap.google;

            case 3:
                return R.mipmap.google;

            case 4:
                return R.mipmap.google;

            case 5:
                return R.mipmap.google;

        }


        return R.mipmap.google;
    }
    public String SearchEngine_name() {
        //pref = context.getSharedPreferences("MyPref", 0); // 0 - for private mode
        //  this.searchEngineType= pref.getInt("key_name", 0); // getting Integer
        switch (get_Browser_type()) {
            case 0:
                return "Google";

            case 1:
                return "Bing";

            case 2:
                return "Yandex";

            case 3:
                return "DuckDuck Go";

            case 4:
                return "Baidu";

            case 5:
                return "Yahoo";

        }


        return "Google";
    }
    public HttpUrl a(Context context, String url) {

        switch (this.get_Browser_type()) {
            case 0:
                return HttpUrl.parse("https://www.google.com/search").newBuilder().addQueryParameter("q", url).addQueryParameter("sourceid", "chrome-mobile")
                        // .addQueryParameter("hl", d.abc(context))
                        .build();
            case 1:
                return HttpUrl.parse("https://www.bing.com/search").newBuilder().addQueryParameter("q", url)
                        //.addQueryParameter("setlang", d.abc(context))
                        .build();
            case 2:
                return HttpUrl.parse("https://yandex.com/").newBuilder().addQueryParameter("q", url).build();
            case 3:
                return HttpUrl.parse("https://duckduckgo.com").newBuilder().addQueryParameter("q", url).build();
            case 4:
                return HttpUrl.parse("http://www.baidu.com/s").newBuilder().addQueryParameter("wd", url).build();
            case 5:
                return HttpUrl.parse("https://search.yahoo.com/search").newBuilder().addQueryParameter("p", url)
                        //.addQueryParameter("vl", "lang_" + d.abc(context))
                        .build();  default:
                return null;
        }
    }




}
