package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Post;
import com.example.demo.repos.PostRepository;

@Service
public class PostService {
	@Autowired
	PostRepository postRepository;

	public Post save(Post p) {
		return postRepository.save(p);
	}

	public List<Post> findAll() {
		return postRepository.findAll();
	}

	public Post findById(Integer id) {
		return postRepository.findById(id).get();
	}

	public void deleteById(Integer id) {
		postRepository.deleteById(id);
	}

	public void updatePost(int id,Post post) {

		Post post1 = postRepository.findById(id).get();
		post1.setTitle(post.getTitle());
		post1.set(machine.getRef());
		post1.setSalle(machine.getSalle());
		post1.setDateAchat(machine.getDateAchat());
		machinerepository.save(mch);
	}


}
