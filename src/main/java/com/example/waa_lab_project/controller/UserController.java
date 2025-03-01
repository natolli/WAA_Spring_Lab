package com.example.waa_lab_project.controller;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.waa_lab_project.model.Comment;
import com.example.waa_lab_project.model.Post;
import com.example.waa_lab_project.model.User;
import com.example.waa_lab_project.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable long id) {
        return userService.getUserById(id);
    }

    @PostMapping("/")
    public void createUser(@RequestBody User user) {
        userService.createUser(user);
    }

    @GetMapping("/with-more-than/{n}-posts")
    public List<User> getUsersWithMoreThanNPosts(@PathVariable int n) {
        return userService.getUsersWithMoreThanNPosts(n);
    }

    @GetMapping("/posts/by-title")
    public List<Post> getPostsByTitle(@RequestParam String title) {
        return userService.getPostsByTitle(title);
    }

    @GetMapping("/{userId}/posts/{postId}/comments/{commentId}")
    public Comment getUserPostComment(@PathVariable long userId, @PathVariable long postId, @PathVariable long commentId) {
        return userService.getUserById(userId).getPosts().stream()
                .filter(p -> p.getId() == postId)
                .flatMap(p -> p.getComments().stream())
                .filter(c -> c.getId() == commentId)
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Comment not found"));
    }
}
