package es.codeurjc.blog.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.codeurjc.blog.models.Comment;
import es.codeurjc.blog.models.Post;
import es.codeurjc.blog.services.PostService;

@RestController
@RequestMapping("/api/posts")
public class CommentsRestController {

	@Autowired
	PostService postService;

	@PostMapping("/{postId}/comments")
	public ResponseEntity<Post> createComment(@RequestBody final Comment comment, @PathVariable final long postId) {
		final Post post = postService.addCommentToPost(comment, postId);
		if (post != null) {
			return new ResponseEntity<>(post, HttpStatus.CREATED);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/{postId}/comments/{commentId}")
	public ResponseEntity<Post> deleteComment(@PathVariable final long postId, @PathVariable final long commentId) {
		final Post post = postService.removeCommentFromPost(postId, commentId);
		if (post != null) {
			return new ResponseEntity<>(post, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
}
