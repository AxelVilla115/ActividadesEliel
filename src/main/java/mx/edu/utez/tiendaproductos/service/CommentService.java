package mx.edu.utez.tiendaproductos.service;

import mx.edu.utez.tiendaproductos.excepcion.ResourceNoFound;
import mx.edu.utez.tiendaproductos.model.Comment;
import mx.edu.utez.tiendaproductos.repository.CommentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CommentService {
    private final CommentRepository repo;

    public CommentService(CommentRepository repo) {
        this.repo = repo;
    }
    public Optional<Comment> findById(Long id){
        return repo.findById(id);
    }

    public List<Comment> getAll(){
        return repo.findAll();
    }

    public Comment save(Comment comment){
        return repo.save(comment);
    }

    public boolean delete(Long id){
       if(repo.existsById(id)){
           repo.deleteById(id);
           return true;
       }
        return false;
    }

    public Comment update(Long id,Comment coment){
        Comment comentario=repo.findById(id).orElseThrow(
                ()-> new ResourceNoFound("Comment not found with id"+id)
        );
        comentario.setComment(coment.getComment());
        comentario.setDate(coment.getDate());
        comentario.setPublic(coment.isPublic());
        comentario.setRate(coment.getRate());
        repo.save(comentario);
        return comentario;
    }

}
