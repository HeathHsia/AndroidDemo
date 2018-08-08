package landscapedemo.heath.com.landscapedemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * @param view
     */
    public void clickItem (View view) {
        Log.d("hh",view.getTag().toString());
        switch (view.getTag().toString()) {
            case "全部车型" :
            {
                // WebView
                Intent intent = new Intent(MainActivity.this, WebActivity.class);
                startActivity(intent);
            }
                break;
            case "智能提车" :
            {
                Intent intent = new Intent(MainActivity.this, VideoActivity.class);
                startActivity(intent);
            }
                break;
            case "礼品优惠" :
            {

            }
                break;
            case "AR看车" :
            {

            }
                break;
            case "打印单据" :
            {

            }
                break;
            default:
            {

            }
                break;

        }
    }
}
