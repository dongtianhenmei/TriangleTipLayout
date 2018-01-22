package com.example.huangxingwei.trianglelayout;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;

import com.example.library.TriangleTipLayout;

public class MainActivity extends AppCompatActivity {

    private TriangleTipLayout mTipsLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTipsLayout = findViewById(R.id.layout);

        ////// 配置指示器UI
        mTipsLayout.setRectBackgroundColor(Color.parseColor("#FFF8BE"));
        mTipsLayout.setTextColor(Color.parseColor("#FF9B33"));
        mTipsLayout.setTriangleGravity(Gravity.CENTER);
        mTipsLayout.bindView(findViewById(R.id.image));
        mTipsLayout.setText("您今日收入已到达10W+，牛逼。保持努力");
    }

    public void changedBindView(View view) {
        mTipsLayout.bindView(findViewById(R.id.image));
        mTipsLayout.setTriangleGravity(Gravity.CENTER);
        mTipsLayout.setText("对齐图片");
    }

    public void textBindView(View view) {
        mTipsLayout.bindView(findViewById(R.id.text1));
        mTipsLayout.setTriangleGravity(Gravity.LEFT);
        mTipsLayout.setText("对齐文字");
    }
}
