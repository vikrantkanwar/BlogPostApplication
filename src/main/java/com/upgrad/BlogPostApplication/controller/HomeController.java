package com.upgrad.BlogPostApplication.controller;

import com.upgrad.BlogPostApplication.model.Post;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


import java.util.ArrayList;
import java.util.Date;

@Controller
public class HomeController {
    @RequestMapping("/")
    public String getAllPost(Model model) {
        ArrayList<Post> posts=new ArrayList<>();

        Post post1=new Post();
        post1.setTitle("Smartphones");
        post1.setBody("iPhones are not better than androids.");
        post1.setDate(new Date());


        Post post2=new Post();
        post2.setTitle("Beauty");
        post2.setBody("Selena Gomez has started her own make-up line.");
        post2.setDate(new Date());


        Post post3=new Post();
        post3.setTitle("Technology");
        post3.setBody("Tesla CEO is promoting SpaceX.");
        post3.setDate(new Date());

        posts.add(post1);
        posts.add(post2);
        posts.add(post3);

        model.addAttribute("posts",posts);
        return "index";
    }
}
