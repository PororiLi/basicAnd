package com.porori.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<MainData> arrayList;
    private MainAdapter mainAdapter;
    private RecyclerView recyclerView;
    private LinearLayoutManager linearLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        recyclerView = (RecyclerView)findViewById(R.id.rv);
        linearLayoutManager = new LinearLayoutManager((this));
        recyclerView.setLayoutManager(linearLayoutManager);


        arrayList = new ArrayList<>();
        mainAdapter = new MainAdapter(arrayList);    //mainadapter에 arraylist 담기
        recyclerView.setAdapter(mainAdapter);

        Button btn_add = (Button)findViewById(R.id.btn_add);
        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainData mainData = new MainData(R.mipmap.ic_launcher, "porori", "recyclerview");
                arrayList.add(mainData);    //arraylist 에  maindata 추가
                mainAdapter.notifyDataSetChanged(); //데이터 변경 후 새로고침
            }
        });

    }
}