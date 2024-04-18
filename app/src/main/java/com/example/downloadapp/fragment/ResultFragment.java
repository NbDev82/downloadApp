package com.example.downloadapp.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.downloadapp.adapter.ItemResultAdapter;
import com.example.downloadapp.databinding.FragmentResultBinding;
import com.example.downloadapp.model.DownloadItem;

import java.util.ArrayList;
import java.util.List;

public class ResultFragment extends Fragment {
    FragmentResultBinding binding;
    private ItemResultAdapter adapter;
    private List<DownloadItem> downloadItems;


    public ResultFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentResultBinding.inflate(inflater, container, false);
        downloadItems = new ArrayList<>();
        adapter = new ItemResultAdapter(downloadItems);
        binding.rclItems.setAdapter(adapter);
        return binding.getRoot();
    }
}