

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;

import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest(classes = {com.example.demo.CounterService.class})
@TestPropertySource(properties = {
        "counter.initial-value=10"
})
public class CounterServiceIntegrationTest {

    @Autowired
    private com.example.demo.CounterService counterService;

    @BeforeEach
    public void setUp() {
        counterService.reset(); // Ensure a known state before each test
    }

    @Test
    public void testInitialCount() {
        // Initial count should be 10 as set by the property
        assertEquals(10, counterService.getCount(), "Initial count should be 10.");
    }

    @Test
    @DirtiesContext // Mark the context as dirty after this test
    public void testIncrement() {
        counterService.increment();
        assertEquals(1, counterService.getCount(), "Count should be 1 after incrementing once.");
    }

    @Test
    @DirtiesContext // Mark the context as dirty after this test
    public void testMultipleIncrements() {
        counterService.increment();
        counterService.increment();
        counterService.increment();
        assertEquals(3, counterService.getCount(), "Count should be 3 after incrementing three times.");
    }

    @Test
    public void testReset() {
        counterService.increment();
        counterService.reset();
        assertEquals(0, counterService.getCount(), "Count should be reset to 0.");
    }
}