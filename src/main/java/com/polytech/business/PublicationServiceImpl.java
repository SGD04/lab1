package com.polytech.business;

import com.polytech.repository.PostRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by norabbit on 13/03/17.
 */
@Service
public class PublicationServiceImpl implements PublicationService {
    private PostRepository postRepository;

    public void post(Post post) {
        postRepository.save(post);
    }

    public List<Post> fetchAll(){
        return postRepository.findAll();
    }

    public PublicationServiceImpl(PostRepository postRepository){
        this.postRepository = postRepository;
    }
}
