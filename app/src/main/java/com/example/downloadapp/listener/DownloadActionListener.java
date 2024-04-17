package com.example.downloadapp.listener;

public interface DownloadActionListener {
    void onStartDownload(String fileName, String url);
    void onPauseDownload();
    void onResumeDownload();
}
