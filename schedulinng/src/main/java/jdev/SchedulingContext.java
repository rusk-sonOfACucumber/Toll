package jdev;

import jdev.services.ScheduledService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * Created by jdev on 26.03.2017.
 */
@Configuration
@EnableScheduling
public class SchedulingContext {

    @Bean
    public ScheduledService schedService() {
        return new ScheduledService();
    }
}
