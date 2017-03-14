package com.polytech.config;

import com.polytech.business.PublicationService;
import com.polytech.business.PublicationServiceImpl;
import com.polytech.repository.PostRepository;
import com.polytech.repository.jdbcPostRepository;
import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * Created by norabbit on 13/03/17.
 */
@Configuration
public class ApplicationConfig {

    //@Bean
    //public DataSource dataSource(){
    //    return new EmbeddedDatabaseBuilder()
    //            .setType(EmbeddedDatabaseType.H2)
    //            .addScript("create-schema.sql")
    //            .build();
    //}

    @Bean
    public DataSource dataSource() {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setUsername("root");
        dataSource.setPassword("root");
        dataSource.setUrl("jdbc:mysql://localhost:3306/bddpolytech");
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        return dataSource;
    }

    @Bean
    public PostRepository postRepository(){
        return new jdbcPostRepository(dataSource());
    }

    @Bean
    public PublicationService publicationService(PostRepository postRepository){
        return new PublicationServiceImpl(postRepository);
    }
}
