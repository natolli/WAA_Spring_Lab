package com.example.waa_lab_project.service;

import com.example.waa_lab_project.dto.PostDto;
import com.example.waa_lab_project.model.Post;
import com.example.waa_lab_project.repository.PostRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostService {
    private final PostRepository postRepository;
    private final ModelMapper modelMapper;

    public PostServiceImpl(PostRepository postRepository, ModelMapper modelMapper) {
        this.postRepository = postRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<PostDto> getAllPosts() {
        return postRepository.findAll().stream()
                .map(post -> modelMapper.map(post, PostDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public PostDto getPostById(long id) {
        return postRepository.findById(id)
                .map(post -> modelMapper.map(post, PostDto.class))
                .orElseThrow(() -> new RuntimeException("Post not found"));
    }

    @Override
    public void createPost(PostDto postDto) {
        Post post = modelMapper.map(postDto, Post.class);
        post.setId(postRepository.getNextId());
        postRepository.save(post);
    }

    @Override
    public void deletePost(long id) {
        postRepository.deleteById(id);
    }
}