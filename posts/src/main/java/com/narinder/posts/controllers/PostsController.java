package com.narinder.posts.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.narinder.posts.entities.Posts;
import com.narinder.posts.service.PostService;

@RestController
public class PostsController {
	
	@Autowired
	PostService service;
	
	@GetMapping("posts/{username}")
	public List<Posts> getPostsByNmae(@PathVariable String username){
		return service.getPostsByUsername(username);
	}
	
	@PostMapping("posts")
	public void post(@RequestBody Posts post) {
		service.save(post);
	}
	
	@GetMapping("posts")
	public List<Posts> getAllPosts(){
		return service.allPosts();
	}
	
	@DeleteMapping("posts/{id}")
	public void deletePost(@PathVariable int id) {
		service.deletePost(id);
	}

}
