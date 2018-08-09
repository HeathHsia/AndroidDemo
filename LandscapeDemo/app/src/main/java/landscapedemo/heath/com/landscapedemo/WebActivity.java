package landscapedemo.heath.com.landscapedemo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class WebActivity extends BaseActivity {

    private WebView webView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);
        webView = (WebView)findViewById(R.id.webV);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().supportZoom();
        webView.getSettings().setBuiltInZoomControls(true);
        webView.getSettings().setUseWideViewPort(true);

        // 如果不设置WebViewClient 就会跳转到浏览器
        webView.setWebViewClient(new WebViewClient() {
            // 列表项目
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                return super.shouldOverrideUrlLoading(view, request);
            }
        });
        webView.loadUrl("https://www.baidu.com");
    }
}
