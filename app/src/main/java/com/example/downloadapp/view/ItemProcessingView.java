package com.example.downloadapp.view;

public class ItemProcessingView {
    String title;
    int process;

    public ItemProcessingView() {
    }

    public ItemProcessingView(String title, int process) {
        this.title = title;
        this.process = process;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getProcess() {
        return process;
    }

    public void setProcess(int process) {
        this.process = process;
    }
}
