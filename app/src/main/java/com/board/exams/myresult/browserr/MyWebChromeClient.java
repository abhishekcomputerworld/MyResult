package com.board.exams.myresult.browserr;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.webkit.WebChromeClient;
import android.webkit.WebView;

import androidx.annotation.Nullable;


public class MyWebChromeClient extends WebChromeClient {
    Webview_Interface webview_interface;
    Context context;
    public MyWebChromeClient(Context context, Webview_Interface webview_interface) {
        this.context = context;
        this.webview_interface= webview_interface;
    }


    @Override
    public void onProgressChanged(WebView view, int newProgress) {
        super.onProgressChanged(view, newProgress);
        webview_interface.progress(newProgress);
    }
    @Override
    public void onReceivedTitle(WebView view, String title) {
        super.onReceivedTitle(view, title);
    }

    @Override
    public void onReceivedIcon(WebView view, Bitmap icon) {
        super.onReceivedIcon(view, icon);
        webview_interface.url_img(icon);
     }









    @Nullable
    @Override
    public Bitmap getDefaultVideoPoster() {
        return BitmapFactory.decodeResource(context.getResources(), 17301616);
    }
}
