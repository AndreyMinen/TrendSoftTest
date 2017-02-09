package ru.dronix.trendsoftest.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.dronix.trendsoftest.dao.CategoryDao;
import ru.dronix.trendsoftest.models.Category;

import java.util.List;

/**
 * Created by ADMIN on 08.02.2017.
 */
@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryDao categoryDao;

    @Transactional
    public List<Category> getAllCategory() {
        return this.categoryDao.getAllCategory();
    }

    @Transactional
    public Category getCategoryById(int id) {
        return this.categoryDao.getCategoryById(id);
    }
}
