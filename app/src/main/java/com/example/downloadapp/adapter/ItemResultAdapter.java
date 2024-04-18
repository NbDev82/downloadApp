package com.example.downloadapp.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.example.downloadapp.R;
import com.example.downloadapp.databinding.ItemResultBinding;
import com.example.downloadapp.model.DownloadItem;

import java.util.List;

public class ItemResultAdapter extends RecyclerView.Adapter<ItemResultAdapter.ItemResultViewHolder>{

    private List<DownloadItem> downloadItems;

    public void setItemResultViews(List<DownloadItem> downloadItems){
        this.downloadItems = downloadItems;
        notifyDataSetChanged();
    }

    public ItemResultAdapter(List<DownloadItem> downloadItems) {
        this.downloadItems = downloadItems;
    }

    @NonNull
    @Override
    public ItemResultAdapter.ItemResultViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ItemResultViewHolder(
                ItemResultBinding.inflate(
                        LayoutInflater.from(parent.getContext()),
                        parent,
                        false
                )
        );
    }

    @Override
    public void onBindViewHolder(@NonNull ItemResultAdapter.ItemResultViewHolder holder, int position) {
        holder.setData(downloadItems.get(position));
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class ItemResultViewHolder extends RecyclerView.ViewHolder {

        ItemResultBinding binding;
        public ItemResultViewHolder(ItemResultBinding item) {
            super(item.getRoot());
        }

        void setData(DownloadItem downloadItem){
            binding.txvTitle.setText(downloadItem.getFileName());
            if(downloadItem.getStatus() == DownloadItem.EStatus.COMPLETED){
                binding.imgStatus.setImageDrawable(
                        ContextCompat.getDrawable(binding.getRoot().getContext(), R.drawable.ic_check));
            } else if (downloadItem.getStatus() == DownloadItem.EStatus.FAILED) {
                binding.imgStatus.setImageDrawable(
                        ContextCompat.getDrawable(binding.getRoot().getContext(), R.drawable.ic_cross));
            }
        }
    }
}
