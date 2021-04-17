package com.lrm.web;

import com.lrm.dao.BlogRepository;
import com.lrm.po.Blog;
import com.lrm.po.Tag;
import com.lrm.service.BlogService;
import com.lrm.service.TagService;
import com.lrm.vo.BlogQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpSession;
import java.util.List;


@Controller
public class TagShowController {

    BlogRepository repository;

    @Autowired
    private TagService tagService;

    @Autowired
    private BlogService blogService;

    @GetMapping("/tags/{id}")
    public String tags(@PageableDefault(size = 8, sort = {"updateTime"}, direction = Sort.Direction.DESC) Pageable pageable,
                       @PathVariable Long id, Model model, BlogQuery blog, HttpSession session) {
        System.out.println("tag gg");
        List<Tag> tags = tagService.listTagTop(10000);
        if (id == -1) {
            if(tags.size()!=0)
           id = tags.get(0).getId();
        }
        model.addAttribute("tags", tags);
        model.addAttribute("page", blogService.listBlog(pageable,blog));
        model.addAttribute("activeTagId", id);
        return "tags";
    }



    @GetMapping("/tagsBlogList/{id}")
    public String tagsBlogList(@PageableDefault(size = 8, sort = {"updateTime"}, direction = Sort.Direction.DESC) Pageable pageable,
                       @PathVariable Long id, Model model, BlogQuery blog, HttpSession session) {
        System.out.println("tagBlogList");
        System.out.println(id);
        List<Tag> tags = tagService.listTagTop(10000);
        model.addAttribute("tags", tags);
        model.addAttribute("page", blogService.idexTagBlogList(pageable,id));
        model.addAttribute("activeTagId", id);
        return "tags";
    }


}
