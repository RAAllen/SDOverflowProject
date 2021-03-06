package com.skilldistillery.overflow.respositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.skilldistillery.overflow.entities.Post;

public interface PostRepository extends JpaRepository<Post, Integer> {
	
	@Query("SELECT p FROM Post p where p.user.id = :id")
	public List<Post> getPostsForUser(@Param("id")int id);
	
	public List<Post> findAllPostsByCategoryName(String name);
	
	public List<Post> findByNameContaining(String name);
	
}
