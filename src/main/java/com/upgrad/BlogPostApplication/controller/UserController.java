package com.upgrad.BlogPostApplication.controller;


import com.upgrad.BlogPostApplication.model.Post;
import com.upgrad.BlogPostApplication.model.User;
import com.upgrad.BlogPostApplication.service.PostService;
import com.upgrad.BlogPostApplication.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;


@Controller
public class UserController {

    private UserService userService = new UserService();
    private PostService postService =new PostService();

    //GET request to "/users/login"
    @RequestMapping(method = RequestMethod.GET, value="/users/login")
    public String login(Model model){
        model.addAttribute("user",new User());
        return "users/login";
    }

    //POST request to "/users/login"
    @RequestMapping(method = RequestMethod.POST, value = "/users/login")
    public String loginUser(User user){
        //check if he credentials match
        if(userService.login(user)){
            return "redirect:/posts";
        }
        else{
            return "redirect:users/login";
        }
    }

    //Agenda 3: Create the User registration
    //Registration -> "/users/registration"
    //logout -> "/users/logout"

    @RequestMapping(method = RequestMethod.GET, value = "/users/registration")
    public String registration(){
        return "users/registration";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/users/registration")
    public String userRegistration(User user){
        //business logic to save the credentials of the user to the given database

        return "redirect:/users/login";
    }

    @RequestMapping("/users/logout")
    public String userLogout(Model model){

        List<Post> posts=postService.getAllPosts();
        model.addAttribute("posts",posts);
        return "redirect:/";

    }
}
