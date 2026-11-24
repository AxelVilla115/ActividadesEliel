package mx.edu.utez.tiendaproductos.controller;

import jakarta.validation.Valid;
import mx.edu.utez.tiendaproductos.dto.CommentRequest;
import mx.edu.utez.tiendaproductos.dto.CommentResponse;
import mx.edu.utez.tiendaproductos.model.Comment;
import mx.edu.utez.tiendaproductos.service.CommentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController()
@RequestMapping("/comments")
public class CommentController {
    private CommentService service;

    public CommentController(CommentService service){
        this.service=service;
    }

    public Comment toEntity(CommentRequest request){
        Comment entity=new Comment();
        entity.setAutor(request.autor());
        entity.setPublic(true);
        entity.setRate(request.rate());
        entity.setComment(request.comment());
        entity.setDate(request.date());
        return entity;
    }

    public CommentResponse toResponse(Comment comentario){
        return new CommentResponse(comentario.getId(),comentario.getComment(),comentario.getDate(),comentario.getRate(),comentario.isPublic(),comentario.getAutor());
    }

    @GetMapping
    public ResponseEntity<List<CommentResponse>> getAll(){
        List<CommentResponse> myList=new ArrayList();
        for(Comment com:service.getAll()){
            myList.add(toResponse(com));
        }
        return ResponseEntity.ok(myList);
    }

    @GetMapping("{id}")
    public ResponseEntity<CommentResponse> findById(@PathVariable Long id){
        Optional<Comment> coment=service.findById(id);
        if(coment.isPresent()){
           return ResponseEntity.ok(toResponse(coment.get()));
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<CommentResponse> save(@Valid @RequestBody CommentRequest coment){
        Comment comentario=service.save(toEntity(coment));
        return ResponseEntity.status(HttpStatus.CREATED).body(toResponse(comentario));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<CommentResponse> update(@PathVariable Long id,@Valid@RequestBody CommentRequest coment){
        Comment update=service.update(id,toEntity(coment));
            return ResponseEntity.status(HttpStatus.CREATED).body(toResponse(update));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<CommentResponse> delete(@PathVariable Long id){
        boolean existe=service.delete(id);
        if(existe){
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();

    }

}
