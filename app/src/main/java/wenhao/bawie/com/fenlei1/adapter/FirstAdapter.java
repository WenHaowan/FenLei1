package wenhao.bawie.com.fenlei1.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import wenhao.bawie.com.fenlei1.R;
import wenhao.bawie.com.fenlei1.bean.FirstBean;
import wenhao.bawie.com.fenlei1.bean.SenndBean;
import wenhao.bawie.com.fenlei1.common.ShowCommon;
import wenhao.bawie.com.fenlei1.presenter.ShowPresenter;
import wenhao.bawie.com.fenlei1.view.ShowView;

/**
 * Created by HP on 2018/10/24.
 */

public class FirstAdapter extends RecyclerView.Adapter<FirstAdapter.FirstViewHolder>{

    private Context context;
    private List<FirstBean.DataBean> list;

    public FirstAdapter(Context context, List<FirstBean.DataBean> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public FirstAdapter.FirstViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.first_layout, parent, false);
        FirstViewHolder holder = new FirstViewHolder(inflate);
        return holder;
    }

    @Override
    public void onBindViewHolder(FirstAdapter.FirstViewHolder holder, final int position) {
        holder.frist_text.setText(list.get(position).getName());
        holder.frist_text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (showListener != null){
                    showListener.showCid(list.get(position).getCid());
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class FirstViewHolder extends RecyclerView.ViewHolder {

        private TextView frist_text;
        public FirstViewHolder(View itemView) {
            super(itemView);

            frist_text = (TextView) itemView.findViewById(R.id.frist_text);
        }
    }

    private ShowListener showListener;

    public void RequestListener(ShowListener showListener){
        this.showListener = showListener;
    }
    public interface ShowListener{
        void showCid(int i);
    }
}
