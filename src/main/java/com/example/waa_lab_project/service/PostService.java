package com.example.waa_lab_project.service;

import com.example.waa_lab_project.dto.PostDto;
import com.example.waa_lab_project.model.Post;
import com.example.waa_lab_project.repository.PostRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PostService {
    private final PostRepository postRepository;
    private final ModelMapper modelMapper;

    public PostService(PostRepository postRepository, ModelMapper modelMapper) {
        this.postRepository = postRepository;
        this.modelMapper = modelMapper;
    }

    public List<PostDto> getAllPosts() {
        return postRepository.findAll().stream()
                .map(post -> modelMapper.map(post, PostDto.class))
                .collect(Collectors.toList());
    }

    public PostDto getPostById(long id) {
        Optional<Post> post = postRepository.findById(id);
        return post.map(value -> modelMapper.map(value, PostDto.class)).orElse(null);
    }

    public PostDto createPost(PostDto postDto) {
        Post post = modelMapper.map(postDto, Post.class);
        postRepository.save(post);
        return modelMapper.map(post, PostDto.class);
    }

    public void deletePost(long id) {
        postRepository.deleteById(id);
    }
}
