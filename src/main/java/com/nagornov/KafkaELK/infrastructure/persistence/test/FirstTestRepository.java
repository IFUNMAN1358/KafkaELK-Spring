package com.nagornov.KafkaELK.infrastructure.persistence.test;

import org.springframework.stereotype.Repository;

@Repository
public class FirstTestRepository {

    public String someMethod() {
        String str = "some string from FirstTestRepository.class";
        return str;
    }

}