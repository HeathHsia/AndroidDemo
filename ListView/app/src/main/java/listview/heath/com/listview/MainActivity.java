package listview.heath.com.listview;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.bumptech.glide.Glide;

import org.json.JSONArray;
import org.json.JSONObject;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    // 创建数据源
    private ListView listView;
    private final static OkHttpClient client = new OkHttpClient();
    private ArrayList<Hashtable<String, Object>> dataArr = new ArrayList<Hashtable<String, Object>>();

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
            dataList.add(map);
        }
        Log.e("item Data ArrList", dataList.toString());
        // 创建SimpleAdapter

        SimpleAdapter adapter = new SimpleAdapter(this, dataList, R.layout.item, new String[]{"itemImg", "itemTitle"}, new int[] {R.id.itemImg, R.id.itemTitle});
        listView.setAdapter(adapter);

        // 设置listView adapter 适配器
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
        requestDataList();
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        setTitle("你点击了" + i + " 行");
    }

    /**
     * request DataList
     */
    public void requestDataList () {
        // 开启线程 做网络请求
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    reloadData();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    public void  reloadData () throws IOException {
        Request request = new Request.Builder().url("").build();
        try {
            Response response = client.newCall(request).execute();
            if (response.isSuccessful()) {
                String resultJSONStr = response.body().string();
                JSONObject responseObj = new JSONObject(resultJSONStr);
                JSONObject resultObj = responseObj.getJSONObject("result");
                JSONArray brandList = resultObj.getJSONArray("brandlist");
                System.out.print(brandList);
                for (int i = 0; i < brandList.length(); i ++) {
                    JSONObject brand = (JSONObject) brandList.get(i);
                    JSONArray brandArr = brand.getJSONArray("list");
                    for (int j = 0; j < brandArr.length(); j++) {
                        JSONObject tempObj = (JSONObject) brandArr.get(j);
                        // 只保留title和图片
                        Hashtable<String, Object> hash = new Hashtable<String, Object>();
                        hash.put("itemTitle", tempObj.get("name"));
                        hash.put("itemImg", tempObj.get("imgurl"));
                        dataArr.add(hash);
                    }
                }

                listView.post(new Runnable() {
                    @Override
                    public void run() {
//                        SimpleAdapter adapter = new SimpleAdapter(this, dataArr, R.layout.item, new String[]{"itemImg", "itemTitle"}, new int[] {R.id.itemImg, R.id.itemTitle});
//                        listView.setAdapter(adapter);
                    }
                });
                // 主线程更新UI
//                runOnUiThread(new Runnable() {
//                    @Override
//                    public void run() {
//
//                    }
//                });
            }else {
                System.out.print("请求失败");
            }
        }catch (Exception e) {
            e.printStackTrace();
        }

    }
}


