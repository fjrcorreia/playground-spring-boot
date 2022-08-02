package pt.fjrcorreia.playground.spring.boot.repository;

import org.springframework.data.repository.CrudRepository;
import pt.fjrcorreia.playground.spring.boot.model.BookTbl;

/**
 * @author Francisco Correia
 */
public interface BooksRepository extends CrudRepository<BookTbl, Long> {
}
