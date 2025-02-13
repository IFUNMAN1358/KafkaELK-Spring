package com.nagornov.KafkaELK.domain.core.interfaces;

import com.nagornov.KafkaELK.domain.model.Log;

public interface LogSender {

    void sendLog(Log log);

}