package pt.fjrcorreia.playground.spring.boot.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * @author Francisco Correia
 */
@Configuration
@EnableJpaRepositories(basePackages = {"pt.fjrcorreia.playground.spring.boot.repository"})
@EntityScan(basePackages = {"pt.fjrcorreia.playground.spring.boot.model"})
public class RepositoryConfig {
}
