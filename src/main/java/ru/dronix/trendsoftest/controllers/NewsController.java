package ru.dronix.trendsoftest.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.dronix.trendsoftest.models.Category;
import ru.dronix.trendsoftest.models.News;
import ru.dronix.trendsoftest.services.CategoryService;
import ru.dronix.trendsoftest.services.NewsService;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by ADMIN on 08.02.2017.
 */
@Controller
public class NewsController {

    @Autowired
    private NewsService newsService;

    @Autowired
    private CategoryService categoryService;

    @RequestMapping(value = {"/","index"})
    public String index(Model model){
        model.addAttribute("newsList",this.newsService.getAllNews());
        model.addAttribute("categories",this.categoryService.getAllCategory());
        model.addAttribute("news",new News());

        return "index";
    }

    @RequestMapping(value = "/search",method = RequestMethod.GET)
    public String search(HttpServletRequest request,Model model){
        Category cat=this.categoryService.getCategoryById(Integer.parseInt(request.getParameterValues("sel_cat")[0]));
        String title=request.getParameterValues("search_title")[0];
        String desc=request.getParameterValues("search_descr")[0];


        model.addAttribute("categories", this.categoryService.getAllCategory());
        model.addAttribute("newsList",this.newsService.searchNews(cat,title,desc));
        model.addAttribute("news",new News());


        return "index";
    }

    @RequestMapping(value = "/news/add",method = RequestMethod.POST)
    public String addNews(@ModelAttribute("news")News news,HttpServletRequest request){
        news.setCategory_id(this.categoryService.getCategoryById(Integer.parseInt(request.getParameterValues("sel_cat")[0])));
        if(news.getId()==null){
            this.newsService.addNews(news);
        }else{
            this.newsService.updateNews(news);
        }



        return "redirect:/index";
    }

    @RequestMapping(value = "/remove/{id}")
    public String deleteNews(@PathVariable("id")int id){
        this.newsService.deleteNews(id);

        return "redirect:/index";
    }

    @RequestMapping(value = "/edit/{id}")
    public String deleteNews(@PathVariable("id")int id,Model model){
        model.addAttribute("news",this.newsService.getNewsById(id));
        model.addAttribute("newsList",this.newsService.getAllNews());
        model.addAttribute("categories",this.categoryService.getAllCategory());


        return "index";
    }

}
