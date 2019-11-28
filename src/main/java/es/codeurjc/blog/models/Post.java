package es.codeurjc.blog.models;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

import com.fasterxml.jackson.annotation.JsonView;

public class Post {

	public interface Basic {
	}

	public interface WithComments {
	}

	@JsonView(Basic.class)
	private long id = -1;

	@JsonView(Basic.class)
	private String title;

	@JsonView(Basic.class)
	private String content;

	@JsonView(WithComments.class)
	private Map<Long, Comment> comments = new ConcurrentHashMap<>();

	private AtomicLong lastCommentId = new AtomicLong();

	public long getId() {
		return id;
	}

	public void setId(final long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(final String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(final String content) {
		this.content = content;
	}

	public Map<Long, Comment> getComments() {
		return comments;
	}

	public void setComments(final Map<Long, Comment> comments) {
		this.comments = comments;
	}

	public Long generateNextCommentId() {
		return lastCommentId.incrementAndGet();
	}

}
