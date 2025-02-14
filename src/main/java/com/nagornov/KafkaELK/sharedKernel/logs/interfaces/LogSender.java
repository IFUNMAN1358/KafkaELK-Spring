package com.nagornov.KafkaELK.sharedKernel.logs.interfaces;

import com.nagornov.KafkaELK.sharedKernel.logs.model.Log;

public interface LogSender {

    void sendLog(Log log);

}