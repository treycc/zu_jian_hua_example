package com.bodyworks.zu_jian_hua_example.mvp;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.bodyworks.zu_jian_hua_example.R;
import com.bodyworks.zu_jian_hua_example.mvp.base.MvpBaseFragment;
import com.bodyworks.zu_jian_hua_example.mvp.presenter.MainPresenter;
import com.bodyworks.zu_jian_hua_example.mvp.view.MainView;

/**
 * Created by treycc on 2017/3/28.
 */

public class MvpFragment extends MvpBaseFragment<MainView, MainPresenter> implements MainView {

    private ProgressBar progressBar;
    private TextView textView;
    private EditText editText;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.activity_mvp, container, false);
        rootView.setBackgroundColor(Color.GRAY);
        rootView.setClickable(true);
        progressBar = (ProgressBar) rootView.findViewById(R.id.progressBar);
        textView = (TextView) rootView.findViewById(R.id.textView);
        editText = (EditText) rootView.findViewById(R.id.editText);
        rootView.findViewById(R.id.imageButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().getSupportFragmentManager().popBackStackImmediate();
            }
        });
        return rootView;
    }

    @NonNull
    @Override
    public MainPresenter createPresenter() {
        return new MainPresenter(this);
    }

    @Override
    public void showProgress() {

    }

    @Override
    public void hideProgress() {

    }

    @Override
    public void loadDataComplate(String loadedText) {

    }

    @Override
    public void changeName(String chageText) {

    }
}
