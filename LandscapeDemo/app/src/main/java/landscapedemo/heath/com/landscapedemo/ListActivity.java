package landscapedemo.heath.com.landscapedemo;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;

import java.io.File;

public class ListActivity extends BaseActivity {

    @TargetApi(Build.VERSION_CODES.GINGERBREAD)
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        File path = new File("");
        // 向下兼容
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.GINGERBREAD ) {
            path.getTotalSpace();
        }else {
            path.getTotalSpace();
        }
    }
}
