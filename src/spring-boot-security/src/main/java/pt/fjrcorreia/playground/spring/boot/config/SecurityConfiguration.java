package pt.fjrcorreia.playground.spring.boot.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import org.springframework.security.oauth2.client.registration.ClientRegistrations;

/**
 * @author Francisco Correia
 */
@EnableGlobalMethodSecurity(securedEnabled = true)
@EnableWebSecurity
@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    private static final Logger logger = LoggerFactory.getLogger(SecurityConfiguration.class);



    @Override
    protected void configure(HttpSecurity http) throws Exception {

        logger.info("Configure Security HTTP");


        http
                .authorizeRequests()
                .anyRequest().authenticated()
                .and()
                .oauth2Login()
                .redirectionEndpoint()
                .baseUri("/custom-callback");

    }
}

