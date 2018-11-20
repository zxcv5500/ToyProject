package com.zxcv5500.toyproject.book.adltb.ch05.mvvm.model;

import java.security.acl.Owner;
import java.util.List;

/**
 * Created by zxcv5500 on 2018-08-27.
 */
public interface GitHubService {
    /**
     * API 액세스 결과가 이 클래스에 들어온다
     * GitHub의 리포지터리 목록이 들어있다
     * @see GitHubService#listRepos(String)
     */
    public static class Repositories {

        public final List<RepositoryItem> items;

        public Repositories(List<RepositoryItem> items) {
            this.items = items;
        }

    }

    /**
     * API 액세스 결과가 이 클래스에 들어온다
     * GitHub의 리포지터리 데이터가 들어있다
     * @see GitHubService#detailRepo(String, String)
     */
    public static class RepositoryItem {

        public final String description;
        public final Owner owner;
        public final String language;
        public final String name;
        public final String stargazers_count;
        public final String forks_count;
        public final String full_name;
        public final String html_url;


        public RepositoryItem(String description, Owner owner, String language, String name, String stargazers_count, String forks_count, String full_name, String html_url) {
            this.description = description;
            this.owner = owner;
            this.language = language;
            this.name = name;
            this.stargazers_count = stargazers_count;
            this.forks_count = forks_count;
            this.full_name = full_name;
            this.html_url = html_url;
        }
    }
}
