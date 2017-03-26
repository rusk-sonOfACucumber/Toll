package jdev.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by jdev on 26.03.2017.
 */
@Service
public class DataPeekService {

    @Autowired
    private DataSendService dataSendService;
}
