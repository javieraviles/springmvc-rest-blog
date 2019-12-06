package es.codeurjc.blog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import es.codeurjc.blog.entities.Post;

public interface PostRepository extends JpaRepository<Post, Long> {
}
