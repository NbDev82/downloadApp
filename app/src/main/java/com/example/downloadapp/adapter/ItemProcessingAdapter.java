package com.example.downloadapp.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.downloadapp.databinding.ItemProcessingBinding;
import com.example.downloadapp.view.ItemProcessingView;

import java.util.ArrayList;
import java.util.List;

public class ItemProcessingAdapter extends RecyclerView.Adapter<ItemProcessingAdapter.ItemProcessingViewHolder> {
    private List<ItemProcessingView> itemProcessingViews;

    public ItemProcessingAdapter(List<ItemProcessingView> itemProcessingViews) {
        this.itemProcessingViews = itemProcessingViews;
    }

    public void setItemProcessingViews(List<ItemProcessingView> itemProcessingViews){
        this.itemProcessingViews = itemProcessingViews;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ItemProcessingViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ItemProcessingViewHolder(
                ItemProcessingBinding.inflate(
                        LayoutInflater.from(parent.getContext()),
                        parent,
                        false
                )
        );
    }

    @Override
    public void onBindViewHolder(ItemProcessingViewHolder holder, int position) {
        holder.setData(itemProcessingViews.get(position));
    }

    @Override
    public int getItemCount() {
        return itemProcessingViews.size();
    }

    public class ItemProcessingViewHolder extends RecyclerView.ViewHolder {

        ItemProcessingBinding binding;
        public ItemProcessingViewHolder(ItemProcessingBinding item) {
            super(item.getRoot());
        }

        void setData(ItemProcessingView itemProcessingView){
            binding.txvTitle.setText(itemProcessingView.getTitle());
            binding.txvDownload.setText(itemProcessingView.getProcess());
        }
    }
}
