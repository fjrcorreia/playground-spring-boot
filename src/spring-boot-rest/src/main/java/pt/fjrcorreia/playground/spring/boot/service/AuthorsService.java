package pt.fjrcorreia.playground.spring.boot.service;

/**
 * @author Francisco Correia
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pt.fjrcorreia.playground.spring.boot.api.Author;
import pt.fjrcorreia.playground.spring.boot.repository.AuthorsRepository;
import pt.fjrcorreia.playground.spring.boot.utils.ModelUtils;

import java.util.ArrayList;
import java.util.List;

@Service
public class AuthorsService {


    private final AuthorsRepository authorsRepository;


    @Autowired
    public AuthorsService(AuthorsRepository authorsRepository) {
        this.authorsRepository = authorsRepository;
    }


    public List<Author> listAuthors() {
        List<Author> authors = new ArrayList<>();

        authorsRepository.findAll().forEach(authorTbl -> {
            authors.add(ModelUtils.toAuthor(authorTbl));
        });

        return authors;
    }
}
