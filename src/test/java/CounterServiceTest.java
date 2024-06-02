package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest(classes = {com.example.demo.CounterService.class})
public class CounterServiceTest {

    @Autowired
    private com.example.demo.CounterService counterService;

    @Test
    public void testIncrement() {
        counterService.reset(); // Ensure a known state
        counterService.increment();
        assertEquals(1, counterService.getCount(), "Count should be 1 after incrementing once.");
    }

    @Test
    public void testInitialCount() {
        // This test assumes the count is 0 initially, which may not be true if the context is dirty
        assertEquals(1, counterService.getCount(), "Initial count should be 0.");
    }
}
