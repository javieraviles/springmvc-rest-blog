package es.codeurjc.blog.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

import es.codeurjc.blog.controllers.PostController.FullPostView;
import es.codeurjc.blog.entities.Author;
import es.codeurjc.blog.entities.Comment;
import es.codeurjc.blog.entities.Post;
import es.codeurjc.blog.services.PostService;

@RestController
@RequestMapping("/api/authors")
public class AuthorController {

	@Autowired
	PostService postService;
	
	interface FullAuthorView extends Post.IdPost, Comment.BasicComment, Author.DetailedAuthor {
	}


	@JsonView(Post.DetailedPost.class)
	@PostMapping("/")
	public ResponseEntity<Author> createAuthor(@RequestBody final Author author) {
		return new ResponseEntity<>(postService.createAuthor(author), HttpStatus.CREATED);
	}

	@JsonView(FullAuthorView.class)
	@GetMapping("/{authorId}/comments")
	public ResponseEntity<Author> deleteComment(@PathVariable final long authorId) {
		final Optional<Author> author = postService.getAuthor(authorId);
		if (author.isPresent()) {
			return new ResponseEntity<>(author.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
}
