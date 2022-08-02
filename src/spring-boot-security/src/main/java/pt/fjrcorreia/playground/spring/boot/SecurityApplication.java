package pt.fjrcorreia.playground.spring.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import pt.fjrcorreia.playground.spring.boot.config.ControllerConfiguration;

@SpringBootApplication
public class SecurityApplication {

	public static void main(String[] args) {
		SpringApplication.run(ControllerConfiguration.class, args);
	}

}
