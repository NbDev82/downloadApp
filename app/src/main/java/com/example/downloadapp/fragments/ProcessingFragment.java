package com.example.downloadapp.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.downloadapp.adapter.ItemProcessingAdapter;
import com.example.downloadapp.databinding.FragmentProcessingBinding;
import com.example.downloadapp.view.ItemProcessingView;

import java.util.ArrayList;
import java.util.List;

public class ProcessingFragment extends Fragment {
    FragmentProcessingBinding binding;

    private ItemProcessingAdapter adapter;
    private List<ItemProcessingView> itemProcessingViews;

    public ProcessingFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentProcessingBinding.inflate(inflater, container, false);
        itemProcessingViews = new ArrayList<>();
        adapter = new ItemProcessingAdapter(itemProcessingViews);
        binding.rclItems.setAdapter(adapter);
        return binding.getRoot();
    }
}