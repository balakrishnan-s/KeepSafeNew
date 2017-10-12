package com.abhinav.keepsafe.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.abhinav.keepsafe.R;
import com.abhinav.keepsafe.adapter.viewholder.CTAViewHolder;

import java.util.List;

/**
 * Created by abhinav.sharma on 11/10/17.
 */

public class CTAAdapter extends RecyclerView.Adapter<CTAViewHolder> {

    private Context context;
    private LayoutInflater inflater;
    private List<String> ctaLists;
    private OnItemClick onItemClick;

    public interface OnItemClick{
        void delegateClickEvent(int position);
    }

    public CTAAdapter(Context context, List<String> ctaLists, OnItemClick onItemClick) {
        this.context = context;
        this.ctaLists = ctaLists;
        this.onItemClick = onItemClick;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public CTAViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.layout_single_item_cta, parent, false);
        CTAViewHolder ctaViewHolder = new CTAViewHolder(view);
        return ctaViewHolder;
    }

    @Override
    public void onBindViewHolder(CTAViewHolder holder, final int position) {
        holder.ivCTAImage.setImageResource(R.drawable.svg_no_categories);
        holder.tvCTATitle.setText(getItem(position));
        holder.ivCTAImage.setOnClickListener(v -> onItemClick.delegateClickEvent(position));
    }

    @Override
    public int getItemCount() {
        return ctaLists.size();
    }

    private String getItem(int position) {
        return ctaLists.get(position);
    }
}
