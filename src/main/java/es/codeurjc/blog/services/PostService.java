package es.codeurjc.blog.services;

import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Service;

import es.codeurjc.blog.models.Comment;
import es.codeurjc.blog.models.Post;

@Service
public class PostService {

	private Map<Long, Post> posts = new ConcurrentHashMap<>();
	private AtomicLong lastId = new AtomicLong();

	public Collection<Post> getPosts() {
		return posts.values();
	}

	public Post getPost(final Long postId) {
		return posts.get(postId);
	}

	public Post createPost(final Post post) {
		final Long newPostId = generateNextPostId();
		post.setId(newPostId);
		posts.put(newPostId, post);
		return post;
	}

	public Post updatePost(final Long postId, final Post post) {
		post.setId(postId);
		if (posts.containsKey(postId)) {
			posts.put(postId, post);
			return post;
		} else {
			return null;
		}
	}

	public Post deletePost(final Long postId) {
		if (posts.containsKey(postId)) {
			final Post postToBeRemoved = posts.get(postId);
			posts.remove(postId);
			return postToBeRemoved;
		} else {
			return null;
		}
	}

	public Post addCommentToPost(final Comment comment, final Long postId) {
		if (posts.containsKey(postId)) {
			final Post post = posts.get(postId);
			final Map<Long, Comment> postComments = post.getComments();
			final Long newCommentId = post.generateNextCommentId();
			comment.setId(newCommentId);
			postComments.put(newCommentId, comment);
			return post;
		} else {
			return null;
		}
	}

	public Post removeCommentFromPost(final Long postId, final Long commentId) {
		if (posts.containsKey(postId)) {
			final Post post = posts.get(postId);
			final Map<Long, Comment> postComments = post.getComments();
			postComments.remove(commentId);
			return post;
		} else {
			return null;
		}
	}

	private Long generateNextPostId() {
		return lastId.incrementAndGet();
	}

}
