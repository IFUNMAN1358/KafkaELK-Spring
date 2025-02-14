package com.nagornov.KafkaELK.domain.domainService.test;

import com.nagornov.KafkaELK.domain.logger.DomainServiceLogger;
import com.nagornov.KafkaELK.infrastructure.persistence.test.FirstTestRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FirstTestDomainService {

    private final FirstTestRepository firstTestRepository;
    private final DomainServiceLogger domainServiceLogger;

    public String someMethod() {
        domainServiceLogger.info("domain1");
        String str = firstTestRepository.someMethod();
        return str;
    }

}
