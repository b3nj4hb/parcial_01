package pe.edu.upeu.parcial01.service;

import java.util.List;

import pe.edu.upeu.parcial01.model.Post;

public interface SPost {
	Post create(Post post);
	List<Post> readAll();
	Post read(Long id);
	void delete(Long id);
	Post update(Post al);
}
