package com.example.gangplank.yuekao;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
//我是翟涑超，正在考B场，14272919990928571x
    private ViewPager vp;
    private TabLayout tb;
    private ArrayList<Fragment>list;
    private ArrayList<String>title;
    private VAdapter  vAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        vp = (ViewPager) findViewById(R.id.vp);
        tb = (TabLayout) findViewById(R.id.tb);
        list =new ArrayList<>();
        list.add(new AFragment());
        list.add(new BFragment());
        list.add(new CFragment());
        list.add(new DFragment());
        title =new ArrayList<>();
        title.add("good");
        title.add("share");
        title.add("ask");
        title.add("job");
        vAdapter =new VAdapter(getSupportFragmentManager(),list,title);
        vp.setAdapter(vAdapter);
        tb.setupWithViewPager(vp);
    }
}
