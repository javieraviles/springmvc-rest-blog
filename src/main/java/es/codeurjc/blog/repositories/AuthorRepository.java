package es.codeurjc.blog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import es.codeurjc.blog.entities.Author;

public interface AuthorRepository extends JpaRepository<Author, Long> {
}
