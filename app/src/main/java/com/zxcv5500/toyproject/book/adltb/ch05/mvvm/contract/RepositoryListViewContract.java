package com.zxcv5500.toyproject.book.adltb.ch05.mvvm.contract;

import com.zxcv5500.toyproject.book.adltb.ch05.mvvm.model.GitHubService;

/**
 * Created by zxcv5500 on 2018-08-27.
 */
public interface RepositoryListViewContract {
    void showRepositories(GitHubService.Repositories repositories);

    void showError();

    void startDetailActivity(String fullRepositoryName);


}
