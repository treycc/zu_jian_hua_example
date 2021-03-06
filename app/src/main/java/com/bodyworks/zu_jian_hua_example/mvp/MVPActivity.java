package com.bodyworks.zu_jian_hua_example.mvp;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.Editable;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.bodyworks.zu_jian_hua_example.R;
import com.bodyworks.zu_jian_hua_example.mvp.base.MvpBaseActivity;
import com.bodyworks.zu_jian_hua_example.mvp.dagger.DaggerMainComponent;
import com.bodyworks.zu_jian_hua_example.mvp.dagger.MainComponent;
import com.bodyworks.zu_jian_hua_example.mvp.dagger.MainModule;
import com.bodyworks.zu_jian_hua_example.mvp.dagger.Person;
import com.bodyworks.zu_jian_hua_example.mvp.presenter.MainPresenter;
import com.bodyworks.zu_jian_hua_example.mvp.view.MainView;

import javax.inject.Inject;

/**
 * Created by treycc on 2017/3/27.
 */

public class MVPActivity extends MvpBaseActivity<MainView, MainPresenter> implements MainView {

    private ProgressBar progressBar;
    private TextView textView;
    private EditText editText;
    private MvpFragment mvpFragment;

    @Inject
    Person person;
    @Inject
    Person person2;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mvp);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        textView = (TextView) findViewById(R.id.textView);
        editText = (EditText) findViewById(R.id.editText);
        findViewById(R.id.imageButton).setVisibility(View.GONE);

//        MvpFragment mvpFragment = new MvpFragment();
//        getSupportFragmentManager().beginTransaction().add(R.id.container, mvpFragment)
//                .addToBackStack(null)
//                .commit();

        MainComponent component = DaggerMainComponent.builder().mainModule(new MainModule()).build();
        component.inject(this);
//        DaggerMainComponent.create().inject(this);

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
