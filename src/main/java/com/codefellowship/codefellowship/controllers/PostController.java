package com.codefellowship.codefellowship.controllers;




import com.codefellowship.codefellowship.models.ApplicationUser;
import com.codefellowship.codefellowship.models.ApplicationUserRepository;
import com.codefellowship.codefellowship.models.PostRepository;
import com.codefellowship.codefellowship.models.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;
import sun.security.krb5.internal.ccache.CredentialsCache;

@Controller
public class PostController {

    @Autowired
    ApplicationUserRepository applicationUserRepository;

    @Autowired
    PostRepository postRepository;

    @PostMapping("/detailPage")
    public RedirectView createNewPost(String username, String body)    {
        ApplicationUser personWhoPosts = applicationUserRepository.findByUsername(username);
        Post newPost = new Post(personWhoPosts, body);
        postRepository.save(newPost);
        return new RedirectView("/userDetails" );


    }


}
