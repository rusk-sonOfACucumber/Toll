package jdev;

import jdev.services.ScheduledService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by jdev on 26.03.2017.
 */
@Configuration
public class SchedulingContext {


    @Bean
    public ScheduledService sendService() {
        return new ScheduledService();
    }
}
