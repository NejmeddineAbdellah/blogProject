package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Post;
import com.example.demo.service.PostService;

@RestController
@RequestMapping("/post")
public class PostController {
	@Autowired
	PostService postService;

	@PostMapping("/save")
	public Post save(@RequestBody Post p) {
		return postService.save(p);
	}

	@GetMapping("/all")
	public List<Post> findAll() {
		return postService.findAll();
	}

	@GetMapping("/findbytitle/{title}")
	public List<Post> findByTitle(@PathVariable String title) { return postService.findByTitle(title); }

	@GetMapping("/findbyid/{id}")
	public Post findById(@PathVariable Integer id) {
		return postService.findById(id);
	}

	@DeleteMapping("/delete/{id}")
	public void deleteById(@PathVariable Integer id) {
		postService.deleteById(id);
	}
	
	@PutMapping("/update/{id}")
	public Post save(@RequestBody Post p,@PathVariable int id) {
		 Post post = postService.findById(id);
	        if (post != null) {
	        	 if (p.getTitle() != null) {
	 	            post.setTitle(p.getTitle());

	             }
	        	 if (p.getDescription() != null) {
	            post.setDescription(p.getDescription());
	        	 }
	        	 if(p.getImage() != null) {
	        		 post.setImage(p.getImage());
	        	 }
	        	 if(p.getTag() != null) {
	        		 post.setTag(p.getTag());
	        	 }
	            return postService.save(post);
	        }
	        return null;	}
	


}
