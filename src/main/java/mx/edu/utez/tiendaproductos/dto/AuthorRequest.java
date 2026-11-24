package mx.edu.utez.tiendaproductos.dto;

import jakarta.persistence.UniqueConstraint;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.UniqueElements;

public record AuthorRequest(
        @NotBlank(message = "This can't be empty")
        @NotNull(message = "This can't be empty")
        String name,
        
        String email
) {
}
