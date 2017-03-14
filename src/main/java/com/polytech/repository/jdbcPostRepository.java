package com.polytech.repository;

import com.polytech.business.Post;

import javax.sql.DataSource;
import java.sql.*;
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
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO POST (CONTENT) VALUES(?)");
            preparedStatement.setString(1,post.getContent());
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public List<Post> findAll()
    {
        List<Post> allPosts = new ArrayList<Post>();

        try {
            Connection connection = dataSource.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT CONTENT FROM POST");

            while(resultSet.next()){
                String content = resultSet.getString("CONTENT");
                Post post = new Post(content);
                allPosts.add(post);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return allPosts;
    }
}
