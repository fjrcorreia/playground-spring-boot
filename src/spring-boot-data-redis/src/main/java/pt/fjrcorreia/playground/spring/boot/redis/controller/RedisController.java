package pt.fjrcorreia.playground.spring.boot.redis.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import pt.fjrcorreia.playground.spring.boot.redis.model.Student;
import pt.fjrcorreia.playground.spring.boot.redis.repository.StudentRepository;

import jakarta.annotation.PostConstruct;

@RestController
@RequestMapping(value = "/students", produces = MediaType.APPLICATION_JSON_VALUE)
public class RedisController {

    private static final Logger logger = LoggerFactory.getLogger(RedisController.class);

    private final JedisConnectionFactory jedisConnectionFactory;
    private final StudentRepository studentRepository;

    @Autowired
    public RedisController(JedisConnectionFactory jedisConnectionFactory, StudentRepository studentRepository) {
        this.jedisConnectionFactory = jedisConnectionFactory;
        this.studentRepository = studentRepository;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Student getStudents(@PathVariable("id") String id) {
        return studentRepository.findById(id).orElseThrow(() -> new RuntimeException("Not Found"));
    }


    @RequestMapping(value = "", method = RequestMethod.GET)
    public Iterable<Student> listStudents(@RequestParam(name = "name", required = false) String nameFilter) {
        if (nameFilter != null && nameFilter.length() > 0) {
            return studentRepository.findByName(nameFilter);
        } else {
            return studentRepository.findAll();
        }
    }


    @RequestMapping(value = "", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Student putStudent(@RequestBody Student student) {
        if (student == null || student.getId() == null) {
            throw new RuntimeException("Invalid Request");
        }
        return studentRepository.save(student);
    }


    @PostConstruct
    public void initStudent() {
        Student engStudent = new Student(
                "Eng2015001", "John Doe", Student.Gender.MALE, 1);
        Student medStudent = new Student(
                "Med2015001", "Gareth Houston", Student.Gender.MALE, 2);
        studentRepository.save(engStudent);
        studentRepository.save(medStudent);
        logger.info("Repo: {}", studentRepository.getClass().getName());
        logger.info("Repo: {}", studentRepository.getClass().getSuperclass());
        logger.info("Repo: {}", studentRepository.getClass().getSuperclass().getClass().getSuperclass());

        RedisConnection rc = jedisConnectionFactory.getConnection();
        logger.info("Jedis Connection: {}", rc.getClass().getName());
        rc.hSet("Student:qs32456677890".getBytes(), "_class".getBytes(), "pt.fjrcorreia.playground.spring.boot.redis.model.Student".getBytes());
        rc.hSet("Student:qs32456677890".getBytes(), "id".getBytes(), "qs32456677890".getBytes());
        rc.hSet("Student:qs32456677890".getBytes(), "name".getBytes(), "John Doe".getBytes());
        rc.sAdd("Student".getBytes(), "qs32456677890".getBytes());

        org.springframework.data.redis.connection.jedis.JedisConnection tt;
        org.springframework.data.redis.core.RedisConnectionUtils rcu;
        JedisConnectionFactory jcf;
        org.springframework.data.redis.core.convert.MappingRedisConverter mp;
        org.springframework.data.util.ClassTypeInformation cti;
    }

}
