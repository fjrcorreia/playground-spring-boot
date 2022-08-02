package pt.fjrcorreia.playground.spring.boot.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author Francisco Correia
 */
@Configuration
@EnableAutoConfiguration
@ComponentScan(basePackages = "pt.fjrcorreia.playground.spring.boot")
public class ControllerConfiguration {

    private static final Logger logger = LoggerFactory.getLogger(ControllerConfiguration.class);

    public ControllerConfiguration() {
        logger.info("Loading Controller Configuration");
    }
}
