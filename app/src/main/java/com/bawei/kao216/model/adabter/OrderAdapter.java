package com.bawei.kao216.model.adabter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bawei.kao216.R;
import com.bawei.kao216.model.entity.OrderEntity;

import java.text.SimpleDateFormat;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class OrderAdapter extends RecyclerView.Adapter<OrderAdapter.VH> {

    private List<OrderEntity.OrderListBean> listBeans;

    public OrderAdapter(List<OrderEntity.OrderListBean> listBeans) {
        this.listBeans = listBeans;
    }

    @NonNull
    @Override
    public VH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_order_form, parent, false);
        return new VH(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull VH holder, int position) {
        OrderEntity.OrderListBean orderListBean = listBeans.get(position);

        holder.tvOrderId.setText("订单号"+orderListBean.getOrderId());

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("YYYY-MM-dd HH:mm");
        String format = simpleDateFormat.format(orderListBean.getOrderTime());
        holder.tvTime.setText(format);

        int orderStatus = orderListBean.getOrderStatus();
        if (orderStatus == 1){
            holder.btnPayOrReceive.setVisibility(View.VISIBLE);
            holder.btnPayOrReceive.setText("去支付");
        }else if (orderStatus == 2){
            holder.btnPayOrReceive.setVisibility(View.VISIBLE);
            holder.btnPayOrReceive.setText("确认收货");
        }else {
            holder.btnPayOrReceive.setVisibility(View.GONE);
        }

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(holder.itemView.getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        holder.recyclerCommidity.setLayoutManager(linearLayoutManager);

        List<OrderEntity.OrderListBean.DetailListBean> detailListBeans = orderListBean.getDetailList();

        OrderCommodAdapter orderCommodAdapter = new OrderCommodAdapter(detailListBeans, orderStatus);
        holder.recyclerCommidity.setAdapter(orderCommodAdapter);

    }

    @Override
    public int getItemCount() {
        return listBeans.size();
    }

    class VH extends RecyclerView.ViewHolder {
        @BindView(R.id.tv_order_id)
        TextView tvOrderId;
        @BindView(R.id.recycler_commidity)
        RecyclerView recyclerCommidity;
        @BindView(R.id.tv_time)
        TextView tvTime;
        @BindView(R.id.btn_pay_or_receive)
        Button btnPayOrReceive;
        public VH(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
