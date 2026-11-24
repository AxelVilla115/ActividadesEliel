package mx.edu.utez.tiendaproductos.model;

import jakarta.persistence.*;
import org.hibernate.validator.constraints.UniqueElements;

@Entity
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String userName;
    private String email;

    public Author(Long id,String userName,String email){
        this.id=id;
        this.userName=userName;
        this.email=email;
    }
    public Author(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
