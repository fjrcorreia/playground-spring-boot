package pt.fjrcorreia.playground.spring.boot;

import java.util.Date;

/**
 * @author Francisco Correia
 */
public class ExceptionResponse {

    private String version;
    private Date timestamp;
    private String message;
    private String details;

    public ExceptionResponse(Date timestamp, String message, String details) {
        super();
        this.version = "0.0.1-Version";
        this.timestamp = timestamp;
        this.message = message;
        this.details = details;
    }

    public String getVersion() {
        return version;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public String getMessage() {
        return message;
    }

    public String getDetails() {
        return details;
    }

}