package pt.fjrcorreia.playground.spring.boot.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.AbstractHandlerExceptionResolver;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;
import org.springframework.web.servlet.mvc.support.DefaultHandlerExceptionResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Properties;

/**
 * @author Francisco Correia
 */

@Configuration
@EnableAutoConfiguration
@ComponentScan(basePackages = {"pt.fjrcorreia.playground.spring.boot"})
public class AppConfig {

    protected Logger logger;

    public AppConfig() {
        logger = LoggerFactory.getLogger(getClass());
        logger.info("Creating DemoExceptionConfiguration");
    }

    /*
    @Bean(name = "simpleMappingExceptionResolver")
    public SimpleMappingExceptionResolver createSimpleMappingExceptionResolver() {

    }
*/


    /*
    @Bean(name = "simpleMappingExceptionResolver")
    public SwitchableSimpleMappingExceptionResolver createSwitchableSimpleMappingExceptionResolver() {
        logger.info("Creating SwitchableSimpleMappingExceptionResolver in disabled mode");

        // Turn exception resolving off to start
        boolean initialState = true;

        SwitchableSimpleMappingExceptionResolver resolver = new SwitchableSimpleMappingExceptionResolver(
                initialState);

        Properties mappings = new Properties();
        //mappings.setProperty("DatabaseException", "databaseException");
        //mappings.setProperty("InvalidCreditCardException", "creditCardError");

        resolver.setExceptionMappings(mappings); // None by default
        resolver.setExceptionAttribute("ex"); // Default is "exception"
        resolver.setWarnLogCategory("demo1.ExceptionLogger"); // No default

        // See comment in ExceptionConfiguration
        resolver.setDefaultErrorView("defaultErrorPage");
        return resolver;
    }*/

    /*
     * Create the {@link SwitchController}.

    @Bean(name = "switchController")
    public SwitchController createSwitchController() {
        logger.info("Creating SwitchController");
        return new SwitchController(
                createSwitchableSimpleMappingExceptionResolver());
    }
     */


    private DefaultHandlerExceptionResolver ph;

    @Bean
    public HandlerExceptionResolver getHandlerExceptionResolver(){
        return new CustomHandlerExceptionResolver();
    }


    public class CustomHandlerExceptionResolver implements HandlerExceptionResolver, Ordered {

        WebRequest req;



        @Override
        public int getOrder() {
            return Ordered.HIGHEST_PRECEDENCE;
        }

        @Override
        public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
            logger.warn("Handling Error....... ("+ex.getClass().getSimpleName()+"): " + ex.getMessage() );
            return null;
        }
    }


    public class SwitchableSimpleMappingExceptionResolver extends SimpleMappingExceptionResolver {

        protected boolean enabled = false;

        public SwitchableSimpleMappingExceptionResolver(boolean enabled) {
            this.enabled = enabled;

            setOrder(LOWEST_PRECEDENCE - 1);

            logger.warn("Instantiating SwitchableSimpleMappingExceptionResolver");
        }

        /**
         * Enabled or not?
         *
         * @return Is enabled?
         */
        public boolean isEnabled() {
            return enabled;
        }

        /**
         * Allow this resolver to be turned on and off whilst the application is
         * running.
         *
         * @param enabled Set to enabled?
         */
        public void setEnabled(boolean enabled) {
            this.enabled = enabled;
        }

        /**
         * Resolver only handles exceptions if enabled. Overrides method inherited
         * from {@link AbstractHandlerExceptionResolver}
         */
        @Override
        protected boolean shouldApplyTo(HttpServletRequest request, Object handler) {
            logger.warn("shouldApplyTo -> " + handler.toString());
            return enabled && super.shouldApplyTo(request, handler);
        }
    }

}
