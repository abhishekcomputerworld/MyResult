package com.board.exams.myresult.browserr;

import android.graphics.Bitmap;


public interface Webview_Interface {
    void url(String a);
    void url_img(Bitmap a);
    void progress(int progress);
    void forward(boolean enable);
    void backword(boolean enable);



}
