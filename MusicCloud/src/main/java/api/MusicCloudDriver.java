package api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

@EnableAutoConfiguration
@ComponentScan
public class MusicCloudDriver extends SpringBootServletInitializer {

    private static Class<MusicCloudDriver> appClass = MusicCloudDriver.class;
    private static Logger log =  LoggerFactory.getLogger(MusicCloudDriver.class);

    public static void main(String args[]){
        log.info("The MusicCloud driver started");
        SpringApplication.run(MusicCloudDriver.class,args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder applicationBuilder){
        return applicationBuilder.sources(appClass);
    }
}
