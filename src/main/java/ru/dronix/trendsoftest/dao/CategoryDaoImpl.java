package ru.dronix.trendsoftest.dao;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.dronix.trendsoftest.models.Category;

import java.util.List;

/**
 * Created by ADMIN on 08.02.2017.
 */
@Repository
public class CategoryDaoImpl implements CategoryDao {

    private Logger log=Logger.getLogger(CategoryDaoImpl.class);
    private List<Category> listCategory;

    @Autowired
    private SessionFactory sessionFactory;

    public List<Category> getAllCategory() {
        Session session=this.sessionFactory.getCurrentSession();
        listCategory=(List<Category>)session.createCriteria(Category.class).list();
        log.info("Получен список категорий. В списке: "+listCategory.size());
        return listCategory;
    }

    public Category getCategoryById(int id) {
        Session session=this.sessionFactory.getCurrentSession();
        Category category=(Category)session.load(Category.class,new Integer(id));
        log.info("Получена категория по id: "+category);
        return category;
    }
}
