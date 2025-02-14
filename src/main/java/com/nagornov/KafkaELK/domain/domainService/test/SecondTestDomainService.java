package com.nagornov.KafkaELK.domain.domainService.test;

import com.nagornov.KafkaELK.domain.logger.DomainServiceLogger;
import com.nagornov.KafkaELK.infrastructure.persistence.test.SecondTestRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SecondTestDomainService {

    private final SecondTestRepository secondTestRepository;
    private final DomainServiceLogger domainServiceLogger;

    public String someMethod() {
        domainServiceLogger.info("domain2");
        String str = secondTestRepository.someMethod();
        throw new RuntimeException("gg");
        //return str;
    }

}