package es.codeurjc.blog.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

import es.codeurjc.blog.controllers.PostController.FullPostView;
import es.codeurjc.blog.entities.Comment;
import es.codeurjc.blog.entities.Post;
import es.codeurjc.blog.services.PostService;

@RestController
@RequestMapping("/api/posts")
public class CommentController {

	@Autowired
	PostService postService;

	@JsonView(FullPostView.class)
	@PostMapping("/{postId}/comments")
	public ResponseEntity<Post> createComment(@Valid @RequestBody final Comment comment, @PathVariable final long postId) {
		final Post post = postService.addCommentToPost(comment, postId);
		if (post != null) {
			return new ResponseEntity<>(post, HttpStatus.CREATED);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@JsonView(FullPostView.class)
	@DeleteMapping("/{postId}/comments/{commentId}")
	public ResponseEntity<Comment> deleteComment(@PathVariable final long postId, @PathVariable final long commentId) {
		final Comment comment = postService.removeCommentFromPost(postId, commentId);
		if (comment != null) {
			return new ResponseEntity<>(comment, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
}
