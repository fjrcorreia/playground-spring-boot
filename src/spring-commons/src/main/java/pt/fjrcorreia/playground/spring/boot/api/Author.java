package pt.fjrcorreia.playground.spring.boot.api;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * @author Francisco Correia
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Author {

    private String identifier;
    private String name;
    private String email;

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
