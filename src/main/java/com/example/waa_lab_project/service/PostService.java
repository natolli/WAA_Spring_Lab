package com.example.waa_lab_project.service;

import java.util.List;
import com.example.waa_lab_project.dto.PostDto;

public interface PostService {
    List<PostDto> getAllPosts();
    PostDto getPostById(long id);
    void createPost(PostDto postDto);
    void deletePost(long id);
}
