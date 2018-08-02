package preference.heath.com.preference;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private final static String TAG = "HHHHHHHHH";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Context context = this.getApplicationContext();
        Intent intent = getIntent();
        context.startService(intent);
        context.stopService(intent);
        Log.e(TAG, "onCreate========");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.e(TAG, "onStar========");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.e(TAG, "onRestart======");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e(TAG, "onResume========");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.e(TAG, "onPause======");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.e(TAG, "onStop=======");
    }

    public void sendMessage (View view) {
        Button button = (Button) view;
        Log.e("MainActivity", button.getText().toString());
    }
}
