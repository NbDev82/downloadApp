package com.example.downloadapp;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.SystemClock;
import android.util.Log;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.downloadapp.databinding.ItemProcessingBinding;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class DownloadTask extends AsyncTask<String, Integer, Void> {

    private static final String TAG = DownloadTask.class.getSimpleName();

    private ItemProcessingBinding binding;

    private boolean isPaused = false;
    private FileOutputStream outputStream;

    public DownloadTask(ItemProcessingBinding binding, FileOutputStream outputStream) {
        this.binding = binding;
        this.outputStream = outputStream;
    }

    @Override
    protected Void doInBackground(String... params) {
        String fileUrl = params[0];

        try {
            URL url = new URL(fileUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.connect();

            InputStream inputStream = connection.getInputStream();

            long lastPublishTime = System.currentTimeMillis();
            long publishInterval = 1000;

            long fileSize = connection.getContentLength();
            long downloadedSize = 0;

            byte[] data = new byte[1024];
            int count;
            while ((count = inputStream.read(data)) != -1) {
                if (isPaused) {
                    synchronized (this) {
                        while (isPaused) {
                            wait();
                        }
                    }
                }
                downloadedSize += count;
                outputStream.write(data, 0, count);

                long currentTime = System.currentTimeMillis();

                int progress = (int) ((downloadedSize * 100) / fileSize);
                if (progress >= 100) {
                    progress = 100;
                    publishProgress(progress);
                }

                if (currentTime - lastPublishTime >= publishInterval) {
                    publishProgress(progress);
                    lastPublishTime = currentTime;
                }
            }

            // Flush the output stream
            outputStream.flush();

            // Close streams
            outputStream.close();
            inputStream.close();

        } catch (Exception e) {
            Log.e(TAG, "Error downloading file: " + e.getMessage());
        }
        return null;
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        super.onProgressUpdate(values);

        binding.pbDownload.setProgress(values[0]);
        binding.txvDownload.setText(values[0] + "%");
    }

    // Method to toggle pause/resume
    public synchronized void togglePause() {
        isPaused = !isPaused;
        if (!isPaused) {
            notify();
        }
    }
}