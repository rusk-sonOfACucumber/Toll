package jdev.services;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

/**
 * Created by jdev on 26.03.2017.
 */
@Service
public class ScheduledService {


    private int count;

    @Scheduled (cron = "*/4 * * * * *")
    private void tick() {
        System.out.println("ScheduledService.tick " + count++);
    }
}
