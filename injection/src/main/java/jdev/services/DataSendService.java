package jdev.services;

import org.springframework.stereotype.Service;

/**
 * Created by jdev on 26.03.2017.
 */
@Service
public class DataSendService {
    public void callFromInit() {
        System.out.println("DataSendService.callFromInit");
    }
}
