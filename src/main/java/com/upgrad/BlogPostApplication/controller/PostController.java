package com.upgrad.BlogPostApplication.controller;

import com.upgrad.BlogPostApplication.model.Post;
import com.upgrad.BlogPostApplication.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class PostController {

    //IOC -> INVERSION OF CONTROL | DEPENDENCY INJECTION
    @Autowired
    private PostService postService;


    @RequestMapping("/posts")

    public String getUserPost(Model model){
        //PostService postService=new PostService();
        List<Post> posts = postService.getAllPosts();
        model.addAttribute("posts",posts);
        return "posts";

        //Agenda 1: Map the GET request to "/posts/newpost" -> to get the view of newpost
        //Agenda 2: Map the Post request to "/posts/create" -> to create the post for the user



    }
    @RequestMapping(method = RequestMethod.GET, value = "/posts/newpost")
    public String newPost(){
        return "posts/create";
    }
    @RequestMapping(method = RequestMethod.POST, value = "/posts/create")
    public String createNewPost(Post newPost){
        //PostService postService = new PostService();
        newPost.setDate(new Date());
        postService.createPost(newPost);
        return "redirect:/posts";
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/deletepost/{postId}")
    public String deletePost(@PathVariable Integer postId) {
        postService.deletePost(postId);
        return "redirect:/posts";
    }
}
