package mx.edu.utez.tiendaproductos.repository;

import mx.edu.utez.tiendaproductos.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}
