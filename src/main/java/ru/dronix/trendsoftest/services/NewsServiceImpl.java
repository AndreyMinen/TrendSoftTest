package ru.dronix.trendsoftest.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.dronix.trendsoftest.dao.NewsDao;
import ru.dronix.trendsoftest.models.Category;
import ru.dronix.trendsoftest.models.News;

import java.util.List;

/**
 * Created by ADMIN on 08.02.2017.
 */
@Service
public class NewsServiceImpl implements NewsService {

    @Autowired
    private NewsDao newsDao;

    @Transactional
    public void addNews(News news) {
        this.newsDao.addNews(news);
    }

    @Transactional
    public void updateNews(News news) {
        this.newsDao.updateNews(news);
    }

    @Transactional
    public void deleteNews(int id) {
        this.newsDao.deleteNews(id);
    }

    @Transactional
    public News getNewsById(int id) {
        return this.newsDao.getNewsById(id);
    }

    @Transactional
    public List<News> getAllNews() {
        return this.newsDao.getAllNews();
    }

    @Transactional
    public List<News> searchNews(Category cat, String title, String descr) {
        return this.newsDao.searchNews(cat,title,descr);
    }
}
