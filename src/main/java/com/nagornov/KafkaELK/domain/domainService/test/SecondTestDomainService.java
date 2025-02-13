package com.nagornov.KafkaELK.domain.domainService.test;

import com.nagornov.KafkaELK.infrastructure.persistence.test.SecondTestRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SecondTestDomainService {

    private final SecondTestRepository secondTestRepository;

    public String someMethod() {
        String str = secondTestRepository.someMethod();
        return str;
    }

}