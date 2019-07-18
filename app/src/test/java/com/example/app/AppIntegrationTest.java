package com.example.app;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class AppIntegrationTest {

    @Test
    void contextLoads(@Autowired ApplicationContext context) {
        var app = context.getBean(App.class);
        assertNotNull(app.getGreeting());
    }

}
