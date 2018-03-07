package com.hc.mvp.activity_fragment.ui.mainbody.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.hc.mvp.R;
import com.hc.mvp.activity_fragment.ui.mainbody.Bean.HomeOneInfo;
import com.hc.mvp.activity_fragment.ui.mainbody.Bean.HomeOneItemInfo;
import com.jingewenku.abrahamcaijin.commonutil.AppLogMessageMgr;
import org.xutils.x;

import java.util.List;

/**
 * Created by Administrator on 2018/3/6.
 */
public class HomeFragmentReItemAdapter extends RecyclerView.Adapter<HomeFragmentReItemAdapter.ViewHolder> {

    List<HomeOneItemInfo> homeOneInfoList;

    public HomeFragmentReItemAdapter(List<HomeOneItemInfo> homeOneInfoList) {
        this.homeOneInfoList = homeOneInfoList;
    }

    /**
     * 绑定view
     *
     * @param parent
     * @param viewType
     * @return
     */
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.home_recyclerview_itemxml, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    /**
     * 绑定数据
     *
     * @param holder
     * @param position
     */
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.text_title.setText(homeOneInfoList.get(position).getText_title());
        x.image().bind(holder.image_url, homeOneInfoList.get(position).getUrl_image());
    }

    @Override
    public int getItemCount() {
        return 3;
    }

    /**
     * 初始化
     */
    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView text_title;
        ImageView image_url;

        public ViewHolder(View itemView) {
            super(itemView);
            text_title = (TextView) itemView.findViewById(R.id.text_title);
            image_url = (ImageView) itemView.findViewById(R.id.image_url);
        }
    }
}
