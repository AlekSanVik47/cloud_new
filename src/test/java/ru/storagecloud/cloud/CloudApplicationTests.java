package ru.storagecloud.cloud;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.assertTrue;
@ActiveProfiles("test")
@SpringBootTest
class CloudApplicationTests {

    @Test
    void contextLoads() {
        assertTrue(true, "Базовый тест загрузки контекста");
    }

}




