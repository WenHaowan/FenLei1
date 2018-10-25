package wenhao.bawie.com.fenlei1.adapter;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

import java.util.List;

import wenhao.bawie.com.fenlei1.R;
import wenhao.bawie.com.fenlei1.bean.SenndBean;

/**
 * Created by HP on 2018/10/25.
 */

public class SenndAdapter extends RecyclerView.Adapter<SenndAdapter.SenndViewHolder>{
    private Context context;
    private List<SenndBean.DataBean> list;

    public SenndAdapter(Context context, List<SenndBean.DataBean> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public SenndAdapter.SenndViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.sennd_layout, parent, false);
        SenndViewHolder senndViewHolder = new SenndViewHolder(inflate);
        return senndViewHolder;
    }

    @Override
    public void onBindViewHolder(SenndAdapter.SenndViewHolder holder, int position) {
        holder.right_recyview.setLayoutManager(new GridLayoutManager(context,3));
        ThreeAdapter threeAdapter = new ThreeAdapter(context,list.get(position).getList());
        holder.right_recyview.setAdapter(threeAdapter);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class SenndViewHolder extends RecyclerView.ViewHolder {

        private RecyclerView right_recyview;

        public SenndViewHolder(View itemView) {
            super(itemView);

            right_recyview = (RecyclerView) itemView.findViewById(R.id.right_recyview);
        }
    }
}
