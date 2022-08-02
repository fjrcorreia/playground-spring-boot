package pt.fjrcorreia.playground.spring.boot.component;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.AbstractHandlerExceptionResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Francisco Correia
 */
@Component
public class RestResponseStatusExceptionResolver extends AbstractHandlerExceptionResolver {

    public RestResponseStatusExceptionResolver(){
        logger.warn("Instantiating RestResponseStatusExceptionResolver");
    }

    @Override
    protected ModelAndView doResolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {

        try {
            return handleIllegalArgument((IllegalArgumentException) ex, response, request);
        } catch (Exception handlerException) {
            logger.warn("Handling of [" + ex.getClass().getName() + "] resulted in Exception", handlerException);
        }
        return null;
    }



    private ModelAndView handleIllegalArgument
            (IllegalArgumentException ex, HttpServletResponse response, HttpServletRequest request) throws IOException {
        response.sendError(HttpServletResponse.SC_CONFLICT);
        String accept = request.getHeader(HttpHeaders.ACCEPT);
        ModelAndView view =  new ModelAndView();

        logger.warn("Using Custom handler");
        view.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);

        return view;
    }
}