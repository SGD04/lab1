package com.polytech.repository;

import com.polytech.business.Post;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by norabbit on 13/03/17.
 */
public class jdbcPostRepository implements PostRepository {

    private DataSource dataSource;

    private ArrayList<Post> db = new ArrayList<Post>();

    public jdbcPostRepository(DataSource dataSource) {
        this.dataSource = dataSource;
    }


    public void save(Post post)
    {
        try{
            Connection connection = dataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO POST VALUES(?)");
            preparedStatement.setString(1,post.getContent());
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public List<Post> findAll()
    {
        return db;
    }
}
