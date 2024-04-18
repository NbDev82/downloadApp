package com.example.downloadapp.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.downloadapp.databinding.ItemProcessingBinding;
import com.example.downloadapp.model.DownloadItem;

import java.util.List;

public class ItemProcessingAdapter extends RecyclerView.Adapter<ItemProcessingAdapter.ItemProcessingViewHolder> {
    private List<DownloadItem> downloadItems;

    public ItemProcessingAdapter(List<DownloadItem> downloadItems) {
        this.downloadItems = downloadItems;
    }

    public void setDownloadItems(List<DownloadItem> downloadItems){
        this.downloadItems = downloadItems;
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
        holder.setData(downloadItems.get(position));
    }

    @Override
    public int getItemCount() {
        return downloadItems.size();
    }

    public class ItemProcessingViewHolder extends RecyclerView.ViewHolder {

        ItemProcessingBinding binding;
        public ItemProcessingViewHolder(ItemProcessingBinding item) {
            super(item.getRoot());
        }

        void setData(DownloadItem downloadItem){
            binding.txvTitle.setText(downloadItem.getFileName());
            binding.txvDownload.setText(downloadItem.getProgress());
        }
    }
}
