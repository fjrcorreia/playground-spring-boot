package pt.fjrcorreia.playground.spring.boot.repository;


import org.springframework.data.repository.CrudRepository;
import pt.fjrcorreia.playground.spring.boot.model.AuthorTbl;

/**
 * @author Francisco Correia
 */
public interface AuthorsRepository extends CrudRepository<AuthorTbl, Long> {


}
