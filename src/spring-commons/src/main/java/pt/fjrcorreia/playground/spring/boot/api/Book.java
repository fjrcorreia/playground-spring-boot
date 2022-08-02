package pt.fjrcorreia.playground.spring.boot.api;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

/**
 * @author Francisco Correia
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Book {

    private String isbn;
    private String title;
    private List<Author> authors;


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

    public List<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Author> authors) {
        this.authors = authors;
    }

}
