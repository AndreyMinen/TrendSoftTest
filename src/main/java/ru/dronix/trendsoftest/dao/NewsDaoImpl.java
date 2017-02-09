package ru.dronix.trendsoftest.dao;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.dronix.trendsoftest.models.Category;
import ru.dronix.trendsoftest.models.News;

import java.util.Date;
import java.util.List;

/**
 * Created by ADMIN on 08.02.2017.
 */
@Repository
public class NewsDaoImpl implements NewsDao {

    private Logger log=Logger.getLogger(NewsDaoImpl.class);
    private Date date=new Date();
    private List<News> listNews;

    @Autowired
    private SessionFactory sessionFactory;

    public void addNews(News news) {
        Session session=this.sessionFactory.getCurrentSession();
        news.setDate_publish(date);
        session.persist(news);
        log.info("Добавлена новость: "+news);
    }

    public void updateNews(News news) {
        Session session=this.sessionFactory.getCurrentSession();
        news.setDate_publish(date);
        session.update(news);
        log.info("Новость обновлена: "+news);
    }

    public void deleteNews(int id) {
        Session session=this.sessionFactory.getCurrentSession();
        News news=getNewsById(id);
        session.delete(news);
        log.info("Новость удалена: "+news);
    }

    public News getNewsById(int id) {
        Session session=this.sessionFactory.getCurrentSession();
        News news=(News)session.load(News.class,new Integer(id));
        log.info("Получена новость по id: "+news);

        return news;
    }

    public List<News> getAllNews() {
        Session session=this.sessionFactory.getCurrentSession();
        listNews=(List<News>)session.createCriteria(News.class).list();
        log.info("получен список всех новостей. В списке: "+listNews.size());

        return listNews;
    }

    public List<News> searchNews(Category cat, String title, String descr) {
        Session session=this.sessionFactory.getCurrentSession();

        String query="SELECT * FROM trendsoft_test.news WHERE descr LIKE '%"+descr+"%' AND title LIKE '%"+title+"%' AND category_id='"+cat.getId()+"'";

        listNews=session.createSQLQuery(query).addEntity(News.class).list();



        log.info("Получен список по фильтру. В списке: "+listNews.size());

        return listNews;
    }
}
