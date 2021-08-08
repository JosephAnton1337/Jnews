package com.rudnev.Jnews.service;

import com.rudnev.Jnews.model.News;
import com.rudnev.Jnews.repository.NewsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NewsServiceImpl implements NewsService {
    @Autowired
    NewsRepository repository;
    @Override
    public void save(News news) {
        repository.save(news);

    }

    @Override
    public boolean isExist(String newsTitle) {
        List<News> news = repository.findAll();
        for (News n : news){
            if (n.getTitle().equals(newsTitle))
                return true;

        }
        return false;
    }

    @Override
    public List<News> getAllNews() {
        return repository.findAll();
    }
}
