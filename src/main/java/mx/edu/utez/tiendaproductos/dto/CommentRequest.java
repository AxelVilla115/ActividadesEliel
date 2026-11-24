package mx.edu.utez.tiendaproductos.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import mx.edu.utez.tiendaproductos.model.Author;
import org.springframework.boot.context.properties.bind.DefaultValue;

public record CommentRequest(
        @NotBlank(message = "This can't be empty")
        @NotNull(message = "This can't be empty")
        String date,
        @Max(500)
        String comment,
        @PositiveOrZero
        int rate,
        boolean isPublic,
        @NotNull(message = "This can't be empty")
        Author autor

) {
}
