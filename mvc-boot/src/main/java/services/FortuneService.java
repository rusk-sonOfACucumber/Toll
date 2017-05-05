package services;

import org.springframework.stereotype.Service;

/**
 * Created by jdev on 05.05.2017.
 */
@Service
public class FortuneService {

    public double tryFortune() {
        return Math.random();
    }
}
