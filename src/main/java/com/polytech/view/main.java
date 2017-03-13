package com.polytech.view;

import com.polytech.business.Post;
import com.polytech.business.PublicationService;
import com.polytech.repository.PostRepository;

import java.util.List;

/**
 * Created by norabbit on 13/03/17.
 */
public class main {

    private static String content;

    public static void main(String[] args) {

        PostRepository postRepository = new PostRepository();
        System.out.println("Hello user");
        PublicationService publicationService = new PublicationService(postRepository);

        Post post = new Post("welcome to Luminy");
        publicationService.post(post);

        List<Post> posts = publicationService.fetchAll();
        System.out.println(posts);
    }
}
