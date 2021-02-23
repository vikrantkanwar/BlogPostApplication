package com.upgrad.BlogPostApplication.service;

import com.upgrad.BlogPostApplication.model.User;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    //contain all the business logic and communicate with database
    public boolean login(User user) {
        if (user.getUsername().equals("ashish_kumar") && user.getPassword().equals("chitkara"))
            return true;
        else
            return false;
    }
}
