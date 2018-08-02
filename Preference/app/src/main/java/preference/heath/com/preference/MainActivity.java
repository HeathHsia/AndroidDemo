package preference.heath.com.preference;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onStart() {
        super.onStart();

        // Uri 功能跳转
        Uri number = Uri.parse("tel:18501036904");
        Intent callIntent = new Intent(Intent.ACTION_DIAL, number);

    }
}
