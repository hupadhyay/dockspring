package in.himtech.learn.dockspring.restclient.controller;

import in.himtech.learn.dockspring.restclient.model.Post;
import in.himtech.learn.dockspring.restclient.service.PostService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/posts")
public class PostController {
    private final PostService postService;

    public PostController(PostService postService){
        this.postService = postService;
    }

    @GetMapping()
    List<Post> getAllPosts(){
        return this.postService.getAllPosts();
    }

    @GetMapping("/{id}")
    Post getPostById(@PathVariable Integer id){
        return this.postService.getPostById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    Post create(@RequestBody Post post){
        return this.postService.createPost(post);
    }

    @PutMapping("/{id}")
    Post update(@PathVariable Integer id, @RequestBody Post post){
        return this.postService.updatePost(id, post);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void delete(@PathVariable Integer id){
        this.postService.deletePost(id);
    }

}
