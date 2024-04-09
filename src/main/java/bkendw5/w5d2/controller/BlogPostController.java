package bkendw5.w5d2.controller;

import bkendw5.w5d2.entities.BlogPost;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import bkendw5.w5d2.services.BlogService;

import java.util.List;

@RestController
@RequestMapping("/blogposts")
public class BlogPostController {

    @Autowired
    private BlogService bs;

    @GetMapping
    private List<BlogPost> getAllBlogPosts(){
        return this.bs.getAllBlogsList();
    }

    @GetMapping("/getex")
    private String getEx(){
        return "GET";
    }
    @PostMapping("/postex")
    private String postEx(){
        return "POST";
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    private BlogPost saveBlogPost(@RequestBody BlogPost body){
        return this.bs.saveBlog(body);
    }

    @GetMapping("/{blogpostId}")
    private BlogPost findBlogPostById(@PathVariable int blogpostId){
        return this.bs.findById(blogpostId);
    }

    @PutMapping("/{blogpostId}")
    private BlogPost findBlogPostByIdAndUpdate(@PathVariable int blogpostId, @RequestBody BlogPost body){
        return this.bs.findByIdAndUpdate(blogpostId, body);
    }

    @DeleteMapping("/{blogpostId}")
    @ResponseStatus(HttpStatus.NO_CONTENT) // Status Code 204
    private void findBlogPostByIdAndDelete(@PathVariable int blogpostId){
        this.bs.DeleteFromId(blogpostId);
    }
}
