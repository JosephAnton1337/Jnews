package com.rudnev.Jnews.service;

import com.rudnev.Jnews.model.News;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface NewsService {
    public void save(News news);//сохранение новости,если название новости совпадает мы ее сохраняем
    public boolean isExist(String newsTitle);//проверка на существующую новость
    public List<News> getAllNews();//показываем все новости которые есть в БД
}
