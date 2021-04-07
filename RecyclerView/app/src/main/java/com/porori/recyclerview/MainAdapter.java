package com.porori.recyclerview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.CustomViewHolder> {
    private ArrayList<MainData> arrayList;

    public MainAdapter(ArrayList<MainData> arrayList) {
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public MainAdapter.CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {   //리스트뷰의 처음 보는 상태일때의 생명주기

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list, parent, false);    //list 레이아웃으로 view 생성
        CustomViewHolder holder = new CustomViewHolder(view); //view 연결

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull MainAdapter.CustomViewHolder holder, int position) {  //추가될때에 대한 생명주기
        //holder에 arrayList  값 연결
        holder.iv_profile.setImageResource(arrayList.get(position).getIv_profile());    //imageResource를 세팅함.
        holder.tv_name.setText(arrayList.get(position).getTv_name());
        holder.tv_content.setText(arrayList.get(position).getTv_content());

        holder.itemView.setTag(position);   //position 값 갖고 오기
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String curName = holder.tv_name.getText().toString();
                Toast.makeText(v.getContext(), curName, Toast.LENGTH_SHORT).show();     //activity가 아니기때문에 View.getContext, 보여줄것, 시간
            }
        });

        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                remove(holder.getAdapterPosition());    //holder의 position 값 넘겨줌. getAdapterPosition()

                return true;
            }
        });


    }

    @Override
    public int getItemCount() {
        return (null != arrayList? arrayList.size() : 0);   //리스트 사이즈가 0이 아니면 사이즈 출력
    }

    public void remove(int position) {
        try {
            arrayList.remove(position); //position에 있는 값 리무브
            notifyItemRemoved(position);    //데이터 변환 후 새로고침
        } catch (IndexOutOfBoundsException ex)  {
            ex.printStackTrace();
        }
    }

    public class CustomViewHolder extends RecyclerView.ViewHolder {
        protected ImageView iv_profile;
        protected TextView tv_name;
        protected  TextView tv_content;

        public CustomViewHolder(@NonNull View itemView) {
            super(itemView);
            this.iv_profile = (ImageView) itemView.findViewById(R.id.iv_profile);   //findviewbyId와 비슷하나 activity가 아니기 때문에 itemview.find~ 사용
            this.tv_name = (TextView) itemView.findViewById(R.id.tv_name);
            this.tv_content = (TextView) itemView.findViewById(R.id.tv_content);

        }
    }
}
