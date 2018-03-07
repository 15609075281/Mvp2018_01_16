package com.hc.mvp.activity_fragment.ui.mainbody.adapter;


import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.hc.mvp.R;
import com.hc.mvp.activity_fragment.ui.mainbody.Bean.HomeOneInfo;
import com.jingewenku.abrahamcaijin.commonutil.AppLogMessageMgr;
import org.xutils.x;

import java.util.List;

/**
 * Created by Administrator on 2018/3/5.
 */
public class HomeFragmentOneAdapter extends RecyclerView.Adapter<HomeFragmentOneAdapter.ViewHolder> {

    List<HomeOneInfo> homeOneInfoList;

    public HomeFragmentOneAdapter(List<HomeOneInfo> homeOneInfoList) {
        this.homeOneInfoList = homeOneInfoList;
    }

    //注册view
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup content, int viewType) {
        View view = LayoutInflater.from(content.getContext()).inflate(R.layout.homefragment_itemxml, content, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    //绑定数据
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.homeone_text.setText(homeOneInfoList.get(position).getTitle());
        HomeFragmentReItemAdapter homeFragmentReItemAdapter = new HomeFragmentReItemAdapter(homeOneInfoList.get(position).getHomeOneItemInfoList());
        holder.adapter_item_recyclerview.setAdapter(homeFragmentReItemAdapter);
    }

    //获取数量
    @Override
    public int getItemCount() {
        return homeOneInfoList.size();
    }

    /**
     * ViewHolder
     */
    public static class ViewHolder extends RecyclerView.ViewHolder {

        TextView homeone_text;
        RecyclerView adapter_item_recyclerview;
        LinearLayoutManager linearLayoutManager;

        public ViewHolder(View itemView) {
            super(itemView);
            homeone_text = (TextView) itemView.findViewById(R.id.homeone_text);
            adapter_item_recyclerview = (RecyclerView) itemView.findViewById(R.id.adapter_item_recyclerview);
            linearLayoutManager = new LinearLayoutManager(itemView.getContext());
            linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
            adapter_item_recyclerview.setHasFixedSize(true);
            adapter_item_recyclerview.setLayoutManager(linearLayoutManager);
        }
    }

//    @Override
//    public void onClick(View view) {
//        if (mOnItemClickListener != null) {
//            //注意这里使用getTag方法获取数据
//            mOnItemClickListener.onItemClick(view, (HomeOneInfo) view.getTag());
//        }
//    }
//
//    /**
//     * 监听器
//     */
//    public static interface OnRecyclerViewItemClickListener {
//        void onItemClick(View view, HomeOneInfo data);
//    }
//
//    private OnRecyclerViewItemClickListener mOnItemClickListener = null;
//
//    public void setOnItemClickListener(OnRecyclerViewItemClickListener listener) {
//        this.mOnItemClickListener = listener;
//    }
}
