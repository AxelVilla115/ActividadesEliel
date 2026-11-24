package mx.edu.utez.tiendaproductos.controller;


import jakarta.validation.Valid;
import mx.edu.utez.tiendaproductos.dto.AuthorRequest;
import mx.edu.utez.tiendaproductos.dto.AuthorResponse;
import mx.edu.utez.tiendaproductos.model.Author;
import mx.edu.utez.tiendaproductos.service.AuthorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController()
@RequestMapping("/authors")
public class AuthorController {
    private final AuthorService service;

    public AuthorController(AuthorService service) {
        this.service = service;
    }

    public Author toEntity(AuthorRequest request){
        Author entity=new Author();
        entity.setEmail(request.email());
        entity.setUserName(request.name());
        return entity;
    }

    public AuthorResponse toResponse(Author author){
        return new AuthorResponse(author.getId(),author.getUserName(),author.getEmail());
    }

    @GetMapping
    public ResponseEntity<List<AuthorResponse>> getAll(){
        List<AuthorResponse> myList=new ArrayList<>();
        for(Author a : service.findAll()){
            myList.add(toResponse(a));
        }
        return ResponseEntity.ok().body(myList);
    }
    @GetMapping("/{id}")
    public ResponseEntity<AuthorResponse> findById(@PathVariable Long id){
        Optional<Author> search=service.findById(id);
        if(search.isPresent()){
            return ResponseEntity.ok().body(toResponse(search.get()));
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<AuthorResponse> save(@Valid @RequestBody AuthorRequest crear){
        Author created=service.save(toEntity(crear));
        return ResponseEntity.status(HttpStatus.CREATED).body(toResponse(created));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<AuthorResponse> update(@PathVariable Long id,@Valid @RequestBody AuthorRequest editar){
      Author upd=service.update(id,toEntity(editar));
      return ResponseEntity.status(HttpStatus.CREATED).body(toResponse(upd));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<AuthorResponse> delete(@PathVariable Long id){
        if(service.delete(id)){
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}
