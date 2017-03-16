package com.polytech.web;

import com.polytech.business.Post;
import com.polytech.business.PublicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
import java.util.Map;

/**
 * Created by Sergio on 15/03/2017.
 */

@Controller
public class ShareController {

    @Autowired
    PublicationService publicationService;

    @RequestMapping(value = "/share", method = RequestMethod.POST)
    public String sharePost(Post post){
        publicationService.post(post);
        return "redirect:/feed";
    }

    @RequestMapping(value = "/feed", method = RequestMethod.GET)
    public String readPost(Map model){
        List<Post> posts = publicationService.fetchAll();
        model.put("posts", posts);
        return "feed";
    }

}
