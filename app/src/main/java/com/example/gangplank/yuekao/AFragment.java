package com.example.gangplank.yuekao;


import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.gson.Gson;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class AFragment extends Fragment {


    private RecyclerView rl;
    private ArrayList<Person>list;
    private MyAdapter myAdapter;
    public AFragment() {
        // Required empty public constructor
    }

      @SuppressLint("HandlerLeak")
          private Handler handler =new Handler(){
              @Override
              public void handleMessage(Message msg) {
                  super.handleMessage(msg);
                  if(msg.what==0x001){
                      String string= (String) msg.obj;
                      Gson gson=new Gson();
                      Student student = gson.fromJson(string, Student.class);
                      ArrayList<Person> result = student.getResult();
                      list.addAll(result);
                      myAdapter.notifyDataSetChanged();
                  }
              }
          };
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_a, container, false);
        initView(view);
        initData();
        return view;
    }

          private void initData() {
              new Thread(){
                  @Override
                  public void run() {
                      super.run();

                      try {
                          HttpURLConnection con = (HttpURLConnection) new URL("http://192.168.1.19:8080/json/test1.json").openConnection();
                          StringBuffer sb =   new StringBuffer();
                          int length =-1;
                          byte []  bytes  =new byte[1024];
                          InputStream is = con.getInputStream();

                         while((length=is.read(bytes))!=-1){
                             sb.append(new String(bytes,0,length));
                         }
                          Message message = handler.obtainMessage();
                          message.what = 0x001;
                          message.obj=sb.toString();
                          handler.sendMessage(message);
                      } catch (Exception e) {
                          e.printStackTrace();
                      }


                          }


              }.start();

          }



    private void initView(View view) {
        rl = (RecyclerView) view.findViewById(R.id.rl);
        list = new ArrayList<>();
        myAdapter =new MyAdapter(getActivity(),list);
        rl.setAdapter(myAdapter);
       GridLayoutManager manager = new GridLayoutManager(getActivity(),3);
        rl.setLayoutManager(manager);
    }
}
