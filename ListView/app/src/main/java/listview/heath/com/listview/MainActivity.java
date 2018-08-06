package listview.heath.com.listview;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONObject;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    // 创建数据源
    private ListView listView;
    private final static OkHttpClient client = new OkHttpClient();
    private List<Brand> dataArr = new ArrayList<Brand>();

    MainActHandler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_layout);
        listView = (ListView) findViewById(R.id.list_view);
        configListView();

        handler = new MainActHandler() {
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
            }
        };
    }

    private void configListView () {
        listView.setOnItemClickListener(this);
        requestDataList();

    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        Brand currentBrand = dataArr.get(i);
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
                for (int i = 0; i < brandList.length(); i ++) {
                    JSONObject brand = (JSONObject) brandList.get(i);
                    JSONArray brandArr = brand.getJSONArray("list");
                    for (int j = 0; j < brandArr.length(); j++) {
                        JSONObject tempObj = (JSONObject) brandArr.get(j);
                        Brand brandBean = new Brand();
                        brandBean.setItemTitle((String )tempObj.get("name"));
                        brandBean.setItemImgUrl((String)tempObj.get("imgurl"));
                        dataArr.add(brandBean);
                    }
                }
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        MyListAdapter adapter = new MyListAdapter(listView.getContext(), dataArr);
                        listView.setAdapter(adapter);
                    }
                });

            }else {
                System.out.print("请求失败");
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    class MainActHandler extends Handler {

        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
        }
    }
 }

