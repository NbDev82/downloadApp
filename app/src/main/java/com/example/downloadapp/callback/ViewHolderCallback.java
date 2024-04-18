package com.example.downloadapp.callback;

import com.example.downloadapp.databinding.ItemProcessingBinding;
import com.example.downloadapp.model.DownloadItem;

public interface ViewHolderCallback {
    void onBindingReady(ItemProcessingBinding binding, DownloadItem item);
}

