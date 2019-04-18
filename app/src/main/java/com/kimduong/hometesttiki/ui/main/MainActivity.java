package com.kimduong.hometesttiki.ui.main;

import android.os.Bundle;
import android.widget.Toast;

import com.kimduong.hometesttiki.R;
import com.kimduong.hometesttiki.adapter.KeywordAdapter;

import java.util.List;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class MainActivity extends AppCompatActivity implements MainView {


    @BindView(R.id.rv_keyword)
    RecyclerView rvKeyword;
    private MainPresenter mainPresenter;
    private KeywordAdapter keywordAdapter;
    private Unbinder unbinder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    @Override
    protected void onResume() {
        super.onResume();
        mainPresenter.fetchKeyword();
    }

    private void initView() {
        unbinder = ButterKnife.bind(this);
        mainPresenter = new MainPresenter(this);
        keywordAdapter = new KeywordAdapter();
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(RecyclerView.HORIZONTAL);
        rvKeyword.setLayoutManager(layoutManager);
        rvKeyword.setAdapter(keywordAdapter);
    }

    @Override
    public void updateKeyWordList(List<String> strings) {
        keywordAdapter.setList(strings);
    }

    @Override
    public void showMessage(String string) {
        Toast.makeText(this, string, Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
        mainPresenter.destroy();
    }
}
