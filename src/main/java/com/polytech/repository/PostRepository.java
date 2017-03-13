package com.polytech.repository;

import com.polytech.business.Post;

import java.util.List;

/**
 * Created by norabbit on 13/03/17.
 */
public interface PostRepository {
    void save(Post post);

    List<Post> findAll();
}
