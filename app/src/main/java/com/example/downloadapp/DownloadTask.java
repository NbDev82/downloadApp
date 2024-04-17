package com.example.downloadapp;

import android.os.AsyncTask;
import android.util.Log;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class DownloadTask extends AsyncTask<String, Integer, Void> {

    private static final String TAG = DownloadTask.class.getSimpleName();

    private boolean isPaused = false;
    private FileOutputStream outputStream;

    public DownloadTask(FileOutputStream outputStream) {
        this.outputStream = outputStream;
    }

    @Override
    protected Void doInBackground(String... params) {
        String fileUrl = params[0];

        try {
            URL url = new URL(fileUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.connect();

            // Input stream to read file
            InputStream inputStream = connection.getInputStream();

            byte[] data = new byte[1024];
            int count;
            while ((count = inputStream.read(data)) != -1) {
                if (isPaused) {
                    // If paused, wait until resumed
                    synchronized (this) {
                        while (isPaused) {
                            wait();
                        }
                    }
                }
                outputStream.write(data, 0, count);
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

    // Method to toggle pause/resume
    public synchronized void togglePause() {
        isPaused = !isPaused;
        if (!isPaused) {
            notify();
        }
    }
}