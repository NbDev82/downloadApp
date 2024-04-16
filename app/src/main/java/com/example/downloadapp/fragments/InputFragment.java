package com.example.downloadapp.fragments;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;

import com.example.downloadapp.MainActivity;
import com.example.downloadapp.databinding.FragmentInputBinding;
import com.example.downloadapp.databinding.InputDialogBinding;

public class InputFragment extends Fragment {
    public interface OnDialogDismissedListener {
        void onDialogDismissed();
    }

    FragmentInputBinding binding;
    InputDialogBinding bindingDialog;
    Dialog dialog;
    private OnDialogDismissedListener mListener;

    public void setOnDialogDismissedListener(OnDialogDismissedListener listener) {
        mListener = listener;
    }

    public InputFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentInputBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onResume() {
        super.onResume();
        showInputDialog();
        setOnDialogDismissedListener((MainActivity) requireActivity());
    }


    @Override
    public void onDestroyView(){
        super.onDestroyView();
        if (dialog != null && dialog.isShowing()) {
            dialog.dismiss();
        }
        binding = null;
    }

    private void showInputDialog(){
        bindingDialog = InputDialogBinding.inflate(getLayoutInflater());
        dialog = new Dialog(bindingDialog.getRoot().getContext());

        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(bindingDialog.getRoot());

        Window window = dialog.getWindow();
        if (window == null) {
            return;
        }

        window.setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT);
        window.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        bindingDialog.btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        dialog.setOnDismissListener(dialog -> {
            onDialogDismissed();
        });


        dialog.show();
    }

    private void onDialogDismissed(){
        if (mListener != null) {
            mListener.onDialogDismissed();
        }
    }
}