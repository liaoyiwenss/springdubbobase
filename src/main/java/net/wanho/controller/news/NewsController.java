package net.wanho.controller.news;

import net.wanho.pojo.News;
import net.wanho.service.news.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/news")
public class NewsController {


    @Autowired
    private NewsService newsService;

    @RequestMapping("/init")
    @ResponseBody
    public Object init(HttpSession session){

        List<News> newslist = newsService.selectnewsList();
        return newslist;
    }
}
