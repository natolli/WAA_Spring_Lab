package com.example.waa_lab_project.service;

import java.util.List;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.example.waa_lab_project.aspect.ExecutionTime;
import com.example.waa_lab_project.model.Post;
import com.example.waa_lab_project.model.User;
import com.example.waa_lab_project.repository.ExceptionLogRepository;
import com.example.waa_lab_project.repository.LoggerRepository;
import com.example.waa_lab_project.repository.PostRepository;
import com.example.waa_lab_project.repository.UserRepository;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final PostRepository postRepository;
    private final LoggerRepository loggerRepository;
    private final ExceptionLogRepository exceptionLogRepository;

    public UserService(UserRepository userRepository, PostRepository postRepository, LoggerRepository loggerRepository, ExceptionLogRepository exceptionLogRepository) {
        this.userRepository = userRepository;
        this.postRepository = postRepository;
        this.loggerRepository = loggerRepository;
        this.exceptionLogRepository = exceptionLogRepository;
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @ExecutionTime
    public User getUserById(long id) {
        return userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
    }

    public void createUser(User user) {
        userRepository.save(user);
    }

    public List<User> getUsersWithMoreThanNPosts(int n) {
        return userRepository.findUsersWithMoreThanNPosts(n);
    }

    public List<Post> getPostsByTitle(String title) {
        return postRepository.findByTitleContaining(title);
    }

    public void createPost(Post post) {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
        post.setUser(user);
        postRepository.save(post);
    }
}