package com.example.downloadapp.listener;

public interface DownloadActionListener {
    void onStartDownload(String fileName, String url, String format);
    void onPauseDownload();
    void onResumeDownload();
}
