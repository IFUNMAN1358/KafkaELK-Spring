plugins {
    id("java")
    id("org.springframework.boot") version "3.3.1"
    id("io.spring.dependency-management") version "1.1.5"
}

group = "com.nagornov.KafkaELK"
version = "1.0-SNAPSHOT"

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(22)
    }
}

repositories {
    mavenCentral()
}

dependencies {
    // GENERAL
    implementation("org.springframework.boot:spring-boot-starter")
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-starter-actuator")
    // SECURITY
    implementation("org.springframework.boot:spring-boot-starter-security")
    implementation("org.springframework.security:spring-security-crypto")
    testImplementation("org.springframework.security:spring-security-test")
    // JWT
    implementation("io.jsonwebtoken:jjwt-api:0.11.5")
    runtimeOnly("io.jsonwebtoken:jjwt-impl:0.11.5")
    runtimeOnly("io.jsonwebtoken:jjwt-jackson:0.11.5")
    // JACKSON
    implementation("com.fasterxml.jackson.datatype:jackson-datatype-jsr310")
    // KAFKA
    implementation("org.springframework.kafka:spring-kafka")
    // ELK
    implementation("org.springframework.boot:spring-boot-starter-data-elasticsearch")
    // ENV
    implementation("io.github.cdimascio:dotenv-java:3.0.0")
    // VALIDATION
    implementation("org.springframework.boot:spring-boot-starter-validation")
    // JAKARTA
    implementation("jakarta.annotation:jakarta.annotation-api:3.0.0")
    // LOMBOK
    compileOnly("org.projectlombok:lombok:1.18.34")
    annotationProcessor("org.projectlombok:lombok:1.18.34")
    testCompileOnly("org.projectlombok:lombok:1.18.34")
    testAnnotationProcessor("org.projectlombok:lombok:1.18.34")
    // MAPSTRUCT
    implementation("org.mapstruct:mapstruct:1.5.5.Final")
    annotationProcessor("org.mapstruct:mapstruct-processor:1.5.5.Final")
    // TEST
    implementation("org.springframework.boot:spring-boot-starter-test")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

tasks.bootJar {
    enabled = true
}

tasks.test {
    useJUnitPlatform()
}