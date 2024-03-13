package com.narinder.posts.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.narinder.posts.entities.Posts;
import com.narinder.posts.exception.NoPostFound;
import com.narinder.posts.repositories.PostsRepository;

@Service
public class PostService {
	
	@Autowired
	PostsRepository repo;

	public List<Posts> getPostsByUsername(String username) {		
		List<Posts> findByUsername = repo.findByUsername(username);
		if(findByUsername.isEmpty()) {
			throw new NoPostFound("No post available with username : " + username);
		}
		return findByUsername;
	}

	public void save(Posts post) {
		repo.save(post);
	}

	public List<Posts> allPosts() {
		return repo.findAll();
	}

	public void deletePost(int id) {
		repo.deleteById(id);
	}

}
