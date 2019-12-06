package es.codeurjc.blog.entities;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonView;

@Entity
public class Post {

	public interface IdPost {
	}
	
	public interface BasicPost {
	}

	public interface DetailedPost {
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@JsonView(IdPost.class)
	private long id;

	@JsonView(BasicPost.class)
	private String title;

	@JsonView(BasicPost.class)
	private String content;

	@JsonView(DetailedPost.class)
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "post")
	private Set<Comment> comments;

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

	public Set<Comment> getComments() {
		return comments;
	}

	public void setComments(final Set<Comment> comments) {
		this.comments = comments;
	}

}
