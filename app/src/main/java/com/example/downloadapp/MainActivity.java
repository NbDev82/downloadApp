package com.example.downloadapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import com.example.downloadapp.databinding.ActivityMainBinding;
import com.example.downloadapp.fragment.InputFragment;
import com.example.downloadapp.fragment.ProcessingFragment;
import com.example.downloadapp.fragment.ResultFragment;
import com.example.downloadapp.listener.DownloadActionListener;
import com.google.android.material.navigation.NavigationBarView;

import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity
        implements InputFragment.OnDialogDismissedListener, DownloadActionListener {

    private ActivityMainBinding binding;
    private ProcessingFragment processingFragment;
    private DownloadTask downloadTask;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        processingFragment = new ProcessingFragment();

        ArrayList<Fragment> fragments = new ArrayList<>();
        fragments.add(new InputFragment());
        fragments.add(processingFragment);
        fragments.add(new ResultFragment());

        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(this, fragments);
        binding.viewPagerHome.setAdapter(viewPagerAdapter);

        List<Integer> tabIds = Arrays.asList(R.id.input_tab, R.id.processing_tab, R.id.result_tab);

        binding.viewPagerHome.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                if(position >= tabIds.size()){
                    position = 2;
                }

                binding.bnvHome.setSelectedItemId(tabIds.get(position));
                super.onPageSelected(position);
            }
        });

        binding.bnvHome.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                binding.viewPagerHome.setCurrentItem(tabIds.indexOf(item.getItemId()));
                return true;
            }
        });


        int firstFragmentPosition = 2;
        binding.viewPagerHome.setCurrentItem(firstFragmentPosition, false);
    }

    @Override
    public void onDialogDismissed() {
        binding.viewPagerHome.setCurrentItem(1, false);
    }

    @Override
    public void onStartDownload(String fileName, String url) {
        try {
            FileOutputStream outputStream = openFileOutput(fileName, MODE_PRIVATE);
            downloadTask = new DownloadTask(outputStream);
            downloadTask.execute(url);
        } catch (Exception e) {
            Log.e("MainActivity", "Error starting download: " + e.getMessage());
        }
    }

    @Override
    public void onPauseDownload() {
        if (downloadTask != null) {
            downloadTask.togglePause();
        }
    }

    @Override
    public void onResumeDownload() {
        if (downloadTask != null) {
            downloadTask.togglePause();
        }
    }
}