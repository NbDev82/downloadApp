package com.example.downloadapp.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.downloadapp.adapter.ItemResultAdapter;
import com.example.downloadapp.databinding.FragmentResultBinding;
import com.example.downloadapp.view.ItemResultView;

import java.util.ArrayList;
import java.util.List;

public class ResultFragment extends Fragment {
    FragmentResultBinding binding;
    private ItemResultAdapter adapter;
    private List<ItemResultView> itemResultViews;


    public ResultFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentResultBinding.inflate(inflater, container, false);
        itemResultViews = new ArrayList<>();
        adapter = new ItemResultAdapter(itemResultViews);
        binding.rclItems.setAdapter(adapter);
        return binding.getRoot();
    }
}