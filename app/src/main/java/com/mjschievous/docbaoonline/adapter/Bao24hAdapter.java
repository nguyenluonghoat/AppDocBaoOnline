package com.mjschievous.docbaoonline.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.mjschievous.docbaoonline.R;
import com.mjschievous.docbaoonline.listener.OnItemClick;
import com.mjschievous.docbaoonline.model.Item;

import java.util.List;

public class Bao24hAdapter extends RecyclerView.Adapter<Bao24hAdapter.ViewHoder> {
    private List<Item> itemList;
    private Context mContext;
    private OnItemClick mListener;

    public Bao24hAdapter(List<Item> itemList, Context mContext, OnItemClick mListener) {
        this.itemList = itemList;
        this.mContext = mContext;
        this.mListener = mListener;
    }

    @NonNull
    @Override
    public ViewHoder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.new_layout,parent,false);
        return new ViewHoder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHoder holder, int position) {
        final Item item = itemList.get(position);
        holder.tvTitle.setText(item.getTitle());
        holder.tvDescription.setText(item.getDescription());
        holder.tvDate.setText(item.getPubDate());
        String url = item.getThumbUrl();
        Glide.with(mContext).load(url).into(holder.imgThumb);
        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mListener.onClickItem(item.getDetailUrl());
            }
        });

    }


    @Override
    public int getItemCount() {
        return itemList.size();
    }

    public class ViewHoder extends RecyclerView.ViewHolder  {
        ImageView imgThumb;
        TextView tvTitle, tvDate, tvDescription;
        LinearLayout linearLayout;
        public ViewHoder(@NonNull View itemView) {
            super(itemView);
            linearLayout = itemView.findViewById(R.id.lli);
            imgThumb = itemView.findViewById(R.id.img_thumb);
            tvDate = itemView.findViewById(R.id.tv_date);
            tvTitle = itemView.findViewById(R.id.tv_title);
            tvDescription = itemView.findViewById(R.id.tv_description);

        }

    }
}
