package jdev;

import jdev.services.DataPeekService;
import jdev.services.DataSendService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by jdev on 26.03.2017.
 */
@Configuration
public class InjectionContext {

    @Bean
    public DataPeekService peekService() {
        return new DataPeekService();
    }

    @Bean
    public DataSendService sendService() {
        return new DataSendService();
    }
}
