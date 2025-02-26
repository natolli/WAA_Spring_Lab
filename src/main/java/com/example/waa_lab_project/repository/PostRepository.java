package com.example.waa_lab_project.repository;

import com.example.waa_lab_project.model.Post;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class PostRepository {
    private List<Post> posts = new ArrayList<>();
    private long idCounter = 1;

    public List<Post> findAll() {
        return posts;
    }

    public Optional<Post> findById(long id) {
        return posts.stream().filter(post -> post.getId() == id).findFirst();
    }

    public Post save(Post post) {
        post.setId(idCounter++);
        posts.add(post);
        return post;
    }

    public void deleteById(long id) {
        posts.removeIf(post -> post.getId() == id);
    }
}
