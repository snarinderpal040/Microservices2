package com.narinder.posts.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.narinder.posts.entities.Posts;

public interface PostsRepository extends JpaRepository<Posts, Integer> {
	
	List<Posts> findByUsername(String username);

}
