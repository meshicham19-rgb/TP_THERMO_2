package ma.uiz.thermo2;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;

/**
 * TP Thermo 2 — Pr Hicham MESBAH.
 * Dilatation thermique et pompe à chaleur. La simulation est dans app/src/main/assets/index.html.
 */
public class MainActivity extends Activity {

    private WebView web;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try {
            web = new WebView(this);
        } catch (Throwable t) {
            // WebView absent ou en cours de mise à jour (Android System WebView / Chrome)
            TextView tv = new TextView(this);
            tv.setPadding(48, 48, 48, 48);
            tv.setTextSize(18);
            tv.setText("Impossible d'ouvrir la simulation : le composant « Android System WebView » est absent ou en cours de mise à jour.\n\nMettez à jour « Android System WebView » et « Chrome » dans le Play Store, puis relancez TP Thermo 2.\n\nDétail : " + t);
            setContentView(tv);
            return;
        }
        setContentView(web);

        WebSettings s = web.getSettings();
        s.setJavaScriptEnabled(true);
        s.setDomStorageEnabled(true);            // réponses des comptes rendus
        s.setAllowFileAccess(true);              // lecture de file:///android_asset
        s.setAllowFileAccessFromFileURLs(true);  // dossier assets/js (three.js hors ligne)
        s.setCacheMode(WebSettings.LOAD_DEFAULT);
        s.setLoadWithOverviewMode(true);
        s.setUseWideViewPort(true);
        s.setMixedContentMode(WebSettings.MIXED_CONTENT_COMPATIBILITY_MODE);

        web.setWebViewClient(new WebViewClient());
        web.setWebChromeClient(new WebChromeClient());

        if (savedInstanceState != null) {
            web.restoreState(savedInstanceState);
        } else {
            web.loadUrl("file:///android_asset/index.html");
        }
    }

    @Override
    public void onBackPressed() {
        if (web != null && web.canGoBack()) web.goBack();
        else super.onBackPressed();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        if (web != null) web.saveState(outState);
    }

    @Override
    protected void onPause() { super.onPause(); if (web != null) web.onPause(); }

    @Override
    protected void onResume() { super.onResume(); if (web != null) web.onResume(); }

    @Override
    protected void onDestroy() {
        if (web != null) { web.destroy(); web = null; }
        super.onDestroy();
    }
}
