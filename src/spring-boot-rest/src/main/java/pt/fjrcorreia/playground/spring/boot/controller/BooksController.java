package pt.fjrcorreia.playground.spring.boot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import pt.fjrcorreia.playground.spring.boot.api.Author;
import pt.fjrcorreia.playground.spring.boot.api.Book;
import pt.fjrcorreia.playground.spring.boot.service.AuthorsService;
import pt.fjrcorreia.playground.spring.boot.service.BooksService;

import java.util.List;

/**
 * @author Francisco Correia
 */
@RestController
@RequestMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
public class BooksController {

    private final BooksService booksService;
    private final AuthorsService authorsService;


    @Autowired
    public BooksController(BooksService booksService, AuthorsService authorsService) {
        this.booksService = booksService;
        this.authorsService = authorsService;
    }

    @RequestMapping(method = RequestMethod.GET, value = "books")
    public ResponseEntity<List<Book>> listBooks() {
        List<Book> books = booksService.listBooks();
        return new ResponseEntity<>(books, HttpStatus.OK);
    }




    @RequestMapping(method = RequestMethod.GET, value = "authors")
    public ResponseEntity<List<Author>> listAuthors() {
        List<Author> authors = authorsService.listAuthors();
        return new ResponseEntity<>(authors, HttpStatus.OK);
    }


    @RequestMapping(method = RequestMethod.GET, value = "boom")
    public ResponseEntity<Object> stuff() {

        if (1==1){
            throw new RuntimeException("Sample Error");
        }
        return new ResponseEntity<>("No Response", HttpStatus.OK);
    }

}
