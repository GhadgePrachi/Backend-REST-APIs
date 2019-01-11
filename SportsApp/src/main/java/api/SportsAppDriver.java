package api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

@EnableAutoConfiguration
@ComponentScan

public class SportsAppDriver extends SpringBootServletInitializer {
    private static Class<SportsAppDriver> appClass = SportsAppDriver.class;
    private static Logger log = LoggerFactory.getLogger(SportsAppDriver.class);

    public static void main(String[] args){
        log.info("Starting SportsAppDriver");
        SpringApplication.run(SportsAppDriver.class,args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder applicationBuilder){
        return applicationBuilder.sources(appClass);
    }
}
