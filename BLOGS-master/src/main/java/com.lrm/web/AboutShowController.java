package com.lrm.web;

import com.lrm.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class AboutShowController {
    @Autowired
    BlogService blogService;

    @GetMapping("/about")
    public String about(Model model) {
        model.addAttribute("recommendBlogs", blogService.listRecommendBlogTop(5));


        //  System.out.println("进about+++"+user);
        return "about";
    }
}
