package com.polytech.config;

import com.polytech.business.PublicationService;
import com.polytech.business.PublicationServiceImpl;
import com.polytech.repository.PostRepository;
import com.polytech.repository.jdbcPostRepository;
import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

import javax.sql.DataSource;

/**
 * Created by norabbit on 13/03/17.
 */
@Configuration
@PropertySource("classpath:/application.properties")
public class ApplicationConfig {

    @Value("${datasource.driverName}")
    private String driverClassName;

    @Value("${datasource.url}")
    private String url;

    @Value("${datasource.username}")
    private String username;

    @Value("${datasource.password}")
    private String password;

    @Autowired
    private Environment environment;

    @Bean
    public DataSource dataSource() {
        String driverClassName = environment.getProperty("datasource.driverName");
        String url = environment.getProperty("datasource.url");
        String username = environment.getProperty("datasource.username");
        String password = environment.getProperty("datasource.password");

        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        dataSource.setUrl(url);
        dataSource.setDriverClassName(driverClassName);
        return dataSource;
    }

    //@Bean
    //public DataSource dataSource() {
    //    BasicDataSource dataSource = new BasicDataSource();
    //    dataSource.setUsername(username);
    //    dataSource.setPassword(password);
    //    dataSource.setUrl(url);
    //    dataSource.setDriverClassName(driverClassName);
    //    return dataSource;
    //}

    //@Bean
    //public DataSource dataSource(){
    //    return new EmbeddedDatabaseBuilder()
    //            .setType(EmbeddedDatabaseType.H2)
    //            .addScript("create-schema.sql")
    //            .build();
    //}

    //@Bean
    //public DataSource dataSource() {
    //    BasicDataSource dataSource = new BasicDataSource();
    //    dataSource.setUsername("root");
    //    dataSource.setPassword("root");
    //    dataSource.setUrl("jdbc:mysql://localhost:3306/bddpolytech");
    //    dataSource.setDriverClassName("com.mysql.jdbc.Driver");
    //    return dataSource;
    //}

    @Bean
    public PostRepository postRepository(){
        return new jdbcPostRepository(dataSource());
    }

    @Bean
    public PublicationService publicationService(PostRepository postRepository){
        return new PublicationServiceImpl(postRepository);
    }
}
