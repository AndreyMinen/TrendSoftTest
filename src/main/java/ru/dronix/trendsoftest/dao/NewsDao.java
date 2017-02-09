package ru.dronix.trendsoftest.dao;

import ru.dronix.trendsoftest.models.Category;
import ru.dronix.trendsoftest.models.News;

import java.util.List;

/**
 * Created by ADMIN on 08.02.2017.
 */
public interface NewsDao {

    void addNews(News news);

    void updateNews(News news);

    void deleteNews(int id);

    News getNewsById(int id);

    List<News> getAllNews();

    List<News> searchNews(Category cat,String str);


}
