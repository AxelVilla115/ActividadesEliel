package mx.edu.utez.tiendaproductos.dto;

import mx.edu.utez.tiendaproductos.model.Author;

public record CommentResponse(
        Long id,
        String comment,
        String date,
        int rate,
        boolean isPublic,
        Author autor
) {
}
