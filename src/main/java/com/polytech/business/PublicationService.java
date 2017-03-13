package com.polytech.business;

import com.polytech.repository.PostRepository;

import java.util.List;

/**
 * Created by norabbit on 13/03/17.
 */
public class PublicationService {
    private PostRepository postRepository;

    public void post(Post post) {
        postRepository.save(post);
    }

    public List<Post> fetchAll(){
        return postRepository.findAll();
    }

    public PublicationService(PostRepository postRepository){
        this.postRepository = postRepository;
    }
}
