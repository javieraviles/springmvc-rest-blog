package es.codeurjc.blog.services;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.codeurjc.blog.entities.Author;
import es.codeurjc.blog.entities.Comment;
import es.codeurjc.blog.entities.Post;
import es.codeurjc.blog.repositories.AuthorRepository;
import es.codeurjc.blog.repositories.CommentRepository;
import es.codeurjc.blog.repositories.PostRepository;

@Service
public class PostService {

	@Autowired
	PostRepository postRepository;

	@Autowired
	CommentRepository commentRepository;

	@Autowired
	AuthorRepository authorRepository;

	public Collection<Post> getPosts() {
		return postRepository.findAll();
	}

	public Optional<Post> getPost(final Long postId) {
		final Optional<Post> post = postRepository.findById(postId);
		if (post.isPresent()) {
			post.get().getComments().size();
		}
		return post;
	}

	public Post createPost(final Post post) {
		return postRepository.save(post);
	}

	public Post updatePost(final Long postId, final Post post) {
		post.setId(postId);
		if (postRepository.findById(postId).isPresent()) {
			return postRepository.save(post);
		} else {
			return null;
		}
	}

	public Post deletePost(final Long postId) {
		final Optional<Post> postToBeRemoved = postRepository.findById(postId);
		if (postToBeRemoved.isPresent()) {
			postToBeRemoved.get().getComments().size();
			postRepository.deleteById(postId);
			return postToBeRemoved.get();
		} else {
			return null;
		}
	}

	public Post addCommentToPost(final Comment comment, final Long postId) {
		final Optional<Post> post = postRepository.findById(postId);
		if (post.isPresent()) {
			comment.setPost(post.get());
			post.get().getComments().add(comment);
			postRepository.save(post.get());
			return post.get();
		} else {
			return null;
		}
	}

	public Comment removeCommentFromPost(final Long postId, final Long commentId) {
		final Optional<Comment> comment = commentRepository.findByIdAndPostId(commentId, postId);
		if (comment.isPresent()) {
			commentRepository.deleteById(commentId);
			return comment.get();
		} else {
			return null;
		}
	}

	public Author createAuthor(final Author author) {
		return authorRepository.save(author);
	}
	
	public Optional<Author> getAuthor(final Long authorId) {
		final Optional<Author> author = authorRepository.findById(authorId);
		if (author.isPresent()) {
			author.get().getComments().size();
		}
		return author;
	}

}
