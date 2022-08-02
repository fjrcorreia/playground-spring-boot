package pt.fjrcorreia.playground.spring.boot.model;


import javax.persistence.*;
import java.util.List;

/**
 * @author Francisco Correia
 */
@Entity
@Table(name = "books")
public class BookTbl {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String isbn;

    @Column
    private String title;

    @ManyToMany
    private List<AuthorTbl> authors;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<AuthorTbl> getAuthors() {
        return authors;
    }

    public void setAuthors(List<AuthorTbl> authors) {
        this.authors = authors;
    }
}
