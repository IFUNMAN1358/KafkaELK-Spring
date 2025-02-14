package com.nagornov.KafkaELK.application.applicationService;

import com.nagornov.KafkaELK.domain.domainService.test.FirstTestDomainService;
import com.nagornov.KafkaELK.domain.domainService.test.SecondTestDomainService;
import com.nagornov.KafkaELK.domain.logger.ApplicationServiceLogger;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TestApplicationService {

    private final FirstTestDomainService firstTestDomainService;
    private final SecondTestDomainService secondTestDomainService;
    private final ApplicationServiceLogger applicationServiceLoggerService;

    public String someMethod() {

        applicationServiceLoggerService.info("some message");

        String str1 = firstTestDomainService.someMethod();
        String str2 = secondTestDomainService.someMethod();

        return str1 + " " + str2;
    }

}
