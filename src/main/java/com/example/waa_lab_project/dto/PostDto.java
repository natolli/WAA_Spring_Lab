package com.example.waa_lab_project.dto;

public class PostDto {
    private long id;
    private String title;
    private String content;
    private String author;

    // Constructors
    public PostDto() {}
    public PostDto(long id, String title, String content, String author) {
        this.id =id;
        this.title = title;
        this.content = content;
        this.author = author;
    }

    // Getters and Setters
    public long getId() { return id; } 
    public void setId(long id) { this.id = id; } 
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public String getContent() { return content; }
    public void setContent(String content) { this.content = content; }
    public String getAuthor() { return author; }
    public void setAuthor(String author) { this.author = author; }
}