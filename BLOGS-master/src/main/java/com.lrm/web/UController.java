package com.lrm.web;

import com.lrm.po.Blog;
import com.lrm.po.User;
import com.lrm.service.UImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/mybatis")
public class UController {
    @Autowired
    UImpl u;

    @RequestMapping("/m")
    public String goGo(){
        System.out.println("inin");
        List<User> users = u.getAllUsers1();
        for (User user : users) {
            System.out.println(user);
        }
//        u.insertUer();
        return "tmarkdown";
    }

    @RequestMapping("/insert")
    public String insert(Blog blog, Model model){
        System.out.println("Content:");
        System.out.println(blog.getContent());
        model.addAttribute("content",blog.getContent());
        return "getmarkdown";
    }

}
