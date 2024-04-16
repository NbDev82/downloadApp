package com.example.downloadapp.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.example.downloadapp.R;
import com.example.downloadapp.databinding.ItemResultBinding;
import com.example.downloadapp.view.ItemResultView;

import java.util.List;

public class ItemResultAdapter extends RecyclerView.Adapter<ItemResultAdapter.ItemResultViewHolder>{

    private List<ItemResultView> itemResultViews;

    public void setItemResultViews(List<ItemResultView> itemResultViews){
        this.itemResultViews = itemResultViews;
        notifyDataSetChanged();
    }

    public ItemResultAdapter(List<ItemResultView> itemResultViews) {
        this.itemResultViews = itemResultViews;
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
        holder.setData(itemResultViews.get(position));
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

        void setData(ItemResultView itemResultView){
            binding.txvTitle.setText(itemResultView.getTitle());
            if(itemResultView.isStatus()){
                binding.imgStatus.setImageDrawable(
                        ContextCompat.getDrawable(binding.getRoot().getContext(), R.drawable.ic_check));
            } else {
                binding.imgStatus.setImageDrawable(
                        ContextCompat.getDrawable(binding.getRoot().getContext(), R.drawable.ic_cross));
            }
        }
    }
}
