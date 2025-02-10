package com.nagornov.KafkaELK.domain.service.test;

import com.nagornov.KafkaELK.infrastructure.persistence.test.FirstTestRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FirstTestDomainService {

    private final FirstTestRepository firstTestRepository;

    public String someMethod() {
        String str = firstTestRepository.someMethod();
        return str;
    }

}
