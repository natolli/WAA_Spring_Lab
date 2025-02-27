package com.example.waa_lab_project.repository;

import com.example.waa_lab_project.model.Post;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class PostRepository {
    private final List<Post> posts = new ArrayList<>();
    private long idCounter = 1;
    private static final Logger logger = LogManager.getLogger(PostRepository.class);

    public List<Post> findAll() {
        return posts;
    }

    public Optional<Post> findById(long id) {
        return posts.stream().filter(p -> p.getId() == id).findFirst();
    }

    public long getNextId() {
        return idCounter++;
    }

    public void save(Post post) {
        post.setId(idCounter++);
       logger.info("Hello");
       logger.info(post);
       logger.info("Hello");
        posts.add(post);
    }

    public void deleteById(long id) {
        posts.removeIf(post -> post.getId() == id);
    }
}