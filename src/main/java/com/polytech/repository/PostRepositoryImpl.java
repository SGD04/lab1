package com.polytech.repository;

import com.polytech.business.Post;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by norabbit on 13/03/17.
 */
public class PostRepositoryImpl implements PostRepository {

    private ArrayList<Post> db = new ArrayList<Post>();

    public void save(Post post) {
         db.add(post);
    }

    public List<Post> findAll() {
        return db;
    }
}
