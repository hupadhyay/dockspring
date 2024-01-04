package in.himtech.learn.dockspring.restclient.service;

import in.himtech.learn.dockspring.restclient.model.Post;
import jdk.jfr.MemoryAddress;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.List;

@Service
public class PostService {

    private final RestClient restClient;

    public PostService(){
        this.restClient = RestClient.builder()
                .baseUrl("https://jsonplaceholder.typicode.com")
                .build();
    }
    public List<Post> getAllPosts() {
        return this.restClient.get()
                .uri("/posts")
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .body(new ParameterizedTypeReference<List<Post>>() {});
    }

    public Post getPostById(Integer id) {
        return this.restClient.get()
                .uri("/posts/{id}", id)
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .body(Post.class);
    }

    public Post createPost(Post post) {
        return this.restClient.post()
                .uri("/posts")
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON)
                .body(post)
                .retrieve()
                .body(Post.class);
    }

    public Post updatePost(Integer id, Post post) {
        return this.restClient.put()
                .uri("/posts/{id}", id)
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON)
                .body(post)
                .retrieve()
                .body(Post.class);
    }

    public void deletePost(Integer id) {
        this.restClient.delete()
                .uri("posts/{id}", id)
                .retrieve()
                .toBodilessEntity();
    }
}
