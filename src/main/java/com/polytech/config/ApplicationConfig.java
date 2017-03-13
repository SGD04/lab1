package com.polytech.config;

import com.polytech.business.PublicationService;
import com.polytech.business.PublicationServiceImpl;
import com.polytech.repository.PostRepository;
import com.polytech.repository.PostRepositoryImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by norabbit on 13/03/17.
 */
@Configuration
public class ApplicationConfig {

    @Bean
    public PostRepository postRepository(){
        return new PostRepositoryImpl();
    }

    @Bean
    public PublicationService publicationService(PostRepository postRepository){
        return new PublicationServiceImpl(postRepository);
    }
}
