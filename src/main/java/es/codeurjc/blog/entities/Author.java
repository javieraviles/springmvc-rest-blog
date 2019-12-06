package es.codeurjc.blog.entities;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonView;

import es.codeurjc.blog.entities.Post.DetailedPost;

@Entity
public class Author {
	
	public interface DetailedAuthor {
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@JsonView(DetailedPost.class)
	private long id;

	@JsonView(DetailedPost.class)
	private String name;

	@JsonView(DetailedPost.class)
	private int age;

	@JsonView(DetailedAuthor.class)
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "author")
	private Set<Comment> comments;

	public long getId() {
		return id;
	}

	public void setId(final long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(final String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(final int age) {
		this.age = age;
	}

	public Set<Comment> getComments() {
		return comments;
	}

	public void setComments(final Set<Comment> comments) {
		this.comments = comments;
	}

}
