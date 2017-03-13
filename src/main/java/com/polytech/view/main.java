package com.polytech.view;

import com.polytech.business.Post;
import com.polytech.business.PublicationServiceImpl;
import com.polytech.repository.PostRepository;
import com.polytech.repository.PostRepositoryImpl;

import java.util.List;

/**
 * Created by norabbit on 13/03/17.
 */
public class main {

    public static void main(String[] args) {

        PostRepository postRepositoryImpl = new PostRepositoryImpl();

        System.out.println("Hello user");
        PublicationServiceImpl publicationServiceImpl = new PublicationServiceImpl(postRepositoryImpl);

        Post post = new Post("welcome to Luminy");
        publicationServiceImpl.post(post);

        List<Post> posts = publicationServiceImpl.fetchAll();
        System.out.println(posts);
    }
}
