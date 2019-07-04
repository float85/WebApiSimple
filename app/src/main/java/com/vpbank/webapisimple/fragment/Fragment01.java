package com.vpbank.webapisimple.fragment;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.vpbank.webapisimple.R;
import com.vpbank.webapisimple.databinding.Fragment01Binding;

public class Fragment01 extends Fragment {
    Fragment01Binding binding;

    public static Fragment01 newInstance() {
        return new Fragment01();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_01, container, false);

        binding.tvFragment01.setText("Done");
        return binding.getRoot();
    }
}
