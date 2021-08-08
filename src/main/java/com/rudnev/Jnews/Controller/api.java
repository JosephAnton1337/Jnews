package com.rudnev.Jnews.Controller;

import com.rudnev.Jnews.model.News;
import com.rudnev.Jnews.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
// возвращает все елементы которые есть в бд

@RestController
public class api {
    @Autowired
    NewsService newsService;

@GetMapping(value = "/news")
    public List<News> getAllNews(){
        return newsService.getAllNews();
    }

}
