package listview.heath.com.listview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    // 创建数据源
    private final static String[] strs = new String[] {"first", "second", "third", "forth", "fifth"
    };
    private ListView listView;
    private final static OkHttpClient client = new OkHttpClient();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_layout);
        // 绑定layout中的listView
        listView = (ListView) findViewById(R.id.list_view);

        ArrayList<HashMap<String, Object>> dataList = new ArrayList<HashMap<String, Object>>();
        for (int i = 0; i < 10; i++) {
            HashMap<String, Object> map = new HashMap<String, Object>();
            map.put("itemImg", R.drawable.ic_launcher_background);
            map.put("itemTitle", "第几" + i + "行");
            map.put("itemText", "This is " + i );
            dataList.add(map);
        }
        Log.e("item Data ArrList", dataList.toString());
        // 创建SimpleAdapter

        SimpleAdapter adapter = new SimpleAdapter(this, dataList, R.layout.item, new String[]{"itemImg", "itemTitle", "itemText"}, new int[] {R.id.itemImg, R.id.itemTitle, R.id.itemText});
        listView.setAdapter(adapter);

        // 设置listview adapter 适配器
        /***
         * 第二个参数：自定义一个layout，系统有默认的样式，如果有choice或者check选择器 需要设置setMode否则不显示
         */
//        listView.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_multiple_choice, strs));
        // 设置选择的Mode 否则不显示
//        listView.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
        configListView();
    }

    // 设置listView监听者，并该接口方法
    private void configListView () {
        listView.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        setTitle("你点击了" + i + " 行");
        requestDataList();
    }

    /**
     * request DataList
     */
    public void requestDataList () {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    excute();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    public void  excute () throws Exception {
        Request request = new Request.Builder().url("https://publicobject.com/helloworld.txt").build();
        try {
            Response response = client.newCall(request).execute();
            if (response.isSuccessful()) {
                Log.e("请求成功", "Success");
//                Log.e("Response Body is ", response.body().toString());
            }else {
                Log.e("请求失败", "Fail");
            }
        }catch (Exception e) {
            e.printStackTrace();
        }

    }
}


