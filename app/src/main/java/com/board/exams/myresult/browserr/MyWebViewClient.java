package com.board.exams.myresult.browserr;

import android.annotation.TargetApi;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.MailTo;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import android.webkit.MimeTypeMap;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.core.content.FileProvider;

import java.io.File;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;

public  class MyWebViewClient extends WebViewClient {
    Context context;
    private Context a;
    public static boolean f31972b;

    Webview_Interface webview_interface;
    private Map<String, Boolean> loadedUrls = new HashMap<>();
    @Override
    public void onReceivedError(WebView view, WebResourceRequest request, WebResourceError error) {
        super.onReceivedError(view, request, error);
    }

    public MyWebViewClient( Context c, Webview_Interface webview_interface) {
        this.context = c;
        this.a = c;
        this.webview_interface = webview_interface;
        AdBlocker.init(context);
    }

    // low qpi
    @Nullable
    @Override
    public WebResourceResponse shouldInterceptRequest(WebView view, String url) {
        // return super.shouldInterceptRequest(view, url);
        boolean ad;
        if (!loadedUrls.containsKey(url)) {
            ad = AdBlocker.isAd(url);
            loadedUrls.put(url, ad);
        } else {
            ad = loadedUrls.get(url);
        }

        if (ad && new SearchEngineModal(context).block_add()) {
            return AdBlocker.createEmptyResource();
        } else {
            return super.shouldInterceptRequest(view, url);
        }
    }
/*
    @Override
    public void onReceivedHttpAuthRequest(WebView webView, HttpAuthHandler httpAuthHandler, String str, String str2) {
        AlertDialog.Builder aVar = new AlertDialog.Builder (context);
        View inflate = LayoutInflater.from(context).inflate(R.layout.dialog_auth_request, null);
        EditText editText = (EditText) inflate.findViewById(R.id.auth_request_username_edittext);
        EditText editText2 = (EditText) inflate.findViewById(R.id.auth_request_password_edittext);
        ((TextView) inflate.findViewById(R.id.auth_request_realm_textview)).setText(context.getString(R.string.label_realm, new Object[]{str2}));
        aVar.setView(inflate);
        aVar.setTitle((int)R.string.title_sign_in);
        aVar.setCancelable(true);
        aVar.setPositiveButton((int)R.string.title_sign_in, (DialogInterface.OnClickListener) new C10467z(this, editText, editText2, httpAuthHandler));
        aVar.setNegativeButton(R.string.action_cancel, (DialogInterface.OnClickListener) new C10466y(this, httpAuthHandler));
        AlertDialog a = aVar.create();
        a.show();
    }
    */

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Nullable
    @Override
    public WebResourceResponse shouldInterceptRequest(WebView view, WebResourceRequest request) {
        //   return super.shouldInterceptRequest(view, request);
        String url = request.getUrl().toString();
        boolean ad;
        if (!loadedUrls.containsKey(url)) {
            ad = AdBlocker.isAd(url);
            loadedUrls.put(url, ad);
        } else {
            ad = loadedUrls.get(url);
        }
        if (ad && new SearchEngineModal(context).block_add()) {
            return AdBlocker.createEmptyResource();
        } else {
            return super.shouldInterceptRequest(view, request);
        }

  /*      return ad && new SearchEngineModal(context).block_add() ? AdBlocker.createEmptyResource() :
                super.shouldInterceptRequest(view, request);*/
    }


