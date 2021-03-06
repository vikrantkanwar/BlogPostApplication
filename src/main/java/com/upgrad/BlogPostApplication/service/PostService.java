package com.upgrad.BlogPostApplication.service;

import com.upgrad.BlogPostApplication.model.Post;
import com.upgrad.BlogPostApplication.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Service
public class PostService {

    //USING JPA - COMMUNICATE | EntityManagerFactory -> EntityManager
    @Autowired
    private PostRepository postRepository;

    public List<Post> getAllPosts(){
        return postRepository.getAllPosts();
    }

    public void createPost(Post newPost) {
        postRepository.createPost(newPost);
    }

    public void deletePost(Integer postId) {
        postRepository.deletePost(postId);
    }
}
