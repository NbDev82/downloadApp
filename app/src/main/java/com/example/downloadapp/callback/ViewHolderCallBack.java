package com.example.downloadapp.callback;

import com.example.downloadapp.databinding.ItemProcessingBinding;
import com.example.downloadapp.model.DownloadItem;

public interface ViewHolderCallBack {
    void onBindingReady(ItemProcessingBinding binding, DownloadItem item);
}

