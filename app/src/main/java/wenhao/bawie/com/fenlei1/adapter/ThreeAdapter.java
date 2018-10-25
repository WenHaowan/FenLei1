package wenhao.bawie.com.fenlei1.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import wenhao.bawie.com.fenlei1.R;
import wenhao.bawie.com.fenlei1.bean.SenndBean;

/**
 * Created by HP on 2018/10/25.
 */

public class ThreeAdapter extends RecyclerView.Adapter<ThreeAdapter.ThreeViewHolder>{

    private Context context;
    private List<SenndBean.DataBean.ListBean> list;

    public ThreeAdapter(Context context, List<SenndBean.DataBean.ListBean> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public ThreeAdapter.ThreeViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.three_layout, parent, false);
        ThreeViewHolder threeViewHolder = new ThreeViewHolder(inflate);
        return threeViewHolder;
    }

    @Override
    public void onBindViewHolder(ThreeAdapter.ThreeViewHolder holder, int position) {
        holder.item_right_text.setText(list.get(position).getName());
        Glide.with(context).load(list.get(position).getIcon()).into(holder.item_right_img);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ThreeViewHolder extends RecyclerView.ViewHolder {

        private TextView item_right_text;
        private ImageView item_right_img;

        public ThreeViewHolder(View itemView) {
            super(itemView);
            item_right_img = (ImageView) itemView.findViewById(R.id.item_right_img);
            item_right_text = (TextView) itemView.findViewById(R.id.item_right_text);
        }
    }
}
