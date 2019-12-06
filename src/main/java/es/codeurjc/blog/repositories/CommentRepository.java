package es.codeurjc.blog.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import es.codeurjc.blog.entities.Comment;

public interface CommentRepository extends JpaRepository<Comment, Long> {
	Optional<Comment> findByIdAndPostId(Long id, Long postId);
}
