package mx.edu.utez.tiendaproductos.repository;

import mx.edu.utez.tiendaproductos.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author,Long> {
}
