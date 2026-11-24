package mx.edu.utez.tiendaproductos.model;

import jakarta.persistence.*;

@Entity
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String comment;
    private int rate;
    private boolean isPublic;
    private String date;

    @ManyToOne
    @JoinColumn(name = "autorId")
    private Author autor;



    public Comment(Long id, String comment, int rate, boolean isPublic, String date,Author autor) {
        this.id = id;
        this.comment = comment;
        this.rate = rate;
        this.isPublic = isPublic;
        this.date = date;
        this.autor=autor;
    }
    public Comment() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    public boolean isPublic() {
        return isPublic;
    }

    public void setPublic(boolean aPublic) {
        isPublic = aPublic;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Author getAutor() {
        return autor;
    }

    public void setAutor(Author autor) {
        this.autor = autor;
    }
}
