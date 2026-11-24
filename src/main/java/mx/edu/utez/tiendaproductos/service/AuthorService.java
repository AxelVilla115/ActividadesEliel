package mx.edu.utez.tiendaproductos.service;

import mx.edu.utez.tiendaproductos.excepcion.ResourceNoFound;
import mx.edu.utez.tiendaproductos.model.Author;
import mx.edu.utez.tiendaproductos.repository.AuthorRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AuthorService {
    private final AuthorRepository repo;

    public AuthorService(AuthorRepository repo){
        this.repo=repo;
    }

    public Optional<Author> findById(Long id){
        return repo.findById(id);
    }

    public List<Author> findAll(){
        return repo.findAll();
    }

    public Author save(Author author){
        return repo.save(author);
    }

    public boolean delete(Long id){
        if(!repo.existsById(id)){
            return false;
        }
        repo.deleteById(id);
        return true;
    }

    public Author update(Long id,Author author){
       Author upd=repo.findById(id).orElseThrow(
               ()->new ResourceNoFound("Author not found by id:"+id)
       );
       upd.setUserName(author.getUserName());
       upd.setEmail(author.getEmail());
        return repo.save(upd);
    }


}
