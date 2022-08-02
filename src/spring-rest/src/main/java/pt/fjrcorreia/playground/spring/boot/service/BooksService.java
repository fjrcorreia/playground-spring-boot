package pt.fjrcorreia.playground.spring.boot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pt.fjrcorreia.playground.spring.boot.api.Book;
import pt.fjrcorreia.playground.spring.boot.repository.BooksRepository;
import pt.fjrcorreia.playground.spring.boot.utils.ModelUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Francisco Correia
 */
@Service
public class BooksService {

    private final BooksRepository booksRepository;


    @Autowired
    public BooksService(BooksRepository booksRepository) {
        this.booksRepository = booksRepository;
    }


    public List<Book> listBooks() {
        List<Book> books = new ArrayList<>();
        booksRepository.findAll().forEach(bookTbl -> {
            books.add(ModelUtils.toBook(bookTbl));
        });

        return books;
    }


}
