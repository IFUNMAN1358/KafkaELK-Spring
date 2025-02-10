package com.nagornov.KafkaELK.infrastructure.persistence.test;

import org.springframework.stereotype.Repository;

@Repository
public class SecondTestRepository {

    public String someMethod() {
        String str = "some string from SecondTestRepository.class";
        return str;
    }

}
