package com.example.downloadapp.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.downloadapp.adapter.ItemProcessingAdapter;
import com.example.downloadapp.databinding.FragmentProcessingBinding;
import com.example.downloadapp.model.DownloadItem;

import java.util.ArrayList;
import java.util.List;

public class ProcessingFragment extends Fragment {
    FragmentProcessingBinding binding;

    private ItemProcessingAdapter adapter;
    private List<DownloadItem> downloadItems;

    public ProcessingFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentProcessingBinding.inflate(inflater, container, false);
        downloadItems = new ArrayList<>();
        adapter = new ItemProcessingAdapter(downloadItems);
        binding.rclItems.setAdapter(adapter);
        return binding.getRoot();
    }

    public void addItemProcessingView(DownloadItem downloadItem) {
        if (downloadItems == null) {
            downloadItems = new ArrayList<>();
        }

        this.downloadItems.add(downloadItem);
        adapter.setDownloadItems(downloadItems);
    }
}