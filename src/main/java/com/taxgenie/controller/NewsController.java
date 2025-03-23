package com.taxgenie.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.taxgenie.model.NewsArticle;
import com.taxgenie.services.NewsService;

@Controller
public class NewsController {

	@Autowired
    private NewsService newsService;

    @GetMapping("/news")
    public String getNews(Model model) {
        List<NewsArticle> newsArticles = newsService.getFinancialNews();
        model.addAttribute("articles", newsArticles);
        return "news";
    }
}
