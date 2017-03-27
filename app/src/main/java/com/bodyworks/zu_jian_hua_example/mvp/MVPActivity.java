package com.bodyworks.zu_jian_hua_example.mvp;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.bodyworks.zu_jian_hua_example.R;
import com.bodyworks.zu_jian_hua_example.mvp.base.MvpBaseActivity;
import com.bodyworks.zu_jian_hua_example.mvp.presenter.MainPresenter;
import com.bodyworks.zu_jian_hua_example.mvp.view.MainView;

/**
 * Created by treycc on 2017/3/27.
 */

public class MVPActivity extends MvpBaseActivity<MainView, MainPresenter> implements MainView {

    private ProgressBar progressBar;
    private TextView textView;
    private EditText editText;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mvp);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        textView = (TextView) findViewById(R.id.textView);
        editText = (EditText) findViewById(R.id.editText);
    }

    @NonNull
    @Override
    public MainPresenter createPresenter() {
        return new MainPresenter(this);
    }


    public void click_to_request(View view) {
        Editable text = editText.getText();
        getPresenter().request(text.toString());
    }

    public void click_to_change(View view) {
        getPresenter().change();
    }

    @Override
    public void showProgress() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void loadDataComplate(String loadedText) {
        textView.setText(loadedText);
        hideProgress();
    }

    @Override
    public void changeName(String chageText) {
        textView.setText(chageText);
        hideProgress();
    }
}
