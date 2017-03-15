package com.polytech.web;

import com.polytech.business.Post;
import com.polytech.business.PublicationService;
import com.polytech.config.ApplicationConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

/**
 * Created by norabbit on 13/03/17.
 */
public class main {

    public static void main(String[] args) {

        System.out.println("Hello user");

        System.setProperty("spring.profiles.active","PROD");

        /*PostRepository postRepositoryImpl = new jdbcPostRepository();
        PublicationServiceImpl publicationServiceImpl = new PublicationServiceImpl(postRepositoryImpl);*/

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(ApplicationConfig.class);

        PublicationService publicationService = applicationContext.getBean(PublicationService.class);

        Post post = new Post("welcome to Polytech");
        publicationService.post(post);

        Post post2 = new Post("il fait chaud");
        publicationService.post(post2);

        Post post3 = new Post("j'ai envie de manger un burger");
        publicationService.post(post3);

        List<Post> posts = publicationService.fetchAll();
        System.out.println(posts);
    }
}
