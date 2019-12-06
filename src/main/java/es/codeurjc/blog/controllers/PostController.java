package es.codeurjc.blog.controllers;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

import es.codeurjc.blog.entities.Comment;
import es.codeurjc.blog.entities.Post;
import es.codeurjc.blog.services.PostService;

@RestController
@RequestMapping("/api/posts")
public class PostController {

	@Autowired
	PostService postService;
	
	interface GeneralPostView extends Post.IdPost, Post.BasicPost {
	}

	interface FullPostView extends Post.IdPost, Post.BasicPost, Post.DetailedPost, Comment.BasicComment, Comment.CommentAuthor {
	}

	@JsonView(GeneralPostView.class)
	@GetMapping("/")
	public ResponseEntity<Collection<Post>> getPosts() {
		return new ResponseEntity<>(postService.getPosts(), HttpStatus.OK);
	}

	@JsonView(FullPostView.class)
	@GetMapping("/{postId}")
	public ResponseEntity<Post> getPost(@PathVariable final long postId) {

		final Optional<Post> post = postService.getPost(postId);

		if (post.isPresent()) {
			return new ResponseEntity<>(post.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@JsonView(FullPostView.class)
	@PostMapping("/")
	public ResponseEntity<Post> createPost(@RequestBody final Post post) {
		return new ResponseEntity<>(postService.createPost(post), HttpStatus.CREATED);
	}

	@JsonView(FullPostView.class)
	@PutMapping("/{postId}")
	public ResponseEntity<Post> updatePost(@PathVariable final long postId, @RequestBody final Post updatedPost) {

		final Post post = postService.updatePost(postId, updatedPost);

		if (post != null) {
			return new ResponseEntity<>(post, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@JsonView(FullPostView.class)
	@DeleteMapping("/{postId}")
	public ResponseEntity<Post> deletePost(@PathVariable final long postId) {

		final Post post = postService.deletePost(postId);

		if (post != null) {
			return new ResponseEntity<>(post, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

}
