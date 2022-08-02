package pt.fjrcorreia.playground.spring.boot.redis.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pt.fjrcorreia.playground.spring.boot.redis.model.Student;

import java.util.List;

@Repository
public interface StudentRepository extends CrudRepository<Student, String> {

    List<Student> findByName(String name);
}