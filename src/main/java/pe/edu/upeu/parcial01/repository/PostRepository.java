package pe.edu.upeu.parcial01.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.upeu.parcial01.model.Post;
@Repository
public interface PostRepository extends JpaRepository<Post, Long>{

}
