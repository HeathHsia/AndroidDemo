package com.example.heath.myapplication;



import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

import static com.example.heath.myapplication.DisplayMessageActivity.EXTRA_MESSAGE;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void sendMessage(View view){
        // 创建Intent 与另一个Activity 运行时绑定的对象，可以启动另一个Activity
        Intent intent = new Intent(this, DisplayMessageActivity.class);
        // findViewById 根据XML中id获取View
        EditText editText = (EditText) findViewById(R.id.edit_message);
        String message = editText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }

    /***
     * 为 ActionBar 添加菜单项，需要重载onCreateOptionsMenu
     * @param menu
     * @return
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // 为ActionBar 扩展菜单项
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_activity_actions, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.action_search:
                // 搜索界面
//                openSearch();
                return true;
            case R.id.action_settings:
                // 设置界面
//                openSetting();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
