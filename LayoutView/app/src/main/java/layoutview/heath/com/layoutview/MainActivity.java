package layoutview.heath.com.layoutview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Integer number = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void clickItem (View view) {
        Button button = (Button)view;
        String clickText = button.getText().toString();
        TextView textView = (TextView) findViewById(R.id.textView);
        textView.setText(clickText);
    }
}
