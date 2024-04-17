package com.example.downloadapp.model;

public class DownloadItem {
    private String fileName;
    private String url;
    private int progress;
    private EStatus status;

    public DownloadItem() {
    }

    public DownloadItem(String fileName, String url, int progress, EStatus status) {
        this.fileName = fileName;
        this.url = url;
        this.progress = progress;
        this.status = status;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getProgress() {
        return progress;
    }

    public void setProgress(int progress) {
        this.progress = progress;
    }

    public EStatus getStatus() {
        return status;
    }

    public void setStatus(EStatus status) {
        this.status = status;
    }

    public enum EStatus {
        DOWNLOADING,
        PAUSED,
        COMPLETED,
        FAILED
    }
}
