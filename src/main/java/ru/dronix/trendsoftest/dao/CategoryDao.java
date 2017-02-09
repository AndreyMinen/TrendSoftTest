package ru.dronix.trendsoftest.dao;

import ru.dronix.trendsoftest.models.Category;

import java.util.List;

/**
 * Created by ADMIN on 08.02.2017.
 */
public interface CategoryDao {

    List<Category> getAllCategory();

    Category getCategoryById(int id);

}
