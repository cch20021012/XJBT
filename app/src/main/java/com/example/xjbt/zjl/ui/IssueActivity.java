package com.example.xjbt.zjl.ui;

import android.os.Bundle;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.xjbt.R;
import com.example.xjbt.zjl.adapter.MyExpandableListAdapter;

public class IssueActivity extends AppCompatActivity {

    private ExpandableListView mElvZjl;

    //数据
    String[] group = {"什么是土星？"};
    String[][] child = {
            {"饿狼传说遥远的她........................"}

    };
    private MyExpandableListAdapter myExpandableListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_issue);
        initView();
        listener();
        initData();
    }

    private void initData() {

    }

    private void initView() {
        mElvZjl = (ExpandableListView) findViewById(R.id.zjl_elv);
        myExpandableListAdapter = new MyExpandableListAdapter(group, child, this);
        mElvZjl.setAdapter(myExpandableListAdapter);

    }



    private void listener() {
        //设置一级列表的点击事件
        mElvZjl.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
            @Override
            public boolean onGroupClick(ExpandableListView parent, View v, int groupPosition, long id) {
                Toast.makeText(IssueActivity.this, group[groupPosition], Toast.LENGTH_SHORT).show();
                //返回false 否则一级列表不会展开
                return false;
            }
        });

        //设置二级列表的点击事件
        mElvZjl.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
                Toast.makeText(IssueActivity.this, child[groupPosition][childPosition], Toast.LENGTH_SHORT).show();
                return false;
            }
        });
    }
}