    @TargetApi(21)
    public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
        String url = request.getUrl().toString();
        return ab(view, url) || super.shouldOverrideUrlLoading(view, request);
    }

    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        return ab(webView, str) || super.shouldOverrideUrlLoading(webView, str);
    }

    private boolean ab(WebView webView, String str) {
        if (str.startsWith("http://") || str.startsWith("https://")) {
           // Toast.makeText(context, "http", Toast.LENGTH_SHORT).show();
            return false;
        } Intent intent;
        if (str.startsWith("mailto:")) {
          //  Toast.makeText(context, "mailto", Toast.LENGTH_SHORT).show();
            MailTo parse = MailTo.parse(str);
           context.startActivity(m10402a(parse.getTo(), parse.getSubject(), parse.getBody(), parse.getCc()));
            webView.reload();
            return true;
        }
        String str2 = "market://";
        if (str.startsWith("intent://") || str.startsWith(str2) || str.startsWith("tel:")) {
           // Toast.makeText(context, "intent", Toast.LENGTH_SHORT).show();
            try {
                intent = Intent.parseUri(str, Intent.URI_ANDROID_APP_SCHEME);
            } catch (URISyntaxException unused) {
                intent = null;
            }
            if (intent != null) {
                intent.addCategory("android.intent.category.BROWSABLE");
                intent.setComponent(null);
                intent.setSelector(null);
                try {
                    this.context.startActivity(intent);
                   /* if (str.startsWith(str2)) {
                        EventBus.getDefault().post((Object)  new C10513yY());
                    }*/
                } catch (ActivityNotFoundException unused2) {
                    Log.e("LightningWebClient", "ActivityNotFoundException");
                }
                return true;
            }
        } else {
          //  Toast.makeText(context, "fille", Toast.LENGTH_SHORT).show();
            String str3 = "file://";
            String str4 = "android.intent.action.VIEW";
            if (str.startsWith(str3)) {
                File file = new File(str.replace(str3, ""));
                if (file.exists()) {
                    String mimeTypeFromExtension = MimeTypeMap.getSingleton()
                            .getMimeTypeFromExtension(m10418d(file.toString()));
                    try {
                        Intent intent2 = new Intent();
                        intent2.setAction(str4);
                        intent2.setFlags(Intent.FLAG_ACTIVITY_LAUNCH_ADJACENT);
                        intent2.setDataAndType(FileProvider.getUriForFile(this.context, "video.downloader.videodownloader.fileprovider", file), mimeTypeFromExtension);
                        this.context.startActivity(intent2);
                    } catch (Exception unused3) {
                        System.out.println("LightningWebClient: cannot open downloaded file");
                    }
                    return true;
                }
            } else if (str.startsWith("baidubox")) {
               // Toast.makeText(context, "baidbox", Toast.LENGTH_SHORT).show();
                return true;
            } else {
                if (!TextUtils.isEmpty(str) && !str.startsWith("http")) {
                  //  Toast.makeText(context, "///", Toast.LENGTH_SHORT).show();
                //    Toast.makeText(context, "eee////", Toast.LENGTH_SHORT).show();
                    this.context.startActivity(new Intent(str4, Uri.parse(str)));
                    try {
                        int indexOf = str.indexOf("://");
                        if (indexOf > 0) {
                            if (m10242a((Context) this.context, str.substring(0, indexOf))) {
                                this.context.startActivity(new Intent(str4, Uri.parse(str)));
                               // Toast.makeText(context, "d////", Toast.LENGTH_SHORT).show();
                                return true;
                            }
                        }
                    } catch (Exception e) {
                      //  Toast.makeText(context, "eee////", Toast.LENGTH_SHORT).show();
                        this.context.startActivity(new Intent(str4, Uri.parse(str)));
                    }
                }
            }
        }
        return false;
    }
    public static boolean m10242a(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            context.getPackageManager().getApplicationInfo(str, PackageManager.GET_META_DATA);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
  /*  private boolean m40462a(WebView webView, String str) {
        StringBuilder sb = new StringBuilder();
        sb.append("shouldOverrideLoading : ");
        sb.append(webView.getUrl());
        C0933SL.m3828a(sb.toString(), new Object[0]);
        C8649BN a = C8649BN.m34681a();
        FragmentActivity fragmentActivity = context;
        StringBuilder sb2 = new StringBuilder();
        sb2.append(webView.getUrl());
        sb2.append("");
        a.mo22068a((Context) fragmentActivity, sb2.toString());
        if (webView.getTag() != null) {
            String str2 = "pop_up_ads";
            if (webView.getTag().equals(str2)) {
                webView.setTag(null);
                C7575fb.m30233a((Context) context, str2, C2365cb.m10406a(str));
            }
        }
        Map n = this.f31974d.mo26818n();
        if (this.f31974d.mo26828x()) {
            return m40463a(webView, str, n);
        }
        if (str.startsWith("about:")) {
            return m40463a(webView, str, n);
        }
        if (!m40466b(str, webView) && !m40464a(str, webView)) {
            return m40463a(webView, str, n);
        }
        return true;
    }*/


    @Override
    public void onPageFinished(WebView view, String url) {
        if (view.isShown()) {
        webview_interface.forward(view.canGoForward());
        webview_interface.backword(view.canGoBack());
        }
        super.onPageFinished(view, url);

    }

    @Override
    public void onPageStarted(WebView view, String url, Bitmap favicon) {
        super.onPageStarted(view, url, favicon);
        if (view.isShown()) {
        webview_interface.forward(view.canGoForward());
        webview_interface.backword(view.canGoBack());
        }
        webview_interface.url(url);


    }
    public static Intent m10402a(String str, String str2, String str3, String str4) {
        Intent intent = new Intent("android.intent.action.SEND");
        intent.putExtra("android.intent.extra.EMAIL", new String[]{str});
        intent.putExtra("android.intent.extra.TEXT", str3);
        intent.putExtra("android.intent.extra.SUBJECT", str2);
        intent.putExtra("android.intent.extra.CC", str4);
        intent.setType("message/rfc822");
        return intent;
    }

    public static String m10418d(String str) {
        int lastIndexOf = str.lastIndexOf(46) + 1;
        if (lastIndexOf <= 0 || str.length() <= lastIndexOf) {
            return null;
        }
        return str.substring(lastIndexOf, str.length());
    }
  /*  @Override
    public void onFormResubmission(WebView view, Message dontResend, Message resend) {
        AlertDialog.Builder aVar = new AlertDialog.Builder (context);
        aVar.setTitle((CharSequence) context.getString(R.string.title_form_resubmission));
        aVar.setMessage((CharSequence)context.getString(R.string.message_form_resubmission));
        aVar.setCancelable(true);
        aVar.setPositiveButton((CharSequence) context.getString(R.string.action_yes), (DialogInterface.OnClickListener) new C10431D(this, resend));
        aVar.setNegativeButton((CharSequence) context.getString(R.string.action_no), (DialogInterface.OnClickListener) new C10430C(this, dontResend));
        AlertDialog a = aVar.create();
        a.show();
        C9810fW.m38601a(context, a); }
*/
 /*   @Override
    public void onLoadResource(WebView webView, String str) {
//        Logger.e("onLoadResource one","ddddcccc");
        if (!C0122Ca.m552a().mo374a(this.context, webView.getUrl()) && !C0122Ca.m552a().mo376b(this.context, str)) {
            Logger.e("onLoadResource two","ddddcccc");
            Webview sVar = this.webview;
            if (sVar != null) {
                super.onLoadResource(webView, str);
            }
            if (webView.getContext() != null) {
                String str2 = "com.abhishek.downloader";
                if (CoreService.m29543c(webView.getContext(), str) && C0721Oa.m2966c(webView.getContext(), str2)) {
                    String x = C0721Oa.m2983x(webView.getContext());
                    if (TextUtils.isEmpty(x)) {
                        x = C8223sL.m32790i(webView.getContext());
                    }
                    webView.loadUrl(x);
                } else if (CoreService.m29566u(webView.getContext(), str) && C0721Oa.m2970e(webView.getContext(), str2)) {
                    String G = C0721Oa.m2941G(webView.getContext());
                    if (TextUtils.isEmpty(G)) {
                        G = C8223sL.m32765A(webView.getContext());
                    }
                    webView.loadUrl(G);
                } else if (CoreService.m29545d(webView.getContext(), str) && C0721Oa.m2968d(webView.getContext(), str2)) {
                    String A = C0721Oa.m2935A(webView.getContext());
                    if (TextUtils.isEmpty(A)) {
                        A = C8223sL.m32792k(webView.getContext());
                    }
                    webView.loadUrl(A);
                }
            }
        }
    }*/

}