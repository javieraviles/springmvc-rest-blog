package es.codeurjc.blog.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonView;

import es.codeurjc.blog.entities.Author.DetailedAuthor;

@Entity
public class Comment {

	public interface BasicComment {
	}

	public interface CommentAuthor {
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@JsonView(BasicComment.class)
	private long id;

	@JsonView(CommentAuthor.class)
	@ManyToOne
	@NotNull
	private Author author;

	@JsonView(BasicComment.class)
	private String content;

	@ManyToOne
	@JsonView(DetailedAuthor.class)
	private Post post;

	public long getId() {
		return id;
	}

	public void setId(final long id) {
		this.id = id;
	}

	public Author getAuthor() {
		return author;
	}

	public void setAuthor(final Author author) {
		this.author = author;
	}

	public String getContent() {
		return content;
	}

	public void setContent(final String content) {
		this.content = content;
	}

	public Post getPost() {
		return post;
	}

	public void setPost(Post post) {
		this.post = post;
	}

}
