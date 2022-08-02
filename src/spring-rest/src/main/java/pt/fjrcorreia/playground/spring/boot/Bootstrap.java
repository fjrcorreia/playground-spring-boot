package pt.fjrcorreia.playground.spring.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import pt.fjrcorreia.playground.spring.boot.config.AppConfig;

/**
 * @author Francisco Correia
 */

@SpringBootApplication
public class Bootstrap {
    public static void main(String[] args) {
        SpringApplication.run(AppConfig.class, args);
    }
}
