package com.rudnev.Jnews.job;


import com.rudnev.Jnews.model.News;
import com.rudnev.Jnews.service.NewsService;
import org.hibernate.boot.model.source.internal.hbm.XmlElementMetadata;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.print.Doc;
import java.io.IOException;

@Component
public class ParseTask {
    @Autowired
    NewsService newsService;

    @Scheduled(fixedDelay = 1000)
    public void parseNewNews() {
        String url = "https://news.ycombinator.com/";

        try {
            Document doc = Jsoup.connect(url).userAgent("Yandex").timeout(5000).referrer("https://google.com").get();
            Elements news = doc.getElementsByClass("storylink");
            for (Element el:news){
                String title =el.ownText();
                if (!newsService.isExist(title)){
                    News obj = new News();
                    obj.setTitle(title);
                    newsService.save(obj);


                }//проверяем существует ли уже такая новсть
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }




}
