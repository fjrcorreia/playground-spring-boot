package pt.fjrcorreia.playground.spring.boot.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;

/**
 * @author Francisco Correia
 */
@Controller
@RequestMapping("/error")
public class ErrorController {


    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<String> handleError(HttpServletRequest request, Exception ex) {

        HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;

        HttpHeaders customHeaders = new HttpHeaders();
        customHeaders.add(HttpHeaders.CONTENT_TYPE, "application/custom+json;charset=UTF-8");

        String path = null;
        if (request != null) {
            Enumeration<String> headers = request.getHeaderNames();
            while (headers.hasMoreElements()) {
                String header = headers.nextElement();
                System.out.println("H(" + header + ")-> " + request.getHeader(header));
            }

            Enumeration<String> attributes = request.getAttributeNames();
            while (attributes.hasMoreElements()) {
                String attr = attributes.nextElement();
                Object value = request.getAttribute(attr);
                System.out.println("P(" + attr + ")[" + value.getClass().getSimpleName() + "]-> " + value);
            }

            status = HttpStatus.valueOf((Integer) request.getAttribute("javax.servlet.error.status_code"));
            path = request.getAttribute("javax.servlet.error.request_uri").toString();

        }


        String message = "Severe Mistake ("+path+"): " + (ex != null ? ex.getClass().getSimpleName() : "????");
        return new ResponseEntity<>(message, customHeaders, status);

    }



}
