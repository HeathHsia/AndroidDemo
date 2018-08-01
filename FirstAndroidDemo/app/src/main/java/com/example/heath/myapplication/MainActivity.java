package com.example.heath.myapplication;



import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View; // android view 包
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

}
