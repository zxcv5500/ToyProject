package com.zxcv5500.toyproject.book.adltb.ch05.mvvm.view;

import android.support.design.widget.CoordinatorLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Spinner;

import com.zxcv5500.toyproject.R;
import com.zxcv5500.toyproject.book.adltb.ch05.mvvm.contract.RepositoryListViewContract;
import com.zxcv5500.toyproject.book.adltb.ch05.mvvm.model.GitHubService;

/**
 * 리포지토리 목록을 표시하는 액티비티
 * MVVM의 뷰 역할을 한다.
 */
public class RepositoryListActivity extends AppCompatActivity implements RepositoryListViewContract {

    private Spinner languageSpinner;
    private CoordinatorLayout coordinatorLayout;

    //private RepositoryAdapter repositoryAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_repository_list);
    }

    @Override
    public void showRepositories(GitHubService.Repositories repositories) {

    }

    @Override
    public void showError() {

    }

    @Override
    public void startDetailActivity(String fullRepositoryName) {

    }
}
