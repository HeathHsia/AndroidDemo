package listview.heath.com.intentmqhandledemo;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;


public class MainActivity extends AppCompatActivity {

    @SuppressLint("HandlerLeak")
    private Handler myHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
//            super.handleMessage(msg);
            Log.d("---------","++++++");
            switch (msg.what){
                case 1:
                {
                    Log.d("+++++++++++","===========");
                }
                    break;
                default:
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void clickButton (View view) {
        Log.d("Click", "Click Log");
        // 新建子线程 run 执行子线程中的事情
        new Thread(new Runnable() {
            @Override
            public void run() {
                // 让主线程handle处理message
//             Handler myHandler = new Handler(Looper.getMainLooper());
             Message msg = new Message();
             msg.what = 1;
             myHandler.sendMessage(msg);
//             myHandler.post(new Runnable() {
//                    @Override
//                    public void run() {
//                        for (int i = 0; i < 100000; i++) {
//                            Log.e("note", "" + i);
//                        }
////                        ImageView img = (ImageView) findViewById(R.id.img);
////                        Bitmap imgBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.ic_launcher_background);
////                        img.setImageBitmap(imgBitmap);
//                        // 框架已经做了异步线程处理
//                       Glide.with(getBaseContext()).load("https://ss2.bdstatic.com/70cFvnSh_Q1YnxGkpoWK1HF6hhy/it/u=1421494343,3838991329&fm=23&gp=0.jpg").into((ImageView) findViewById(R.id.img));
//                    }
//                });
            }
        }).start();
    }
}
