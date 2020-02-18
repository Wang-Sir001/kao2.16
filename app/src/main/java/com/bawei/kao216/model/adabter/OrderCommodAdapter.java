package com.bawei.kao216.model.adabter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bawei.kao216.R;
import com.bawei.kao216.model.entity.OrderEntity;
import com.bumptech.glide.Glide;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class OrderCommodAdapter extends RecyclerView.Adapter<OrderCommodAdapter.VH> {

    private List<OrderEntity.OrderListBean.DetailListBean> detailListBeans;

    private int orderStatus;

    public OrderCommodAdapter(List<OrderEntity.OrderListBean.DetailListBean> detailListBeans, int orderStatus) {
        this.detailListBeans = detailListBeans;
        this.orderStatus = orderStatus;
    }

    @NonNull
    @Override
    public VH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_order_form_commodity, parent, false);
        return new VH(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull VH holder, int position) {
        OrderEntity.OrderListBean.DetailListBean detailListBean = detailListBeans.get(position);

        holder.productTitleNameTv.setText(detailListBean.getCommodityName());

        holder.productPriceTv.setText(detailListBean.getCommodityPrice());

        String commodityPic = detailListBean.getCommodityPic();
        String[] split = commodityPic.split(",");
        commodityPic = split[0];
        Glide.with(holder.productIconIv)
                .load(commodityPic)
                .error(R.mipmap.ic_launcher)
                .placeholder(R.mipmap.ic_launcher)
                .into(holder.productIconIv);

        if (orderStatus == 3){
            holder.btnEvaluate.setVisibility(View.VISIBLE);
        }else {
            holder.btnEvaluate.setVisibility(View.GONE);
        }
    }

    @Override
    public int getItemCount() {
        return detailListBeans.size();
    }

    class VH extends RecyclerView.ViewHolder {
        @BindView(R.id.product_icon_iv)
        ImageView productIconIv;
        @BindView(R.id.product_title_name_tv)
        TextView productTitleNameTv;
        @BindView(R.id.product_price_tv)
        TextView productPriceTv;
        @BindView(R.id.btn_evaluate)
        Button btnEvaluate;
        public VH(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
