package com.example.demo.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.Post;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Integer>{

    List<Post> findByTitle(String title);

}
