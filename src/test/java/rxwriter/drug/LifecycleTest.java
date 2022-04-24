package rxwriter.drug;

import org.junit.jupiter.api.*;

public class LifecycleTest {

    @BeforeAll
    static void beforeAll() {
        System.out.println("BeforeAll executed");
    }

    @BeforeEach
    void beforeEach() {
        System.out.println("BeforeEach executed");
    }

    @Test
    void testOne() {
        System.out.println("Test one executed");
    }

    @Test
    void testTwo() {
        System.out.println("Test two executed");
    }

    @AfterEach
    void afterEach() {
        System.out.println("AfterEach executed");
    }

    @AfterAll
    static void afterAll() {
        System.out.println("AfterAll executed");
    }

}
