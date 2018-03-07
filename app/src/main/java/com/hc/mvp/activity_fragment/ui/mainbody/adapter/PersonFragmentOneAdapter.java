package com.hc.mvp.activity_fragment.ui.mainbody.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.hc.mvp.R;
import com.hc.mvp.activity_fragment.ui.mainbody.Bean.PersonFragmentOneInfo;
import org.xutils.x;

import java.util.List;

/**
 * Created by Administrator on 2018/3/7.
 * 我的界面，底部功能区
 */
public class PersonFragmentOneAdapter extends RecyclerView.Adapter<PersonFragmentOneAdapter.ViewHolder> {


    List<PersonFragmentOneInfo> list;

    public PersonFragmentOneAdapter(List<PersonFragmentOneInfo> list) {
        this.list = list;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.personfragment_itemxml, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        x.image().bind(holder.image_url, list.get(position).getImage_url());
        holder.text_.setText(list.get(position).getText_());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView image_url;
        private TextView text_;

        public ViewHolder(View itemView) {
            super(itemView);
            image_url = (ImageView) itemView.findViewById(R.id.image_url);
            text_ = (TextView) itemView.findViewById(R.id.text_title);
        }
    }
}
